package com.example.youthhub.profile;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.connection.conListMaster.ConnCityRes;
import com.example.youthhub.resModel.profile.CityListItem;
import com.example.youthhub.resModel.profile.GenderMasterItem;
import com.example.youthhub.resModel.profile.IntendedDestinationItem;
import com.example.youthhub.resModel.profile.LicenceTypeItem;
import com.example.youthhub.resModel.profile.LocationEthnicityItem;
import com.example.youthhub.resModel.profile.LocationIwiItem;
import com.example.youthhub.resModel.profile.OrganisationDataItem;
import com.example.youthhub.resModel.profile.ProfileMasterResponse;
import com.example.youthhub.resModel.profile.RegionListItem;
import com.example.youthhub.resModel.profile.ResidencyStatusMasterItem;
import com.example.youthhub.resModel.profile.VisaTypeMasterItem;
import com.example.youthhub.resModel.profile.WorkAvailabilityTimingMasterItem;
import com.example.youthhub.resModel.profile.WorkExperienceMasterItem;
import com.example.youthhub.resModel.profile.WorkStatusMasterItem;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileInfoDialog extends Dialog {


    Activity activity;
    @BindView(R.id.genral_information_textview)
    TextView genralInformationTextview;
    @BindView(R.id.firstname_textview)
    TextView firstnameTextview;
    @BindView(R.id.firstname_edit_text)
    EditText firstnameEditText;
    @BindView(R.id.lastname_textview)
    TextView lastnameTextview;
    @BindView(R.id.lastname_edit_text)
    EditText lastnameEditText;
    @BindView(R.id.dob_textview)
    TextView dobTextview;

    @BindView(R.id.gender_textview)
    TextView genderTextview;
    @BindView(R.id.gender_spinner)
    AppCompatSpinner gender_spinner;
    @BindView(R.id.region_spinner)
    AppCompatSpinner regionSpinner;
    @BindView(R.id.region_textview)
    TextView regionTextview;
    @BindView(R.id.district_city_textview)
    TextView districtCityTextview;
    @BindView(R.id.current_organisation_textview)
    TextView currentOrganisationTextview;
    @BindView(R.id.ethnicity_textview)
    TextView ethnicityTextview;
    @BindView(R.id.lwi_textview)
    TextView lwiTextview;
    @BindView(R.id.email_textview)
    TextView emailTextview;
    @BindView(R.id.mobile_number_textview)
    TextView mobileNumberTextview;
    @BindView(R.id.work_profile_textview)
    TextView workProfileTextview;
    @BindView(R.id.current_work_status_textview)
    TextView currentWorkStatusTextview;
    @BindView(R.id.work_availability_textview)
    TextView workAvailabilityTextview;
    @BindView(R.id.work_experience_textview)
    TextView workExperienceTextview;
    @BindView(R.id.your_availability_textview)
    TextView yourAvailabilityTextview;
    @BindView(R.id.prefered_region_textview)
    TextView preferedRegionTextview;
    @BindView(R.id.district_work_textview)
    TextView districtWorkTextview;
    @BindView(R.id.future_intended_destination_textview)
    TextView futureIntendedDestinationTextview;
    @BindView(R.id.license_and_transport_textview)
    TextView licenseAndTransportTextview;
    @BindView(R.id.residency_status_textview)
    TextView residencyStatusTextview;
    @BindView(R.id.communication_connections_textview)
    TextView communicationConnectionsTextview;
    @BindView(R.id.instagram_link_textview)
    TextView instagramLinkTextview;
    @BindView(R.id.instagram_link_edittext)
    EditText instagramLinkEdittext;
    @BindView(R.id.facebook_link_textview)
    TextView facebookLinkTextview;
    @BindView(R.id.facebook_link_edittext)
    EditText facebookLinkEdittext;
    @BindView(R.id.twitter_link_textview)
    TextView twitterLinkTextview;
    @BindView(R.id.twitter_link_edittext)
    EditText twitterLinkEdittext;
    @BindView(R.id.google_plus_link_textview)
    TextView googlePlusLinkTextview;
    @BindView(R.id.google_plus_link_edittext)
    EditText googlePlusLinkEdittext;
    @BindView(R.id.linkedin_link_textview)
    TextView linkedinLinkTextview;
    @BindView(R.id.linkedin_link_edittext)
    EditText linkedinLinkEdittext;
    @BindView(R.id.github_link_textview)
    TextView githubLinkTextview;
    @BindView(R.id.github_link_edittext)
    EditText githubLinkEdittext;
    @BindView(R.id.behance_link_textview)
    TextView behanceLinkTextview;
    @BindView(R.id.behance_link_edittext)
    EditText behanceLinkEdittext;
    @BindView(R.id.additional_info_textview)
    TextView additionalInfoTextview;

    @BindView(R.id.yes_textview)
    TextView yesTextview;
    @BindView(R.id.apply_button)
    Button applyButton;
    @BindView(R.id.cancel_button)
    Button cancelButton;


    @BindView(R.id.dob_edittext)
    AppCompatEditText dobEdittext;
    @BindView(R.id.city_spinner)
    AppCompatSpinner citySpinner;
    @BindView(R.id.organisation_spinner)
    AppCompatSpinner organisationSpinner;
    @BindView(R.id.ethnicity_spinner)
    AppCompatSpinner ethnicitySpinner;
    @BindView(R.id.iwi_spinner)
    AppCompatSpinner iwiSpinner;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_mobileno)
    EditText editMobileno;
    @BindView(R.id.current_work_status_spinner)
    AppCompatSpinner currentWorkStatusSpinner;
    @BindView(R.id.work_availability_spinner)
    AppCompatSpinner workAvailabilitySpinner;
    @BindView(R.id.work_experience_spinner)
    AppCompatSpinner workExperienceSpinner;

    @BindView(R.id.prefered_region_spinner)
    AppCompatSpinner preferedRegionSpinner;
    @BindView(R.id.district_work_spinner)
    AppCompatSpinner districtWorkSpinner;
    @BindView(R.id.future_intended_destination_spinner)
    AppCompatSpinner futureIntendedDestinationSpinner;
    @BindView(R.id.license_and_transport_spinner)
    AppCompatSpinner licenseAndTransportSpinner;
    @BindView(R.id.residency_status_spinner)
    AppCompatSpinner residencyStatusSpinner;
    @BindView(R.id.your_availability_spinner)
    EditText yourAvailabilitySpinner;
    @BindView(R.id.visatype_textview)
    TextView visatypeTextview;
    @BindView(R.id.visatype_spinner)
    AppCompatSpinner visatypeSpinner;
    @BindView(R.id.visaexpire_textview)
    TextView visaexpireTextview;
    @BindView(R.id.edt_visa_month)
    EditText edtVisaMonth;
    @BindView(R.id.edt_visa_year)
    EditText edtVisaYear;
    @BindView(R.id.linear_visa_expire)
    LinearLayoutCompat linearVisaExpire;
    @BindView(R.id.about_me_textview)
    EditText aboutMeTextview;

    private GenderMasterItem genderPassData = null;
    private RegionListItem regionPassData = null;
    private CityListItem cityPassData = null;
    private OrganisationDataItem organisationPassData = null;
    private LocationIwiItem iwiPassData = null;
    private LocationEthnicityItem ethnicityPassData = null;
    private WorkStatusMasterItem currentworkstatusPassData = null;
    private WorkAvailabilityTimingMasterItem workavaiabilityPassData = null;
    private WorkExperienceMasterItem workexperiencePassData = null;
    private RegionListItem perferrredregionPassData = null;
    private CityListItem perferrredcityPassData = null;
    private IntendedDestinationItem intendedDestinationPassData = null;
    private LicenceTypeItem licencePassData = null;
    private ResidencyStatusMasterItem residencyStatusPassData = null;
    private VisaTypeMasterItem visatypePassData = null;
    private Integer genederPosition = null;
    private Integer regionPosition = null;
    private Integer cityPosition = null;
    private Integer organisationPosition = null;
    private Integer iwiPosition = null;
    private Integer ethnicityPosition = null;
    private Integer currentworkstatusPosition = null;
    private Integer workavaiabilityPosition = null;
    private Integer workexperiencePosition = null;
    private Integer perferrredregionPosition = null;
    private Integer perferrredcityPosition = null;
    private Integer intendedDestinationPosition = null;
    private Integer licencePosition = null;
    private Integer residencyStatusPosition = null;
    private Integer visatypePosition = null;
    private String usercode;

    ProfileMasterResponse profileInfoMaster;
    OnPassDataListener onPassDataListener;

    //Profile Updated
    String firstName = "";
    String lastName = "";
    String dob = "";
    String gender = "";
    String regionId = "";
    String cityId = "";
    String currentorgansizationStatusId = "";
    String ethnicity = "";
    String lwi = "";
    String emailId = "";
    String moileNo = "";
    String currentWorkStatusId = "";
    String workAvailabilityId = "";
    String workExperienceId = "";
    String yourAvailabilityWorkperWeek = "";
    String perferredWorkRegionId = "";
    String perferrredWorkCityId = "";
    String futhurIndentededDesitinationId = "";
    String LicenceTypeId = "";
    String residencyStatusId = "";
    String visaTypeId = "";
    String visaMonth = "";
    String visaYear = "";
    String instagramUrl = "";
    String twitterUrl = "";
    String googleplusUrl = "";
    String linkeninUrl = "";
    String githubUrl = "";
    String behanceUrl = "";
    String aboutme = "";

    final Calendar myCalendar = Calendar.getInstance();
    public static final String TAG = "ProfileInfoDialog";

    public ProfileInfoDialog(Activity activity, String usercode) {
        super(activity);
        this.activity = activity;
        this.usercode = usercode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.profile_info_dialogue);
        ButterKnife.bind(this);
        callTypeFace();

        //  call_profile_info_master(usercode);
        Log.d(TAG, "onCreate: " + new Gson().toJson(profileInfoMaster));
        if (profileInfoMaster!=null) {
            update_ui(profileInfoMaster);
        }
    }

    private void callTypeFace() {
        additionalInfoTextview.setTypeface(FontTypeFace.fontBold(activity));
        behanceLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        communicationConnectionsTextview.setTypeface(FontTypeFace.fontBold(activity));
        currentOrganisationTextview.setTypeface(FontTypeFace.fontBold(activity));
        currentWorkStatusTextview.setTypeface(FontTypeFace.fontBold(activity));
        districtCityTextview.setTypeface(FontTypeFace.fontBold(activity));
        districtWorkTextview.setTypeface(FontTypeFace.fontBold(activity));
        dobTextview.setTypeface(FontTypeFace.fontBold(activity));
        emailTextview.setTypeface(FontTypeFace.fontBold(activity));
        ethnicityTextview.setTypeface(FontTypeFace.fontBold(activity));
        facebookLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        firstnameTextview.setTypeface(FontTypeFace.fontBold(activity));
        futureIntendedDestinationTextview.setTypeface(FontTypeFace.fontBold(activity));
        genderTextview.setTypeface(FontTypeFace.fontBold(activity));
        genralInformationTextview.setTypeface(FontTypeFace.fontBold(activity));
        githubLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        googlePlusLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        instagramLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        lastnameTextview.setTypeface(FontTypeFace.fontBold(activity));
        licenseAndTransportTextview.setTypeface(FontTypeFace.fontBold(activity));
        yourAvailabilityTextview.setTypeface(FontTypeFace.fontBold(activity));
        workProfileTextview.setTypeface(FontTypeFace.fontBold(activity));
        workExperienceTextview.setTypeface(FontTypeFace.fontBold(activity));
        workAvailabilityTextview.setTypeface(FontTypeFace.fontBold(activity));
        twitterLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        residencyStatusTextview.setTypeface(FontTypeFace.fontBold(activity));
        regionTextview.setTypeface(FontTypeFace.fontBold(activity));
        preferedRegionTextview.setTypeface(FontTypeFace.fontBold(activity));
        preferedRegionTextview.setTypeface(FontTypeFace.fontBold(activity));
        mobileNumberTextview.setTypeface(FontTypeFace.fontBold(activity));
        lwiTextview.setTypeface(FontTypeFace.fontBold(activity));
        linkedinLinkTextview.setTypeface(FontTypeFace.fontBold(activity));
        visatypeTextview.setTypeface(FontTypeFace.fontBold(activity));
        visaexpireTextview.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(firstnameTextview,"First Name");
        AppUtils.textAddAstreik(lastnameTextview,"Last Name");
        AppUtils.textAddAstreik(dobTextview,"Date of Birth");
        AppUtils.textAddAstreik(genderTextview,"Gender");
        AppUtils.textAddAstreik(regionTextview,"Region");
        AppUtils.textAddAstreik(districtCityTextview,"District / City");
        AppUtils.textAddAstreik(futureIntendedDestinationTextview,"Future intended destination");
        AppUtils.textAddAstreik(emailTextview,"Email");

    }

    @OnClick({R.id.apply_button, R.id.cancel_button, R.id.dob_edittext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_button:
                pass_Data();
                break;
            case R.id.cancel_button:
                dismiss();
                break;
            case R.id.dob_edittext:
               /* DatePickerDialog picker = new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                picker.show();*/
                calendarClick();
                break;
        }
    }

    private void calendarClick() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) ->
        {
            String age = getAge(year,monthOfYear,dayOfMonth);
            int AGE = Integer.valueOf(age);
            if(AGE>=11 && AGE<=26){
                dobEdittext.setText(String.valueOf(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year));
            }else {
                //MyToast.errorMessage(age,activity);
                MyToast.errorMessage("The dob field must contain a valid Youth Date of Birth (Age b/w 12 to 25)",activity);
            }
        }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }
    private String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        int ageInt = age;

        return Integer.toString(ageInt);
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            AppUtils.updateLabel1(dobEdittext,myCalendar);

        }

    };

    public void newInstance(ProfileMasterResponse profileInfoMaster) {
        this.profileInfoMaster = profileInfoMaster;
        Log.d(TAG, "newInstance: " + new Gson().toJson(profileInfoMaster));
    }


    private void update_ui(ProfileMasterResponse profileInfoMaster) {
        firstnameEditText.setText(profileInfoMaster.getData().getYouthInfo().getYthFirstName());
        lastnameEditText.setText(profileInfoMaster.getData().getYouthInfo().getYthLastName());
        dobEdittext.setText(profileInfoMaster.getData().getYouthInfo().getYthDob());
        editEmail.setText(profileInfoMaster.getData().getYouthInfo().getYthContactEmail());
        editMobileno.setText(profileInfoMaster.getData().getYouthInfo().getYthMobileNo());
        yourAvailabilitySpinner.setText(profileInfoMaster.getData().getYouthInfo().getYthWorkAvailabilityHour());
        // firstnameEditText.setText(profileInfoMaster.getData().getYouthInfo().getYthFirstName());

        /*General Information*/
        gender_spinner_load();
        regionSpinnerLoad();
        citySpinnerLoad();
        organisationSpinnerLoad();
        IwiSpinnerLoad();
        ethnicitySpinnerLoad();

        /*Work Profile*/
        currentworkstatusSpinnerLoad();
        workavailabilitySpinnerLoad();
        workexperienceSpinnerLoad();
        perferedregionSpinnerLoad();
        perferredcitySpinnerLoad();
        intendedDestinationSpinnerLoad();
        licenseTrasportSpinnerLoad();
        residencystatusSpinnerLoad();
        visatypeSpinnerLoad();

        edtVisaMonth.setText(profileInfoMaster.getData().getYouthInfo().getYthVisaExpireMonth());
        edtVisaYear.setText(profileInfoMaster.getData().getYouthInfo().getYthVisaExpireYear());

        instagramLinkEdittext.setText(profileInfoMaster.getData().getYouthInfo().getSluInstagram());
        facebookLinkEdittext.setText(profileInfoMaster.getData().getYouthInfo().getSluFacebook());
        twitterLinkEdittext.setText(profileInfoMaster.getData().getYouthInfo().getSluTwitter());
        googlePlusLinkEdittext.setText(profileInfoMaster.getData().getYouthInfo().getSluGooglePlus());
        linkedinLinkEdittext.setText(profileInfoMaster.getData().getYouthInfo().getSluLinkedin());
        behanceLinkEdittext.setText(profileInfoMaster.getData().getYouthInfo().getSluBehance());

        aboutMeTextview.setText(profileInfoMaster.getData().getYouthInfo().getYthFullDescription());


        //   Loader.showLoad(activity, false);
    }

    private void visatypeSpinnerLoad() {

        List<VisaTypeMasterItem> residencyStatusMasterItems = new ArrayList<>();


        VisaTypeMasterItem residencyStatusMasterItem = new VisaTypeMasterItem();
        residencyStatusMasterItem.setId(null);
        residencyStatusMasterItem.setName(activity.getResources().getString(R.string.select_visatype));
        residencyStatusMasterItems.add(residencyStatusMasterItem);

        residencyStatusMasterItems.addAll(profileInfoMaster.getData().getVisaTypeMaster());
        if (residencyStatusMasterItems.size() > 0) {
            ArrayAdapter<VisaTypeMasterItem> adapter = new ArrayAdapter<VisaTypeMasterItem>(activity, R.layout.spinner_text, residencyStatusMasterItems) {
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
            visatypeSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < residencyStatusMasterItems.size(); i++) {
                if (residencyStatusMasterItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthVisaTypeName())) {
                    int spinnerPosition = adapter.getPosition(residencyStatusMasterItems.get(i));
                    visatypeSpinner.setSelection(spinnerPosition);
                }
            }
            visatypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    visatypePosition = position;
                    if (position > 0) {
                        visatypePassData = (VisaTypeMasterItem) parent.getSelectedItem();
                    } else {
                        visatypePassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void residencystatusSpinnerLoad() {

        List<ResidencyStatusMasterItem> residencyStatusMasterItems = new ArrayList<>();


        ResidencyStatusMasterItem residencyStatusMasterItem = new ResidencyStatusMasterItem();
        residencyStatusMasterItem.setId(null);
        residencyStatusMasterItem.setName(activity.getResources().getString(R.string.select_residencystatus));
        residencyStatusMasterItems.add(residencyStatusMasterItem);

        residencyStatusMasterItems.addAll(profileInfoMaster.getData().getResidencyStatusMaster());
        if (residencyStatusMasterItems.size() > 0) {
            ArrayAdapter<ResidencyStatusMasterItem> adapter = new ArrayAdapter<ResidencyStatusMasterItem>(activity, R.layout.spinner_text, residencyStatusMasterItems) {
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
            residencyStatusSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < residencyStatusMasterItems.size(); i++) {
                if (residencyStatusMasterItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthResidencyTypeName())) {
                    int spinnerPosition = adapter.getPosition(residencyStatusMasterItems.get(i));
                    residencyStatusSpinner.setSelection(spinnerPosition);
                }

            }
            residencyStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    residencyStatusPosition = position;
                    if (position > 0) {
                        residencyStatusPassData = (ResidencyStatusMasterItem) parent.getSelectedItem();
                    } else {
                        residencyStatusPassData = null;
                    }

                    if (residencyStatusMasterItems.get(residencyStatusPosition).getName().equalsIgnoreCase("Work visa")) {
                        visatypeTextview.setVisibility(View.VISIBLE);
                        visatypeSpinner.setVisibility(View.VISIBLE);
                        visaexpireTextview.setVisibility(View.VISIBLE);
                        linearVisaExpire.setVisibility(View.VISIBLE);
                    } else {
                        visatypeTextview.setVisibility(View.GONE);
                        visatypeSpinner.setVisibility(View.GONE);
                        visaexpireTextview.setVisibility(View.GONE);
                        linearVisaExpire.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void licenseTrasportSpinnerLoad() {

        List<LicenceTypeItem> licenceTypeItems = new ArrayList<>();


        LicenceTypeItem licenceTypeItem = new LicenceTypeItem();
        licenceTypeItem.setLtTypeId(null);
        licenceTypeItem.setLtName(activity.getResources().getString(R.string.select_license));
        licenceTypeItems.add(licenceTypeItem);

        licenceTypeItems.addAll(profileInfoMaster.getData().getLicenceType());
        if (licenceTypeItems.size() > 0) {
            ArrayAdapter<LicenceTypeItem> adapter = new ArrayAdapter<LicenceTypeItem>(activity, R.layout.spinner_text, licenceTypeItems) {
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
            licenseAndTransportSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < licenceTypeItems.size(); i++) {
                if (licenceTypeItems.get(i).getLtName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getLicenceType())) {
                    int spinnerPosition = adapter.getPosition(licenceTypeItems.get(i));
                    licenseAndTransportSpinner.setSelection(spinnerPosition);
                }
            }
            licenseAndTransportSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    licencePosition = position;
                    if (position > 0) {
                        licencePassData = (LicenceTypeItem) parent.getSelectedItem();
                    } else {
                        licencePassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void intendedDestinationSpinnerLoad() {

        List<IntendedDestinationItem> intendedDestinationItems = new ArrayList<>();


        IntendedDestinationItem intendedDestinationItem = new IntendedDestinationItem();
        intendedDestinationItem.setSmStatusId(null);
        intendedDestinationItem.setSmName(activity.getResources().getString(R.string.select_intended_destination));
        intendedDestinationItems.add(intendedDestinationItem);

        intendedDestinationItems.addAll(profileInfoMaster.getData().getIntendedDestination());
        if (intendedDestinationItems.size() > 0) {
            ArrayAdapter<IntendedDestinationItem> adapter = new ArrayAdapter<IntendedDestinationItem>(activity, R.layout.spinner_text, intendedDestinationItems) {
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
            futureIntendedDestinationSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < intendedDestinationItems.size(); i++) {
                if (intendedDestinationItems.get(i).getSmName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthIntendedDestination())) {
                    int spinnerPosition = adapter.getPosition(intendedDestinationItems.get(i));
                    futureIntendedDestinationSpinner.setSelection(spinnerPosition);
                }
            }
            futureIntendedDestinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    intendedDestinationPosition = position;
                    if (position > 0) {
                        intendedDestinationPassData = (IntendedDestinationItem) parent.getSelectedItem();
                    } else {
                        intendedDestinationPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void perferredcitySpinnerLoad() {

        List<CityListItem> cityListItems = new ArrayList<>();


        CityListItem cityListItem = new CityListItem();
        cityListItem.setCiCityId(null);
        cityListItem.setCiName(activity.getResources().getString(R.string.select_prefcity));
        cityListItems.add(cityListItem);

        cityListItems.addAll(profileInfoMaster.getData().getCityList());
        if (cityListItems.size() > 0) {
            ArrayAdapter<CityListItem> adapter = new ArrayAdapter<CityListItem>(activity, R.layout.spinner_text, cityListItems) {
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
            districtWorkSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < cityListItems.size(); i++) {
                if (cityListItems.get(i).getCiName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getPreferredCityName())) {
                    int spinnerPosition = adapter.getPosition(cityListItems.get(i));
                    districtWorkSpinner.setSelection(spinnerPosition);
                }
            }
            districtWorkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    perferrredcityPosition = position;
                    if (position > 0) {
                        perferrredcityPassData = (CityListItem) parent.getSelectedItem();
                    } else {
                        perferrredcityPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void perferedregionSpinnerLoad() {

        List<RegionListItem> regionListItems = new ArrayList<>();


        RegionListItem regionListItem = new RegionListItem();
        regionListItem.setReRegionId(null);
        regionListItem.setReName(activity.getResources().getString(R.string.select_preferegion));
        regionListItems.add(regionListItem);

        regionListItems.addAll(profileInfoMaster.getData().getRegionList());
        if (regionListItems.size() > 0) {
            ArrayAdapter<RegionListItem> adapter = new ArrayAdapter<RegionListItem>(activity, R.layout.spinner_text, regionListItems) {
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
            preferedRegionSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < regionListItems.size(); i++) {
                if (regionListItems.get(i).getReName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getPreferredRegionName())) {
                    int spinnerPosition = adapter.getPosition(regionListItems.get(i));
                    preferedRegionSpinner.setSelection(spinnerPosition);
                }
            }
            preferedRegionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    perferrredregionPosition = position;
                    if (position > 0) {
                        perferrredregionPassData = (RegionListItem) parent.getSelectedItem();
                    } else {
                        perferrredregionPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void workexperienceSpinnerLoad() {

        List<WorkExperienceMasterItem> workExperienceMasterItems = new ArrayList<>();


        WorkExperienceMasterItem workExperienceMasterItem = new WorkExperienceMasterItem();
        workExperienceMasterItem.setId(null);
        workExperienceMasterItem.setName(activity.getResources().getString(R.string.select_workexperience));
        workExperienceMasterItems.add(workExperienceMasterItem);

        workExperienceMasterItems.addAll(profileInfoMaster.getData().getWorkExperienceMaster());
        if (workExperienceMasterItems.size() > 0) {
            ArrayAdapter<WorkExperienceMasterItem> adapter = new ArrayAdapter<WorkExperienceMasterItem>(activity, R.layout.spinner_text, workExperienceMasterItems) {
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
            workExperienceSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < workExperienceMasterItems.size(); i++) {
                if (workExperienceMasterItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthWorkExperienceName())) {
                    int spinnerPosition = adapter.getPosition(workExperienceMasterItems.get(i));
                    workExperienceSpinner.setSelection(spinnerPosition);
                }
            }
            workExperienceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    workexperiencePosition = position;
                    if (position > 0) {
                        workexperiencePassData = (WorkExperienceMasterItem) parent.getSelectedItem();
                    } else {
                        workexperiencePassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void workavailabilitySpinnerLoad() {

        List<WorkAvailabilityTimingMasterItem> workAvailabilityTimingMasterItems = new ArrayList<>();


        WorkAvailabilityTimingMasterItem workAvailabilityTimingMasterItem = new WorkAvailabilityTimingMasterItem();
        workAvailabilityTimingMasterItem.setId(null);
        workAvailabilityTimingMasterItem.setName(activity.getResources().getString(R.string.select_workavaiability));
        workAvailabilityTimingMasterItems.add(workAvailabilityTimingMasterItem);

        workAvailabilityTimingMasterItems.addAll(profileInfoMaster.getData().getWorkAvailabilityTimingMaster());
        if (workAvailabilityTimingMasterItems.size() > 0) {
            ArrayAdapter<WorkAvailabilityTimingMasterItem> adapter = new ArrayAdapter<WorkAvailabilityTimingMasterItem>(activity, R.layout.spinner_text, workAvailabilityTimingMasterItems) {
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
            workAvailabilitySpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < workAvailabilityTimingMasterItems.size(); i++) {
                if (workAvailabilityTimingMasterItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthWorkAvailabilityTimingName())) {
                    int spinnerPosition = adapter.getPosition(workAvailabilityTimingMasterItems.get(i));
                    workAvailabilitySpinner.setSelection(spinnerPosition);
                }
            }
            workAvailabilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    workavaiabilityPosition = position;
                    if (position > 0) {
                        workavaiabilityPassData = (WorkAvailabilityTimingMasterItem) parent.getSelectedItem();
                    } else {
                        workavaiabilityPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void currentworkstatusSpinnerLoad() {

        List<WorkStatusMasterItem> workStatusMasterItems = new ArrayList<>();


        WorkStatusMasterItem workStatusMasterItem = new WorkStatusMasterItem();
        workStatusMasterItem.setId(null);
        workStatusMasterItem.setName(activity.getResources().getString(R.string.select_workstatus));
        workStatusMasterItems.add(workStatusMasterItem);

        workStatusMasterItems.addAll(profileInfoMaster.getData().getWorkStatusMaster());
        if (workStatusMasterItems.size() > 0) {
            ArrayAdapter<WorkStatusMasterItem> adapter = new ArrayAdapter<WorkStatusMasterItem>(activity, R.layout.spinner_text, workStatusMasterItems) {
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
            currentWorkStatusSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < workStatusMasterItems.size(); i++) {
                if (workStatusMasterItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthWorkStatusName())) {
                    int spinnerPosition = adapter.getPosition(workStatusMasterItems.get(i));
                    currentWorkStatusSpinner.setSelection(spinnerPosition);
                }
            }
            currentWorkStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    currentworkstatusPosition = position;
                    if (position > 0) {
                        currentworkstatusPassData = (WorkStatusMasterItem) parent.getSelectedItem();
                    } else {
                        currentworkstatusPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void ethnicitySpinnerLoad() {

        List<LocationEthnicityItem> locationEthnicityItems = new ArrayList<>();


        LocationEthnicityItem locationEthnicityItem = new LocationEthnicityItem();
        locationEthnicityItem.setId(null);
        locationEthnicityItem.setName(activity.getResources().getString(R.string.select_ethnicity));
        locationEthnicityItems.add(locationEthnicityItem);

        locationEthnicityItems.addAll(profileInfoMaster.getData().getLocationEthnicity());
        if (locationEthnicityItems.size() > 0) {
            ArrayAdapter<LocationEthnicityItem> adapter = new ArrayAdapter<LocationEthnicityItem>(activity, R.layout.spinner_text, locationEthnicityItems) {
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
            ethnicitySpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < locationEthnicityItems.size(); i++) {
                if (locationEthnicityItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthEthnicityName())) {
                    int spinnerPosition = adapter.getPosition(locationEthnicityItems.get(i));
                    ethnicitySpinner.setSelection(spinnerPosition);
                }
            }
            ethnicitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ethnicityPosition = position;
                    if (position > 0) {
                        ethnicityPassData = (LocationEthnicityItem) parent.getSelectedItem();
                    } else {
                        ethnicityPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void IwiSpinnerLoad() {

        List<LocationIwiItem> locationIwiItems = new ArrayList<>();


        LocationIwiItem locationIwiItem = new LocationIwiItem();
        locationIwiItem.setIwIwiId(null);
        locationIwiItem.setIwName(activity.getResources().getString(R.string.select_iwi));
        locationIwiItems.add(locationIwiItem);

        locationIwiItems.addAll(profileInfoMaster.getData().getLocationIwi());
        if (locationIwiItems.size() > 0) {
            ArrayAdapter<LocationIwiItem> adapter = new ArrayAdapter<LocationIwiItem>(activity, R.layout.spinner_text, locationIwiItems) {
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
            iwiSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < locationIwiItems.size(); i++) {
                if (locationIwiItems.get(i).getIwName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getIwName())) {
                    int spinnerPosition = adapter.getPosition(locationIwiItems.get(i));
                    iwiSpinner.setSelection(spinnerPosition);
                }
            }
            iwiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    iwiPosition = position;
                    if (position > 0) {
                        iwiPassData = (LocationIwiItem) parent.getSelectedItem();
                    } else {
                        iwiPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void organisationSpinnerLoad() {

        List<OrganisationDataItem> organisationDataItems = new ArrayList<>();


        OrganisationDataItem organisationDataItem = new OrganisationDataItem();
        organisationDataItem.setOgmOrganisationId(null);
        organisationDataItem.setOgmName(activity.getResources().getString(R.string.select_organisation));
        organisationDataItems.add(organisationDataItem);

        organisationDataItems.addAll(profileInfoMaster.getData().getOrganisationData());
        if (organisationDataItems.size() > 0) {
            ArrayAdapter<OrganisationDataItem> adapter = new ArrayAdapter<OrganisationDataItem>(activity, R.layout.spinner_text, organisationDataItems) {
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
            organisationSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < organisationDataItems.size(); i++) {
                if (organisationDataItems.get(i).getOgmName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getOgmName())) {
                    int spinnerPosition = adapter.getPosition(organisationDataItems.get(i));
                    organisationSpinner.setSelection(spinnerPosition);
                }
            }
            organisationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    organisationPosition = position;
                    if (position > 0) {
                        organisationPassData = (OrganisationDataItem) parent.getSelectedItem();
                    } else {
                        organisationPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void citySpinnerLoad() {

        List<CityListItem> cityListItems = new ArrayList<>();


        CityListItem cityListItem = new CityListItem();
        cityListItem.setCiCityId(null);
        cityListItem.setCiName(activity.getResources().getString(R.string.select_city));
        cityListItems.add(cityListItem);

        cityListItems.addAll(profileInfoMaster.getData().getCityList());
        if (cityListItems.size() > 0) {
            ArrayAdapter<CityListItem> adapter = new ArrayAdapter<CityListItem>(activity, R.layout.spinner_text, cityListItems) {
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
            citySpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < cityListItems.size(); i++) {
                if (cityListItems.get(i).getCiName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getCityName())) {
                    int spinnerPosition = adapter.getPosition(cityListItems.get(i));
                    citySpinner.setSelection(spinnerPosition);
                }
            }
            citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    cityPosition = position;
                    if (position > 0) {
                        cityPassData = (CityListItem) parent.getSelectedItem();
                    } else {
                        cityPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void regionSpinnerLoad() {

        List<RegionListItem> regionListItems = new ArrayList<>();


        RegionListItem regionListItem = new RegionListItem();
        regionListItem.setReRegionId(null);
        regionListItem.setReName(activity.getResources().getString(R.string.select_region));
        regionListItems.add(regionListItem);

        regionListItems.addAll(profileInfoMaster.getData().getRegionList());
        if (regionListItems.size() > 0) {
            ArrayAdapter<RegionListItem> adapter = new ArrayAdapter<RegionListItem>(activity, R.layout.spinner_text, regionListItems) {
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
            regionSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            for (int i = 0; i < regionListItems.size(); i++) {
                if (regionListItems.get(i).getReName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getRegionName())) {
                    int spinnerPosition = adapter.getPosition(regionListItems.get(i));
                    regionSpinner.setSelection(spinnerPosition);
                }
            }
            regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    regionPosition = position;
                    if (position > 0) {
                        regionPassData = (RegionListItem) parent.getSelectedItem();
                        call_city_api(regionPassData.getReRegionId());
                    } else {
                        regionPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }


    private void call_city_api(String reRegionId) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<List<CityListItem>> call = ApiClient.getApiInterface().getprofileCity(Constants.getApiKey(activity),Constants.getAccessKey(activity), Constants.getToken(activity), reRegionId);
            call.enqueue(new Callback<List<CityListItem>>() {
                @Override
                public void onResponse(@NonNull Call<List<CityListItem>> call, @NonNull Response<List<CityListItem>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            //if (response.body().getStatus() == 1) {
                            profileInfoMaster.getData().getCityList().clear();
                            profileInfoMaster.getData().setCityList(response.body());
                            citySpinnerLoad();
                            //  }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ConnCity", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<List<CityListItem>> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ConnCity", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }


    private void gender_spinner_load() {

        List<GenderMasterItem> genderMasters = new ArrayList<>();


        GenderMasterItem genderMaster = new GenderMasterItem();
        genderMaster.setId(null);
        genderMaster.setName(activity.getResources().getString(R.string.select_geneder));
        genderMasters.add(genderMaster);

        genderMasters.addAll(profileInfoMaster.getData().getGenderMaster());
        if (genderMasters.size() > 0) {
            ArrayAdapter<GenderMasterItem> adapter = new ArrayAdapter<GenderMasterItem>(activity, R.layout.spinner_text, genderMasters) {
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
            gender_spinner.setAdapter(adapter);
            Log.d("ProfileFilter", "category_spinner_load: " + new Gson().toJson(genderMasters));
            for (int i = 0; i < genderMasters.size(); i++) {
                if (genderMasters.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthGenderName())) {
                    int spinnerPosition = adapter.getPosition(genderMasters.get(i));
                    gender_spinner.setSelection(spinnerPosition);
                }
            }
            gender_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    genederPosition = position;
                    if (position > 0) {
                        genderPassData = (GenderMasterItem) parent.getSelectedItem();
                    } else {
                        genderPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void pass_Data() {

        if (organisationPassData != null) {
            currentorgansizationStatusId = organisationPassData.getOgmOrganisationId();
        }

        if (ethnicityPassData != null) {
            ethnicity = ethnicityPassData.getId();
        }

        if (iwiPassData != null) {
            lwi = iwiPassData.getIwIwiId();
        }


        if (!editMobileno.getText().toString().isEmpty()) {
            moileNo = editMobileno.getText().toString();
        }

        if (currentworkstatusPassData != null) {
            currentWorkStatusId = currentworkstatusPassData.getId();
        }

        if (workavaiabilityPassData != null) {
            workAvailabilityId = workavaiabilityPassData.getId();
        }

        if (workexperiencePassData != null) {
            workExperienceId = workexperiencePassData.getId();
        }

        if (!yourAvailabilitySpinner.getText().toString().isEmpty()) {
            yourAvailabilityWorkperWeek = yourAvailabilitySpinner.getText().toString();
        }

        if (perferrredregionPassData != null) {
            perferredWorkRegionId = perferrredregionPassData.getReRegionId();
        }

        if (perferrredcityPassData != null) {
            perferrredWorkCityId = perferrredcityPassData.getCiCityId();
        }



        if (licencePassData != null) {
            LicenceTypeId = licencePassData.getLtTypeId();
        }

        if (residencyStatusPassData != null) {
            residencyStatusId = residencyStatusPassData.getId();
        }

        if (visatypePassData != null) {
            visaTypeId = visatypePassData.getId();
        }

        if (!edtVisaMonth.getText().toString().isEmpty()) {
            visaMonth = edtVisaMonth.getText().toString();
        }

        if (!edtVisaYear.getText().toString().isEmpty()) {
            visaYear = edtVisaYear.getText().toString();
        }

        if (!instagramLinkEdittext.getText().toString().isEmpty()) {
            instagramUrl = instagramLinkEdittext.getText().toString();
        }

        if (!twitterLinkEdittext.getText().toString().isEmpty()) {
            twitterUrl = twitterLinkEdittext.getText().toString();
        }


        if (!googlePlusLinkEdittext.getText().toString().isEmpty()) {
            googleplusUrl = googlePlusLinkEdittext.getText().toString();
        }

        if (!linkedinLinkEdittext.getText().toString().isEmpty()) {
            linkeninUrl = linkedinLinkEdittext.getText().toString();
        }

        if (!githubLinkEdittext.getText().toString().isEmpty()) {
            githubUrl = githubLinkEdittext.getText().toString();
        }

        if (!behanceLinkEdittext.getText().toString().isEmpty()) {
            behanceUrl = behanceLinkEdittext.getText().toString();
        }

        if (!aboutMeTextview.getText().toString().isEmpty()) {
            aboutme = aboutMeTextview.getText().toString();
        }
        if (!firstnameEditText.getText().toString().isEmpty()) {
            firstName = firstnameEditText.getText().toString();
            if (!lastnameEditText.getText().toString().isEmpty()) {
                lastName = lastnameEditText.getText().toString();
                if (!dobEdittext.getText().toString().isEmpty()) {
                    dob = dobEdittext.getText().toString();
                    //  dob = AppUtils.dateformatddmmyyyy(dob);
                    if (genderPassData != null) {
                        gender = genderPassData.getId();
                        if (regionPassData != null) {
                            regionId = regionPassData.getReRegionId();
                            if (cityPassData != null) {
                                cityId = cityPassData.getCiCityId();
                                if (!editEmail.getText().toString().isEmpty()) {
                                    emailId = editEmail.getText().toString();
                                    if (intendedDestinationPassData != null) {
                                        futhurIndentededDesitinationId = intendedDestinationPassData.getSmStatusId();
                                        onPassDataListener.onPassData(firstName, lastName, AppUtils.dateformatyyyymmdd(dob), gender, regionId, cityId, currentorgansizationStatusId, ethnicity,
                                                lwi, emailId, moileNo, currentWorkStatusId, workAvailabilityId, workExperienceId, yourAvailabilityWorkperWeek, perferredWorkRegionId,
                                                perferrredWorkCityId, futhurIndentededDesitinationId, LicenceTypeId, residencyStatusId, visaTypeId, visaMonth,

                                                visaYear, instagramUrl, twitterUrl, googleplusUrl, linkeninUrl, githubUrl, behanceUrl, aboutme, true);
                                        //  dismiss();
                                    }else{
                                        MyToast.errorMessage("Please select futher intended desctination",activity);
                                    }
                                }else{
                                    MyToast.errorMessage("Please enter email",activity);
                                }
                            }else{
                                MyToast.errorMessage("Please select city",activity);
                            }
                        }else{
                            MyToast.errorMessage("Please select region",activity);
                        }
                    }else{
                        MyToast.errorMessage("Please select gender",activity);
                    }
                }else{
                    MyToast.errorMessage("Please enter dob",activity);
                }
            }else{
                MyToast.errorMessage("Please enter lastname",activity);
            }
        }else{
            MyToast.errorMessage("Please enter firstname",activity);
        }












    }

    public interface OnPassDataListener {
        void onPassData(String firstName,
                        String lastName,
                        String dob,
                        String gender,
                        String regionId,
                        String cityId,
                        String currentorgansizationStatusId,
                        String ethnicity,
                        String lwi,
                        String emailId,
                        String moileNo,
                        String currentWorkStatusId,
                        String workAvailabilityId,
                        String workExperienceId,
                        String yourAvailabilityWorkperWeek,
                        String perferredWorkRegionId,
                        String perferrredWorkCityId,
                        String futhurIndentededDesitinationId,
                        String LicenceTypeId,
                        String residencyStatusId,
                        String visaTypeId,
                        String visaMonth,
                        String visaYear,
                        String instagramUrl,
                        String twitterUrl,
                        String googleplusUrl,
                        String linkeninUrl,
                        String githubUrl,
                        String behanceUrl,
                        String aboutme,
                        boolean filter);
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    public static void dismissDialog(){
        // activity.dismiss();
    }
}
