package com.example.youthhub.dashBoard.dashboard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.post.EncouragersList;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.MyViewHolder> {

    Activity activity;

    private List<EncouragersList> lists = new ArrayList<>();
    private String userMediumPath;
    private String userThumbnailPath;

    LikeAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<EncouragersList> lists, String userMediumPath, String userThumbnailPath) {
        this.lists = lists;
        this.userMediumPath = userMediumPath;
        this.userThumbnailPath = userThumbnailPath;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_like_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        callTypeFace(holder);
        EncouragersList list = lists.get(position);
        holder.likeName.setText(list.getUserName());
        holder.likeAbout.setText(list.getPfeCreatedOn());


        if (list.getUmProfilePicture().isEmpty()) {
            holder.likeImg.setVisibility(View.GONE);
            holder.likeUsernameCode.setVisibility(View.VISIBLE);
            holder.likeUsernameCode.setText(list.getUsernameCode());
        } else {
            holder.likeImg.setVisibility(View.VISIBLE);
            holder.likeUsernameCode.setVisibility(View.GONE);
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, userThumbnailPath + list.getUmProfilePicture()))
                    .apply(options)
                    .into(holder.likeImg);
        }

    }

    private void callTypeFace(MyViewHolder holder) {
        holder.likeName.setTypeface(FontTypeFace.fontBold(activity));
        holder.likeUsernameCode.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.like_img)
        CircleImageView likeImg;
        @BindView(R.id.like_username_code)
        TextView likeUsernameCode;
        @BindView(R.id.like_img_code_constrain)
        ConstraintLayout likeImgCodeConstrain;
        @BindView(R.id.like_name)
        TextView likeName;
        @BindView(R.id.like_about)
        TextView likeAbout;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}