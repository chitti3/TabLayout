package com.example.youthhub.dashBoard.exploreFragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.explore.topics.ExploreTopicDetail;
import com.example.youthhub.resModel.explore.topics.ExploreTopicsView;
import com.example.youthhub.resModel.explore.topics.TopicContent;
import com.example.youthhub.resModel.explore.topics.TopicInfo;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExploreTopicsActivity extends AppCompatActivity {


    @BindView(R.id.topic_image)
    ImageView topicImage;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.topic_view1)
    View topicView1;
    @BindView(R.id.topic_title)
    TextView topicTitle;
    @BindView(R.id.topic_sub_title)
    TextView topicSubTitle;
    @BindView(R.id.topic_viewers)
    TextView topicViewers;
    @BindView(R.id.subTitle_views_constrain)
    ConstraintLayout subTitleViewsConstrain;
    @BindView(R.id.topic_date)
    TextView topicDate;
    @BindView(R.id.topic_subject)
    TextView topicSubject;
    @BindView(R.id.date_subject_constrain)
    ConstraintLayout dateSubjectConstrain;
    @BindView(R.id.topic_view2)
    View topicView2;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.discussion)
    TextView discussion;
    @BindView(R.id.topic_view3)
    View topicView3;
    @BindView(R.id.about_view)
    View aboutView;
    @BindView(R.id.discussion_view)
    View discussionView;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.topic_details_cardview)
    CardView topicDetailsCardview;

    ExploreTopicsView exploreTopicsView = null;

    ExploreTopicDetail exploreTopicDetail = null;
    TopicInfo topicInfo = null;
    List<TopicContent> topicContent = null;
    String exploreCode = null;
    String topicId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_topics);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ButterKnife.bind(this);
        CallTypeFace();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            exploreTopicsView = bundle.getParcelable(Constants.ExploreTopicsView);
            if (exploreTopicsView != null) {
                update_ui(exploreTopicsView);
            }
        }
    }

    private void CallTypeFace() {

        topicTitle.setTypeface(FontTypeFace.fontBold(this));
        topicSubTitle.setTypeface(FontTypeFace.fontSemiBold(this));
        topicViewers.setTypeface(FontTypeFace.fontSemiBold(this));
        about.setTypeface(FontTypeFace.fontBold(this));
        discussion.setTypeface(FontTypeFace.fontRegular(this));
    }

    private void update_ui(ExploreTopicsView exploreTopicsView) {

        if (exploreTopicsView.getExploreTopicsData().getExploreTopicDetail() != null) {
            exploreTopicDetail = exploreTopicsView.getExploreTopicsData().getExploreTopicDetail();
            exploreCode = exploreTopicDetail.getXmCode();
        }

        if (exploreTopicsView.getExploreTopicsData().getIsTopicInfo() != null) {
            topicInfo = exploreTopicsView.getExploreTopicsData().getTopicInfo();
            topicId = topicInfo.getXtTopicId();
        }

        if (exploreTopicsView.getExploreTopicsData().getTopicContent() != null) {
            topicContent = exploreTopicsView.getExploreTopicsData().getTopicContent();
        }

        if (topicInfo != null) {
            topicTitle.setText(topicInfo.getXtTitle());
        }


        if (exploreTopicDetail != null) {
            topicSubTitle.setText(exploreTopicDetail.getUmName());
            String views = exploreTopicDetail.getXmTotalView() + " Views";
            topicViewers.setText(views);
            topicDate.setText(exploreTopicDetail.getXmPostDate());
            topicSubject.setText(exploreTopicDetail.getXmSubject());

            switch (exploreTopicDetail.getXcType()) {
                case "4":
                    Glide.with(this)
                            .load(exploreTopicDetail.getCoverfile())
                            .apply(AppUtils.getRequestOptionWithoutOverride())
                            .into(topicImage);
                    break;
                default:
                    Glide.with(this)
                            .load(Constants.getLoadGlide(this,exploreTopicDetail.getCoverpath() + exploreTopicDetail.getCoverfile()))
                            .apply(AppUtils.getRequestOptionWithoutOverride())
                            .into(topicImage);
                    break;
            }

        }

        if (topicContent != null) {
            loadFragment(ExploreTopicAboutFragment.newInstance(topicContent,exploreTopicDetail.getXmDescription()));
        }

    }

    void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    @OnClick({R.id.back, R.id.back_constrain, R.id.about, R.id.discussion})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
            case R.id.back_constrain:
                onBackPressed();
                break;
            case R.id.about:
                aboutView.setVisibility(View.VISIBLE);
                discussionView.setVisibility(View.GONE);
                about.setTypeface(FontTypeFace.fontBold(this));
                discussion.setTypeface(FontTypeFace.fontRegular(this));
                if (topicContent != null) {
                    loadFragment(ExploreTopicAboutFragment.newInstance(topicContent, exploreTopicDetail.getXmDescription()));
                }
                break;
            case R.id.discussion:
                aboutView.setVisibility(View.GONE);
                discussionView.setVisibility(View.VISIBLE);
                discussion.setTypeface(FontTypeFace.fontBold(this));
                about.setTypeface(FontTypeFace.fontRegular(this));
                if(exploreCode!=null && topicId!=null) {
                    loadFragment(ExploreTopicDiscussionFragment.newInstance(exploreCode, topicId));
                }
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
