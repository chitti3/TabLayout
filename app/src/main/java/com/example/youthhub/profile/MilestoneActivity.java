package com.example.youthhub.profile;

import android.app.Activity;
import android.content.Intent;
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
import com.example.youthhub.resModel.profile.journey.ProfileJourneyListResponse;
import com.example.youthhub.resModel.profile.milestone.ProfileMilestoneListResponse;
import com.example.youthhub.resModel.profile.profileinfo.AchievementItem;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.NetWorkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.profile.ProfileInfoDialog.TAG;

public class MilestoneActivity extends AppCompatActivity {
    Activity activity;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.add_mile)
    ImageView addmile;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    MileStoneAdapter mileStoneAdapter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.text_title)
    TextView textTitle;
    private String pageno = null;
    private String id;
    private ProfileMilestoneListResponse profileMilestoneListResponse;
    private String userType = "";
    private String userCode = "";
    private String mileid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestone_activity);
        ButterKnife.bind(this);
        activity = this;

        Intent intent = getIntent();
        mileid = intent.getStringExtra("id");
        addmile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                milestoneadd();
            }
        });
        call_adapter();
        getBundle();
    }

    private void addUI() {
    }


    private void getBundle() {
        try {

            if (getIntent().getExtras() != null) {
                //  userType = getIntent().getStringExtra(Constants.UserType);
                userCode = getIntent().getStringExtra(Constants.UserCode);

            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        call_profile_milestone_api(userCode);
    }

    private void call_adapter() {
        recyclerView.setNestedScrollingEnabled(false);
        textTitle.setTypeface(FontTypeFace.fontBold(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void call_profile_milestone_api(String userCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileMilestoneListResponse> call = ApiClient.getApiInterface().getJourneyMilestoneList(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), pageno,
                    userCode);

            call.enqueue(new Callback<ProfileMilestoneListResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileMilestoneListResponse> call, @NonNull Response<ProfileMilestoneListResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileMilestoneListResponse = response.body();
                                mileStoneAdapter = new MileStoneAdapter(activity, profileMilestoneListResponse,mileid,userCode);
                                recyclerView.setAdapter(mileStoneAdapter);
                                mileStoneAdapter.notifyDataSetChanged();
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            } else {
                                noListImg.setVisibility(View.VISIBLE);
                                noListTxt.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);

                                noListTxt.setText(response.body().getMessage());

                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, response.body().getStatus_img()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(noListImg);
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                // MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileMilestoneListResponse> call, @NonNull Throwable t) {
                    call_profile_milestone_api(userCode);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    @OnClick(R.id.back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
        }
    }
    private void milestoneadd() {
        Intent intent = new Intent(activity, AddMilestoneActivity.class);
        intent.putExtra(Constants.UserCode,userCode);
        // intent.putExtra("visualjourneymaster",profileVisualJourneyAddMasterResponse);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
    }
}
