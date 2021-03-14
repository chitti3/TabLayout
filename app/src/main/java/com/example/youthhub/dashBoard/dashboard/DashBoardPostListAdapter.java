package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.post.CommentListResponse;
import com.example.youthhub.resModel.post.PostLikeResponse;
import com.example.youthhub.resModel.post.postList.PostList;
import com.example.youthhub.resModel.profilepostlist.ConnectionListItem;
import com.example.youthhub.resModel.profilepostlist.EventListItem;
import com.example.youthhub.resModel.profilepostlist.GalleryListItem;
import com.example.youthhub.resModel.profilepostlist.JobsListItem;
import com.example.youthhub.resModel.profilepostlist.PostListItem;
import com.example.youthhub.resModel.profilepostlist.ShareUserInfo;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardPostListAdapter extends RecyclerView.Adapter<DashBoardPostListAdapter.MyViewHolder> {

    Activity activity;
    public static final String TAG = DashBoardPostListAdapter.class.getSimpleName();


    private OnPassValuesListener onPassValuesListener;

    public void setOnPassValuesListener(OnPassValuesListener onPassValuesListener) {
        this.onPassValuesListener = onPassValuesListener;
    }

    public DashBoardPostListAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<PostListItem> postLists = new ArrayList<>();
    private List<EventListItem> eventList = new ArrayList<>();
    private List<JobsListItem> jobsList = new ArrayList<>();
    private List<ConnectionListItem> connectionList = new ArrayList<>();
    private String pathSource;
    private String pathLarge;
    private String pathMedium;
    private String pathThumb;
    private String vidPath;
    private String vidPosterPath;
    private String profileMediumPath;
    private String profileThumbnailPath;
    private String eventLogoPath;
    private String explore_path1;
    private String explore_path2;

    public void addAll(List<PostListItem> postLists, List<EventListItem> eventList,
                       List<JobsListItem> jobsList, List<ConnectionListItem> connectionList, Map<String, String> imagePath) {
        this.postLists = postLists;
        this.eventList = eventList;
        this.jobsList = jobsList;
        this.connectionList = connectionList;
        this.pathSource = imagePath.get("path_source");
        this.pathLarge = imagePath.get("path_large");
        this.pathMedium = imagePath.get("path_medium");
        this.pathThumb = imagePath.get("path_thumb");
        this.vidPath = imagePath.get("vid_path");
        this.vidPosterPath = imagePath.get("vid_poster_path");
        this.profileMediumPath = imagePath.get("profile_medium_path");
        this.profileThumbnailPath = imagePath.get("profile_thumbnail_path");
        this.eventLogoPath = imagePath.get("event_logo_path");
        this.explore_path1 = imagePath.get("explore_path1");
        this.explore_path2 = imagePath.get("explore_path2");
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_dashboard_post_list, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        callTypeFace(holder);

        PostListItem postList = postLists.get(position);
        List<GalleryListItem> galleryLists = postList.getGalleryList();
        ShareUserInfo shareUserInfo = postList.getShareUserInfo();

        holder.likeBtn.setTag(R.id.data_tag, postList);
        holder.likeBtn.setTag(R.id.position, position);

        holder.pinBtn.setTag(R.id.data_tag, postList);
        holder.pinBtn.setTag(R.id.position, position);

        holder.likeCountTxt.setTag(postList);

        holder.commentBtn.setTag(postList);
        holder.commentCountTxt.setTag(postList);
        holder.postCmt.setTag(postList);

        holder.threeDot.setTag(R.id.data_tag, postList);
        holder.threeDot.setTag(R.id.position, position);
        Log.d(TAG, "data: post shared empty"+new Gson().toJson(postList.getShareUserInfo()));
        if (!new Gson().toJson(postList.getShareUserInfo()).equals("{}")) {
            holder.postSharedContent.setVisibility(View.VISIBLE);
            holder.postSharedBy.setVisibility(View.VISIBLE);
            holder.postSharedContent.setText("Shared Text : "+postList.getShareUserInfo().getPusShareTitle());
            holder.postSharedBy.setText("Posted By : "+postList.getUmName());
        }else{
            holder.postSharedContent.setVisibility(View.GONE);
            holder.postSharedBy.setVisibility(View.GONE);
            Log.d(TAG, "onBindViewHolder: post shared empty");
        }

        holder.shareBtn.setTag(R.id.data_tag, postList);
        holder.shareBtn.setTag(R.id.position, position);

        holder.mainImage.setTag(R.id.data_tag, postList);
        holder.multiImg1.setTag(R.id.data_tag, postList);
        holder.multiImg2.setTag(R.id.data_tag, postList);
        holder.multiImg3.setTag(R.id.data_tag, postList);
        holder.multiImgCountTxt.setTag(R.id.data_tag, postList);
        Log.d(TAG, "onBindViewHolder: getIs_share_icon" + postList.getIsShareIcon());
        if (postList.getIsShareIcon() == 1) {
            holder.shareBtn.setVisibility(View.VISIBLE);
            Log.d(TAG, "onBindViewHolder: getIs_share_icon visible" + postList.getIsShareIcon());
        } else {
            holder.shareBtn.setVisibility(View.GONE);
            Log.d(TAG, "onBindViewHolder: getIs_share_icon gone" + postList.getIsShareIcon());
        }
        if (postList.getShareUserCount() > 0) {
            // holder.shareBtn.setVisibility(View.VISIBLE);
            String shareCount;
            if (postList.getShareUserCount() == 1) {
                shareCount = shareUserInfo.getSharedByName() + " shared a post";
            } else {
                shareCount = shareUserInfo.getSharedByName() + " and " + (postList.getShareUserCount() - 1) + " others shared a post";
            }
            holder.postName.setText(shareCount);
        } else {
            if (!postList.getUmCode().equals(Constants.getUserCode(activity))) {
                // holder.shareBtn.setVisibility(View.VISIBLE);
            } else {
                //   holder.shareBtn.setVisibility(View.GONE);
            }

            holder.postName.setText(postList.getUmName());
        }

        holder.postedTime.setText(postList.getPmCreatedOn());
        holder.description.setText(postList.getPmDescription());
        holder.likeCountTxt.setText(postList.getPmTotalLike());




       holder.LikecC.setText(postList.getPmTotalLike() +" Likes");
       holder.commentCountTxt.setText(postList.getPmTotalComment());
       holder.comentCC.setText(postList.getPmTotalComment()+" Comments");


        if(postList.getPmTagsName()!=null){
            holder.Tag_name.setVisibility(View.VISIBLE);
            holder.Tag_name.setText(postList.getPmTagsName());
        }else{

          //  holder.Tag_name.setVisibility(View.GONE);
        }

        System.out.println("=====tagss" +postList.getPmTagsName());

        System.out.println("geththata"+Constants.getAccessKey(activity)+"fff"+Constants.getToken(activity));

        int like = Integer.parseInt(postList.getPmTotalLike());
        if (like <= 0) {
            holder.LikecC.setVisibility(View.GONE);

        }else{

            holder.LikecC.setVisibility(View.VISIBLE);
        }


        int comment = Integer.parseInt(postList.getPmTotalComment());
        if (comment <= 0) {
            holder.comentCC.setVisibility(View.GONE);

        }else{

            holder.comentCC.setVisibility(View.VISIBLE);
        }


        if(like<=0 && comment<=0){

            holder.constraintLayout3.setVisibility(View.GONE);

        }else{

            holder.constraintLayout3.setVisibility(View.VISIBLE);

        }


        holder.LikecC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  PostListItem likeCountPostList = (PostListItem) view.getTag();
                int like = Integer.parseInt(postList.getPmTotalLike());
                if (like <= 0) {
                    MyToast.errorMessage("No Likes For this Post", activity);
                } else {
                    call_post_encourage_list_api(postList);
                }


            }
        });


        holder.comentCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle comment_bundle = new Bundle();
                comment_bundle.putString(Constants.PostCode, postList.getPmCode());
                comment_bundle.putString(Constants.LikeCount, postList.getPmTotalLike());
                Intent commentIntent = new Intent(activity, CommentActivity.class);
                commentIntent.putExtras(comment_bundle);
                activity.startActivity(commentIntent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);

            }
        });



        switch (postList.getEncourageStatus()) {
            case 0:
                holder.likeBtn.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_unlike_heart));
                break;
            case 1:
                holder.likeBtn.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_like_heart));
                break;
        }

        switch (postList.getFavoriteStatus()) {
            case 0:
                holder.pinBtn.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_unpin_bookmark));
                break;
            case 1:
                holder.pinBtn.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_pin_bookmark));
                break;
        }
        Log.d(TAG, "onBindViewHolder: "+postList.getPmType());
        Log.d(TAG, "onBindViewHolder: "+new Gson().toJson(postList));
        if (!postList.getUmProfilePicture().isEmpty()) {
            holder.postImg.setVisibility(View.VISIBLE);
            // holder.postCmtImage.setVisibility(View.VISIBLE);
            if (postList.getShareUserCount() == 0) {
                if (postList.getPmType().equals("4")){
                    Glide.with(activity)
                            .load(Constants.getLoadGlide(activity, eventLogoPath + postList.getGalleryList().get(0).getPgaImage()))
                            .apply(AppUtils.getRequestOption())
                            .listener(AppUtils.requestListener)
                            .into(holder.postImg);
                }else if (postList.getPmType().equals("6")){
                    if (postList.getGalleryList().size()>0) {
                        if (postList.getGalleryList().get(0).getExploreType1() == 2) {
                            Glide.with(activity)
                                    .load(Constants.getLoadGlide(activity, explore_path2 + postList.getGalleryList().get(0).getPgaImage()))
                                    .apply(AppUtils.getRequestOption())
                                    .listener(AppUtils.requestListener)
                                    .into(holder.postImg);
                        } else {
                            Glide.with(activity)
                                    .load(Constants.getLoadGlide(activity, explore_path1 + postList.getGalleryList().get(0).getPgaImage()))
                                    .apply(AppUtils.getRequestOption())
                                    .listener(AppUtils.requestListener)
                                    .into(holder.postImg);
                        }
                    }
                }else {
                    Glide.with(activity)
                            .load(Constants.getLoadGlide(activity, profileThumbnailPath + postList.getUmProfilePicture()))
                            .apply(AppUtils.getRequestOption())
                            .listener(AppUtils.requestListener)
                            .into(holder.postImg);
                }
            } else {
                if (!postList.getShareUserInfo().getSharedByPic().isEmpty()) {
                    Glide.with(activity)
                            .load(Constants.getLoadGlide(activity, profileThumbnailPath + postList.getShareUserInfo().getSharedByPic()))
                            .apply(AppUtils.getRequestOption())
                            .listener(AppUtils.requestListener)
                            .into(holder.postImg);
                } else {
                    holder.postImg.setVisibility(View.GONE);
                    holder.postImageTxt.setVisibility(View.VISIBLE);
                    holder.postImageTxt.setText(postList.getShareUserInfo().getSharedByNameCode());
                }
            }
            Log.d(TAG, "onBindViewHolder: " + profileThumbnailPath + postList.getUmProfilePicture());
          /*  Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, profileThumbnailPath + postList.getUmProfilePicture()))
                    .apply(AppUtils.getRequestOption())
                    .listener(AppUtils.requestListener)
                    .into(holder.postCmtImage);*/
        } else {
            holder.postImageTxt.setVisibility(View.VISIBLE);
            //  holder.postCmtImageTxt.setVisibility(View.VISIBLE);

            holder.postImageTxt.setText(postList.getUsernameCode());

            //  holder.postCmtImageTxt.setText(postList.getUsernameCode());
        }


        if (Preference.getInstance(activity).getStr(Constants.UserProfileImage).length() != 0) {
            Glide.with(activity)
                    .load(Preference.getInstance(activity).getStr(Constants.UserImagePath) + Preference.getInstance(activity).getStr(Constants.UserProfileImage) + "?Yh-Access-Key=" + Preference.getInstance(activity).getStr(Constants.AccessKey))
                    .apply(AppUtils.getRequestOption())
                    .listener(AppUtils.requestListener)
                    .into(holder.postCmtImage);

            holder.postCmtImage.setVisibility(View.VISIBLE);

        } else {
            holder.postCmtImageTxt.setVisibility(View.VISIBLE);

            holder.postCmtImageTxt.setText(Preference.getInstance(activity).getStr(Constants.UserNameCode));

        }


        try {
            load_images(holder, AppUtils.getRequestOption(), galleryLists);
        } catch (Exception e) {
            Log.d("GlideLoadException", e.toString());
        }

        if (position == 1) {
            holder.postInclude2.setVisibility(View.VISIBLE);
            if (eventList.size() > 0) {
                holder.eventLayout.setVisibility(View.VISIBLE);
                event_layout(holder, eventList, eventLogoPath);
            } else {
                holder.eventLayout.setVisibility(View.GONE);
            }
            if (jobsList.size() > 0) {
                holder.jobsLayout.setVisibility(View.VISIBLE);
                jobs_layout(holder, jobsList);
            } else {
                holder.jobsLayout.setVisibility(View.GONE);
            }
            if (connectionList.size() > 0) {
                holder.connectionLayout.setVisibility(View.VISIBLE);
                connection_layout(holder, connectionList, profileMediumPath, profileThumbnailPath);
            } else {
                holder.connectionLayout.setVisibility(View.GONE);
            }
        } else {
            holder.postInclude2.setVisibility(View.GONE);
        }

    }

    private void load_images(MyViewHolder holder, RequestOptions options, List<GalleryListItem> galleryLists) {
        int size = galleryLists.size();
        if (size <= 4) {
            switch (size) {
                case 1:
                    holder.multiImageConstrain.setVisibility(View.VISIBLE);
                    holder.mainImage.setVisibility(View.VISIBLE);
                    holder.multiImgView1.setVisibility(View.GONE);
                    holder.multiImg1.setVisibility(View.GONE);
                    holder.multiImgView2.setVisibility(View.GONE);
                    holder.multiImg2.setVisibility(View.GONE);
                    holder.multiImgView3.setVisibility(View.GONE);
                    holder.multiImg3.setVisibility(View.GONE);
                    holder.multiImgCountTxt.setVisibility(View.GONE);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 0))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.mainImage);
                    break;
                case 2:
                    holder.multiImageConstrain.setVisibility(View.VISIBLE);
                    holder.mainImage.setVisibility(View.VISIBLE);
                    holder.multiImgView1.setVisibility(View.VISIBLE);
                    holder.multiImg1.setVisibility(View.VISIBLE);
                    holder.multiImgView2.setVisibility(View.GONE);
                    holder.multiImg2.setVisibility(View.GONE);
                    holder.multiImgView3.setVisibility(View.GONE);
                    holder.multiImg3.setVisibility(View.GONE);
                    holder.multiImgCountTxt.setVisibility(View.GONE);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 0))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.mainImage);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 1))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.multiImg1);
                    break;
                case 3:
                    holder.multiImageConstrain.setVisibility(View.VISIBLE);
                    holder.mainImage.setVisibility(View.VISIBLE);
                    holder.multiImgView1.setVisibility(View.VISIBLE);
                    holder.multiImg1.setVisibility(View.VISIBLE);
                    holder.multiImgView2.setVisibility(View.VISIBLE);
                    holder.multiImg2.setVisibility(View.VISIBLE);
                    holder.multiImgView3.setVisibility(View.GONE);
                    holder.multiImg3.setVisibility(View.GONE);
                    holder.multiImgCountTxt.setVisibility(View.GONE);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 0))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.mainImage);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 1))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.multiImg1);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 2))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.multiImg2);
                    break;
                case 4:
                    holder.multiImageConstrain.setVisibility(View.VISIBLE);
                    holder.mainImage.setVisibility(View.VISIBLE);
                    holder.multiImgView1.setVisibility(View.VISIBLE);
                    holder.multiImg1.setVisibility(View.VISIBLE);
                    holder.multiImgView2.setVisibility(View.VISIBLE);
                    holder.multiImg2.setVisibility(View.VISIBLE);
                    holder.multiImgView3.setVisibility(View.VISIBLE);
                    holder.multiImg3.setVisibility(View.VISIBLE);
                    holder.multiImgCountTxt.setVisibility(View.GONE);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 0))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.mainImage);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 1))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.multiImg1);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 2))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.multiImg2);

                    Glide.with(activity)
                            .load(loadImage(galleryLists, 3))
                            .apply(options)
                            .listener(AppUtils.requestListener)
                            .into(holder.multiImg3);
                    break;
                default:
                    holder.multiImageConstrain.setVisibility(View.GONE);
                    holder.mainImage.setVisibility(View.GONE);
                    holder.multiImgView1.setVisibility(View.GONE);
                    holder.multiImg1.setVisibility(View.GONE);
                    holder.multiImgView2.setVisibility(View.GONE);
                    holder.multiImg2.setVisibility(View.GONE);
                    holder.multiImgView3.setVisibility(View.GONE);
                    holder.multiImg3.setVisibility(View.GONE);
                    holder.multiImgCountTxt.setVisibility(View.GONE);
                    break;
            }
        } else {


            holder.multiImageConstrain.setVisibility(View.VISIBLE);
            holder.mainImage.setVisibility(View.VISIBLE);
            holder.multiImgView1.setVisibility(View.VISIBLE);
            holder.multiImg1.setVisibility(View.VISIBLE);
            holder.multiImgView2.setVisibility(View.VISIBLE);
            holder.multiImg2.setVisibility(View.VISIBLE);
            holder.multiImgView3.setVisibility(View.VISIBLE);
            holder.multiImg3.setVisibility(View.VISIBLE);
            holder.multiImgCountTxt.setVisibility(View.VISIBLE);

            Glide.with(activity)
                    .load(loadImage(galleryLists, 0))
                    .apply(options)
                    .listener(AppUtils.requestListener)
                    .into(holder.mainImage);

            Glide.with(activity)
                    .load(loadImage(galleryLists, 1))
                    .apply(options)
                    .listener(AppUtils.requestListener)
                    .into(holder.multiImg1);

            Glide.with(activity)
                    .load(loadImage(galleryLists, 2))
                    .apply(options)
                    .listener(AppUtils.requestListener)
                    .into(holder.multiImg2);

            Glide.with(activity)
                    .load(loadImage(galleryLists, 3))
                    .apply(options)
                    .listener(AppUtils.requestListener)
                    .into(holder.multiImg3);

            String imageCount = "+" + String.valueOf(size - 4);
            holder.multiImgCountTxt.setText(imageCount);
        }
    }

    String loadImage(List<GalleryListItem> galleryLists, int i) {

        String imagePath1 = null;
        switch (galleryLists.get(0).getPgaType()) {
            case "1":
                imagePath1 = Constants.getLoadGlide(activity, pathThumb + galleryLists.get(i).getPgaImage());
                break;
            case "2":
                imagePath1 = galleryLists.get(i).getPgaImage();
                break;
            case "3":
                imagePath1 = Constants.getLoadGlide(activity, galleryLists.get(i).getPgaVideoPoster());
                break;
            case "4":
                imagePath1 = galleryLists.get(i).getPgaVideoPoster();
                break;
        }

        return imagePath1;
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.postName.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.postName1.setTypeface(FontTypeFace.fontMedium(activity));
        holder.postCmt.setTypeface(FontTypeFace.fontMedium(activity));
        holder.suggestEventTxt.setTypeface(FontTypeFace.fontBold(activity));
        holder.suggestJobsTxt.setTypeface(FontTypeFace.fontBold(activity));
        holder.suggestConnectionTxt.setTypeface(FontTypeFace.fontBold(activity));
        holder.postImageTxt.setTypeface(FontTypeFace.fontBold(activity));
        holder.postCmtImageTxt.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void event_layout(MyViewHolder holder, List<EventListItem> eventList, String eventLogoPath) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        holder.suggestEventRecycler.setLayoutManager(linearLayoutManager);
        SuggestedEventsAdapter suggestedEventsAdapter = new SuggestedEventsAdapter(activity, eventList, eventLogoPath);
        holder.suggestEventRecycler.setAdapter(suggestedEventsAdapter);
    }

    private void jobs_layout(MyViewHolder holder, List<JobsListItem> jobsList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        holder.suggestJobsRecycler.setLayoutManager(linearLayoutManager);
        SuggestedJobsAdapter suggestedJobsAdapter = new SuggestedJobsAdapter(activity, jobsList);
        holder.suggestJobsRecycler.setAdapter(suggestedJobsAdapter);
    }

    private void connection_layout(MyViewHolder holder, List<ConnectionListItem> connectionList, String profileMediumPath, String profileThumbnailPath) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        holder.suggestConnectionRecycler.setLayoutManager(linearLayoutManager);
        SuggestConnectAdapter suggestConnectAdapter = new SuggestConnectAdapter(activity, connectionList, profileMediumPath, profileThumbnailPath);
        holder.suggestConnectionRecycler.setAdapter(suggestConnectAdapter);
    }

    @Override
    public int getItemCount() {
        return postLists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.post_img)
        CircleImageView postImg;
        @BindView(R.id.post_image_txt)
        TextView postImageTxt;
        @BindView(R.id.post_image_constrain)
        ConstraintLayout postImageConstrain;
        @BindView(R.id.post_name)
        TextView postName;
        @BindView(R.id.posted_time)
        TextView postedTime;
        @BindView(R.id.three_dot)
        ImageView threeDot;
        @BindView(R.id.main_image)
        ImageView mainImage;
        @BindView(R.id.multi_img_view1)
        View multiImgView1;
        @BindView(R.id.multi_img1)
        ImageView multiImg1;
        @BindView(R.id.multi_img_view2)
        View multiImgView2;
        @BindView(R.id.multi_img2)
        ImageView multiImg2;
        @BindView(R.id.multi_img_view3)
        View multiImgView3;
        @BindView(R.id.multi_img3)
        ImageView multiImg3;
        @BindView(R.id.multi_img_count_txt)
        TextView multiImgCountTxt;
        @BindView(R.id.multi_image_constrain)
        ConstraintLayout multiImageConstrain;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.education_txt)
        TextView educationTxt;
        @BindView(R.id.work)
        TextView work;
        @BindView(R.id.like_btn)
        ImageView likeBtn;
        @BindView(R.id.like_count_txt)
        TextView likeCountTxt;
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
        @BindView(R.id.comment_btn)
        ImageView commentBtn;
        @BindView(R.id.comment_count_txt)
        TextView commentCountTxt;
        @BindView(R.id.share_btn)
        ImageView shareBtn;
        @BindView(R.id.pin_btn)
        ImageView pinBtn;
        @BindView(R.id.view1)
        View view1;
        @BindView(R.id.post_cmt_image)
        CircleImageView postCmtImage;
        @BindView(R.id.post_cmt_image_txt)
        TextView postCmtImageTxt;
        @BindView(R.id.post_cmt_image_constrain)
        ConstraintLayout postCmtImageConstrain;
        @BindView(R.id.post_cmt)
        TextView postCmt;
        @BindView(R.id.post_image_constrain2)
        CircleImageView postImageConstrain2;
        @BindView(R.id.post_name1)
        TextView postName1;
        @BindView(R.id.posted_time1)
        TextView postedTime1;
        @BindView(R.id.cmt_description)
        TextView cmtDescription;
        @BindView(R.id.comment_constrain)
        ConstraintLayout commentConstrain;
        @BindView(R.id.view4)
        View view4;
        @BindView(R.id.post_include1)
        LinearLayout postInclude1;
        @BindView(R.id.suggest_event_txt)
        TextView suggestEventTxt;
        @BindView(R.id.suggest_event_recycler)
        RecyclerView suggestEventRecycler;
        @BindView(R.id.event_layout)
        RelativeLayout eventLayout;
        @BindView(R.id.suggest_jobs_txt)
        TextView suggestJobsTxt;
        @BindView(R.id.suggest_jobs_recycler)
        RecyclerView suggestJobsRecycler;
        @BindView(R.id.jobs_layout)
        RelativeLayout jobsLayout;
        @BindView(R.id.suggest_connection_txt)
        TextView suggestConnectionTxt;
        @BindView(R.id.suggest_connection_recycler)
        RecyclerView suggestConnectionRecycler;
        @BindView(R.id.connection_layout)
        RelativeLayout connectionLayout;
        @BindView(R.id.post_include2)
        LinearLayout postInclude2;
        @BindView(R.id.post_shared_content)
        TextView postSharedContent;
        @BindView(R.id.post_shared_by)
        TextView postSharedBy;
        @BindView(R.id.tags)
        TextView Tag_name;
        @BindView(R.id.Likec)
        TextView LikecC;
        @BindView(R.id.comentC)
        TextView comentCC;
        @BindView(R.id.constraintLayout3)
        ConstraintLayout constraintLayout3;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.three_dot, R.id.main_image, R.id.multi_img1, R.id.multi_img2, R.id.multi_img3, R.id.multi_img_count_txt, R.id.like_btn, R.id.like_count_txt, R.id.comment_btn, R.id.comment_count_txt, R.id.post_cmt, R.id.share_btn, R.id.pin_btn,R.id.Likec,R.id.comentC})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.three_dot:
                    /*Intent videoIntent = new Intent(activity, VimeoVideoActivity.class);
                    activity.startActivity(videoIntent);
                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);*/
                    PostListItem threeDotsPostList = (PostListItem) view.getTag(R.id.data_tag);
                    int selectedPosition = (int) view.getTag(R.id.position);
                    onPassValuesListener.onPassData(threeDotsPostList, selectedPosition);
                    break;
                case R.id.main_image:
                case R.id.multi_img1:
                case R.id.multi_img2:
                case R.id.multi_img3:
                case R.id.multi_img_count_txt:
                    PostListItem imagePostList = (PostListItem) view.getTag(R.id.data_tag);
                                      
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(Constants.PostImageList, (Parcelable) imagePostList);
                    bundle.putString("path_source", pathSource);
                    bundle.putString("path_large", pathLarge);
                    bundle.putString("path_medium", pathMedium);
                    bundle.putString("path_thumb", pathThumb);
                    bundle.putString("vid_path", vidPath);
                    bundle.putString("vid_poster_path", vidPosterPath);
                    bundle.putString("profile_medium_path", profileMediumPath);
                    bundle.putString("profile_thumbnail_path", profileThumbnailPath);
                    bundle.putString("event_logo_path", eventLogoPath);

                    System.out.println("==============gethtaht" +imagePostList);

                    Intent multi_img_count_txtIntent = new Intent(activity, PostImageViewActivity.class);
                    multi_img_count_txtIntent.putExtras(bundle);
                    activity.startActivity(multi_img_count_txtIntent);
                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                    break;
                case R.id.like_btn:

                        PostListItem likePostList = (PostListItem) view.getTag(R.id.data_tag);
                        int likePosition = (int) view.getTag(R.id.position);
                        likeBtn.setBackground(ContextCompat.getDrawable(activity, R.drawable.ic_like_heart));
                        onPassValuesListener.onPassPostLikeData(likePostList, likePosition);

                        break;

                case R.id.Likec:
                case R.id.like_count_txt:
                    PostListItem likeCountPostList = (PostListItem) view.getTag();
                    int like = Integer.parseInt(likeCountPostList.getPmTotalLike());
                    if (like <= 0) {
                        MyToast.errorMessage("No Likes For this Post", activity);
                    } else {
                        call_post_encourage_list_api(likeCountPostList);
                    }
                    break;

                case R.id.comment_btn:
                case R.id.comment_count_txt:
                case R.id.post_cmt:
                    PostListItem postList = (PostListItem) view.getTag();
                    Bundle comment_bundle = new Bundle();
                    comment_bundle.putString(Constants.PostCode, postList.getPmCode());
                    comment_bundle.putString(Constants.LikeCount, postList.getPmTotalLike());
                    Intent commentIntent = new Intent(activity, CommentActivity.class);
                    commentIntent.putExtras(comment_bundle);
                    activity.startActivity(commentIntent);
                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                    //call_comment_list_api(postList);
                    break;
                case R.id.share_btn:
                    PostList sharePostList = (PostList) view.getTag(R.id.data_tag);
                    int selectedSharePosition = (int) view.getTag(R.id.position);
                    onPassValuesListener.onPassShareData(sharePostList, selectedSharePosition);
                    break;
                case R.id.pin_btn:
                    PostList pinPostList = (PostList) view.getTag(R.id.data_tag);
                    int pinPosition = (int) view.getTag(R.id.position);
                    onPassValuesListener.onPassPinData(pinPostList, pinPosition);
                    break;
            }
        }

    }

    private void call_comment_list_api(PostList postList) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommentListResponse> call = ApiClient.getApiInterface().getCommentList(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    postList.getPmCode());

            call.enqueue(new Callback<CommentListResponse>() {
                @Override
                public void onResponse(@NonNull Call<CommentListResponse> call, @NonNull Response<CommentListResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putParcelable(Constants.PostCommentList, response.body());
                            bundle.putString(Constants.PostCode, postList.getPmCode());
                            bundle.putString(Constants.LikeCount, postList.getPmTotalLike());
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

    private void call_post_encourage_list_api(PostListItem likeCountPostList) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<PostLikeResponse> call = ApiClient.getApiInterface().getPostEncourageList(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    likeCountPostList.getPmCode());

            call.enqueue(new Callback<PostLikeResponse>() {
                @Override
                public void onResponse(@NonNull Call<PostLikeResponse> call, @NonNull Response<PostLikeResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                Bundle bundle = new Bundle();
                                bundle.putParcelable(Constants.PostLikeList, response.body());
                                Intent likeActivityIntent = new Intent(activity, LikeActivity.class);
                                likeActivityIntent.putExtras(bundle);
                                activity.startActivity(likeActivityIntent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostLikeList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<PostLikeResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " PostLikeList", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    public interface OnPassValuesListener {
        void onPassData(PostListItem postList, int selectedPosition);

        void onPassPostLikeData(PostListItem likePostList, int likePosition);

        void onPassPinData(PostList pinPostList, int pinPosition);

        void onPassShareData(PostList sharePostList, int selectedPosition);
    }

}