package com.example.youthhub.signUpPage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.youthhub.R;
import com.example.youthhub.loginPage.ActivityLogin;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.register.CityList;
import com.example.youthhub.resModel.register.CityResponse;
import com.example.youthhub.resModel.register.EthnicityList;
import com.example.youthhub.resModel.register.GenderList;
import com.example.youthhub.resModel.register.IntendedDestinationList;
import com.example.youthhub.resModel.register.IwiList;
import com.example.youthhub.resModel.register.LicenceTypeList;
import com.example.youthhub.resModel.register.RegionList;
import com.example.youthhub.resModel.register.RegisterData;
import com.example.youthhub.resModel.register.RegisterResponse;
import com.example.youthhub.resModel.register.SignUpResponse;
import com.example.youthhub.resModel.register.WorkExperienceList;
import com.example.youthhub.resModel.register.WorkSituationList;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.libizo.CustomEditText;

import java.util.ArrayList;
import java.util.List;
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
 * Use the {@link FragmentCreateAccount3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCreateAccount3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.work_status_spinner)
    AppCompatSpinner workStatusSpinner;
    @BindView(R.id.work_exp_spinner)
    AppCompatSpinner workExpSpinner;
    @BindView(R.id.hours_work)
    CustomEditText hoursWork;
    @BindView(R.id.region_spinner)
    AppCompatSpinner regionSpinner;
    @BindView(R.id.district_spinner)
    AppCompatSpinner districtSpinner;
    @BindView(R.id.destination_spinner)
    AppCompatSpinner destinationSpinner;
    @BindView(R.id.license_type_spinner)
    AppCompatSpinner licenseTypeSpinner;
    @BindView(R.id.next_btn)
    Button nextBtn;
    Unbinder unbinder;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    SignUpFragmentTransfer signUpFragmentTransfer;
    RegisterResponse registerResponse;
    RegisterData registerData;

    String email = "", passcode = "", firstName = "", lastName = "", pwd = "", confirmPwd = "";

    String jobWishlist;
    String regionList;
    RegionList preferred_region = null;
    String genderList;
    String ethnicityList;
    String iwiList;
    String cityList;
    CityList preferred_city = null;

    CityResponse cityResponse;

    LicenceTypeList licenceTypeList = null;
    IntendedDestinationList intendedDestinationList = null;
    WorkSituationList workSituationList = null;
    WorkExperienceList workExperienceList = null;

    public FragmentCreateAccount3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCreateAccount3.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCreateAccount3 newInstance(String param1, String param2) {
        FragmentCreateAccount3 fragment = new FragmentCreateAccount3();
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
        View view = inflater.inflate(R.layout.fragment_create_account3, container, false);
        unbinder = ButterKnife.bind(this, view);
        signUpFragmentTransfer = (SignUpFragmentTransfer) activity;
        setTypeFace();
        //load_spinner();

        Bundle bundle = getArguments();
        if (bundle != null) {
            email = bundle.getString(Constants.Email);
            passcode = bundle.getString(Constants.PassCode);
            registerResponse = bundle.getParcelable(Constants.RegisterData);
            if (registerResponse != null) {
                registerData = registerResponse.getRegisterData();
            }
            firstName = bundle.getString("firstname");
            lastName = bundle.getString("lastname");
            pwd = bundle.getString("pwd");
            confirmPwd = bundle.getString("confirmPwd");
            genderList = bundle.getString(Constants.GenderList);
            regionList = bundle.getString(Constants.RegionList);
            ethnicityList = bundle.getString(Constants.EthnicityList);
            jobWishlist = bundle.getString(Constants.JobWishList);
            iwiList = bundle.getString(Constants.IwiList);
            cityList = bundle.getString(Constants.DistrictList);
        }
        work_status_spinner_load(registerData);
        work_exp__spinner_load(registerData);
        region_spinner_load(registerData);
        destination__spinner_load(registerData);
        licence_type_spinner_load(registerData);
        district_spinner_load(null);

        return view;
    }

    private void district_spinner_load(CityResponse cityResponse) {
        List<CityList> lists;
        if (cityResponse != null) {
            lists = cityResponse.getCityData().getCityList();
        } else {
            lists = new ArrayList<>();
        }
        DistrictSpinnerAdapter adapter = new DistrictSpinnerAdapter(activity, lists);
        districtSpinner.setAdapter(adapter);
        districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!regionSpinner.getSelectedItem().toString().equals("Select Your Region")) {
                    if (position != 0) {
                        preferred_city = (CityList) view.getTag();
                    }else {
                        preferred_city = null;
                    }
                } else {
                    MyToast.errorMessage("Please select region", activity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void licence_type_spinner_load(RegisterData registerData) {
        List<LicenceTypeList> lists = registerData.getLicenceTypeList();
        LicenceTypeSpinnerAdapter adapter = new LicenceTypeSpinnerAdapter(activity, lists);
        licenseTypeSpinner.setAdapter(adapter);

        licenseTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    licenceTypeList = (LicenceTypeList) view.getTag();
                }else {
                    licenceTypeList = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void destination__spinner_load(RegisterData registerData) {
        List<IntendedDestinationList> lists = registerData.getIntendedDestinationList();
        DestinationSpinnerAdapter adapter = new DestinationSpinnerAdapter(activity, lists);
        destinationSpinner.setAdapter(adapter);

        destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    intendedDestinationList = (IntendedDestinationList) view.getTag();
                }else {
                    intendedDestinationList = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void region_spinner_load(RegisterData registerData) {
        List<RegionList> lists = registerData.getRegionList();
        RegionSpinnerAdapter adapter = new RegionSpinnerAdapter(activity, lists);
        regionSpinner.setAdapter(adapter);

        regionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    preferred_region = (RegionList) view.getTag();
                    call_city_api(preferred_region.getReRegionId());
                }else {
                    preferred_region = null;
                    district_spinner_load(null);
                    preferred_city = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void call_city_api(String regionID) {
        if(NetWorkUtil.isNetworkConnected(activity)){
            Loader.showLoad(activity,true);
            Call<CityResponse> responseCall = ApiClient.getApiInterface().getGetCity(Constants.getApiKey(activity),regionID);
            responseCall.enqueue(new Callback<CityResponse>() {
                @Override
                public void onResponse(@NonNull Call<CityResponse> call, @NonNull Response<CityResponse> response) {
                    if (response.isSuccessful()) {
                        cityResponse = response.body();
                        district_spinner_load(cityResponse);
                    } else {
                        Log.d(Constants.failureResponse + " CityResponse", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<CityResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " CityResponse", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                    Loader.showLoad(activity,false);
                }
            });
        }
    }

    private void work_exp__spinner_load(RegisterData registerData) {
        List<WorkExperienceList> lists = registerData.getWorkExperienceList();
        WorkExpSpinnerAdapter adapter = new WorkExpSpinnerAdapter(activity, lists);
        workExpSpinner.setAdapter(adapter);

        workExpSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    workExperienceList = (WorkExperienceList) view.getTag();
                }else {
                    workExperienceList = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void work_status_spinner_load(RegisterData registerData) {

        List<WorkSituationList> lists = registerData.getWorkSituationList();
        WorkStatusSpinnerAdapter adapter = new WorkStatusSpinnerAdapter(activity, lists);
        workStatusSpinner.setAdapter(adapter);

        workStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    workSituationList = (WorkSituationList) view.getTag();
                }else {
                    workSituationList = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setTypeFace() {
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
        /*Intent intent = new Intent(activity, ActivityLogin.class);
        startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_slide_up,R.anim.stay);*/
    }

    private void validation() {
        if (workSituationList == null) {
            MyToast.errorMessage("Please Select Work Status", activity);
        } else if (workExperienceList == null) {
            MyToast.errorMessage("Please Select Work Experience", activity);
        } else if (preferred_region == null) {
            MyToast.errorMessage("Please Select Preferred Region", activity);
        } else if (preferred_city == null) {
            MyToast.errorMessage("Please Select Preferred City", activity);
        } else if (intendedDestinationList == null) {
            MyToast.errorMessage("Please Select Intended Destination", activity);
        } else if (licenceTypeList == null) {
            MyToast.errorMessage("Please Select Licence Type", activity);
        } else {
            callApi();
        }
    }

    private void callApi() {
        if(NetWorkUtil.isNetworkConnected(activity)){

            String work_status = "";
            String work_exp = "";
            String intend_dest = "";
            String pref_region = "";
            String pref_city = "";
            String license_type = "";
            String work_hours = "";

            if(workSituationList!=null){
                work_status = workSituationList.getJtTypeId();
            }
            if(workExperienceList!=null){
                work_exp = String.valueOf(workExperienceList.getId());
            }
            if(intendedDestinationList!=null){
                intend_dest = intendedDestinationList.getSmStatusId();
            }
            if(preferred_region!=null){
                pref_region = preferred_region.getReRegionId();
            }
            if(preferred_city!=null){
                pref_city = preferred_city.getCiCityId();
            }
            if(licenceTypeList!=null){
                license_type = licenceTypeList.getName();
            }
            if(!Objects.requireNonNull(hoursWork.getText()).toString().isEmpty()){
                work_hours = hoursWork.getText().toString();
            }

            Loader.showLoad(activity,true);
            Call<SignUpResponse> responseCall = ApiClient.getApiInterface().getSignUp(
                    Constants.getApiKey(activity),
                    DEVICE_KEY,
                    DEVICE_TYPE,
                    email,
                    passcode,
                    "6",
                    firstName,
                    lastName,
                    genderList,
                    regionList,
                    cityList,
                    pwd,
                    confirmPwd,
                    work_status,
                    work_exp,
                    intend_dest,
                    pref_region,
                    pref_city,
                    license_type,
                    jobWishlist,
                    "",
                    iwiList,
                    ethnicityList,
                    work_hours,
                    App_TYPE);

            responseCall.enqueue(new Callback<SignUpResponse>() {
                @Override
                public void onResponse(@NonNull Call<SignUpResponse> call, @NonNull Response<SignUpResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage("Registered Successfully", activity);
                                Intent intent = new Intent(activity, ActivityLogin.class);
                                startActivity(intent);
                                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " SignUp", response.toString());
                    }
                    Loader.showLoad(activity,false);
                }

                @Override
                public void onFailure(@NonNull Call<SignUpResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " SignUp", t.toString());
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
