package com.example.youthhub.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import com.example.youthhub.R;

import butterknife.ButterKnife;

public class CustomProgress extends Dialog{

    Activity activity;

    CustomProgress(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loader);
        ButterKnife.bind(this);
    }
}