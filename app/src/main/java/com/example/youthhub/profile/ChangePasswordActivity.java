package com.example.youthhub.profile;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.createPost.TagsJourneyDialog;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.profile.visualjourney.ProfileVisualJourneyAddMasterResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.google.gson.Gson;
import com.libizo.CustomEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {

    private static final String TAG = ChangePasswordActivity.class.getSimpleName();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_txt)
    TextView backTxt;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.oldpassword)
    com.libizo.CustomEditText oldpassword;
    @BindView(R.id.passwordstrength)
    TextView passwordstrength;
    @BindView(R.id.newpassword)
    com.libizo.CustomEditText newpassword;
    @BindView(R.id.confirmpassword)
    CustomEditText confirmpassword;
    @BindView(R.id.constrain)
    ConstraintLayout constrain;
    @BindView(R.id.next_btn)
    Button nextBtn;
    Activity activity;
    private CommonRes commonRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
        newpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                calculateStrength(editable.toString());

            }
        });
        init();
    }

    private void calculateStrength(String pass) {
        if (pass.length() < 4 || pass.length() >15 )
        {
            newpassword.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dc3545")));
            passwordstrength.setText("pass too short or too long");

        }
        else if (!pass.matches(".*\\d.*"))
        {
            newpassword.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffc107")));
            passwordstrength.setText("no digits found");

        }
        else if (!pass.matches(".*[a-z].*"))
        {
            newpassword.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffc107")));
            passwordstrength.setText("no lowercase letters found");

        }
        else if (!pass.matches(".*[!@#$%^&*+=?-].*")) {
            newpassword.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffc107")));
            passwordstrength.setText("no special chars found");

        }else if (!pass.matches(".*[A-Z].*"))
        {
            passwordstrength.setText("no Uppercase letters found");
            newpassword.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dc3545")));

        }else
        {
            passwordstrength.setText("Strong");
            newpassword.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dc3545")));

        }

    }

    private void init() {
        activity = this;
    }

    @OnClick({R.id.next_btn, R.id.back_txt, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.back_txt:
                onBackPressed();
                break;
            case R.id.next_btn:
                validate();
                break;

        }
    }

    private void validate() {
        if (oldpassword.getText().toString() != null && oldpassword.getText().toString().length() > 0) {
            if (newpassword.getText().toString() != null && newpassword.getText().toString().length() > 0) {
                if (newpassword.getText().toString().length() > 7) {
                    if (confirmpassword.getText().toString() != null && confirmpassword.getText().toString().length() > 0) {
                        if (newpassword.getText().toString().equals(confirmpassword.getText().toString())) {
                            call_change_password_api(oldpassword.getText().toString(), newpassword.getText().toString(), confirmpassword.getText().toString());
                        } else {
                            MyToast.errorMessage("Password Mismatch", activity);
                        }
                    } else {
                        MyToast.errorMessage("Please enter confirm password", activity);
                    }
                } else {
                    MyToast.errorMessage("Please enter above 8 digit password", activity);
                }
            } else {
                MyToast.errorMessage("Please enter new password", activity);
            }
        } else {
            MyToast.errorMessage("Please enter old password", activity);
        }

    }


    private void call_change_password_api(String oldpasswordedt, String newpasswordedt, String confirmpasswordedt) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonRes> call = ApiClient.getApiInterface().updatepassword(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), oldpasswordedt, newpasswordedt, confirmpasswordedt);

            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                commonRes = response.body();
                              /*  visualJourneyAdapter = new VisualJourneyAdapter(activity,profileJourneyListResponse);
                                recyclerView.setAdapter(visualJourneyAdapter);
                                visualJourneyAdapter.notifyDataSetChanged();*/
                                MyToast.normalMessage(response.body().getMessage(), activity);
                                Log.d(TAG, "onResponse:call_change_password_api " + new Gson().toJson(commonRes));
                                finish();
                            } else {
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse, " call_change_password_api" + response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    call_change_password_api(oldpasswordedt, newpasswordedt, confirmpasswordedt);
                    Log.d(Constants.failureResponse, " call_change_password_api" + t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
    }

}
