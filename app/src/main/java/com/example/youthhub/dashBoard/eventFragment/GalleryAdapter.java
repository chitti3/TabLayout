package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.event.gallery.Gallery;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.SquareImageView;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    public static final String TAG = "GalleryAdapter";
    Activity activity;
    private Map<String, String> imagePath;
    private List<Gallery> galleries;
    private String galleryType;

    private OnLoadMoreListener onLoadMoreListener;
    private PassGalleryDatas passGalleryDatas;
    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    void setPassGalleryDatas(PassGalleryDatas passGalleryDatas) {
        this.passGalleryDatas = passGalleryDatas;
    }

    public void addAll(List<Gallery> galleries) {
        Log.d(TAG, "addAll: ");
        this.galleries = galleries;
        notifyDataSetChanged();
    }

    GalleryAdapter(Activity activity, final RecyclerView photosRecycler, Map<String, String> imagePath, List<Gallery> galleries, String galleryType) {
        this.activity = activity;
        this.imagePath = imagePath;
        this.galleries = galleries;
        this.galleryType = galleryType;

        Log.d(TAG, "GalleryAdapter: " + new Gson().toJson(galleries));

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) photosRecycler.getLayoutManager();
        photosRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                boolean scrolled = AppUtils.isLastItemDisplaying(photosRecycler);
                if (scrolled) {
                    if (linearLayoutManager != null) {
                        totalItemCount = linearLayoutManager.getItemCount();
                    }
                    if (linearLayoutManager != null) {
                        lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    }
                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + galleries.size());
        return galleries == null ? 0 : galleries.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_photos_adapter, viewGroup, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + galleryType);

        populateItemRows((MyViewHolder) holder, position, galleryType);
    }

    private void populateItemRows(MyViewHolder holder, int position, String galleryType) {

        switch (galleryType) {
            case "Photos":
                update_photos_ui(holder, position);
                break;
            case "Videos":
                update_videos_ui(holder, position);
                break;
        }

    }

    private void update_videos_ui(MyViewHolder holder, int position) {

        //videos
        holder.playBtn.setVisibility(View.VISIBLE);

        Gallery gallery = galleries.get(position);

        holder.projectsImage.setOnClickListener(this);
        holder.projectsImage.setTag(R.id.glide_tag, position);
        holder.projectsImage.setTag(R.id.glide_object_tag, gallery);
        holder.projectsImage.setTag(R.id.glide_image_tag, imagePath.get("path_video"));
        Log.d(TAG, "update_videos_ui: " + new Gson().toJson(gallery));
        if (gallery != null) {
            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, imagePath.get("path_video_poster") + gallery.getEgaVideoPoster()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(holder.projectsImage);
        }
    }

    private void update_photos_ui(MyViewHolder holder, int position) {
        Log.d(TAG, "update_photos_ui: size" + galleries.size());
        Log.d(TAG, "update_photos_ui: position" + position);
        //photos
        Gallery gallery = galleries.get(position);

        holder.projectsImage.setOnClickListener(this);
        holder.projectsImage.setTag(R.id.glide_tag, position);
        holder.projectsImage.setTag(R.id.glide_object_tag, gallery);
        holder.projectsImage.setTag(R.id.glide_image_tag, imagePath.get("path_thumb"));
        Log.d(TAG, "update_photos_ui: " + imagePath.get("path_thumb") + gallery.getEgaImage());

        Glide.with(activity)
                .load(Constants.getLoadGlide(activity, imagePath.get("path_thumb") + gallery.getEgaImage()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(holder.projectsImage);
    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.projects_image) {
            if (v.getTag() != null) {
                Gallery gallery = (Gallery) v.getTag(R.id.glide_object_tag);
                int position = (int) v.getTag(R.id.glide_tag);
                String path = (String) v.getTag(R.id.glide_image_tag);
                switch (galleryType) {
                    case "Photos":
                        passGalleryDatas.passData(position);
                        break;
                    case "Videos":
                        passGalleryDatas.passVideo(gallery, path);
                        break;
                }

            }
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.projects_image)
        SquareImageView projectsImage;
        @BindView(R.id.play_btn)
        ImageView playBtn;
        @BindView(R.id.projects_card)
        CardView projectsCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

    public interface PassGalleryDatas {
        void passData(int position);

        void passVideo(Gallery gallery, String videoPath);
    }

}
