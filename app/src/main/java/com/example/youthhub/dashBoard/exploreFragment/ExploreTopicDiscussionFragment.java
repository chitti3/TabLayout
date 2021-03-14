package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.content.Context;
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
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.exploreDiscussion.ExploreDiscussion;
import com.example.youthhub.resModel.explore.exploreDiscussion.ExploreDiscussionAdd;
import com.example.youthhub.resModel.explore.exploreDiscussion.ExploreDiscussionList;
import com.example.youthhub.retrofit.ApiClient;
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
 * Use the {@link ExploreTopicDiscussionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreTopicDiscussionFragment extends Fragment implements ExploreDiscussionAdapter.OnLoadMoreListener, ExploreDiscussionAdapter.OnPassDataListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EXPLORECODE = "exploreCode";
    private static final String TOPICID = "topicId";
    @BindView(R.id.discussion_recycler)
    RecyclerView discussionRecycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
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
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String exploreCode;
    private String topicId;

    Integer page_no = null;

    Activity activity;
    ExploreDiscussionAdapter exploreDiscussionAdapter;

    private OnFragmentInteractionListener mListener;

    List<ExploreDiscussion> exploreDiscussion = new ArrayList<>();

    public ExploreTopicDiscussionFragment() {
        // Required empty public constructor
    }

    public static ExploreTopicDiscussionFragment newInstance(String exploreCode, String topicId) {
        ExploreTopicDiscussionFragment fragment = new ExploreTopicDiscussionFragment();
        Bundle args = new Bundle();
        args.putString(EXPLORECODE, exploreCode);
        args.putString(TOPICID, topicId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            exploreCode = getArguments().getString(EXPLORECODE);
            topicId = getArguments().getString(TOPICID);
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore_topic_discussion, container, false);
        unbinder = ButterKnife.bind(this, view);
        call_adapter_before_api();
        call_api();
        return view;
    }

    private void call_adapter_before_api() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setStackFromEnd(true);
        discussionRecycler.setLayoutManager(linearLayoutManager);
        exploreDiscussionAdapter = new ExploreDiscussionAdapter(activity, discussionRecycler);
        exploreDiscussionAdapter.setOnLoadMoreListener(this);
        exploreDiscussionAdapter.setOnPassDataListener(this);
        discussionRecycler.setAdapter(exploreDiscussionAdapter);
    }

    private void call_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            final String pageNo;
            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }
            Call<ExploreDiscussionList> call = ApiClient.getApiInterface().getExploreDiscussionList(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), exploreCode, topicId, pageNo);
            call.enqueue(new Callback<ExploreDiscussionList>() {
                @Override
                public void onResponse(@NonNull Call<ExploreDiscussionList> call, @NonNull Response<ExploreDiscussionList> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                updateUi(response.body(), pageNo);
                            } else {
                                no_list(response.body());
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ExploreDiscuss", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ExploreDiscussionList> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ExploreDiscuss", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateUi(ExploreDiscussionList body, String pageNo) {

        final Map<String, String> imagePath = new HashMap<>();
        imagePath.put("user_medium_path", body.getExploreDiscussionData().getUserMediumPath());
        imagePath.put("user_thumbnail_path", body.getExploreDiscussionData().getUserThumbnailPath());

        if (pageNo.isEmpty()) {
            exploreDiscussion = body.getExploreDiscussionData().getExploreDiscussions();
        } else {
            exploreDiscussion.addAll(body.getExploreDiscussionData().getExploreDiscussions());
        }
        exploreDiscussionAdapter.addAll(exploreDiscussion, imagePath, exploreCode, topicId);
        exploreDiscussionAdapter.setLoaded();
        page_no = body.getNextpage();
    }

    private void no_list(ExploreDiscussionList body) {
        if (!body.getMessage().isEmpty()) {
            noListImg.setVisibility(View.VISIBLE);
            noListTxt.setVisibility(View.VISIBLE);

            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity,body.getStatusImg()))
                    .apply(options)
                    .into(noListImg);

            noListTxt.setText(body.getMessage());
            //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
        } else {
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
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

    private void call_msg_send_api(String message) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ExploreDiscussionAdd> call = ApiClient.getApiInterface().getExploreDiscussionAdd(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), exploreCode, topicId, message);
            call.enqueue(new Callback<ExploreDiscussionAdd>() {
                @Override
                public void onResponse(@NonNull Call<ExploreDiscussionAdd> call, @NonNull Response<ExploreDiscussionAdd> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                commentEdittext.setText("");
                                update_msg_Ui(response.body());
                            } else {
                                if (!response.body().getMessage().isEmpty()) {
                                    MyToast.normalMessage(response.body().getMessage(), activity);
                                }
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ExploreDiscuss", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ExploreDiscussionAdd> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ExploreDiscuss", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void update_msg_Ui(ExploreDiscussionAdd body) {

        final Map<String, String> imagePath = new HashMap<>();
        imagePath.put("user_medium_path", body.getExploreAddData().getUserMediumPath());
        imagePath.put("user_thumbnail_path", body.getExploreAddData().getUserThumbnailPath());
        exploreDiscussion.add(body.getExploreAddData().getExploreDiscussions());
        exploreDiscussionAdapter.addAll(exploreDiscussion, imagePath, exploreCode, topicId);
        exploreDiscussionAdapter.setLoaded();
        discussionRecycler.smoothScrollToPosition(Objects.requireNonNull(discussionRecycler.getAdapter()).getItemCount() - 1);
    }

    @Override
    public void onLoadMore() {
        if (page_no != null) {
            call_api();
        }
    }

    @Override
    public void passData(boolean deleted, int deletePosition) {
        if (deleted) {
            exploreDiscussion.remove(deletePosition);
            exploreDiscussionAdapter.notifyDataSetChanged();
            if(exploreDiscussion.size()<=0){
                noListImg.setVisibility(View.VISIBLE);
                noListTxt.setVisibility(View.VISIBLE);
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
