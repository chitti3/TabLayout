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
import android.widget.EditText;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.profile.ProfileInfoDialog;
import com.example.youthhub.resModel.profile.WorkStatusMasterItem;
import com.example.youthhub.resModel.profile.profiletestmonial.ProvidersTitleItem;
import com.example.youthhub.resModel.profile.profiletestmonial.TestimonialResponse;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestimonialReqDialog extends Dialog {

    Activity activity;
    @BindView(R.id.testimonial_txt)
    TextView testimonialTxt;
    @BindView(R.id.provider_title_txt)
    TextView providerTitleTxt;
    @BindView(R.id.provider_spinner)
    AppCompatSpinner providerSpinner;
    @BindView(R.id.testimonial_name_txt)
    TextView testimonialNameTxt;
    @BindView(R.id.testimonial_name)
    EditText testimonialName;
    @BindView(R.id.email_txt)
    TextView emailTxt;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.organisation_txt)
    TextView organisationTxt;
    @BindView(R.id.organisation)
    EditText organisation;
    @BindView(R.id.cmt_txt)
    TextView cmtTxt;
    @BindView(R.id.comment)
    EditText comment;
    @BindView(R.id.apply_btn)
    Button applyBtn;
    @BindView(R.id.cancel_btn)
    Button cancelBtn;
    TestimonialResponse testimonialResponse;
    private Integer providerPosition = null;
    private ProvidersTitleItem providerPassData = null;
    OnPassDataListener onPassDataListener;
    private String testmonialprovider = null;
    private String providerID = null;
    private String comment_edt = null;
    private String organisation_edt = null;
    private String email_edt = null;

    public TestimonialReqDialog(Activity activity, TestimonialResponse testimonialResponse) {
        super(activity);
        this.activity = activity;
        this.testimonialResponse = testimonialResponse;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.testimonial_req_dialog);
        ButterKnife.bind(this);
        callTypeFace();
        providerTitleSpinnerLoad();
    }

    private void callTypeFace() {
        testimonialTxt.setTypeface(FontTypeFace.fontBold(activity));
        providerTitleTxt.setTypeface(FontTypeFace.fontBold(activity));
        testimonialNameTxt.setTypeface(FontTypeFace.fontBold(activity));
        emailTxt.setTypeface(FontTypeFace.fontBold(activity));
        organisationTxt.setTypeface(FontTypeFace.fontBold(activity));
        cmtTxt.setTypeface(FontTypeFace.fontBold(activity));
        applyBtn.setTypeface(FontTypeFace.fontBold(activity));
        cancelBtn.setTypeface(FontTypeFace.fontBold(activity));

        AppUtils.textAddAstreik(testimonialNameTxt, "Name of Testimonial Provider");
        AppUtils.textAddAstreik(emailTxt, "Email");
        AppUtils.textAddAstreik(organisationTxt, "Organisation Name");
        AppUtils.textAddAstreik(cmtTxt, "Comments");
        AppUtils.textAddAstreik(providerTitleTxt, "Providers Title");
    }

    @OnClick({R.id.apply_btn, R.id.cancel_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.apply_btn:
                pass_Data();
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
        }
    }

    private void providerTitleSpinnerLoad() {

        List<ProvidersTitleItem> providersTitleItems = new ArrayList<>();


        ProvidersTitleItem providersTitleItem = new ProvidersTitleItem();
        providersTitleItem.setId(null);
        providersTitleItem.setName(activity.getResources().getString(R.string.select_providertitle));
        providersTitleItems.add(providersTitleItem);

        providersTitleItems.addAll(testimonialResponse.getData().getProvidersTitle());
        if (providersTitleItems.size() > 0) {
            ArrayAdapter<ProvidersTitleItem> adapter = new ArrayAdapter<ProvidersTitleItem>(activity, R.layout.spinner_text, providersTitleItems) {
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
            providerSpinner.setAdapter(adapter);
            // Log.d("ProfileFilter", "regionListItems_spinner_load: " + new Gson().toJson(regionListItems));
       /*     for (int i = 0; i < providersTitleItems.size(); i++) {
                if (providersTitleItems.get(i).getName().equalsIgnoreCase(profileInfoMaster.getData().getYouthInfo().getYthWorkStatusName())) {
                    int spinnerPosition = adapter.getPosition(providersTitleItems.get(i));
                    providerSpinner.setSelection(spinnerPosition);
                }
            }*/
            providerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    providerPosition = position;
                    if (position > 0) {
                        providerPassData = (ProvidersTitleItem) parent.getSelectedItem();
                    } else {
                        providerPassData = null;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }


    private void pass_Data() {
        if (providerPassData != null) {
            providerID = providerPassData.getId();
            if (!testimonialName.getText().toString().isEmpty()) {
                testmonialprovider = testimonialName.getText().toString();
                if (!email.getText().toString().isEmpty()) {
                    email_edt = email.getText().toString();
                    if (!organisation.getText().toString().isEmpty()) {
                        organisation_edt = organisation.getText().toString();
                        if (comment != null) {
                            comment_edt = comment.getText().toString();
                            onPassDataListener.onPassData(testmonialprovider, email_edt, organisation_edt, comment_edt, providerID, true);
                            dismiss();
                        }else {
                            MyToast.errorMessage("Please enter comment",activity);
                        }
                    }else {
                        MyToast.errorMessage("Please enter organisation",activity);
                    }
                }else {
                    MyToast.errorMessage("Please enter email",activity);
                }
            }else {
                MyToast.errorMessage("Please enter name of testimonal provider",activity);
            }
        }else {
            MyToast.errorMessage("Please select providers titles",activity);
        }












    }

    public interface OnPassDataListener {
        void onPassData(String testmonialprovider,
                        String email_edt,
                        String organisation_edt,
                        String comment_edt,
                        String providerID,
                        boolean filter);
    }

    void setOnPassDataListener(OnPassDataListener onPassDataListener) {
        this.onPassDataListener = onPassDataListener;
    }

}
