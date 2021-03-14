package com.example.youthhub.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.profile.profileTabSubViews.ExperienceKeyAdapter;
import com.example.youthhub.profile.profileTabSubViews.ProfileSubActivity;
import com.example.youthhub.profile.profileupdate.Data;
import com.example.youthhub.profile.profileupdate.ProfileUpdateResponse;
import com.example.youthhub.resModel.profile.ProfileInfo;
import com.example.youthhub.resModel.profile.ProfileMasterResponse;
import com.example.youthhub.resModel.profile.getInfo.ProfileGetInfoResponse;
import com.example.youthhub.resModel.profile.profileinfo.ProfileInfoResp;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.profiletestmonial.TestimonialResponse;
import com.example.youthhub.resModel.profile.profilewishlist.WishlistAddResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.utils.AppUtils.getStringIsEmpty;
import static com.example.youthhub.utils.Constants.ProfileInfo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment implements ProfileInfoDialog.OnPassDataListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.info_txt)
    TextView infoTxt;
    @BindView(R.id.edit)
    TextView edit;
    @BindView(R.id.region_txt)
    TextView regionTxt;
    @BindView(R.id.region)
    TextView region;
    @BindView(R.id.district_city_txt)
    TextView districtCityTxt;
    @BindView(R.id.district_city)
    TextView districtCity;
    @BindView(R.id.gender_txt)
    TextView genderTxt;
    @BindView(R.id.gender)
    TextView gender;
    @BindView(R.id.destination_txt)
    TextView destinationTxt;
    @BindView(R.id.destination)
    TextView destination;
    @BindView(R.id.profile_info_card)
    CardView profileInfoCard;
    @BindView(R.id.wishlist_txt)
    TextView wishlistTxt;
    @BindView(R.id.wishlist_add_txt)
    TextView wishlistAddTxt;
    @BindView(R.id.wishlist_lists1)
    TextView wishlistLists1;
    @BindView(R.id.wishlist_lists2)
    TextView wishlistLists2;
    @BindView(R.id.wishlist_view_all_txt)
    TextView wishlistViewAllTxt;
    @BindView(R.id.wishlist_card)
    CardView wishlistCard;
    @BindView(R.id.testimonials_txt)
    TextView testimonialsTxt;
    @BindView(R.id.test_request_txt)
    TextView testRequestTxt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.sub_title)
    TextView subTitle;
    @BindView(R.id.mail)
    TextView mail;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.endorsed_txt)
    TextView endorsedTxt;
    @BindView(R.id.endorsed_name)
    TextView endorsedName;
    @BindView(R.id.testimonial_view_all_txt)
    TextView testimonialViewAllTxt;
    @BindView(R.id.testimonial_card)
    CardView testimonialCard;
    @BindView(R.id.exp_txt)
    TextView expTxt;
    @BindView(R.id.exp_edit_txt)
    TextView expEditTxt;
    @BindView(R.id.exp_title)
    TextView expTitle;
    @BindView(R.id.exp_date)
    TextView expDate;
    @BindView(R.id.exp_position)
    TextView expPosition;
    @BindView(R.id.exp_years)
    TextView expYears;
    @BindView(R.id.exp_desc)
    TextView expDesc;
    @BindView(R.id.exp_delete)
    ImageView expDelete;
    @BindView(R.id.exp_view_all_txt)
    TextView expViewAllTxt;
    @BindView(R.id.exp_card)
    CardView expCard;
    @BindView(R.id.education_txt)
    TextView educationTxt;
    @BindView(R.id.education_edit_txt)
    TextView educationEditTxt;
    @BindView(R.id.edu_title)
    TextView eduTitle;
    @BindView(R.id.edu_date)
    TextView eduDate;
    @BindView(R.id.edu_position)
    TextView eduPosition;
    @BindView(R.id.edu_years)
    TextView eduYears;
    @BindView(R.id.edu_desc)
    TextView eduDesc;
    @BindView(R.id.edu_delete)
    ImageView eduDelete;
    @BindView(R.id.education_view_all_txt)
    TextView educationViewAllTxt;
    @BindView(R.id.education_card)
    CardView educationCard;
    @BindView(R.id.volunteer_txt)
    TextView volunteerTxt;
    @BindView(R.id.volunteer_edit_txt)
    TextView volunteerEditTxt;
    @BindView(R.id.volunteer_title)
    TextView volunteerTitle;
    @BindView(R.id.volunteer_date)
    TextView volunteerDate;
    @BindView(R.id.volunteer_position)
    TextView volunteerPosition;
    @BindView(R.id.volunteer_years)
    TextView volunteerYears;
    @BindView(R.id.volunteer_desc)
    TextView volunteerDesc;
    @BindView(R.id.volunteer_delete)
    ImageView volunteerDelete;
    @BindView(R.id.volunteer_view_all_txt)
    TextView volunteerViewAllTxt;
    @BindView(R.id.volunteer_card)
    CardView volunteerCard;
    @BindView(R.id.skills_txt)
    TextView skillsTxt;
    @BindView(R.id.skills_title)
    TextView skillsTitle;
    @BindView(R.id.skills_text1)
    TextView skillsText1;
    @BindView(R.id.skills_text2)
    TextView skillsText2;
    @BindView(R.id.skills_title1)
    TextView skillsTitle1;
    @BindView(R.id.skills_text3)
    TextView skillsText3;
    @BindView(R.id.skills_text4)
    TextView skillsText4;
    @BindView(R.id.skills_view_all_txt)
    TextView skillsViewAllTxt;
    @BindView(R.id.skills_card)
    CardView skillsCard;
    @BindView(R.id.awards_txt)
    TextView awardsTxt;
    @BindView(R.id.awards_edit_txt)
    TextView awardsEditTxt;
    @BindView(R.id.awards_title)
    TextView awardsTitle;
    @BindView(R.id.awards_date)
    TextView awardsDate;
    @BindView(R.id.awards_place)
    TextView awardsPlace;
    @BindView(R.id.awards_recieved)
    TextView awardsRecieved;
    @BindView(R.id.awards_desc)
    TextView awardsDesc;
    @BindView(R.id.awards_delete)
    ImageView awardsDelete;
    @BindView(R.id.awards_view_all_txt)
    TextView awardsViewAllTxt;
    @BindView(R.id.awards_card)
    CardView awardsCard;
    @BindView(R.id.cv_txt)
    TextView cvTxt;

    @BindView(R.id.cv_edit_txt)
    TextView cvEditTxt;
    @BindView(R.id.cv_title)
    TextView cvTitle;
    @BindView(R.id.resume_txt)
    TextView resumeTxt;
    @BindView(R.id.cv_date)
    TextView cvDate;
    @BindView(R.id.cv_title1)
    TextView cvTitle1;
    @BindView(R.id.resume_txt1)
    TextView resumeTxt1;
    @BindView(R.id.cv_date1)
    TextView cvDate1;
    @BindView(R.id.cv_view_all_txt)
    TextView cvViewAllTxt;
    @BindView(R.id.cv_card)
    CardView cvCard;
    @BindView(R.id.tech_skills_txt)
    TextView techSkillsTxt;
    @BindView(R.id.tech_skills_edit_txt)
    TextView techSkillsEditTxt;
    @BindView(R.id.tech_skills_title)
    TextView techSkillsTitle;
    @BindView(R.id.tech_skills_rating)
    TextView techSkillsRating;
    @BindView(R.id.tech_skills_title1)
    TextView techSkillsTitle1;
    @BindView(R.id.tech_skills_rating1)
    TextView techSkillsRating1;
    @BindView(R.id.tech_skills_view_all_txt)
    TextView techSkillsViewAllTxt;
    @BindView(R.id.tech_skills_card)
    CardView techSkillsCard;


    ProfileMasterResponse profileInfoMaster;

    Unbinder unbinder;

    String mfirstName = "";
    String mlastName = "";
    String mdob = "";
    String mgender_update = "";
    String mregionId = "";
    String mcityId = "";
    String mcurrentorgansizationStatusId = "";
    String methnicity = "";
    String mlwi = "";
    String memailId = "";
    String mmoileNo = "";
    String mcurrentWorkStatusId = "";
    String mworkAvailabilityId = "";
    String mworkExperienceId = "";
    String myourAvailabilityWorkperWeek = "";
    String mperferredWorkRegionId = "";
    String mperferrredWorkCityId = "";
    String mfuthurIndentededDesitinationId = "";
    String mLicenceTypeId = "";
    String mresidencyStatusId = "";
    String mvisaTypeId = "";
    String mvisaMonth = "";
    String mvisaYear = "";
    String minstagramUrl = "";
    String mfacebookUrl = "";
    String mtwitterUrl = "";
    String mgoogleplusUrl = "";
    String mlinkeninUrl = "";
    String mgithubUrl = "";
    String mbehanceUrl = "";
    String maboutme = "";
    boolean mfilter = false;

    public static final String TAG = ProfileFragment.class.getSimpleName();
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.exprecycle_responability)
    RecyclerView exprecycleResponability;
    @BindView(R.id.skills_edit_txt)
    TextView skillsEditTxt;
    @BindView(R.id.interests_txt)
    TextView interestsTxt;
    @BindView(R.id.interests_edit_txt)
    TextView interestsEditTxt;
    @BindView(R.id.interests_title)
    TextView interestsTitle;
    @BindView(R.id.interests_rating)
    TextView interestsRating;
    @BindView(R.id.interests_title1)
    TextView interestsTitle1;
    @BindView(R.id.interests_rating1)
    TextView interestsRating1;
    @BindView(R.id.interests_view_all_txt)
    TextView interestsViewAllTxt;
    @BindView(R.id.interests_card)
    CardView interestsCard;
    @BindView(R.id.language_txt)
    TextView languageTxt;
    @BindView(R.id.language_edit_txt)
    TextView languageEditTxt;
    @BindView(R.id.language_title)
    TextView languageTitle;
    @BindView(R.id.language_rating)
    TextView languageRating;
    @BindView(R.id.language_title1)
    TextView languageTitle1;
    @BindView(R.id.language_rating1)
    TextView languageRating1;
    @BindView(R.id.language_view_all_txt)
    TextView languageViewAllTxt;
    @BindView(R.id.language_card)
    CardView languageCard;
    @BindView(R.id.wishlist_view)
    View wishlistView;
    @BindView(R.id.industry_txt)
    TextView industryTxt;
    @BindView(R.id.industry_add_txt)
    TextView industryAddTxt;
    @BindView(R.id.industry_type_txt)
    TextView industryTypeTxt;
    @BindView(R.id.industry_type)
    TextView industryType;
    @BindView(R.id.industry_view)
    View industryView;
    @BindView(R.id.industry_card)
    CardView industryCard;
    @BindView(R.id.contact_txt)
    TextView contactTxt;
    @BindView(R.id.contact_add_txt)
    TextView contactAddTxt;
    @BindView(R.id.persons_txt)
    TextView personsTxt;
    @BindView(R.id.persons)
    TextView persons;
    @BindView(R.id.roles_txt)
    TextView rolesTxt;
    @BindView(R.id.roles)
    TextView roles;
    @BindView(R.id.contact_view)
    View contactView;
    @BindView(R.id.contact_card)
    CardView contactCard;
    @BindView(R.id.liker_img1)
    CircleImageView likerImg1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.liker_img2)
    CircleImageView likerImg2;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.like_count)
    TextView likeCount;
    @BindView(R.id.endorsed_layout)
    ConstraintLayout endorsedLayout;
    @BindView(R.id.testimonial_view)
    View testimonialView;
    @BindView(R.id.txt_keyresponability)
    TextView txtKeyresponability;
    @BindView(R.id.exp_view)
    View expView;
    @BindView(R.id.education_view)
    View educationView;
    @BindView(R.id.volunteer_view)
    View volunteerView;

    @BindView(R.id.skills_layout1)
    ConstraintLayout skillsLayout1;
    @BindView(R.id.liker_img3)
    CircleImageView likerImg3;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.liker_img4)
    CircleImageView likerImg4;
    @BindView(R.id.view5)
    View view5;
    @BindView(R.id.like_count1)
    TextView likeCount1;
    @BindView(R.id.skills_layout2)
    ConstraintLayout skillsLayout2;
    @BindView(R.id.skills_view)
    View skillsView;

    @BindView(R.id.awards_layout)
    ConstraintLayout awardsLayout;
    @BindView(R.id.awards_view)
    View awardsView;
    @BindView(R.id.cv_view)
    View cvView;
    @BindView(R.id.tech_skills_view)
    View techSkillsView;
    @BindView(R.id.interests_view)
    View interestsView;
    @BindView(R.id.language_view)
    View languageView;
    @BindView(R.id.sub_insdustry_txt)
    TextView subInsdustryTxt;
    @BindView(R.id.sub_insdustry)
    TextView subInsdustry;
    @BindView(R.id.profile_info_constrain)
    ConstraintLayout profileInfoConstrain;
    @BindView(R.id.wish_list_constrain)
    ConstraintLayout wishListConstrain;
    @BindView(R.id.testimonial_constrain)
    ConstraintLayout testimonialConstrain;
    @BindView(R.id.exp_constrain)
    ConstraintLayout expConstrain;
    @BindView(R.id.education_constrain)
    ConstraintLayout educationConstrain;
    @BindView(R.id.volunteer_constrain)
    ConstraintLayout volunteerConstrain;
    @BindView(R.id.skills_constrain)
    ConstraintLayout skillsConstrain;
    @BindView(R.id.awards_constrain)
    ConstraintLayout awardsConstrain;
    @BindView(R.id.cv_constrain)
    ConstraintLayout cvConstrain;
    @BindView(R.id.tech_skills_constrain)
    ConstraintLayout techSkillsConstrain;
    @BindView(R.id.interests_constrain)
    ConstraintLayout interestsConstrain;
    @BindView(R.id.language_constrain)
    ConstraintLayout languageConstrain;
    @BindView(R.id.industry_constrain)
    ConstraintLayout industryConstrain;
    @BindView(R.id.contact_constrain)
    ConstraintLayout contactConstrain;

    @BindView(R.id.contact_card1)
    CardView contactCard1;
    @BindView(R.id.cons_testimonial)
    ConstraintLayout consTestimonial;
    @BindView(R.id.testimonial_nodata)
    TextView testimonialNodata;
    @BindView(R.id.test_include_layout)
    LinearLayout testIncludeLayout;
    @BindView(R.id.wishlist_nodata)
    TextView wishlistNodata;
    @BindView(R.id.exp_include_layout)
    LinearLayout expIncludeLayout;
    @BindView(R.id.exp_nodata)
    TextView expNodata;
    @BindView(R.id.education_nodata)
    TextView educationNodata;
    @BindView(R.id.education_include_layout)
    LinearLayout educationIncludeLayout;
    @BindView(R.id.volunteer_nodata)
    TextView volunteerNodata;
    @BindView(R.id.volunteer_include_layout)
    LinearLayout volunteerIncludeLayout;
    @BindView(R.id.skills_nodata)
    TextView skillsNodata;
    @BindView(R.id.awards_nodata)
    TextView awardsNodata;
    @BindView(R.id.awards_include_layout)
    LinearLayout awardsIncludeLayout;
    @BindView(R.id.cv_nodata)
    TextView cvNodata;
    @BindView(R.id.tech_skills_nodata)
    TextView techSkillsNodata;
    @BindView(R.id.interests_nodata)
    TextView interestsNodata;
    @BindView(R.id.language_nodata)
    TextView languageNodata;
    @BindView(R.id.no_wishlist)
    ImageView NoWishlist;
    @BindView(R.id.no_testimonial)
    ImageView NoTestimonial;
    @BindView(R.id.no_exp_img)
    ImageView NoExpImg;
    @BindView(R.id.no_edu_img)
    ImageView NoEduImg;
    @BindView(R.id.no_vol_img)
    ImageView NoVolImg;
    @BindView(R.id.no_skill_img)
    ImageView NoSkillImg;
    @BindView(R.id.no_award_image)
    ImageView NoAwardImage;
    @BindView(R.id.no_cv_image)
    ImageView NoCvImage;
    @BindView(R.id.no_lang_img)
    ImageView NoLangImage;
    @BindView(R.id.no_int_img)
    ImageView NoIntImg;
    @BindView(R.id.no_texh_img)
    ImageView NoTechImg;
 /*   @BindView(R.id.testimonial_linear)
    LinearLayout testimonialLinear;*/


    private ProfileInfo getProfileInfoResponse;
    private String UserType = "";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static final String TAG_WISHLIST = "wishlist";
    public static final String TAG_TESTMONIALS_MASTER = "testmonial_master";
    public static final String TAG_WISHLIST_SELECT = "select_wishlist";
    //  public static final String TAG_ADDMASTER = "add_master";
    private OnFragmentInteractionListener mListener;

    Activity activity;
    ProfileInfoResp profileInfoResp;
    ProfileGetInfoResponse profileGetInfoResponse;
    ProfileAddMasterResponse profileAddMasterResponse;
    TestimonialResponse testimonialResponse;
    ProfileUpdateResponse profileUpdateResponse;
    WishlistAddResponse wishlistAddResponse;
    private String mwishlistid = "";
    private ExperienceKeyAdapter experienceKeyAdapter;
    private String UserCode = "";

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        activity = getActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        //      if (UserType.equals("6")) {
        call_profile_info_api(getProfileInfoResponse.getUmCode(), UserType);
/*        } else if (UserType.equals("1")) {
            call_profile_info_api(getProfileInfoResponse.getUmCode(), UserType);
            edit.setVisibility(View.VISIBLE);
            wishlistAddTxt.setVisibility(View.VISIBLE);
            testRequestTxt.setVisibility(View.VISIBLE);
            expEditTxt.setVisibility(View.VISIBLE);
            educationEditTxt.setVisibility(View.VISIBLE);
            volunteerEditTxt.setVisibility(View.VISIBLE);
            skillsEditTxt.setVisibility(View.VISIBLE);
            awardsEditTxt.setVisibility(View.VISIBLE);
            cvEditTxt.setVisibility(View.VISIBLE);
            techSkillsEditTxt.setVisibility(View.VISIBLE);
            interestsEditTxt.setVisibility(View.VISIBLE);
            languageEditTxt.setVisibility(View.VISIBLE);
            Log.d(TAG, "getBundle1: UserType" + UserType);
        } else {

            call_profile_info_other_api(getProfileInfoResponse.getUmCode(), UserType);
            Log.d(TAG, "getBundle2: UserType" + UserType);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        unbinder = ButterKnife.bind(this, view);
        setTypeFace();
        deleteIconGone();
        getBundle();
        return view;
    }

    private void deleteIconGone() {
        awardsDelete.setVisibility(View.GONE);
        eduDelete.setVisibility(View.GONE);
        expDelete.setVisibility(View.GONE);
        volunteerDelete.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);
    }

    private void getBundle() {
        try {
            Bundle aBundle = getArguments();
            if (aBundle != null) {

                getProfileInfoResponse = getArguments().getParcelable(ProfileInfo);
                UserType = getArguments().getString(Constants.UserType);
                UserCode = getArguments().getString(Constants.UserCode);

                Log.d(TAG, "getBundle: " + new Gson().toJson(getProfileInfoResponse));
                Log.d(TAG, "getBundle: getUmCode" + getProfileInfoResponse.getUmCode());
                Log.d(TAG, "getBundle: getUmCode" + UserCode);
                Log.d(TAG, "getBundle: UserType" + UserType);
                Log.d(TAG, "getBundle: UserCode" + Preference.getInstance(activity).getStr(Constants.UserCode));
                if (UserCode.equals(Preference.getInstance(activity).getStr(Constants.UserCode))){
                    Log.d(TAG, "getBundle: getProfileInfoResponse.getUmCode()" +   Preference.getInstance(activity).getStr(Constants.UserCode));
                    call_profile_info_api(UserCode, UserType);
                    edit.setVisibility(View.VISIBLE);
                    wishlistAddTxt.setVisibility(View.VISIBLE);
                    testRequestTxt.setVisibility(View.VISIBLE);
                    expEditTxt.setVisibility(View.VISIBLE);
                    educationEditTxt.setVisibility(View.VISIBLE);
                    volunteerEditTxt.setVisibility(View.VISIBLE);
                    skillsEditTxt.setVisibility(View.VISIBLE);
                    awardsEditTxt.setVisibility(View.VISIBLE);
                    cvEditTxt.setVisibility(View.VISIBLE);
                    techSkillsEditTxt.setVisibility(View.VISIBLE);
                    interestsEditTxt.setVisibility(View.VISIBLE);
                    languageEditTxt.setVisibility(View.VISIBLE);
                    Log.d(TAG, "getBundle1: UserType" + UserType);
                }
                if (!UserCode.equals(Preference.getInstance(activity).getStr(Constants.UserCode))) {
                    if (UserType.equals("6")) {
                        cvConstrain.setVisibility(View.GONE);
                        call_profile_info_api(UserCode, UserType);
                        Log.d(TAG, "getBundle1: UserType" + UserType);
                    } else if (UserType.equals("1")) {
                        call_profile_info_api(UserCode, UserType);
                        edit.setVisibility(View.VISIBLE);
                        wishlistAddTxt.setVisibility(View.VISIBLE);
                        testRequestTxt.setVisibility(View.VISIBLE);
                        expEditTxt.setVisibility(View.VISIBLE);
                        educationEditTxt.setVisibility(View.VISIBLE);
                        volunteerEditTxt.setVisibility(View.VISIBLE);
                        skillsEditTxt.setVisibility(View.VISIBLE);
                        awardsEditTxt.setVisibility(View.VISIBLE);
                        cvEditTxt.setVisibility(View.VISIBLE);
                        cvConstrain.setVisibility(View.VISIBLE);
                        techSkillsEditTxt.setVisibility(View.VISIBLE);
                        interestsEditTxt.setVisibility(View.VISIBLE);
                        languageEditTxt.setVisibility(View.VISIBLE);
                        Log.d(TAG, "getBundle1: UserType" + UserType);
                    } else {

                        call_profile_info_other_api(UserCode, UserType);
                        Log.d(TAG, "getBundle2: UserType" + UserType);
                    }
                }
                // Log.d(TAG, "getBundle2: UserType" + UserType);
                call_profile_info_master(UserCode);
                // call_profile_master_api(TAG_WISHLIST);
                call_tstmonial_master_api();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTypeFace() {
        infoTxt.setTypeface(FontTypeFace.fontBold(activity));
        wishlistTxt.setTypeface(FontTypeFace.fontBold(activity));

        testimonialsTxt.setTypeface(FontTypeFace.fontBold(activity));
        expTxt.setTypeface(FontTypeFace.fontBold(activity));
        educationTxt.setTypeface(FontTypeFace.fontBold(activity));
        volunteerTxt.setTypeface(FontTypeFace.fontBold(activity));
        skillsTxt.setTypeface(FontTypeFace.fontBold(activity));
        awardsTxt.setTypeface(FontTypeFace.fontBold(activity));
        cvTxt.setTypeface(FontTypeFace.fontBold(activity));
        techSkillsTxt.setTypeface(FontTypeFace.fontBold(activity));
        interestsTxt.setTypeface(FontTypeFace.fontBold(activity));
        languageTxt.setTypeface(FontTypeFace.fontBold(activity));
        industryTxt.setTypeface(FontTypeFace.fontBold(activity));
        contactTxt.setTypeface(FontTypeFace.fontBold(activity));

        wishlistViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        testimonialViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        expViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        educationViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        volunteerViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        skillsViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        awardsViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        cvViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        techSkillsViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        interestsViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));
        languageViewAllTxt.setTypeface(FontTypeFace.fontBold(activity));


        edit.setVisibility(View.INVISIBLE);
        wishlistAddTxt.setVisibility(View.INVISIBLE);
        testRequestTxt.setVisibility(View.INVISIBLE);
        expEditTxt.setVisibility(View.INVISIBLE);
        educationEditTxt.setVisibility(View.INVISIBLE);
        volunteerEditTxt.setVisibility(View.INVISIBLE);
        skillsEditTxt.setVisibility(View.INVISIBLE);
        awardsEditTxt.setVisibility(View.INVISIBLE);
        cvEditTxt.setVisibility(View.INVISIBLE);
        techSkillsEditTxt.setVisibility(View.INVISIBLE);
        interestsEditTxt.setVisibility(View.INVISIBLE);
        languageEditTxt.setVisibility(View.INVISIBLE);
/*        wishlistViewAllTxt.setVisibility(View.GONE);
        testimonialViewAllTxt.setVisibility(View.GONE);
        expViewAllTxt.setVisibility(View.GONE);
        educationViewAllTxt.setVisibility(View.GONE);
        volunteerViewAllTxt.setVisibility(View.GONE);
        skillsViewAllTxt.setVisibility(View.GONE);
        awardsViewAllTxt.setVisibility(View.GONE);
        cvViewAllTxt.setVisibility(View.GONE);
        techSkillsViewAllTxt.setVisibility(View.GONE);
        interestsViewAllTxt.setVisibility(View.GONE);
        languageViewAllTxt.setVisibility(View.GONE);*/


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.edit, R.id.wishlist_add_txt, R.id.wishlist_view_all_txt, R.id.test_request_txt,
            R.id.testimonial_view_all_txt, R.id.exp_edit_txt, R.id.exp_view_all_txt, R.id.education_edit_txt,
            R.id.education_view_all_txt, R.id.volunteer_edit_txt, R.id.volunteer_view_all_txt,
            R.id.skills_view_all_txt, R.id.awards_edit_txt, R.id.awards_view_all_txt, R.id.cv_edit_txt,
            R.id.cv_view_all_txt, R.id.tech_skills_edit_txt, R.id.tech_skills_view_all_txt,
            R.id.skills_edit_txt, R.id.interests_edit_txt, R.id.interests_view_all_txt, R.id.language_edit_txt, R.id.language_view_all_txt})
    public void onViewClicked(View view) {
        Intent intent = new Intent(activity, ProfileSubActivity.class);
        intent.putExtra(Constants.UserType, UserType);
        switch (view.getId()) {
            case R.id.edit:
                if (profileInfoMaster != null) {
                    ProfileInfoDialog profileInfoDialog = new ProfileInfoDialog(activity, UserCode);
                    profileInfoDialog.newInstance(profileInfoMaster);
                    profileInfoDialog.setOnPassDataListener(this);
                    profileInfoDialog.show();

                } else {
                    MyToast.errorMessage("Please wait profile loading", activity);
                }
                break;
            case R.id.wishlist_add_txt:

                // Intent wishListIntent = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "WishList");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.wishlist_view_all_txt:
                //  Intent wishListIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "WishList");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.test_request_txt:
                if (testimonialResponse != null) {
                    //   Intent testimonialIntent = new Intent(activity, ProfileSubActivity.class);
                    intent.putExtra("IntentName", "Testimonial");
                    intent.putExtra(TAG_TESTMONIALS_MASTER, testimonialResponse);
                    intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                } else {
                    MyToast.errorMessage("Please wait profile loading", activity);
                }
                break;
            case R.id.testimonial_view_all_txt:
                if (testimonialResponse != null) {
                    // Intent testimonialIntent1 = new Intent(activity, ProfileSubActivity.class);
                    intent.putExtra("IntentName", "Testimonial");
                    intent.putExtra(TAG_TESTMONIALS_MASTER, testimonialResponse);
                    intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                } else {
                    MyToast.errorMessage("Please wait profile loading", activity);
                }
                break;
            case R.id.exp_edit_txt:
                //Intent expIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Experience");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.exp_view_all_txt:
                //   Intent expIntent2 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Experience");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.education_edit_txt:
                //  Intent eduIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Education");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.education_view_all_txt:
                //  Intent eduIntent2 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Education");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.volunteer_edit_txt:
                //   Intent volunteerIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Volunteering Experience");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.volunteer_view_all_txt:
                //     Intent volunteerIntent2 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Volunteering Experience");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.skills_view_all_txt:
                //  Intent skillsIntent = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Skills");
                intent.putExtra(TAG_TESTMONIALS_MASTER, testimonialResponse);
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.awards_edit_txt:
                //Intent awardsIntent = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Achievement and Awards");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.awards_view_all_txt:
                //      Intent awardsIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Achievement and Awards");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.cv_edit_txt:
                // Intent cvIntent = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Attach CV");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.cv_view_all_txt:
                //     Intent cvIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Attach CV");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.tech_skills_edit_txt:
                //  Intent tech_skillsIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Technical Skills");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.tech_skills_view_all_txt:
                //   Intent tech_skillsIntent2 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Technical Skills");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.skills_edit_txt:
                //  Intent skillsIntent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Skills");
                intent.putExtra(TAG_TESTMONIALS_MASTER, testimonialResponse);
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;

            case R.id.interests_edit_txt:
                // Intent interestsintent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Interests");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;

            case R.id.interests_view_all_txt:
                //    Intent interestsintent2 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Interests");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;

            case R.id.language_edit_txt:
                // Intent languageintent2 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Languages");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;

            case R.id.language_view_all_txt:
                // Intent languageintent1 = new Intent(activity, ProfileSubActivity.class);
                intent.putExtra("IntentName", "Languages");
                intent.putExtra(TAG_WISHLIST_SELECT, profileInfoResp);
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;

        }
    }

    private void call_profile_info_master(String userCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileMasterResponse> call = ApiClient.getApiInterface().getProfileInfoMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    userCode);

            call.enqueue(new Callback<ProfileMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileMasterResponse> call, @NonNull Response<ProfileMasterResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileInfoMaster = response.body();
                                Log.d(TAG, "onResponse:ProfileInfoDialog " + new Gson().toJson(profileInfoMaster));
                                //       update_ui(profileInfoMaster);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                        Loader.showLoad(activity, false);
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileMasterResponse> call, @NonNull Throwable t) {
                    call_profile_info_master(userCode);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_profile_info_other_api(String userCode, String userType) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileGetInfoResponse> call = ApiClient.getApiInterface().getProfileInfoOther(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    userCode);

            call.enqueue(new Callback<ProfileGetInfoResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileGetInfoResponse> call, @NonNull Response<ProfileGetInfoResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileGetInfoResponse = response.body();
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse "+new Gson().toJson(profileInfoResp));

                                updated_another_Ui(profileGetInfoResponse);

                            } else {
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
                public void onFailure(@NonNull Call<ProfileGetInfoResponse> call, @NonNull Throwable t) {
                    call_profile_info_other_api(userCode, UserType);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_profile_info_api(String userCode, String userType) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileInfoResp> call = ApiClient.getApiInterface().getYouthProfileInfo(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    userCode);

            call.enqueue(new Callback<ProfileInfoResp>() {
                @Override
                public void onResponse(@NonNull Call<ProfileInfoResp> call, @NonNull Response<ProfileInfoResp> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileInfoResp = response.body();
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse "+new Gson().toJson(profileInfoResp));
                                Log.d(TAG, "onResponse: call_profile_info_api");
                                update_ui(profileInfoResp);

                            } else {
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
                public void onFailure(@NonNull Call<ProfileInfoResp> call, @NonNull Throwable t) {
                    call_profile_info_api(userCode, UserType);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_profile_getinfo_api(String userCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileGetInfoResponse> call = ApiClient.getApiInterface().getProfileInfoOther(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    userCode);

            call.enqueue(new Callback<ProfileGetInfoResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileGetInfoResponse> call, @NonNull Response<ProfileGetInfoResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileGetInfoResponse = response.body();
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse "+new Gson().toJson(profileInfoResp));
                                update_ui(profileGetInfoResponse);
                            } else {
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
                public void onFailure(@NonNull Call<ProfileGetInfoResponse> call, @NonNull Throwable t) {
                    call_profile_getinfo_api(userCode);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void update_ui(ProfileGetInfoResponse profileGetInfoResponse) {

    }


    private void call_tstmonial_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<TestimonialResponse> call = ApiClient.getApiInterface().testmonialMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity));

            call.enqueue(new Callback<TestimonialResponse>() {
                @Override
                public void onResponse(@NonNull Call<TestimonialResponse> call, @NonNull Response<TestimonialResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                testimonialResponse = response.body();
                                Log.d(TAG, "onResponse:profileAddMasterResponse " + new Gson().toJson(testimonialResponse));
                                //   update_ui(profileInfoResp);
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
                public void onFailure(@NonNull Call<TestimonialResponse> call, @NonNull Throwable t) {
                    call_tstmonial_master_api();
                    Log.d(Constants.failureResponse, " ProfilprofileAddMasterResponseeInfo" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_profile_info_update_api(boolean mfilter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileUpdateResponse> call = ApiClient.getApiInterface().updateProfileInfo(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    mfirstName,
                    mlastName,
                    mdob,
                    mgender_update,
                    mregionId,
                    mcityId,
                    memailId,
                    mcurrentorgansizationStatusId,
                    methnicity,
                    mlwi,
                    mmoileNo,
                    mcurrentWorkStatusId,
                    mworkAvailabilityId,
                    mworkExperienceId,
                    myourAvailabilityWorkperWeek,
                    mperferredWorkRegionId,
                    mperferrredWorkCityId,
                    mresidencyStatusId,
                    mvisaTypeId, mvisaMonth,
                    mvisaYear,
                    minstagramUrl,
                    mfacebookUrl,
                    mtwitterUrl,
                    mgoogleplusUrl,
                    mlinkeninUrl,
                    mgithubUrl, mbehanceUrl,
                    maboutme,
                    mfuthurIndentededDesitinationId,
                    mLicenceTypeId
            );

            call.enqueue(new Callback<ProfileUpdateResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileUpdateResponse> call, @NonNull Response<ProfileUpdateResponse> response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse:ProfileYouthInfoResponse " + new Gson().toJson(response.body()));
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileUpdateResponse = response.body();
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse "+new Gson().toJson(profileInfoResp));
                                profileInfoMaster.getData().setYouthInfo(Data.getProfileInfo());

                               ProfileInfoDialog.dismissDialog();
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " profile_info_update" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileUpdateResponse> call, @NonNull Throwable t) {
                    //call_profile_info_update_api(mfilter);

                    Log.d(Constants.failureResponse, " profile_info_update" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

    private void updated_another_Ui(ProfileGetInfoResponse profileGetInfoResponse) {
   /*     Log.d(TAG, "updated_another_Ui: ");
        profileInfoCard.setVisibility(View.VISIBLE);
        edit.setVisibility(View.INVISIBLE);
        if (UserType.equals("5")) {
            industryCard.setVisibility(View.GONE);
            contactCard.setVisibility(View.GONE);
            contactCard.setVisibility(View.GONE);
            gender.setVisibility(View.GONE);
            genderTxt.setVisibility(View.GONE);
            destination.setVisibility(View.GONE);
            destinationTxt.setVisibility(View.GONE);

        } else {
            industryCard.setVisibility(View.VISIBLE);
            contactCard.setVisibility(View.VISIBLE);
        }
        if (UserType.equals("6")) {
            industryCard.setVisibility(View.GONE);
            contactCard.setVisibility(View.GONE);
        }
        industryType.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusType());
        persons.setText(profileGetInfoResponse.getData().getProfileInfo().getLouContactPersonName());
        roles.setText(profileGetInfoResponse.getData().getProfileInfo().getLouContactPersonRole());
        if (UserType.equals("8")) {
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());

        } else {
            subInsdustryTxt.setVisibility(View.GONE);
            subInsdustry.setVisibility(View.GONE);

        }

        wishlistCard.setVisibility(View.GONE);
        testimonialCard.setVisibility(View.GONE);
        //  group.setVisibility(View.GONE);
        expCard.setVisibility(View.GONE);
        educationCard.setVisibility(View.GONE);
        volunteerCard.setVisibility(View.GONE);
        skillsCard.setVisibility(View.GONE);
        awardsCard.setVisibility(View.GONE);
        cvCard.setVisibility(View.GONE);
        techSkillsCard.setVisibility(View.GONE);
        interestsCard.setVisibility(View.GONE);
        languageCard.setVisibility(View.GONE);*/

        Log.d(TAG, "updated_another_Ui: ");
        profileInfoCard.setVisibility(View.VISIBLE);
        edit.setVisibility(View.INVISIBLE);
        if (UserType.equals("5")) {
            industryCard.setVisibility(View.GONE);
            contactCard.setVisibility(View.GONE);
            contactCard.setVisibility(View.GONE);
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            region.setVisibility(View.VISIBLE);
            districtCity.setVisibility(View.VISIBLE);
            gender.setVisibility(View.VISIBLE);
            destination.setVisibility(View.VISIBLE);
            destinationTxt.setVisibility(View.VISIBLE);
            infoTxt.setText("General Information");
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());
            region.setText(profileGetInfoResponse.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileGetInfoResponse.getData().getProfileInfo().getCityName());
            genderTxt.setText("Suburb");
            gender.setText(profileGetInfoResponse.getData().getProfileInfo().getSuburbName());
            destinationTxt.setText("Website");
            destination.setText(profileGetInfoResponse.getData().getProfileInfo().getSluWebsite());

        } else {
            industryCard.setVisibility(View.VISIBLE);
            contactCard.setVisibility(View.VISIBLE);
        }
        if (UserType.equals("6")) {

            industryCard.setVisibility(View.GONE);
            contactCard.setVisibility(View.GONE);


        }
        industryType.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusType());
        persons.setText(profileGetInfoResponse.getData().getProfileInfo().getLouContactPersonName());
        roles.setText(profileGetInfoResponse.getData().getProfileInfo().getLouContactPersonRole());
        if (UserType.equals("7")) {
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            region.setVisibility(View.VISIBLE);
            districtCity.setVisibility(View.VISIBLE);
            gender.setVisibility(View.VISIBLE);
            destination.setVisibility(View.VISIBLE);
            destinationTxt.setVisibility(View.VISIBLE);
            infoTxt.setText("General Information");
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());
            region.setText(profileGetInfoResponse.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileGetInfoResponse.getData().getProfileInfo().getCityName());
            genderTxt.setText("Suburb");
            gender.setText(profileGetInfoResponse.getData().getProfileInfo().getSuburbName());
            destinationTxt.setText("Website");
            destination.setText(profileGetInfoResponse.getData().getProfileInfo().getSluWebsite());




        } else
        if (UserType.equals("8")) {
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            region.setVisibility(View.VISIBLE);
            districtCity.setVisibility(View.VISIBLE);
            gender.setVisibility(View.VISIBLE);
            destination.setVisibility(View.VISIBLE);
            destinationTxt.setVisibility(View.VISIBLE);
            infoTxt.setText("General Information");
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());
            region.setText(profileGetInfoResponse.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileGetInfoResponse.getData().getProfileInfo().getCityName());
            genderTxt.setText("Suburb");
            gender.setText(profileGetInfoResponse.getData().getProfileInfo().getSuburbName());
            destinationTxt.setText("Website");
            destination.setText(profileGetInfoResponse.getData().getProfileInfo().getSluWebsite());




        }
        if (UserType.equals("9")) {
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            region.setVisibility(View.VISIBLE);
            districtCity.setVisibility(View.VISIBLE);
            gender.setVisibility(View.VISIBLE);
            destination.setVisibility(View.VISIBLE);
            destinationTxt.setVisibility(View.VISIBLE);
            infoTxt.setText("General Information");
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());
            region.setText(profileGetInfoResponse.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileGetInfoResponse.getData().getProfileInfo().getCityName());
            genderTxt.setText("Suburb");
            gender.setText(profileGetInfoResponse.getData().getProfileInfo().getSuburbName());
            destinationTxt.setText("Website");
            destination.setText(profileGetInfoResponse.getData().getProfileInfo().getSluWebsite());




        }
        if (UserType.equals("10")) {
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            region.setVisibility(View.VISIBLE);
            districtCity.setVisibility(View.VISIBLE);
            gender.setVisibility(View.VISIBLE);
            destination.setVisibility(View.VISIBLE);
            destinationTxt.setVisibility(View.VISIBLE);
            infoTxt.setText("General Information");
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());
            region.setText(profileGetInfoResponse.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileGetInfoResponse.getData().getProfileInfo().getCityName());
            genderTxt.setText("Suburb");
            gender.setText(profileGetInfoResponse.getData().getProfileInfo().getSuburbName());
            destinationTxt.setText("Website");
            destination.setText(profileGetInfoResponse.getData().getProfileInfo().getSluWebsite());




        }    if (UserType.equals("11")) {
            subInsdustryTxt.setVisibility(View.VISIBLE);
            subInsdustry.setVisibility(View.VISIBLE);
            region.setVisibility(View.VISIBLE);
            districtCity.setVisibility(View.VISIBLE);
            gender.setVisibility(View.VISIBLE);
            destination.setVisibility(View.VISIBLE);
            destinationTxt.setVisibility(View.VISIBLE);
            infoTxt.setText("General Information");
            subInsdustry.setText(profileGetInfoResponse.getData().getProfileInfo().getIndusSubtype());
            region.setText(profileGetInfoResponse.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileGetInfoResponse.getData().getProfileInfo().getCityName());
            genderTxt.setText("Suburb");
            gender.setText(profileGetInfoResponse.getData().getProfileInfo().getSuburbName());
            destinationTxt.setText("Website");
            destination.setText(profileGetInfoResponse.getData().getProfileInfo().getSluWebsite());




        }
        else {
            subInsdustryTxt.setVisibility(View.GONE);
            subInsdustry.setVisibility(View.GONE);

        }

        wishlistCard.setVisibility(View.GONE);
        testimonialCard.setVisibility(View.GONE);
        //  group.setVisibility(View.GONE);
        expCard.setVisibility(View.GONE);
        educationCard.setVisibility(View.GONE);
        volunteerCard.setVisibility(View.GONE);
        skillsCard.setVisibility(View.GONE);
        awardsCard.setVisibility(View.GONE);
        cvCard.setVisibility(View.GONE);
        techSkillsCard.setVisibility(View.GONE);
        interestsCard.setVisibility(View.GONE);
        languageCard.setVisibility(View.GONE);
    }

    public void margintopReduce(CardView cardView) {
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) cardView.getLayoutParams();
        params.setMargins(0, -16, 0, 0); //substitute parameters for left, top, right, bottom
        cardView.setLayoutParams(params);

    }

    private void update_ui(ProfileInfoResp profileInfoResp) {
        industryCard.setVisibility(View.GONE);
        contactCard.setVisibility(View.GONE);
        Log.d(TAG, "update_ui: ");
        //Info
        if (profileInfoResp.getData().getProfileInfo() != null) {
            region.setText(profileInfoResp.getData().getProfileInfo().getRegionName());
            districtCity.setText(profileInfoResp.getData().getProfileInfo().getCityName());
            gender.setText(profileInfoResp.getData().getProfileInfo().getYthGenderName());
            destination.setText(profileInfoResp.getData().getProfileInfo().getIntendedDestinationName());
        }
        Log.d(TAG, "onResponse:profileInfoResp getJobWishlist"+new Gson().toJson(profileInfoResp.getData().getJobWishlist()));

        //Job Wishlist
        if (profileInfoResp.getData().getJobWishlist() != null) {
            wishlistNodata.setVisibility(View.GONE);
            NoWishlist.setVisibility(View.GONE);
            if (profileInfoResp.getData().getJobWishlist().size() == 0) {
                NoWishlist.setVisibility(View.VISIBLE);
                wishlistNodata.setVisibility(View.VISIBLE);}
            if (profileInfoResp.getData().getJobWishlist().size() >= 1) {
                wishlistLists1.setVisibility(View.VISIBLE);

                if (getStringIsEmpty(profileInfoResp.getData().getJobWishlist().get(0).getWitName()))
                    wishlistLists1.setText(profileInfoResp.getData().getJobWishlist().get(0).getWitName());
            } else {
                wishlistLists1.setVisibility(View.GONE);
            }
            if (profileInfoResp.getData().getJobWishlist().size() >= 2) {
                wishlistViewAllTxt.setVisibility(View.VISIBLE);
                wishlistLists2.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getJobWishlist().get(1).getWitName()))
                    wishlistLists2.setText(profileInfoResp.getData().getJobWishlist().get(1).getWitName());
            } else {
                wishlistViewAllTxt.setVisibility(View.GONE);

                wishlistLists2.setVisibility(View.GONE);
               // wishlistNodata.setVisibility(View.VISIBLE);
            }
        } else {
            Log.d(TAG, "update_ui: " + new Gson().toJson(profileInfoResp.getData().getJobWishlist()));
            wishlistLists1.setVisibility(View.GONE);
            wishlistLists2.setVisibility(View.GONE);
            wishListConstrain.setVisibility(View.GONE);
            wishlistNodata.setVisibility(View.VISIBLE);
            NoWishlist.setVisibility(View.VISIBLE);

        }
        Log.d(TAG, "update_ui:1 " + new Gson().toJson(profileInfoResp.getData().getJobWishlist()));

        Log.d(TAG, "update_ui: getTestimonials" + profileInfoResp.getData().getTestimonials());
        Log.d(TAG, "update_ui: getTestimonials" + profileInfoResp.getData().getTestimonials().size());
        //  Log.d(TAG, "update_ui: getTestimonials"+profileInfoResp.getData().getTestimonials().get(0).getTeuProviderMessage());

        //Testimonals
        if (!profileInfoResp.getData().getTestimonials().isEmpty() && profileInfoResp.getData().getTestimonials() != null) {
            if (profileInfoResp.getData().getTestimonials().size() != 0) {
                testimonialViewAllTxt.setVisibility(View.VISIBLE);
                title.setText(profileInfoResp.getData().getTestimonials().get(0).getSkmName());
                date.setText(profileInfoResp.getData().getTestimonials().get(0).getTeuCreatedOn());
                subTitle.setText(profileInfoResp.getData().getTestimonials().get(0).getTeuProviderCompany());
                mail.setText(profileInfoResp.getData().getTestimonials().get(0).getTeuProviderEmail());
                desc.setText(profileInfoResp.getData().getTestimonials().get(0).getTeuProviderMessage());
                endorsedName.setText(profileInfoResp.getData().getTestimonials().get(0).getTeuProviderName() + " - " + profileInfoResp.getData().getTestimonials().get(0).getTeuProviderTitle());
                delete.setVisibility(View.GONE);
                testIncludeLayout.setVisibility(View.VISIBLE);
                testimonialNodata.setVisibility(View.GONE);
                NoTestimonial.setVisibility(View.GONE);
            } else {
                testimonialViewAllTxt.setVisibility(View.GONE);
                testimonialNodata.setVisibility(View.VISIBLE);
                NoTestimonial.setVisibility(View.VISIBLE);
                testIncludeLayout.setVisibility(View.GONE);
            }
        } else {
            testimonialViewAllTxt.setVisibility(View.GONE);
            testIncludeLayout.setVisibility(View.GONE);
            testimonialNodata.setVisibility(View.VISIBLE);
            NoTestimonial.setVisibility(View.VISIBLE);
            // testimonialLinear.setVisibility(View.GONE);
            //  testimonialConstrain.setVisibility(View.GONE);
            //  margintopReduce(testimonialCard);
            // group.setVisibility(View.GONE);
        }

        //Experience
        if (!profileInfoResp.getData().getExperience().isEmpty() && profileInfoResp.getData().getExperience() != null) {
            if (profileInfoResp.getData().getExperience().size() != 0) {
                expViewAllTxt.setVisibility(View.VISIBLE);
                expTitle.setText(profileInfoResp.getData().getExperience().get(0).getEmuDesignation());
                expDate.setText(profileInfoResp.getData().getExperience().get(0).getStartDate() + "-" + profileInfoResp.getData().getExperience().get(0).getEndDate());
                expPosition.setText(profileInfoResp.getData().getExperience().get(0).getEmuJtTypeName());
                expYears.setText(profileInfoResp.getData().getExperience().get(0).getDiffYear());
                expDesc.setText(profileInfoResp.getData().getExperience().get(0).getEmuDescription());
                experienceKeyAdapter = new ExperienceKeyAdapter(activity, profileInfoResp.getData().getExperience().get(0).getEmuResponsibilities());
                exprecycleResponability.setAdapter(experienceKeyAdapter);
                LinearLayoutManager wishList_LayoutManager = new LinearLayoutManager(activity);
                exprecycleResponability.setLayoutManager(wishList_LayoutManager);
                experienceKeyAdapter.notifyDataSetChanged();
                expNodata.setVisibility(View.GONE);
                NoExpImg.setVisibility(View.GONE);
                expIncludeLayout.setVisibility(View.VISIBLE);
            } else {
                expViewAllTxt.setVisibility(View.GONE);
                expNodata.setVisibility(View.VISIBLE);
                NoExpImg.setVisibility(View.VISIBLE);
                expIncludeLayout.setVisibility(View.GONE);
            }
        } else {
            expViewAllTxt.setVisibility(View.GONE);
            expNodata.setVisibility(View.VISIBLE);
            NoExpImg.setVisibility(View.VISIBLE);
            expIncludeLayout.setVisibility(View.GONE);
            // expConstrain.setVisibility(View.GONE);
            // margintopReduce(expCard);
        }

        //Education
        if (!profileInfoResp.getData().getEducation().isEmpty() && profileInfoResp.getData().getEducation() != null) {
            String year = "";
            if (!profileInfoResp.getData().getEducation().get(0).getDiffYear().equals("0")) {
                year = year + profileInfoResp.getData().getEducation().get(0).getDiffYear() + " yrs ";
            }
            if (!profileInfoResp.getData().getEducation().get(0).getDiffMonth().equals("0")) {
                year = year + profileInfoResp.getData().getEducation().get(0).getDiffMonth() + " mon ";
            }
            educationViewAllTxt.setVisibility(View.VISIBLE);
            eduTitle.setText(profileInfoResp.getData().getEducation().get(0).getQauTitle());
            eduDate.setText(profileInfoResp.getData().getEducation().get(0).getQauStartDate() + "-" + profileInfoResp.getData().getEducation().get(0).getQauEndDate());
            eduPosition.setText(profileInfoResp.getData().getEducation().get(0).getQamTitle());
            eduYears.setText(year);
            eduDesc.setText(profileInfoResp.getData().getEducation().get(0).getQauDescription());
            educationNodata.setVisibility(View.GONE);
            NoEduImg.setVisibility(View.GONE);
            educationIncludeLayout.setVisibility(View.VISIBLE);
        } else {
            educationViewAllTxt.setVisibility(View.GONE);
            educationNodata.setVisibility(View.VISIBLE);
            NoEduImg.setVisibility(View.VISIBLE);
            educationIncludeLayout.setVisibility(View.GONE);
            //    educationConstrain.setVisibility(View.GONE);
            //   margintopReduce(educationCard);
        }

    /*    //Education
        if (!profileInfoResp.getData().getEducation().isEmpty() && profileInfoResp.getData().getEducation()!=null) {
            eduTitle.setText(profileInfoResp.getData().getEducation().get(0).getQau_title());
            eduDate.setText(profileInfoResp.getData().getEducation().get(0).getQau_start_date()+"-"+profileInfoResp.getData().getEducation().get(0).getQau_end_date());
            eduPosition.setText(profileInfoResp.getData().getEducation().get(0).getQam_title());
            eduYears.setText(profileInfoResp.getData().getEducation().get(0).getDiff_year());
            eduDesc.setText(profileInfoResp.getData().getEducation().get(0).getQau_description());

        }else{

        }
*/
        //Volunteering Education
        if (!profileInfoResp.getData().getVolunteering().isEmpty() && profileInfoResp.getData().getVolunteering() != null) {
            String year = "";
            if (!profileInfoResp.getData().getVolunteering().get(0).getDiffYear().equals("0")) {
                year = year + profileInfoResp.getData().getVolunteering().get(0).getDiffYear() + " yrs ";
            }
            if (!profileInfoResp.getData().getVolunteering().get(0).getDiffMonth().equals("0")) {
                year = year + profileInfoResp.getData().getVolunteering().get(0).getDiffMonth() + " mon ";
            }
            volunteerViewAllTxt.setVisibility(View.VISIBLE);
            volunteerTitle.setText(profileInfoResp.getData().getVolunteering().get(0).getVouTitle());
            volunteerDate.setText(profileInfoResp.getData().getVolunteering().get(0).getVouStartDate() + "-" + profileInfoResp.getData().getVolunteering().get(0).getVouEndDate());
            volunteerPosition.setText(profileInfoResp.getData().getVolunteering().get(0).getVouProviderName());
            volunteerYears.setText(year);
            volunteerDesc.setText(profileInfoResp.getData().getVolunteering().get(0).getVouDescription());
            volunteerNodata.setVisibility(View.GONE);
            NoVolImg.setVisibility(View.GONE);
            volunteerIncludeLayout.setVisibility(View.VISIBLE);
        } else {
            volunteerViewAllTxt.setVisibility(View.GONE);
            volunteerNodata.setVisibility(View.VISIBLE);
            NoVolImg.setVisibility(View.VISIBLE);
            volunteerIncludeLayout.setVisibility(View.GONE);
            //  volunteerConstrain.setVisibility(View.GONE);
            //  margintopReduce(volunteerCard);
        }

        //Skills
        if (!profileInfoResp.getData().getSkills().isEmpty() && profileInfoResp.getData().getSkills() != null) {
            skillsNodata.setVisibility(View.GONE);
            NoSkillImg.setVisibility(View.GONE);
            if (profileInfoResp.getData().getSkills().get(0) != null) {

                skillsViewAllTxt.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getSkills().get(0).getSkmName()))
                    skillsTitle.setText(profileInfoResp.getData().getSkills().get(0).getSkmName());
            } else {

                skillsTitle.setVisibility(View.GONE);
            }
            if (profileInfoResp.getData().getSkills().get(1) != null) {
                skillsTitle.setVisibility(View.VISIBLE);
                skillsTitle1.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getSkills().get(1).getSkmName()))
                    skillsTitle1.setText(profileInfoResp.getData().getSkills().get(1).getSkmName());
            } else {
                skillsViewAllTxt.setVisibility(View.GONE);
                skillsTitle1.setVisibility(View.GONE);
            }
        } else {
            skillsTitle.setVisibility(View.GONE);
            skillsTitle1.setVisibility(View.GONE);
            skillsViewAllTxt.setVisibility(View.GONE);
            skillsNodata.setVisibility(View.VISIBLE);
            NoSkillImg.setVisibility(View.VISIBLE);
            // skillsConstrain.setVisibility(View.GONE);
            // margintopReduce(skillsCard);
        }

        //Achievement and Awards
        if (!profileInfoResp.getData().getAchievement().isEmpty() && profileInfoResp.getData().getAchievement() != null) {
            awardsViewAllTxt.setVisibility(View.VISIBLE);
            awardsTitle.setText(profileInfoResp.getData().getAchievement().get(0).getAcuTitle());
            awardsDate.setText(profileInfoResp.getData().getAchievement().get(0).getIssuedYear());
            awardsPlace.setText(profileInfoResp.getData().getAchievement().get(0).getAcuOccupation());
            awardsRecieved.setText(profileInfoResp.getData().getAchievement().get(0).getAcuProviderName());
            awardsDesc.setText(profileInfoResp.getData().getAchievement().get(0).getAcuDescription());
            awardsNodata.setVisibility(View.GONE);
            NoAwardImage.setVisibility(View.GONE);
            awardsIncludeLayout.setVisibility(View.VISIBLE);
        } else {
            awardsViewAllTxt.setVisibility(View.GONE);
            awardsNodata.setVisibility(View.VISIBLE);
            NoAwardImage.setVisibility(View.VISIBLE);
            awardsIncludeLayout.setVisibility(View.GONE);
            //  awardsConstrain.setVisibility(View.GONE);
            //   margintopReduce(awardsCard);
        }

        //Attach Cv
        if (!profileInfoResp.getData().getUserCv().isEmpty() && profileInfoResp.getData().getUserCv() != null) {
          cvNodata.setVisibility(View.GONE);
          NoCvImage.setVisibility(View.GONE);
            if (profileInfoResp.getData().getUserCv().size() >= 1) {

                cvTitle.setVisibility(View.VISIBLE);
                resumeTxt.setVisibility(View.VISIBLE);
                cvDate.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getUserCv().get(0).getUcvTitle()))
                    cvTitle.setText(profileInfoResp.getData().getUserCv().get(0).getUcvTitle());
                resumeTxt.setText(profileInfoResp.getData().getUserCv().get(0).getUcvTypeName());
                cvDate.setText(profileInfoResp.getData().getUserCv().get(0).getUcvCreatedOn());
            } else {
                cvTitle.setVisibility(View.GONE);
                resumeTxt.setVisibility(View.GONE);
                cvDate.setVisibility(View.GONE);
            }
            if (profileInfoResp.getData().getUserCv().size() >= 2) {
                cvViewAllTxt.setVisibility(View.VISIBLE);

                cvTitle1.setVisibility(View.VISIBLE);
                resumeTxt1.setVisibility(View.VISIBLE);
                cvDate1.setVisibility(View.VISIBLE);

                if (getStringIsEmpty(profileInfoResp.getData().getUserCv().get(1).getUcvTitle()))
                    cvTitle1.setText(profileInfoResp.getData().getUserCv().get(1).getUcvTitle());
                resumeTxt1.setText(profileInfoResp.getData().getUserCv().get(1).getUcvTypeName());
                cvDate1.setText(profileInfoResp.getData().getUserCv().get(1).getUcvCreatedOn());
            } else {
                cvViewAllTxt.setVisibility(View.GONE);
                cvTitle1.setVisibility(View.GONE);
                resumeTxt1.setVisibility(View.GONE);
                cvDate1.setVisibility(View.GONE);

            }
        } else {
            cvTitle.setVisibility(View.GONE);
            resumeTxt.setVisibility(View.GONE);
            cvTitle1.setVisibility(View.GONE);
            cvDate.setVisibility(View.GONE);
            resumeTxt1.setVisibility(View.GONE);
            cvDate1.setVisibility(View.GONE);
            cvNodata.setVisibility(View.VISIBLE);
            NoCvImage.setVisibility(View.VISIBLE);
            //  cvConstrain.setVisibility(View.GONE);
            // margintopReduce(cvCard);

        }

        //Technical Skill
        if (!profileInfoResp.getData().getTechnicalSkills().isEmpty() && profileInfoResp.getData().getTechnicalSkills() != null) {
            techSkillsNodata.setVisibility(View.GONE);
            NoTechImg.setVisibility(View.GONE);
            if (profileInfoResp.getData().getTechnicalSkills().size() >= 1) {
                techSkillsTitle.setVisibility(View.VISIBLE);
                techSkillsRating.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getTechnicalSkills().get(0).getSkuName()))
                    techSkillsTitle.setText(profileInfoResp.getData().getTechnicalSkills().get(0).getSkuName());
                techSkillsRating.setText(profileInfoResp.getData().getTechnicalSkills().get(0).getSkuLevel());
            } else {
                techSkillsTitle.setVisibility(View.GONE);
                techSkillsRating.setVisibility(View.GONE);
            }
            if (profileInfoResp.getData().getTechnicalSkills().size() >= 2) {
                techSkillsViewAllTxt.setVisibility(View.VISIBLE);
                techSkillsTitle1.setVisibility(View.VISIBLE);
                techSkillsRating1.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getTechnicalSkills().get(1).getSkuName()))
                    techSkillsTitle1.setText(profileInfoResp.getData().getTechnicalSkills().get(1).getSkuName());
                techSkillsRating1.setText(profileInfoResp.getData().getTechnicalSkills().get(1).getSkuLevel());
            } else {
                techSkillsViewAllTxt.setVisibility(View.GONE);
                techSkillsTitle1.setVisibility(View.GONE);
                techSkillsRating1.setVisibility(View.GONE);
            }
        } else {
            techSkillsTitle.setVisibility(View.GONE);
            techSkillsRating.setVisibility(View.GONE);
            techSkillsTitle1.setVisibility(View.GONE);
            techSkillsRating1.setVisibility(View.GONE);
            techSkillsNodata.setVisibility(View.VISIBLE);
            NoTechImg.setVisibility(View.VISIBLE);
            //  techSkillsConstrain.setVisibility(View.GONE);
            //  margintopReduce(techSkillsCard);
        }
        Log.d(TAG, "update_ui: Interests" + profileInfoResp.getData().getInterests().size());
        //Interests
        if (!profileInfoResp.getData().getInterests().isEmpty() && profileInfoResp.getData().getInterests() != null) {
            interestsNodata.setVisibility(View.GONE);
            NoIntImg.setVisibility(View.GONE);
            if (profileInfoResp.getData().getInterests().size() >= 1) {
                interestsTitle.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getInterests().get(0).getInuName()))
                    interestsTitle.setText(profileInfoResp.getData().getInterests().get(0).getInuName());
            } else {
                interestsTitle.setVisibility(View.GONE);
            }
            if (profileInfoResp.getData().getInterests().size() >= 2) {
                interestsViewAllTxt.setVisibility(View.VISIBLE);
                interestsTitle1.setVisibility(View.VISIBLE);
                Log.d(TAG, "update_ui:inside Interests" + profileInfoResp.getData().getInterests().size());

                if (getStringIsEmpty(profileInfoResp.getData().getInterests().get(1).getInuName()))
                    interestsTitle1.setText(profileInfoResp.getData().getInterests().get(1).getInuName());
            } else {
                Log.d(TAG, "update_ui:inside_out Interests" + profileInfoResp.getData().getInterests().size());
                interestsViewAllTxt.setVisibility(View.GONE);
                interestsTitle1.setVisibility(View.GONE);
            }
        } else {
            interestsTitle.setVisibility(View.GONE);
            interestsTitle1.setVisibility(View.GONE);
            interestsNodata.setVisibility(View.VISIBLE);
            NoIntImg.setVisibility(View.VISIBLE);
            //  interestsConstrain.setVisibility(View.GONE);
            //   margintopReduce(interestsCard);
            // Log.d(TAG, "update_ui: "+new Gson().toJson());
        }

        //Languages
        if (!profileInfoResp.getData().getLanguage().isEmpty() && profileInfoResp.getData().getLanguage() != null) {
            languageNodata.setVisibility(View.GONE);
            NoLangImage.setVisibility(View.GONE);
            if (profileInfoResp.getData().getLanguage().size() >= 1) {
                languageTitle.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getLanguage().get(0).getLamName()))
                    languageTitle.setText(profileInfoResp.getData().getLanguage().get(0).getLamName());
            } else {
                languageTitle.setVisibility(View.GONE);
            }
            if (profileInfoResp.getData().getLanguage().size() >= 2) {
                languageViewAllTxt.setVisibility(View.VISIBLE);
                languageTitle1.setVisibility(View.VISIBLE);
                if (getStringIsEmpty(profileInfoResp.getData().getLanguage().get(1).getLamName()))
                    languageTitle1.setText(profileInfoResp.getData().getLanguage().get(1).getLamName());
            } else {
                languageViewAllTxt.setVisibility(View.GONE);
                languageTitle1.setVisibility(View.GONE);
            }
        } else {
            languageTitle.setVisibility(View.GONE);
            languageTitle1.setVisibility(View.GONE);
            languageNodata.setVisibility(View.VISIBLE);
            NoLangImage.setVisibility(View.VISIBLE);
            //  languageConstrain.setVisibility(View.GONE);
            //   margintopReduce(languageCard);
        }


    }

    @Override
    public void onPassData(String firstName, String lastName, String dob, String gender, String regionId, String cityId,
                           String currentorgansizationStatusId, String ethnicity, String lwi, String emailId,
                           String moileNo, String currentWorkStatusId, String workAvailabilityId, String workExperienceId,
                           String yourAvailabilityWorkperWeek, String perferredWorkRegionId, String perferrredWorkCityId,
                           String futhurIndentededDesitinationId, String LicenceTypeId, String residencyStatusId,
                           String visaTypeId, String visaMonth, String visaYear, String instagramUrl,
                           String twitterUrl, String googleplusUrl, String linkeninUrl, String githubUrl,
                           String behanceUrl, String aboutme, boolean filter) {
        mfirstName = firstName;
        mlastName = lastName;
        mdob = dob;
        mgender_update = gender;
        mregionId = regionId;
        mcityId = cityId;
        mcurrentorgansizationStatusId = currentorgansizationStatusId;
        methnicity = ethnicity;
        mlwi = lwi;
        memailId = emailId;
        mmoileNo = moileNo;
        mcurrentWorkStatusId = currentWorkStatusId;
        mworkAvailabilityId = workAvailabilityId;
        mworkExperienceId = workExperienceId;
        myourAvailabilityWorkperWeek = yourAvailabilityWorkperWeek;
        mperferredWorkRegionId = perferredWorkRegionId;
        mperferrredWorkCityId = perferrredWorkCityId;
        mfuthurIndentededDesitinationId = futhurIndentededDesitinationId;
        myourAvailabilityWorkperWeek = yourAvailabilityWorkperWeek;
        mLicenceTypeId = LicenceTypeId;
        mresidencyStatusId = residencyStatusId;
        mvisaTypeId = visaTypeId;
        mvisaMonth = visaMonth;
        mvisaYear = visaYear;
        minstagramUrl = instagramUrl;
        mtwitterUrl = twitterUrl;
        mgoogleplusUrl = googleplusUrl;
        mlinkeninUrl = linkeninUrl;
        mgithubUrl = githubUrl;
        mbehanceUrl = behanceUrl;
        maboutme = aboutme;
        mfilter = filter;
        Log.d(TAG, "onPassData: dob" + mdob);
        call_profile_info_update_api(true);

        Intent profileIntent = new Intent(activity, ProfileActivity.class);
        profileIntent.putExtra(Constants.UserCode, Constants.getUserCode(activity));
        profileIntent.putExtra(Constants.UserType, "1");
        startActivity(profileIntent);
        activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
