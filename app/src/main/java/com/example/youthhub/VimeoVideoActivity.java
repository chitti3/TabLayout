package com.example.youthhub;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VimeoVideoActivity extends AppCompatActivity {


    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.title)
    TextView title;

    String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view2);
        ButterKnife.bind(this);
        callTypeFace();

        if(getIntent().getExtras()!=null){
            videoId = getIntent().getStringExtra(Constants.VimeoVideoId);
            String vimeoVideo = "<html><body><iframe width=\"400\" height=\"280\" src=\"https://player.vimeo.com/video/" + videoId + "?player_id=player\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

            webview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {

                    webView.loadUrl(request.getUrl().toString());
                    return true;
                }
            });
            WebSettings webSettings = webview.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webview.loadData(vimeoVideo, "text/html", "utf-8");
        }else {
            MyToast.errorMessage(getString(R.string.error_msg),this);
            Handler handler = new Handler();
            handler.postDelayed(this::finish,1000);
        }

    }

    private void callTypeFace() {
        title.setTypeface(FontTypeFace.fontBold(this));
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
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

}