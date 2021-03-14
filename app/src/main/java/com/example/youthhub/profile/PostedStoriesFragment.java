package com.example.youthhub.profile;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.dashboard.DashBoardPostListAdapter;
import com.example.youthhub.dashBoard.dashboard.PostShareDialog;
import com.example.youthhub.dashBoard.dashboard.ProfileReportEditDialog;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.post.likepost.LikeResponse;
import com.example.youthhub.resModel.post.postList.PostList;
import com.example.youthhub.resModel.profile.ProfileInfo;
import com.example.youthhub.resModel.profilepostlist.ConnectionListItem;
import com.example.youthhub.resModel.profilepostlist.EventListItem;
import com.example.youthhub.resModel.profilepostlist.JobsListItem;
import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;
import com.example.youthhub.resModel.profilepostlist.PostListItem;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.makeramen.roundedimageview.RoundedImageView.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PostedStoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostedStoriesFragment extends Fragment implements DashBoardPostListAdapter.OnPassValuesListener,
        ProfileReportEditDialog.OnPassValueListener,
        PostShareDialog.OnPassShareData{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.add_step_btn)
    Button addStepBtn;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.no_list)
    LinearLayout noList;
    @BindView(R.id.nested_scroll)
    NestedScrollView nestedScroll;

    private OnFragmentInteractionListener mListener;

    Activity activity;

    ProfileInfo profileInfo;
    String UserCode;

    boolean continueToLoad = true;

    Integer page_no = null;

    List<PostListItem> postLists = new ArrayList<>();
    private List<EventListItem> eventList = new ArrayList<>();
    private List<JobsListItem> jobsList = new ArrayList<>();
    private List<ConnectionListItem> connectionList = new ArrayList<>();
    Map<String, String> imagePath;
    DashBoardPostListAdapter dashBoardPostListAdapter;

    int selectedPosition = -1;

    public PostedStoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostedStoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PostedStoriesFragment newInstance(String param1, String param2) {
        PostedStoriesFragment fragment = new PostedStoriesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static PostedStoriesFragment newInstance(ProfileInfo profileInfo) {
        PostedStoriesFragment fragment = new PostedStoriesFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.ProfileInfo, profileInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            profileInfo = getArguments().getParcelable(Constants.ProfileInfo);
            if (profileInfo != null) {
                UserCode = profileInfo.getUmCode();
            }
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posted_stories, container, false);
        unbinder = ButterKnife.bind(this, view);
        call_adapter_before_api();
        call_profiler_post_list_api();
        //call_adapter();

        return view;
    }

    private void call_adapter_before_api() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);
        dashBoardPostListAdapter = new DashBoardPostListAdapter(activity);
        dashBoardPostListAdapter.setOnPassValuesListener(this);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(dashBoardPostListAdapter);

        nestedScroll.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (nestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1) != null) {
                if ((scrollY >= (nestedScrollView.getChildAt(nestedScrollView.getChildCount() - 1).getMeasuredHeight() - nestedScrollView.getMeasuredHeight())) &&
                        scrollY > oldScrollY) {
                    if (continueToLoad) {
                        onLoadMore();
                    }
                }
            }
        });
    }

    private void call_profiler_post_list_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            continueToLoad = false;
            final String pageNo;
            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }

            Call<PostDashboardListResponse> call = ApiClient.getApiInterface().getPostList(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pageNo,
                    UserCode,
                    "",
                    "");

            call.enqueue(new Callback<PostDashboardListResponse>() {
                @Override
                public void onResponse(@NonNull Call<PostDashboardListResponse> call, @NonNull Response<PostDashboardListResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                if (noList != null) {
                                    noList.setVisibility(View.GONE);
                                }
                                update_adapter(response.body(), pageNo);
                            } else {
                                no_list(response.body());
                                Loader.showLoad(activity, false);
                                continueToLoad = true;
                            }
                        } else {
                            Loader.showLoad(activity, false);
                            continueToLoad = true;
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostList", response.toString());
                        Loader.showLoad(activity, false);
                        continueToLoad = true;
                    }
                }

                @Override
                public void onFailure(@NonNull Call<PostDashboardListResponse> call, @NonNull Throwable t) {
                    call_profiler_post_list_api();
                    Log.d(Constants.failureResponse + " PostList", t.toString());
                    Loader.showLoad(activity, false);
                    continueToLoad = true;
                }
            });

        }
    }

    private void update_adapter(PostDashboardListResponse body, String pageNo) {
        if (pageNo.isEmpty()) {
            postLists = body.getData().getPostList();
        } else {
            postLists.addAll(body.getData().getPostList());
        }

        imagePath = new HashMap<>();
        imagePath.put("path_source", body.getData().getPathSource());
        imagePath.put("path_large", body.getData().getPathLarge());
        imagePath.put("path_medium", body.getData().getPathMedium());
        imagePath.put("path_thumb", body.getData().getPathThumb());
        imagePath.put("vid_path", body.getData().getVidPath());
        imagePath.put("vid_poster_path", body.getData().getVidPosterPath());
        imagePath.put("profile_medium_path", body.getData().getProfileMediumPath());
        imagePath.put("profile_thumbnail_path", body.getData().getProfileThumbnailPath());
        imagePath.put("event_logo_path", body.getData().getEventLogoPath());

        dashBoardPostListAdapter.addAll(postLists, eventList, jobsList, connectionList, imagePath);
        page_no = body.getNextpage();
        Loader.showLoad(activity, false);
        continueToLoad = true;
    }

    private void no_list(PostDashboardListResponse body) {
        if (!body.getMessage().isEmpty()) {
            noList.setVisibility(View.VISIBLE);

            postLists.clear();
            imagePath = new HashMap<>();
            dashBoardPostListAdapter.addAll(postLists, eventList, jobsList, connectionList, imagePath);

            try {
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, body.getStatus_img()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(noListImg);
            }catch (Exception e){
                Log.d(Constants.GlideException,e.toString());
            }

            noListTxt.setText(body.getMessage());
            //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
        } else {
            noList.setVisibility(View.GONE);
        }
        page_no = null;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void onLoadMore() {
        if (page_no != null) {
            call_profiler_post_list_api();
        }
    }

    @Override
    public void onPassData(PostListItem postList, int selectedPosition) {
        this.selectedPosition = selectedPosition;
        if (postList.getUmCode().equals(Constants.getUserCode(activity)) && postList.getShareUserCount() <= 0) {
            ProfileReportEditDialog editDeleteDialog = new ProfileReportEditDialog(activity, postList.getPmCode(), postList.getPmDescription(), "EditDelete");
            editDeleteDialog.setOnPassValueListener(this);
            editDeleteDialog.show();
        } else {
            ProfileReportEditDialog reportDialog = new ProfileReportEditDialog(activity, postList.getPmCode(), postList.getPmDescription(), "Report");
            reportDialog.setOnPassValueListener(this);
            reportDialog.show();
        }
    }

    @Override
    public void onPassPostLikeData(PostListItem likePostList, int likePosition) {
        call_post_encourage_api(likePostList, likePosition);
    }



    @Override
    public void onPassPinData(PostList pinPostList, int pinPosition) {
        call_post_favourite_api(pinPostList, pinPosition);
    }

    @Override
    public void onPassShareData(PostList sharePostList, int selectedPosition) {
        this.selectedPosition = selectedPosition;
        PostShareDialog postShareDialog = new PostShareDialog(activity, sharePostList.getPmCode());
        postShareDialog.setOnPassShareData(this);
        postShareDialog.show();
    }

    @Override
    public void onPassShareData(PostDashboardListResponse postListResponse) {
        if (selectedPosition >= 0) {
            postLists.remove(selectedPosition);
            postLists.add(0, postListResponse.getData().getPostList().get(0));
            dashBoardPostListAdapter.notifyDataSetChanged();
            selectedPosition = -1;
            nestedScroll.smoothScrollTo(0, 0);
        }
    }

    @Override
    public void onPassDescData(String description) {
        if (selectedPosition >= 0) {
            PostListItem postList = postLists.get(selectedPosition);
            postList.setPmDescription(description);
            postLists.remove(selectedPosition);
            postLists.add(selectedPosition, postList);
            dashBoardPostListAdapter.notifyDataSetChanged();
            selectedPosition = -1;
        }
    }

    @Override
    public void onPassDeleteData(boolean deleted) {
        if (deleted) {
            page_no = null;
            call_profiler_post_list_api();
        }
    }

    @Override
    public void onPassReportData(boolean deleted) {

    }

    private void call_post_encourage_api(PostListItem likePostList, int likePosition) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            String status;
            if (likePostList.getEncourageStatus() == 1) {
                status = "0";
            } else {
                status = "1";
            }
            Loader.showLoad(activity, true);
            Log.d(TAG, "call_post_encourage_api:getApiKey "+Constants.getApiKey(activity));
            Log.d(TAG, "call_post_encourage_api:getAccessKey "+Constants.getAccessKey(activity));
            Log.d(TAG, "call_post_encourage_api:getToken "+Constants.getToken(activity));
            Call<LikeResponse> call = ApiClient.getApiInterface().getPostEncourage(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    likePostList.getPmCode(),
                    status);

            String finalStatus = status;
            call.enqueue(new Callback<LikeResponse>() {
                @Override
                public void onResponse(@NonNull Call<LikeResponse> call, @NonNull Response<LikeResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                PostListItem postList = postLists.get(likePosition);
                                postList.setEncourageStatus(Integer.valueOf(finalStatus));
                                int likeCount;
                                if (finalStatus.equals("0")) {
                                    likeCount = Integer.valueOf(postList.getPmTotalLike()) - 1;
                                } else {
                                    likeCount = Integer.valueOf(postList.getPmTotalLike()) + 1;
                                }
                                postList.setPmTotalLike(String.valueOf(likeCount));
                                postLists.set(likePosition, postList);
                                dashBoardPostListAdapter.notifyDataSetChanged();
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostLike", response.toString());
                    }
                 //   Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<LikeResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " PostLike", t.toString());
                    Loader.showLoad(activity, false);

                }
            });
        }
    }

    private void call_post_favourite_api(PostList pinPostList, int pinPosition) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            String status;
            if (pinPostList.getFavoriteStatus() == 1) {
                status = "0";
            } else {
                status = "1";
            }
            Loader.showLoad(activity, true);
            Call<CommonRes> call = ApiClient.getApiInterface().getPostFavourite(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pinPostList.getPmCode(),
                    status);

            String finalStatus = status;
            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                PostListItem postList = postLists.get(pinPosition);
                                postList.setFavoriteStatus(Integer.valueOf(finalStatus));
                                postLists.set(pinPosition, postList);
                                dashBoardPostListAdapter.notifyDataSetChanged();
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostLike", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " PostLike", t.toString());
                    Loader.showLoad(activity, false);

                }
            });
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
