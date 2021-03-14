package com.example.youthhub.dashBoard.exploreFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.explore.ExploreViewRes;
import com.example.youthhub.resModel.explore.Exploredetail;
import com.example.youthhub.resModel.explore.Relatedexplore;
import com.example.youthhub.resModel.explore.Topic;
import com.example.youthhub.resModel.explore.topics.ExploreTopicsView;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.MyToast;
import com.example.youthhub.utils.NetWorkUtil;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreViewActivity extends AppCompatActivity implements
        ExploreAboutAdapter.OnPassDataListener,
        ExploreTopicsAdapter.OnLoadMoreListener,
        ExploreTopicsAdapter.OnPassDataListener {

    private static final String TAG = "ExploreViewActivity";
    @BindView(R.id.explore_image)
    ImageView exploreImage;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.back_constrain)
    ConstraintLayout backConstrain;
    @BindView(R.id.explore_view1)
    View exploreView1;
    @BindView(R.id.explore_title)
    TextView exploreTitle;
    @BindView(R.id.explore_sub_title)
    TextView exploreSubTitle;
    @BindView(R.id.explore_viewers)
    TextView exploreViewers;
    @BindView(R.id.subTitle_views_constrain)
    ConstraintLayout subTitleViewsConstrain;
    @BindView(R.id.explore_date)
    TextView exploreDate;
    @BindView(R.id.explore_subject)
    TextView exploreSubject;
    @BindView(R.id.date_subject_constrain)
    LinearLayout dateSubjectConstrain;
    @BindView(R.id.explore_view2)
    View exploreView2;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.topic)
    TextView topic;
    @BindView(R.id.add_remove_explore)
    Button addRemoveExplore;
    @BindView(R.id.explore_view3)
    View exploreView3;
    @BindView(R.id.about_view)
    View aboutView;
    @BindView(R.id.topic_view)
    View topicView;
    @BindView(R.id.desc_txt)
    TextView descTxt;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.related_topics_txt)
    TextView relatedTopicsTxt;
    @BindView(R.id.about_recycler)
    RecyclerView aboutRecycler;
    @BindView(R.id.about_constrain)
    ConstraintLayout aboutConstrain;
    @BindView(R.id.nested_scroll)
    NestedScrollView nestedScroll;
    @BindView(R.id.no_list_img)
    ImageView noListImg;
    @BindView(R.id.no_list_txt)
    TextView noListTxt;
    @BindView(R.id.topic_recycler)
    RecyclerView topicRecycler;
    @BindView(R.id.topic_constrain)
    ConstraintLayout topicConstrain;
    @BindView(R.id.explore_details_cardview)
    CardView exploreDetailsCardview;

    ExploreAboutAdapter exploreAboutAdapter;
    ExploreTopicsAdapter exploreTopicsAdapter;

    ExploreViewRes exploreViewRes;
    Exploredetail exploredetail = null;
    List<Relatedexplore> relatedexplore = null;
    List<Topic> topics = null;
    Activity activity;
    Integer page_no = null;
    @BindView(R.id.title_txt)
    TextView titleTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_view);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        ButterKnife.bind(this);
        activity = this;
        callTypeFace();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            exploreViewRes = bundle.getParcelable(Constants.ExploreView);
            if (exploreViewRes != null) {
                page_no = exploreViewRes.getNextpage();
            }
        }
        call_adapter();
        if (exploreViewRes != null) {
            update_ui(exploreViewRes, "");
        }
    }

    private void call_adapter() {

        //About Recycler
        exploreAboutAdapter = new ExploreAboutAdapter(this);
        aboutRecycler.setAdapter(exploreAboutAdapter);
        exploreAboutAdapter.setPassDataListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        aboutRecycler.setLayoutManager(linearLayoutManager);

        //Topic Recycler
        exploreTopicsAdapter = new ExploreTopicsAdapter(this, topicRecycler);
        exploreTopicsAdapter.setOnPassDataListener(this);
        exploreTopicsAdapter.setOnLoadMoreListener(this);
        topicRecycler.setAdapter(exploreTopicsAdapter);
        topicRecycler.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void update_ui(ExploreViewRes exploreViewRes, String pageNo) {

        if (pageNo.isEmpty()) {
            exploredetail = exploreViewRes.getExploreViewData().getExploredetail();
            relatedexplore = exploreViewRes.getExploreViewData().getRelatedexplore();
            topics = exploreViewRes.getExploreViewData().getTopics();
        } else {
            topics.addAll(exploreViewRes.getExploreViewData().getTopics());
        }

        if (exploredetail != null) {

            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);

            switch (exploredetail.getXcType()) {
                case "4":
                    Glide.with(activity)
                            .load(exploredetail.getCoverfile())
                            .apply(options)
                            .into(exploreImage);
                    break;
                default:
                    Glide.with(activity)
                            .load(Constants.getLoadGlide(activity, exploredetail.getCoverpath() + exploredetail.getCoverfile()))
                            .apply(options)
                            .into(exploreImage);
                    break;
            }
            Log.d(TAG, "update_ui: exploreSubject" + exploredetail.getXmSubject());
            exploreTitle.setText(exploredetail.getXmTitle());
            exploreSubTitle.setText(exploredetail.getUmName());
            String views = exploredetail.getXmTotalView() + " Views";
            exploreViewers.setText(views);
            exploreDate.setText(exploredetail.getXmPostDate());
            exploreSubject.setText(exploredetail.getXmSubject());
            switch (exploredetail.getXuSave()) {
                case 0:
                    addRemoveExplore.setText(getString(R.string.add_explore));
                    break;
                case 1:
                    addRemoveExplore.setText(getString(R.string.remove_explore));
                    break;
            }


            desc.setText(exploredetail.getXmDescription());
            if (exploredetail.getXmTagName()!=null&&exploredetail.getXmTagName().length()>0) {
                titleTxt.setVisibility(View.VISIBLE);
                titleTxt.setText(exploredetail.getXmTagName());
            }else{
                titleTxt.setVisibility(View.GONE);
            }
        }
        //About list
        if (relatedexplore != null) {
            exploreAboutAdapter.addAll(relatedexplore);
        }

        //topic

        if (topics != null) {
            exploreTopicsAdapter.addAll(topics);
            exploreTopicsAdapter.setLoaded();
        }
    }

    private void callTypeFace() {
        exploreTitle.setTypeface(FontTypeFace.fontBold(this));
        exploreSubTitle.setTypeface(FontTypeFace.fontSemiBold(this));
        exploreViewers.setTypeface(FontTypeFace.fontSemiBold(this));
        about.setTypeface(FontTypeFace.fontBold(this));
        topic.setTypeface(FontTypeFace.fontRegular(this));
        addRemoveExplore.setTypeface(FontTypeFace.fontBold(this));
        descTxt.setTypeface(FontTypeFace.fontSemiBold(this));
        titleTxt.setTypeface(FontTypeFace.fontSemiBold(this));
        relatedTopicsTxt.setTypeface(FontTypeFace.fontSemiBold(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
    }

    @OnClick({R.id.back, R.id.explore_sub_title, R.id.about, R.id.topic, R.id.add_remove_explore})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.explore_sub_title:
                break;
            case R.id.about:
                aboutConstrain.setVisibility(View.VISIBLE);
                topicConstrain.setVisibility(View.GONE);
                aboutView.setVisibility(View.VISIBLE);
                topicView.setVisibility(View.GONE);
                about.setTypeface(FontTypeFace.fontBold(this));
                topic.setTypeface(FontTypeFace.fontRegular(this));
                break;
            case R.id.topic:
                aboutConstrain.setVisibility(View.GONE);
                topicConstrain.setVisibility(View.VISIBLE);
                aboutView.setVisibility(View.GONE);
                topicView.setVisibility(View.VISIBLE);
                topic.setTypeface(FontTypeFace.fontBold(this));
                about.setTypeface(FontTypeFace.fontRegular(this));
                break;
            case R.id.add_remove_explore:
                if (exploredetail != null) {
                    call_addExplore_api(exploredetail);
                }
                break;
        }
    }

    private void call_addExplore_api(final Exploredetail exploredetail) {

        String exploreCode = exploredetail.getXmCode();
        String sharedType = "2";
        String postBy = "";
        final String isAddToExplore;

        Integer xuSave = exploredetail.getXuSave();

        switch (xuSave) {
            case 0:
                isAddToExplore = "1";
                break;
            case 1:
                isAddToExplore = "0";
                break;
            default:
                isAddToExplore = "0";
                break;

        }
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonRes> call = ApiClient.getApiInterface().getAddMyExplore(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), exploreCode, sharedType, postBy, isAddToExplore);
            call.enqueue(new Callback<CommonRes>() {
                @Override
                public void onResponse(@NonNull Call<CommonRes> call, @NonNull Response<CommonRes> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            if (response.body().getStatus() == 1) {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                                update(isAddToExplore);

                            } else {
                                MyToast.errorMessage(response.body().getMessage(), activity);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " AddMyExplore", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonRes> call, @NonNull Throwable t) {
                    Log.d(Constants.failureResponse + " AddMyExplore", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void update(String isAddToExplore) {
        exploredetail.setXuSave(Integer.valueOf(isAddToExplore));
        switch (exploredetail.getXuSave()) {
            case 0:
                addRemoveExplore.setText(getString(R.string.add_explore));
                break;
            case 1:
                addRemoveExplore.setText(getString(R.string.remove_explore));
                break;
        }
    }


    private void call_explore_view_api(String exCode, final Integer pageNumber) {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);

            final String pageNo;

            if (pageNumber == null) {
                page_no = null;
            }

            if (page_no == null) {
                pageNo = "";
            } else {
                pageNo = String.valueOf(page_no);
            }

            Call<ExploreViewRes> call = ApiClient.getApiInterface().getExploreView(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), exCode, pageNo);
            call.enqueue(new Callback<ExploreViewRes>() {
                @Override
                public void onResponse(@NonNull Call<ExploreViewRes> call, @NonNull Response<ExploreViewRes> response) {
                    Loader.showLoad(activity, false);
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            exploreViewRes = response.body();
                            if (response.body().getStatus() == 1) {
                                page_no = exploreViewRes.getNextpage();
                                update_ui(exploreViewRes, pageNo);
                                if (pageNumber == null) {
                                    nestedScroll.scrollTo(0, 0);
                                }
                                Objects.requireNonNull(aboutRecycler.getLayoutManager()).scrollToPosition(0);
                            } else {
                                no_list(exploreViewRes);
                            }
                        }
                    } else {
                        Log.d(Constants.failureResponse + " ExploreView", response.toString());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<ExploreViewRes> call, @NonNull Throwable t) {
                    Loader.showLoad(activity, false);
                    Log.d(Constants.failureResponse + " ExploreView", t.toString());
                }
            });
        }
    }

    private void no_list(ExploreViewRes exploreViewRes) {
        if (!exploreViewRes.getMessage().isEmpty()) {
            noListImg.setVisibility(View.VISIBLE);
            noListTxt.setVisibility(View.VISIBLE);

            topics.clear();
            exploreTopicsAdapter.addAll(topics);
            exploreTopicsAdapter.setLoaded();

            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH);

            Glide.with(activity)
                    .load(Constants.getLoadGlide(activity, exploreViewRes.getStatus_img()))
                    .apply(options)
                    .into(noListImg);

            noListTxt.setText(exploreViewRes.getMessage());
            //MyToast.normalMessage(discussionListResponse.getMessage(), activity);
        } else {
            noListImg.setVisibility(View.GONE);
            noListTxt.setVisibility(View.GONE);
        }
        page_no = null;
    }

    @Override
    public void onPassData(Relatedexplore relatedexplore) {
        call_explore_view_api(relatedexplore.getXmCode(), null);
    }

    @Override
    public void onLoadMore() {
        if (page_no != null) {
            call_explore_view_api(exploredetail.getXmCode(), exploreViewRes.getNextpage());
        }
    }

    @Override
    public void onPassData(Topic topic) {
        call_topics_api(topic);
    }

    private void call_topics_api(Topic topic) {
        String exploreId = exploredetail.getXmCode();
        String topicId = topic.getXtTopicId();
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
        }
        Call<ExploreTopicsView> call = ApiClient.getApiInterface().getExploreTopics(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity), exploreId, topicId);
        call.enqueue(new Callback<ExploreTopicsView>() {
            @Override
            public void onResponse(@NonNull Call<ExploreTopicsView> call, @NonNull Response<ExploreTopicsView> response) {
                Loader.showLoad(activity, false);
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatus() == 1) {
                            Bundle bundle = new Bundle();
                            bundle.putParcelable(Constants.ExploreTopicsView, response.body());
                            Intent intent = new Intent(activity, ExploreTopicsActivity.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                        } else {
                            if (!response.body().getMessage().isEmpty()) {
                                MyToast.normalMessage(response.body().getMessage(), activity);
                            }
                        }
                    }
                } else {
                    Log.d(Constants.failureResponse + " ExploreTopics", response.toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ExploreTopicsView> call, @NonNull Throwable t) {
                Log.d(Constants.failureResponse + " ExploreTopics", t.toString());
                Loader.showLoad(activity, false);
            }
        });
    }

}

