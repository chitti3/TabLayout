package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.VideoViewActivity;
import com.example.youthhub.VimeoVideoActivity;
import com.example.youthhub.resModel.post.CommentListResponse;
import com.example.youthhub.resModel.post.likepost.LikeResponse;
import com.example.youthhub.resModel.post.postList.GalleryList;
import com.example.youthhub.resModel.post.postList.GalleryList1;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostImagesAdapter extends RecyclerView.Adapter<PostImagesAdapter.MyViewHolder> {

    public static final String TAG = "PostImagesAdapter";
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.post_images)
    ImageView postImages;
    @BindView(R.id.play_btn)
    ImageView playBtn;
    @BindView(R.id.like_post)
    ImageView likePost;
    @BindView(R.id.like_count)
    TextView likeCount;
    @BindView(R.id.like_constrain)
    ConstraintLayout likeConstrain;
    @BindView(R.id.cmt_post)
    ImageView cmtPost;
    @BindView(R.id.cmt_count)
    TextView cmtCount;
    @BindView(R.id.cmt_constrain)
    ConstraintLayout cmtConstrain;
    @BindView(R.id.share)
    ImageView share;
    @BindView(R.id.images_constrain)
    ConstraintLayout imagesConstrain;
    private Activity activity;
    private List<GalleryList> galleryLists = new ArrayList<>();
    private String pathThumb;
    private String pmDescription;
    private String pmCode;
    private String pmTotalLike;
    private Integer encourageStatus;
    private String pmTotalComment;

    PostImagesAdapter(Activity activity) {
        this.activity = activity;
    }

    public void addAll(String pmDescription, List<GalleryList> galleryLists, String pathThumb, String pmCode, String pmTotalLike, Integer encourageStatus, String pmTotalComment) {
        this.galleryLists = galleryLists;
        this.pathThumb = pathThumb;
        this.pmDescription = pmDescription;
        this.pmCode = pmCode;
        this.pmTotalLike = pmTotalLike;
        this.encourageStatus = encourageStatus;
        this.pmTotalComment = pmTotalComment;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.post_images_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (position == 0) {
            holder.imagesConstrain.setVisibility(View.GONE);
            holder.description.setVisibility(View.VISIBLE);
            holder.description.setText(pmDescription);
        } else {
            holder.imagesConstrain.setVisibility(View.VISIBLE);
            holder.description.setVisibility(View.GONE);
            GalleryList galleryList = galleryLists.get(position - 1);
            Log.d(TAG, "onBindViewHolder:PostImagesAdapter "+new Gson().toJson(galleryList));
            Glide.with(activity)
                    .load(loadImage(galleryList, holder))
                    .apply(AppUtils.getRequestOption())
                    .listener(AppUtils.requestListener)
                    .into(holder.postImages);

            holder.likeCount.setText(pmTotalLike);
            holder.cmtCount.setText(pmTotalComment);

            switch (encourageStatus) {
                case 0:
                    holder.likePost.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_unlike_heart));
                    break;
                case 1:
                    holder.likePost.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_like_heart));
                    break;
            }

        }
    }


    String loadImage(GalleryList galleryLists, MyViewHolder holder) {
        Log.d(TAG, "PostImagesAdapter:loadImage: "+galleryLists.getPgaType());
        String imagePath1 = null;
        switch (galleryLists.getPgaType()) {
            case "1":
                imagePath1 = Constants.getLoadGlide(activity, pathThumb + galleryLists.getPgaImage());
                holder.playBtn.setVisibility(View.GONE);
                holder.postImages.setVisibility(View.VISIBLE);

                break;
            case "2":
                imagePath1 = galleryLists.getPgaImage();
                holder.playBtn.setVisibility(View.GONE);
                holder.postImages.setVisibility(View.VISIBLE);
                break;
            case "3":
                imagePath1 = Constants.getLoadGlide(activity, galleryLists.getPgaVideoPoster());
                holder.playBtn.setVisibility(View.VISIBLE);
                holder.postImages.setVisibility(View.GONE);
                holder.postImages.setTag(R.id.data_tag,galleryLists);
                holder.playBtn.setTag(R.id.data_tag,galleryLists);
                break;
            case "4":
                imagePath1 = galleryLists.getPgaVideoPoster();
                holder.playBtn.setVisibility(View.VISIBLE);
                holder.postImages.setVisibility(View.GONE);
                holder.postImages.setTag(R.id.data_tag,galleryLists);
                holder.playBtn.setTag(R.id.data_tag,galleryLists);
                break;
        }

        return imagePath1;
    }

    @Override
    public int getItemCount() {
        return galleryLists.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.post_images)
        ImageView postImages;
        @BindView(R.id.like_post)
        ImageView likePost;
        @BindView(R.id.like_count)
        TextView likeCount;
        @BindView(R.id.like_constrain)
        ConstraintLayout likeConstrain;
        @BindView(R.id.cmt_post)
        ImageView cmtPost;
        @BindView(R.id.cmt_count)
        TextView cmtCount;
        @BindView(R.id.cmt_constrain)
        ConstraintLayout cmtConstrain;
        @BindView(R.id.share)
        ImageView share;
        @BindView(R.id.images_constrain)
        ConstraintLayout imagesConstrain;
        @BindView(R.id.play_btn)
        ImageView playBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.post_images, R.id.play_btn, R.id.like_post, R.id.like_count, R.id.like_constrain, R.id.cmt_post, R.id.cmt_count, R.id.cmt_constrain})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.post_images:
                case R.id.play_btn:
                    GalleryList list = (GalleryList) view.getTag(R.id.data_tag);
                    if (list!=null) {
                        String videoUrlPath;
                        Log.d(TAG, "PostImagesAdapter:loadImage: " + new Gson().toJson(list));
                        switch (list.getPgaType()) {
                            case "3":
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.VideoPath, Constants.getLoadGlide(activity, list.getPgaVideo()));
                                Intent videoIntent = new Intent(activity, VideoViewActivity.class);
                                videoIntent.putExtras(bundle);
                                activity.startActivity(videoIntent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                                break;
                            case "4":
                                videoUrlPath = list.getPgaVideo();
                                if (videoUrlPath.contains("youtube")) {
                                    Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + list.getPgaVideoId()));
                                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + list.getPgaVideoId()));
                                    try {
                                        activity.startActivity(appIntent);
                                    } catch (ActivityNotFoundException ex) {
                                        activity.startActivity(webIntent);
                                    }
                                } else if (videoUrlPath.contains("vimeo")) {
                                    Intent vimeoVideoIntent = new Intent(activity, VimeoVideoActivity.class);
                                    vimeoVideoIntent.putExtra(Constants.VimeoVideoId, list.getPgaVideoId());
                                    activity.startActivity(vimeoVideoIntent);
                                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                                } else {
                                    Bundle bundle1 = new Bundle();
                                    bundle1.putString(Constants.VideoPath, Constants.getLoadGlide(activity, list.getPgaVideo()));
                                    Intent videoIntent1 = new Intent(activity, VideoViewActivity.class);
                                    videoIntent1.putExtras(bundle1);
                                    activity.startActivity(videoIntent1);
                                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                                }
                                break;
                        }
                    }else{
                        Log.d(TAG, "onViewClicked: playbtn empty");
                    }
                    break;
                case R.id.like_post:
                    call_post_encourage_api(pmCode);
                    break;
                case R.id.like_count:
                    break;
                case R.id.cmt_post:
                case R.id.cmt_count:
                case R.id.cmt_constrain:
                    call_comment_list_api(pmCode);
                    break;
            }
        }

    }

    private void call_comment_list_api(String pmCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommentListResponse> call = ApiClient.getApiInterface().getCommentList(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pmCode);

            call.enqueue(new Callback<CommentListResponse>() {
                @Override
                public void onResponse(@NonNull Call<CommentListResponse> call, @NonNull Response<CommentListResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putParcelable(Constants.PostCommentList, response.body());
                            bundle.putString(Constants.PostCode, pmCode);
                            bundle.putString(Constants.LikeCount, pmTotalLike);
                            Intent commentIntent = new Intent(activity, CommentActivity.class);
                            commentIntent.putExtras(bundle);
                            activity.startActivity(commentIntent);
                            activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
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

    private void call_post_encourage_api(String pmCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            String status;
            if (encourageStatus == 1) {
                status = "0";
            } else {
                status = "1";
            }
            Loader.showLoad(activity, true);
            Call<LikeResponse> call = ApiClient.getApiInterface().getPostEncourage(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pmCode,
                    status);

            call.enqueue(new Callback<LikeResponse>() {
                @Override
                public void onResponse(@NonNull Call<LikeResponse> call, @NonNull Response<LikeResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                if (status.equals("1")) {
                                    encourageStatus = 1;
                                } else {
                                    encourageStatus = 0;
                                }
                                Log.d(TAG, "onResponse: working"+encourageStatus);
                                notifyDataSetChanged();
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
                public void onFailure(@NonNull Call<LikeResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " PostLike", t.toString());
                    Loader.showLoad(activity, false);

                }
            });
        }
    }

}
