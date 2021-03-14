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
import com.example.youthhub.resModel.profile.profileinfo.TechnicalSkillsItem;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TechnicalSkillsDialog extends Dialog {

    Activity activity;
    @BindView(R.id.technical_skills_textview)
    TextView technicalSkillsTextview;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.skill_edittext)
    EditText skillEdittext;
    @BindView(R.id.level_textview)
    TextView levelTextview;
    @BindView(R.id.level_edittext)
    EditText levelEdittext;
    @BindView(R.id.apply_btn)
    Button applyBtn;

    boolean isUpdated = false;

    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;

    private String leveltxt = null;
    private String skilltxt = null;
    private String technicalId = null;
    TechnicalSkillsItem technicalSkillsItem;
    int position;

    public TechnicalSkillsDialog(Activity activity) {
        super(activity);

        this.activity = activity;
    }

    public TechnicalSkillsDialog(Activity activity, TechnicalSkillsItem technicalSkillsItem, boolean b, int position) {
        super(activity);
        this.activity = activity;
        this.technicalSkillsItem = technicalSkillsItem;
        this.isUpdated = b;
        this.position = position;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.technical_skills_dialogue);
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
        skillEdittext.setText(technicalSkillsItem.getSkuName());
        levelEdittext.setText(technicalSkillsItem.getSkuLevel());

    }

    private void callTypeFace() {
        technicalSkillsTextview.setTypeface(FontTypeFace.fontBold(activity));
        titleTextview.setTypeface(FontTypeFace.fontBold(activity));
        levelTextview.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(titleTextview, "Skill");
        AppUtils.textAddAstreik(levelTextview, "Level");
    }


    private void addTechnicalSkill() {
        if (!skillEdittext.getText().toString().isEmpty()) {
            skilltxt = skillEdittext.getText().toString();
        }

        if (!levelEdittext.getText().toString().isEmpty()) {
            leveltxt = levelEdittext.getText().toString();
        }

        if (skillEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter skill",activity);
        }else   if (levelEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter level",activity);
        }else {
            onPassDataListener.onPassData(skilltxt, leveltxt, true);
            dismiss();
        }
    }

    private void upddateTechnicalSkill() {
        if (!skillEdittext.getText().toString().isEmpty()) {
            skilltxt = skillEdittext.getText().toString();
        }

        if (!levelEdittext.getText().toString().isEmpty()) {
            leveltxt = levelEdittext.getText().toString();
        }
        technicalId = technicalSkillsItem.getSkuSequenceId();
        if (skillEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter skill",activity);
        }else   if (levelEdittext.getText().toString().isEmpty()) {
            MyToast.errorMessage("Please enter level",activity);
        }else {
            onUpdatePassDataListener.onUpdatePassData(technicalId, skilltxt, leveltxt,position, true);
            dismiss();
        }
     /*
      */

    }

    @OnClick({R.id.technical_skills_textview, R.id.apply_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.technical_skills_textview:
                dismiss();
                break;
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateTechnicalSkill();
                } else {
                    addTechnicalSkill();
                }
                break;
        }
    }

    public interface OnPassDataListener {
        void onPassData(String skilltxt, String leveltxt, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String technicalId, String skilltxt, String leveltxt, int position, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }
}