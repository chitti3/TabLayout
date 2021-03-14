package com.example.youthhub.profile;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.follower.ProfileFollowerResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FollowingActivity extends AppCompatActivity {
    private static final String TAG = FollowingActivity.class.getSimpleName();
    Activity activity;
    List<FollowersFollowingModel> followingModelList;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.following_name)
    TextView followingName;
    @BindView(R.id.following_recycler)
    RecyclerView followingRecycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    private String pageno = null;
    private String usercode = null;
    private ProfileFollowerResponse profileFollowerResponse;
    FollowingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        ButterKnife.bind(this);
        activity = this;
        callTypeFace();

        followingRecycler.setHasFixedSize(true);
        followingRecycler.setLayoutManager(new LinearLayoutManager(this));


        if (getIntent().getExtras() != null) {
            usercode = getIntent().getStringExtra(Constants.UserCode);
            call_profile_following_api(usercode);
        }


    }

    private void callTypeFace() {
        followingName.setTypeface(FontTypeFace.fontBold(this));
    }

    @OnClick(R.id.back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    private void call_profile_following_api(String usercode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileFollowerResponse> call = ApiClient.getApiInterface().getFollowingFollower(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pageno, "following", usercode);

            call.enqueue(new Callback<ProfileFollowerResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileFollowerResponse> call, @NonNull Response<ProfileFollowerResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileFollowerResponse = response.body();
                                followingName.setText(profileFollowerResponse.getData().getResultCount() + " Following");

                                adapter = new FollowingAdapter(activity, profileFollowerResponse);
                                followingRecycler.setAdapter(adapter);

                                //     MyToast.normalMessage("Volunteer Added successfully", activity);
                            } else {
                                noListImg.setVisibility(View.VISIBLE);
                                noListTxt.setVisibility(View.VISIBLE);
                                followingRecycler.setVisibility(View.GONE);
                                followingName.setText(  "0 Following");
                                noListTxt.setText(response.body().getMessage());

                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, response.body().getStatus_img()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(noListImg);
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                //MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileFollowerResponse> call, @NonNull Throwable t) {
                    call_profile_following_api(usercode);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

}


