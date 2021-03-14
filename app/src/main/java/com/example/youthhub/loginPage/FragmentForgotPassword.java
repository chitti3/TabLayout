package com.example.youthhub.loginPage;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.login.LoginResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.otpPage.FragmentOTP;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.libizo.CustomEditText;

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
 * Use the {@link FragmentForgotPassword#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentForgotPassword extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.recover_email)
    CustomEditText recoverEmail;
    @BindView(R.id.next_btn)
    Button nextBtn;
    Unbinder unbinder;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    LoginFragmentTransfer fragmentTransfer;

    public FragmentForgotPassword() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentForgotPassword.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentForgotPassword newInstance(String param1, String param2) {
        FragmentForgotPassword fragment = new FragmentForgotPassword();
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
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        unbinder = ButterKnife.bind(this, view);
        fragmentTransfer = (LoginFragmentTransfer) activity;
        text.setText("Recover"+"\n"+"your account");

        callTypeFace();

        return view;
    }

    private void callTypeFace() {
        text.setTypeface(FontTypeFace.fontBold(activity));
        nextBtn.setTypeface(FontTypeFace.fontBold(activity));
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

    @OnClick(R.id.next_btn)
    public void onViewClicked() {
        validation();
    }

    private void validation() {
        if(Objects.requireNonNull(recoverEmail.getText()).toString().trim().isEmpty()){
            MyToast.errorMessage("Email "+ getResources().getString(R.string.empty),activity);
        }else {
            fragmentTransfer.fragmentTransferListener(new FragmentOTP(), null);
            callForgotPwdApi();
        }
    }

    private void callForgotPwdApi() {
        if(NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity,true);
            final String email = Objects.requireNonNull(recoverEmail.getText()).toString();
            Call<LoginResponse> forgotPwdResCall = ApiClient.getApiInterface().getForGotPassword(Constants.getApiKey(activity),email);
            forgotPwdResCall.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        if (response.body().getStatus() == 1) {
                            MyToast.normalMessage(response.body().getMessage(), activity);
                            Bundle bundle = new Bundle();
                            bundle.putString("From","ForgotPwd");
                            bundle.putString(Constants.Email, email);
                            bundle.putString(Constants.Message, response.body().getMessage());
                            bundle.putString(Constants.Fragment, "ForgotPwd");
                            fragmentTransfer.fragmentTransferListener(new FragmentOTP(), bundle);

                        } else {
                            MyToast.normalMessage(response.body().getMessage(), activity);
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ForgotPwd", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ForgotPwd", t.toString());
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
