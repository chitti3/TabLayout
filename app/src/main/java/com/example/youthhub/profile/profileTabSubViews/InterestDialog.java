package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.profileinfo.InterestsItem;
import com.example.youthhub.resModel.profile.profileinfo.TechnicalSkillsItem;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InterestDialog extends Dialog {

    Activity activity;


    boolean isUpdated = false;

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;
    @BindView(R.id.interests_skills_textview)
    TextView interestsSkillsTextview;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.interest_edittext)
    EditText interestEdittext;
    @BindView(R.id.apply_btn)
    Button applyBtn;


    private String interestId = null;
    InterestsItem interestsItem;
    int position;
    private String interesttxt = null;

    public InterestDialog(Activity activity) {
        super(activity);

        this.activity = activity;
    }

    public InterestDialog(Activity activity, InterestsItem interestsItem, boolean b, int position) {
        super(activity);
        this.activity = activity;
        this.interestsItem = interestsItem;
        this.isUpdated = b;
        this.position = position;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.interest_dialog);
        ButterKnife.bind(this);
        callTypeFace();

        if (isUpdated) {
            updatedUI();
        } else {
            addUI();
        }
    }

    private void addUI() {

    }

    private void updatedUI() {
        interestEdittext.setText(interestsItem.getInuName());

    }

    private void callTypeFace() {
        interestsSkillsTextview.setTypeface(FontTypeFace.fontBold(activity));
        titleTextview.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(titleTextview, "Interests");
    }


    private void addInterest() {

        if (!interestEdittext.getText().toString().isEmpty()) {
            interesttxt = interestEdittext.getText().toString();
        }
        if (interestEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter interest",activity);
        }else {
            onPassDataListener.onInterestPassData(interesttxt, true);
            dismiss();
        }
    }

    private void upddateInterest() {

        interestId = interestsItem.getInuInterestId();
   if (!interestEdittext.getText().toString().isEmpty()) {
            interesttxt = interestEdittext.getText().toString();
        }
        if (interestEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter interest",activity);
        }else {
            onUpdatePassDataListener.onUpdatePassData(interestId, interesttxt,  true);
            dismiss();
        }




    }



    @OnClick({R.id.interests_skills_textview, R.id.apply_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.interests_skills_textview:
                dismiss();
                break;
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateInterest();
                } else {
                    addInterest();
                }
                break;
        }
    }

    public interface OnPassDataListener {
        void onInterestPassData(String interesttxt, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String interestId, String interesttxt, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }
}