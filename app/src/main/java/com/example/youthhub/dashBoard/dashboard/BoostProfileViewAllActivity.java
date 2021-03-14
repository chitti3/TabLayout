package com.example.youthhub.dashBoard.dashboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BoostProfileViewAllActivity extends AppCompatActivity {


    BoostProfileViewAllAdapter boostProfileViewAllAdapter;
    @BindView(R.id.profiler_name)
    TextView profilerName;
    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.sample_img)
    ImageView sampleImg;
    @BindView(R.id.boost_profile_text)
    TextView boostProfileText;
    @BindView(R.id.boost_profile_view1)
    View boostProfileView1;
    @BindView(R.id.boost_profile_recycler)
    RecyclerView boostProfileRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boost_profile_view_all);
        ButterKnife.bind(this);
        callTypeFace();
        call_adapter();
    }

    private void callTypeFace() {
        profilerName.setTypeface(FontTypeFace.fontSemiBold(this));
        boostProfileText.setTypeface(FontTypeFace.fontSemiBold(this));
    }

    private void call_adapter() {
        boostProfileViewAllAdapter = new BoostProfileViewAllAdapter(this);
        boostProfileRecycler.setAdapter(boostProfileViewAllAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        boostProfileRecycler.setLayoutManager(linearLayoutManager);
        boostProfileViewAllAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fileList();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }
}
