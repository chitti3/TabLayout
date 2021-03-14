package com.example.youthhub.dashBoard.jobsFragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.jobs.applyJob.Cv;
import com.example.youthhub.resModel.jobs.applyJob.JobApplyMaster;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobApplyDialog extends Dialog {

    @BindView(R.id.select_resume_click)
    View selectResumeClick;
    private Activity activity;

    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    @BindView(R.id.cancel_dialog)
    ImageView cancelDialog;
    @BindView(R.id.desc_txt)
    TextView descTxt;
    @BindView(R.id.desc)
    EditText desc;
    @BindView(R.id.add_cover_ltr)
    TextView addCoverLtr;
    @BindView(R.id.select_resume)
    Spinner selectResume;
    @BindView(R.id.apply)
    Button apply;

    private AddCoverLetterDialog addCoverLetterDialog;

    private String jobCode = null;

    private JobApplyMaster jobApplyMaster = null;

    private Cv selectCv = null;
    private OnPassDataListener onPassDataListener;

    void setOnPassDataListener(OnPassDataListener onPassDataListener){
        this.onPassDataListener = onPassDataListener;
    }

    JobApplyDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void newInstance(String job_code) {
        this.jobCode = job_code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.job_apply_dialog);
        ButterKnife.bind(this);
        CallTypeFace();
        addCoverLetterDialog = new AddCoverLetterDialog(activity);
        load_before_resume_spinner();
    }

    private void CallTypeFace() {
        dialogTitle.setTypeface(FontTypeFace.fontBold(activity));
        descTxt.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void load_before_resume_spinner() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.select_resume));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        selectResume.setAdapter(adapter);
    }

    private void call_resume_apply_master() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<JobApplyMaster> call = ApiClient.getApiInterface().getJobApplyMaster(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    jobCode);

            call.enqueue(new Callback<JobApplyMaster>() {
                @Override
                public void onResponse(@NonNull Call<JobApplyMaster> call, @NonNull Response<JobApplyMaster> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                jobApplyMaster = response.body();
                                load_resume_spinner(jobApplyMaster.getJobApplyMasterData().getCvs());
                                selectResumeClick.setVisibility(View.GONE);
                                selectResume.performClick();
                            }else {
                                MyToast.errorMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse+" JobApplyMaster",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<JobApplyMaster> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" JobApplyMaster",t.toString());
                    Loader.showLoad(activity,false);
                }
            });

        }
    }

    private void load_resume_spinner(List<Cv> cvs) {
        List<Cv> cvs1 = new ArrayList<>();

        Cv cv = new Cv();
        cv.setUcvCvId(null);
        cv.setUcvTitle(activity.getResources().getString(R.string.select_resume));
        cvs1.add(cv);

        cvs1.addAll(cvs);

        if (cvs1.size() > 0) {
            ArrayAdapter<Cv> adapter = new ArrayAdapter<Cv>(activity, R.layout.spinner_text, cvs1) {
                @Override
                public boolean isEnabled(int position) {
                    return position != 0;
                }

                @Override
                public View getDropDownView(int position, View convertView,
                                            @NonNull ViewGroup parent) {
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView tv = (TextView) view;
                    if (position == 0) {
                        // Set the hint text color gray
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.grey));
                    } else {
                        tv.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    }
                    return view;
                }
            };
            adapter.setDropDownViewResource(R.layout.spinner_text);
            selectResume.setAdapter(adapter);
            selectResume.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0) {
                        selectCv = (Cv) parent.getSelectedItem();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    @OnClick({R.id.cancel_dialog, R.id.add_cover_ltr, R.id.apply, R.id.select_resume_click})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel_dialog:
                dismiss();
                break;
            case R.id.add_cover_ltr:
                addCoverLetterDialog.show();
                break;
            case R.id.apply:
                call_apply_api();
                break;
            case R.id.select_resume_click:
                if(jobApplyMaster==null){
                    call_resume_apply_master();
                }
                break;
        }
    }

    private void call_apply_api() {
        String jobNotes = desc.getText().toString();
        String job_cv_id = "";
        if(selectCv!=null) {
            job_cv_id = selectCv.getUcvCvId();
        }
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonRes> call = ApiClient.getApiInterface().getJobApply(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    jobCode,
                    jobNotes,
                    job_cv_id,
                    "",
                    "",
                    "");

            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                MyToast.normalMessage(response.body().getMessage(),activity);
                                desc.setText("");
                                load_before_resume_spinner();
                                selectResumeClick.setVisibility(View.VISIBLE);
                                onPassDataListener.onPassData(true);
                                dismiss();
                            }else {
                                MyToast.errorMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse+" JobApply",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" JobApply",t.toString());
                    Loader.showLoad(activity,false);
                }
            });

        }
    }


    public void getData(String file_name, MultipartBody.Part body) {
        if (file_name != null) {
            addCoverLetterDialog.getData(file_name, body);
        }
    }

    public interface OnPassDataListener{
        void onPassData(boolean successCall);
    }
}
