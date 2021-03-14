package com.example.youthhub.utils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.title)
    TextView title;
    String web_view_url, topic;
    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        callTypeFace();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            web_view_url = bundle.getString("WebView");
            topic = bundle.getString("Topic");

            //webview.getSettings().setJavaScriptEnabled(true);
            //String url = "http://docs.google.com/gview?embedded=true&url="+web_view_url;
            webview.loadUrl("https://app1.youthhub.nz/v1/viewtc/WW91dGggSHViIFVzZXIgVGVybXMgLSBZb3V0aC5wZGY=");

            /*WebView webview = new WebView(this);
            setContentView(webview);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + web_view_url);*/
            title.setText(topic);
            //Toast.makeText(this, web_view_url + " " + topic, Toast.LENGTH_LONG).show();
        }

    }

    private void callTypeFace() {
        title.setTypeface(FontTypeFace.fontSemiBold(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @OnClick(R.id.back_constrain)
    public void onViewClicked() {
        onBackPressed();
    }

    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }
    }

}
