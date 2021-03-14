package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.profileexperience.add.updatemaster.ExperienceItem;
import com.example.youthhub.resModel.profile.profileinfo.EmuResponsibilitiesItem;
import com.example.youthhub.resModel.profile.profilemaster.BusinessCategory;
import com.example.youthhub.resModel.profile.profilemaster.JobType;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.youthhub.profile.ProfileFragment.TAG;

public class ExperienceDialog extends Dialog {

    Activity activity;
    @BindView(R.id.experience_txt)
    TextView experienceTxt;
    @BindView(R.id.job_title_txt)
    TextView jobTitleTxt;
    @BindView(R.id.job_type_txt)
    TextView jobTypeTxt;
    @BindView(R.id.job_title)
    EditText jobTitle;
    @BindView(R.id.job_type_spinner)
    AppCompatSpinner jobTypeSpinner;
    @BindView(R.id.job_designation_txt)
    TextView jobDesignationTxt;
    @BindView(R.id.job_designation)
    EditText jobDesignation;
    @BindView(R.id.job_description_txt)
    TextView jobDescriptionTxt;
    @BindView(R.id.job_description)
    EditText jobDescription;
    @BindView(R.id.start_date_txt)
    TextView startDateTxt;
    @BindView(R.id.end_date_txt)
    TextView endDateTxt;
    @BindView(R.id.start_date)
    EditText startDate;
    @BindView(R.id.end_date)
    EditText endDate;
    @BindView(R.id.work_ind_txt)
    TextView workIndTxt;
    @BindView(R.id.sub_work_ind_txt)
    TextView subWorkIndTxt;
    @BindView(R.id.work_ind)
    AppCompatSpinner workInd;
    @BindView(R.id.sub_work_ind)
    AppCompatSpinner subWorkInd;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    ProfileAddMasterResponse profileAddMasterResponse;
    @BindView(R.id.is_progress_txt)
    TextView isProgressTxt;
    @BindView(R.id.is_process_checkbox)
    SwitchCompat isProcessCheckbox;
    @BindView(R.id.exprecycle_responability_txt)
    TextView exprecycleResponabilityTxt;
    @BindView(R.id.recycle_responability)
    RecyclerView recycleResponability;
    @BindView(R.id.btn_responaility_add)
    ImageView btnResponailityAdd;
    private Integer jobTypeposition = null;
    private JobType jobTypepassData = null;
    private Integer workIndustryposition = null;
    private BusinessCategory workIndustrypassData = null;
    private boolean isUpdated = false;

    final Calendar myCalendar = Calendar.getInstance();

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;

    private String startDatetxt = null;
    private String endDatetxt = null;
    private String jobDesignationtxt = null;
    private String jobTitletxt = null;
    private String jobTypeId = null;
    private String jobDescriptiontxt = null;
    private String responability = "";
    private String isinprocess = "0";
    private String jobId = null;

    ExperienceItem experienceItem = new ExperienceItem();
    int position;
    KeyResponabilityAdapter keyResponabilityAdapter;
    EmuResponsibilitiesItem emuResponsibilities;
    public List<EmuResponsibilitiesItem> emuResponsibilitiesItemList;


    public ExperienceDialog(Activity activity, ProfileAddMasterResponse profileAddMasterResponse, boolean isUpdated) {
        super(activity);
        this.activity = activity;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = isUpdated;
    }

    public ExperienceDialog(Activity activity, ExperienceItem experienceItem, ProfileAddMasterResponse profileAddMasterResponse, boolean b, int position) {
        super(activity);
        this.activity = activity;
        this.experienceItem = experienceItem;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = b;
        this.position = position;
        Log.d(TAG, "ExperienceDialog:1 "+new Gson().toJson(experienceItem));
       // updatedUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.experience_dialog);
        Log.d(TAG, "updatedUI:0 ");
        ButterKnife.bind(this);
        call_adapter();
        callTypeFace();
        // updateUi(profileAddMasterResponse);
        Log.d(TAG, "updatedUI: ");
        if (isUpdated) {
            Log.d(TAG, "updatedUI:1 ");
            updatedUI();

        } else {
            Log.d(TAG, "updatedUI:2 ");
            addUI();
        }
        jobDesignation.setImeOptions(EditorInfo.IME_ACTION_DONE);
        jobDesignation.setRawInputType(InputType.TYPE_CLASS_TEXT);

    }

    private void updatedUI() {
        Log.d(TAG, "ExperienceDialog:2 "+new Gson().toJson(experienceItem));
        jobType_spinner_load(isUpdated);
        jobTitle.setText(experienceItem.getEmuEmployerName());
        jobDesignation.setText(experienceItem.getEmuDesignation());
        jobDescription.setText(experienceItem.getEmuDescription());
        if (experienceItem.getIsInprogress() == 0) {
            isProcessCheckbox.setChecked(false);
            endDate.setVisibility(View.VISIBLE);
            endDateTxt.setVisibility(View.VISIBLE);
        } else {
            isProcessCheckbox.setChecked(true);
            endDate.setVisibility(View.GONE);
            endDateTxt.setVisibility(View.GONE);
        }
        if (experienceItem.getStartDate() != null)
            startDate.setText(AppUtils.dateformatddMMMyyyy(experienceItem.getStartDate()));
        if (experienceItem.getEndDate() != null)
            endDate.setText(AppUtils.dateformatddMMMyyyy(experienceItem.getEndDate()));
        Log.d(TAG, "updatedUI:data c "+new Gson().toJson(experienceItem));
        keyResponabilityAdapter = new KeyResponabilityAdapter(activity,experienceItem.getEmuResponsibilities());
        recycleResponability.setAdapter(keyResponabilityAdapter);
        keyResponabilityAdapter.notifyDataSetChanged();

        for (int i = 0; i < experienceItem.getEmuResponsibilities().size(); i++) {
            emuResponsibilities.setName(experienceItem.getEmuResponsibilities().get(i).getName());
            emuResponsibilitiesItemList.add(emuResponsibilities);
        }
        Log.d(TAG, "updatedUI:data 1 ");
    }

    private void addUI() {
        Log.d(TAG, "addUI: "+new Gson().toJson(experienceItem.getEmuResponsibilities()));
        Log.d(TAG, "addUI:emuResponsibilitiesItemList "+new Gson().toJson(emuResponsibilitiesItemList));

        jobType_spinner_load(isUpdated);
        emuResponsibilities.setName("");
        emuResponsibilitiesItemList.add(emuResponsibilities);
        Log.d(TAG, "addUI:emuResponsibilitiesItemList 1"+new Gson().toJson(emuResponsibilitiesItemList));
        experienceItem.setEmuResponsibilities(emuResponsibilitiesItemList);
        Log.d(TAG, "addUI: 1"+new Gson().toJson(experienceItem.getEmuResponsibilities()));
        keyResponabilityAdapter = new KeyResponabilityAdapter(activity,experienceItem.getEmuResponsibilities());
        recycleResponability.setAdapter(keyResponabilityAdapter);
        keyResponabilityAdapter.notifyDataSetChanged();

    }

    private void updateUi(ProfileAddMasterResponse profileAddMasterResponse) {
        //  jobType_spinner_load(profileAddMasterResponse);
        //  businessCategory_spinner_load(profileAddMasterResponse);
    }

    private void jobType_spinner_load(boolean profileAddMasterResponse1) {
        List<JobType> jobTypes = new ArrayList<>();


        JobType jobType = new JobType();
        jobType.setJtTypeId(null);
        jobType.setJtName(activity.getResources().getString(R.string.select_job_type));
        jobTypes.add(jobType);

        jobTypes.addAll(profileAddMasterResponse.getData().getJobType());
        if (jobTypes.size() > 0) {
            ArrayAdapter<JobType> adapter = new ArrayAdapter<JobType>(activity, R.layout.spinner_text, jobTypes) {
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
            jobTypeSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            if (profileAddMasterResponse1) {
                for (int i = 0; i < jobTypes.size(); i++) {
                    if (jobTypes.get(i).getJtName().equalsIgnoreCase(experienceItem.getEmuJtTypeName())) {
                        int spinnerPosition = adapter.getPosition(jobTypes.get(i));
                        jobTypeSpinner.setSelection(spinnerPosition);
                    }
                }
            }
            jobTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    jobTypeposition = position;
                    if (position > 0) {
                        jobTypepassData = (JobType) parent.getSelectedItem();
                    } else {
                        jobTypepassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }

    private void businessCategory_spinner_load(ProfileAddMasterResponse profileAddMasterResponse) {
        List<BusinessCategory> businessCategories = new ArrayList<>();


        BusinessCategory businessCategory = new BusinessCategory();
        businessCategory.setIcaCategoryId(null);
        businessCategory.setIcaName(activity.getResources().getString(R.string.select_buinesscategory));
        businessCategories.add(businessCategory);

        businessCategories.addAll(profileAddMasterResponse.getData().getBusinessCategoryList());
        if (businessCategories.size() > 0) {
            ArrayAdapter<BusinessCategory> adapter = new ArrayAdapter<BusinessCategory>(activity, R.layout.spinner_text, businessCategories) {
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
            workInd.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
            /*for (int i = 0; i < wishlistItems.size(); i++) {
                if (wishlistItems.get(i).getWitName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthVisaTypeName())) {
                    int spinnerPosition = adapter.getPosition(wishlistItems.get(i));
                    categorySpinner.setSelection(spinnerPosition);
                }
            }*/
            workInd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    workIndustryposition = position;
                    if (position > 0) {
                        workIndustrypassData = (BusinessCategory) parent.getSelectedItem();
                    } else {
                        workIndustrypassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }
    private void call_adapter() {
        Log.d(TAG, "updatedUI:00 ");
        recycleResponability.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recycleResponability.setLayoutManager(linearLayoutManager);
        Log.d(TAG, "updatedUI:000 ");
    }

    private void callTypeFace() {

    /*    LinearLayoutManager techSkills_LayoutManager = new LinearLayoutManager(activity);
        recycleResponability.setLayoutManager(techSkills_LayoutManager);*/
         emuResponsibilities = new EmuResponsibilitiesItem();
       // experienceItem=new ExperienceItem();
        emuResponsibilitiesItemList=new ArrayList<>();

        experienceTxt.setTypeface(FontTypeFace.fontBold(activity));
        jobTitleTxt.setTypeface(FontTypeFace.fontBold(activity));
        jobTypeTxt.setTypeface(FontTypeFace.fontBold(activity));
        jobDesignationTxt.setTypeface(FontTypeFace.fontBold(activity));
        jobDescriptionTxt.setTypeface(FontTypeFace.fontBold(activity));
        startDateTxt.setTypeface(FontTypeFace.fontBold(activity));
        endDateTxt.setTypeface(FontTypeFace.fontBold(activity));
        workIndTxt.setTypeface(FontTypeFace.fontBold(activity));
        subWorkIndTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
        isProgressTxt.setTypeface(FontTypeFace.fontBold(activity));
        exprecycleResponabilityTxt.setTypeface(FontTypeFace.fontBold(activity));
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

        AppUtils.textAddAstreik(jobTitleTxt, "Job Title");
        AppUtils.textAddAstreik(jobTypeTxt, "Job Type");
        AppUtils.textAddAstreik(jobDescriptionTxt, "Job Description");
        AppUtils.textAddAstreik(jobDescriptionTxt, "Job Description");
        AppUtils.textAddAstreik(jobDesignationTxt, "Employer");
        AppUtils.textAddAstreik(startDateTxt, "Start Date");
    }

    @OnClick({R.id.apply_btn, R.id.cancel_btn, R.id.start_date, R.id.end_date, R.id.btn_responaility_add})
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
                case R.id.btn_responaility_add:
                    Log.d(TAG, "onViewClicked:1 btn_responaility_add"+new Gson().toJson(emuResponsibilitiesItemList));
                    Log.d(TAG, "onViewClicked:1 btn_responaility_add emuResponsibilities"+new Gson().toJson(emuResponsibilities));
                    emuResponsibilities = new EmuResponsibilitiesItem();
                    emuResponsibilities.setName("");
                    Log.d(TAG, "onViewClicked:1 btn_responaility_add emuResponsibilities after"+new Gson().toJson(emuResponsibilities));

                    emuResponsibilitiesItemList.add(emuResponsibilities);
                    Log.d(TAG, "onViewClicked:2 btn_responaility_add"+new Gson().toJson(emuResponsibilitiesItemList));

                    experienceItem.setEmuResponsibilities(emuResponsibilitiesItemList);
                    Log.d(TAG, "onViewClicked: btn_responaility_add"+new Gson().toJson(emuResponsibilitiesItemList));
                    keyResponabilityAdapter = new KeyResponabilityAdapter(activity,experienceItem.getEmuResponsibilities());
                    recycleResponability.setAdapter(keyResponabilityAdapter);
                    keyResponabilityAdapter.notifyDataSetChanged();
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


    private void addEducation() {

        if (isProcessCheckbox.isChecked()) {
            isinprocess = "1";
        } else {
            isinprocess = "0";
        }
       /* if (keyResponabilityAdapter.getData().length()>0) {
            responability = keyResponabilityAdapter.getData();
        } else {
            MyToast.errorMessage("Responability should be empty", activity);
        }*/
        if (!jobTitle.getText().toString().isEmpty()) {
            jobTitletxt = jobTitle.getText().toString();
            if (jobTypepassData != null) {
                jobTypeId = jobTypepassData.getJtTypeId();
                if (!jobDesignation.getText().toString().isEmpty()) {
                    jobDesignationtxt = jobDesignation.getText().toString();
                    if (!jobDescription.getText().toString().isEmpty()) {
                        jobDescriptiontxt = jobDescription.getText().toString();
                        if (!startDate.getText().toString().isEmpty()) {
                            startDatetxt = startDate.getText().toString();
                            startDatetxt = AppUtils.dateformatddmmyyyy(startDatetxt);

                            if (isProcessCheckbox.isChecked()) {
                                onPassDataListener.onPassData(jobTitletxt, jobTypeId, jobDesignationtxt, jobDescriptiontxt, startDatetxt,
                                        endDatetxt, isinprocess, responability, true);
                                dismiss();
                            } else {
                                if (!endDate.getText().toString().isEmpty()) {

                                    endDatetxt = endDate.getText().toString();
                                    endDatetxt = AppUtils.dateformatddmmyyyy(endDatetxt);
                                    onPassDataListener.onPassData(jobTitletxt, jobTypeId, jobDesignationtxt, jobDescriptiontxt, startDatetxt,
                                            endDatetxt, isinprocess, responability, true);
                                    dismiss();

                                } else {
                                    MyToast.errorMessage("Please select end date", activity);
                                }
                            }


                        } else {
                            MyToast.errorMessage("Please select start date", activity);
                        }
                    } else {
                        MyToast.errorMessage("Please enter job description", activity);
                    }
                } else {
                    MyToast.errorMessage("Please enter employer", activity);
                }
            } else {
                MyToast.errorMessage("Please select job type", activity);
            }
        } else {
            MyToast.errorMessage("Please enter job title", activity);
        }


    }

    private void upddateEducation() {
        if (isProcessCheckbox.isChecked()) {
            isinprocess = "1";
        } else {
            isinprocess = "0";
        }
        jobId = experienceItem.getEmuEmploymentId();


        if (!jobTitle.getText().toString().isEmpty()) {
            jobTitletxt = jobTitle.getText().toString();
            if (jobTypepassData != null) {
                jobTypeId = jobTypepassData.getJtTypeId();
                if (!jobDesignation.getText().toString().isEmpty()) {
                    jobDesignationtxt = jobDesignation.getText().toString();
                    if (!jobDescription.getText().toString().isEmpty()) {
                        jobDescriptiontxt = jobDescription.getText().toString();
                        if (!startDate.getText().toString().isEmpty()) {
                            startDatetxt = startDate.getText().toString();
                            startDatetxt = AppUtils.dateformatddmmyyyy(startDatetxt);
                      /*      if (keyResponabilityAdapter.getData().length()>0) {
                                responability = keyResponabilityAdapter.getData();*/
                            if (isProcessCheckbox.isChecked()) {
                                onUpdatePassDataListener.onUpdatePassData(jobId, jobTitletxt, jobTypeId, jobDesignationtxt, jobDescriptiontxt, startDatetxt,
                                        endDatetxt, isinprocess, responability,position, true);
                                dismiss();
                            } else {
                                if (!endDate.getText().toString().isEmpty()) {
                                    endDatetxt = endDate.getText().toString();
                                    endDatetxt = AppUtils.dateformatddmmyyyy(endDatetxt);
                                    onUpdatePassDataListener.onUpdatePassData(jobId, jobTitletxt, jobTypeId, jobDesignationtxt, jobDescriptiontxt, startDatetxt,
                                            endDatetxt, isinprocess, responability,position, true);
                                    dismiss();
                                } else {
                                    MyToast.errorMessage("Please select end date", activity);
                                }
                            }
                          /*  } else {
                                MyToast.errorMessage("Responability should be empty", activity);
                            }*/
                        } else {
                            MyToast.errorMessage("Please select start date", activity);
                        }
                    } else {
                        MyToast.errorMessage("Please enter job description", activity);
                    }
                } else {
                    MyToast.errorMessage("Please enter employer", activity);
                }
            } else {
                MyToast.errorMessage("Please select job type", activity);
            }
        } else {
            MyToast.errorMessage("Please enter job title", activity);
        }

    }


    public interface OnPassDataListener {
        void onPassData(String jobTitletxt, String jobTypeId, String jobDesignationtxt, String jobDescriptiontxt, String startDatetxt, String endDatetxt, String isinprocess, String responability, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String jobId, String jobTitletxt, String jobTypeId, String jobDesignationtxt, String jobDescriptiontxt, String startDatetxt, String endDatetxt, String isinprocess, String responability,int position, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }

}