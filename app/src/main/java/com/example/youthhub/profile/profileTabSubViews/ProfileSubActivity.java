package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.BasicResponse;
import com.example.youthhub.resModel.profile.ProfileYouthInfoResponse;
import com.example.youthhub.resModel.profile.attachcv.ProfileAttachCVMasterResponse;
import com.example.youthhub.resModel.profile.attachcv.add.ProfileAttachAddResponse;
import com.example.youthhub.resModel.profile.attachcv.upload.ProfileResumeUploadResponse;
import com.example.youthhub.resModel.profile.interest.ProfileInterestAddResponse;
import com.example.youthhub.resModel.profile.language.ProfileLanguageAddResponse;
import com.example.youthhub.resModel.profile.profileawards.ProfileAwardsAddResponse;
import com.example.youthhub.resModel.profile.profileeducation.ProfileAddEducationResponse;
import com.example.youthhub.resModel.profile.profileeducation.update.ProfileUpdateEducationResponse;
import com.example.youthhub.resModel.profile.profileexperience.add.ProfileExperienceAddResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.profiletestmonial.TestimonialResponse;
import com.example.youthhub.resModel.profile.profilewishlist.WishlistAddResponse;
import com.example.youthhub.resModel.profile.technicalskill.ProfileTechnicalSkillAddResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.ProfileAddVolunteerResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.ImageFilePath;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;

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

import static com.example.youthhub.profile.ProfileFragment.TAG_TESTMONIALS_MASTER;
import static com.example.youthhub.profile.ProfileFragment.TAG_WISHLIST_SELECT;

public class ProfileSubActivity extends AppCompatActivity implements WishListAddDialog.OnPassDataListener,
        TestimonialReqDialog.OnPassDataListener, EducationDialog.OnPassDataListener, VolunteerDialog.OnPassDataListener,
        ExperienceDialog.OnPassDataListener, AwardsDialog.OnPassDataListener, CvDialog.OnPassDataListener,
        TechnicalSkillsDialog.OnPassDataListener, InterestDialog.OnPassDataListener, LanguageDialog.OnPassDataListener, WishListAdapter.OnPassDataListener {


    private static final String TAG = ProfileSubActivity.class.getSimpleName();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.activity_title)
    TextView activityTitle;
    @BindView(R.id.dialog_show_btn)
    TextView dialogShowBtn;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.no_img)
    ImageView NoImg;

    String IntentName;
    WishListAdapter wishListAdapter;
    TestimonialAdapter testimonialAdapter;
    ExperienceAdapter experienceAdapter;
    EducationAdapter educationAdapter;
    VolunteerAdapter volunteerAdapter;
    SkillsAdapter skillsAdapter;
    AwardsAdapter awardsAdapter;
    CvAdapter cvAdapter;
    TechSkillsAdapter techSkillsAdapter;
    InterestDialog interestDialog;


    boolean mb = false;
    ProfileAddMasterResponse profileAddMasterResponse = new ProfileAddMasterResponse();
    TestimonialResponse testimonialResponse = new TestimonialResponse();
    ProfileAttachCVMasterResponse profileAttachCVMasterResponse;
    ProfileInfoResp profileInfoResp = new ProfileInfoResp();
    List<ProfileYouthInfoResponse.ProfileYouthData.JobWishlist> job_wishlist = new ArrayList<>();
    @BindView(R.id.txt_no_data)
    TextView txtNoData;

    Activity activity;
    private String mwishlistid = null;
    private boolean mfilter = false;
    private WishlistAddResponse wishlistAddResponse;
    private BasicResponse basicResponse;
    private ProfileAddEducationResponse profileAddEducationResponse;
    private ProfileAddVolunteerResponse profileAddVolunteerResponse;
    private ProfileExperienceAddResponse profileExperienceAddResponse;
    private ProfileAwardsAddResponse profileAwardsAddResponse;
    private ProfileAttachAddResponse attachAddResponse;
    private ProfileTechnicalSkillAddResponse profileTechnicalSkillAddResponse;
    private ProfileInterestAddResponse profileInterestAddResponse;
    private ProfileLanguageAddResponse profileLanguageAddResponse;

    //Testmonial
    String mtestmonialprovider = null, memail_edt = null, morganisation_edt = null, mcomment_edt = null, mproviderID = null;

    //Education
    String mregionId = null, morganizationCategoryId = null, mnceaId = null, mqualificationCategoryId = null, mquaProviderId = null,
            mquaTitlePassId = null,
            mtitleQualificationId = null, mstartDateId = null, mendDateId = null, mqualificationedt = null, mqualificationId = null, isprocessedu = null;

    //Volunteer
    private String misinprocess = "0";
    private String mvolcatId = null;
    private String mrolettxt = null;
    private String mstartDatetxt = null;
    private String mendDatetxt = null;
    private String morganisationtxt = null;
    private String mdescriptiontxt = null;

    //Experience
    private String mestartDatetxt = null;
    private String meendDatetxt = null;
    private String mjobDesignationtxt = null;
    private String mjobTitletxt = null;
    private String mjobTypeId = null;
    private String mjobDescriptiontxt = null;
    private String mresponability = null;
    private String meisinprocess = "0";
    private String mjobId = null;

    //Awards
    private String mawardsid = null;
    private String mtitletxt = null;
    private String moccupationtxt = null;
    private String madescriptiontxt = null;
    private String missuedBytxt = null;
    private String mdateSpinnertxt = null;

    //Attach Cv
    private String mtypemasterId = null;
    private String mcvtitletxt = null;
    private String mimage = null;
    private String mcvId = null;

    //Technical Skill
    private String mskilltxt = null;
    private String mleveltxt = null;

    //Interest
    private String minteresttxt = null;


    //Language
    private String mlanguageId = null;
    private String mprofitiencyId = null;
    private ProfileUpdateEducationResponse profileUpdateEducationResponse;
    private int mposition;
    private CvDialog cvDialog;
    private String UserType = "";

    public ProfileSubActivity() {
    }


    @OnClick({R.id.back_constrain, R.id.back, R.id.dialog_show_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_constrain:
            case R.id.back:
                onBackPressed();
                break;
            case R.id.dialog_show_btn:
                switch (IntentName) {
                    case "WishList":
                        WishListAddDialog wishListAddDialog = new WishListAddDialog(this, profileAddMasterResponse);
                        wishListAddDialog.setOnPassDataListener(this);
                        wishListAddDialog.show();
                        break;
                    case "Testimonial":
                        TestimonialReqDialog testimonialReqDialog = new TestimonialReqDialog(this, testimonialResponse);
                        testimonialReqDialog.setOnPassDataListener(this);
                        testimonialReqDialog.show();
                        break;
                    case "Experience":
                        ExperienceDialog experienceDialog = new ExperienceDialog(this, profileAddMasterResponse, false);
                        experienceDialog.setOnPassDataListener(this);
                        experienceDialog.show();
                        break;
                    case "Education":
                        EducationDialog educationDialog = new EducationDialog(this, profileAddMasterResponse, false);
                        educationDialog.setOnPassDataListener(this);
                        educationDialog.show();
                        break;
                    case "Volunteering Experience":
                        VolunteerDialog volunteerDialog = new VolunteerDialog(this, profileAddMasterResponse, false);
                        volunteerDialog.setOnPassDataListener(this);
                        volunteerDialog.show();
                        break;
                    case "Skills":
                        TestimonialReqDialog SkillsReqDialog = new TestimonialReqDialog(this, testimonialResponse);
                        SkillsReqDialog.setOnPassDataListener(this);
                        SkillsReqDialog.show();
                        break;
                    case "Achievement and Awards":
                        AwardsDialog awardsDialog = new AwardsDialog(this);
                        awardsDialog.setOnPassDataListener(this);
                        awardsDialog.show();
                        break;
                    case "Attach CV":
                        CvDialog cvDialog = new CvDialog(this, profileAttachCVMasterResponse);
                        cvDialog.setOnPassDataListener(this);
                        cvDialog.show();
                        break;
                    case "Technical Skills":
                        TechnicalSkillsDialog technicalSkillsDialog = new TechnicalSkillsDialog(this);
                        technicalSkillsDialog.setOnPassDataListener(this);
                        technicalSkillsDialog.show();
                        break;
                    case "Interests":
                        InterestDialog interestsDialog = new InterestDialog(this);
                        interestsDialog.setOnPassDataListener(this);
                        interestsDialog.show();
                        break;
                    case "Languages":
                        LanguageDialog languagesDialog = new LanguageDialog(this, profileAddMasterResponse, false);
                        languagesDialog.setOnPassDataListener(this);
                        languagesDialog.show();
                        break;
                }
                break;
        }
    }

    private void switchAdapter(String intentName) {
        switch (intentName) {
            case "WishList":
                activityTitle.setText("JobWishlist");
                dialogShowBtn.setText("Add");
                call_profile_master_api("wishlist");
                wishListAdapter = new WishListAdapter(this, profileInfoResp, UserType);
                recyclerView.setAdapter(wishListAdapter);
                LinearLayoutManager wishList_LayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(wishList_LayoutManager);
                if (profileInfoResp.getData().getJobWishlist().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_no_wishlist);
                    txtNoData.setText("To get relevant suggested jobs add your wishlists.\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);


                    wishListAdapter.notifyDataSetChanged();
                }
                wishListAdapter.setOnPassDataListener(this);
                break;
            case "Testimonial":
                activityTitle.setText("Testimonial");
                dialogShowBtn.setText("Request");
                if (profileInfoResp.getData().getTestimonials().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_testi);
                    txtNoData.setText("Get noticed fast. Employers are 30% more likely to engage with your profile if you have 2 or more testimonials\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);
                    testimonialAdapter = new TestimonialAdapter(this, profileInfoResp, UserType);
                    recyclerView.setAdapter(testimonialAdapter);
                    LinearLayoutManager testimonial_LayoutManager = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(testimonial_LayoutManager);
                    testimonialAdapter.notifyDataSetChanged();
                }

                break;
            case "Experience":
                activityTitle.setText("Experience");
                dialogShowBtn.setText("Add");
                call_profile_master_api("workexperience");

                experienceAdapter = new ExperienceAdapter(activity, profileInfoResp, profileAddMasterResponse, UserType);
                recyclerView.setAdapter(experienceAdapter);
                LinearLayoutManager experience_LayoutManager = new LinearLayoutManager(activity);
                recyclerView.setLayoutManager(experience_LayoutManager);

                if (profileInfoResp.getData().getExperience().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_exp);
                    txtNoData.setText("List your work experiences, add different positions and describe your responsibilities. Don't forget to highlight your key responsibilities and biggest achievements.\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);
                    experienceAdapter.notifyDataSetChanged();
                }
                break;



            case "Education":
                activityTitle.setText("Education");
                dialogShowBtn.setText("Add");
                call_profile_master_api("education");

                educationAdapter = new EducationAdapter(activity, profileInfoResp, profileAddMasterResponse, UserType);
                LinearLayoutManager education_LayoutManager = new LinearLayoutManager(activity);
                recyclerView.setLayoutManager(education_LayoutManager);
                recyclerView.setAdapter(educationAdapter);
                educationAdapter.notifyDataSetChanged();

                if (profileInfoResp.getData().getEducation().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_edu);
                    txtNoData.setText("Add your Education Journey.");
                } else {

                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);
                }
                break;


            case "Volunteering Experience":
                activityTitle.setText("Volunteering Experience");
                dialogShowBtn.setText("Add");
                call_profile_master_api("volunteering");

                volunteerAdapter = new VolunteerAdapter(activity, profileInfoResp, profileAddMasterResponse, UserType);
                LinearLayoutManager volunteer_LayoutManager = new LinearLayoutManager(activity);
                recyclerView.setLayoutManager(volunteer_LayoutManager);
                recyclerView.setAdapter(volunteerAdapter);
                volunteerAdapter.notifyDataSetChanged();

                if (profileInfoResp.getData().getVolunteering().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_vol);
                    txtNoData.setText("Volunteer work can be an excellent way to showcase key skills such as event planning, fundraising, or problem-solving.\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);
                }

                break;


            case "Skills":
                activityTitle.setText("Skills");
                dialogShowBtn.setText("Request");
                if (profileInfoResp.getData().getSkills().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_skills);
                    txtNoData.setText("Get endorsed for key soft skills.\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);
                    skillsAdapter = new SkillsAdapter(this, profileInfoResp);
                    recyclerView.setAdapter(skillsAdapter);
                    LinearLayoutManager skills_LayoutManager = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(skills_LayoutManager);
                    skillsAdapter.notifyDataSetChanged();
                }

                break;
            case "Achievement and Awards":
                activityTitle.setText("Achievement and Awards");
                dialogShowBtn.setText("Add");
                awardsAdapter = new AwardsAdapter(this, profileInfoResp, UserType);
                recyclerView.setAdapter(awardsAdapter);
                LinearLayoutManager awards_LayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(awards_LayoutManager);
                awardsAdapter.notifyDataSetChanged();


                if (profileInfoResp.getData().getAchievement().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_exp);
                    txtNoData.setText("Listing achievements on your resume highlights your strengths and growth to potential employers. Accomplishments can include any professional, educational or personal milestones you have achieved.\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);

                }

                break;
            case "Attach CV":
                activityTitle.setText("Attach Cv");
                dialogShowBtn.setText("Add");
                call_profile_cv_master_api();
                break;


            case "Technical Skills":
                activityTitle.setText("Technical Skills");
                dialogShowBtn.setText("Add");
                call_profile_master_api("Technical Skills");

                techSkillsAdapter = new TechSkillsAdapter(this, profileInfoResp, "Technical Skills", UserType);
                recyclerView.setAdapter(techSkillsAdapter);
                LinearLayoutManager techSkills_LayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(techSkills_LayoutManager);
                techSkillsAdapter.notifyDataSetChanged();

                if (profileInfoResp.getData().getTechnicalSkills().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_tech);
                    txtNoData.setText("Technical skills include the ability to use specialized software or operate specific machinery, equipment, and tools. They require specialized knowledge. Examples are MS office, Programming Skills or Social media skills.\n" +
                            "\n");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);

                }

                break;

            case "Interests":
                activityTitle.setText("Interests");
                dialogShowBtn.setText("Add");
                call_profile_master_api("Interests");

                techSkillsAdapter = new TechSkillsAdapter(this, profileInfoResp, "Interests", UserType);
                LinearLayoutManager techSkills_Layoutanager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(techSkills_Layoutanager);
                recyclerView.setAdapter(techSkillsAdapter);
                techSkillsAdapter.notifyDataSetChanged();


                if (profileInfoResp.getData().getInterests().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_int);
                    txtNoData.setText("Showcase your casual side and let employers know how you'd be a good cultural fit.");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);


                }

                break;


            case "Languages":
                activityTitle.setText("Languages");
                dialogShowBtn.setText("Add");
                call_profile_master_api("languages");

                techSkillsAdapter = new TechSkillsAdapter(activity, profileInfoResp, "Languages", UserType);
                LinearLayoutManager techSkills_LaoutManager = new LinearLayoutManager(activity);
                recyclerView.setLayoutManager(techSkills_LaoutManager);
                recyclerView.setAdapter(techSkillsAdapter);
                techSkillsAdapter.notifyDataSetChanged();
                if (profileInfoResp.getData().getLanguage().size() == 0) {
                    recyclerView.setVisibility(View.GONE);
                    txtNoData.setVisibility(View.VISIBLE);
                    NoImg.setVisibility(View.VISIBLE);
                    NoImg.setImageResource(R.drawable.yh_2_n_lang);
                    txtNoData.setText("If you know foreign languages, include them in this section.");
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                    txtNoData.setVisibility(View.GONE);
                    NoImg.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 1:

                if (resultCode == RESULT_OK) {
                    Uri selectedFileURI = data.getData();
                    File file = new File(ImageFilePath.getPath(activity,selectedFileURI));
                    Log.d("ProfileSubActivity", "FileUpload : " + file.getName());
                    call_Api(file);
                }
                break;

        }
    }

    private void call_Api(File file) {
        if (NetWorkUtil.isNetworkConnected(activity)) ;
        {
            Loader.showLoad(activity, true);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            final MultipartBody.Part body = MultipartBody.Part.createFormData("cv_file", file.getName(), requestFile);

            Call<ProfileResumeUploadResponse> call = ApiClient.getApiInterface().getUploadResumeFile(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), body);
            call.enqueue(new Callback<ProfileResumeUploadResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileResumeUploadResponse> call, @NonNull Response<ProfileResumeUploadResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                mimage = response.body().getData().getFileName();

                                cvDialog.getData(mimage, body);
                                MyToast.normalMessage(mimage+" file Upload successfully !!!",activity);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse, response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileResumeUploadResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse, t.toString());
                    Loader.showLoad(activity, false);
                    MyToast.normalMessage(t.toString(), activity);
                }
            });
        }
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_sub);
        ButterKnife.bind(this);
        activity = this;
        cvDialog = new CvDialog(activity);
        callTypeFace();
        getBundle();
        if (getIntent().getExtras() != null) {
            IntentName = getIntent().getStringExtra("IntentName");
        }
        switchAdapter(IntentName);

        Log.d(TAG, "onCreate: profileAddMasterResponse" + new Gson().toJson(profileAddMasterResponse));
    }


    private void getBundle() {

        //profileAddMasterResponse = new ProfileAddMasterResponse();
        try {

            if (getIntent().getExtras() != null) {
               /* if (getIntent().getExtras().getParcelable(TAG_ADDMASTER) != null) {
                    profileAddMasterResponse = getIntent().getParcelableExtra(TAG_ADDMASTER);
                    Log.d(TAG, "getBundle: " + new Gson().toJson(profileAddMasterResponse));
                } else {0
                    Log.d(TAG, "getBundle:else " + new Gson().toJson(profileAddMasterResponse));
                }*/
                if (getIntent().getParcelableExtra(TAG_WISHLIST_SELECT) != null) {
                    profileInfoResp = getIntent().getParcelableExtra(TAG_WISHLIST_SELECT);
                    Log.d(TAG, "getBundle:profileYouthInfoResponse " + new Gson().toJson(profileInfoResp));
                } else {
                    Log.d(TAG, "getBundle:profileYouthInfoResponse else " + new Gson().toJson(profileInfoResp));
                }
                if (getIntent().getExtras().getParcelable(TAG_TESTMONIALS_MASTER) != null) {
                    testimonialResponse = getIntent().getParcelableExtra(TAG_TESTMONIALS_MASTER);
                    Log.d(TAG, "getBundle: " + new Gson().toJson(testimonialResponse));
                } else {
                    Log.d(TAG, "getBundle:else " + new Gson().toJson(testimonialResponse));
                }
                if (getIntent().getStringExtra(Constants.UserType) != null) {
                    UserType = getIntent().getStringExtra(Constants.UserType);
                    if (UserType.equals("6")) {
                        dialogShowBtn.setVisibility(View.GONE);
                    } else if (UserType.equals("1")) {
                        dialogShowBtn.setVisibility(View.VISIBLE);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void call_profile_cv_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAttachCVMasterResponse> call = ApiClient.getApiInterface().attachCVMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity));

            call.enqueue(new Callback<ProfileAttachCVMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAttachCVMasterResponse> call, @NonNull Response<ProfileAttachCVMasterResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAttachCVMasterResponse = response.body();
                                Log.d(TAG, "onResponse:profileAddMasterResponse " + new Gson().toJson(profileAttachCVMasterResponse));
                                //   update_ui(profileInfoResp);
                                if (profileInfoResp.getData().getUserCv().size() == 0) {
                                    recyclerView.setVisibility(View.GONE);
                                    txtNoData.setVisibility(View.VISIBLE);
                                    txtNoData.setText("No Data Found Attach Cv");
                                } else {
                                    recyclerView.setVisibility(View.VISIBLE);
                                    txtNoData.setVisibility(View.GONE);
                                    cvAdapter = new CvAdapter(activity, profileInfoResp, profileAttachCVMasterResponse, UserType);
                                    recyclerView.setAdapter(cvAdapter);
                                    LinearLayoutManager cv_LayoutManager = new LinearLayoutManager(activity);
                                    recyclerView.setLayoutManager(cv_LayoutManager);
                                    cvAdapter.notifyDataSetChanged();
                                }
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profileAddMasterResponse" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAttachCVMasterResponse> call, @NonNull Throwable t) {
                    call_profile_cv_master_api();
                    Log.d(Constants.failureResponse, " ProfilprofileAddMasterResponseeInfo" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_profile_master_api(String type) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAddMasterResponse> call = ApiClient.getApiInterface().getProfileAddMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    type);

            call.enqueue(new Callback<ProfileAddMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAddMasterResponse> call, @NonNull Response<ProfileAddMasterResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAddMasterResponse = response.body();
                                Log.d(TAG, "onResponse:profileAddMasterResponse " + new Gson().toJson(profileAddMasterResponse));
//                                  update_ui(profileInfoResp);
//                                if (type.equals("education")) {
//                                    educationAdapter = new EducationAdapter(activity, profileInfoResp, profileAddMasterResponse, UserType);
//
//                                    if (profileInfoResp.getData().getEducation().size() == 0) {
//                                        recyclerView.setVisibility(View.GONE);
//                                        txtNoData.setVisibility(View.VISIBLE);
//                                        txtNoData.setText("No Data Found Education");
//                                    } else {
//                                        LinearLayoutManager education_LayoutManager = new LinearLayoutManager(activity);
//                                        recyclerView.setLayoutManager(education_LayoutManager);
//                                        recyclerView.setVisibility(View.VISIBLE);
//                                        txtNoData.setVisibility(View.GONE);
//                                        recyclerView.setAdapter(educationAdapter);
//                                        educationAdapter.notifyDataSetChanged();
//
//                                    }
//                                } else if (type.equals("volunteering")) {
//                                    volunteerAdapter = new VolunteerAdapter(activity, profileInfoResp, profileAddMasterResponse, UserType);
//
//                                    if (profileInfoResp.getData().getVolunteering().size() == 0) {
//                                        recyclerView.setVisibility(View.GONE);
//                                        txtNoData.setVisibility(View.VISIBLE);
//                                        txtNoData.setText("No Data Found Volunteering Experience");
//                                    } else {
//                                        LinearLayoutManager volunteer_LayoutManager = new LinearLayoutManager(activity);
//                                        recyclerView.setLayoutManager(volunteer_LayoutManager);
//                                        recyclerView.setVisibility(View.VISIBLE);
//                                        txtNoData.setVisibility(View.GONE);
//                                        recyclerView.setAdapter(volunteerAdapter);
//                                        volunteerAdapter.notifyDataSetChanged();
//                                    }
//                                } else if (type.equals("workexperience")) {
//
//                                    experienceAdapter = new ExperienceAdapter(activity, profileInfoResp, profileAddMasterResponse, UserType);
//
//
//                                    if (profileInfoResp.getData().getExperience().size() == 0) {
//                                        recyclerView.setVisibility(View.GONE);
//                                        txtNoData.setVisibility(View.VISIBLE);
//                                        txtNoData.setText("No Data Found Experience");
//                                    } else {
//
//                                        LinearLayoutManager experience_LayoutManager = new LinearLayoutManager(activity);
//
//                                        recyclerView.setLayoutManager(experience_LayoutManager);
//
//                                        recyclerView.setVisibility(View.VISIBLE);
//                                        txtNoData.setVisibility(View.GONE);
//
//                                        recyclerView.setAdapter(experienceAdapter);
//                                        experienceAdapter.notifyDataSetChanged();
//                                    }
//
//
//                                } else if (type.equals("languages")) {
//
//                                    if (profileInfoResp.getData().getLanguage().size() == 0) {
//                                        recyclerView.setVisibility(View.GONE);
//                                        txtNoData.setVisibility(View.VISIBLE);
//                                        txtNoData.setText("No Data Found Languages");
//                                    } else {
//                                        recyclerView.setVisibility(View.VISIBLE);
//                                        txtNoData.setVisibility(View.GONE);
//                                        techSkillsAdapter = new TechSkillsAdapter(activity, profileInfoResp, "Languages", UserType);
//                                        recyclerView.setAdapter(techSkillsAdapter);
//                                        LinearLayoutManager techSkills_LayoutManager = new LinearLayoutManager(activity);
//                                        recyclerView.setLayoutManager(techSkills_LayoutManager);
//                                        techSkillsAdapter.notifyDataSetChanged();
//                                    }
//                                }
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                // MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profileAddMasterResponse" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAddMasterResponse> call, @NonNull Throwable t) {
                    call_profile_master_api(type);
                    Log.d(Constants.failureResponse, "profileAddMasterResponseeInfo" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void callTypeFace() {
        activityTitle.setTypeface(FontTypeFace.fontBold(this));
        dialogShowBtn.setTypeface(FontTypeFace.fontMedium(this));
    }


    private void call_add_wishlist_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<WishlistAddResponse> call = ApiClient.getApiInterface().addWishlist(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mwishlistid
            );

            call.enqueue(new Callback<WishlistAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<WishlistAddResponse> call, @NonNull Response<WishlistAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                wishlistAddResponse = response.body();
                                if (wishlistAddResponse.getData().isAddWishlistStatus()) {
                                    MyToast.normalMessage("Wishlist added successfully", activity);
                                    profileInfoResp.getData().getJobWishlist().add(wishlistAddResponse.getData().getJobWishlist().get(0));
                                    wishListAdapter.notifyDataSetChanged();
                                    recyclerView.setVisibility(View.VISIBLE);
                                    txtNoData.setVisibility(View.GONE);
                                    Log.d(TAG, "onResponse:profileInfoResp " + new Gson().toJson(profileInfoResp.getData().getJobWishlist()));
                                } else {
                                    MyToast.normalMessage("Already added this wishlist", activity);
                                }

                                // MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                //     MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<WishlistAddResponse> call, @NonNull Throwable t) {
                    call_add_wishlist_api(mfilter);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void call_create_testmonial_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<BasicResponse> call = ApiClient.getApiInterface().createTestimonials(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mtestmonialprovider, memail_edt, morganisation_edt, mproviderID, mcomment_edt
            );

            call.enqueue(new Callback<BasicResponse>() {
                @Override
                public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                basicResponse = response.body();
                              /*  profileInfoResp.getData().getTestimonials().add(wishlistAddResponse.getData().getJobWishlist().get(0));
                                wishListAdapter.notifyDataSetChanged();*/
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                    call_create_testmonial_api(mfilter);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void call_create_education_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAddEducationResponse> call = ApiClient.getApiInterface().createEducation(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mregionId, morganizationCategoryId, mquaProviderId, mquaTitlePassId, mqualificationedt, mnceaId
                    , mqualificationCategoryId, mstartDateId, mendDateId, isprocessedu
            );

            call.enqueue(new Callback<ProfileAddEducationResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAddEducationResponse> call, @NonNull Response<ProfileAddEducationResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAddEducationResponse = response.body();
                                profileInfoResp.getData().getEducation().add(profileAddEducationResponse.getData().getEducation().get(0));
                                educationAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Education Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAddEducationResponse> call, @NonNull Throwable t) {
                    call_create_testmonial_api(mfilter);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_create_volunteer_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAddVolunteerResponse> call = ApiClient.getApiInterface().createVolunteer(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mrolettxt, morganisationtxt, mdescriptiontxt, mvolcatId, mstartDatetxt, mendDatetxt
                    , misinprocess);

            call.enqueue(new Callback<ProfileAddVolunteerResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAddVolunteerResponse> call, @NonNull Response<ProfileAddVolunteerResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAddVolunteerResponse = response.body();
                                profileInfoResp.getData().getVolunteering().add(profileAddVolunteerResponse.getData().getVolunteering().get(0));
                                volunteerAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Volunteer Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAddVolunteerResponse> call, @NonNull Throwable t) {
                    call_create_volunteer_api(mfilter);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void call_create_experience_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileExperienceAddResponse> call = ApiClient.getApiInterface().createExperience(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mjobTitletxt, mjobDesignationtxt, mjobDescriptiontxt, mjobTypeId, mestartDatetxt, meendDatetxt
                    , meisinprocess, mresponability);

            call.enqueue(new Callback<ProfileExperienceAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileExperienceAddResponse> call, @NonNull Response<ProfileExperienceAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileExperienceAddResponse = response.body();
                                profileInfoResp.getData().getExperience().add(profileExperienceAddResponse.getData().getExperience().get(0));
                                experienceAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Experience Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileExperienceAddResponse> call, @NonNull Throwable t) {
                    call_create_experience_api(mfilter);
                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_create_awards_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAwardsAddResponse> call = ApiClient.getApiInterface().createAwards(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mtitletxt, moccupationtxt, missuedBytxt, madescriptiontxt, mdateSpinnertxt);

            call.enqueue(new Callback<ProfileAwardsAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAwardsAddResponse> call, @NonNull Response<ProfileAwardsAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileAwardsAddResponse = response.body();
                                profileInfoResp.getData().getAchievement().add(profileAwardsAddResponse.getData().getAchievement().get(0));
                                awardsAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Awards Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_create_awards_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAwardsAddResponse> call, @NonNull Throwable t) {
                    call_create_awards_api(mfilter);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_create_attachCv_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileAttachAddResponse> call = ApiClient.getApiInterface().createAttachCV(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mtypemasterId, mcvtitletxt, mimage);

            call.enqueue(new Callback<ProfileAttachAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileAttachAddResponse> call, @NonNull Response<ProfileAttachAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                attachAddResponse = response.body();
                                profileInfoResp.getData().getUserCv().add(attachAddResponse.getData().getUserCv());
                                cvAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Attach CV Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_create_awards_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileAttachAddResponse> call, @NonNull Throwable t) {
                    call_create_attachCv_api(mfilter);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_create_technicalSkill_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileTechnicalSkillAddResponse> call = ApiClient.getApiInterface().createTechnicalSkill(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mskilltxt, mleveltxt);

            call.enqueue(new Callback<ProfileTechnicalSkillAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileTechnicalSkillAddResponse> call, @NonNull Response<ProfileTechnicalSkillAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileTechnicalSkillAddResponse = response.body();
                                profileInfoResp.getData().getTechnicalSkills().add(profileTechnicalSkillAddResponse.getData().getTechnicalSkills().get(0));
                                techSkillsAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Technical Skill Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_create_awards_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileTechnicalSkillAddResponse> call, @NonNull Throwable t) {
                    call_create_technicalSkill_api(mfilter);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_create_interest_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileInterestAddResponse> call = ApiClient.getApiInterface().createInterest(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    minteresttxt);

            call.enqueue(new Callback<ProfileInterestAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileInterestAddResponse> call, @NonNull Response<ProfileInterestAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileInterestAddResponse = response.body();
                                profileInfoResp.getData().getInterests().add(profileInterestAddResponse.getData().getInterests().get(0));
                                techSkillsAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Interest Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_create_awards_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileInterestAddResponse> call, @NonNull Throwable t) {
                    call_create_interest_api(mfilter);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_create_language_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileLanguageAddResponse> call = ApiClient.getApiInterface().createLanguage(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mlanguageId,mprofitiencyId);

            call.enqueue(new Callback<ProfileLanguageAddResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileLanguageAddResponse> call, @NonNull Response<ProfileLanguageAddResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileLanguageAddResponse = response.body();
                                profileInfoResp.getData().getLanguage().add(profileLanguageAddResponse.getData().getLanguage().get(0));
                                techSkillsAdapter.notifyDataSetChanged();
                                recyclerView.setVisibility(View.VISIBLE);
                                txtNoData.setVisibility(View.GONE);
                                MyToast.normalMessage("Language Added successfully", activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse:failure " + new Gson().toJson(response.body()));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_create_awards_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileLanguageAddResponse> call, @NonNull Throwable t) {
                    call_create_language_api(mfilter);
                    Log.d(Constants.failureResponse, " call_create_awards_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @Override
    public void onPassData(String wishlistid, boolean filter) {
        mwishlistid = wishlistid;
        mfilter = filter;
        call_add_wishlist_api(true);
    }


    @Override
    public void onPassData(String testmonialprovider, String email_edt, String organisation_edt, String comment_edt,
                           String providerID, boolean filter) {
        mtestmonialprovider = testmonialprovider;
        memail_edt = email_edt;
        morganisation_edt = organisation_edt;
        mcomment_edt = comment_edt;
        mproviderID = providerID;
        filter = true;
        call_create_testmonial_api(true);
    }

    @Override
    public void onPassData(String regionId, String organizationCategoryId, String nceaId, String qualificationCategoryId,
                           String quaProviderId, String quaTitlePassId, String titleQualificationId,
                           String startDateId, String endDateId, String qualificationedt,String isprocessedution, boolean b) {
        mregionId = regionId;
        morganizationCategoryId = organizationCategoryId;
        mnceaId = nceaId;
        mqualificationCategoryId = qualificationCategoryId;
        mquaProviderId = quaProviderId;
        mquaTitlePassId = quaTitlePassId;
        mtitleQualificationId = titleQualificationId;
        mstartDateId = startDateId;
        mendDateId = endDateId;
        mqualificationedt = qualificationedt;
        isprocessedu = isprocessedution;
        mb = b;
        call_create_education_api(true);
    }


    @Override
    public void onPassData(String volcatId, String rolettxt, String startDatetxt, String endDatetxt, String organisationtxt, String descriptiontxt, String isinprocess, boolean b) {
        mvolcatId = volcatId;
        mrolettxt = rolettxt;
        mstartDatetxt = startDatetxt;
        mendDatetxt = endDatetxt;
        morganisationtxt = organisationtxt;
        mdescriptiontxt = descriptiontxt;
        misinprocess = isinprocess;
        mb = b;
        call_create_volunteer_api(true);
    }

    @Override
    public void onPassData(String jobTitletxt, String jobTypeId, String jobDesignationtxt, String jobDescriptiontxt, String startDatetxt, String endDatetxt, String isinprocess, String responability, boolean b) {
        mjobTitletxt = jobTitletxt;
        mjobTypeId = jobTypeId;
        mjobDesignationtxt = jobDesignationtxt;
        mjobDescriptiontxt = jobDescriptiontxt;
        mestartDatetxt = startDatetxt;
        meendDatetxt = endDatetxt;
        meisinprocess = isinprocess;
        mresponability = responability;
        mb = b;
        call_create_experience_api(true);
    }

    @Override
    public void onExperiencePassData(String titletxt, String occupationtxt, String descriptiontxt, String dateSpinnertxt, String issuedBytxt, boolean b) {
        mtitletxt = titletxt;
        moccupationtxt = occupationtxt;
        madescriptiontxt = descriptiontxt;
        mdateSpinnertxt = dateSpinnertxt;
        missuedBytxt = issuedBytxt;
        mb = b;
        call_create_awards_api(true);
    }

    @Override
    public void onattachCVPassData(String titletxt, String typemasterId, String image, boolean b) {
        mcvtitletxt = titletxt;
        mtypemasterId = typemasterId;
      //  mimage = image;
        mb = b;
        call_create_attachCv_api(true);
    }

    @Override
    public void onPassData(String skilltxt, String leveltxt, boolean b) {
        mskilltxt = skilltxt;
        mleveltxt = leveltxt;
        mb = b;
        call_create_technicalSkill_api(true);
    }

    @Override
    public void onInterestPassData(String interesttxt, boolean b) {
        minteresttxt = interesttxt;

        mb = b;
        call_create_interest_api(true);
    }

    @Override
    public void onLanguagePassData(String languageId, String profitiencyId, boolean b) {
        mlanguageId = languageId;
        mprofitiencyId = profitiencyId;

        mb = b;
        call_create_language_api(true);
    }

    @Override
    public void passData(boolean deleted, int deletePosition, String which) {
        if (deleted) {
            switch (which) {
                case "wishlist":
                    profileInfoResp.getData().getJobWishlist().remove(deletePosition);
                    wishListAdapter.notifyDataSetChanged();
                    if (profileInfoResp.getData().getJobWishlist().size() <= 0) {
                        // call_comment_list_api(PostCode);
                        recyclerView.setVisibility(View.GONE);
                        txtNoData.setVisibility(View.VISIBLE);
                        txtNoData.setText("No Data Found JobWishList");
                    }
                    break;
                    default:
                        Log.d(TAG, "passData: not match"+which);
                        break;
            }
        }
    }
}