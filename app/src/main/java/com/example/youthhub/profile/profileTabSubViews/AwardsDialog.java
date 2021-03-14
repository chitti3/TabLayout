package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.profileinfo.AchievementItem;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.youthhub.profile.ProfileInfoDialog.TAG;

public class AwardsDialog extends Dialog {

    Activity activity;
    @BindView(R.id.achievement_textview)
    TextView achievementTextview;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.title_edittext)
    EditText titleEdittext;
    @BindView(R.id.occupation_textview)
    TextView occupationTextview;
    @BindView(R.id.occupation_edittext)
    EditText occupationEdittext;
    @BindView(R.id.description_textview)
    TextView descriptionTextview;
    @BindView(R.id.description_edittext)
    EditText descriptionEdittext;
    @BindView(R.id.date_textview)
    TextView dateTextview;

    @BindView(R.id.issued_by)
    TextView issuedBy;
    @BindView(R.id.issued_by_edittext)
    EditText issuedByEdittext;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    @BindView(R.id.date_spinner)
    AppCompatEditText dateSpinner;

    private boolean isUpdated = false;

    final Calendar myCalendar = Calendar.getInstance();

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;
    private String awardsid = null;
    private String titletxt = null;
    private String occupationtxt = null;
    private String descriptiontxt = null;
    private String issuedBytxt = null;
    private String dateSpinnertxt = null;

    AchievementItem achievementItem;

    int position;

    public AwardsDialog(Activity activity) {
        super(activity);

        this.activity = activity;
    }

    public AwardsDialog(Activity activity, AchievementItem achievementItem, boolean isUpdated, int position) {
        super(activity);

        this.activity = activity;
        this.isUpdated = isUpdated;
        this.achievementItem = achievementItem;
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.achievement_awards_dialogue);
        ButterKnife.bind(this);
        callTypeFace();
        Log.d(TAG, "onCreate: " + isUpdated);
        if (isUpdated) {
            updatedUI();

        } else {
            addUI();
        }

    }

    private void addUI() {
    }

    private void updatedUI() {
        titleEdittext.setText(achievementItem.getAcuTitle());
        occupationEdittext.setText(achievementItem.getAcuOccupation());
        descriptionEdittext.setText(achievementItem.getAcuDescription());
        issuedByEdittext.setText(achievementItem.getAcuProviderName());

        dateSpinner.setText(achievementItem.getIssuedYear());
    }

    private void callTypeFace() {
        achievementTextview.setTypeface(FontTypeFace.fontBold(activity));
        titleTextview.setTypeface(FontTypeFace.fontBold(activity));
        occupationTextview.setTypeface(FontTypeFace.fontBold(activity));
        descriptionTextview.setTypeface(FontTypeFace.fontBold(activity));
        dateTextview.setTypeface(FontTypeFace.fontBold(activity));
        issuedBy.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(titleTextview,"Title");
        AppUtils.textAddAstreik(occupationTextview,"Occupation");
        AppUtils.textAddAstreik(descriptionTextview,"Description");
        AppUtils.textAddAstreik(dateTextview,"Date");
        AppUtils.textAddAstreik(issuedBy,"Issued By");
    }


    @OnClick({R.id.date_spinner, R.id.apply_btn, R.id.cancel_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.date_spinner:
                DatePickerDialog picker = new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                picker.getDatePicker().setTag("start");
                picker.show();
                break;
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateAwards();
                } else {
                    addAwards();
                }
                break;
            case R.id.cancel_btn:
                dismiss();
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
                AppUtils.updateLabel(dateSpinner, myCalendar);
            }
        }

    };

    private void addAwards() {
   if (!titleEdittext.getText().toString().isEmpty()) {
            titletxt = titleEdittext.getText().toString();

        }

        if (!occupationEdittext.getText().toString().isEmpty()) {
            occupationtxt = occupationEdittext.getText().toString();

        }

        if (!descriptionEdittext.getText().toString().isEmpty()) {
            descriptiontxt = descriptionEdittext.getText().toString();

        }

        if (!issuedByEdittext.getText().toString().isEmpty()) {
            issuedBytxt = issuedByEdittext.getText().toString();

        }

        if (!dateSpinner.getText().toString().isEmpty()) {
            dateSpinnertxt = dateSpinner.getText().toString();
            dateSpinnertxt = AppUtils.dateformatddmmyyyy(dateSpinnertxt);
        }

        if (titleEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter title",activity);
        }else if (occupationEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter occupation",activity);
        }else if (descriptionEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter description",activity);
        }else if (issuedByEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter issueBy",activity);
        }else if (dateSpinner.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter date",activity);
        }else{
            onPassDataListener.onExperiencePassData(titletxt, occupationtxt, descriptiontxt, dateSpinnertxt, issuedBytxt, true);
            dismiss();
        }




    }

    private void upddateAwards() {

        awardsid = achievementItem.getAcuAchievementId();
     if (!titleEdittext.getText().toString().isEmpty()) {
            titletxt = titleEdittext.getText().toString();

        }

        if (!occupationEdittext.getText().toString().isEmpty()) {
            occupationtxt = occupationEdittext.getText().toString();

        }

        if (!descriptionEdittext.getText().toString().isEmpty()) {
            descriptiontxt = descriptionEdittext.getText().toString();

        }

        if (!issuedByEdittext.getText().toString().isEmpty()) {
            issuedBytxt = issuedByEdittext.getText().toString();

        }

        if (!dateSpinner.getText().toString().isEmpty()) {
            dateSpinnertxt = dateSpinner.getText().toString();
            dateSpinnertxt = AppUtils.dateformatMMMyyyy(dateSpinnertxt);
        }


        if (titleEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter title",activity);
        }else if (occupationEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter occupation",activity);
        }else if (descriptionEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter description",activity);
        }else if (issuedByEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter issueBy",activity);
        }else if (dateSpinner.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter date",activity);
        }else{
            Log.d(TAG, "upddateAwards: "+dateSpinnertxt);
            onUpdatePassDataListener.onUpdatePassData(awardsid, titletxt, occupationtxt, descriptiontxt, dateSpinnertxt, issuedBytxt,position, true);
            dismiss();
        }




    }


    public interface OnPassDataListener {
        void onExperiencePassData(String titletxt, String occupationtxt, String descriptiontxt, String dateSpinnertxt, String issuedBytxt, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String awardsid, String titletxt, String occupationtxt, String descriptiontxt, String dateSpinnertxt, String issuedBytxt, int position, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }

}
