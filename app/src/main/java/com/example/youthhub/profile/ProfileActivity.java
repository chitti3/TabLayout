package com.example.youthhub.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.dashBoard.InterfaceClass;
import com.example.youthhub.dashBoard.dashboard.SuggestConnectAdapter;
import com.example.youthhub.dashBoard.findConnectionFragment.ContactDialog;
import com.example.youthhub.resModel.connection.contactMessage.ContactMessageResponse;
import com.example.youthhub.resModel.connection.followunfollow.FollowUnfollowResponse;
import com.example.youthhub.resModel.post.postList.ConnectionList;
import com.example.youthhub.resModel.post.postList.PostListResponse;
import com.example.youthhub.resModel.profile.ProfileInfo;
import com.example.youthhub.resModel.profile.ProfileInfoResponse;
import com.example.youthhub.resModel.profile.ProfilePicUpload;
import com.example.youthhub.resModel.profile.profileinfo.CoverPictureUpload;
import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import java.io.File;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity implements InterfaceClass.OnCustomStateListener, ContactDialog.OnPassDataListener {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    Activity activity;
    ProfileInfoResponse profileInfoResponse = null;
    String UserCode;
    String UserType;
    @BindView(R.id.profile_cover_img)
    ImageView profileCoverImg;
    @BindView(R.id.profile_cover_bg_white)
    ImageView profileCoverBgWhite;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.profile_view1)
    View profileView1;
    @BindView(R.id.profile_pic_bg)
    View profilePicBg;
    @BindView(R.id.profile_pic_border)
    View profilePicBorder;
    @BindView(R.id.profile_img)
    CircleImageView profileImg;
    @BindView(R.id.profile_pic_icon)
    ImageView profilePicIcon;
    @BindView(R.id.profile_edit)
    ImageView profileEdit;
    @BindView(R.id.profiler_name)
    TextView profilerName;
    @BindView(R.id.profiler_subject)
    TextView profilerSubject;
    @BindView(R.id.followers_view)
    View followersView;
    @BindView(R.id.followers_bg_image)
    View followersBgImage;
    @BindView(R.id.followers_count)
    TextView followersCount;
    @BindView(R.id.followers_txt)
    TextView followersTxt;
    @BindView(R.id.followers_constrain)
    ConstraintLayout followersConstrain;
    @BindView(R.id.following_view)
    View followingView;
    @BindView(R.id.following_bg_image)
    View followingBgImage;
    @BindView(R.id.following_count)
    TextView followingCount;
    @BindView(R.id.following_txt)
    TextView followingTxt;
    @BindView(R.id.following_contrain)
    ConstraintLayout followingContrain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.cover_picture)
    ImageView CoverPicture;
    UploadFileDialog uploadFileDialog;
    @BindView(R.id.profile_img_txt)
    TextView profileImgTxt;
    @BindView(R.id.profile_pic_follow)
    ImageView profilePicFollow;
    @BindView(R.id.profile_msg)
    ImageView profileMsg;
    private int tabcount = 4;
    ContactDialog contactDialog;
    private String chat_id="0";
    private String is_follow="0";
    int cover=0;
    ProfileInfo profileInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        activity = this;
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        callTypeFace();
        uploadFileDialog = new UploadFileDialog(activity, "Profile");
        if (getIntent().getExtras() != null) {

            UserCode = getIntent().getStringExtra(Constants.UserCode);
            UserType = getIntent().getStringExtra(Constants.UserType);
            call_profile_info_api(UserCode);
            //  Log.d(TAG, "onCreate: UserChat"+getIntent().getStringExtra(Constants.UserChat));
            if (getIntent().getStringExtra(Constants.UserChat)!=null){
                profileMsg.setVisibility(View.VISIBLE);
                profilePicFollow.setVisibility(View.VISIBLE);
                chat_id = getIntent().getStringExtra(Constants.UserChat);
                is_follow = getIntent().getStringExtra(Constants.UserFollow);

                if (is_follow.equals("1")) {
                    profilePicFollow.setImageDrawable(getResources().getDrawable(R.drawable.ic_person_black_24dp));
                } else if (is_follow.equals("0")) {
                    profilePicFollow.setImageDrawable(getResources().getDrawable(R.drawable.group1907));
                }


            }else{
                profileMsg.setVisibility(View.GONE);
                profilePicFollow.setVisibility(View.GONE);
            }
            if (UserType.equals("6")) {
                profilePicIcon.setVisibility(View.VISIBLE);
                profileEdit.setVisibility(View.GONE);
            } else if (UserType.equals("1")) {
                profilePicIcon.setVisibility(View.VISIBLE);
                profileEdit.setVisibility(View.VISIBLE);
            } else {
                profilePicIcon.setVisibility(View.GONE);
                profileEdit.setVisibility(View.GONE);
            }
            Log.d(TAG, "onCreate: UserCode" + UserCode);
            Log.d(TAG, "onCreate: UserType" + UserType);
        }

    }

    private void call_profile_info_api(String userCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileInfoResponse> call = ApiClient.getApiInterface().getProfileInfo(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    userCode);

            call.enqueue(new Callback<ProfileInfoResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileInfoResponse> call, @NonNull Response<ProfileInfoResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileInfoResponse = response.body();

                                Log.d(TAG, "onResponse: call_profile_info_api" + new Gson().toJson(profileInfoResponse));
                                update_ui(profileInfoResponse);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileInfoResponse> call, @NonNull Throwable t) {
                    call_profile_info_api(userCode);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void update_ui(ProfileInfoResponse profileInfoResponse) {

        profileInfo = profileInfoResponse.getProfileInfoData().getProfileInfo();

        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.ProfileInfo, profileInfo);
        Log.d(TAG, "update_ui: " + new Gson().toJson(profileInfo));
        Log.d(TAG, "UserType: " + UserType);
        if (UserType.equals("8")) {
            tabcount = 5;
        } else {
            tabcount = 4;

        }
        viewPager.setAdapter(new ProfilePagerAdapter(getSupportFragmentManager(), bundle, UserType, tabcount));
        if (UserType.equals("8")) {
            viewPager.setOffscreenPageLimit(5);
        } else {
            viewPager.setOffscreenPageLimit(4);
        }
        tabs.setupWithViewPager(viewPager);
        setCustomFont(0);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                setCustomFont(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        profilerName.setText(profileInfo.getUsername());
        /*if (profileInfo.getYthShortDescription().isEmpty()) {
            profilerSubject.setText(profileInfo.getYthFullDescription());
        } else {
            profilerSubject.setText(profileInfo.getYthShortDescription());
        }*/
        //   String place = profileInfo.getRegionName()+"\n"+profileInfo.getCityName();
        String place = profileInfo.getRegionName();
        profilerSubject.setText(place);
        followersCount.setText(String.valueOf(profileInfoResponse.getProfileInfoData().getFollowerCount()));
        followingCount.setText(String.valueOf(profileInfoResponse.getProfileInfoData().getFollowingCount()));
        Log.d(TAG, "update_ui:working " + profileInfo.getProfilePic());
        try {

            if (!profileInfo.getProfilePic().isEmpty() || profileInfo.getProfilePic().length() != 0) {
                Glide.with(this)
                        .load(Constants.getLoadGlide(activity, profileInfoResponse.getProfileInfoData().getUserThumbnailPath() + profileInfo.getProfilePic()))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(profileImg);
                profileImg.setVisibility(View.VISIBLE);
                profileImgTxt.setVisibility(View.GONE);
            } else {
                profileImg.setVisibility(View.INVISIBLE);
                profileImgTxt.setVisibility(View.VISIBLE);
                profileImgTxt.setText(profileInfoResponse.getProfileInfoData().getProfileInfo().getUsernameCode());
            }

            Glide.with(this)
                    .load(Constants.getLoadGlide(activity, profileInfoResponse.getProfileInfoData().getUserCoverPath() + profileInfo.getCoverPic()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(profileCoverImg);
        } catch (Exception e) {
            Log.d(Constants.GlideException, e.toString());
        }

    }

    public void setCustomFont(int tabPosition) {

        ViewGroup vg = (ViewGroup) tabs.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    //Put your font in assests folder
                    //assign name of the font here (Must be case sensitive)
                    if (tabPosition == j) {
                        ((TextView) tabViewChild).setTypeface(FontTypeFace.fontBold(ProfileActivity.this));
                    } else {
                        ((TextView) tabViewChild).setTypeface(FontTypeFace.fontRegular(ProfileActivity.this));
                    }

                }
            }
        }
    }

    private void callTypeFace() {
        profilerName.setTypeface(FontTypeFace.fontSemiBold(this));
        followersCount.setTypeface(FontTypeFace.fontBold(this));
        followersTxt.setTypeface(FontTypeFace.fontBold(this));
        followingCount.setTypeface(FontTypeFace.fontBold(this));
        followingTxt.setTypeface(FontTypeFace.fontBold(this));
        profilerSubject.setTypeface(FontTypeFace.fontMedium(this));

        contactDialog = new ContactDialog(activity);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @OnClick({R.id.followers_count, R.id.followers_txt, R.id.following_count, R.id.following_txt, R.id.followers_constrain, R.id.following_contrain, R.id.profile_edit,R.id.profile_pic_follow, R.id.profile_msg
    ,R.id.cover_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.followers_count:
            case R.id.followers_txt:
            case R.id.followers_constrain:
                Intent intent = new Intent(getApplicationContext(), FollowersActivity.class);
                intent.putExtra(Constants.UserCode, UserCode);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.following_count:
            case R.id.following_txt:
            case R.id.following_contrain:
                Intent intent1 = new Intent(getApplicationContext(), FollowingActivity.class);
                intent1.putExtra(Constants.UserCode, UserCode);
                startActivity(intent1);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            //case R.id.profile_edit:
            //uploadFileDialog.show();

            case R.id.profile_edit:
                uploadFileDialog.newInstance(profileInfo);
                uploadFileDialog.show();
                break;
            case R.id.cover_picture:
                uploadFileDialog = new UploadFileDialog(activity, "Cover");
                uploadFileDialog.show();
                cover=1;
                break;


            case R.id.profile_pic_follow:
               call_connection_follow_api(is_follow);
                break;
            case R.id.profile_msg:

                contactDialog.setOnPassDataListener(ProfileActivity.this);
                contactDialog.show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constants.CAMERA_REQUEST:
                    File file = new File(getFilesDir(), "newImage.jpg");
                    Log.d("", "FileUpload : " + file.getName());

                   if (cover==1)
                   {
                       call_cover_upload_api(file);

                   }else {
                       call_profile_upload_api(file);
                   }
                    break;
                case Constants.GALLERY_REQUEST:
                    Uri selectedFileURI = data.getData();
                    File file1 = new File(AppUtils.getPath(selectedFileURI, activity));
                    Log.d("", "FileUpload : " + file1.getName());
                    if (cover==1)
                    {
                        call_cover_upload_api(file1);

                    }else {
                        call_profile_upload_api(file1);
                    }
                    break;
            }
        }
    }

    private void call_profile_upload_api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file", file.getName(), requestFile);

            Call<ProfilePicUpload> call = ApiClient.getApiInterface().getProfilePic(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);
            call.enqueue(new Callback<ProfilePicUpload>() {
                @Override
                public void onResponse(@NonNull Call<ProfilePicUpload> call, @NonNull Response<ProfilePicUpload> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                uploadFileDialog.closeDialog();
                                ProfilePicUpload profilePicUpload = response.body();
                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, profilePicUpload.getProfilePicUploadData().getPathThumb() + profilePicUpload.getProfilePicUploadData().getFilename()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(profileImg);
                                MyToast.normalMessage("Profile Picture Uploaded Successfully",activity);
                                Loader.showLoad(activity, false);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProPicUpload", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfilePicUpload> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ProPicUpload", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }
    public void call_cover_upload_api(File file1) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file", file1.getName(), requestFile);
            Call<CoverPictureUpload> call = ApiClient.getApiInterface().getCoverPic(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);
            call.enqueue(new Callback<CoverPictureUpload>() {
                @Override
                public void onResponse(Call<CoverPictureUpload> call, Response<CoverPictureUpload> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                uploadFileDialog.closeDialog();
                                // ProfilePicUpload profilePicUpload = response.body();
                                CoverPictureUpload coverPictureUpload = response.body();
                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, coverPictureUpload.getProfileCoverUploadData().getCover_photo() + coverPictureUpload.getProfileCoverUploadData().getFilename()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(profileCoverImg);
                                MyToast.normalMessage("Cover Picture Updated Successfully",activity);
                                Loader.showLoad(activity, false);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProPicUpload", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(Call<CoverPictureUpload> call, Throwable t) {

                }
            });
        }
    }
    private void call_connect_api(String message) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ContactMessageResponse> call = ApiClient.getApiInterface().createContactMessage(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity),
                    UserCode, String.valueOf(chat_id), message);
            call.enqueue(new Callback<ContactMessageResponse>() {


                @Override
                public void onResponse(Call<ContactMessageResponse> call, Response<ContactMessageResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                // connectionListMaster = response.body();

                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ConListMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ContactMessageResponse> call, @NonNull Throwable t) {
                    call_connect_api(message);
                    Log.d(Constants.failureResponse + " ConListMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_connection_follow_api(String isfollow) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

       /*     if (connectionList.getIsFollow() == 0) {
                isfollow = "1";
            } else {
                isfollow = "0";
            }*/
            Call<FollowUnfollowResponse> call = ApiClient.getApiInterface().getFollowUnFollow(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), UserCode, isfollow);
            call.enqueue(new Callback<FollowUnfollowResponse>() {
                @Override
                public void onResponse(@NonNull Call<FollowUnfollowResponse> call, @NonNull Response<FollowUnfollowResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                                is_follow = "0";
                                change_ui(response.body());
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " FollowUnFollow", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<FollowUnfollowResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " FollowUnFollow", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void change_ui(FollowUnfollowResponse connection) {
        if (connection.getMessage().contains("Follow") || connection.getMessage().contains("Unfollow")) {

            if (connection.getMessage().contains("Follow")) {
                profilePicFollow.setImageDrawable(getResources().getDrawable(R.drawable.ic_person_black_24dp));
            } else if (connection.getMessage().contains("Unfollow")) {
                profilePicFollow.setImageDrawable(getResources().getDrawable(R.drawable.unfollow_user));
            }

        }
    }

    @Override
    public void stateChanged(PostDashboardListResponse response) {

    }


    @Override
    public void passData(String title, boolean clear) {
        call_connect_api(title);
    }
}