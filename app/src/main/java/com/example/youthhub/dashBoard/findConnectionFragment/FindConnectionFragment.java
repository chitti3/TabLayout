package com.example.youthhub.dashBoard.findConnectionFragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.connection.Connection;
import com.example.youthhub.resModel.connection.ConnectionList;
import com.example.youthhub.resModel.connection.conListMaster.ConnectionListMaster;
import com.example.youthhub.resModel.connection.followunfollow.FollowUnfollowResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Use the {@link FindConnectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FindConnectionFragment extends Fragment implements FindConnectionAdapter.OnLoadMoreListener, FindConnectionAdapter.OnPassDataListener, FindConFilterDialog.OnPassDataListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.find_connection_txt)
    TextView findConnectionTxt;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.find_connection_recycler)
    RecyclerView findConnectionRecycler;
    Unbinder unbinder;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;

    ConnectionListMaster connectionListMaster = null;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private OnFragmentInteractionListener mListener;

    Activity activity;

    FindConnectionAdapter findConnectionAdapter;
    FragmentTransfer fragmentTransfer;
    Connection connection;
    List<ConnectionList> connectionLists = new ArrayList<>();
    Integer page_no = null;

    FindConFilterDialog findConFilterDialog;

    String usertype = "";
    String search = "";
    String region = "";
    String city = "";
    String wishlist = "";
    String service = "";
    String bizservice = "";
    String bizSubService = "";
    String tags = "";


    public FindConnectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FindConnectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FindConnectionFragment newInstance(String param1, String param2) {
        FindConnectionFragment fragment = new FindConnectionFragment();
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
        View view = inflater.inflate(R.layout.fragment_find_connection, container, false);
        unbinder = ButterKnife.bind(this, view);
        fragmentTransfer = (FragmentTransfer) activity;
        fragmentTransfer.hideSearchView(true);

        findConFilterDialog = new FindConFilterDialog(activity);

        callTypeFace();
        call_adapter();
        call_connection_list_api(false);
        call_list_master_api();
        refresh.setOnRefreshListener(() -> {
            page_no = null;
            usertype = "";
            search = "";
            region = "";
            city = "";
            wishlist = "";
            service = "";
            bizservice = "";
            bizSubService = "";
            tags = "";
            connectionLists.clear();
            findConnectionAdapter.notifyDataSetChanged();
            findConnectionAdapter.setLoaded();
            call_connection_list_api(false);
            refresh.setRefreshing(false);
        });
        return view;
    }

    private void call_list_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<ConnectionListMaster> call = ApiClient.getApiInterface().getConListMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity));
            call.enqueue(new Callback<ConnectionListMaster>() {
                @Override
                public void onResponse(@NonNull Call<ConnectionListMaster> call, @NonNull Response<ConnectionListMaster> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                connectionListMaster = response.body();
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ConListMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<ConnectionListMaster> call, @NonNull Throwable t) {
                    call_list_master_api();
                    Log.d(Constants.failureResponse + " ConListMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_connection_list_api(final boolean filter) {
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

            String user_type = "";
            if (usertype.isEmpty()) {
                user_type = Constants.getUserType(activity);
            } else {
                user_type = usertype;
            }

            Call<Connection> connectionCall = ApiClient.getApiInterface().getConnection(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity),
                    Constants.getToken(activity),
                    user_type,
                    search,
                    region,
                    city,
                    "",
                    wishlist,
                    service,
                    bizservice,
                    bizSubService,
                    tags,
                    pageNo);

            connectionCall.enqueue(new Callback<Connection>() {
                @Override
                public void onResponse(@NonNull Call<Connection> call, @NonNull Response<Connection> response) {
                    if (response.isSuccessful()) {
                        connection = response.body();

                        if (connection != null) {
                            if (connection.getStatus() == 1) {
                                noListImg.setVisibility(View.GONE);
                                noListTxt.setVisibility(View.GONE);
                                updateUi(connection, pageNo);
                            } else {
                                no_list(connection);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " Connection", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<Connection> call, @NonNull Throwable t) {
                    call_connection_list_api(filter);
                    Log.d(Constants.failureResponse + " Connection", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void updateUi(Connection connection, String pageNo) {
        if (pageNo.isEmpty()) {
            connectionLists = connection.getConnectionData().getConnectionList();
        } else {
            connectionLists.addAll(connection.getConnectionData().getConnectionList());
        }
        final Map<String, String> imagePath = new HashMap<>();
        imagePath.put("user_medium_path", connection.getConnectionData().getUserMediumPath());
        imagePath.put("user_thumbnail_path", connection.getConnectionData().getUserThumbnailPath());
        findConnectionAdapter.addAll(connectionLists, imagePath);
        findConnectionAdapter.setLoaded();
        page_no = connection.getNextpage();
    }

    private void no_list(Connection connection) {
        if (!connection.getMessage().isEmpty()) {
            noListImg.setVisibility(View.VISIBLE);
            noListTxt.setVisibility(View.VISIBLE);

            connectionLists.clear();
            findConnectionAdapter.addAll(connectionLists, null);
            findConnectionAdapter.setLoaded();

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, connection.getStatusImg()))
                    .apply(AppUtils.getRequestOptionWithoutOverride())
                    .into(noListImg);

            noListTxt.setText(connection.getMessage());
            //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
        } else {
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
        }
        page_no = null;
    }

    private void callTypeFace() {
        findConnectionTxt.setTypeface(FontTypeFace.fontBold(activity));
        filterTxt.setTypeface(FontTypeFace.fontMedium(activity));
    }

    private void call_adapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
        findConnectionRecycler.setLayoutManager(gridLayoutManager);
        findConnectionAdapter = new FindConnectionAdapter(activity, findConnectionRecycler);
        findConnectionAdapter.setOnLoadMoreListener(this);
        findConnectionAdapter.setOnPassDataListener(this);
        findConnectionRecycler.setAdapter(findConnectionAdapter);
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

    @OnClick(R.id.filter_txt)
    public void onViewClicked() {
        if (connectionListMaster != null) {
            findConFilterDialog.newInstance(connectionListMaster);
            findConFilterDialog.setOnPassDataListener(this);
            findConFilterDialog.show();
        }
    }

    @Override
    public void onLoadMore() {
        loadMore();
    }

    private void loadMore() {
        if (page_no != null) {
            call_connection_list_api(false);
        }
    }

    @Override
    public void onPassData(final ConnectionList connectionList, final int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            String isfollow;
            if (connectionList.getIsFollow() == 0) {
                isfollow = "1";
            } else {
                isfollow = "0";
            }
            Call<FollowUnfollowResponse> call = ApiClient.getApiInterface().getFollowUnFollow(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), connectionList.getUsercode(), isfollow);
            call.enqueue(new Callback<FollowUnfollowResponse>() {
                @Override
                public void onResponse(@NonNull Call<FollowUnfollowResponse> call, @NonNull Response<FollowUnfollowResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                change_ui(response.body(), position);
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " FollowUnFollow", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<FollowUnfollowResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " FollowUnFollow", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void change_ui(FollowUnfollowResponse connection, int position) {
        if (connection.getMessage().contains("Follow") || connection.getMessage().contains("Unfollow")) {
            ConnectionList connectionList = connectionLists.get(position);
            if (connection.getMessage().contains("Follow")) {
                connectionList.setIsFollow(1);
            } else if (connection.getMessage().contains("Unfollow")) {
                connectionList.setIsFollow(0);
            }
            connectionLists.set(position, connectionList);
            findConnectionAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void passData(String usertype, String search, String region, String city, String wishlist, String service, String bizservice, String bizSubService, String tags) {
        this.usertype = usertype;
        this.search = search;
        this.region = region;
        this.city = city;
        this.wishlist = wishlist;
        this.service = service;
        this.bizservice = bizservice;
        this.bizSubService = bizSubService;
        this.tags = tags;
        call_connection_list_api(true);

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
