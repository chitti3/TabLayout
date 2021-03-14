package com.example.youthhub.dashBoard.eventFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.youthhub.R;
import com.example.youthhub.resModel.event.eventView.EventView;
import com.example.youthhub.resModel.event.eventView.EventViewData;
import com.example.youthhub.resModel.event.eventView.EventViewResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventActivity extends AppCompatActivity {

    EventViewResponse eventViewResponse;
    EventViewData eventViewData;
    EventView eventView;

    String access_key;
    String authorizations;
    @BindView(R.id.event_image)
    ImageView eventImage;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.event_view1)
    View eventView1;
    @BindView(R.id.event_title)
    TextView eventTitle;
    @BindView(R.id.event_share)
    ImageView eventShare;
    @BindView(R.id.event_date)
    TextView eventDate;
    @BindView(R.id.event_region)
    TextView eventRegion;
    @BindView(R.id.event_time)
    TextView eventTime;
    @BindView(R.id.event_city)
    TextView eventCity;
    @BindView(R.id.event_view2)
    View eventView2;
    @BindView(R.id.event_going_count)
    TextView eventGoingCount;
    @BindView(R.id.event_invited_count)
    TextView eventInvitedCount;
    @BindView(R.id.event_going_txt)
    TextView eventGoingTxt;
    @BindView(R.id.event_invited_txt)
    TextView eventInvitedTxt;
    @BindView(R.id.count_btn)
    Button countBtn;
    @BindView(R.id.event_view3)
    View eventView3;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.event_details_cardview)
    CardView eventDetailsCardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsable_activity);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        callTypeFace();

        access_key = Preference.getInstance(this).getStr(Constants.AccessKey);
        authorizations = "Youthhub " + Preference.getInstance(this).getStr(Constants.Token);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            eventViewResponse = bundle.getParcelable(Constants.EventViewRes);
            if (eventViewResponse != null) {
                eventViewData = eventViewResponse.getEventViewData();
                eventView = eventViewData.getEventView();
            }
        }

        eventTitle.setText(eventView.getEventTitle());
        eventDate.setText(eventView.getEventStartDate());
        eventRegion.setText(eventView.getEventRegionName());
        String time = eventView.getEventStarttime() + " - " + eventView.getEventEndtime();
        eventTime.setText(time);
        eventCity.setText(eventView.getEventCityName());
        if (eventView.getTotalYouthhubParticipants().equals("0")){
            eventGoingCount.setVisibility(View.INVISIBLE);
        }else {
            eventGoingCount.setVisibility(View.VISIBLE);
            eventGoingCount.setText(eventView.getTotalYouthhubParticipants());
        }
       // countBtn.setText(eventView.getParticipantCurrentStatusName());

        if(eventView.getEventStatusName().equals("Expired"))
        {
            countBtn.setVisibility(View.INVISIBLE);
        }else
        {
            countBtn.setVisibility(View.VISIBLE);
            countBtn.setText(eventView.getParticipantCurrentStatusName());
        }

        Glide.with(this)
                .load(Constants.getLoadGlide(this, eventViewData.getEventLogoPath() + eventView.getEventLogo()))
                .apply(AppUtils.getRequestOptionWithoutOverride())
                .into(eventImage);

        if (bundle != null) {
            viewPager.setAdapter(new EventPagerAdapter(getSupportFragmentManager(), bundle));
        }
        tabLayout.setupWithViewPager(viewPager);
        setCustomFont(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                /*if (tab.getPosition() == 3) {
                    bottomCard.setVisibility(View.VISIBLE);
                } else {
                    bottomCard.setVisibility(View.GONE);
                }*/

                /*TextView tv = (TextView) LayoutInflater.from(ProfileActivity.this).inflate(R.layout.custom_tab,null);
                tv.setTypeface(FontTypeFace.fontBold(ProfileActivity.this));
                tabs.getTabAt(tab.getPosition()).setCustomView(tv);*/
                setCustomFont(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void callTypeFace() {
        eventTitle.setTypeface(FontTypeFace.fontBold(this));
        eventDate.setTypeface(FontTypeFace.fontSemiBold(this));
        eventRegion.setTypeface(FontTypeFace.fontSemiBold(this));
        eventTime.setTypeface(FontTypeFace.fontMedium(this));
        eventCity.setTypeface(FontTypeFace.fontMedium(this));
        eventGoingCount.setTypeface(FontTypeFace.fontBold(this));
        eventInvitedCount.setTypeface(FontTypeFace.fontBold(this));
        countBtn.setTypeface(FontTypeFace.fontBold(this));
    }

    public void setCustomFont(int tabPosition) {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    //Put your font in assests folder
                    //assign name of the font here (Must be case sensitive)
                    if (tabPosition == j) {
                        ((TextView) tabViewChild).setTypeface(FontTypeFace.fontBold(EventActivity.this));
                    } else {
                        ((TextView) tabViewChild).setTypeface(FontTypeFace.fontRegular(EventActivity.this));
                    }

                }
            }
        }
    }

    @OnClick({R.id.back, R.id.back_constrain, R.id.event_share, R.id.count_btn, R.id.event_going_count, R.id.event_going_txt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
            case R.id.back_constrain:
                onBackPressed();
                break;
            case R.id.event_share:
                break;
            case R.id.count_btn:
                call_count_status_api(eventView.getEventCode(), eventView.getParticipantCurrentStatus());
                break;
            case R.id.event_going_count:
            case R.id.event_going_txt:
                if(Integer.valueOf(eventGoingCount.getText().toString())<=0) {
                    MyToast.errorMessage("Currently No Participant are available",this);
                }else {
                    Intent intent = new Intent(this, ParticipantListActivity.class);
                    intent.putExtra("EventCode", eventView.getEventCode());
                    startActivity(intent);
                    overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                }
                break;
        }
    }

    private void call_count_status_api(String eventCode, Integer participantCurrentStatus) {
        if (NetWorkUtil.isNetworkConnected(this)) {
            Loader.showLoad(this, true);
            int status;
            if (participantCurrentStatus == 0) {
                status = 1;
            } else {
                status = 0;
            }
            Call<EventViewResponse> responseCall = ApiClient.getApiInterface().getCountMeApplyStatusinView(Constants.getApiKey(EventActivity.this),access_key, authorizations, eventCode, String.valueOf(status));
            responseCall.enqueue(new Callback<EventViewResponse>() {
                @Override
                public void onResponse(@NonNull Call<EventViewResponse> call, @NonNull Response<EventViewResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage(response.body().getMessage(), EventActivity.this);
                                if (status == 1) {
                                    eventView.setParticipantCurrentStatus(1);
                                    eventView.setParticipantCurrentStatusName("Count Me Out");
                                    eventView.setTotalYouthhubParticipants(String.valueOf(Integer.valueOf(eventView.getTotalYouthhubParticipants()) + 1));
                                } else {
                                    eventView.setParticipantCurrentStatus(0);
                                    eventView.setParticipantCurrentStatusName("Count Me In");
                                    eventView.setTotalYouthhubParticipants(String.valueOf(Integer.valueOf(eventView.getTotalYouthhubParticipants()) - 1));
                                }
                                updateView(eventView);
                            } else {
                                MyToast.normalMessage(response.body().getMessage(), EventActivity.this);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " CountMeStatus", response.toString());
                    }
                    Loader.showLoad(EventActivity.this, false);
                }

                @Override
                public void onFailure(@NonNull Call<EventViewResponse> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " CountMeStatus", t.toString());
                    MyToast.errorMessage(getResources().getString(R.string.error_msg), EventActivity.this);
                    Loader.showLoad(EventActivity.this, false);
                }
            });
        }
    }

    private void updateView(EventView eventView) {
        countBtn.setText(eventView.getParticipantCurrentStatusName());
        if (eventView.getTotalYouthhubParticipants().equals("0")){
            eventGoingCount.setVisibility(View.INVISIBLE);
        }else {
            eventGoingCount.setVisibility(View.VISIBLE);
            eventGoingCount.setText(eventView.getTotalYouthhubParticipants());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

}
