package com.example.youthhub.signUpPage;

import android.app.Activity;
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
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.register.CityList;
import com.example.youthhub.resModel.register.CityResponse;
import com.example.youthhub.resModel.register.EthnicityList;
import com.example.youthhub.resModel.register.GenderList;
import com.example.youthhub.resModel.register.IwiList;
import com.example.youthhub.resModel.register.JobWishlist;
import com.example.youthhub.resModel.register.RegionList;
import com.example.youthhub.resModel.register.RegisterData;
import com.example.youthhub.resModel.register.RegisterResponse;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentCreateAccount2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCreateAccount2 extends Fragment implements JobwishlistDialog.PassJobWishListItems{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.firstName)
    CustomEditText firstName;
    @BindView(R.id.lastName)
    CustomEditText lastName;
    @BindView(R.id.gender_spinner)
    AppCompatSpinner genderSpinner;
    @BindView(R.id.region_spinner)
    AppCompatSpinner regionSpinner;
    @BindView(R.id.district_spinner)
    AppCompatSpinner districtSpinner;
    @BindView(R.id.ethnicity_spinner)
    AppCompatSpinner ethnicitySpinner;
    @BindView(R.id.job_wishlist_spinner)
    TextView jobWishlistSpinner;
    @BindView(R.id.iwi_spinner)
    AppCompatSpinner iwiSpinner;
    @BindView(R.id.pwd)
    CustomEditText pwd;
    @BindView(R.id.confirm_pwd)
    CustomEditText confirmPwd;
    @BindView(R.id.next_btn)
    Button nextBtn;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    SignUpFragmentTransfer signUpFragmentTransfer;

    RegisterResponse registerResponse;
    RegisterData registerData;
    String email = "", passcode = "";

    RegionList regionList = null;
    GenderList genderList = null;
    EthnicityList ethnicityList = null;
    IwiList iwiList = null;
    CityList cityList = null;
    CityResponse cityResponse;
    String jobWishSelectedItems = "";
    String jobWishSelectedItemsName = "";

    JobwishlistDialog jobwishlistDialog;

    public FragmentCreateAccount2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCreateAccount2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCreateAccount2 newInstance(String param1, String param2) {
        FragmentCreateAccount2 fragment = new FragmentCreateAccount2();
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
        View view = inflater.inflate(R.layout.fragment_create_account2, container, false);
        unbinder = ButterKnife.bind(this, view);
        signUpFragmentTransfer = (SignUpFragmentTransfer) activity;
        jobwishlistDialog = new JobwishlistDialog(activity);
        setTypeFace();
        Bundle bundle = getArguments();
        if (bundle != null) {
            email = bundle.getString(Constants.Email);
            passcode = bundle.getString(Constants.PassCode);
            registerResponse = bundle.getParcelable(Constants.RegisterData);
            if (registerResponse != null) {
                registerData = registerResponse.getRegisterData();
            }
        }
        //load_spinner();
        gender_spinner_load(registerData);
        region_spinner_load(registerData);
        ethinicity_spinner_load(registerData);
        iwi_spinner_load(registerData);
        //jobwishlist_spinner_load(registerData);
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
                        cityList = (CityList) view.getTag();
                    } else {
                        cityList = null;
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

    private void jobwishlist_spinner_load(RegisterData registerData) {
        List<JobWishlist> lists = registerData.getJobWishlist();
        jobwishlistDialog.newInstance(lists);
        jobwishlistDialog.setPassJobWishListItems(this);
        jobwishlistDialog.show();
        /*JobWishListSpinnerAdapter adapter = new JobWishListSpinnerAdapter(activity, lists);
        jobWishlistSpinner.setAdapter(adapter);

        jobWishlistSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    jobWishlist = (JobWishlist) view.getTag();
                }else {
                    jobWishlist = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }

    private void iwi_spinner_load(RegisterData registerData) {
        List<IwiList> lists = registerData.getIwiList();
        IwiSpinnerAdapter adapter = new IwiSpinnerAdapter(activity, lists);
        iwiSpinner.setAdapter(adapter);

        iwiSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    iwiList = (IwiList) view.getTag();
                } else {
                    iwiList = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void ethinicity_spinner_load(RegisterData registerData) {
        List<EthnicityList> lists = registerData.getEthnicityList();
        EthnicitySpinnerAdapter adapter = new EthnicitySpinnerAdapter(activity, lists);
        ethnicitySpinner.setAdapter(adapter);

        ethnicitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    ethnicityList = (EthnicityList) view.getTag();
                } else {
                    ethnicityList = null;
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
                    regionList = (RegionList) view.getTag();
                    call_city_api(regionList.getReRegionId());
                } else {
                    regionList = null;
                    district_spinner_load(null);
                    cityList = null;
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

    private void gender_spinner_load(RegisterData registerData) {
        List<GenderList> lists = registerData.getGenderList();
        GenderSpinnerAdapter adapter = new GenderSpinnerAdapter(activity, lists);
        genderSpinner.setAdapter(adapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    genderList = (GenderList) view.getTag();
                } else {
                    genderList = null;
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

    @OnClick({R.id.job_wishlist_spinner, R.id.next_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.job_wishlist_spinner:
                jobwishlist_spinner_load(registerData);
                break;
            case R.id.next_btn:
                validation();
                //signUpFragmentTransfer.fragmentTransferListener(new FragmentCreateAccount3(),2,null);
                break;
        }
    }

    private void validation() {
        //String text = spinner.getSelectedItem().toString();
        if (Objects.requireNonNull(firstName.getText()).toString().isEmpty()) {
            MyToast.errorMessage("firstName " + getResources().getString(R.string.empty), activity);
        } /*else if (Objects.requireNonNull(lastName.getText()).toString().isEmpty()) {
            MyToast.errorMessage("LastName " + getResources().getString(R.string.empty), activity);
        } */else if (genderList == null) {
            MyToast.errorMessage("Select Your Gender", activity);
        } else if (regionList == null) {
            MyToast.errorMessage("Select Your Region", activity);
        } else if (cityList == null) {
            MyToast.errorMessage("Select Your City", activity);
        }/* else if (ethnicityList == null) {
            MyToast.errorMessage("Select Your Ethnicity", activity);
        } else if (jobWishSelectedItems.isEmpty()) {
            MyToast.errorMessage("Select Your MyJobs WishList", activity);
        } else if (iwiList == null) {
            MyToast.errorMessage("Select Your IWI", activity);
        } */else if (Objects.requireNonNull(pwd.getText()).toString().isEmpty()) {
            MyToast.errorMessage("PassWord " + getResources().getString(R.string.empty), activity);
        } else if(!getStringMatches(pwd.getText().toString())){
            MyToast.errorMessage("The PassWord should contain one uppercase,lowercase,numeric and special characters", activity);
        }else if(pwd.getText().toString().length()<8){
            MyToast.errorMessage("The Password field must be at least 8 characters ", activity);
        }else if (Objects.requireNonNull(confirmPwd.getText()).toString().isEmpty()) {
            MyToast.errorMessage("Confirm Password " + getResources().getString(R.string.empty), activity);
        } else if (!pwd.getText().toString().equals(confirmPwd.getText().toString())) {
            MyToast.errorMessage("Both Password fields should be same", activity);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.Email, email);
            bundle.putString(Constants.PassCode, passcode);
            bundle.putParcelable(Constants.RegisterData, registerResponse);

            String last_name = "";
            if(!Objects.requireNonNull(lastName.getText()).toString().isEmpty()){
                last_name = lastName.getText().toString();
            }
            String gender = "";
            if(genderList!=null){
                gender = genderList.getId();
            }
            String region = "";
            if(regionList!=null){
                region = regionList.getReRegionId();
            }
            String city = "";
            if(cityList!=null){
                city = cityList.getCiCityId();
            }
            String ethnicity = "";
            if(ethnicityList!=null){
                ethnicity = ethnicityList.getEtEthnicityId();
            }
            String wishlist = "";
            if(!jobWishSelectedItems.isEmpty()){
                wishlist = jobWishSelectedItems;
            }
            String iwi = "";
            if(iwiList!=null){
                iwi = iwiList.getIwIwiId();
            }

           /* bundle.putString("firstname", firstName.getText().toString());
            bundle.putString("lastname", lastName.getText().toString());
            bundle.putString("pwd", pwd.getText().toString());
            bundle.putString("confirmPwd", confirmPwd.getText().toString());
            bundle.putParcelable(Constants.GenderList, genderList);
            bundle.putParcelable(Constants.RegionList, regionList);
            bundle.putParcelable(Constants.DistrictList, cityList);
            bundle.putParcelable(Constants.EthnicityList, ethnicityList);
            bundle.putString(Constants.JobWishList, jobWishSelectedItems);
            bundle.putParcelable(Constants.IwiList, iwiList);*/

            bundle.putString("firstname", firstName.getText().toString());
            bundle.putString("lastname", last_name);
            bundle.putString("pwd", pwd.getText().toString());
            bundle.putString("confirmPwd", confirmPwd.getText().toString());
            bundle.putString(Constants.GenderList, gender);
            bundle.putString(Constants.RegionList, region);
            bundle.putString(Constants.DistrictList, city);
            bundle.putString(Constants.EthnicityList, ethnicity);
            bundle.putString(Constants.JobWishList, wishlist);
            bundle.putString(Constants.IwiList, iwi);

            signUpFragmentTransfer.fragmentTransferListener(new FragmentCreateAccount3(), 2, bundle);
        }
    }

    public boolean getStringMatches(String value){

        String regex = "^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)" + "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$";

        return value.matches(regex);
    }

    @Override
    public void PassDatas(List<JobWishlist> jobWishlists) {
        for (int i=0;i<jobWishlists.size();i++){
            if(i!=0) {
                jobWishSelectedItems = jobWishSelectedItems + "," + jobWishlists.get(i).getWitTagId();
                jobWishSelectedItemsName = jobWishSelectedItemsName + "," + jobWishlists.get(i).getWitName();
            }else {
                jobWishSelectedItems = jobWishlists.get(i).getWitTagId();
                jobWishSelectedItemsName = jobWishlists.get(i).getWitName();
            }
        }
        jobWishlistSpinner.setText(jobWishSelectedItemsName);
        //Toast.makeText(activity,jobWishSelectedItems,Toast.LENGTH_LONG).show();
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
