package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.SwitchCompat;
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
import com.example.youthhub.resModel.profile.profileinfo.AchievementItem;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.resModel.profile.profilemaster.VolunteerngCategoryResponse;
import com.example.youthhub.resModel.profile.volunteer.add.create.updatemaster.VolunteeringItem;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VolunteerDialog extends Dialog {

     int position;
    Activity activity;
    @BindView(R.id.volunteer_txt)
    TextView volunteerTxt;
    @BindView(R.id.role_txt)
    TextView roleTxt;
    @BindView(R.id.role)
    EditText role;
    @BindView(R.id.organisation_txt)
    TextView organisationTxt;
    @BindView(R.id.organisation)
    EditText organisation;
    @BindView(R.id.description_txt)
    TextView descriptionTxt;
    @BindView(R.id.description)
    EditText description;
    @BindView(R.id.start_date_txt)
    TextView startDateTxt;
    @BindView(R.id.end_date_txt)
    TextView endDateTxt;
    @BindView(R.id.start_date)
    EditText startDate;
    @BindView(R.id.end_date)
    EditText endDate;
    @BindView(R.id.org_cat_txt)
    TextView orgCatTxt;
    @BindView(R.id.org_cat_spinner)
    AppCompatSpinner orgCatSpinner;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    ProfileAddMasterResponse profileAddMasterResponse;
    boolean isUpdated = false;
    @BindView(R.id.is_progress_txt)
    TextView isProgressTxt;

    @BindView(R.id.is_process_checkbox)
    SwitchCompat isProcessCheckbox;
    private VolunteerngCategoryResponse volcatPassData = null;
    private Integer volcatPosition = null;

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;
    private String isinprocess = "0";
    private String volcatId = null;
    private String rolettxt = null;
    private String startDatetxt = null;
    private String endDatetxt = null;
    private String organisationtxt = null;
    private String descriptiontxt = null;
    private String volunteerId = null;
    final Calendar myCalendar = Calendar.getInstance();
    VolunteeringItem volunteeringItem;

    public VolunteerDialog(Activity activity, ProfileAddMasterResponse profileAddMasterResponse, boolean isUpdated) {
        super(activity);
        this.activity = activity;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = isUpdated;
    }

    public VolunteerDialog(Activity activity, VolunteeringItem volunteeringItem, ProfileAddMasterResponse profileAddMasterResponse, boolean isUpdated, int position) {
        super(activity);
        this.activity = activity;
        this.volunteeringItem = volunteeringItem;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = isUpdated;
        this.position = position;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.volunteer_dialog);
        ButterKnife.bind(this);

        callTypeFace();
        if (isUpdated) {
            updatedUI();
        } else {
            addUI(profileAddMasterResponse);
        }
    }

    private void updatedUI() {
        cause_spinner_load(isUpdated);
        role.setText(volunteeringItem.getVouTitle());
        organisation.setText(volunteeringItem.getVouProviderName());
        description.setText(volunteeringItem.getVouDescription());
        if (volunteeringItem.getIsInprogress().equals("0")) {
            isProcessCheckbox.setChecked(false);
            endDate.setVisibility(View.GONE);
            endDateTxt.setVisibility(View.GONE);
        }else{
            isProcessCheckbox.setChecked(true);
            endDate.setVisibility(View.VISIBLE);
            endDateTxt.setVisibility(View.VISIBLE);
        }
        if (volunteeringItem.getVouStartDate() != null)
            startDate.setText(AppUtils.dateformatddMMMyyyy(volunteeringItem.getVouStartDate()));
        if (volunteeringItem.getVouEndDate() != null)
            endDate.setText(AppUtils.dateformatddMMMyyyy(volunteeringItem.getVouEndDate()));
    }


    private void addUI(ProfileAddMasterResponse profileAddMasterResponse) {
        cause_spinner_load(isUpdated);
       // isProcessCheckbox.setChecked(true);
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


    private void cause_spinner_load(boolean selected) {

        List<VolunteerngCategoryResponse> volunteerngCategoryResponses = new ArrayList<>();


        VolunteerngCategoryResponse volunteerngCategoryResponse = new VolunteerngCategoryResponse();
        volunteerngCategoryResponse.setVocCategoryId(null);
        volunteerngCategoryResponse.setVocName(activity.getResources().getString(R.string.select_volcat));
        volunteerngCategoryResponses.add(volunteerngCategoryResponse);

        volunteerngCategoryResponses.addAll(profileAddMasterResponse.getData().getVolunteering_category());
        if (volunteerngCategoryResponses.size() > 0) {
            ArrayAdapter<VolunteerngCategoryResponse> adapter = new ArrayAdapter<VolunteerngCategoryResponse>(activity, R.layout.spinner_text, volunteerngCategoryResponses) {
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
            orgCatSpinner.setAdapter(adapter);
            if (selected) {
                for (int i = 0; i < volunteerngCategoryResponses.size(); i++) {
                    if (volunteerngCategoryResponses.get(i).getVocName().equalsIgnoreCase(volunteeringItem.getVocName())) {
                        int spinnerPosition = adapter.getPosition(volunteerngCategoryResponses.get(i));
                        orgCatSpinner.setSelection(spinnerPosition);
                    }
                }
            }
            orgCatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    volcatPosition = position;
                    if (position > 0) {
                        volcatPassData = (VolunteerngCategoryResponse) parent.getSelectedItem();
                    } else {
                        volcatPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }


    private void callTypeFace() {
        volunteerTxt.setTypeface(FontTypeFace.fontBold(activity));
        roleTxt.setTypeface(FontTypeFace.fontBold(activity));
        organisationTxt.setTypeface(FontTypeFace.fontBold(activity));
        descriptionTxt.setTypeface(FontTypeFace.fontBold(activity));
        startDateTxt.setTypeface(FontTypeFace.fontBold(activity));
        endDateTxt.setTypeface(FontTypeFace.fontBold(activity));
        orgCatTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));
        isProgressTxt.setTypeface(FontTypeFace.fontBold(activity));
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

        AppUtils.textAddAstreik(roleTxt,"Role");
        AppUtils.textAddAstreik(organisationTxt,"Organisation");
        AppUtils.textAddAstreik(descriptionTxt,"Description");
        AppUtils.textAddAstreik(startDateTxt,"Start Date");
        AppUtils.textAddAstreik(orgCatTxt,"Cause");


    }

    @OnClick({R.id.apply_btn, R.id.cancel_btn, R.id.start_date, R.id.end_date, R.id.is_process_checkbox})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateVolunteerExperience();
                } else {
                    addVolunteerExperience();
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

        }
    }


    private void addVolunteerExperience() {
        if (isProcessCheckbox.isChecked()){
            isinprocess="0";
        }else {
            isinprocess="1";
        }
        if (!role.getText().toString().isEmpty()) {
            rolettxt = role.getText().toString();
            if (!organisation.getText().toString().isEmpty()) {
                organisationtxt = organisation.getText().toString();
                if (!description.getText().toString().isEmpty()) {
                    descriptiontxt = description.getText().toString();
                    if (volcatPassData != null) {
                        volcatId = volcatPassData.getVocCategoryId();
                        if (isProcessCheckbox.isChecked()) {
                            if (!startDate.getText().toString().isEmpty()) {
                                startDatetxt = startDate.getText().toString();
                                startDatetxt = AppUtils.dateformatddmmyyyy(startDatetxt);
                                onPassDataListener.onPassData(volcatId, rolettxt, startDatetxt, endDatetxt, organisationtxt,
                                        descriptiontxt, isinprocess, true);
                                dismiss();
                            }else{
                                MyToast.errorMessage("Please Select Volunteer Start Date",activity);
                            }
                        }else{
                            if (!startDate.getText().toString().isEmpty()) {
                                startDatetxt = startDate.getText().toString();
                                startDatetxt = AppUtils.dateformatddmmyyyy(startDatetxt);
                                if (!endDate.getText().toString().isEmpty()) {
                                    endDatetxt = endDate.getText().toString();
                                    endDatetxt = AppUtils.dateformatddmmyyyy(endDatetxt);
                                    onPassDataListener.onPassData(volcatId, rolettxt, startDatetxt, endDatetxt, organisationtxt,
                                            descriptiontxt, isinprocess, true);
                                    dismiss();
                                }else{
                                    MyToast.errorMessage("Please Select Volunteer End Date",activity);
                                }
                            }else{
                                MyToast.errorMessage("Please Select Volunteer Start Date",activity);
                            }
                        }
                    }else{
                        MyToast.errorMessage("Please Select Volunteer Category",activity);
                    }

                }else{
                    MyToast.errorMessage("Please Select Volunteer Description",activity);
                }
            }else{
                MyToast.errorMessage("Please Select Volunteer Organisation",activity);
            }
        } else {
            rolettxt = "";
            MyToast.errorMessage("Please Select Volunteer Role",activity);
        }
        if (volcatPassData != null) {
            volcatId = volcatPassData.getVocCategoryId();
        }else{
            MyToast.errorMessage("Please Select Volunteer Category",activity);
        }




     /*   if (!startDate.getText().toString().isEmpty()) {
            startDatetxt = startDate.getText().toString();
            startDatetxt = AppUtils.dateformatddmmyyyy(startDatetxt);
        }

        if (!endDate.getText().toString().isEmpty()) {
            endDatetxt = endDate.getText().toString();
            endDatetxt = AppUtils.dateformatddmmyyyy(endDatetxt);
        }

        if (!organisation.getText().toString().isEmpty()) {
            organisationtxt = organisation.getText().toString();
        }
        if (!description.getText().toString().isEmpty()) {
            descriptiontxt = description.getText().toString();
        }*/




    }

    private void upddateVolunteerExperience() {

        volunteerId = volunteeringItem.getVouQualificationId();

        if (volcatPassData != null) {
            volcatId = volcatPassData.getVocCategoryId();
        }


        if (!role.getText().toString().isEmpty()) {
            rolettxt = role.getText().toString();

        } else {
            rolettxt = "";
        }

        if (!startDate.getText().toString().isEmpty()) {
            startDatetxt = startDate.getText().toString();
            startDatetxt = AppUtils.dateformatddmmyyyy(startDatetxt);
        }

        if (!endDate.getText().toString().isEmpty()) {
            endDatetxt = endDate.getText().toString();
            endDatetxt = AppUtils.dateformatddmmyyyy(endDatetxt);
        }

        if (!organisation.getText().toString().isEmpty()) {
            organisationtxt = organisation.getText().toString();
        }
        if (!description.getText().toString().isEmpty()) {
            descriptiontxt = description.getText().toString();
        }
        if (isProcessCheckbox.isChecked()){
            isinprocess="0";
        }else {
            isinprocess="1";
        }

        onUpdatePassDataListener.onUpdatePassData(volunteerId, volcatId, rolettxt, startDatetxt, endDatetxt, organisationtxt,
                descriptiontxt, isinprocess, true);
        dismiss();

    }

    public interface OnPassDataListener {
        void onPassData(String volcatId, String rolettxt, String startDatetxt, String endDatetxt, String organisationtxt, String descriptiontxt, String isinprocess, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String volunteerId, String volcatId, String rolettxt, String startDatetxt, String endDatetxt, String organisationtxt, String descriptiontxt, String isinprocess, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }
}
