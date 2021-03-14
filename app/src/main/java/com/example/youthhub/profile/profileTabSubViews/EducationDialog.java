package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.profileeducation.update.EducationItem;
import com.example.youthhub.resModel.profile.profileeducation.update.ProfileUpdateEducationResponse;
import com.example.youthhub.resModel.profile.profilemaster.NceaResponse;
import com.example.youthhub.resModel.profile.profilemaster.OrganizationCategoryResponse;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.profilemaster.QualificationCategoryResponse;
import com.example.youthhub.resModel.profile.profilemaster.RegionResponse;
import com.example.youthhub.resModel.profile.profilemaster.qualificationprovider.QualificatiionProviderResponse;
import com.example.youthhub.resModel.profile.profilemaster.qualificationprovider.QualificationProviderItem;
import com.example.youthhub.resModel.profile.profilemaster.titlequalification.QualificationTitleItem;
import com.example.youthhub.resModel.profile.profilemaster.titlequalification.TitleQualificationResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
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

public class EducationDialog extends Dialog {

    private static final String TAG = EducationDialog.class.getSimpleName();
    Activity activity;
    @BindView(R.id.education_txt)
    TextView educationTxt;
    @BindView(R.id.region_txt)
    TextView regionTxt;
    @BindView(R.id.org_category_txt)
    TextView orgCategoryTxt;
    @BindView(R.id.region)
    AppCompatSpinner region;
    @BindView(R.id.org_category_spinner)
    AppCompatSpinner orgCategorySpinner;
    @BindView(R.id.ncea_txt)
    TextView nceaTxt;
    @BindView(R.id.ncea)
    AppCompatSpinner ncea;
    @BindView(R.id.qua_category_txt)
    TextView quaCategoryTxt;
    @BindView(R.id.qua_category_spinner)
    AppCompatSpinner quaCategorySpinner;
    @BindView(R.id.qualification_txt)
    TextView qualificationTxt;
    @BindView(R.id.qualification)
    EditText qualification;
    @BindView(R.id.start_date_txt)
    TextView startDateTxt;
    @BindView(R.id.end_date_txt)
    TextView endDateTxt;
    @BindView(R.id.start_date)
    EditText startDate;
    @BindView(R.id.end_date)
    EditText endDate;
    @BindView(R.id.qua_provider_txt)
    TextView quaProviderTxt;
    @BindView(R.id.qua_title_txt)
    TextView quaTitleTxt;
    @BindView(R.id.qua_provider)
    AppCompatSpinner quaProvider;
    @BindView(R.id.qua_title)
    AppCompatSpinner quaTitle;
    @BindView(R.id.title_qualification_txt)
    TextView titleQualificationTxt;
    @BindView(R.id.title_qualification)
    EditText titleQualification;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    ProfileAddMasterResponse profileAddMasterResponse;
    @BindView(R.id.qua_provider_view)
    View quaProviderView;
    @BindView(R.id.qua_title_view)
    View quaTitleView;

    QualificatiionProviderResponse qualificatiionProviderResponse;
    ProfileUpdateEducationResponse profileUpdateEducationResponse;
    TitleQualificationResponse titleQualificationResponse;

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;
    @BindView(R.id.is_progress_txt)
    TextView isProgressTxt;
    @BindView(R.id.is_process_checkbox)
    SwitchCompat isProcessCheckbox;

    private Integer regionPosition = null;
    private RegionResponse regionPassData = null;
    private Integer organizationCategoryPosition = null;
    private OrganizationCategoryResponse organizationCategoryPassData = null;
    private Integer qualificationCategoryPosition = null;
    private QualificationCategoryResponse qualificationCategoryPassData = null;
    private NceaResponse nceaPassData = null;
    private Integer nceaPosition = null;
    private QualificationProviderItem quaProviderPassData = null;
    private Integer quaProviderPosition = null;
    private Integer quaTitlePosition = null;
    private QualificationTitleItem quaTitlePassData = null;
    private String regionId = null;
    private String organizationCategoryId = null;
    private String nceaId = null;
    private String qualificationCategoryId = null;
    private String quaProviderId = null;
    private String quaTitlePassId = null;
    private String qualificationedt = null;
    private String titleQualificationId = null;
    private String startDateId = null;
    private String endDateId = null;
    private String qualificaionId = null;
    private boolean isUpdated = false;

    final Calendar myCalendar = Calendar.getInstance();
    EducationItem educationItem;
    int position;
    private String isinprocess = "0";

    public EducationDialog(Activity activity,
                           ProfileAddMasterResponse profileAddMasterResponse, boolean isUpdated) {
        super(activity);
        this.activity = activity;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = isUpdated;


    }

    public EducationDialog(Activity activity, EducationItem educationItem,
                           ProfileAddMasterResponse profileAddMasterResponse, boolean isUpdated, int position) {
        super(activity);
        this.activity = activity;
        this.educationItem = educationItem;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = isUpdated;
        this.position = position;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.education_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        if (isUpdated) {
            updatedUI();

        } else {
            addUI(profileAddMasterResponse);
        }

    }

    private void updatedUI() {
        Log.d(TAG, "updatedUI: " + new Gson().toJson(educationItem));
        region_spinner_load(isUpdated);
        organizationCategory_spinner_load(isUpdated);
        qualificationCategory_spinner_load(isUpdated);
        ncea_spinner_load(isUpdated);
        qualification.setText(educationItem.getQauDescription());
        if (educationItem.getQauStartDate() != null)
            startDate.setText(AppUtils.dateformatddMMMyyyy(educationItem.getQauStartDate()));
        if (educationItem.getQauEndDate() != null)
            endDate.setText(AppUtils.dateformatddMMMyyyy(educationItem.getQauEndDate()));
        if (educationItem.getIsInprogress().equals("0")) {
            isProcessCheckbox.setChecked(false);
            endDate.setVisibility(View.VISIBLE);
            endDateTxt.setVisibility(View.VISIBLE);
        } else {
            isProcessCheckbox.setChecked(true);
            endDate.setVisibility(View.GONE);
            endDateTxt.setVisibility(View.GONE);
        }
    }

    private void addUI(ProfileAddMasterResponse profileAddMasterResponse) {
        region_spinner_load(isUpdated);
        organizationCategory_spinner_load(isUpdated);
        qualificationCategory_spinner_load(isUpdated);
        ncea_spinner_load(isUpdated);
    }

    private void callTypeFace() {
        educationTxt.setTypeface(FontTypeFace.fontBold(activity));
        regionTxt.setTypeface(FontTypeFace.fontBold(activity));
        orgCategoryTxt.setTypeface(FontTypeFace.fontBold(activity));
        nceaTxt.setTypeface(FontTypeFace.fontBold(activity));
        quaCategoryTxt.setTypeface(FontTypeFace.fontBold(activity));
        qualificationTxt.setTypeface(FontTypeFace.fontBold(activity));
        startDateTxt.setTypeface(FontTypeFace.fontBold(activity));
        endDateTxt.setTypeface(FontTypeFace.fontBold(activity));
        quaProviderTxt.setTypeface(FontTypeFace.fontBold(activity));
        quaTitleTxt.setTypeface(FontTypeFace.fontBold(activity));
        titleQualificationTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
        isProgressTxt.setTypeface(FontTypeFace.fontBold(activity));

        titleQualificationTxt.setVisibility(View.GONE);
        titleQualification.setVisibility(View.GONE);

        AppUtils.textAddAstreik(regionTxt, "Region");
        AppUtils.textAddAstreik(orgCategoryTxt, "Organisation Category");
        AppUtils.textAddAstreik(nceaTxt, "NCEA");
        AppUtils.textAddAstreik(quaCategoryTxt, "Qualification Category");
        AppUtils.textAddAstreik(quaProviderTxt, "Qualification Provider");
        AppUtils.textAddAstreik(quaTitleTxt, "Title of Qualification");
       // AppUtils.textAddAstreik(titleQualificationTxt, "Elaborate on Qualification");
        AppUtils.textAddAstreik(startDateTxt, "Start Date");
        AppUtils.textAddAstreik(qualificationTxt, "Elaborate on Qualification");

        isProcessCheckbox.setChecked(false);
        isProcessCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    endDate.setVisibility(View.INVISIBLE);
                    endDateTxt.setVisibility(View.INVISIBLE);
                    isinprocess = "1";

                } else {
                    endDate.setVisibility(View.VISIBLE);
                    endDateTxt.setVisibility(View.VISIBLE);
                    isinprocess = "0";

                }
            }
        });
    }

    @OnClick({R.id.apply_btn, R.id.cancel_btn, R.id.qua_provider_view, R.id.qua_title_view, R.id.start_date, R.id.end_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateEducation();
                } else {
                    addEducation();
                }

                break;
            case R.id.cancel_btn:
                dismiss();
                break;
            case R.id.start_date:
                DatePickerDialog picker = new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                picker.getDatePicker().setTag("start");
                picker.show();

                break;
            case R.id.end_date:
                DatePickerDialog picker1 = new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                picker1.getDatePicker().setTag("end");
                picker1.show();
                break;
            case R.id.qua_provider_view:
                if (organizationCategoryPosition == 0) {
                    MyToast.errorMessage("Kindly Select Organization Category", activity);
                }
                break;
            case R.id.qua_title_view:
                if (organizationCategoryPosition == 0) {
                    MyToast.errorMessage("Kindly Select Qualification Provider", activity);
                } else {
                    if (quaProviderPosition == 0) {
                        MyToast.errorMessage("Kindly Select Qualification Provider", activity);
                    }
                }
                break;

        }
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            if (view.getTag().equals("start")) {
                AppUtils.updateLabel(startDate, myCalendar);
            } else if (view.getTag().equals("end")) {
                AppUtils.updateLabel(endDate, myCalendar);
            }
        }

    };


    private void call_QualificationProvider(String organizationcategoryid) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<QualificatiionProviderResponse> call = ApiClient.getApiInterface().getQualficationProvider(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    organizationcategoryid);

            call.enqueue(new Callback<QualificatiionProviderResponse>() {
                @Override
                public void onResponse(@NonNull Call<QualificatiionProviderResponse> call, @NonNull Response<QualificatiionProviderResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                qualificatiionProviderResponse = response.body();
                                Log.d(TAG, "onResponse:ProfileInfoDialog " + new Gson().toJson(qualificatiionProviderResponse));
                                //       update_ui(profileInfoMaster);
                                qualificationProvider_spinner_load(isUpdated);
                            } else {
                                Log.d(TAG, "onResponse:call_organizationCategory else ");

                                //  MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                        Loader.showLoad(activity, false);
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<QualificatiionProviderResponse> call, @NonNull Throwable t) {
                    call_QualificationProvider(organizationcategoryid);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void call_titleQualification(String qualificationprovider_id) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<TitleQualificationResponse> call = ApiClient.getApiInterface().getTitleQualfication(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    qualificationprovider_id);

            call.enqueue(new Callback<TitleQualificationResponse>() {
                @Override
                public void onResponse(@NonNull Call<TitleQualificationResponse> call, @NonNull Response<TitleQualificationResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                titleQualificationResponse = response.body();
                                Log.d(TAG, "onResponse:ProfileInfoDialog " + new Gson().toJson(titleQualificationResponse));
                                //       update_ui(profileInfoMaster);
                                titlequalification_spinner_load(isUpdated);
                                //  qualificationProvider_spinner_load(false);
                            } else {
                                Log.d(TAG, "onResponse:call_organizationCategory else ");

                                //  MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                        Loader.showLoad(activity, false);
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<TitleQualificationResponse> call, @NonNull Throwable t) {
                    call_titleQualification(qualificationprovider_id);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }


    private void region_spinner_load(boolean selected) {

        List<RegionResponse> regionResponses = new ArrayList<>();


        RegionResponse regionResponse = new RegionResponse();
        regionResponse.setReRegionId(null);
        regionResponse.setReName(activity.getResources().getString(R.string.select_region));
        regionResponses.add(regionResponse);

        regionResponses.addAll(profileAddMasterResponse.getData().getRegion_list());
        if (regionResponses.size() > 0) {
            ArrayAdapter<RegionResponse> adapter = new ArrayAdapter<RegionResponse>(activity, R.layout.spinner_text, regionResponses) {
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
            region.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < regionResponses.size(); i++) {
                    if (regionResponses.get(i).getReName().equalsIgnoreCase(educationItem.getReName())) {
                        int spinnerPosition = adapter.getPosition(regionResponses.get(i));
                        region.setSelection(spinnerPosition);
                    }
                }
            }
            region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    regionPosition = position;
                    if (position > 0) {
                        regionPassData = (RegionResponse) parent.getSelectedItem();
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

    private void organizationCategory_spinner_load(boolean selected) {

        List<OrganizationCategoryResponse> organizationCategoryResponses = new ArrayList<>();


        OrganizationCategoryResponse organizationCategoryResponse = new OrganizationCategoryResponse();
        organizationCategoryResponse.setOgcCategoryId(null);
        organizationCategoryResponse.setOgcName(activity.getResources().getString(R.string.select_organisation));
        organizationCategoryResponses.add(organizationCategoryResponse);

        organizationCategoryResponses.addAll(profileAddMasterResponse.getData().getOrganisation_category());
        if (organizationCategoryResponses.size() > 0) {
            ArrayAdapter<OrganizationCategoryResponse> adapter = new ArrayAdapter<OrganizationCategoryResponse>(activity, R.layout.spinner_text, organizationCategoryResponses) {
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
            orgCategorySpinner.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < organizationCategoryResponses.size(); i++) {
                    if (organizationCategoryResponses.get(i).getOgcName().equalsIgnoreCase(educationItem.getOgcName())) {
                        int spinnerPosition = adapter.getPosition(organizationCategoryResponses.get(i));
                        orgCategorySpinner.setSelection(spinnerPosition);
                    }
                }
            }
            orgCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    organizationCategoryPosition = position;
                    if (position > 0) {
                        organizationCategoryPassData = (OrganizationCategoryResponse) parent.getSelectedItem();
                        call_QualificationProvider(organizationCategoryPassData.getOgcCategoryId());
                        quaProviderView.setVisibility(View.GONE);
                    } else {
                        organizationCategoryPassData = null;
                        quaProviderView.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void qualificationProvider_spinner_load(boolean selected) {

        List<QualificationProviderItem> qualificatiionProviderResponses = new ArrayList<>();


        QualificationProviderItem qualificationProviderItem = new QualificationProviderItem();
        qualificationProviderItem.setQapProviderId(null);
        qualificationProviderItem.setQapName(activity.getResources().getString(R.string.select_qualificationprovider));
        qualificatiionProviderResponses.add(qualificationProviderItem);

        qualificatiionProviderResponses.addAll(qualificatiionProviderResponse.getData().getQualificationProvider());
        if (qualificatiionProviderResponses.size() > 0) {
            ArrayAdapter<QualificationProviderItem> adapter = new ArrayAdapter<QualificationProviderItem>(activity, R.layout.spinner_text, qualificatiionProviderResponses) {
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
            quaProvider.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < qualificatiionProviderResponses.size(); i++) {
                    if (qualificatiionProviderResponses.get(i).getQapName().equalsIgnoreCase(educationItem.getQapName())) {
                        int spinnerPosition = adapter.getPosition(qualificatiionProviderResponses.get(i));
                        quaProvider.setSelection(spinnerPosition);
                    }
                }
            }
            quaProvider.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    quaProviderPosition = position;
                    if (position > 0) {
                        quaProviderPassData = (QualificationProviderItem) parent.getSelectedItem();
                        call_titleQualification(quaProviderPassData.getQapProviderId());
                        quaTitleView.setVisibility(View.GONE);
                    } else {
                        quaTitleView.setVisibility(View.VISIBLE);

                        quaProviderPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }


    private void titlequalification_spinner_load(boolean selected) {

        List<QualificationTitleItem> qualificationTitleItems = new ArrayList<>();


        QualificationTitleItem qualificationTitleItem = new QualificationTitleItem();
        qualificationTitleItem.setQamQualificationId(null);
        qualificationTitleItem.setQamTitle(activity.getResources().getString(R.string.select_titlequalification));
        qualificationTitleItems.add(qualificationTitleItem);

        qualificationTitleItems.addAll(titleQualificationResponse.getData().getQualificationTitle());
        if (qualificationTitleItems.size() > 0) {
            ArrayAdapter<QualificationTitleItem> adapter = new ArrayAdapter<QualificationTitleItem>(activity, R.layout.spinner_text, qualificationTitleItems) {
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
            quaTitle.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < qualificationTitleItems.size(); i++) {
                    if (qualificationTitleItems.get(i).getQamTitle().equalsIgnoreCase(educationItem.getQamTitle())) {
                        int spinnerPosition = adapter.getPosition(qualificationTitleItems.get(i));
                        quaTitle.setSelection(spinnerPosition);
                    }
                }
            }
            quaTitle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    quaTitlePosition = position;
                    if (position > 0) {
                        quaTitlePassData = (QualificationTitleItem) parent.getSelectedItem();
                    } else {
                        quaTitlePassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void qualificationCategory_spinner_load(boolean selected) {

        List<QualificationCategoryResponse> qualificationCategoryResponses = new ArrayList<>();


        QualificationCategoryResponse qualificationCategoryResponse = new QualificationCategoryResponse();
        qualificationCategoryResponse.setQacCategoryId(null);
        qualificationCategoryResponse.setQacName(activity.getResources().getString(R.string.select_qualification));

        qualificationCategoryResponses.add(qualificationCategoryResponse);

        qualificationCategoryResponses.addAll(profileAddMasterResponse.getData().getQualification_category());
        if (qualificationCategoryResponses.size() > 0) {
            ArrayAdapter<QualificationCategoryResponse> adapter = new ArrayAdapter<QualificationCategoryResponse>(activity, R.layout.spinner_text, qualificationCategoryResponses) {
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
            quaCategorySpinner.setAdapter(adapter);
            Log.d(TAG, "qualificationCategory_spinner_load: ");
            if (selected) {
                for (int i = 0; i < qualificationCategoryResponses.size(); i++) {
                    if (qualificationCategoryResponses.get(i).getQacName().equalsIgnoreCase(educationItem.getQacName())) {
                        int spinnerPosition = adapter.getPosition(qualificationCategoryResponses.get(i));
                        quaCategorySpinner.setSelection(spinnerPosition);
                        quaTitle.setSelection(0);
                    }
                }
            }
            quaCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    qualificationCategoryPosition = position;
                    if (position > 0) {
                        qualificationCategoryPassData = (QualificationCategoryResponse) parent.getSelectedItem();
                    } else {
                        qualificationCategoryPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void ncea_spinner_load(boolean selected) {

        List<NceaResponse> nceaResponses = new ArrayList<>();


        NceaResponse nceaResponse = new NceaResponse();
        nceaResponse.setId(null);
        nceaResponse.setName(activity.getResources().getString(R.string.select_ncea));

        nceaResponses.add(nceaResponse);

        nceaResponses.addAll(profileAddMasterResponse.getData().getNcea_level());
        if (nceaResponses.size() > 0) {
            ArrayAdapter<NceaResponse> adapter = new ArrayAdapter<NceaResponse>(activity, R.layout.spinner_text, nceaResponses) {
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
            ncea.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < nceaResponses.size(); i++) {
                    if (nceaResponses.get(i).getName().equalsIgnoreCase(educationItem.getQauNceaLevelName())) {
                        int spinnerPosition = adapter.getPosition(nceaResponses.get(i));
                        ncea.setSelection(spinnerPosition);
                    }
                }
            }
            ncea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    nceaPosition = position;
                    if (position > 0) {
                        nceaPassData = (NceaResponse) parent.getSelectedItem();
                    } else {
                        nceaPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    private void addEducation() {


        if (isProcessCheckbox.isChecked()) {
            isinprocess = "1";
        } else {
            isinprocess = "0";
        }

        Log.d(TAG, "addEducation: "+isProcessCheckbox);

        if (!titleQualification.getText().toString().isEmpty()) {
            titleQualificationId = titleQualification.getText().toString();

        } else {
            titleQualificationId = "";
        }


        if (!endDate.getText().toString().isEmpty()) {
            endDateId = endDate.getText().toString();
            endDateId = AppUtils.dateformatddmmyyyy(endDateId);
        }

        if (!qualification.getText().toString().isEmpty()) {
            qualificationedt = qualification.getText().toString();
        }
        if (regionPassData != null) {
            regionId = regionPassData.getReRegionId();
            if (organizationCategoryPassData != null) {
                organizationCategoryId = organizationCategoryPassData.getOgcCategoryId();
                if (nceaPassData != null) {
                    nceaId = nceaPassData.getId();
                    if (qualificationCategoryPassData != null) {
                        qualificationCategoryId = qualificationCategoryPassData.getQacCategoryId();
                        if (quaProviderPassData != null) {
                            quaProviderId = quaProviderPassData.getQapProviderId();
                            if (!qualification.getText().toString().isEmpty()) {
                                qualificationedt = qualification.getText().toString();
                            if (quaTitlePassData != null) {
                                quaTitlePassId = quaTitlePassData.getQamQualificationId();
                                if (!startDate.getText().toString().isEmpty()) {
                                    startDateId = startDate.getText().toString();
                                    startDateId = AppUtils.dateformatddmmyyyy(startDateId);
                                    if (isProcessCheckbox.isChecked()) {
                                        onPassDataListener.onPassData(regionId, organizationCategoryId, nceaId, qualificationCategoryId, quaProviderId,
                                                quaTitlePassId, titleQualificationId, startDateId, endDateId, qualificationedt,isinprocess, true);
                                        dismiss();
                                    } else {
                                        if (!endDate.getText().toString().isEmpty()) {

                                            endDateId = endDate.getText().toString();
                                            endDateId = AppUtils.dateformatddmmyyyy(endDateId);
                                            onPassDataListener.onPassData(regionId, organizationCategoryId, nceaId, qualificationCategoryId, quaProviderId,
                                                    quaTitlePassId, titleQualificationId, startDateId, endDateId, qualificationedt,isinprocess, true);
                                            dismiss();

                                        } else {
                                            MyToast.errorMessage("Please select end date", activity);
                                        }
                                    }
                                }else{
                                    MyToast.errorMessage("Please select start date", activity);
                                }

                            }else{
                                MyToast.errorMessage("Please select Title of Qualification", activity);
                            }
                        }else{
                            MyToast.errorMessage("Please enter elaborate on qulification", activity);
                        }
                        }else{
                            MyToast.errorMessage("Please select Qualification Provider", activity);
                        }
                    }else{
                        MyToast.errorMessage("Please select Qualification Category", activity);
                    }
                }else{
                    MyToast.errorMessage("Please select NCEA", activity);
                }
            }else{
                MyToast.errorMessage("Please select Organisation Category", activity);
            }
        }else{
            MyToast.errorMessage("Please select region", activity);
        }








        Log.d(TAG, "addEducation: +\"!!\"+" + regionId + "!!" + organizationCategoryId + "!!" + nceaId + "!!" + qualificationCategoryId + "!!" + quaProviderId + "!!" +
                quaTitlePassId + "!!" + titleQualificationId + "!!" + startDateId + "!!" + endDateId + "!!" + qualificationedt);


    }

    private void upddateEducation() {

        qualificaionId = educationItem.getQauQualificationId();
        if (isProcessCheckbox.isChecked()) {
            isinprocess = "1";
        } else {
            isinprocess = "0";
        }



        if (!titleQualification.getText().toString().isEmpty()) {
            titleQualificationId = titleQualification.getText().toString();

        } else {
            titleQualificationId = "";
        }


        if (!endDate.getText().toString().isEmpty()) {
            endDateId = endDate.getText().toString();
            endDateId = AppUtils.dateformatddmmyyyy(endDateId);
        }


        if (regionPassData != null) {
            regionId = regionPassData.getReRegionId();
            if (organizationCategoryPassData != null) {
                organizationCategoryId = organizationCategoryPassData.getOgcCategoryId();
                if (nceaPassData != null) {
                    nceaId = nceaPassData.getId();
                    if (qualificationCategoryPassData != null) {
                        qualificationCategoryId = qualificationCategoryPassData.getQacCategoryId();
                        if (!qualification.getText().toString().isEmpty()) {
                            qualificationedt = qualification.getText().toString();
                            if (quaProviderPassData != null) {
                                quaProviderId = quaProviderPassData.getQapProviderId();
                                if (quaTitlePassData != null) {
                                    quaTitlePassId = quaTitlePassData.getQamQualificationId();
                                if (!startDate.getText().toString().isEmpty()) {
                                    startDateId = startDate.getText().toString();
                                    startDateId = AppUtils.dateformatddmmyyyy(startDateId);
                                    if (isProcessCheckbox.isChecked()) {
                                        onUpdatePassDataListener.onUpdatePassData(qualificaionId, regionId, organizationCategoryId, nceaId, qualificationCategoryId, quaProviderId,
                                                quaTitlePassId, titleQualificationId, startDateId, endDateId, qualificationedt,isinprocess, position, true);
                                        dismiss();
                                    } else {
                                        if (!endDate.getText().toString().isEmpty()) {

                                            endDateId = endDate.getText().toString();
                                            endDateId = AppUtils.dateformatddmmyyyy(endDateId);
                                            onUpdatePassDataListener.onUpdatePassData(qualificaionId, regionId, organizationCategoryId, nceaId, qualificationCategoryId, quaProviderId,
                                                    quaTitlePassId, titleQualificationId, startDateId, endDateId, qualificationedt,isinprocess, position, true);
                                            dismiss();

                                        } else {
                                            MyToast.errorMessage("Please select end date", activity);
                                        }
                                    }
                                }else{
                                    MyToast.errorMessage("Please select start date", activity);
                                }

                            }else{
                                MyToast.errorMessage("Please select Title of Qualification", activity);
                            } }else{
                            MyToast.errorMessage("Please select Qualification Provider", activity);
                        }
                        }else{
                            MyToast.errorMessage("Please enter elaborate on qualification", activity);
                        }
                    }else{
                        MyToast.errorMessage("Please select Qualification Category", activity);
                    }
                }else{
                    MyToast.errorMessage("Please select NCEA", activity);
                }
            }else{
                MyToast.errorMessage("Please select Organisation Category", activity);
            }
        }else{
            MyToast.errorMessage("Please select region", activity);
        }


        Log.d(TAG, "updateEducation: +\"!!\"+" + qualificaionId + "!!" + regionId + "!!" + organizationCategoryId + "!!" + nceaId + "!!" + qualificationCategoryId + "!!" + quaProviderId + "!!" +
                quaTitlePassId + "!!" + titleQualificationId + "!!" + startDateId + "!!" + endDateId + "!!" + qualificationedt);


    }

    public interface OnPassDataListener {
        void onPassData(String regionId, String organizationCategoryId, String nceaId, String qualificationCategoryId,
                        String quaProviderId, String quaTitlePassId, String titleQualificationId, String startDateId,
                        String endDateId, String qualificationedt,String isinprocess, boolean b);

       /* void onPassData(String wishlistid,
                        String organizationCategoryId, String nceaId, String qualificationCategoryId, String quaProviderId, String quaTitlePassId, String titleQualificationId, String startDateId, String endDateId, String qualificationedt, boolean filter);
*/
    }

    public interface OnUpdatePassDataListener {


        void onUpdatePassData(String qualicationId, String regionId, String organizationCategoryId, String nceaId, String qualificationCategoryId,
                              String quaProviderId, String quaTitlePassId, String titleQualificationId, String startDateId,
                              String endDateId, String qualificationedt,String isinprocess, int position, boolean b);
       /* void onPassData(String wishlistid,
                        String organizationCategoryId, String nceaId, String qualificationCategoryId, String quaProviderId, String quaTitlePassId, String titleQualificationId, String startDateId, String endDateId, String qualificationedt, boolean filter);
*/
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }


}
