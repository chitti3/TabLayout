package com.example.youthhub.profile.profileTabSubViews;

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
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.resModel.profile.attachcv.ProfileAttachCVMasterResponse;
import com.example.youthhub.resModel.profile.attachcv.TypeMasterItem;
import com.example.youthhub.resModel.profile.attachcv.upload.ProfileResumeUploadResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.io.File;
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

public class CvDialog extends Dialog {

    private static final String TAG = CvDialog.class.getSimpleName();
    Activity activity;
    @BindView(R.id.add_resume_textview)
    TextView addResumeTextview;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.title_edittext)
    EditText titleEdittext;
    @BindView(R.id.type_textview)
    TextView typeTextview;
    @BindView(R.id.type_spinner)
    AppCompatSpinner typeSpinner;
    @BindView(R.id.file_upload_textview)
    TextView fileUploadTextview;

    @BindView(R.id.apply_btn)
    Button applyBtn;
    ProfileAttachCVMasterResponse profileAttachCVMasterResponse;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    @BindView(R.id.file_upload_txtarea)
    TextView fileUploadEdittext;
    TextView txt_file;
    private boolean isUpdated = false;
    private TypeMasterItem typemasterPassData = null;
    private Integer typemasterPosition = null;

    MultipartBody.Part body;
    private String typemasterId = null;
    private String titletxt = null;
    private String image = null;
    private String file = "ss";
    private String cvId = null;

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;

    UploadFileDialog uploadFileDialog;

    public CvDialog(Activity activity, ProfileAttachCVMasterResponse profileAttachCVMasterResponse) {
        super(activity);
        this.activity = activity;
        this.profileAttachCVMasterResponse = profileAttachCVMasterResponse;
    }

    public CvDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.attach_cv_dialogue);
        ButterKnife.bind(this);
        callTypeFace();
        uploadFileDialog = new UploadFileDialog(activity, "Resume");
        if (isUpdated) {
            updatedUI();
        } else {
            addUI();
        }
    }

    private void addUI() {
        cvType_spinner_load(isUpdated);
    }

    private void updatedUI() {
        cvType_spinner_load(isUpdated);
    }

    private void callTypeFace() {
        addResumeTextview.setTypeface(FontTypeFace.fontBold(activity));
        titleTextview.setTypeface(FontTypeFace.fontBold(activity));
        typeTextview.setTypeface(FontTypeFace.fontBold(activity));
        fileUploadTextview.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(titleTextview, "Title");
        AppUtils.textAddAstreik(typeTextview, "Type");
        AppUtils.textAddAstreik(fileUploadTextview, "File Upload");
    }


    private void cvType_spinner_load(boolean selected) {

        List<TypeMasterItem> typeMasterItems = new ArrayList<>();


        TypeMasterItem typeMasterItem = new TypeMasterItem();
        typeMasterItem.setId(0);
        typeMasterItem.setName(activity.getResources().getString(R.string.select_typemaster));
        typeMasterItems.add(typeMasterItem);

        typeMasterItems.addAll(profileAttachCVMasterResponse.getData().getTypeMaster());
        if (typeMasterItems.size() > 0) {
            ArrayAdapter<TypeMasterItem> adapter = new ArrayAdapter<TypeMasterItem>(activity, R.layout.spinner_text, typeMasterItems) {
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
                                            ViewGroup parent) {
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
            typeSpinner.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < typeMasterItems.size(); i++) {
                    /*if (typeMasterItems.get(i).getName().equalsIgnoreCase(volunteeringItem.getVocName())) {
                        int spinnerPosition = adapter.getPosition(typeMasterItems.get(i));
                        typeSpinner.setSelection(spinnerPosition);
                    }*/
                }
            }
            typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    typemasterPosition = position;
                    Log.d(TAG, "onItemSelected:typeSpinner " + position);
                    if (position > 0) {
                        typemasterPassData = (TypeMasterItem) parent.getSelectedItem();
                    } else {
                        typemasterPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

/*    private void call_profile_upload_api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("cv_file", file.getName(), requestFile);

            Call<ProfileResumeUploadResponse> call = ApiClient.getApiInterface().getUploadResumeFile(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);
            call.enqueue(new Callback<ProfileResumeUploadResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileResumeUploadResponse> call, @NonNull Response<ProfileResumeUploadResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                uploadFileDialog.closeDialog();
                                ProfileResumeUploadResponse profileResumeUploadResponse = response.body();
                                image = profileResumeUploadResponse.getData().getFileName();
                                Log.d(TAG, "onResponse: fileupload" + image);
                                fileUploadEdittext.setText(image);

                               *//* Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, profilePicUpload.getData().getPath_thumb() + profilePicUpload.getData().getFilename()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(profileImg);*//*
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(TAG, "call_profile_upload_api: failed");
                        Log.d(Constants.failureResponse + " ProPicUpload", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileResumeUploadResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ProPicUpload", t.toString());
                    Log.d(TAG, "call_profile_upload_api: failed");
                    Loader.showLoad(activity, false);
                }
            });
        }
    }*/


    @OnClick({R.id.apply_btn, R.id.cancel_btn, R.id.file_upload_txtarea})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateattachCV();
                } else {
                    addattachCV();
                }
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
            case R.id.file_upload_txtarea:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        Log.v(TAG, "Permission is granted1");
                        open_file();
                    } else {
                        Log.v(TAG, "Permission is revoked1");
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
                    }
                } else { //permission is automatically granted on sdk<23 upon installation
                    Log.v(TAG, "Permission is granted1");
                    open_file();
                }
                break;
        }
    }

    public void getData(String file_name, MultipartBody.Part body) {
        if (file_name != null) {
            Log.d(TAG, "getData: " + file_name);
           TextView txt_file = findViewById(R.id.file_upload_txtarea);
            this.image = file_name;
            file = image;
            Log.d(TAG, "addattachCV: " + image);
            txt_file.setText(""+file_name);

            this.body = body;
        }
    }

    private void open_file() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        try {
            activity.startActivityForResult(intent, 1);
        } catch (Exception ex) {
            Log.d("File Select Error", ex.toString());
        }
    }

    private void addattachCV() {

        if (typemasterPassData != null) {
            typemasterId = String.valueOf(typemasterPassData.getId());
        }


        if (!titleEdittext.getText().toString().isEmpty()) {
            titletxt = titleEdittext.getText().toString();

        }
        Log.d(TAG, "addattachCV: image"+image);
        Log.d(TAG, "addattachCV: file"+file);
     //   image = image;
        if (typemasterPassData == null) {
            MyToast.errorMessage("Select type", activity);
        } else if (titleEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter typemaster", activity);
        } else {
            onPassDataListener.onattachCVPassData(titletxt, typemasterId, file, true);
            dismiss();
        }


    }

    private void upddateattachCV() {

        cvId = "";
     //   image = image;
        if (typemasterPassData != null) {
            typemasterId = String.valueOf(typemasterPassData.getId());
        }


        if (!titleEdittext.getText().toString().isEmpty()) {
            titletxt = titleEdittext.getText().toString();

        }
        if (typemasterPassData == null) {
            MyToast.errorMessage("Select type", activity);
        } else if (titleEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter typemaster", activity);
        } else {
            onUpdatePassDataListener.onUpdatePassData(cvId, titletxt, typemasterId, image, true);
            dismiss();
        }


    }

    public interface OnPassDataListener {
        void onattachCVPassData(String titletxt, String typemasterId, String image, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String cvId, String titletxt, String typemasterId, String image, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }
}
