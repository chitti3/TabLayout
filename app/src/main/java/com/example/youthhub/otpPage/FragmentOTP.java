package com.example.youthhub.otpPage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.loginPage.ForgotPassChangeFragment;
import com.example.youthhub.loginPage.LoginFragmentTransfer;
import com.example.youthhub.resModel.login.LoginResponse;
import com.example.youthhub.resModel.register.RegisterResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.signUpPage.FragmentCreateAccount2;
import com.example.youthhub.signUpPage.SignUpFragmentTransfer;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentOTP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOTP extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.otp_first)
    TextView otpFirst;
    @BindView(R.id.otp_second)
    TextView otpSecond;
    @BindView(R.id.otp_third)
    TextView otpThird;
    @BindView(R.id.otp_fourth)
    TextView otpFourth;
    @BindView(R.id.next_btn)
    Button nextBtn;
    Unbinder unbinder;
    @BindView(R.id.display_msg)
    TextView displayMsg;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    SignUpFragmentTransfer signUpFragmentTransfer;
    LoginFragmentTransfer fragmentTransfer;
    String email = "", user_type = "", dob = "", accept_terms = "", message = "", fragment = "";

    public FragmentOTP() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOTP.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOTP newInstance(String param1, String param2) {
        FragmentOTP fragment = new FragmentOTP();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_otp, container, false);
        unbinder = ButterKnife.bind(this, view);
        signUpFragmentTransfer = (SignUpFragmentTransfer) activity;
        fragmentTransfer = (LoginFragmentTransfer) activity;
        text.setText(activity.getString(R.string.verify_account));
        setTypeFace();
        text_change_listener();

        Bundle bundle = getArguments();
        if (bundle != null) {
            fragment = bundle.getString(Constants.Fragment);
            email = bundle.getString(Constants.Email);
            message = bundle.getString(Constants.Message);
            displayMsg.setText(message);
            if (fragment != null && fragment.equals("Register")) {
                user_type = bundle.getString(Constants.UserType);
                dob = bundle.getString(Constants.DOB);
                accept_terms = bundle.getString(Constants.AcceptTerms);
            }
        }

        return view;
    }

    private void setTypeFace() {
        text.setTypeface(FontTypeFace.fontBold(activity));
        nextBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void text_change_listener() {

        otpFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = otpFirst.getText().toString().length();
                if (length == 1) {
                    otpFirst.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle2));
                    otpFirst.setTextColor(ContextCompat.getColor(activity, R.color.white));
                    otpSecond.requestFocus();
                } else {
                    otpFirst.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otpSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = otpSecond.getText().toString().length();
                if (length == 1) {
                    otpSecond.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle2));
                    otpSecond.setTextColor(ContextCompat.getColor(activity, R.color.white));
                    otpThird.requestFocus();
                } else {
                    otpSecond.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle));
                    otpFirst.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otpThird.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = otpThird.getText().toString().length();
                if (length == 1) {
                    otpThird.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle2));
                    otpThird.setTextColor(ContextCompat.getColor(activity, R.color.white));
                    otpFourth.requestFocus();
                } else {
                    otpThird.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle));
                    otpSecond.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otpFourth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = otpFourth.getText().toString().length();
                if (length == 1) {
                    otpFourth.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle2));
                    otpFourth.setTextColor(ContextCompat.getColor(activity, R.color.white));
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(otpFourth.getWindowToken(), 0);
                } else {
                    otpFourth.setBackground(ContextCompat.getDrawable(activity, R.drawable.textview_circle));
                    otpThird.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.next_btn, R.id.resend_otp_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.next_btn:
                //signUpFragmentTransfer.fragmentTransferListener(new FragmentCreateAccount2(), 1);
                validation();
                break;
            case R.id.resend_otp_txt:
                Log.d("Fragment OTP", "onViewClicked: "+fragment);
                if (!fragment.isEmpty()) {
                    if (fragment.equals("Register")) {
                        call_register_otp_api();
                    } else {
                        callResendForgotOtpApi();
                    }
                }
                break;
        }
    }

    private void call_register_otp_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            displayMsg.setText("");
            Call<RegisterResponse> responseCall = ApiClient.getApiInterface().getUserRegisterRequest(Constants.getApiKey(activity), email, user_type, dob, accept_terms);
            responseCall.enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                displayMsg.setText(response.body().getMessage());
                                otpFirst.setText("");
                                otpSecond.setText("");
                                otpThird.setText("");
                                otpFourth.setText("");
                                otpFirst.requestFocus();
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " SignUpRegReq", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " SignUpRegReq", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void callResendForgotOtpApi() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            displayMsg.setText("");
            Loader.showLoad(activity, true);
            Call<LoginResponse> forgotPwdResCall = ApiClient.getApiInterface().getForGotPassword(Constants.getApiKey(activity), email);
            forgotPwdResCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        if (response.body().getStatus() == 1) {
                            displayMsg.setText(response.body().getMessage());
                            otpFirst.setText("");
                            otpSecond.setText("");
                            otpThird.setText("");
                            otpFourth.setText("");
                            otpFirst.requestFocus();
                        } else {
                            MyToast.normalMessage(response.body().getMessage(), activity);
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ResendOtp", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ResendOtp", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });

        }

    }

    private void validation() {
        if (otpFirst.getText().toString().trim().isEmpty() || otpSecond.getText().toString().trim().isEmpty() || otpThird.getText().toString().trim().isEmpty() || otpFourth.getText().toString().trim().isEmpty()) {
            MyToast.errorMessage("Field " + getResources().getString(R.string.empty), activity);
        } else {
            final String passcode = otpFirst.getText().toString() + otpSecond.getText().toString() + otpThird.getText().toString() + otpFourth.getText().toString();
            if (!fragment.isEmpty()) {
                if (fragment.equals("ForgotPwd")) {
                    forgotCallApi(passcode);
                } else {
                    registerCallApi(passcode);
                }
            }
        }
    }

    private void registerCallApi(final String passcode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            if (!email.isEmpty()) {
                Call<RegisterResponse> responseCall = ApiClient.getApiInterface().getUserRegisterCodeVerify(Constants.getApiKey(activity), email, passcode);
                responseCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getStatus() == 1) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString(Constants.Email, email);
                                    bundle.putString(Constants.PassCode, passcode);
                                    bundle.putParcelable(Constants.RegisterData, response.body());
                                    signUpFragmentTransfer.fragmentTransferListener(new FragmentCreateAccount2(), 1, bundle);
                                } else {
                                    MyToast.errorMessage(response.body().getMessage(), activity);
                                }
                            }
                        } else {
                            Log.d(Constants.failureResponse + " SignUpOtp", response.toString());
                        }
                        Loader.showLoad(activity, false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                        Log.d(Constants.failureResponse + " SignUpOtp", t.toString());
                        MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                        Loader.showLoad(activity, false);
                    }
                });
            }
        }
    }

    private void forgotCallApi(final String passcode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            if (!email.isEmpty()) {
                Call<LoginResponse> otpCall = ApiClient.getApiInterface().getForGotPasswordVerify(Constants.getApiKey(activity), email, passcode);
                otpCall.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                if (response.body().getStatus() == 1) {
                                    MyToast.normalMessage(response.body().getMessage(), activity);
                                    Bundle bundle = new Bundle();
                                    bundle.putString(Constants.Email, email);
                                    bundle.putString(Constants.PassCode, passcode);
                                    fragmentTransfer.fragmentTransferListener(new ForgotPassChangeFragment(), bundle);
                                } else {
                                    MyToast.normalMessage(response.body().getMessage(), activity);
                                }
                            }
                        } else {
                            Log.d(Constants.failureResponse + " ForgotPwdOtp", response.toString());
                        }
                        Loader.showLoad(activity, false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                        Log.d(Constants.failureResponse + " ForgotPwdOtp", t.toString());
                        MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                        Loader.showLoad(activity, false);
                    }
                });
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
