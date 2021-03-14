package com.example.youthhub.profile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.UploadFileDialog;
import com.example.youthhub.dashBoard.createPost.JourneyAdapter;
import com.example.youthhub.dashBoard.createPost.TagsJourneyDialog;
import com.example.youthhub.resModel.post.createPost.JourneyList;
import com.example.youthhub.resModel.post.createPost.PrimeTag;
import com.example.youthhub.resModel.post.createPost.Tag;
import com.example.youthhub.resModel.profile.ProfilePicUpload;
import com.example.youthhub.resModel.profile.milestone.ProfileMilestoneListResponse;
import com.example.youthhub.resModel.profile.visualjourney.Journey_Edit.Journey_after_edit_response;
import com.example.youthhub.resModel.profile.visualjourney.Journey_Edit.Journey_edit_response;
import com.example.youthhub.resModel.profile.visualjourney.PrimeTagsItem;
import com.example.youthhub.resModel.profile.visualjourney.ProfileVisualJourneyAddMasterResponse;
import com.example.youthhub.resModel.profile.visualjourney.TagsItem;
import com.example.youthhub.resModel.profile.visualjourney.add.AddJourneyResponse;
import com.example.youthhub.resModel.profile.visualjourney.journeyprofileupload.JourneyProfileUploadResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.filestack.Config;
import com.filestack.FileLink;
import com.filestack.android.FilestackPicker;
import com.filestack.android.FsActivity;
import com.filestack.android.FsConstants;
import com.filestack.android.Selection;
import com.filestack.transforms.tasks.ResizeTask;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

public class AddStepActivity extends AppCompatActivity implements TagsJourneyDialog.PassListItems, AddStepCategoryAdapter.OnPassDataListener {

    private static final String TAG = AddStepActivity.class.getSimpleName();
    private static final int REQUEST_FILESTACK = 107;
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
    EditText tagssss;
    @BindView(R.id.spinner_btn_img)
    ImageView spinnerBtnImg;
    @BindView(R.id.tags_constrain)
    ConstraintLayout tagsConstrain;
    @BindView(R.id.select_media_txt)
    TextView selectMediaTxt;
    @BindView(R.id.upload_img)
    TextView uploadImg;
    @BindView(R.id.select_media_cardView)
    CardView selectMediaCardView;
    @BindView(R.id.apply_btn)
    Button applyBtn;

    Activity activity;

    UploadFileDialog uploadFileDialog;

    String prime_tags = "";

    AddStepCategoryAdapter addStepCategoryAdapter;

    TagsJourneyDialog tagsJourneyDialog;
    List<PrimeTagsItem> selectedPrimeTags = new ArrayList<>();
    @BindView(R.id.image_view)
    CircleImageView imageView;
    // private List<TagsItem> selectedTags = new ArrayList<>();
    private List<com.example.youthhub.resModel.post.createPost.Tag> selectedTags = new ArrayList<>();
    String tag = "";
    String gettag= "";
    boolean aBoolean;
    String J_code;
    Journey_edit_response journey_edit_response;
    String gettagids = "";
    private UploadReceiver uploadReceiver;
    private FileLink fileLink;
/*
    String[] titles = {"Education", "Volunteering", "My Interest", "Event", "Employment", "Training", "Community"};
    int[] titles_icons = {R.drawable.ic_education, R.drawable.ic_volunteer, R.drawable.ic_interest, R.drawable.ic_event, R.drawable.ic_employment, R.drawable.ic_training, R.drawable.ic_community};
*/


    ProfileVisualJourneyAddMasterResponse profileVisualJourneyAddMasterResponse;
    private String imageurl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_step);
        ButterKnife.bind(this);
        callTypeFace();
        getBundle();

        init();


        if(getIntent().getExtras()!=null){

            aBoolean = getIntent().getBooleanExtra("boolen",false);
            J_code = getIntent().getStringExtra("j_code");
            Edit_Journey_details(J_code);
            System.out.println("============getthe" +aBoolean +J_code);

        }


        // Be careful to avoid registering multiple receiver instances
        if (savedInstanceState == null) {
            IntentFilter intentFilter = new IntentFilter(FsConstants.BROADCAST_UPLOAD);
            UploadStatusReceiver receiver = new UploadStatusReceiver();
            LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter);
        }
    }

    private void Edit_Journey_details(String j_code) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<Journey_edit_response> call = ApiClient.getApiInterface().JourneyEditDetails(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), j_code
            );

            call.enqueue(new Callback<Journey_edit_response>() {
                @Override
                public void onResponse(@NonNull Call<Journey_edit_response> call, @NonNull Response<Journey_edit_response> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus()==1) {
                                Journey_edit_response journey_edit_model = response.body();

                                System.out.println("========getthejourney"+response.body().getData().getJourney_info().getJum_code());


                                applyBtn.setText("Update");

                                title.setText(response.body().getData().getJourney_info().getJum_title());
                                subHeading.setText(response.body().getData().getJourney_info().getJum_short_description());
                                description.setText(response.body().getData().getJourney_info().getJum_full_description());
//                                gallery_temp_code = response.body().

                                // tag = response.body().getData().getJourney_info().getJum_tags();

                                gettagids = response.body().getData().getJourney_info().getJum_tags();


                                List<Journey_edit_response.Jum_tags_name> taglist = new ArrayList<>();
                                taglist = response.body().getData().getJum_tags_name();
                                String name = "";
                                for (int i=0;i<taglist.size();i++){
                                    name = name +","+taglist.get(i).getTg_name();

                                    System.out.println("=====namess" +name);
                                    tagssss.setText(name);
                                }
                                gettag = gettagids +"," +tag ;

                                System.out.println("===========gettagitemsid" +gettag);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                //  MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<Journey_edit_response> call, @NonNull Throwable t) {
                    //Deletejourneyy(journey_code);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }

    }


    private void getBundle() {

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
        AppUtils.textAddAstreik(subHeadingTxt, "Short Description");
        AppUtils.textAddAstreik(descriptionTxt, "Description");
    }

    private void init() {
        activity = this;


        uploadFileDialog = new UploadFileDialog(activity, "AddPost");
        call_profile_journey_master_api();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }


    private void call_profile_journey_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileVisualJourneyAddMasterResponse> call = ApiClient.getApiInterface().getJourneyMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity));

            call.enqueue(new Callback<ProfileVisualJourneyAddMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileVisualJourneyAddMasterResponse> call, @NonNull Response<ProfileVisualJourneyAddMasterResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        List<PrimeTagsItem> primeTags = new ArrayList<>();
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileVisualJourneyAddMasterResponse = response.body();
                                String[] titles = new String[profileVisualJourneyAddMasterResponse.getData().getPrimeTags().size()];
                                String[] titles_icons = new String[profileVisualJourneyAddMasterResponse.getData().getPrimeTags().size()];
                                String[] titles_id = new String[profileVisualJourneyAddMasterResponse.getData().getPrimeTags().size()];
                                for (int i = 0; i < profileVisualJourneyAddMasterResponse.getData().getPrimeTags().size(); i++) {
                                    primeTags.add(profileVisualJourneyAddMasterResponse.getData().getPrimeTags().get(i));
                                    titles[i] = profileVisualJourneyAddMasterResponse.getData().getPrimeTags().get(i).getTgName();
                                    titles_icons[i] = profileVisualJourneyAddMasterResponse.getData().getPrimeTags().get(i).getTgIcon();
                                    titles_id[i] = profileVisualJourneyAddMasterResponse.getData().getPrimeTags().get(i).getTgTagId();
                                }

                                primeTags.addAll(profileVisualJourneyAddMasterResponse.getData().getPrimeTags());
                                addStepCategoryAdapter = new AddStepCategoryAdapter(activity, profileVisualJourneyAddMasterResponse.getData().getPrimeTagsPath());

                                //addStepCategoryAdapter = new JourneyAdapter(activity);
                                addStepCategoryAdapter.setOnPassDataListener(AddStepActivity.this::onPassData);


                                categoryRecycler.setAdapter(addStepCategoryAdapter);
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
                                categoryRecycler.setLayoutManager(linearLayoutManager);
                                //  call_setpActivity_adapter(postAddMaster.getPostAddMasterData().getPrimeTags(), postAddMaster.getPostAddMasterData().getPrimeTagsPath());

                                call_setpActivity_adapter(primeTags, profileVisualJourneyAddMasterResponse.getData().getPrimeTagsPath());
                              /*  visualJourneyAdapter = new VisualJourneyAdapter(activity,profileJourneyListResponse);
                                recyclerView.setAdapter(visualJourneyAdapter);
                                visualJourneyAdapter.notifyDataSetChanged();*/
                                Log.d(TAG, "onResponse:profileVisualJourneyAddMasterResponse " + new Gson().toJson(profileVisualJourneyAddMasterResponse));
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileVisualJourneyAddMasterResponse> call, @NonNull Throwable t) {
                    call_profile_journey_master_api();
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    @OnClick({R.id.back, R.id.apply_btn, R.id.tags, R.id.select_media_cardView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.apply_btn:
                validatioaddJourney();
                break;
            case R.id.tags:
                tagsJourneyDialog = new TagsJourneyDialog(activity);
                tagsJourneyDialog.setPassListItems(this);
                tagsJourneyDialog.newTagsInstance(profileVisualJourneyAddMasterResponse.getData().getTags(), selectedTags);
                tagsJourneyDialog.show();
                break;
            case R.id.select_media_cardView:
                //selectImage();
                Log.d(TAG, "onViewClicked: select_media_cardView");
                uploadFileDialog.show();

                break;
        }
    }

    private void validatioaddJourney() {
        String mtitle = title.getText().toString();
        String mdescription = description.getText().toString();
        String mshortdescription = subHeading.getText().toString();
        String mtags = tag;
        String mimageurl = imageurl;
        String mprime_tags = prime_tags;

        if (mtitle.length() > 0) {
            if (mshortdescription.length() > 0) {
                if (mdescription.length() > 0) {

                    if(aBoolean==true){

                        Call_Journey_Edit(J_code,mtitle,mshortdescription,mdescription);

                    }else{
                        call_profile_add_jounrey(mtitle, mshortdescription, mdescription, mtags, mprime_tags, mimageurl);

                    }



                } else {
                    MyToast.errorMessage("Please enter description", activity);
                }
            } else {
                MyToast.errorMessage("Please enter short description", activity);
            }
        } else {
            MyToast.errorMessage("Please enter title", activity);
        }
    }

    private void Call_Journey_Edit(String j_code, String mtitle, String mshortdescription, String mdescription) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<Journey_after_edit_response> call = ApiClient.getApiInterface().Journey_Edit(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), j_code,mtitle,mshortdescription,mdescription,tag,"","");


            call.enqueue(new Callback<Journey_after_edit_response>() {
                @Override
                public void onResponse(@NonNull Call<Journey_after_edit_response> call, @NonNull Response<Journey_after_edit_response> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus()==1) {
                                Journey_after_edit_response journey_edit_l = response.body();

                                System.out.println("=======Sucessssfully updated");
                                finish();

//                                Intent intent = new Intent(activity, ProfileActivity.class);
//                                intent.putExtra(Constants.UserCode, Constants.getUserCode(activity));
//                                intent.putExtra(Constants.UserType, "1");
//                                activity.startActivity(intent);
//                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);



                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                //  MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<Journey_after_edit_response> call, @NonNull Throwable t) {
                    //Deletejourneyy(journey_code);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }










    // Handles user clicking select button, launches the picker UI
    private void selectImage() {
        // For simplicity we're loading credentials from a string res, don't do this in production

        Config config = new Config(Constants.APP_File_Stack_Key, "https://form.samples.android.filestack.com");

        Intent pickerIntent = new Intent(activity, FsActivity.class);
        pickerIntent.putExtra(FsConstants.EXTRA_CONFIG, config);
        // Restrict file selections to just images
        String[] mimeTypes = {"image/*"};
        pickerIntent.putExtra(FsConstants.EXTRA_MIME_TYPES, mimeTypes);
        // activity.startActivity(pickerIntent);
        // Start the activity
        startActivityForResult(pickerIntent, REQUEST_FILESTACK);

/*        Config config = new Config(Constants.APP_File_Stack_Key, "https://form.samples.android.filestack.com");
        FilestackPicker picker = new FilestackPicker.Builder()
                .config(config)
                    .storageOptions()
                    .config(...)
                    .autoUploadEnabled(...)
                    .sources(...)
                    .mimeTypes(...)
                    .multipleFilesSelectionEnabled(...)
                    .displayVersionInformation(...)
                    .build();

        picker.launch(activity);*/
    }

    @Override
    public void onPassData(PrimeTagsItem primeTag) {
        int num;
        boolean itemTheir = false;
        if (selectedPrimeTags.size() == 0) {
            selectedPrimeTags.add(primeTag);
        } else {
            num = selectedPrimeTags.size();
            for (int i = 0; i < num; i++) {
                if (selectedPrimeTags.get(i).getTgTagId().equals(primeTag.getTgTagId())) {
                    selectedPrimeTags.remove(i);
                    itemTheir = false;
                    break;
                } else {
                    itemTheir = true;
                }
            }
            if (itemTheir) {
                selectedPrimeTags.add(primeTag);
            }
        }
        setPrimeTags(selectedPrimeTags);
    }

    private void setPrimeTags(List<PrimeTagsItem> primeTags) {
        String tags = "";
        for (int i = 0; i < primeTags.size(); i++) {
            if (tags.equals("")) {
                tags = primeTags.get(i).getTgName();
                prime_tags = primeTags.get(i).getTgTagId();
            } else {
                tags = tags + "," + primeTags.get(i).getTgName();
                prime_tags = prime_tags + "," + primeTags.get(i).getTgTagId();
            }
        }
    }

    private void call_setpActivity_adapter(List<PrimeTagsItem> primeTags, String primeTagsPath) {
        addStepCategoryAdapter.addAll(primeTags, primeTagsPath, selectedPrimeTags);
    }

    // Receives upload broadcasts from SDK service
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
    }

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FILESTACK && resultCode == RESULT_OK) {
            Log.d(TAG, "received filestack selections");
            String key = FsConstants.EXTRA_SELECTION_LIST;
            ArrayList<Selection> selections = data.getParcelableArrayListExtra(key);
            for (int i = 0; i < selections.size(); i++) {
                Selection selection = selections.get(i);
                String msg = String.format(Locale.getDefault(), "selection %d: %s", i, selection.getName());
                Log.d(TAG, msg);
            }
        }

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constants.CAMERA_REQUEST:
                    File file = new File(getFilesDir(), "newImage.jpg");
                    Log.d("", "FileUpload : " + file.getName());
                    call_profile_upload_api(file);
                    break;
                case Constants.GALLERY_REQUEST:
                    Uri selectedFileURI = data.getData();
                    File file1 = new File(AppUtils.getPath(selectedFileURI, activity));
                    Log.d("", "FileUpload : " + file1.getName());
                    call_profile_upload_api(file1);
                    break;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // If MainActivity contains a FileLink when the fragment resumes, load the image from it
        // So in this case we check the activity for data, rather than have it push to the fragment
        FileLink fileLink = ((AddStepActivity) activity).getFileLink();
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
    public void TagsPassData(List<Tag> tags) {
        this.selectedTags = tags;
        String tagss = "";
        for (int i = 0; i < tags.size(); i++) {
            if (tagss.equals("")) {
                tagss = tags.get(i).getTgName();
                tag = tags.get(i).getTgTagId();
            } else {
                tagss = tagss + "," + tags.get(i).getTgName();
                tag = tag + "," + tags.get(i).getTgTagId();
            }
        }
        tagssss.setText(tagss);
    }

    @Override
    public void TagsItemPassData(List<TagsItem> tagsList) {


    }

    @Override
    public void JourneyPassData(List<JourneyList> journeyLists) {

    }

    private void call_profile_upload_api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("userfile", file.getName(), requestFile);

            Call<JourneyProfileUploadResponse> call = ApiClient.getApiInterface().getVisualJourneyImage(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    body);

            Log.d(TAG, "onResponse: call_profile_upload_api");
            call.enqueue(new Callback<JourneyProfileUploadResponse>() {
                @Override
                public void onResponse(@NonNull Call<JourneyProfileUploadResponse> call, @NonNull Response<JourneyProfileUploadResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                uploadFileDialog.closeDialog();
                                JourneyProfileUploadResponse profilePicUpload = response.body();
                                Log.d(TAG, "onResponse: call_profile_upload_api" + profilePicUpload.getData().getPathThumb() + profilePicUpload.getData().getFilename() + Constants.getAccessKey(activity));
                                uploadImg.setText(profilePicUpload.getData().getFilename());
                             /*   imageurl = profilePicUpload.getData().getFilename();
                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, profilePicUpload.getData().getPathThumb() + profilePicUpload.getData().getFilename()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(imageView);*/
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProPicUpload", response.toString());
                    }
                    Log.d(TAG, "onResponse: " + new Gson().toJson(response.body()));
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<JourneyProfileUploadResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ProPicUpload", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }


    private void call_profile_add_jounrey(String mtitle, String mshort_description, String mdescription, String mtags, String mprime_tags, String mgallery_temp_code) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<AddJourneyResponse> call = ApiClient.getApiInterface().getAddJourney(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), mtitle, mshort_description, mdescription, mtags, mprime_tags,
                    mgallery_temp_code);

            call.enqueue(new Callback<AddJourneyResponse>() {
                @Override
                public void onResponse(@NonNull Call<AddJourneyResponse> call, @NonNull Response<AddJourneyResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage("Journey created successfully", activity);
                                finish();
                            } else {


                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<AddJourneyResponse> call, @NonNull Throwable t) {
                    //  call_profile_add_jounrey(userCode);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }
}
