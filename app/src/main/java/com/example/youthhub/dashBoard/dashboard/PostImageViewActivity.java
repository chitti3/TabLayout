package com.example.youthhub.dashBoard.dashboard;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.post.postList.GalleryList;
import com.example.youthhub.resModel.post.postList.GalleryList1;
import com.example.youthhub.resModel.post.postList.PostList;
import com.example.youthhub.resModel.profilepostlist.PostListItem;
import com.example.youthhub.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class PostImageViewActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.post_image)
    CircleImageView postImage;
    @BindView(R.id.post_code_txt)
    TextView postCodeTxt;
    @BindView(R.id.post_image_code_constrain)
    ConstraintLayout postImageCodeConstrain;
    @BindView(R.id.post_name)
    TextView postName;
    @BindView(R.id.posted_time)
    TextView postedTime;
    @BindView(R.id.three_dot)
    ImageView threeDot;
    @BindView(R.id.post_images_recycler)
    RecyclerView postImagesRecycler;

    private String pathSource;
    private String pathLarge;
    private String pathMedium;
    private String pathThumb;
    private String vidPath;
    private String vidPosterPath;
    private String profileMediumPath;
    private String profileThumbnailPath;
    private String eventLogoPath;

    PostImagesAdapter postImagesAdapter;
    PostListItem postList;
    List<GalleryList> galleryLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_image_view);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            postList = bundle.getParcelable(Constants.PostImageList);

            pathSource = bundle.getString("path_source");
            pathLarge = bundle.getString("path_large");
            pathMedium = bundle.getString("path_medium");
            pathThumb = bundle.getString("path_thumb");
            vidPath = bundle.getString("vid_path");
            vidPosterPath = bundle.getString("vid_poster_path");
            profileMediumPath = bundle.getString("profile_medium_path");
            profileThumbnailPath = bundle.getString("profile_thumbnail_path");
            eventLogoPath = bundle.getString("event_logo_path");

            if (postList != null) {
                galleryLists = postList.getGalleryList1();
                call_adapter(postList.getPmDescription(),galleryLists,pathThumb,postList.getPmCode(),postList.getPmTotalLike(),postList.getEncourageStatus(),postList.getPmTotalComment());
                postName.setText(postList.getUmName());
                postedTime.setText(postList.getPmCreatedOn());

                RequestOptions options = new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .priority(Priority.HIGH);

                if (!postList.getUmProfilePicture().isEmpty()) {
                    postImage.setVisibility(View.VISIBLE);
                    postCodeTxt.setVisibility(View.GONE);
                    Glide.with(this)
                            .load(Constants.getLoadGlide(this, profileThumbnailPath + postList.getUmProfilePicture()))
                            .apply(options)
                            .into(postImage);
                } else {
                    postCodeTxt.setVisibility(View.VISIBLE);
                    postImage.setVisibility(View.GONE);
                    postCodeTxt.setText(postList.getUsernameCode());
                }
            }
        }
    }

    private void call_adapter(String pmDescription, List<GalleryList> galleryLists, String pathThumb, String pmCode, String pmTotalLike, Integer encourageStatus, String pmTotalComment) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        postImagesRecycler.setLayoutManager(linearLayoutManager);
        postImagesAdapter = new PostImagesAdapter(this);
        postImagesRecycler.setAdapter(postImagesAdapter);
        postImagesAdapter.addAll(pmDescription,galleryLists,pathThumb,pmCode,pmTotalLike,encourageStatus,pmTotalComment);
    }

    @OnClick({R.id.back_constrain, R.id.back, R.id.three_dot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_constrain:
            case R.id.back:
                onBackPressed();
                break;
            case R.id.three_dot:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }
}
