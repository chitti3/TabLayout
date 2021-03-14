package com.example.youthhub.dashBoard.createPost;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ImagePostAdapter extends RecyclerView.Adapter<ImagePostAdapter.MyViewHolder> {

    private Activity activity;
    private List<PostImageModel> postImageModels = new ArrayList<>();
    private OnPassDataListener onPassDataListener;

    void setOnPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    ImagePostAdapter(Activity activity) {
        this.activity = activity;
    }

    void addAll(List<PostImageModel> postImageModels) {
        this.postImageModels = postImageModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(activity).inflate(R.layout.image_post_adapter, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (position == (postImageModels.size() - 1)) {
            holder.view1.setVisibility(View.VISIBLE);
        } else {
            holder.view1.setVisibility(View.GONE);
        }

        PostImageModel postImageModel = postImageModels.get(position);

        holder.deleteImage.setTag(postImageModel);
        holder.deleteIcon.setTag(postImageModel);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(activity)
                .load(postImageModel.getBitmap())
                .apply(options)
                .into(holder.postImage);
    }


    @Override
    public int getItemCount() {
        return postImageModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.post_image)
        ImageView postImage;
        @BindView(R.id.delete_icon)
        CircleImageView deleteIcon;
        @BindView(R.id.delete_image)
        ConstraintLayout deleteImage;
        @BindView(R.id.images_cardview)
        CardView imagesCardview;
        @BindView(R.id.view1)
        View view1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick({R.id.delete_icon, R.id.delete_image})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.delete_icon:
                case R.id.delete_image:
                    PostImageModel postImageModel = (PostImageModel) view.getTag();
                    if(postImageModel!=null){
                        onPassDataListener.onPassData(postImageModel);
                    }
                    break;
            }
        }

    }

    public interface OnPassDataListener{
        void onPassData(PostImageModel postImageModel);
    }

}
