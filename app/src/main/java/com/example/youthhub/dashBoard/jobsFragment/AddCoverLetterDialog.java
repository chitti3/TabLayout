package com.example.youthhub.dashBoard.jobsFragment;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
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
import android.widget.Toast;

import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.resModel.jobs.applyJob.ApplyCoverLetter;
import com.example.youthhub.resModel.jobs.applyJob.ResumeMaster;
import com.example.youthhub.resModel.jobs.applyJob.ResumeTypeMaster;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class AddCoverLetterDialog extends Dialog{

    @BindView(R.id.dialog_title)
    TextView dialogTitle;
    @BindView(R.id.cancel_dialog)
    ImageView cancelDialog;
    @BindView(R.id.title_txt)
    TextView titleTxt;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.resume_type_txt)
    TextView resumeTypeTxt;
    @BindView(R.id.resume_type)
    Spinner resumeType;
    @BindView(R.id.resume_type_click)
    View resumeTypeClick;
    @BindView(R.id.file_upload_txt)
    TextView fileUploadTxt;
    @BindView(R.id.file_upload)
    TextView fileUpload;
    @BindView(R.id.apply)
    Button apply;
    private Activity activity;

    private List<ResumeTypeMaster> resumeTypeMasters = null;

    private ResumeTypeMaster resumeTypeMaster = null;

    private String fileName = null;
    private MultipartBody.Part body= null;
    private UploadFileDialog uploadFileDialog;

    AddCoverLetterDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_cover_letter_dilaog);
        ButterKnife.bind(this);
        CallTypeFace();
        load_before_resume_type_spinner();
    }

    private void load_before_resume_type_spinner() {
        List<String> list = new ArrayList<>();
        list.add(activity.getResources().getString(R.string.select_type));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, R.layout.spinner_text, list);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        resumeType.setAdapter(adapter);
    }

    private void CallTypeFace() {
        dialogTitle.setTypeface(FontTypeFace.fontBold(activity));
        titleTxt.setTypeface(FontTypeFace.fontBold(activity));
        resumeTypeTxt.setTypeface(FontTypeFace.fontBold(activity));
        fileUploadTxt.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(fileUploadTxt, "File Upload");
        AppUtils.textAddAstreik(titleTxt, "Title");
        AppUtils.textAddAstreik(resumeTypeTxt, "Type");
        uploadFileDialog = new UploadFileDialog(activity, "Support");
    }


    @OnClick({R.id.cancel_dialog, R.id.resume_type_click, R.id.file_upload, R.id.apply})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancel_dialog:
                dismiss();
                break;
            case R.id.resume_type_click:
                if(resumeTypeMasters==null) {
                    call_resume_type_api();
                }
                break;
            case R.id.file_upload:
               // uploadFileDialog.show();
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(activity,Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        Log.v(TAG,"Permission is granted1");
                        open_file();
                    } else {
                        Log.v(TAG,"Permission is revoked1");
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                    }
                }
                else { //permission is automatically granted on sdk<23 upon installation
                    Log.v(TAG,"Permission is granted1");
                    open_file();
                }
                break;
            case R.id.apply:
                validate();
                break;
        }
    }

    private void validate() {
        if(title.getText().toString().isEmpty() || resumeTypeMaster==null || fileUpload.getText().toString().isEmpty()){
            MyToast.errorMessage("All Fields are Mandatory",activity);
        }else {
            call_add_resume_api();
        }
    }

    private void call_add_resume_api() {

        String cv_type_id = String.valueOf(resumeTypeMaster.getId());
        String Title = title.getText().toString();

        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            RequestBody cv_type = RequestBody.create(MediaType.parse("text/plain"), cv_type_id);
            RequestBody cv_title = RequestBody.create(MediaType.parse("text/plain"), Title);
            RequestBody file_name = RequestBody.create(MediaType.parse("text/plain"), fileName);

            Call<ApplyCoverLetter> call = ApiClient.getApiInterface().getAddResume(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),Constants.getToken(activity),body,cv_type,cv_title,file_name);

            call.enqueue(new Callback<ApplyCoverLetter>() {
                @Override
                public void onResponse(@NonNull Call<ApplyCoverLetter> call, @NonNull Response<ApplyCoverLetter> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                MyToast.normalMessage(response.body().getMessage(),activity);
                                title.setText("");
                                load_before_resume_type_spinner();
                                resumeTypeClick.setVisibility(View.VISIBLE);
                                fileUpload.setText("");
                                dismiss();
                            }else {
                                MyToast.normalMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse+" AddCoverLetter",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<ApplyCoverLetter> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" AddCoverLetter",t.toString());
                    Loader.showLoad(activity,false);
                }
            });
        }
    }

    private void open_file() {
        Intent intent = new Intent();

        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        try {
            activity.startActivityForResult(Intent.createChooser(intent, "Select Pdf"),123);
        } catch (Exception ex) {
            Log.d("File Select Error",ex.toString());
        }
    }

    private void call_resume_type_api() {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            Call<ResumeMaster> call = ApiClient.getApiInterface().getResumeMaster(Constants.getApiKey(activity),Constants.getAccessKey(activity),Constants.getToken(activity));
            call.enqueue(new Callback<ResumeMaster>() {
                @Override
                public void onResponse(@NonNull Call<ResumeMaster> call, @NonNull Response<ResumeMaster> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                resumeTypeMasters = response.body().getResumeMasterData().getResumeTypeMaster();
                                load_resume_type_spinner(resumeTypeMasters);
                                resumeTypeClick.setVisibility(View.GONE);
                                resumeType.performClick();
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse,response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<ResumeMaster> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse,t.toString());
                    Loader.showLoad(activity,false);
                }
            });

        }
    }

    private void load_resume_type_spinner(List<ResumeTypeMaster> resumeTypeMasters) {
        List<ResumeTypeMaster> resumeTypeMasters1 = new ArrayList<>();

        ResumeTypeMaster resumeTypeMaster1 = new ResumeTypeMaster();
        resumeTypeMaster1.setId(null);
        resumeTypeMaster1.setName(activity.getResources().getString(R.string.select_type));
        resumeTypeMasters1.add(resumeTypeMaster1);

        resumeTypeMasters1.addAll(resumeTypeMasters);

        if (resumeTypeMasters1.size() > 0) {
            ArrayAdapter<ResumeTypeMaster> adapter = new ArrayAdapter<ResumeTypeMaster>(activity, R.layout.spinner_text, resumeTypeMasters1) {
                @Override
                public boolean isEnabled(int position) {
                    if (position == 0) {
                        // Disable the first item from Spinner
                        // First item will be use for hint
                        return false;
                    } else {
                        return true;
                    }
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
            resumeType.setAdapter(adapter);
            resumeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position > 0) {
                        resumeTypeMaster = (ResumeTypeMaster) parent.getSelectedItem();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    public void getData(String file_name, MultipartBody.Part body){
        if(file_name!=null){
            uploadFileDialog.closeDialog();
            fileUpload.setText(file_name);
            fileName = file_name;
            this.body = body;
        }
    }

}
