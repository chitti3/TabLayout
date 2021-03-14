package com.example.youthhub.dashBoard.messagesFragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.example.youthhub.DataModel;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.DashBoardActivity;
import com.example.youthhub.dashBoard.FragmentTransfer;
import com.example.youthhub.dashBoard.findConnectionFragment.FindConnectionFragment;
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
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.youthhub.utils.Constants.App_CHAT_TYPE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MessagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessagesFragment extends Fragment {

    public static final String TAG = "MessagesFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.message_txt)
    TextView messageTxt;
    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.message_recycler)
    RecyclerView messageRecycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    Unbinder unbinder;

    List<MessageListResponse.UserList> userLists = new ArrayList<>();
    List<MessageListResponse.UserList> userFilterLists = new ArrayList<>();
    Integer page_no = null;
    Integer filterPageNo = null;
    boolean clearFilter = true;

    String access_key;
    String searchName = "";
    @BindView(R.id.btn_no_list_txt)
    Button btnNoListTxt;

    private String authorizations;
    private MessageListResponse messageListResponse;
    MessageAdapter messageAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Activity activity;
    FragmentTransfer fragmentTransfer;


    List<DataModel> dataModelList;

    public MessagesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MessagesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessagesFragment newInstance(String param1, String param2) {
        MessagesFragment fragment = new MessagesFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        unbinder = ButterKnife.bind(this, view);
        fragmentTransfer = (FragmentTransfer) activity;
        fragmentTransfer.hideSearchView(true);

        access_key = Preference.getInstance(activity).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);

        callTypeFace();
        callMessageApi();
        refresh.setOnRefreshListener(() -> {
            page_no = null;
            userLists.clear();
            //eventFilterLists.clear();
            if (userLists.size()>0) {
                messageAdapter.notifyDataSetChanged();
                messageAdapter.setLoaded();


            }  callMessageApi();
            refresh.setRefreshing(false);
        });
        //message_list();

        return view;
    }

    private void callTypeFace() {
        messageTxt.setTypeface(FontTypeFace.fontBold(activity));
    }


    private void callMessageApi() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            final String pageno;
            if (page_no == null) {
                pageno = "";
            } else {
                pageno = String.valueOf(page_no);
            }
            final String searchType = App_CHAT_TYPE;
            final String searchName = "";
            Log.d(TAG, "callMessageApi: " + Constants.getApiKey(activity));
            Log.d(TAG, "callMessageApi:access_key " + access_key);
            Log.d(TAG, "callMessageApi: authorizations" + authorizations);
            Log.d(TAG, "callMessageApi:pageno " + pageno);
            Log.d(TAG, "callMessageApi:searchType " + searchType);
            Log.d(TAG, "callMessageApi:searchName " + searchName);

            Call<MessageListResponse> responseCall = ApiClient.getApiInterface().getChatList(Constants.getApiKey(activity),
                    access_key, authorizations, pageno, searchType, searchName);
            responseCall.enqueue(new Callback<MessageListResponse>() {
                @Override
                public void onResponse(@NonNull Call<MessageListResponse> call, @NonNull Response<MessageListResponse> response) {


                    if (response.isSuccessful()) {
                        messageListResponse = response.body();
                        if (messageListResponse != null) {
                            if (messageListResponse.getStatus() == 1) {
                                if (noListImg != null && noListTxt != null) {
                                    noListImg.setVisibility(View.GONE);
                                    noListTxt.setVisibility(View.GONE);
                                    btnNoListTxt.setVisibility(View.GONE);
                                }
                                userLists.addAll(messageListResponse.getData().getUser_list());
                                if (page_no == null) {
                                    call_adapter(messageListResponse, userLists);
                                } else {
                                    messageAdapter.addAll(userLists);
                                    messageAdapter.setLoaded();
                                }
                                page_no = messageListResponse.getNextpage();
                            } else {
                                if (!messageListResponse.getMessage().isEmpty() && messageListResponse.getMessage() != null) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.VISIBLE);
                                        noListTxt.setVisibility(View.VISIBLE);
                                        btnNoListTxt.setVisibility(View.VISIBLE);

                                        //   userLists.clear();
                                        //   messageAdapter.addAll(userLists);
                                        //  messageAdapter.setLoaded();

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, messageListResponse.getStatus_img()))
                                                .apply(AppUtils.getRequestOption())
                                                .into(noListImg);

                                        noListTxt.setText(messageListResponse.getMessage());
                                    }
                                    //MyToast.normalMessage(galleryResponse.getMessage(), activity);
                                } else {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                        btnNoListTxt.setVisibility(View.GONE);
                                    }
                                }

                                page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " MessageList", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<MessageListResponse> call, @NonNull Throwable t) {
                    callMessageApi();
                    Log.d(Constants.failureResponse + " ChatList", t.toString());
                    //MyToast.errorMessage(getResources().getString(R.string.error_msg), activity);
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_adapter(MessageListResponse messageListResponse, List<MessageListResponse.UserList> userLists) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        if (messageRecycler != null) {
            messageRecycler.setLayoutManager(linearLayoutManager);
            messageAdapter = new MessageAdapter(messageRecycler, userLists, activity, messageListResponse.getStatus_img());
            messageRecycler.setAdapter(messageAdapter);
            messageAdapter.setOnLoadMoreListener(this::onLoadMore);
            /*    messageAdapter.setPassDataListener((eventList, viewPage, position) -> {
             *//* if (viewPage) {
                    call_event_api(eventList.getCode());
                } else {
                    if (position >= 0) {
                        call_count_status_api(eventList.getCode(), eventList.getParticipantCurrentStatus(), position);
                    }
                }*//*
            });*/
        }
    }

    private void onLoadMore() {
        if (clearFilter) {
            if (page_no != null) {
                callMessageApi();
            }
        } else {
            if (filterPageNo != null) {
                callMessageFilterApi(searchName, clearFilter, true);
            }
        }

    }

    private void message_list() {

        messageRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


        dataModelList = new ArrayList<>();

        dataModelList.add(
                new DataModel(
                        "Alex",
                        "Hey when are you going?",
                        "9.45AM",
                        R.drawable.profile_img1));

        dataModelList.add(
                new DataModel(
                        "Sandra",
                        "I would love to take this trip with...",
                        "9.45AM",
                        R.drawable.profile_img2));
        dataModelList.add(
                new DataModel(
                        "Lisa",
                        "Sure, lets do it.",
                        "9.45AM",
                        R.drawable.profile_img1));
        dataModelList.add(
                new DataModel(
                        "Mike",
                        "Yes, it was an amazing experience",
                        "9.45AM",
                        R.drawable.profile_img2));
        dataModelList.add(
                new DataModel(
                        "Jennifer",
                        "Loved it out there.",
                        "9.45AM",
                        R.drawable.profile_img1));
        dataModelList.add(
                new DataModel(
                        "Lisa",
                        "Sure, lets do it.",
                        "9.45AM",
                        R.drawable.profile_img2));
        dataModelList.add(
                new DataModel(
                        "Alex",
                        "Hey when are you going?",
                        "9.45AM",
                        R.drawable.profile_img1));
        dataModelList.add(
                new DataModel(

                        "Sandra",
                        "I would love to take this trip with...",
                        "9.45AM",
                        R.drawable.profile_img2));
        dataModelList.add(
                new DataModel(

                        "Lisa",
                        "Sure, lets do it.",
                        "9.45AM",
                        R.drawable.profile_img1));
        dataModelList.add(
                new DataModel(

                        "Mike",
                        "Yes, it was an amazing experience",
                        "9.45AM",
                        R.drawable.profile_img2));
        dataModelList.add(
                new DataModel(

                        "Jennifer",
                        "Loved it out there.",
                        "9.45AM",
                        R.drawable.profile_img1));

      /*  MessageAdapter adapter = new MessageAdapter(activity, dataModelList);
        messageRecycler.setAdapter(adapter);

        adapter.notifyDataSetChanged();
*/
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
        //   unbinder.unbind();
        unbinder.unbind();
    }

    @OnClick({R.id.add, R.id.search, R.id.btn_no_list_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                break;
                case R.id.btn_no_list_txt:
                   // MyToast.normalMessage("Working",activity);
                    FindConnectionFragment findConnectionFragment = new FindConnectionFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout, findConnectionFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                   // DashBoardActivity.fragmentTransferListener(new MessagesFragment());
                break;
            case R.id.search:
                //    fragmentTransfer.hideSearchView(false);
                Intent intent = new Intent(activity, MessageSearchActivity.class);
                startActivity(intent);
                activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
        }
    }

    private void callMessageFilterApi(String title, boolean clear, final boolean loadMore) {

        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            clearFilter = clear;
            //  ismyevent = isMyEvent;
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
            final String searchType = App_CHAT_TYPE;
            searchName = title;
          /*  final String cityId = "";
            final String userCode = "";
            postBy = postedBy;*/
            if (!clear) {
                Call<MessageListResponse> responseCall = ApiClient.getApiInterface().getChatList(Constants.getApiKey(activity), access_key, authorizations, pageno, searchType, searchName);
                responseCall.enqueue(new Callback<MessageListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<MessageListResponse> call, @NonNull Response<MessageListResponse> response) {

                        /*if (eventFilterLists.size() > 0) {
                            eventFilterLists.remove(eventFilterLists.size() - 1);
                            int scrollPosition = eventFilterLists.size();
                            eventAdapter.notifyItemRemoved(scrollPosition);
                        }*/

                        if (response.isSuccessful()) {
                            messageListResponse = response.body();
                            if (messageListResponse != null) {
                                if (messageListResponse.getStatus() == 1) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                        btnNoListTxt.setVisibility(View.GONE);
                                    }
                                    if (loadMore) {
                                        userFilterLists.addAll(messageListResponse.getData().getUser_list());
                                    } else {
                                        userFilterLists = messageListResponse.getData().getUser_list();
                                    }
                                    messageAdapter.addAll(userFilterLists);
                                    messageAdapter.setLoaded();
                                    filterPageNo = messageListResponse.getNextpage();
                                } else {

                                    if (!messageListResponse.getMessage().isEmpty() && messageListResponse.getMessage() != null) {
                                        userFilterLists.clear();
                                        messageAdapter.addAll(userFilterLists);
                                        messageAdapter.setLoaded();

                                        if (noListImg != null && noListTxt != null) {
                                            noListImg.setVisibility(View.VISIBLE);
                                            noListTxt.setVisibility(View.VISIBLE);
                                            btnNoListTxt.setVisibility(View.VISIBLE);
                                        }

                                        Glide.with(activity)
                                                .load(Constants.getLoadGlide(activity, messageListResponse.getStatus_img()))
                                                .apply(AppUtils.getRequestOption())
                                                .into(noListImg);

                                        noListTxt.setText(messageListResponse.getMessage());
                                        //MyToast.errorMessage(eventListResponse.getMessage(), activity);
                                    } else {
                                        if (noListImg != null && noListTxt != null) {
                                            noListImg.setVisibility(View.GONE);
                                            noListTxt.setVisibility(View.GONE);
                                            btnNoListTxt.setVisibility(View.GONE);
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
                    public void onFailure(@NonNull Call<MessageListResponse> call, @NonNull Throwable t) {
                        callMessageFilterApi(searchName, clearFilter, loadMore);
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
                messageAdapter.addAll(userLists);
                messageAdapter.setLoaded();
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
