package com.example.youthhub.loginPage;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.youthhub.R;
import com.example.youthhub.resModel.login.ForgotPwdRes;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.libizo.CustomEditText;

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
 * Use the {@link ForgotPassChangeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgotPassChangeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.password)
    CustomEditText password;
    @BindView(R.id.repeat_password)
    CustomEditText repeatPassword;
    @BindView(R.id.next_btn)
    Button nextBtn;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    Activity activity;
    LoginFragmentTransfer fragmentTransfer;

    String email="", passcode="";


    public ForgotPassChangeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgotPassChangeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgotPassChangeFragment newInstance(String param1, String param2) {
        ForgotPassChangeFragment fragment = new ForgotPassChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_pass_change, container, false);
        unbinder = ButterKnife.bind(this, view);
        fragmentTransfer = (LoginFragmentTransfer) activity;
        Bundle bundle = getArguments();
        if (bundle != null) {
            email = bundle.getString(Constants.Email);
            passcode = bundle.getString(Constants.PassCode);
        }
        callTypeFace();
        return view;
    }

    private void callTypeFace() {
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
        if(password.getText().toString().trim().isEmpty()){
            MyToast.errorMessage("Password Field "+ getResources().getString(R.string.empty),activity);
        }else {
            callApi();
        }
    }

    private void callApi() {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            String passWord = password.getText().toString();
            String rePassWord = repeatPassword.getText().toString();
            Call<ForgotPwdRes> responseCall = ApiClient.getApiInterface().getChangeForGotPasswordVerify(Constants.getApiKey(activity),email,passcode,passWord,rePassWord);
            responseCall.enqueue(new Callback<ForgotPwdRes>() {
                @Override
                public void onResponse(Call<ForgotPwdRes> call, Response<ForgotPwdRes> response) {
                    if(response.isSuccessful()){
                        if(response.body().getStatus()==1){
                            MyToast.normalMessage(response.body().getMessage(),activity);
                            fragmentTransfer.fragmentTransferListener(new FragmentLogin(),null);
                        }else {
                            MyToast.errorMessage(response.body().getMessage(),activity);
                        }
                    }else {
                        Log.d(Constants.failureResponse+" ForgotPwdChange",response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(Call<ForgotPwdRes> call, Throwable t) {
                    Log.d(Constants.failureResponse+" ForgotPwdChange",t.toString());
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
