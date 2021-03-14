package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.post.CommentList;
import com.example.youthhub.resModel.post.CommentListResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity implements CommentAdapter.OnPassDataListener {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.like_icon)
    ImageView likeIcon;
    @BindView(R.id.liker_img1)
    CircleImageView likerImg1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.liker_img2)
    CircleImageView likerImg2;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.like_count)
    TextView likeCount;
    @BindView(R.id.like_layout)
    ConstraintLayout likeLayout;
    @BindView(R.id.cmt_count)
    TextView cmtCount;
    @BindView(R.id.three_dot)
    ImageView threeDot;
    @BindView(R.id.comment_view1)
    View commentView1;
    @BindView(R.id.top_constrain)
    ConstraintLayout topConstrain;
    @BindView(R.id.comment_recycler)
    RecyclerView commentRecycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.comment_view2)
    View commentView2;
    @BindView(R.id.camera)
    ImageView camera;
    @BindView(R.id.comment_view3)
    View commentView3;
    @BindView(R.id.cmt)
    EditText cmt;
    @BindView(R.id.comment_view4)
    View commentView4;
    @BindView(R.id.cmt_post_btn)
    ImageView cmtPostBtn;
    @BindView(R.id.bottom_constrain)
    ConstraintLayout bottomConstrain;

    CommentAdapter commentAdapter;

    CommentListResponse commentListResponse;

    Activity activity;

    String PostCode = null;
    String LikeCount = null;
    List<CommentList> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);
        activity = this;
        call_adapter();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            PostCode = bundle.getString(Constants.PostCode);
            LikeCount = bundle.getString(Constants.LikeCount);
            cmtCount.setText(LikeCount);
            call_comment_list_api(PostCode);
        }
    }

    private void call_adapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        commentRecycler.setLayoutManager(linearLayoutManager);
        commentAdapter = new CommentAdapter(this);
        commentRecycler.setAdapter(commentAdapter);
        commentAdapter.setOnPassDataListener(this);
    }

    @OnClick({R.id.back, R.id.three_dot, R.id.camera, R.id.cmt_post_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.three_dot:
                break;
            case R.id.camera:
                break;
            case R.id.cmt_post_btn:
                validate();
                break;
        }
    }

    private void validate() {
        if (cmt.getText().toString().isEmpty()) {
            MyToast.errorMessage("Comment Field Mandatory", this);
        } else {
            call_comment_add_api();
        }
    }

    private void call_comment_add_api() {
        if (PostCode != null) {
            if (NetWorkUtil.isNetworkConnected(activity)) {
                Loader.showLoad(activity, true);
                Call<CommentListResponse> call = ApiClient.getApiInterface().getCommentAdd(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                        Constants.getToken(activity),
                        PostCode, cmt.getText().toString());

                call.enqueue(new Callback<CommentListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CommentListResponse> call, @NonNull Response<CommentListResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                cmt.setText("");
                                call_comment_list_api(PostCode);
                            }
                        } else {
                            Log.d(Constants.failureResponse + " CommentList", response.toString());
                        }
                        Loader.showLoad(activity, false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<CommentListResponse> call, @NonNull Throwable t) {
                        Log.d(Constants.failureResponse + " CommentList", t.toString());
                        Loader.showLoad(activity, false);
                    }
                });
            }
        }
    }

    private void call_comment_list_api(String PostCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommentListResponse> call = ApiClient.getApiInterface().getCommentList(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    PostCode);

            call.enqueue(new Callback<CommentListResponse>() {
                @Override
                public void onResponse(@NonNull Call<CommentListResponse> call, @NonNull Response<CommentListResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            commentListResponse = response.body();
                            if (response.body().getStatus() == 1) {
                                update_list(commentListResponse);
                            } else {
                                no_list(commentListResponse);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " CommentList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommentListResponse> call, @NonNull Throwable t) {
                    call_comment_list_api(PostCode);
                    Log.d(Constants.failureResponse + " CommentList", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void update_list(CommentListResponse commentListResponse) {
        if (noListImg != null && noListTxt != null) {
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
        }
        lists = commentListResponse.getCommentListData().getCommentList();
        commentAdapter.addAll(lists,
                commentListResponse.getCommentListData().getUserMediumPath(),
                commentListResponse.getCommentListData().getUserThumbnailPath());

    }

    private void no_list(CommentListResponse response) {
        if (noListImg != null && noListTxt != null) {
            noListImg.setVisibility(View.VISIBLE);
            noListTxt.setVisibility(View.VISIBLE);
        }

        try{
            Glide.with(this)
                    .load(Constants.getLoadGlide(this, response.getStatusImg()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(noListImg);
        }catch (Exception e){
            Log.d(Constants.GlideException,e.toString());
        }

        lists.clear();

        commentAdapter.notifyDataSetChanged();

        noListTxt.setText(getString(R.string.no_comment));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }


    @Override
    public void passData(boolean deleted, int deletePosition) {
        if (deleted) {
            lists.remove(deletePosition);
            commentAdapter.notifyDataSetChanged();
            if (lists.size() <= 0) {
                call_comment_list_api(PostCode);
            }
        }
    }
}
