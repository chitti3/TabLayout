package com.example.youthhub.dashBoard.jobsFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.myjobs.MyJobsActivity;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.jobs.JobInfo;
import com.example.youthhub.resModel.jobs.JobView;
import com.example.youthhub.resModel.jobs.applyJob.GetFileUpload;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.ImageFilePath;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobActivity extends AppCompatActivity implements JobApplyDialog.OnPassDataListener{

    private static final String TAG = "JobActivity";
    @BindView(R.id.job_image)
    ImageView jobImage;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.job_view1)
    View jobView1;
    @BindView(R.id.jobs_title)
    TextView jobsTitle;
    @BindView(R.id.pin_unpin_img)
    ImageView pinUnpinImg;
    @BindView(R.id.post_by)
    TextView postBy;
    @BindView(R.id.job_region)
    TextView jobRegion;
    @BindView(R.id.jobs_type)
    TextView jobsType;
    @BindView(R.id.jobs_date)
    TextView jobsDate;
    @BindView(R.id.job_view2)
    View jobView2;
    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    TextView txt2;
    @BindView(R.id.save_job_btn)
    Button saveJobBtn;
    @BindView(R.id.applied_btn)
    Button appliedBtn;
    @BindView(R.id.job_view3)
    View jobView3;
    @BindView(R.id.job_desc_txt)
    TextView jobDescTxt;
    @BindView(R.id.jobs_desc)
    TextView jobsDesc;
    @BindView(R.id.job_key_res_txt)
    TextView jobKeyResTxt;
    @BindView(R.id.job_key_res_desc)
    TextView jobKeyResDesc;
    @BindView(R.id.job_loc_txt)
    TextView jobLocTxt;
    @BindView(R.id.job_loc_desc)
    TextView jobLocDesc;
    @BindView(R.id.map_view)
    ImageView mapView;
    @BindView(R.id.nested_scroll)
    NestedScrollView nestedScroll;
    @BindView(R.id.jobs_main)
    ConstraintLayout jobs_main;

    String jobCode;
    JobInfo jobInfo;

    JobApplyDialog jobApplyDialog;
    Activity activity;

    String fileName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        activity = this;
        ButterKnife.bind(activity);
        callTypeFace();

        if (getIntent() != null) {
            jobCode = getIntent().getStringExtra("JobCode");
            call_job_api();
        }
        jobApplyDialog = new JobApplyDialog(activity);

    }

    private void call_job_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<JobView> jobViewCall = ApiClient.getApiInterface().getJob(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), jobCode);
            jobViewCall.enqueue(new Callback<JobView>() {
                @Override
                public void onResponse(@NonNull Call<JobView> call, @NonNull Response<JobView> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                updateUi(response.body());
                                jobs_main.setVisibility(View.VISIBLE);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " JobView", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<JobView> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " JobView", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateUi(JobView jobView) {

        jobInfo = jobView.getJobData().getJobInfo();

        if(jobInfo.getJobsLogoPath().contains("youthhub")) {
            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity,jobInfo.getJobsLogoPath()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(jobImage);
        }else {
            Glide.with(activity)
                    .load(jobInfo.getJobsLogoPath())
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(jobImage);
        }

        jobsTitle.setText(jobInfo.getJmTitle());
        postBy.setText(jobInfo.getPostBy());
        jobRegion.setText(jobInfo.getRegionName());
        jobsType.setText(jobInfo.getJmJtTypeName());
        jobsDate.setText(jobInfo.getJmStartDate());
        txt1.setText(jobInfo.getIcaName());
        txt2.setText(jobInfo.getIscName());
        jobsDesc.setText(jobInfo.getJmFullDescription());
        if(!jobInfo.getJmRequirementDetails().isEmpty()){
            jobKeyResDesc.setText(jobInfo.getJmRequirementDetails());
            jobKeyResTxt.setVisibility(View.VISIBLE);
            jobKeyResDesc.setVisibility(View.VISIBLE);
        }else {
            jobKeyResDesc.setText(getResources().getString(R.string.no_responsibility));
            jobKeyResTxt.setVisibility(View.GONE);
            jobKeyResDesc.setVisibility(View.GONE);
        }
        jobLocDesc.setText(jobInfo.getJloAddress());

        switch (jobInfo.getIsSave()) {
            case 0:
                pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_unpin_bookmark));
                break;
            case 1:
                pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pin_bookmark));
                break;
            default:
                pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_unpin_bookmark));
                break;
        }

        switch (jobInfo.getIsApplied()) {
            case 0:
                appliedBtn.setText("Apply");
                break;
            case 1:
                appliedBtn.setText("Applied");
                break;
            default:
                appliedBtn.setText("Apply");
                break;
        }
    }

    private void callTypeFace() {
        jobsTitle.setTypeface(FontTypeFace.fontBold(activity));
        postBy.setTypeface(FontTypeFace.fontSemiBold(activity));
        jobRegion.setTypeface(FontTypeFace.fontSemiBold(activity));
        appliedBtn.setTypeface(FontTypeFace.fontBold(activity));
        jobDescTxt.setTypeface(FontTypeFace.fontBold(activity));
        jobKeyResTxt.setTypeface(FontTypeFace.fontBold(activity));
        jobLocTxt.setTypeface(FontTypeFace.fontBold(activity));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @OnClick({R.id.back_constrain, R.id.back, R.id.pin_unpin_img, R.id.applied_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_constrain:
            case R.id.back:
                onBackPressed();
                break;
            case R.id.pin_unpin_img:
                callIsSaveApi(jobInfo);
                break;
            case R.id.applied_btn:
                if(jobCode!=null) {
                    if(jobInfo.getIsApplied()==0) {
                        jobApplyDialog.newInstance(jobCode);
                        jobApplyDialog.setOnPassDataListener(this);
                        jobApplyDialog.show();
                    }else {
                        Intent myJobIntent = new Intent(this, MyJobsActivity.class);
                        startActivity(myJobIntent);
                        overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                    }
                }
                break;
        }
    }

    private void callIsSaveApi(JobInfo jobInfo) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            String jobCode = jobInfo.getJmCode();
            final String isSave;
            if (jobInfo.getIsSave() == 0) {
                isSave = "1";
            } else {
                isSave = "0";
            }
            Call<CommonRes> resCall = ApiClient.getApiInterface().getIsSave(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), jobCode, isSave);
            resCall.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                updateIsSave(Integer.valueOf(isSave));
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " JobIsSave", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " JobIsSave", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateIsSave(Integer isSave) {
        jobInfo.setIsSave(isSave);
        changeUi(jobInfo);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){

            case 123:

                if(resultCode==RESULT_OK && data!=null){
                    Uri selectedFileURI = data.getData();
                    //  Uri uri = Uri.parse(data);
                    Log.d(TAG, "onActivityResult: "+new Gson().toJson(selectedFileURI));
                    File file = new File(ImageFilePath.getPath(activity,selectedFileURI));
                  /*  InputStream is = null;
                    try {
                         is = getContentResolver().openInputStream(selectedFileURI);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    File file = new File(selectedFileURI.getPath().toString());
                    String Fpath = data.getDataString();
                    Log.d("", "FileUpload : " + file.getName());*/
                    call_Api(file);
                }else{
                    Log.d(TAG, "onActivityResult: data null");
                }
                break;

        }
    }
    public String getAbsolutePath(Uri uri) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    public static String getPath1(Uri uri) {
        if (uri == null) return null;
        String fileName = null;
        String path = uri.getPath();
        int cut = path.lastIndexOf('/');
        if (cut != -1) {
            fileName = path.substring(cut + 1);
        }
        return fileName;
    }

    private void call_Api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity));{
            Loader.showLoad(activity,true);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("cv_file", file.getName(), requestFile);

            Call<GetFileUpload> call = ApiClient.getApiInterface().getFileName(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),Constants.getToken(activity),body);
            call.enqueue(new Callback<GetFileUpload>() {
                @Override
                public void onResponse(@NonNull Call<GetFileUpload> call, @NonNull Response<GetFileUpload> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                fileName = response.body().getFileUploadData().getFileName();
                                jobApplyDialog.getData(fileName,body);
                                MyToast.normalMessage(fileName +" file uploaded successfully",activity);
                            }else {
                                Log.d(TAG, "onResponse: "+response.body().getMessage());
                                MyToast.normalMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse,response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<GetFileUpload> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse,t.toString());
                    Loader.showLoad(activity,false);
                    MyToast.normalMessage(t.toString(),activity);
                }
            });
        }
    }

    private void changeUi(JobInfo jobInfo) {
        switch (jobInfo.getIsSave()) {
            case 0:
                pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_unpin_bookmark));
                break;
            case 1:
                pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_pin_bookmark));
                break;
            default:
                pinUnpinImg.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_unpin_bookmark));
                break;
        }
    }

    @Override
    public void onPassData(boolean successCall) {
        if(successCall){
            jobInfo.setIsApplied(1);

            switch (jobInfo.getIsApplied()) {
                case 0:
                    appliedBtn.setText("Apply");
                    break;
                case 1:
                    appliedBtn.setText("Applied");
                    break;
                default:
                    appliedBtn.setText("Apply");
                    break;
            }

        }
    }
}
