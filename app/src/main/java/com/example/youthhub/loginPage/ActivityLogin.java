package com.example.youthhub.loginPage;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;
import com.example.youthhub.signUpPage.SignUpFragmentTransfer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLogin extends AppCompatActivity implements LoginFragmentTransfer, SignUpFragmentTransfer {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_txt)
    TextView backTxt;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,new FragmentLogin());
        fragmentTransaction.commit();
    }

    @OnClick(R.id.back_constrain)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public void fragmentTransferListener(Fragment fragment,Bundle bundle) {
        if(bundle!=null) {
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition( R.anim.stay, R.anim.activity_slide_down );
    }

    @Override
    public void fragmentTransferListener(Fragment fragment, int loadNumber,Bundle bundle) {

    }
}
