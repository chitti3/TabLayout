package com.example.youthhub.profile;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.dashBoard.InterfaceClass;
import com.example.youthhub.dashBoard.createPost.TagsJourneyDialog;
import com.example.youthhub.resModel.post.postList.PostListResponse;
import com.example.youthhub.resModel.profile.ProfilePicUpload;
import com.example.youthhub.resModel.profile.profileinfo.AchievementItem;
import com.example.youthhub.resModel.profile.visualjourney.Journey_Edit.MilestoneUpdate;
import com.example.youthhub.resModel.profile.visualjourney.add.MilestoneUpdateMaster;
import com.example.youthhub.resModel.profile.visualjourney.journeyprofileupload.JourneyProfileUploadResponse;
import com.example.youthhub.resModel.profile.visualjourney.milestoneadd.MilestoneResponse;

import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.filestack.Config;
import com.filestack.FileLink;
import com.filestack.Sources;
import com.filestack.StorageOptions;
import com.filestack.android.FilestackPicker;
import com.filestack.android.FsActivity;
import com.filestack.android.FsConstants;
import com.filestack.android.Selection;
import com.filestack.transforms.tasks.ResizeTask;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

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

public class AddMilestoneActivity extends AppCompatActivity implements InterfaceClass.OnCustomStateListener {

    private static final String TAG = "AddMilestoneActivity";
    private static final int REQUEST_FILESTACK = 107;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.add_step_txt)
    TextView addStepTxt;
    @BindView(R.id.category_txt)
    TextView categoryTxt;
    @BindView(R.id.category_recycler)
    RecyclerView categoryRecycler;
    @BindView(R.id.title_txt)
    TextView titleTxt;
    @BindView(R.id.title)
    EditText title;
    @BindView(R.id.sub_heading_txt)
    TextView subHeadingTxt;
    @BindView(R.id.sub_heading)
    EditText subHeading;
    @BindView(R.id.description_txt)
    TextView descriptionTxt;
    @BindView(R.id.description)
    EditText description;
    @BindView(R.id.tags_txt)
    TextView tagsTxt;
    @BindView(R.id.tags)
    EditText tags;
    @BindView(R.id.spinner_btn_img)
    ImageView spinnerBtnImg;
    @BindView(R.id.tags_constrain)
    ConstraintLayout tagsConstrain;
    @BindView(R.id.select_media_txt)
    TextView selectMediaTxt;
    @BindView(R.id.image_view)
    CircleImageView imageView;
    @BindView(R.id.upload_img)
    TextView uploadImg;
    @BindView(R.id.select_media_cardView)
    CardView selectMediaCardView;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    String miletitle,miledesc;

    Activity activity;
    UploadStatusReceiver receiver;
    //   private UploadReceiver uploadReceiver;
    UploadFileDialog uploadFileDialog;
    private FileLink fileLink;
    private UploadReceiver uploadReceiver;
    private String post_title;
    private String post_description;
    private String gallery_temp_code,gallery_temp_code1;
    private String journey_code = "";
    int position;
    MilestoneUpdateMaster milestoneUpdateMaster;
    boolean bvalue;
    String mileid,vjid;


    /*public AddMilestoneActivity(Activity activity) {
        this.activity = activity;
    }

    public AddMilestoneActivity(Activity activity,MilestoneUpdateMaster milestoneUpdateMaster, boolean isUpdated, int position) {

        this.activity = activity;
        this.isUpdated = isUpdated;
        this.position = position;
        this.milestoneUpdateMaster=milestoneUpdateMaster;
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_milestone);
        ButterKnife.bind(this);
        //  Log.e("okokfref", String.valueOf(isUpdated));
        callTypeFace();
        getBundle();
        Intent intent = getIntent();

        mileid = intent.getStringExtra("mileid");
        vjid = intent.getStringExtra("vjid");
        bvalue =intent.getBooleanExtra("boolean",false);

        if (bvalue){ updatemile(mileid,vjid); }
        else { add(); }

        init();

        // Register the receiver for upload broadcasts
        IntentFilter filter = new IntentFilter(FsConstants.BROADCAST_UPLOAD);
        uploadReceiver = new UploadReceiver();
        LocalBroadcastManager.getInstance(this).registerReceiver(uploadReceiver, filter);

    }



    private void add() {
    }



    // }

    private void getBundle() {
        try {

            if (getIntent().getExtras() != null) {


                //  userType = getIntent().getStringExtra(Constants.UserType);
                journey_code = getIntent().getStringExtra(Constants.UserCode);


            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void callTypeFace() {
        addStepTxt.setTypeface(FontTypeFace.fontBold(this));
        categoryTxt.setTypeface(FontTypeFace.fontBold(this));
        descriptionTxt.setTypeface(FontTypeFace.fontBold(this));
        selectMediaTxt.setTypeface(FontTypeFace.fontBold(this));
        subHeadingTxt.setTypeface(FontTypeFace.fontBold(this));
        tagsTxt.setTypeface(FontTypeFace.fontBold(this));
        titleTxt.setTypeface(FontTypeFace.fontBold(this));
        applyBtn.setTypeface(FontTypeFace.fontBold(this));

        AppUtils.textAddAstreik(titleTxt, "Title");
        AppUtils.textAddAstreik(descriptionTxt, "Description");
    }

    private void init() {
        activity = this;


        uploadFileDialog = new UploadFileDialog(activity, "MileStone");

    }



    // Receives upload broadcasts from SDK service
    public class UploadReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            fileLink = (FileLink) intent.getSerializableExtra(FsConstants.EXTRA_FILE_LINK);
            // FileLink fileLink = ((AddMilestoneActivity) activity).getFileLink();
            if (fileLink != null) {
                int dimen = getResources().getDimensionPixelSize(R.dimen.form);
                String url = getAdaptiveUrl(fileLink, dimen);
                Log.d(TAG, "onResume: "+url);
                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, url))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(imageView);
                //Picasso.with(getContext()).load(url).into(imageView);
            }
            //  setLoading(false);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the receiver to avoid leaking it outside tne activity context
        LocalBroadcastManager.getInstance(this).unregisterReceiver(uploadReceiver);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @OnClick({R.id.back, R.id.apply_btn, R.id.select_media_cardView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.apply_btn:
                vadalitaion();
                break;

            case R.id.select_media_cardView:
                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
                } else {
                    // selectImage();
                    uploadFileDialog.show();
                }
                break;
        }
    }
    private void updatemile(String mileid, String vjid) {
        // if (NetWorkUtil.isNetworkConnected(activity)) {

        Loader.showLoad(activity, true);
        Call<MilestoneUpdateMaster> call = ApiClient.getApiInterface().getmilestoneupdatemaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                Constants.getToken(activity), mileid, vjid);
        call.enqueue(new Callback<MilestoneUpdateMaster>() {
            @Override
            public void onResponse(Call<MilestoneUpdateMaster> call, Response<MilestoneUpdateMaster> response) {
                Log.e("Response", response.message());
                MilestoneUpdateMaster milestoneUpdateMaster = response.body();
                Log.e("Response", new Gson().toJson(milestoneUpdateMaster.getData().getMilestoneview()));
                //   AddMilestoneActivity addMilestoneActivity =new AddMilestoneActivity(activity,milestoneUpdateMaster,true,position);
                miletitle=milestoneUpdateMaster.getData().getMilestoneview().getJustitle();
                miledesc=milestoneUpdateMaster.getData().getMilestoneview().getJusdetail();
                title.setText(miletitle);
                description.setText(miledesc);
                Loader.showLoad(activity, false);
            }

            @Override
            public void onFailure(Call<MilestoneUpdateMaster> call, Throwable t) {
                Log.e("Response", t.getMessage());
                Loader.showLoad(activity, false);
            }
        });

    }
    //}

    private void vadalitaion() {
        post_title = title.getText().toString();
        post_description = description.getText().toString();
        if (post_title.isEmpty()){
            MyToast.errorMessage("Please enter milestone title", activity);
        }else if (post_description.isEmpty()){
            MyToast.errorMessage("Please enter milestone description", activity);
        }else {
            if (bvalue)
            {

                call_update_edit(mileid,vjid,post_title,post_description,gallery_temp_code);
            }else {
                call_new_milestone_post_api();
            }

        }
    }

    private void call_update_edit(String mileid, String vjid, String milestone_title, String milestone_detail,String gallery_temp_code) {
        if (NetWorkUtil.isNetworkConnected(activity))
        {
            Loader.showLoad(activity,true);
            Call<MilestoneUpdate> mileupdate =ApiClient.getApiInterface().getmilestoneupdate(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),mileid,vjid,milestone_title,milestone_detail,gallery_temp_code);
            mileupdate.enqueue(new Callback<MilestoneUpdate>() {
                @Override
                public void onResponse(Call<MilestoneUpdate> call, Response<MilestoneUpdate> response) {

                    Toast.makeText(activity, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    Loader.showLoad(activity,false);
                    // Intent intent = new Intent(activity, VisualJourneyFragment.class);
                    // intent.putExtra(Constants.UserCode,vjid);
                    //intent.putExtra("id","1");
                    // activity.startActivity(intent);
                    //activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                    finish();

                }

                @Override
                public void onFailure(Call<MilestoneUpdate> call, Throwable t) {

                    Loader.showLoad(activity,false);
                }
            });
        }
    }

    public FileLink getFileLink() {
        return fileLink;
    }
    @Override
    public void onResume() {
        super.onResume();

        // If MainActivity contains a FileLink when the fragment resumes, load the image from it
        // So in this case we check the activity for data, rather than have it push to the fragment
        FileLink fileLink = ((AddMilestoneActivity) activity).getFileLink();
        if (fileLink != null) {
            int dimen = getResources().getDimensionPixelSize(R.dimen.form);
            String url = getAdaptiveUrl(fileLink, dimen);
            Log.d(TAG, "onResume: "+url);
            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, url))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(imageView);
            //Picasso.with(getContext()).load(url).into(imageView);
        }
    }

    // Handles user clicking select button, launches the picker UI
    private void selectImage() {
        // For simplicity we're loading credentials from a string res, don't do this in production


        // For simplicity we're loading credentials from a string res, don't do this in production
        String apiKey = Constants.APP_File_Stack_Key;
        if (apiKey.equals("")) {
            throw new RuntimeException("Create a string res value for \"filestack_api_key\"");
        }
        Config config = new Config(apiKey, "https://form.samples.android.filestack.com");
        Context context = activity;
        Intent pickerIntent = new Intent(context, FsActivity.class);
        pickerIntent.putExtra(FsConstants.EXTRA_CONFIG, config);
        // Restrict file selections to just images
        String[] mimeTypes = {"image/*"};
        pickerIntent.putExtra(FsConstants.EXTRA_MIME_TYPES, mimeTypes);
        context.startActivity(pickerIntent);
    }

    /*    // Receives upload broadcasts from SDK service
        public class UploadReceiver extends BroadcastReceiver {

            @Override
            public void onReceive(Context context, Intent intent) {
                fileLink = (FileLink) intent.getSerializableExtra(FsConstants.EXTRA_FILE_LINK);
            }
        }

        public FileLink getFileLink() {
            return fileLink;
        }


        @Override
        protected void onDestroy() {
            super.onDestroy();
            // Unregister the receiver to avoid leaking it outside tne activity context
            LocalBroadcastManager.getInstance(this).unregisterReceiver(uploadReceiver);
        }*/
    public class UploadStatusReceiver extends BroadcastReceiver {
        private static final String TAG = "UploadStatusReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            Locale locale = Locale.getDefault();
            String status = intent.getStringExtra(FsConstants.EXTRA_STATUS);
            Selection selection = intent.getParcelableExtra(FsConstants.EXTRA_SELECTION);
            FileLink fileLink = (FileLink) intent.getSerializableExtra(FsConstants.EXTRA_FILE_LINK);
            int dimen = getResources().getDimensionPixelSize(R.dimen.form);
            String url = getAdaptiveUrl(fileLink, dimen);
            Log.d(TAG, "onResume: " + url);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, url))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(imageView);
            String name = selection.getName();
            String handle = fileLink != null ? fileLink.getHandle() : "n/a";
            String msg = String.format(locale, "upload %s: %s (%s)", status, name, handle);
            Log.d(TAG, msg);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    /*    @Override
        public void onResume() {
            super.onResume();

            // If MainActivity contains a FileLink when the fragment resumes, load the image from it
            // So in this case we check the activity for data, rather than have it push to the fragment
            FileLink fileLink = ((AddMilestoneActivity) activity).getFileLink();
            if (fileLink != null) {
                int dimen = getResources().getDimensionPixelSize(R.dimen.form);
                String url = getAdaptiveUrl(fileLink, dimen);
                Log.d(TAG, "onResume: " + url);

                Glide.with(activity)
                        .load(Constants.getLoadGlide(activity, url))
                        .apply(AppUtils.getRequestOptionWithoutOverride())
                        .into(imageView);
                // Picasso is a useful utility to load the URL into an ImageView
                // Picasso.with(getContext()).load(url).into(imageView);
            }
        }*/
    private void call_new_milestone_post_api() {

        if(NetWorkUtil.isNetworkConnected(activity)){

            Loader.showLoad(activity,true);
            Call<MilestoneResponse> call = ApiClient.getApiInterface().getVisualJourneyAdd(Constants.getApiKey(activity),Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    journey_code,
                    post_title,
                    post_description,
                    gallery_temp_code1);

            call.enqueue(new Callback<MilestoneResponse>() {
                @Override
                public void onResponse(@NonNull Call<MilestoneResponse> call, @NonNull Response<MilestoneResponse> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                MilestoneResponse milestoneResponse = response.body();
                                MyToast.normalMessage("Posted Successfully",activity);
                                //  InterfaceClass.getInstance().changeState(milestoneResponse);
                                Intent intent = new Intent(activity, MilestoneActivity.class);
                                intent.putExtra(Constants.UserCode,journey_code);
                                intent.putExtra("id","1");
                                activity.startActivity(intent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                                finish();
                            }else {
                                MyToast.normalMessage(response.body().getMessage(),activity);
                            }
                        }
                    }else {
                        Log.d(Constants.failureResponse+" AddPost",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<MilestoneResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" AddPost",t.toString());
                    Loader.showLoad(activity,false);
                }
            });
        }
    }
    // Creates a URL to an image sized appropriately for the form ImageView
    private String getAdaptiveUrl(FileLink fileLink, int dimen) {
        ResizeTask resizeTask = new ResizeTask.Builder()
                .fit("crop")
                .align("center")
                .width(dimen)
                .height(dimen)
                .build();

        return fileLink.imageTransform().addTask(resizeTask).url();
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
                    call_profile_upload_api(file);
                    break;
                case Constants.GALLERY_REQUEST:
                    Uri selectedFileURI = data.getData();
                    File file1 = new File(AppUtils.getPath(selectedFileURI,activity));
                    Log.d("", "FileUpload : " + file1.getName());
                    call_profile_upload_api(file1);
                    break;

            }
        }

        if (requestCode == REQUEST_FILESTACK && resultCode == RESULT_OK) {
            Log.i(TAG, "received filestack selections");
            String key = FsConstants.EXTRA_SELECTION_LIST;
            ArrayList<Selection> selections = data.getParcelableArrayListExtra(key);
            for (int i = 0; i < selections.size(); i++) {
                Selection selection = selections.get(i);
                String msg = String.format(Locale.getDefault(), "selection %d: %s", i, selection.getName());
                Log.i(TAG, msg);
            }
        }
    }
    private void call_profile_upload_api(File file) {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            Log.d(TAG, "call_profile_upload_api: ");
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("userfile", file.getName(), requestFile);

            Call<JourneyProfileUploadResponse> call = ApiClient.getApiInterface().getVisualJourneyImage(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);
            call.enqueue(new Callback<JourneyProfileUploadResponse>() {
                @Override
                public void onResponse(@NonNull Call<JourneyProfileUploadResponse> call, @NonNull Response<JourneyProfileUploadResponse> response) {
                    if(response.isSuccessful()){
                        if (response.body() != null) {
                            if(response.body().getStatus()==1){
                                uploadFileDialog.closeDialog();
                                JourneyProfileUploadResponse profilePicUpload = response.body();
                                   if (bvalue) {
                                       gallery_temp_code = "" + profilePicUpload.getGalleryCode();
                                   }else {
                                       gallery_temp_code1 = "" + profilePicUpload.getGalleryCode();
                                   }


                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, profilePicUpload.getData().getPathThumb() + profilePicUpload.getData().getFilename()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(imageView);
                            }else {
                                MyToast.errorMessage(response.body().getMessage(),activity);
                            }
                            Log.d(TAG,response.toString());
                        }
                    }else {
                        Log.d(Constants.failureResponse+" ProPicUpload",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<JourneyProfileUploadResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse+" ProPicUpload",t.toString());
                    Loader.showLoad(activity,false);
                }
            });
        }
    }


    @Override
    public void stateChanged(PostDashboardListResponse response) {

    }

}