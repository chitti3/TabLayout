package com.example.youthhub.profile.profileTabSubViews;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.profileinfo.InterestsItem;
import com.example.youthhub.resModel.profile.profilemaster.LanguageResponse;
import com.example.youthhub.resModel.profile.profilemaster.ProficiencyResponse;
import com.example.youthhub.resModel.profile.profilemaster.ProfileAddMasterResponse;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LanguageDialog extends Dialog {

    Activity activity;
    boolean isUpdated = false;
    OnPassDataListener onPassDataListener;
    OnUpdatePassDataListener onUpdatePassDataListener;
    @BindView(R.id.language_skills_textview)
    TextView languageSkillsTextview;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.language_spinner)
    AppCompatSpinner languageSpinner;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.proficency_textview)
    TextView proficencyTextview;
    @BindView(R.id.proficency_spinner)
    AppCompatSpinner proficencySpinner;


    private String languageId = null;
    private String profitiencyId = null;
    InterestsItem interestsItem;
    int position;
    private String languagepassId = null;
    ProfileAddMasterResponse profileAddMasterResponse;
    private Integer languagePosition = null;
    private Integer profitiencyPosition = null;
    private LanguageResponse languagePassData = null;
    private ProficiencyResponse profieiencyPassData = null;

    /*   public LanguageDialog(Activity activity) {
           super(activity);

           this.activity = activity;
       }
   */
    public LanguageDialog(Activity activity, InterestsItem interestsItem, boolean b, int position) {
        super(activity);
        this.activity = activity;
        this.interestsItem = interestsItem;
        this.isUpdated = b;
        this.position = position;
    }

    public LanguageDialog(ProfileSubActivity profileSubActivity, ProfileAddMasterResponse profileAddMasterResponse, boolean b) {
        super(profileSubActivity);
        this.activity = profileSubActivity;
        this.profileAddMasterResponse = profileAddMasterResponse;
        this.isUpdated = b;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.language_dialog);
        ButterKnife.bind(this);
        callTypeFace();

        if (isUpdated) {
            updatedUI();
        } else {
            addUI();
        }
    }

    private void addUI() {
        language_spinner_load(isUpdated);
        language_profitiency_spinner_load(isUpdated);
    }

    private void updatedUI() {
        language_spinner_load(isUpdated);
        language_profitiency_spinner_load(isUpdated);
    }

    private void callTypeFace() {
        languageSkillsTextview.setTypeface(FontTypeFace.fontBold(activity));
        titleTextview.setTypeface(FontTypeFace.fontBold(activity));
        proficencyTextview.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(titleTextview, "Languages");
        AppUtils.textAddAstreik(proficencyTextview, "Proficiency");
    }

    private void language_spinner_load(boolean selected) {

        List<LanguageResponse> languageItems = new ArrayList<>();


        LanguageResponse languageItem = new LanguageResponse();
        languageItem.setLamLanguageId(null);
        languageItem.setLamName(activity.getResources().getString(R.string.select_lang));
        languageItems.add(languageItem);

        languageItems.addAll(profileAddMasterResponse.getData().getLanguages());
        if (languageItems.size() > 0) {
            ArrayAdapter<LanguageResponse> adapter = new ArrayAdapter<LanguageResponse>(activity, R.layout.spinner_text, languageItems) {
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
            languageSpinner.setAdapter(adapter);
            if (selected) {
                /*for (int i = 0; i < languageItems.size(); i++) {
                    if (languageItems.get(i).getLamName().equalsIgnoreCase(volunteeringItem.getVocName())) {
                        int spinnerPosition = adapter.getPosition(languageItems.get(i));
                        languageSpinner.setSelection(spinnerPosition);
                    }
                }*/
            }
            languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    languagePosition = position;
                    if (position > 0) {
                        languagePassData = (LanguageResponse) parent.getSelectedItem();
                    } else {
                        languagePassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }


    private void addLanguage() {
        if (languagePassData != null) {
            languageId = languagePassData.getLamLanguageId();
        }

        if (profieiencyPassData != null) {
            profitiencyId = String.valueOf(profieiencyPassData.getId());
        }
        if (languagePassData == null) {
            MyToast.errorMessage("Please Select language",activity);
        }else  if (profieiencyPassData == null) {
            MyToast.errorMessage("Please Select proficiency",activity);
        }else{
            onPassDataListener.onLanguagePassData(languageId,profitiencyId, true);
            dismiss();
        }


      /*  if (languagePassData != null) {
            languageId = languagePassData.getLamLanguageId();
        }

        if (profieiencyPassData != null) {
            profitiencyId = String.valueOf(profieiencyPassData.getId());
        }*/


    }



    private void language_profitiency_spinner_load(boolean selected) {

        List<ProficiencyResponse> languageItems = new ArrayList<>();


        ProficiencyResponse languageItem = new ProficiencyResponse();
        languageItem.setId(0);
        languageItem.setName(activity.getResources().getString(R.string.select_profiti));
        languageItems.add(languageItem);

        languageItems.addAll(profileAddMasterResponse.getData().getProficiency());
        if (languageItems.size() > 0) {
            ArrayAdapter<ProficiencyResponse> adapter = new ArrayAdapter<ProficiencyResponse>(activity, R.layout.spinner_text, languageItems) {
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
            proficencySpinner.setAdapter(adapter);
            if (selected) {
                /*for (int i = 0; i < languageItems.size(); i++) {
                    if (languageItems.get(i).getLamName().equalsIgnoreCase(volunteeringItem.getVocName())) {
                        int spinnerPosition = adapter.getPosition(languageItems.get(i));
                        languageSpinner.setSelection(spinnerPosition);
                    }
                }*/
            }
            proficencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    profitiencyPosition = position;
                    if (position > 0) {
                        profieiencyPassData = (ProficiencyResponse) parent.getSelectedItem();
                    } else {
                        profieiencyPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }




    private void upddateLanguage() {

        languagepassId = interestsItem.getInuInterestId();

        if (languagePassData != null) {
            languageId = languagePassData.getLamLanguageId();
        }
        onUpdatePassDataListener.onUpdatePassData(languagepassId, languageId, true);
        dismiss();

    }


    @OnClick({R.id.language_skills_textview, R.id.apply_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.language_skills_textview:
                dismiss();
                break;
            case R.id.apply_btn:
                if (isUpdated) {
                    upddateLanguage();
                } else {
                    addLanguage();
                }
                break;
        }
    }

    public interface OnPassDataListener {
        void onLanguagePassData(String languageId, String profitiencyId, boolean b);

    }

    public interface OnUpdatePassDataListener {

        void onUpdatePassData(String languagepassId, String languageId, boolean b);

    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

    void setOnUpdatePassDataListener(OnUpdatePassDataListener onUpdatePassDataListener) {
        this.onUpdatePassDataListener = onUpdatePassDataListener;
    }
}