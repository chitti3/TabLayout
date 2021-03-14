package com.example.youthhub.FirstOpenPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.loginPage.ActivityLogin;
import com.example.youthhub.utils.SessionManager;
import com.example.youthhub.utils.SwipeGesture;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityOpenAppScreen extends AppCompatActivity implements PagerInterface{

    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.skip)
    TextView skip;

    int fragmentSwipe;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_app_screen);
        ButterKnife.bind(this);

        sessionManager = new SessionManager(this);
        //sessionManager.checkLogin();

        fragmentSwipe = 1;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new FragmentSignInUp());
        fragmentTransaction.commit();

        frameLayout.setOnTouchListener(new SwipeGesture(this) {

            public void onSwipeTop() {
                //Toast.makeText(ActivityOpenAppScreen.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {
                switch (fragmentSwipe) {
                    case 2:
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new FragmentSignInUp());
                        fragmentTransaction.commit();
                        fragmentSwipe = 1;
                        view1.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape1));
                        view2.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        view3.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        skip.setVisibility(View.GONE);
                        break;
                    case 3:
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame_layout, new FragmentDiscover());
                        fragmentTransaction1.commit();
                        fragmentSwipe = 2;
                        view1.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        view2.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape1));
                        view3.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        skip.setVisibility(View.VISIBLE);
                        break;
                }
                //Toast.makeText(ActivityOpenAppScreen.this, "right", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                switch (fragmentSwipe) {
                    case 1:
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, new FragmentDiscover());
                        fragmentTransaction.commit();
                        fragmentSwipe = 2;
                        view1.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        view2.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape1));
                        view3.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        skip.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame_layout, new FragmentInvitation());
                        fragmentTransaction1.commit();
                        fragmentSwipe = 3;
                        view1.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        view2.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
                        view3.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape1));
                        skip.setVisibility(View.VISIBLE);
                        break;
                }
                //Toast.makeText(ActivityOpenAppScreen.this, "left", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                //Toast.makeText(ActivityOpenAppScreen.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @OnClick(R.id.skip)
    public void onViewClicked() {
        Intent logInIntent = new Intent(this, ActivityLogin.class);
        startActivity(logInIntent);
        overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
    }

    @Override
    public void setOnPageChangeListener(int pageNo) {
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.replace(R.id.frame_layout, new FragmentInvitation());
        fragmentTransaction1.commit();
        fragmentSwipe = pageNo;
        view1.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
        view2.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape));
        view3.setBackground(ContextCompat.getDrawable(ActivityOpenAppScreen.this, R.drawable.view_circle_shape1));
        skip.setVisibility(View.VISIBLE);
    }
}
