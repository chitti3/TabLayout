package com.example.youthhub.loginPage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DashBoardActivity;
import com.example.youthhub.resModel.login.LoginResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.signUpPage.ActivitySignUp;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.example.youthhub.utils.Prefs;
import com.example.youthhub.utils.SessionManager;
import com.libizo.CustomEditText;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.utils.Constants.App_TYPE;
import static com.example.youthhub.utils.Constants.DEVICE_KEY;
import static com.example.youthhub.utils.Constants.DEVICE_TYPE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogin extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.username)
    CustomEditText username;
    @BindView(R.id.password)
    CustomEditText password;
    @BindView(R.id.forgot_pwd)
    TextView forgotPwd;
    @BindView(R.id.join_now_txt)
    TextView joinNowTxt;
    @BindView(R.id.login_btn)
    Button loginBtn;

    SessionManager sessionManager;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    LoginFragmentTransfer fragmentTransfer;

    public FragmentLogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLogin.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLogin newInstance(String param1, String param2) {
        FragmentLogin fragment = new FragmentLogin();
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        fragmentTransfer = (LoginFragmentTransfer) activity;
        sessionManager = new SessionManager(activity);
        callTypeFace();

        return view;
    }

    private void callTypeFace() {
        username.setTypeface(FontTypeFace.fontMedium(activity));
        password.setTypeface(FontTypeFace.fontMedium(activity));
        loginBtn.setTypeface(FontTypeFace.fontBold(activity));
        forgotPwd.setTypeface(FontTypeFace.fontBold(activity));
        joinNowTxt.setTypeface(FontTypeFace.fontBold(activity));
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

    @OnClick({R.id.forgot_pwd, R.id.join_now_txt, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgot_pwd:
                fragmentTransfer.fragmentTransferListener(new FragmentForgotPassword(), null);
                break;
            case R.id.join_now_txt:
                Intent signUpIntent = new Intent(activity, ActivitySignUp.class);
                startActivity(signUpIntent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.login_btn:
                validation();
                break;
        }
    }

    private void validation() {
        if (Objects.requireNonNull(username.getText()).toString().trim().isEmpty()) {
            MyToast.errorMessage("Username " + getResources().getString(R.string.empty), activity);
        } else if (Objects.requireNonNull(password.getText()).toString().trim().isEmpty()) {
            MyToast.errorMessage("Password " + getResources().getString(R.string.empty), activity);
        } else {
            callApi();
        }
    }

    private void callApi() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity,true);
            final String userName = Objects.requireNonNull(username.getText()).toString();
            final String passWord = Objects.requireNonNull(password.getText()).toString();
            Call<LoginResponse> loginResponseCall = ApiClient.getApiInterface().getLogin(Constants.getApiKey(activity),DEVICE_KEY,DEVICE_TYPE,userName, passWord,App_TYPE);
            loginResponseCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    //Loader.showLoad(activity,false);
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                //sessionManager.createLoginSession(userName,passWord);
                                MyToast.normalMessage("Login Successfully", activity);
                                Bundle bundle = new Bundle();
                                bundle.putParcelable(Constants.LoginData, response.body());
                                Intent intent = new Intent(activity, DashBoardActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);

                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " Login", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    //ProgressLoad.show(activity,false);
                    //Loader.showLoad(activity,false);
                    Log.d(Constants.failureResponse + " Login", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
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
