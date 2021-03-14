package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.VideoViewActivity;
import com.example.youthhub.VimeoVideoActivity;
import com.example.youthhub.resModel.explore.topics.TopicContent;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExploreTopicsAboutAdapter extends RecyclerView.Adapter<ExploreTopicsAboutAdapter.MyViewHolder> {

    private Activity activity;
    private List<TopicContent> topicContents = new ArrayList<>();
    private String exploreDescription;

    ExploreTopicsAboutAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<TopicContent> topicContents, String exploreDescription) {
        this.topicContents = topicContents;
        this.exploreDescription = exploreDescription;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_topics_about_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        CallTypeFace(myViewHolder);

        if (position == 0) {
            myViewHolder.descTxt.setVisibility(View.VISIBLE);
            myViewHolder.topicDesc.setVisibility(View.VISIBLE);
            myViewHolder.topicDesc.setText(exploreDescription);
        } else {
            TopicContent topicContent = topicContents.get(position - 1);

            myViewHolder.topicImg.setTag(R.id.glide_object_tag, topicContent);
            myViewHolder.playBtn.setTag(R.id.glide_object_tag, topicContent);

            switch (Integer.valueOf(topicContent.getXcType())) {
                case 0:
                    myViewHolder.topicDesc.setText(topicContent.getXcContent());
                    myViewHolder.topicDesc.setVisibility(View.VISIBLE);
                    myViewHolder.topicImg.setVisibility(View.GONE);
                    myViewHolder.playBtn.setVisibility(View.GONE);
                    break;
                case 4:
                    Glide.with(activity)
                            .load(topicContent.getCoverpath())
                            .apply(AppUtils.getRequestOptionWithoutOverride())
                            .into(myViewHolder.topicImg);
                    myViewHolder.topicDesc.setVisibility(View.GONE);
                    myViewHolder.topicImg.setVisibility(View.VISIBLE);
                    myViewHolder.playBtn.setVisibility(View.VISIBLE);
                    break;
                case 1:
                case 2:
                case 3:
                    Glide.with(activity)
                            .load(Constants.getLoadGlide(activity,topicContent.getCoverpath() + topicContent.getCoverfile()))
                            .apply(AppUtils.getRequestOptionWithoutOverride())
                            .into(myViewHolder.topicImg);
                    myViewHolder.topicDesc.setVisibility(View.GONE);
                    myViewHolder.topicImg.setVisibility(View.VISIBLE);
                    myViewHolder.playBtn.setVisibility(View.VISIBLE);
                case 5:
                    Glide.with(activity)
                            .load(topicContent.getCoverpath())
                            .apply(AppUtils.getRequestOptionWithoutOverride())
                            .into(myViewHolder.topicImg);
                    myViewHolder.topicDesc.setVisibility(View.GONE);
                    myViewHolder.topicImg.setVisibility(View.VISIBLE);
                    myViewHolder.playBtn.setVisibility(View.GONE);
                    break;
            }
        }

    }

    private void CallTypeFace(MyViewHolder myViewHolder) {
        myViewHolder.descTxt.setTypeface(FontTypeFace.fontSemiBold(activity));
    }

    @Override
    public int getItemCount() {
        //in first position displaying topic description so we add plus one position
        return topicContents.size() + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.desc_txt)
        TextView descTxt;
        @BindView(R.id.topic_desc)
        TextView topicDesc;
        @BindView(R.id.topic_img)
        ImageView topicImg;
        @BindView(R.id.play_btn)
        ImageView playBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.topic_img, R.id.play_btn})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.play_btn:
                case R.id.topic_img:
                    TopicContent topicContent = (TopicContent) view.getTag(R.id.glide_object_tag);
                    switch (Integer.valueOf(topicContent.getXcType())) {
                        case 0:
                            break;
                        case 4:
                            if (topicContent.getXcContent().contains("youtube")) {
                                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + topicContent.getVideoId()));
                                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + topicContent.getVideoId()));
                                try {
                                    activity.startActivity(appIntent);
                                } catch (ActivityNotFoundException ex) {
                                    activity.startActivity(webIntent);
                                }
                            }else if(topicContent.getXcContent().contains("vimeo")){
                                Intent vimeoVideoIntent = new Intent(activity, VimeoVideoActivity.class);
                                vimeoVideoIntent.putExtra(Constants.VimeoVideoId,topicContent.getVideoId());
                                activity.startActivity(vimeoVideoIntent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            } else {
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.VideoPath, Constants.getLoadGlide(activity,topicContent.getCoverpath() + topicContent.getXcContent()));
                                Intent videoIntent = new Intent(activity, VideoViewActivity.class);
                                videoIntent.putExtras(bundle);
                                activity.startActivity(videoIntent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            }
                            break;
                        case 1:
                        case 2:
                            Bundle imageBundle = new Bundle();
                            imageBundle.putString("Image", Constants.getLoadGlide(activity,topicContent.getCoverpath() + topicContent.getXcContent()));
                            Intent intent = new Intent(activity, ImageViewActivity.class);
                            intent.putExtras(imageBundle);
                            activity.startActivity(intent);
                            activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            break;
                        case 3:
                            Bundle bundle = new Bundle();
                            bundle.putString(Constants.VideoPath, Constants.getLoadGlide(activity,topicContent.getCoverpath() + topicContent.getXcContent()));
                            Intent videoIntent = new Intent(activity, VideoViewActivity.class);
                            videoIntent.putExtras(bundle);
                            activity.startActivity(videoIntent);
                            activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            break;
                        case 5:
                            String pdfUrl = topicContent.getCoverfile();
                            if (!pdfUrl.isEmpty()) {
                                Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                                pdfIntent.setData(Uri.parse("http://docs.google.com/gview?embedded=true&url=" + pdfUrl));
                                try {
                                    view.getContext().startActivity(pdfIntent);
                                } catch (ActivityNotFoundException e) {
                                    Log.d(Constants.PdfLoadFailure + " explorePDF", e.toString());
                                }
                            }
                            break;
                    }
                    break;
            }
        }

    }
}
