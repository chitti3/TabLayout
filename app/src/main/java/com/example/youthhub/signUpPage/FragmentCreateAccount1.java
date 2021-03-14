package com.example.youthhub.signUpPage;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.otpPage.FragmentOTP;
import com.example.youthhub.resModel.register.RegisterResponse;
import com.example.youthhub.resModel.register.SignUpMasterData;
import com.example.youthhub.resModel.register.SignUpMasterResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.CustomEditText;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.Calendar;
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
 * Use the {@link FragmentCreateAccount1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCreateAccount1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.user_role_spinner)
    AppCompatSpinner userRoleSpinner;
    @BindView(R.id.email)
    CustomEditText email;
    @BindView(R.id.dob)
    CustomEditText dob;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.terms_condition_txt)
    TextView termsConditionTxt;
    @BindView(R.id.slash)
    TextView slash;
    @BindView(R.id.privacy_txt)
    TextView privacyTxt;
    @BindView(R.id.constrain)
    ConstraintLayout constrain;
    @BindView(R.id.steps_txt)
    TextView stepsTxt;
    @BindView(R.id.next_btn)
    Button nextBtn;
    Unbinder unbinder;

    // variable to track event time
    private long mLastClickTime = 0;
    private long mLastClickTimeprivacy = 0;

    private OnFragmentInteractionListener mListener;
    Activity activity;
    SignUpFragmentTransfer signUpFragmentTransfer;
    SignUpMasterResponse signUpMasterResponse = null;
    String role = null;
    public FragmentCreateAccount1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCreateAccount1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCreateAccount1 newInstance(String param1, String param2) {
        FragmentCreateAccount1 fragment = new FragmentCreateAccount1();
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
        View view = inflater.inflate(R.layout.fragment_create_account1, container, false);
        unbinder = ButterKnife.bind(this, view);
        signUpFragmentTransfer = (SignUpFragmentTransfer) activity;
        setTypeFace();
        callRegisterMasterApi();
        String title = "Create your" + "\n" + "account";
        text.setText(title);




        dob.setDrawableClickListener(target -> {
            switch (target) {
                case RIGHT:
                    calendarClick();
                    break;
            }

        });


        dob.setFocusable(false);
        dob.setClickable(true);
        role_adapter();

        return view;
    }


    private void role_adapter() {
        String[] data = {"Youth"};
        RoleAdapter adapter = new RoleAdapter(activity,data);
        userRoleSpinner.setAdapter(adapter);
        userRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    role = (String) view.getTag();
                }else {
                    role = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setTypeFace() {
        text.setTypeface(FontTypeFace.fontBold(activity));
        nextBtn.setTypeface(FontTypeFace.fontBold(activity));
    }

    private void calendarClick() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        c.add(Calendar.YEAR, -13);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, (view, year, monthOfYear, dayOfMonth) ->
        {
            String age = getAge(year,monthOfYear,dayOfMonth);
            int AGE = Integer.valueOf(age);
            if(AGE>=11 && AGE<=26){
                dob.setText(String.valueOf(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year));
                if(dob.length() > 0){
                    dob.setFocusable(false);
                }
            }else {
                //MyToast.errorMessage(age,activity);
                MyToast.errorMessage("The dob field must contain a valid Youth Date of Birth (Age b/w 12 to 25)",activity);
            }

        }, mYear , mMonth, mDay);

        datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());


        datePickerDialog.show();

    }

    private String getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        int ageInt = age;

        return Integer.toString(ageInt);
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

    @OnClick({R.id.checkbox, R.id.terms_condition_txt, R.id.privacy_txt, R.id.next_btn, R.id.dob})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkbox:
                break;
            case R.id.terms_condition_txt:
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                if(signUpMasterResponse!=null) {
                    String termsUrl = signUpMasterResponse.getSignUpMasterData().getUserType().get(0).getTeamsUrl();
                    if (termsUrl != null && !termsUrl.isEmpty()) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);

                        intent.setData(Uri.parse("http://docs.google.com/gview?embedded=true&url=" + termsUrl));
                        try {
                            view.getContext().startActivity(intent);
                        } catch (ActivityNotFoundException e) {
                            Log.d(Constants.PdfLoadFailure + " termsPdf", e.toString());
                        }
                    }
                    //termsConditionTxt.setEnabled(false);
                }
                break;
            case R.id.privacy_txt:
                if(signUpMasterResponse!=null) {
                    // Preventing multiple clicks, using threshold of 1 second
                    if (SystemClock.elapsedRealtime() - mLastClickTimeprivacy < 1000) {
                        return;
                    }
                    mLastClickTimeprivacy = SystemClock.elapsedRealtime();
                    String privacyUrl = signUpMasterResponse.getSignUpMasterData().getPrivacyPolicyUrl();

                    Intent privacyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://docs.google.com/gview?embedded=true&url=" + privacyUrl));
                    startActivity(privacyIntent);

                    if (privacyUrl != null && !privacyUrl.isEmpty()) {
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);

                        intent1.setData(Uri.parse("http://docs.google.com/gview?embedded=true&url=" + privacyUrl));
                        try {
                            view.getContext().startActivity(intent1);
                        } catch (ActivityNotFoundException e) {
                            Log.d(Constants.PdfLoadFailure + " privacyPdf", e.toString());
                        }
                    }
                }
                break;
            case R.id.next_btn:
                validation();
                //signUpFragmentTransfer.fragmentTransferListener(new FragmentOTP(),0);
                break;
            case R.id.dob:
                calendarClick();
                break;
        }
    }

    private void callRegisterMasterApi() {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            Call<SignUpMasterResponse> responseCall = ApiClient.getApiInterface().getSignUpMasterData(Constants.getApiKey(activity));
            responseCall.enqueue(new Callback<SignUpMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<SignUpMasterResponse> call, @NonNull Response<SignUpMasterResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                signUpMasterResponse = response.body();
                            } else {
                                MyToast.normalMessage(response.body().getError(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " RegMasterReq", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<SignUpMasterResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " RegMasterReq", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                    Loader.showLoad(activity,false);
                }
            });
        }
    }

    private void validation() {
        if (role !=null) {
            MyToast.errorMessage("Please select your role", activity);
        } else if (Objects.requireNonNull(email.getText()).toString().trim().isEmpty()) {
            MyToast.errorMessage("Email " + getResources().getString(R.string.empty), activity);
        } else if (Objects.requireNonNull(dob.getText()).toString().trim().isEmpty()) {
            MyToast.errorMessage("DOB " + getResources().getString(R.string.empty), activity);
        } else if (!checkbox.isChecked()) {
            MyToast.errorMessage("Please Accept YouthHub Terms & conditions and Privacy policy", activity);
            /*ArcProgressLoader arcProgressLoader = new ArcProgressLoader(activity,
                    120, 20,
                    10.0f, 180.0f,
                    getResources().getIntArray(R.array.loader_color));
            container.addView(arcProgressLoader);*/
            //ProgressLoad.show(activity,true);
        } else {
            if(signUpMasterResponse!=null) {
                callApi(signUpMasterResponse.getSignUpMasterData());
            }
        }
    }

    private void callApi(SignUpMasterData signUpMasterData) {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            final String Email = Objects.requireNonNull(email.getText()).toString();
            String userType = String.valueOf(signUpMasterData.getUserType().get(0).getId());
            String DOB = Objects.requireNonNull(dob.getText()).toString();
            String acceptTerms = "1";

            Call<RegisterResponse> responseCall = ApiClient.getApiInterface().getUserRegisterRequest(Constants.getApiKey(activity),Email, userType, DOB, acceptTerms);
            responseCall.enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.Email, Email);
                                bundle.putString(Constants.UserType,userType);
                                bundle.putString(Constants.DOB,DOB);
                                bundle.putString(Constants.AcceptTerms,acceptTerms);
                                bundle.putString(Constants.Message, response.body().getMessage());
                                bundle.putString(Constants.Fragment, "Register");
                                signUpFragmentTransfer.fragmentTransferListener(new FragmentOTP(), 0, bundle);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " SignUpRegReq", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " SignUpRegReq", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                    Loader.showLoad(activity,false);
                }
            });
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
