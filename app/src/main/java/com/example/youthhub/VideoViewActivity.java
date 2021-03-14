package com.example.youthhub;

import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoViewActivity extends AppCompatActivity {

    @BindView(R.id.video)
    VideoView videoView;

    String videoPath;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        ButterKnife.bind(this);
        callTypeFace();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            videoPath = bundle.getString(Constants.VideoPath);
            String path = videoPath;
            if (path != null) {
                setupVideoView(path);
            } else {
                MyToast.errorMessage("Something went wrong, Please try after sometime", this);
            }
        }

    }

    private void setupVideoView(String path) {

        videoView.setHandleAudioFocus(false);

        videoView.showControls();

        //For now we just picked an arbitrary item to play
        videoView.setVideoURI(Uri.parse(path));

        // Make sure to use the correct VideoView import
        videoView.setOnPreparedListener(() -> videoView.start());

        videoView.setOnErrorListener(e -> {
            MyToast.errorMessage("Oops An Error Occur While Playing Video...!!!", VideoViewActivity.this); // display a toast when an error is occured while playing an video
            return false;
        });
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
