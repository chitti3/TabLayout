package com.example.youthhub.myjobs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.myjobs.MyJobs;
import com.example.youthhub.resModel.myjobs.MyJobsList;
import com.example.youthhub.resModel.myjobs.Status;
import com.example.youthhub.resModel.myjobs.TypeMaster;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyJobsActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.myjobs_txt)
    TextView myjobsTxt;
    @BindView(R.id.job_applied_count)
    TextView jobAppliedCount;
    @BindView(R.id.job_applied_txt)
    TextView jobAppliedTxt;
    @BindView(R.id.job_shortlisted_count)
    TextView jobShortlistedCount;
    @BindView(R.id.job_shortlisted_txt)
    TextView jobShortlistedTxt;
    @BindView(R.id.job_selected_count)
    TextView jobSelectedCount;
    @BindView(R.id.job_selected_txt)
    TextView jobSelectedTxt;
    @BindView(R.id.job_declined_count)
    TextView jobDeclinedCount;
    @BindView(R.id.job_declined_txt)
    TextView jobDeclinedTxt;
    @BindView(R.id.job_view1)
    View jobView1;
    @BindView(R.id.job_view2)
    View jobView2;
    @BindView(R.id.job_view3)
    View jobView3;
    @BindView(R.id.cardView)
    CardView cardView;
    @BindView(R.id.myjobs_recycler)
    RecyclerView myjobsRecycler;

    MyJobsAdapter myJobsAdapter;
    Activity activity;

    MyJobsList myJobsList;
    List<TypeMaster> typeMaster = null;
    Status status = null;
    List<MyJobs> myJobs = null;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_jobs);
        ButterKnife.bind(this);
        activity = this;
        callTypeFace();
        call_adapter();
        call_my_jobs_list_api("");
    }

    private void call_my_jobs_list_api(final String callType) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<MyJobsList> call = ApiClient.getApiInterface().getMyJobs(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), callType);
            call.enqueue(new Callback<MyJobsList>() {
                @Override
                public void onResponse(@NonNull Call<MyJobsList> call, @NonNull Response<MyJobsList> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                myJobsList = response.body();
                                if (callType.isEmpty()) {
                                    update_ui(myJobsList);
                                } else {
                                    update(myJobsList);
                                }
                            } else {
                                if (myJobs != null)
                                    myJobs.clear();
                                List<MyJobs> myJobs = new ArrayList<>();
                                myJobsAdapter.addAll(myJobs);
                                if (response.body().getStatus() == 0) {
                                    myjobsRecycler.setVisibility(View.GONE);
                                    noListImg.setVisibility(View.VISIBLE);
                                    noListTxt.setVisibility(View.VISIBLE);
                                    Glide.with(activity)
                                            .load(Constants.getLoadGlide(activity, response.body().getStatus_img()))
                                            .apply(AppUtils.getRequestOptionWithoutOverride())
                                            .into(noListImg);

                                    noListTxt.setText(response.body().getMessage());

                                }
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " MyJobsList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<MyJobsList> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " MyJobsList", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void update(MyJobsList myJobsList) {
        myJobs = myJobsList.getMyJobsData().getMyJobs();
        myJobsAdapter.addAll(myJobs);
    }

    private void update_ui(MyJobsList myJobsList) {
        typeMaster = myJobsList.getMyJobsData().getTypeMaster();
        status = myJobsList.getMyJobsData().getStatus();
        myJobs = myJobsList.getMyJobsData().getMyJobs();
        if (myJobs != null) {
            myJobsAdapter.addAll(myJobs);
        }
        if (status != null) {
            jobAppliedCount.setText(status.getTotalApplied());
            jobShortlistedCount.setText(String.valueOf(status.getTotalShortlist()));
            jobSelectedCount.setText(status.getTotalInterview());
            jobDeclinedCount.setText(status.getTotalSelected());
        }
    }

    private void callTypeFace() {
        myjobsTxt.setTypeface(FontTypeFace.fontBold(this));
        jobAppliedCount.setTypeface(FontTypeFace.fontBold(this));
        jobShortlistedCount.setTypeface(FontTypeFace.fontRegular(this));
        jobSelectedCount.setTypeface(FontTypeFace.fontRegular(this));
        jobDeclinedCount.setTypeface(FontTypeFace.fontRegular(this));
    }

    private void call_adapter() {
        myJobsAdapter = new MyJobsAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myjobsRecycler.setLayoutManager(linearLayoutManager);
        myjobsRecycler.setAdapter(myJobsAdapter);
    }

    @OnClick({R.id.back_constrain, R.id.back, R.id.job_applied_count, R.id.job_applied_txt, R.id.job_shortlisted_count, R.id.job_shortlisted_txt, R.id.job_selected_count, R.id.job_selected_txt, R.id.job_declined_count, R.id.job_declined_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_constrain:
            case R.id.back:
                onBackPressed();
                break;
            case R.id.job_applied_count:
            case R.id.job_applied_txt:
                jobAppliedCount.setTypeface(FontTypeFace.fontBold(this));
                jobShortlistedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobSelectedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobDeclinedCount.setTypeface(FontTypeFace.fontRegular(this));
                if (typeMaster != null) {
                    call_my_jobs_list_api(String.valueOf(typeMaster.get(0).getId()));
                }
                break;
            case R.id.job_shortlisted_count:
            case R.id.job_shortlisted_txt:
                jobAppliedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobShortlistedCount.setTypeface(FontTypeFace.fontBold(this));
                jobSelectedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobDeclinedCount.setTypeface(FontTypeFace.fontRegular(this));
                if (typeMaster != null) {
                    call_my_jobs_list_api(String.valueOf(typeMaster.get(1).getId()));
                }
                break;
            case R.id.job_selected_count:
            case R.id.job_selected_txt:
                jobAppliedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobShortlistedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobSelectedCount.setTypeface(FontTypeFace.fontBold(this));
                jobDeclinedCount.setTypeface(FontTypeFace.fontRegular(this));
                if (typeMaster != null) {
                    call_my_jobs_list_api(String.valueOf(typeMaster.get(2).getId()));
                }
                break;
            case R.id.job_declined_count:
            case R.id.job_declined_txt:
                jobAppliedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobShortlistedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobSelectedCount.setTypeface(FontTypeFace.fontRegular(this));
                jobDeclinedCount.setTypeface(FontTypeFace.fontBold(this));
                if (typeMaster != null) {
                    call_my_jobs_list_api(String.valueOf(typeMaster.get(3).getId()));
                }
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
