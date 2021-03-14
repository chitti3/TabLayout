package com.example.youthhub.signUpPage;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youthhub.R;
import com.example.youthhub.loginPage.LoginFragmentTransfer;
import com.example.youthhub.utils.FontTypeFace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitySignUp extends AppCompatActivity implements SignUpFragmentTransfer, LoginFragmentTransfer {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_txt)
    TextView backTxt;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.steps_txt)
    TextView stepsTxt;
    @BindView(R.id.loader1)
    View loader1;
    @BindView(R.id.loader2)
    View loader2;
    @BindView(R.id.loader3)
    View loader3;
    @BindView(R.id.loader_constrain)
    ConstraintLayout loaderConstrain;
    @BindView(R.id.create_ac_txt)
    TextView createAcTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        setTypeFace();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new FragmentCreateAccount1());
        fragmentTransaction.commit();
    }

    private void setTypeFace() {
        createAcTxt.setTypeface(FontTypeFace.fontSemiBold(this));
    }

    @OnClick(R.id.back_constrain)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Clear the Activity's bundle of the subsidiary fragments' bundles.
        outState.clear();
    }

    @Override
    public void fragmentTransferListener(Fragment fragment, int loadNumber,Bundle bundle) {
        if(bundle!=null){
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
            switch (loadNumber) {
                case 0:
                    loaderConstrain.setVisibility(View.GONE);
                    break;
                case 1:
                    loaderConstrain.setVisibility(View.VISIBLE);
                    stepsTxt.setText("step 2 of 3 Personal Profile setup");
                    loader1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader2.setBackgroundColor(ContextCompat.getColor(this, R.color.light_dark));
                    loader3.setBackgroundColor(ContextCompat.getColor(this, R.color.light_dark));
                    break;
                case 2:
                    loaderConstrain.setVisibility(View.VISIBLE);
                    stepsTxt.setText("step 3 of 3 Work Profile");
                    loader1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader3.setBackgroundColor(ContextCompat.getColor(this, R.color.light_dark));
                    break;
                case 3:
                    loaderConstrain.setVisibility(View.VISIBLE);
                    loader1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    break;
            }
        }else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
            switch (loadNumber) {
                case 0:
                    loaderConstrain.setVisibility(View.GONE);
                    break;
                case 1:
                    loaderConstrain.setVisibility(View.VISIBLE);
                    stepsTxt.setText("step 2 of 3 Personal Profile setup");
                    loader1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader2.setBackgroundColor(ContextCompat.getColor(this, R.color.light_dark));
                    loader3.setBackgroundColor(ContextCompat.getColor(this, R.color.light_dark));
                    break;
                case 2:
                    loaderConstrain.setVisibility(View.VISIBLE);
                    stepsTxt.setText("step 3 of 3 Work Profile");
                    loader1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader3.setBackgroundColor(ContextCompat.getColor(this, R.color.light_dark));
                    break;
                case 3:
                    loaderConstrain.setVisibility(View.VISIBLE);
                    loader1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    loader3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @Override
    public void fragmentTransferListener(Fragment fragment, Bundle bundle) {

    }
}