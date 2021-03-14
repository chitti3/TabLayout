package com.example.youthhub.dashBoard.eventFragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.youthhub.R;
import com.example.youthhub.resModel.event.gallery.Gallery;
import com.example.youthhub.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventGalleryViewActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    int position;
    List<Gallery> galleries = new ArrayList<>();
    Map<String,String> imagePaths = new HashMap<>();

    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_gallery_view);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            position = bundle.getInt("Position");
            galleries = bundle.getParcelableArrayList(Constants.GalleryDatas);
            imagePaths = (Map<String, String>) bundle.getSerializable("ImagePath");
            imageAdapter = new ImageAdapter(this,galleries,imagePaths);
            viewPager.setAdapter(imageAdapter);
            viewPager.setCurrentItem(position);
        }

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
        overridePendingTransition(R.anim.stay,R.anim.activity_slide_down);
    }
}
