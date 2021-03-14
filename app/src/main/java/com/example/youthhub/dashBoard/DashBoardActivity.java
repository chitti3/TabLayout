package com.example.youthhub.dashBoard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.youthhub.R;
import com.example.youthhub.dashBoard.createPost.CreatePostActivity;
import com.example.youthhub.dashBoard.dashboard.DashBoardFragment;
import com.example.youthhub.dashBoard.eventFragment.EventsFragment;
import com.example.youthhub.dashBoard.exploreFragment.ExploreFragment;
import com.example.youthhub.dashBoard.findConnectionFragment.FindConnectionFragment;
import com.example.youthhub.dashBoard.jobsFragment.JobsFragment;
import com.example.youthhub.dashBoard.messagesFragment.MessagesFragment;
import com.example.youthhub.dashBoard.notificationFragment.FragmentNotification;
import com.example.youthhub.loginPage.ActivityLogin;
import com.example.youthhub.myjobs.MyJobsActivity;
import com.example.youthhub.profile.ChangePasswordActivity;
import com.example.youthhub.profile.ProfileActivity;
import com.example.youthhub.resModel.CommonRes;
import com.example.youthhub.resModel.CommonResponse;
import com.example.youthhub.resModel.login.LoginResponse;
import com.example.youthhub.resModel.post.createPost.PostAddMaster;
import com.example.youthhub.resModel.post.postList.PostListResponse;
import com.example.youthhub.resModel.profilepostlist.PostDashboardListResponse;
import com.example.youthhub.retrofit.ApiClient;
import com.example.youthhub.support.SupportListActivity;
import com.example.youthhub.utils.AppUtils;
import com.example.youthhub.utils.Constants;
import com.example.youthhub.utils.FontTypeFace;
import com.example.youthhub.utils.Loader;
import com.example.youthhub.utils.NetWorkUtil;
import com.example.youthhub.utils.Preference;
import com.example.youthhub.utils.SessionManager;
import com.google.gson.Gson;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.rupins.drawercardbehaviour.CardDrawerLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity implements FragmentTransfer, InterfaceClass.OnCustomStateListener {

    private static final String TAG = DashBoardActivity.class.getSimpleName();
    boolean enabled = true;
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.toolbar_search_view)
    EditText toolbarSearchView;
    @BindView(R.id.points)
    TextView points;
    @BindView(R.id.points_txt)
    TextView pointsTxt;
    @BindView(R.id.level_txt)
    TextView levelTxt;
    @BindView(R.id.user_img)
    CircleImageView userImg;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationViewEx bottomNavigationView;
    @BindView(R.id.bottom_navigation)
    ConstraintLayout bottomNavigation;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinator;
    @BindView(R.id.profile_img)
    CircleImageView profileImg;
    @BindView(R.id.profiler_name)
    TextView profilerName;
    @BindView(R.id.search_view)
    EditText searchView;
    @BindView(R.id.dashboard)
    TextView dashboard;
    @BindView(R.id.connection)
    TextView connection;
    @BindView(R.id.events)
    TextView events;
    @BindView(R.id.explore)
    TextView explore;
    @BindView(R.id.jobs_main)
    TextView jobsMain;
    @BindView(R.id.down_arrow)
    ImageView downArrow;
    @BindView(R.id.jobs_search)
    TextView jobsSearch;
    @BindView(R.id.my_jobs)
    TextView myJobs;
    @BindView(R.id.settings)
    TextView settings;
    @BindView(R.id.support)
    TextView support;
    @BindView(R.id.logout)
    TextView logout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    CardDrawerLayout drawerLayout;
    @BindView(R.id.myprofile)
    TextView myprofile;

    LoginResponse loginResponse;

    SessionManager sessionManager;
    Activity activity;

    public static final String mypreference = "youthhub";

    RefreshListListener refreshListListener;
    @BindView(R.id.connection_user_code)
    TextView connectionUserCode;
    @BindView(R.id.user_img1)
    ConstraintLayout userImg1;
    @BindView(R.id.right_bg)
    View rightBg;
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.guideline2)
    Guideline guideline2;
    @BindView(R.id.connection_user_code_profile)
    TextView connectionUserCodeProfile;
    @BindView(R.id.profile_img11)
    ConstraintLayout profileImg11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);
        InterfaceClass.getInstance().setListener(this);
        //sessionManager.checkLogin();
        Log.d(TAG, "onCreate: ");
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        setTypeFace();
        init();

        getBundleData();

        Fragment fragment = new DashBoardFragment();
        coordinator.setBackground(ContextCompat.getDrawable(DashBoardActivity.this, R.drawable.dashboard_bg_gradient));

        getSupportFragmentManager()
                .beginTransaction()
                //  .addToBackStack(null)
                .replace(R.id.frame_layout, fragment, fragment.getClass().toString()) // add and tag the new fragment
                .commit();

        //fragmentTransferListener(new DashBoardFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private boolean firstClick = true;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.action_home:
                        coordinator.setBackground(ContextCompat.getDrawable(DashBoardActivity.this, R.drawable.dashboard_bg_gradient));
                        fragmentTransferListener(new DashBoardFragment());
                        break;
                    case R.id.action_cmt:
                        coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                        fragmentTransferListener(new MessagesFragment());
                        break;
                    case R.id.action_camera:

                        coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));

                        call_post_add_master_api();
                        break;
                    case R.id.action_notification:
                        coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                        fragmentTransferListener(new FragmentNotification());
                        break;
                    case R.id.action_jobs:
                        coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                        fragmentTransferListener(new JobsFragment());
                        break;
                }

                if (firstClick) {
                    int position = bottomNavigationView.getMenuItemPosition(menuItem);
                    if (0 == position) {
                        firstClick = false;
                        bottomNavigationView.setIconTintList(0, getResources()
                                .getColorStateList(R.color.selected_item_bottom_nav));
                        bottomNavigationView.setTextTintList(0, getResources()
                                .getColorStateList(R.color.selected_item_bottom_nav));
                    }
                }

                return true;
            }
        });

        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);
        bottomNavigationView.setTextVisibility(false);

    }


    private void call_post_add_master_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<PostAddMaster> call = ApiClient.getApiInterface().getPostAddMaster(Constants.getApiKey(activity), Constants.getAccessKey(activity), Constants.getToken(activity));
            call.enqueue(new Callback<PostAddMaster>() {
                @Override
                public void onResponse(@NonNull Call<PostAddMaster> call, @NonNull Response<PostAddMaster> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().getStatus() == 1) {
                            bottomNavigationView.getMenu().findItem(R.id.action_camera).setChecked(false);
                            bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                            Bundle bundle = new Bundle();
                            bundle.putParcelable(Constants.PostAddMaster, response.body());
                            Intent postIntent = new Intent(activity, CreatePostActivity.class);
                            postIntent.putExtras(bundle);
                            startActivity(postIntent);
                            activity.overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostAddMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<PostAddMaster> call, @NonNull Throwable t) {
                    call_post_add_master_api();
                    Log.d(Constants.failureResponse + " PostAddMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }

    private void call_logout_api() {
        if (NetWorkUtil.isNetworkConnected(activity)) {
            Loader.showLoad(activity, true);
            Call<CommonResponse> call = ApiClient.getApiInterface().getlogout(Constants.getApiKey(activity),
                    Constants.getAccessKey(activity), Constants.getToken(activity));
            call.enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(@NonNull Call<CommonResponse> call, @NonNull Response<CommonResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null && response.body().getStatus() == 1) {

                            Intent intent = new Intent(getApplicationContext(), ActivityLogin.class);
                            startActivity(intent);
                            sessionManager.logoutUser();
                            activity.overridePendingTransition(R.anim.activity_slide_down, R.anim.stay);
                            finish();
                        }
                    } else {
                        Log.d(Constants.failureResponse + " PostAddMaster", response.toString());
                    }
                    Loader.showLoad(activity, false);
                }

                @Override
                public void onFailure(@NonNull Call<CommonResponse> call, @NonNull Throwable t) {
                    call_logout_api();
                    Log.d(Constants.failureResponse + " PostAddMaster", t.toString());
                    Loader.showLoad(activity, false);
                }
            });
        }
    }


    private void getBundleData() {
        Log.d(TAG, "getBundleData:  ");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            loginResponse = bundle.getParcelable(Constants.LoginData);
            Log.d(TAG, "getBundleData: if " + new Gson().toJson(loginResponse));
            Log.d(TAG, "getBundleData: if sf " + loginResponse.getLoginData().getUserCoverPic());
            Preference.getInstance(this).setStr(Constants.AccessKey, loginResponse.getAccessKey());
            Preference.getInstance(this).setStr(Constants.Token, loginResponse.getToken());
            Preference.getInstance(this).setStr(Constants.UserID, loginResponse.getLoginData().getUserId());
            Preference.getInstance(this).setStr(Constants.UserCode, loginResponse.getLoginData().getUserCode());
            Preference.getInstance(this).setStr(Constants.UserNameCode, loginResponse.getLoginData().getUserNameCode());
            Preference.getInstance(this).setStr(Constants.UserType, loginResponse.getLoginData().getUserTypeId());
            Preference.getInstance(this).setStr(Constants.UserPoints, loginResponse.getLoginData().getUser_points());
            Preference.getInstance(this).setStr(Constants.UserLevel, loginResponse.getLoginData().getUser_level());
            Preference.getInstance(this).setStr(Constants.UserLevelName, loginResponse.getLoginData().getUser_level_name());
            Preference.getInstance(this).setStr(Constants.UserProfileImage, loginResponse.getLoginData().getUserProfilePic());
            Preference.getInstance(this).setStr(Constants.UserName, loginResponse.getLoginData().getUserName());
            Preference.getInstance(this).setStr(Constants.UserImagePath, loginResponse.getLoginData().getUserMediumPath());
            Log.d("YH-ACCESS-KEY", Preference.getInstance(this).getStr("Access_key"));
            Log.d("Authorizations", Preference.getInstance(this).getStr("Token"));
        } else {
            Log.d(TAG, "getBundleData:else  ");
        }
        Log.d(TAG, "getBundleData:else  name" + Preference.getInstance(this).getStr(Constants.UserImagePath));
        Log.d(TAG, "getBundleData:else  UserImagePath" + Preference.getInstance(this).getStr(Constants.UserProfileImage));
        Log.d(TAG, "getBundleData:else  UserImage" + Preference.getInstance(this).getStr(Constants.UserImagePath) + Preference.getInstance(this).getStr(Constants.UserProfileImage) + "?Yh-Access-Key=" + Preference.getInstance(this).getStr(Constants.AccessKey));
        profilerName.setText(Preference.getInstance(this).getStr(Constants.UserName));
        points.setText(Preference.getInstance(this).getStr(Constants.UserPoints));
        levelTxt.setText(Preference.getInstance(this).getStr(Constants.UserLevelName));

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);
        if (Preference.getInstance(this).getStr(Constants.UserProfileImage).length() != 0) {
            Glide.with(this)
                    .load(Preference.getInstance(this).getStr(Constants.UserImagePath) + Preference.getInstance(this).getStr(Constants.UserProfileImage) + "?Yh-Access-Key=" + Preference.getInstance(this).getStr(Constants.AccessKey))
                    .apply(AppUtils.getRequestOption())
                    .listener(AppUtils.requestListener)
                    .into(profileImg);

            userImg.setVisibility(View.VISIBLE);
            profileImg.setVisibility(View.VISIBLE);
            connectionUserCode.setVisibility(View.GONE);
            connectionUserCodeProfile.setVisibility(View.GONE);
            Glide.with(this)
                    .load(Preference.getInstance(this).getStr(Constants.UserImagePath) + Preference.getInstance(this).getStr(Constants.UserProfileImage) + "?Yh-Access-Key=" + Preference.getInstance(this).getStr(Constants.AccessKey))
                    .apply(AppUtils.getRequestOption())
                    .listener(AppUtils.requestListener)
                    .into(userImg);
        } else {
            userImg.setVisibility(View.GONE);
            profileImg.setVisibility(View.GONE);
            connectionUserCode.setVisibility(View.VISIBLE);
            connectionUserCodeProfile.setVisibility(View.VISIBLE);
            connectionUserCode.setText(Preference.getInstance(this).getStr(Constants.UserNameCode));
            connectionUserCodeProfile.setText(Preference.getInstance(this).getStr(Constants.UserNameCode));
        }
    }

    private void setTypeFace() {
        points.setTypeface(FontTypeFace.fontSemiBold(this));
        pointsTxt.setTypeface(FontTypeFace.fontMedium(this));
        levelTxt.setTypeface(FontTypeFace.fontSemiBold(this));

        profilerName.setTypeface(FontTypeFace.fontBold(this));
        dashboard.setTypeface(FontTypeFace.fontMedium(this));
        connection.setTypeface(FontTypeFace.fontMedium(this));
        events.setTypeface(FontTypeFace.fontMedium(this));
        explore.setTypeface(FontTypeFace.fontMedium(this));
        jobsMain.setTypeface(FontTypeFace.fontMedium(this));

        jobsSearch.setTypeface(FontTypeFace.fontMedium(this));
        myJobs.setTypeface(FontTypeFace.fontMedium(this));

        myprofile.setTypeface(FontTypeFace.fontLight(this));
        settings.setTypeface(FontTypeFace.fontLight(this));
        support.setTypeface(FontTypeFace.fontLight(this));
        logout.setTypeface(FontTypeFace.fontLight(this));
    }

    private void init() {
        activity = this;
        /*DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        width = (width/100)*70;

        navigationView.setMinimumWidth(width/2);*/

        /*setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);*/

        drawerLayout.setViewScale(Gravity.START, 0.9f);
        drawerLayout.setRadius(Gravity.START, 30);
        drawerLayout.setViewElevation(Gravity.START, 20);

        enable_dropdown();
    }


    @OnClick({R.id.menu, R.id.dashboard, R.id.connection, R.id.events, R.id.explore, R.id.jobs_main, R.id.down_arrow, R.id.jobs_search,
            R.id.my_jobs, R.id.settings, R.id.support, R.id.logout, R.id.user_img, R.id.connection_user_code, R.id.myprofile,R.id.profile_img11})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu:
                drawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.dashboard:
                bottomNavigation.setVisibility(View.VISIBLE);
                bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                coordinator.setBackground(ContextCompat.getDrawable(DashBoardActivity.this, R.drawable.dashboard_bg_gradient));
                fragmentTransferListener(new DashBoardFragment());
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.connection:
                /*Intent intent = new Intent(this, FindConnectionActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);*/
                bottomNavigation.setVisibility(View.GONE);
                bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                fragmentTransferListener(new FindConnectionFragment());
                drawerLayout.closeDrawer(Gravity.START);
                //drawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.events:
                /*Intent event_intent = new Intent(this, EventsActivity.class);
                startActivity(event_intent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);*/
                bottomNavigation.setVisibility(View.GONE);
                bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);

                coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                fragmentTransferListener(new EventsFragment());
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.explore:
                /*Intent explore_intent = new Intent(this, ExploreActivity.class);
                startActivity(explore_intent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);*/
                bottomNavigation.setVisibility(View.GONE);
                bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                fragmentTransferListener(new ExploreFragment());
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.jobs_main:
                bottomNavigation.setVisibility(View.GONE);
                enable_dropdown();
                break;
            case R.id.down_arrow:
                bottomNavigation.setVisibility(View.GONE);
                enable_dropdown();
                break;
            case R.id.jobs_search:
                /*Intent jobIntent = new Intent(this, JobSearchActivity.class);
                startActivity(jobIntent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);*/
                bottomNavigation.setVisibility(View.GONE);
                bottomNavigationView.getMenu().findItem(R.id.action_jobs).setChecked(true);
                coordinator.setBackgroundColor(ContextCompat.getColor(DashBoardActivity.this, R.color.white));
                fragmentTransferListener(new JobsFragment());
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.my_jobs:
                bottomNavigation.setVisibility(View.GONE);
                Intent myJobIntent = new Intent(this, MyJobsActivity.class);
                startActivity(myJobIntent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                drawerLayout.closeDrawer(Gravity.START);
                break;

            case R.id.myprofile:
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra(Constants.UserCode, Constants.getUserCode(this));
                intent.putExtra(Constants.UserType, "1");
                startActivity(intent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.settings:
                bottomNavigation.setVisibility(View.GONE);
                Intent changepasswordintent = new Intent(getApplicationContext(), ChangePasswordActivity.class);
                startActivity(changepasswordintent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.support:
                bottomNavigation.setVisibility(View.GONE);
                Intent supportIntent = new Intent(getApplicationContext(), SupportListActivity.class);
                startActivity(supportIntent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.logout:
                call_logout_api();

                break;
            case R.id.user_img:
                Intent profileIntent = new Intent(this, ProfileActivity.class);
                profileIntent.putExtra(Constants.UserCode, Constants.getUserCode(this));
                profileIntent.putExtra(Constants.UserType, "1");
                startActivity(profileIntent);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.profile_img11:
                Intent profileIntent2 = new Intent(this, ProfileActivity.class);
                profileIntent2.putExtra(Constants.UserCode, Constants.getUserCode(this));
                profileIntent2.putExtra(Constants.UserType, "1");
                startActivity(profileIntent2);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
            case R.id.connection_user_code:
                Intent profileIntent1 = new Intent(this, ProfileActivity.class);
                profileIntent1.putExtra(Constants.UserCode, Constants.getUserCode(this));
                profileIntent1.putExtra(Constants.UserType, "1");
                startActivity(profileIntent1);
                overridePendingTransition(R.anim.activity_slide_up, R.anim.stay);
                break;
        }
    }

    private void enable_dropdown() {
        /*if (enabled) {*/
            jobsSearch.setVisibility(View.VISIBLE);
            myJobs.setVisibility(View.VISIBLE);
            enabled = true;
      /*  } else {
            jobsSearch.setVisibility(View.VISIBLE);
            myJobs.setVisibility(View.VISIBLE);
            enabled = true;
        }*/
    }

    @Override
    public void fragmentTransferListener(Fragment fragment) {
        /*FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();*/

        FragmentManager fm = getSupportFragmentManager();
        Fragment currentFragment = fm.findFragmentById(R.id.frame_layout);
        if (currentFragment != null && !fragment.getClass().toString().equals(currentFragment.getTag())) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frame_layout, fragment, fragment.getClass().toString()) // add and tag the new fragment
                    .commit();
        }

    }

    @Override
    public void hideSearchView(boolean hideSearch) {
        if (hideSearch) {
            toolbarSearchView.setVisibility(View.GONE);
        } else {
            toolbarSearchView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.stay, R.anim.activity_slide_down);
        }

    }

    @Override
    public void stateChanged(PostDashboardListResponse response) {
        refreshListListener.refreshList(response);
    }

    public interface RefreshListListener {
        void refreshList(PostDashboardListResponse response);
    }

    public void setRefreshListListener(RefreshListListener refreshListListener) {
        this.refreshListListener = refreshListListener;
    }

}
