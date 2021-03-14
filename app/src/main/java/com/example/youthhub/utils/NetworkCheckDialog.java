package com.example.youthhub.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.youthhub.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifImageView;

public class NetworkCheckDialog extends Dialog {

    Activity activity;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.network_txt)
    TextView networkTxt;
    @BindView(R.id.retry_btn)
    Button retryBtn;
    @BindView(R.id.network_loader)
    GifImageView networkLoader;

    NetworkCheckDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(false);
        this.setCancelable(false);
        setContentView(R.layout.network_check_dialog);
        ButterKnife.bind(this);
        callTypeFace();
    }

    private void callTypeFace() {
        title.setTypeface(FontTypeFace.fontBold(activity));
    }

    @OnClick(R.id.retry_btn)
    public void onViewClicked() {
        retryBtn.setVisibility(View.INVISIBLE);
        networkLoader.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (NetWorkUtil.isConnectingToInternet(activity)) {
                    dismiss();
                    networkLoader.setVisibility(View.GONE);
                    retryBtn.setVisibility(View.VISIBLE);
                } else {
                    networkLoader.setVisibility(View.GONE);
                    retryBtn.setVisibility(View.VISIBLE);
                }
            }
        }, 1000);

    }

    public interface OnCallApiListener{
        void callApi();
    }

}