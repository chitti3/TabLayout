package com.example.youthhub.dashBoard.eventFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.event.eventView.Datum;
import com.example.youthhub.resModel.event.eventView.ParticipantListResponse;
import com.example.youthhub.retrofit.ApiClient;
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

public class ParticipantListActivity extends AppCompatActivity {

    String event_code;
    String access_key;
    String authorizations;
    Integer page_no = null;
    ParticipantListResponse participantListResponse;
    List<Datum> datums = new ArrayList<>();

    ParticipantListAdapter participantListAdapter;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.participant_count)
    TextView participantCount;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant_list);
        ButterKnife.bind(this);
        callTypeFace();
        access_key = Preference.getInstance(this).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(this).getStr(Constants.Token);
        if (getIntent().getExtras() != null) {
            event_code = getIntent().getStringExtra("EventCode");
            call_participant_list_api(event_code);
        }
    }

    private void callTypeFace() {
        participantCount.setTypeface(FontTypeFace.fontBold(this));
    }

    private void call_participant_list_api(String eventCode) {
        if(NetWorkUtil.isNetworkConnected(this)){
            Loader.showLoad(this,true);
            String pageNo;
            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }
            Call<ParticipantListResponse> responseCall = ApiClient.getApiInterface().getParticipantList(Constants.getApiKey(ParticipantListActivity.this),access_key, authorizations, eventCode, pageNo);
            responseCall.enqueue(new Callback<ParticipantListResponse>() {
                @Override
                public void onResponse(@NonNull Call<ParticipantListResponse> call, @NonNull Response<ParticipantListResponse> response) {
                    if (response.isSuccessful()) {
                        participantListResponse = response.body();
                        if (participantListResponse != null) {
                            if (participantListResponse.getStatus() == 1) {
                                datums.addAll(participantListResponse.getParticipantData().getParticipants().getData());
                                participantCount.setText(datums.size()+" Participants");
                                if (page_no == null) {
                                    call_adapter(participantListResponse, datums,participantListResponse.getParticipantData().getUserMediumPath());
                                } else {
                                    participantListAdapter.addAll(datums);
                                    participantListAdapter.setLoaded();
                                }
                                page_no = participantListResponse.getNextpage();
                            } else {
                                page_no = null;
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ParticipantList", response.toString());
                    }
                    Loader.showLoad(ParticipantListActivity.this,false);
                }

                @Override
                public void onFailure(@NonNull Call<ParticipantListResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " ParticipantList", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg),ParticipantListActivity.this);
                    Loader.showLoad(ParticipantListActivity.this,false);
                }
            });
        }
    }

    private void call_adapter(ParticipantListResponse participantListResponse, List<Datum> datums, String userMediumPath) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        participantListAdapter = new ParticipantListAdapter(recyclerView, datums, this,userMediumPath);
        recyclerView.setAdapter(participantListAdapter);
        participantListAdapter.setOnLoadMoreListener(this::onLoadMore);
        participantListAdapter.setPassDataListener(new ParticipantListAdapter.PassDataListener() {
            @Override
            public void passData() {

            }
        });
    }

    private void onLoadMore() {
        if (page_no != null) {
            datums.add(null);
            participantListAdapter.notifyItemInserted(datums.size() - 1);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    datums.remove(datums.size() - 1);
                    int scrollPosition = datums.size();
                    participantListAdapter.notifyItemRemoved(scrollPosition);
                    call_participant_list_api(event_code);
                }
            }, 2000);
        }

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }
}
