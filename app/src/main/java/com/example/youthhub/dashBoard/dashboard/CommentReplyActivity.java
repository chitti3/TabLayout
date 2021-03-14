package com.example.youthhub.dashBoard.dashboard;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.youthhub.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class CommentReplyActivity extends AppCompatActivity {

    @BindView(R.id.back)
    TextView back;
    @BindView(R.id.comment_view1)
    View commentView1;
    @BindView(R.id.top_constrain)
    ConstraintLayout topConstrain;
    @BindView(R.id.commenter_img)
    CircleImageView commenterImg;
    @BindView(R.id.comment_user_code)
    TextView commentUserCode;
    @BindView(R.id.comment_image_code_constrain)
    ConstraintLayout commentImageCodeConstrain;
    @BindView(R.id.commenter_name)
    TextView commenterName;
    @BindView(R.id.comment_time)
    TextView commentTime;
    @BindView(R.id.constrain1)
    ConstraintLayout constrain1;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.comment_view2)
    View commentView2;
    @BindView(R.id.camera)
    ImageView camera;
    @BindView(R.id.comment_view3)
    View commentView3;
    @BindView(R.id.comment_edittext)
    EditText commentEdittext;
    @BindView(R.id.comment_view4)
    View commentView4;
    @BindView(R.id.cmt_post_btn)
    ImageView cmtPostBtn;
    @BindView(R.id.bottom_constrain)
    ConstraintLayout bottomConstrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_reply);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        onBackPressed();
    }
}
