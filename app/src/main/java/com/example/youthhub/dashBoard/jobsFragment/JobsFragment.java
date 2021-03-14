package com.example.youthhub.dashBoard.jobsFragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DeleteMessageDialog;
import com.example.youthhub.dashBoard.FragmentTransfer;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.jobs.Jobs;
import com.example.youthhub.resModel.jobs.JobsList;
import com.example.youthhub.resModel.jobs.listmaster.JobListMaster;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;

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
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsFragment extends Fragment implements JobsAdapter.OnLoadMoreListener, JobsAdapter.OnPassDataListener, JobsFilterDialog.OnPassDataListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.jobs_txt)
    TextView jobsTxt;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.jobs_recycler)
    RecyclerView jobsRecycler;
    Unbinder unbinder;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    OnJobFilterListener onJobFilterListener;
    private OnFragmentInteractionListener mListener;

    Activity activity;

    FragmentTransfer fragmentTransfer;

    JobsAdapter jobsAdapter;
    Jobs jobs;
    List<JobsList> jobsLists = new ArrayList<>();
    Integer page_no = null;
    JobListMaster jobListMaster = null;

    String searchName = "";
    String regionIds = "";
    String cityIds = "";
    String categoryIds = "";
    String subCategoryIds = "";
    String jobTypeIds = "";
    String salaryType = "";
    String salaryRangeFrom = "";
    String salaryRangeTo = "";
    boolean mfiler = false;

    JobsFilterDialog jobsFilterDialog;


    private String userType = "";
    private String userCode = "";
    public void setOnJobFilterListener(OnJobFilterListener onJobFilterListener) {
        this.onJobFilterListener = onJobFilterListener;
    }
    public JobsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobsFragment newInstance(String param1, String param2) {
        JobsFragment fragment = new JobsFragment();
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
        View view = inflater.inflate(R.layout.fragment_jobs, container, false);
        unbinder = ButterKnife.bind(this, view);
       // fragmentTransfer = (FragmentTransfer) activity;
        //fragmentTransfer.hideSearchView(true);
        getBundle();
        callTypeFace();
        call_adapter();
        call_jobs_api(false);

        call_list_master_api();
        jobsFilterDialog = new JobsFilterDialog(activity);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page_no = null;

                searchName = "";
                regionIds = "";
                cityIds = "";
                categoryIds = "";
                subCategoryIds = "";
                jobTypeIds = "";
                salaryType = "";
                salaryRangeFrom = "";
                salaryRangeTo = "";

                jobsLists.clear();
                jobsAdapter.notifyDataSetChanged();
                jobsAdapter.setLoaded();
                call_jobs_api(false);
                refresh.setRefreshing(false);
            }
        });
        return view;
    }

    private void getBundle() {
        try {
            Bundle aBundle = getArguments();
            if (aBundle != null) {


                userType = getArguments().getString(Constants.UserType);
                userCode = getArguments().getString(Constants.UserCode);
                jobsTxt.setVisibility(View.GONE);
                filterTxt.setVisibility(View.GONE);

            }else {
                jobsTxt.setVisibility(View.VISIBLE);
                filterTxt.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jobsTxt.setVisibility(View.VISIBLE);
            filterTxt.setVisibility(View.VISIBLE);
        }

    }

    private void call_list_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<JobListMaster> call = ApiClient.getApiInterface().getListMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity));
            call.enqueue(new Callback<JobListMaster>() {
                @Override
                public void onResponse(@NonNull Call<JobListMaster> call, @NonNull Response<JobListMaster> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                jobListMaster = response.body();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " JobListMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(Call<JobListMaster> call, Throwable t) {
                    Log.d(Constants.failureResponse + " JobListMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_jobs_api(boolean filter) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            if (filter) {
                page_no = null;
            }

            final String pageNo;
            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }

            Call<Jobs> jobsCall = ApiClient.getApiInterface().getJobs(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    pageNo,
                    searchName,
                    regionIds,
                    cityIds,
                    categoryIds,
                    subCategoryIds,
                    jobTypeIds,
                    salaryType,
                    salaryRangeFrom,
                    salaryRangeTo,userCode);

            jobsCall.enqueue(new Callback<Jobs>() {
                @Override
                public void onResponse(@NonNull Call<Jobs> call, @NonNull Response<Jobs> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            jobs = response.body();
                            if (response.body().getStatus() == 1) {
                                if (noListImg != null && noListTxt != null) {
                                    noListImg.setVisibility(View.GONE);
                                    noListTxt.setVisibility(View.GONE);
                                }
                                updateUi(jobs, pageNo);
                               mfiler=true;
                            } else {
                                MyToast.normalMessage(jobs.getMessage(),activity);
                                mfiler=false;
                               // no_list(jobs);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " Jobs", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<Jobs> call, @NonNull Throwable t) {
                    call_jobs_api(false);
                    Log.d(Constants.failureResponse + " Jobs", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateUi(Jobs jobs, String pageNo) {
        if (pageNo.isEmpty()) {
            jobsLists = jobs.getJobsData().getJobsList();
        } else {
            jobsLists.addAll(jobs.getJobsData().getJobsList());
        }
        jobsAdapter.addAll(jobsLists);
        jobsAdapter.setLoaded();
        page_no = jobs.getNextpage();
    }

    private void no_list(Jobs jobs) {
        if (!jobs.getMessage().isEmpty()) {
            noListImg.setVisibility(View.VISIBLE);
            noListTxt.setVisibility(View.VISIBLE);

            jobsLists.clear();
            jobsAdapter.addAll(jobsLists);
            jobsAdapter.setLoaded();

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, jobs.getStatusImg()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(noListImg);

            noListTxt.setText(jobs.getMessage());
            //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
        } else {
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
        }
        page_no = null;
    }

    private void callTypeFace() {
        jobsTxt.setTypeface(FontTypeFace.fontBold(activity));
        filterTxt.setTypeface(FontTypeFace.fontMedium(activity));
    }

    private void call_adapter() {
        jobsRecycler.setLayoutManager(new LinearLayoutManager(activity));
        jobsAdapter = new JobsAdapter(activity, jobsRecycler);
        jobsAdapter.setOnLoadMoreListener(this);
        jobsAdapter.setOnPassDataListener(this);
        jobsRecycler.setAdapter(jobsAdapter);
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

    @OnClick({R.id.filter_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filter_txt:
                if (jobListMaster != null) {
                    jobsFilterDialog.newInstance(jobListMaster);
                    jobsFilterDialog.setOnPassDataListener(this);
                    jobsFilterDialog.show();
                }
                break;
        }
    }

    @Override
    public void onLoadMore() {
        loadMore();
    }

    private void loadMore() {
        if (page_no != null) {
            call_jobs_api(false);
        }
    }

    @Override
    public void onPassData(JobsList jobsList, final int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            String jobCode = jobsList.getJmCode();
            final String isSave;
            if (jobsList.getIsSave() == 0) {
                isSave = "1";
            } else {
                isSave = "0";
            }
            Call<CommonRes> resCall = ApiClient.getApiInterface().getIsSave(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), jobCode, isSave);
            resCall.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                updateIsSave(position, Integer.valueOf(isSave));
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " JobIsSave", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " JobIsSave", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateIsSave(int position, Integer isSave) {
        JobsList jobsList = jobsLists.get(position);
        jobsList.setIsSave(isSave);
        jobsLists.set(position, jobsList);
        jobsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPassData(String search, String category, String subCategory, String region, String city, String salaryType1, String salaryFrom, String salaryTo, String jobType, boolean filter) {

        searchName = search;
        categoryIds = category;
        subCategoryIds = subCategory;
        regionIds = region;
        cityIds = city;
        salaryType = salaryType1;
        salaryRangeFrom = salaryFrom;
        salaryRangeTo = salaryTo;
        jobTypeIds = jobType;
        mfiler = filter;

        call_jobs_api(mfiler);
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

    public interface OnJobFilterListener {
        void OnDelete(boolean deleted);
    }
}