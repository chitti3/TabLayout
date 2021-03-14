package com.example.youthhub.profile;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class PostedStoriesAdapter extends RecyclerView.Adapter<PostedStoriesAdapter.MyViewHolder> implements View.OnClickListener {

    Activity activity;

    public PostedStoriesAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profiler_included_adapter1, viewGroup, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
    }

    private void callTypeFace(MyViewHolder holder) {
        holder.postName.setTypeface(FontTypeFace.fontSemiBold(activity));
        holder.postName1.setTypeface(FontTypeFace.fontMedium(activity));
        holder.postCmt.setTypeface(FontTypeFace.fontMedium(activity));
        holder.postImageTxt.setTypeface(FontTypeFace.fontBold(activity));
        holder.postCmtImageTxt.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onClick(View v) {

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
        EditText postCmt;
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

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
