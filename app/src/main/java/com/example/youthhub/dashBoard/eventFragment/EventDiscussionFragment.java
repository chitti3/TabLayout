package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.event.discussion.Discussion;
import com.example.youthhub.resModel.event.discussion.DiscussionAdd;
import com.example.youthhub.resModel.event.discussion.DiscussionAddData;
import com.example.youthhub.resModel.event.discussion.DiscussionData;
import com.example.youthhub.resModel.event.discussion.DiscussionListResponse;
import com.example.youthhub.resModel.event.eventView.EventViewData;
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
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventDiscussionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventDiscussionFragment extends Fragment implements DiscussionAdapter.OnLoadMoreListener, DiscussionAdapter.OnPassDataListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Unbinder unbinder;
    @BindView(R.id.discussion_recycler)
    RecyclerView discussionRecycler;
    @BindView(R.id.comment_view2)
    View commentView2;
    @BindView(R.id.comment_edittext)
    EditText commentEdittext;
    @BindView(R.id.comment_view4)
    View commentView4;
    @BindView(R.id.cmt_post_btn)
    ImageView cmtPostBtn;
    @BindView(R.id.bottom_constrain)
    ConstraintLayout bottomConstrain;
    @BindView(R.id.nested_scroll)
    ConstraintLayout nestedScroll;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;

    private OnFragmentInteractionListener mListener;
    Activity activity;

    EventViewData eventViewData;

    Integer page_no = null;

    DiscussionListResponse discussionListResponse;
    DiscussionData discussionData;
    List<Discussion> discussions = new ArrayList<>();
    DiscussionAdapter discussionAdapter;

    DiscussionAdd discussionAdd;
    DiscussionAddData discussionAddData;

    String eventCode;

    public EventDiscussionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventDiscussionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventDiscussionFragment newInstance(String param1, String param2) {
        EventDiscussionFragment fragment = new EventDiscussionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static EventDiscussionFragment newInstance(EventViewData eventViewData) {
        EventDiscussionFragment fragment = new EventDiscussionFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.EventViewData, eventViewData);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventViewData = getArguments().getParcelable(Constants.EventViewData);
            if (eventViewData != null) {
                eventCode = eventViewData.getEventView().getEventCode();
            }
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_discussion, container, false);
        unbinder = ButterKnife.bind(this, view);
        call_adapter_before_api();
        call_api();
        return view;
    }

    private void call_adapter_before_api() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setStackFromEnd(true);
        discussionRecycler.setLayoutManager(linearLayoutManager);
        discussionAdapter = new DiscussionAdapter(activity, discussionRecycler);
        discussionAdapter.setOnLoadMoreListener(this);
        discussionAdapter.setOnPassDataListener(this);
        discussionRecycler.setAdapter(discussionAdapter);
    }

    private void call_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            String pageNo;
            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }
            Call<DiscussionListResponse> responseCall = ApiClient.getApiInterface().getDiscussionList(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), eventCode, pageNo);
            responseCall.enqueue(new Callback<DiscussionListResponse>() {
                @Override
                public void onResponse(@NonNull Call<DiscussionListResponse> call, @NonNull Response<DiscussionListResponse> response) {
                    if (response.isSuccessful()) {
                        discussionListResponse = response.body();
                        if (discussionListResponse != null) {
                            if (discussionListResponse.getStatus() == 1) {
                                if (noListImg != null && noListTxt != null) {
                                    noListImg.setVisibility(View.GONE);
                                    noListTxt.setVisibility(View.GONE);
                                }
                                discussionData = discussionListResponse.getDiscussionData();
                                discussions.addAll(discussionData.getDiscussions());
                                if (page_no == null) {
                                    //call_adapter(discussionListResponse, discussions);
                                    update_ui(discussionListResponse, discussions);
                                } else {
                                    update_ui(discussionListResponse, discussions);
                                    //discussionAdapter.addAll(discussions);
                                    discussionAdapter.setLoaded();
                                }
                                page_no = discussionListResponse.getNextpage();
                            } else {
                                if (!discussionListResponse.getMessage().isEmpty()) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.VISIBLE);
                                        noListTxt.setVisibility(View.VISIBLE);
                                    }

                                    Glide.with(activity)
                                            .load(Constants.getLoadGlide(activity, discussionListResponse.getStatus_img()))
                                            .apply(AppUtils.getRequestOptionWithoutOverride())
                                            .into(noListImg);

                                    noListTxt.setText(discussionListResponse.getMessage());
                                    //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
                                } else {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                }
                                page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " DiscussionList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<DiscussionListResponse> call, @NonNull Throwable
                        t) {
                    Log.d(Constants.failureResponse + " DiscussionList", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void update_ui(DiscussionListResponse discussionListResponse, List<Discussion> discussions) {
        final Map<String, String> imagePath = new HashMap<>();
        imagePath.put("user_medium_path", discussionListResponse.getDiscussionData().getUserMediumPath());
        imagePath.put("user_thumbnail_path", discussionListResponse.getDiscussionData().getUserThumbnailPath());
        discussionAdapter.addAll(discussions, imagePath, eventCode);
    }

    private void loadMore() {
        if (page_no != null) {
            call_api();
        }
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

    @Override
    public void onLoadMore() {
        loadMore();
    }

    @OnClick(R.id.cmt_post_btn)
    public void onViewClicked() {
        validate();
    }

    private void validate() {
        if (commentEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Message Field should not be empty", activity);
        } else {
            call_msg_send_api(commentEdittext.getText().toString());
        }
    }

    private void call_msg_send_api(String msg) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<DiscussionAdd> discussionAddCall = ApiClient.getApiInterface().getDiscussion(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), eventCode, msg);
            discussionAddCall.enqueue(new Callback<DiscussionAdd>() {
                @Override
                public void onResponse(@NonNull Call<DiscussionAdd> call, @NonNull Response<DiscussionAdd> response) {
                    if (response.isSuccessful()) {
                        discussionAdd = response.body();
                        if (discussionAdd != null) {
                            if (discussionAdd.getStatus() == 1) {
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                commentEdittext.setText("");
                                discussionAddData = discussionAdd.getDiscussionAddData();
                                discussions.add(discussionAddData.getDiscussions());
                                if (page_no == null) {
                                    //call_adapter(discussionAdd, discussions);
                                    update_add_msg(discussionAdd, discussions);
                                } else {
                                    update_add_msg(discussionAdd, discussions);
                                    //discussionAdapter.addAll(discussions);
                                }
                                //age_no = discussionAdd.getNextpage();
                            } else {
                                if (!discussionAdd.getMessage().isEmpty()) {
                                    MyToast.normalMessage(discussionAdd.getMessage(), activity);
                                }
                                //page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " DiscussionAdd", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<DiscussionAdd> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " DiscussionAdd", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void update_add_msg(DiscussionAdd discussionAdd, List<Discussion> discussions) {
        final Map<String, String> imagePath = new HashMap<>();
        imagePath.put("user_medium_path", discussionAdd.getDiscussionAddData().getUserMediumPath());
        imagePath.put("user_thumbnail_path", discussionAdd.getDiscussionAddData().getUserThumbnailPath());
        discussionAdapter.addAll(discussions, imagePath, eventCode);
        discussionAdapter.setLoaded();
        //discussionRecycler.scrollToPosition(discussions.size()-1);
        discussionRecycler.smoothScrollToPosition(Objects.requireNonNull(discussionRecycler.getAdapter()).getItemCount() - 1);
    }

    @Override
    public void passData(boolean deleted, int deletePosition) {
        if (deleted) {
            discussions.remove(deletePosition);
            discussionAdapter.notifyDataSetChanged();
            if (discussions.size() <= 0) {
                if (noListImg != null && noListTxt != null) {
                    noListImg.setVisibility(View.VISIBLE);
                    noListTxt.setVisibility(View.VISIBLE);
                }
            }
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
