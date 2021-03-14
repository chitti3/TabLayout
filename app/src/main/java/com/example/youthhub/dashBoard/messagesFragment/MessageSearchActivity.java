package com.example.youthhub.dashBoard.messagesFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.DataModel;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.FragmentTransfer;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
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

import static com.example.youthhub.utils.Constants.App_CHAT_TYPE;

public class MessageSearchActivity extends AppCompatActivity {

    private static final String TAG = MessageSearchActivity.class.getSimpleName();
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.search_txt)
    TextView searchTxt;
    @BindView(R.id.search)
    SearchView search;
    @BindView(R.id.search_card)
    CardView searchCard;
    @BindView(R.id.message_txt)
    TextView messageTxt;
    @BindView(R.id.message_recycler)
    RecyclerView messageRecycler;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;

    List<DataModel> dataModelList;

    List<MessageListResponse.UserList> userLists = new ArrayList<>();
    List<MessageListResponse.UserList> userFilterLists = new ArrayList<>();
    Integer page_no = null;
    Integer filterPageNo = null;
    boolean clearFilter = true;

    String access_key;
    String searchName = "";


    private String authorizations;
    private MessageListResponse messageListResponse;
    MessageAdapter messageAdapter;
    Activity activity;
    FragmentTransfer fragmentTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_search);
        ButterKnife.bind(this);
        activity = this;

        access_key = Preference.getInstance(activity).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);

        callTypeFace();
        callMessageApi();
        refresh.setOnRefreshListener(() -> {
            page_no = null;
            userLists.clear();
            //eventFilterLists.clear();
            messageAdapter.notifyDataSetChanged();
            messageAdapter.setLoaded();
            callMessageApi();
            refresh.setRefreshing(false);
        });

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                callMessageFilterApi(s, false, true);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                messageAdapter.getFilter().filter(s);

                return false;
            }
        });

     /*   search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "afterTextChanged: ");

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0)
                    callMessageFilterApi(s.toString(), false, true);

            }
        });

        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // do something, e.g. set your TextView here via .setText()
                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });*/
        //   message_list();
    }


    private void callTypeFace() {
        messageTxt.setTypeface(FontTypeFace.fontBold(this));
        searchTxt.setTypeface(FontTypeFace.fontBold(this));
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


            Call<MessageListResponse> responseCall = ApiClient.getApiInterface().getChatList(Constants.getApiKey(activity), access_key, authorizations, pageno, searchType, searchName);
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

                                        //      userLists.clear();
                                        //    messageAdapter.addAll(userLists);
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
            Log.d(TAG, "callMessageFilterApi: " + searchName);

            if (!clear) {
                Call<MessageListResponse> responseCall = ApiClient.getApiInterface().getChatList(Constants.getApiKey(activity), access_key, authorizations, pageno, searchType, searchName);
                responseCall.enqueue(new Callback<MessageListResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<MessageListResponse> call, @NonNull Response<MessageListResponse> response) {
                        Log.d(TAG, "callMessageFilterApi: onResponse" + searchName);
                        /*if (eventFilterLists.size() > 0) {
                            eventFilterLists.remove(eventFilterLists.size() - 1);
                            int scrollPosition = eventFilterLists.size();
                            eventAdapter.notifyItemRemoved(scrollPosition);
                        }*/
                        userFilterLists.clear();
                        if (response.isSuccessful()) {
                            messageListResponse = response.body();
                            if (messageListResponse != null) {
                                if (messageListResponse.getStatus() == 1) {
                                    if (noListImg != null && noListTxt != null) {
                                        noListImg.setVisibility(View.GONE);
                                        noListTxt.setVisibility(View.GONE);
                                    }
                                    if (loadMore) {
                                        userFilterLists.addAll(messageListResponse.getData().getUser_list());
                                    } else {
                                        userFilterLists = messageListResponse.getData().getUser_list();
                                    }
                                    messageAdapter.addAll(userFilterLists);
                                    messageAdapter.setLoaded();
                                    filterPageNo = messageListResponse.getNextpage();
                                    messageAdapter.notifyDataSetChanged();
                                } else {

                                    if (!messageListResponse.getMessage().isEmpty() && messageListResponse.getMessage() != null) {
                                       /* userFilterLists.clear();
                                        messageAdapter.addAll(userFilterLists);
                                        messageAdapter.setLoaded();*/

                                        if (noListImg != null && noListTxt != null) {
                                            noListImg.setVisibility(View.VISIBLE);
                                            noListTxt.setVisibility(View.VISIBLE);
                                            messageRecycler.setVisibility(View.GONE);
                                            Glide.with(activity)
                                                    .load(Constants.getLoadGlide(activity, messageListResponse.getStatus_img()))
                                                    .apply(AppUtils.getRequestOption())
                                                    .into(noListImg);

                                            noListTxt.setText(messageListResponse.getMessage());
                                        }


                                        //MyToast.errorMessage(eventListResponse.getMessage(), activity);
                                    } else {
                                        if (noListImg != null && noListTxt != null) {
                                            noListImg.setVisibility(View.GONE);
                                            noListTxt.setVisibility(View.GONE);
                                            messageRecycler.setVisibility(View.VISIBLE);
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
                Log.d(TAG, "callMessageFilterApi: else" + searchName);
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


    private void onLoadMore() {
        if (clearFilter) {
            if (page_no != null) {
                callMessageApi();
            }
        } else {
            if (filterPageNo != null) {
                Log.d(TAG, "onLoadMore: ");
                callMessageFilterApi(searchName, clearFilter, true);
            }
        }

    }


    private void message_list() {

        messageRecycler.setLayoutManager(new LinearLayoutManager(this));

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

       /* MessageAdapter adapter = new MessageAdapter(this, dataModelList);
        messageRecycler.setAdapter(adapter);

        adapter.notifyDataSetChanged();*/

    }


    @OnClick({R.id.back, R.id.back_constrain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
            case R.id.back_constrain:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }
}
