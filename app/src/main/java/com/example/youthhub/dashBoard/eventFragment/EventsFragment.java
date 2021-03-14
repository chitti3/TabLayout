package com.example.youthhub.dashBoard.eventFragment;

import android.app.Activity;
import android.content.Intent;
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
import com.example.youthhub.resModel.event.EventList;
import com.example.youthhub.resModel.event.EventListResponse;
import com.example.youthhub.resModel.event.eventView.EventViewResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment implements EventsFilterDialog.OnPassDataListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.events_txt)
    TextView eventsTxt;
    @BindView(R.id.filter_txt)
    TextView filterTxt;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.events_recycler)
    RecyclerView eventsRecycler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    FragmentTransfer fragmentTransfer;
    EventAdapter eventAdapter;

    EventListResponse eventListResponse;
    List<EventList> eventLists = new ArrayList<>();
    List<EventList> eventFilterLists = new ArrayList<>();

    Integer page_no = null;
    Integer filterPageNo = null;

    String access_key;
    String authorizations;
    EventViewResponse eventViewResponse;

    String ismyevent = "";
    String searchName = "";
    String postBy = "";
    boolean clearFilter = true;

    EventsFilterDialog eventFilterDialog;

    private String userType = "";
    private String userCode = "";

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
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
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);
       // fragmentTransfer = (FragmentTransfer) activity;
      //  fragmentTransfer.hideSearchView(true);

        access_key = Preference.getInstance(activity).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);
        getBundle();
        eventFilterDialog = new EventsFilterDialog(activity);
        callTypeFace();
        callEventApi();
        refresh.setOnRefreshListener(() -> {
            page_no = null;
            eventLists.clear();
            eventFilterLists.clear();
            eventAdapter.notifyDataSetChanged();
            eventAdapter.setLoaded();
            callEventApi();
            refresh.setRefreshing(false);
        });
        return view;
    }

    @Override
    public void onResume() {
       // callEventApi();
        super.onResume();
    }

    private void getBundle() {
        try {
            Bundle aBundle = getArguments();
            if (aBundle != null) {


                userType = getArguments().getString(Constants.UserType);
                userCode = getArguments().getString(Constants.UserCode);
                eventsTxt.setVisibility(View.GONE);
                filterTxt.setVisibility(View.GONE);

            }else {
                eventsTxt.setVisibility(View.VISIBLE);
                filterTxt.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            eventsTxt.setVisibility(View.VISIBLE);
            filterTxt.setVisibility(View.VISIBLE);
        }

    }

    private void callEventApi() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            final String ismyevent = "1";
            final String pageno;
            if (page_no == null) {
                pageno = "";
            } else {
                pageno = String.valueOf(page_no);
            }
            final String regionId = "";
            final String searchName = "";
            final String cityId = "";
           // final String userCode = "";
            final String postBy = "";

            Call<EventListResponse> responseCall = ApiClient.getApiInterface().getEventList(Constants.getApiKey(activity), access_key, authorizations, ismyevent, pageno, regionId, searchName, cityId, userCode, postBy);
            responseCall.enqueue(new Callback<EventListResponse>() {
                @Override
                public void onResponse(@NonNull Call<EventListResponse> call, @NonNull Response<EventListResponse> response) {

                    /*if (eventLists.size() > 0) {
                        eventLists.remove(eventLists.size() - 1);
                        int scrollPosition = eventLists.size();
                        eventAdapter.notifyItemRemoved(scrollPosition);
                    }*/
                    if (response.isSuccessful()) {
                        eventListResponse = response.body();
                        if (eventListResponse != null) {
                            if (eventListResponse.getStatus() == 1) {
                                if (noListImg != null && noListTxt != null) {
                                    noListImg.setVisibility(View.GONE);
                                    noListTxt.setVisibility(View.GONE);
                                }
                                eventLists.addAll(eventListResponse.getEventData().getEventList());
                                if (page_no == null) {
                                    call_adapter(eventListResponse, eventLists);
                                } else {
                                    eventAdapter.addAll(eventLists);
                                    eventAdapter.setLoaded();
                                }
                                page_no = eventListResponse.getNextpage();
                            } else {
                                if (!eventListResponse.getMessage().isEmpty() && eventListResponse.getMessage() != null) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.VISIBLE);
                                        noListTxt.setVisibility(View.VISIBLE);

                                        eventLists.clear();
                                   //     eventAdapter.addAll(eventLists);
                                   //     eventAdapter.setLoaded();

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, eventListResponse.getStatus_img()))
                                                .apply(AppUtils.getRequestOption())
                                                .into(noListImg);

                                        noListTxt.setText(eventListResponse.getMessage());
                                    }
                                    //MyToast.normalMessage(galleryResponse.getMessage(), activity);
                                } else {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                }

                                page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " EventList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<EventListResponse> call, @NonNull Throwable t) {
                    callEventApi();
                    Log.d(Constants.failureResponse + " EventList", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void callTypeFace() {
        eventsTxt.setTypeface(FontTypeFace.fontBold(activity));
        filterTxt.setTypeface(FontTypeFace.fontMedium(activity));
    }

    private void call_adapter(EventListResponse eventListResponse, List<EventList> eventLists) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        if (eventsRecycler != null) {
            eventsRecycler.setLayoutManager(linearLayoutManager);
            eventAdapter = new EventAdapter(eventsRecycler, eventLists, activity, eventListResponse.getEventData().getEventLogoPath());
            eventsRecycler.setAdapter(eventAdapter);
            eventAdapter.setOnLoadMoreListener(this::onLoadMore);
            eventAdapter.setPassDataListener((eventList, viewPage, position) -> {
                if (viewPage) {
                    call_event_api(eventList.getCode());
                } else {
                    if (position >= 0) {
                        call_count_status_api(eventList.getCode(), eventList.getParticipantCurrentStatus(), position);
                    }
                }
            });
            eventAdapter.notifyDataSetChanged();
        }
    }

    private void call_count_status_api(String code, final Integer participantCurrentStatus, final int position) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            int status;
            if (participantCurrentStatus == 0) {
                status = 1;
            } else {
                status = 0;
            }
            Call<EventListResponse> responseCall = ApiClient.getApiInterface().getCountMeApplyStatus(Constants.getApiKey(activity), access_key, authorizations, code, String.valueOf(status));
            responseCall.enqueue(new Callback<EventListResponse>() {
                @Override
                public void onResponse(@NonNull Call<EventListResponse> call, @NonNull Response<EventListResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                                EventList eventList = eventLists.get(position);
                                if (status == 1) {
                                    eventList.setParticipantCurrentStatus(1);
                                    eventList.setParticipantCurrentStatusName("Count Me Out");
                                } else {
                                    eventList.setParticipantCurrentStatus(0);
                                    eventList.setParticipantCurrentStatusName("Count Me In");
                                }
                                eventLists.set(position, eventList);
                                eventAdapter.notifyDataSetChanged();

                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " CountMeStatus", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<EventListResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " CountMeStatus", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_event_api(String event_code) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            Call<EventViewResponse> responseCall = ApiClient.getApiInterface().getEventView(Constants.getApiKey(activity), access_key, authorizations, event_code);
            responseCall.enqueue(new Callback<EventViewResponse>() {
                @Override
                public void onResponse(@NonNull Call<EventViewResponse> call, @NonNull Response<EventViewResponse> response) {
                    if (response.isSuccessful()) {
                        eventViewResponse = response.body();
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                if (eventViewResponse.getStatus() == 1) {
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable(Constants.EventViewRes, eventViewResponse);
                                    Intent eventIntent = new Intent(activity, EventActivity.class);
                                    eventIntent.putExtras(bundle);
                                    activity.startActivity(eventIntent);
                                    activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                                }
                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " EventView", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<EventViewResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " EventView", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void onLoadMore() {
        if (clearFilter) {
            if (page_no != null) {
                callEventApi();
            }
        } else {
            if (filterPageNo != null) {
                callFilterApi(searchName, postBy, ismyevent, clearFilter, true);
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
                eventFilterDialog.setOnPassDataListener(this);
                eventFilterDialog.show();
                break;
        }
    }

    @Override
    public void passData(String title, String postBy, String isMyEvent, boolean clear) {
        callFilterApi(title, postBy, isMyEvent, clear, false);
    }

    private void callFilterApi(String title, String postedBy, String isMyEvent, boolean clear, final boolean loadMore) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            clearFilter = clear;
            ismyevent = isMyEvent;
            if (!loadMore) {
                filterPageNo = null;
            }
            final String pageno;
            if (filterPageNo == null) {
                pageno = "";
            } else {
                pageno = String.valueOf(filterPageNo);
            }
            final String regionId = "";
            searchName = title;
            final String cityId = "";
            final String userCode = "";
            postBy = postedBy;
            if (!clear) {
                Call<EventListResponse> responseCall = ApiClient.getApiInterface().getEventList(Constants.getApiKey(activity), access_key, authorizations, ismyevent, pageno, regionId, searchName, cityId, userCode, postBy);
                responseCall.enqueue(new Callback<EventListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<EventListResponse> call, @NonNull Response<EventListResponse> response) {

                        /*if (eventFilterLists.size() > 0) {
                            eventFilterLists.remove(eventFilterLists.size() - 1);
                            int scrollPosition = eventFilterLists.size();
                            eventAdapter.notifyItemRemoved(scrollPosition);
                        }*/

                        if (response.isSuccessful()) {
                            eventListResponse = response.body();
                            if (eventListResponse != null) {
                                if (eventListResponse.getStatus() == 1) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                    if (loadMore) {
                                        eventFilterLists.addAll(eventListResponse.getEventData().getEventList());
                                    } else {
                                        eventFilterLists = eventListResponse.getEventData().getEventList();
                                    }
                                    eventAdapter.addAll(eventFilterLists);
                                    eventAdapter.setLoaded();
                                    filterPageNo = eventListResponse.getNextpage();
                                } else {

                                    if (!eventListResponse.getMessage().isEmpty() && eventListResponse.getMessage() != null) {
                                        eventFilterLists.clear();
                                        eventAdapter.addAll(eventFilterLists);
                                        eventAdapter.setLoaded();

                                        if (noListImg != null && noListTxt != null) {
                                            noListImg.setVisibility(View.VISIBLE);
                                            noListTxt.setVisibility(View.VISIBLE);
                                        }

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, eventListResponse.getStatus_img()))
                                                .apply(AppUtils.getRequestOption())
                                                .into(noListImg);

                                        noListTxt.setText(eventListResponse.getMessage());
                                        //MyToast.errorMessage(eventListResponse.getMessage(), activity);
                                    } else {
                                        if (noListImg != null && noListTxt != null) {
                                            noListImg.setVisibility(View.GONE);
                                            noListTxt.setVisibility(View.GONE);
                                        }
                                    }
                                    filterPageNo = null;
                                }
                            }
                        } else {
                            Log.d(Constants.failureResponse + " EventList", response.toString());
                        }
                        Loader.showLoad(activity, false);
                    }

                    @Override
                    public void onFailure(@NonNull Call<EventListResponse> call, @NonNull Throwable t) {
                        callFilterApi(searchName, postBy, ismyevent, clearFilter, loadMore);
                        Log.d(Constants.failureResponse + " EventList", t.toString());
                        //MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                        Loader.showLoad(activity, false);
                    }
                });
            } else {
                if (noListImg != null && noListTxt != null) {
                    noListImg.setVisibility(View.GONE);
                    noListTxt.setVisibility(View.GONE);
                }
                eventAdapter.addAll(eventLists);
                eventAdapter.setLoaded();
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
        void onFragmentInteraction(Uri uri);
    }
}