package com.example.youthhub;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.profile.ProfileActivity;
import com.example.youthhub.resModel.profile.ProfileInfo;
import com.example.youthhub.resModel.profile.profileinfo.ProfileDeleteResonse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyFileContentProvider;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class UploadFileDialog extends Dialog {

    @BindView(R.id.ic_camera)
    ImageView icCamera;
    @BindView(R.id.camera)
    TextView camera;
    @BindView(R.id.camera_constrain)
    ConstraintLayout cameraConstrain;
    @BindView(R.id.ic_gallery)
    ImageView icGallery;
    @BindView(R.id.gallery)
    TextView gallery;
    @BindView(R.id.gallery_constrain)
    ConstraintLayout galleryConstrain;
    @BindView(R.id.ic_document)
    ImageView icDocument;
    @BindView(R.id.document)
    TextView document;
    @BindView(R.id.document_constrain)
    ConstraintLayout documentConstrain;
    @BindView(R.id.ic_delete)
    ImageView icDelete;
    @BindView(R.id.deletee)
    TextView deletee;
    @BindView(R.id.Delete_cons)
    ConstraintLayout DeleteCons;

    private Activity activity;

    private String from;
    ProfileInfo profileInfo;
    String type = "profile";

    public UploadFileDialog(Activity activity, String from) {
        super(activity);
        this.activity = activity;
        this.from = from;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_file_dialog);
        ButterKnife.bind(this);
        switch (from) {
            case "Support":
                gallery.setText(activity.getString(R.string.photo_video_library));
                documentConstrain.setVisibility(View.VISIBLE);
                DeleteCons.setVisibility(View.GONE);
                break;
            case "AddPost":
                gallery.setText(activity.getString(R.string.photo_video_library));
                documentConstrain.setVisibility(View.GONE);
                DeleteCons.setVisibility(View.GONE);
                break;
            case "Profile":
               if (profileInfo.getProfilePic().isEmpty()) {
                    gallery.setText(activity.getString(R.string.photo_library));
                    documentConstrain.setVisibility(View.GONE);
                    DeleteCons.setVisibility(View.GONE);
                  }else {
                    gallery.setText(activity.getString(R.string.photo_library));
                    documentConstrain.setVisibility(View.GONE);
                    DeleteCons.setVisibility(View.VISIBLE);
                }
                break;
            case "Cover":
                gallery.setText(activity.getString(R.string.photo_library));
                documentConstrain.setVisibility(View.GONE);
                DeleteCons.setVisibility(View.VISIBLE);
                Log.e("Cover Picture","Cover Picture");
                break;
            case "MileStone":
                gallery.setText(activity.getString(R.string.photo_library));
                documentConstrain.setVisibility(View.GONE);
                DeleteCons.setVisibility(View.GONE);
                break;
            case "Resume":
                gallery.setText(activity.getString(R.string.photo_library));
                documentConstrain.setVisibility(View.VISIBLE);
                DeleteCons.setVisibility(View.GONE);
                break;

        }
    }

    @OnClick({R.id.camera_constrain, R.id.gallery_constrain, R.id.document_constrain, R.id.Delete_cons})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.camera_constrain:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_GRANTED) {
                        Log.v(TAG, "Permission is granted1 camera");
                        open_camera();
                    } else {
                        Log.v(TAG, "Permission is revoked1");
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 3);
                    }
                } else { //permission is automatically granted on sdk<23 upon installation
                    Log.v(TAG, "Permission is granted1");
                    open_camera();
                }
                break;
            case R.id.gallery_constrain:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        Log.v(TAG, "Permission is granted1");
                        open_gallery();
                    } else {
                        Log.v(TAG, "Permission is revoked1");
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 4);
                    }
                } else { //permission is automatically granted on sdk<23 upon installation
                    Log.v(TAG, "Permission is granted1");
                    open_gallery();
                }
                break;
            case R.id.document_constrain:
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_GRANTED) {
                        Log.v(TAG, "Permission is granted1");
                        open_file();
                    } else {
                        Log.v(TAG, "Permission is revoked1");
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 5);
                    }
                } else { //permission is automatically granted on sdk<23 upon installation
                    Log.v(TAG, "Permission is granted1");
                    open_file();
                }
                break;

            case R.id.Delete_cons:
                deletefile(type);
                break;

        }
    }

    private void open_camera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, MyFileContentProvider.CONTENT_URI);
        try {
            activity.startActivityForResult(cameraIntent, Constants.CAMERA_REQUEST);
            dismiss();
        } catch (Exception ex) {
            Log.d("File Select Error", ex.toString());
        }

    }

    private void open_gallery() {

        Intent intent2 = new Intent(
                Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        try {
            activity.startActivityForResult(intent2, Constants.GALLERY_REQUEST);
            dismiss();

        } catch (Exception ex) {
            Log.d("File Select Error", ex.toString());
        }

    }

    private void open_file() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        try {
            activity.startActivityForResult(intent, Constants.FILE_REQUEST);
        } catch (Exception ex) {
            Log.d("File Select Error", ex.toString());
        }
    }

    public void closeDialog() {
        dismiss();
    }

    private void deletefile(String type) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileDeleteResonse> call = ApiClient.getApiInterface().getProfileDelete(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    type);

            call.enqueue(new Callback<ProfileDeleteResonse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileDeleteResonse> call, @NonNull Response<ProfileDeleteResonse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {

                                MyToast.normalMessage(response.body().getMessage(), activity);
                                dismiss();
                                Intent profileIntent = new Intent(activity, ProfileActivity.class);
                                profileIntent.putExtra(Constants.UserCode, Constants.getUserCode(activity));
                                profileIntent.putExtra(Constants.UserType, "1");
                                activity.startActivity(profileIntent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);

                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                                dismiss();

                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileDeleteResonse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }


    }

    public void newInstance(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
          Log.d(TAG, "newInstance: " + new Gson().toJson(profileInfo));
    }
}

