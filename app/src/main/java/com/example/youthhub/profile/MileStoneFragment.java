package com.example.youthhub.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.profile.milestone.ProfileMilestoneListResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.NetWorkUtil;

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
 * Use the {@link MileStoneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MileStoneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    MileStoneAdapter mileStoneAdapter;
    private String pageno = null;
    private ProfileMilestoneListResponse profileMilestoneListResponse;
    private String userType = "";
    private String userCode = "";
    String id="0";
private ViewPager viewPager;
    public MileStoneFragment( ) {
        // Required empty public constructor
        this.viewPager=viewPager;

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MileStoneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MileStoneFragment newInstance(String param1, String param2) {
        MileStoneFragment fragment = new MileStoneFragment();
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
        View view = inflater.inflate(R.layout.fragment_mile_stone, container, false);
        unbinder = ButterKnife.bind(this, view);
        call_adapter();
        getBundle();
        return view;
    }

    private void getBundle() {
        try {
            Bundle aBundle = getArguments();
            if (aBundle != null) {


                userType = getArguments().getString(Constants.UserType);
                userCode = getArguments().getString(Constants.UserCode);


            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        call_profile_milestone_api(userCode);

    }

    private void call_adapter() {
        recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void call_profile_milestone_api(String userCode) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ProfileMilestoneListResponse> call = ApiClient.getApiInterface().getMilestoneList(Constants.getApiKey(activity), Constants.getAccessKey(activity),
                    Constants.getToken(activity), pageno,
                    userCode);

            call.enqueue(new Callback<ProfileMilestoneListResponse>() {
                @Override
                public void onResponse(@NonNull Call<ProfileMilestoneListResponse> call, @NonNull Response<ProfileMilestoneListResponse> response) {
                    if (response.isSuccessful()) {
                        //   Log.d(TAG, "onResponse:ProfileYouthInfoResponse 1 ");
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                profileMilestoneListResponse = response.body();
                                mileStoneAdapter = new MileStoneAdapter(activity, profileMilestoneListResponse,id,userCode);
                                recyclerView.setAdapter(mileStoneAdapter);
                                mileStoneAdapter.notifyDataSetChanged();
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                recyclerView.setVisibility(View.VISIBLE);
                            } else {
                                noListImg.setVisibility(View.VISIBLE);
                                noListTxt.setVisibility(View.VISIBLE);
                                recyclerView.setVisibility(View.GONE);

                                noListTxt.setText(response.body().getMessage());

                                Glide.with(activity)
                                        .load(Constants.getLoadGlide(activity, response.body().getStatus_img()))
                                        .apply(AppUtils.getRequestOptionWithoutOverride())
                                        .into(noListImg);
                                //     Log.d(TAG, "onResponse:ProfileYouthInfoResponse else "+new Gson().toJson(profileInfoResp));

                                // MyToast.errorMessage(response.body().getMessage(), activity);
                            }

                        }
                    } else {
                        Log.d(Constants.failureResponse + " ProfileInfo", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ProfileMilestoneListResponse> call, @NonNull Throwable t) {
                    call_profile_milestone_api(userCode);
                    Log.d(Constants.failureResponse + " ProfileInfo", t.toString());
                    Loader.showLoad(activity, false);
                }
            });

        }
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
