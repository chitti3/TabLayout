package com.example.youthhub.dashBoard.exploreFragment;

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
import com.example.youthhub.dashBoard.FragmentTransfer;
import com.example.youthhub.resModel.explore.ExploreListResponse;
import com.example.youthhub.resModel.explore.Explorelist;
import com.example.youthhub.resModel.explore.masterApi.ExploreListMasterResponse;
import com.example.youthhub.resModel.explore.masterApi.ExploreTag;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.profile.ProfileFragment.TAG;
import static com.example.youthhub.utils.Constants.ProfileInfo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment implements ExploreFilterDialog.OnPassDataListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.explore_txt)
    TextView exploreTxt;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.explore_recycler)
    RecyclerView exploreRecycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    FragmentTransfer fragmentTransfer;
    ExploreAdapter exploreAdapter;

    ExploreListResponse exploreListResponse;
    List<Explorelist> explorelists = new ArrayList<>();
    List<Explorelist> exploreFilterLists = new ArrayList<>();

    Integer page_no = null;
    Integer filterPageNo = null;

    ExploreListMasterResponse exploreListMasterResponse;
    String Type = "1";

    boolean clearFilter = true;

    String searchName = "";
    String postBy = "";
    String type = "";
    List<ExploreTag> exploreTags = new ArrayList<>();
    private String userType = "";
    private String userCode = "";

    public ExploreFragment() {
        // Required empty public constructor
    }

    String access_key, authorizations;

    ExploreFilterDialog exploreFilterDialog;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
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
        access_key = Preference.getInstance(activity).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this, view);
       // fragmentTransfer = (FragmentTransfer) activity;
      //  fragmentTransfer.hideSearchView(true);

        callTypeFace();
        getBundle();
        exploreFilterDialog = new ExploreFilterDialog(activity);
        //call_adapter();
        refresh.setOnRefreshListener(() -> {
            page_no = null;
            explorelists.clear();
            exploreFilterLists.clear();
            exploreAdapter.notifyDataSetChanged();
            exploreAdapter.setLoaded();
            call_explore_api();
            refresh.setRefreshing(false);
        });
        return view;
    }

    private void getBundle() {
        try {
            Bundle aBundle = getArguments();
            if (aBundle != null) {


                userType = getArguments().getString(Constants.UserType);
                userCode = getArguments().getString(Constants.UserCode);
                exploreTxt.setVisibility(View.GONE);
                filterTxt.setVisibility(View.GONE);
                Type ="0";

            }else {
                exploreTxt.setVisibility(View.VISIBLE);
                filterTxt.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            exploreTxt.setVisibility(View.VISIBLE);
            filterTxt.setVisibility(View.VISIBLE);
        }
        master_api();
    }

    private void master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
          //  Loader.showLoad(activity, true);
            Call<ExploreListMasterResponse> responseCall = ApiClient.getApiInterface().getExploreMaster(Constants.getApiKey(activity), access_key, authorizations);
            responseCall.enqueue(new Callback<ExploreListMasterResponse>() {
                @Override
                public void onResponse(@NonNull Call<ExploreListMasterResponse> call, @NonNull Response<ExploreListMasterResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            exploreListMasterResponse = response.body();
                            if (response.body().getStatus() == 1) {
                            //    Type = String.valueOf(exploreListMasterResponse.getExploreMasterData().getType().get(0).getId());
                                call_explore_api();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ExMasterList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ExploreListMasterResponse> call, @NonNull Throwable t) {
                    master_api();
                    Log.d(Constants.failureResponse + " ExMasterList", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_explore_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
          //  Loader.showLoad(activity, true);
            String type;
            if (Type != null) {
                type = Type;
                final String searchName = "";
                final String pageNo;
                if (page_no == null) {
                    pageNo = "";
                } else {
                    pageNo = String.valueOf(page_no);
                }
                final String rating = "";
                final String contentType = "";
               // final String userCode = "";
                final String postBy = "";
                final String tags = "";
                Log.d(TAG, "onResponse:exploreListResponse userCode"+userCode);

                Call<ExploreListResponse> responseCall = ApiClient.getApiInterface().getExploreList(Constants.getApiKey(activity), access_key, authorizations, type, searchName, pageNo, rating, contentType, userCode, tags, postBy);
                responseCall.enqueue(new Callback<ExploreListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ExploreListResponse> call, @NonNull Response<ExploreListResponse> response) {
                        if (response.isSuccessful()) {
                            exploreListResponse = response.body();
                            Log.d(TAG, "onResponse:exploreListResponse "+new Gson().toJson(exploreListResponse));
                            if (exploreListResponse != null) {
                                if (exploreListResponse.getStatus() == 1) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                    explorelists.addAll(exploreListResponse.getExploreListData().getExplorelist());
                                    if (page_no == null) {
                                        call_adapter(exploreListResponse, explorelists);
                                    } else {
                                        exploreAdapter.addAll(explorelists);
                                        exploreAdapter.setLoaded();
                                    }
                                    page_no = exploreListResponse.getNextpage();
                                } else {
                                    if (!exploreListResponse.getMessage().isEmpty() && exploreListResponse.getMessage() != null) {
                                        noListImg.setVisibility(View.VISIBLE);
                                        noListTxt.setVisibility(View.VISIBLE);

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, exploreListResponse.getStatusImg()))
                                                .apply(AppUtils.getRequestOptionWithoutOverride())
                                                .into(noListImg);

                                        noListTxt.setText(exploreListResponse.getMessage());
                                        //MyToast.normalMessage(galleryResponse.getMessage(), activity);
                                    } else {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                    page_no = null;
                                }
                            }
                        } else {
                            Log.d(Constants.failureResponse + " ExploreList", response.toString());
                        }
                        Loader.showLoad(activity, false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<ExploreListResponse> call, @NonNull Throwable t) {
                        call_explore_api();
                        Log.d(Constants.failureResponse + " ExploreList", t.toString());
                        //MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                        Loader.showLoad(activity, false);
                    }
                });
            }
        }
    }

    private void callTypeFace() {
        exploreTxt.setTypeface(FontTypeFace.fontBold(activity));
        filterTxt.setTypeface(FontTypeFace.fontMedium(activity));
    }

    private void call_adapter(ExploreListResponse exploreListResponse, List<Explorelist> explorelists) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        if (exploreRecycler != null) {
            exploreRecycler.setLayoutManager(linearLayoutManager);
            exploreAdapter = new ExploreAdapter(activity, exploreRecycler, explorelists, exploreListResponse.getExploreListData().getUserMediumPath());
            exploreRecycler.setAdapter(exploreAdapter);
            exploreAdapter.setOnLoadMoreListener(this::onLoadMore);
        }
    }

    private void onLoadMore() {

        if (clearFilter) {
            if (page_no != null) {
                //explorelists.add(null);
                //exploreAdapter.notifyItemInserted(explorelists.size() - 1);
                call_explore_api();
            }
        } else {
            if (filterPageNo != null) {
                //exploreFilterLists.add(null);
                //exploreAdapter.notifyItemInserted(exploreFilterLists.size() - 1);
                callFilterApi(searchName, postBy, type, clearFilter, exploreTags, true);
            }
        }

    }

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
    }

    @OnClick({R.id.filter_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.filter_txt:
                exploreFilterDialog.newInstance(exploreListMasterResponse, exploreTags);
                exploreFilterDialog.setOnPassDataListener(this);
                exploreFilterDialog.show();
                break;
        }
    }

    @Override
    public void passData(String title, String postBy, String explore, boolean clear, List<ExploreTag> exploreTags) {
        callFilterApi(title, postBy, explore, clear, exploreTags, false);
    }

    private void callFilterApi(String title, String postby, String explore, boolean clear, final List<ExploreTag> exploreTags, final boolean loadmore) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            //Loader.showLoad(activity, true);
            clearFilter = clear;
            this.exploreTags = exploreTags;
            type = explore;
            searchName = title;
            if (!loadmore) {
                filterPageNo = null;
            }
            final String pageno;
            if (filterPageNo == null) {
                pageno = "";
            } else {
                pageno = String.valueOf(filterPageNo);
            }
            final String rating = "";
            final String contentType = "";
            final String userCode = "";
            postBy = postby;
            String tags = "";
            if (exploreTags.size() > 0) {
                for (int i = 0; i < exploreTags.size(); i++) {
                    if (i != 0) {
                        tags = tags + "," + exploreTags.get(i).getTgTagId();
                    } else {
                        tags = exploreTags.get(i).getTgTagId();
                    }
                }
            }
            if (!clear) {
                Call<ExploreListResponse> responseCall = ApiClient.getApiInterface().getExploreList(Constants.getApiKey(activity), access_key, authorizations, type, searchName, pageno, rating, contentType, userCode, tags, postBy);
                responseCall.enqueue(new Callback<ExploreListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ExploreListResponse> call, @NonNull Response<ExploreListResponse> response) {
                        /*if (exploreFilterLists.size() > 0) {
                            exploreFilterLists.remove(exploreFilterLists.size() - 1);
                            int scrollPosition = exploreFilterLists.size();
                            exploreAdapter.notifyItemRemoved(scrollPosition);
                        }*/
                        if (response.isSuccessful()) {
                            exploreListResponse = response.body();
                            if (exploreListResponse != null) {
                                if (exploreListResponse.getStatus() == 1) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                    if (loadmore) {
                                        exploreFilterLists.addAll(exploreListResponse.getExploreListData().getExplorelist());
                                    } else {
                                        exploreFilterLists = exploreListResponse.getExploreListData().getExplorelist();
                                    }
                                    exploreAdapter.addAll(exploreFilterLists);
                                    exploreAdapter.setLoaded();
                                    filterPageNo = exploreListResponse.getNextpage();
                                } else {

                                    if (!exploreListResponse.getMessage().isEmpty() && exploreListResponse.getMessage() != null) {
                                        exploreFilterLists.clear();
                                        exploreAdapter.addAll(exploreFilterLists);
                                        exploreAdapter.setLoaded();

                                        noListImg.setVisibility(View.VISIBLE);
                                        noListTxt.setVisibility(View.VISIBLE);

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, exploreListResponse.getStatusImg()))
                                                .apply(AppUtils.getRequestOptionWithoutOverride())
                                                .into(noListImg);

                                        noListTxt.setText(exploreListResponse.getMessage());

                                        //MyToast.errorMessage(exploreListResponse.getMessage(), activity);
                                    } else {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                    filterPageNo = null;
                                }
                            }

                        } else {
                            Log.d(Constants.failureResponse + " ExploreList", response.toString());
                        }
                        Loader.showLoad(activity, false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<ExploreListResponse> call, @NonNull Throwable t) {
                        callFilterApi(searchName, postBy, type, clearFilter, exploreTags, loadmore);
                        Log.d(Constants.failureResponse + " ExploreList", t.toString());
                        //MyToast.errorMessage(getResources().getString(R.string.error_msg),activity);
                        Loader.showLoad(activity, false);
                    }
                });
            } else {
                noListImg.setVisibility(View.GONE);
                noListTxt.setVisibility(View.GONE);
                exploreAdapter.addAll(explorelists);
                exploreAdapter.setLoaded();
                Loader.showLoad(activity, false);
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
