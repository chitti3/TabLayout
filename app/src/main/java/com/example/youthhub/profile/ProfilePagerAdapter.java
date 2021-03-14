package com.example.youthhub.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.youthhub.dashBoard.eventFragment.EventsFragment;
import com.example.youthhub.dashBoard.exploreFragment.ExploreFragment;
import com.example.youthhub.dashBoard.jobsFragment.JobsFragment;
import com.example.youthhub.resModel.profile.ProfileInfo;
import com.example.youthhub.utils.Constants;
import com.google.gson.Gson;

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = ProfilePagerAdapter.class.getSimpleName();
    Bundle bundle;
    private ProfileInfo profileInfo;
    String userType;
    int tabcount;

    ProfilePagerAdapter(FragmentManager fm, Bundle bundle, String userType, int tabcount) {
        super(fm);
        this.bundle = bundle;
        this.userType = userType;
        this.tabcount = tabcount;
        profileInfo = bundle.getParcelable(Constants.ProfileInfo);
        bundle.putString(Constants.UserType,userType);
        bundle.putString(Constants.UserCode,profileInfo.getUmCode());
        Log.d(TAG, "ProfilePagerAdapter: "+new Gson().toJson(profileInfo));
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return PostedStoriesFragment.newInstance(profileInfo);
            case 1:
                ProfileFragment fragment = new ProfileFragment();
                fragment.setArguments(bundle);
                return fragment;
            case 2:
                if (userType.equals("6")||userType.equals("1")) {
                    VisualJourneyFragment visualJourneyFragment = new VisualJourneyFragment();
                    visualJourneyFragment.setArguments(bundle);
                    return visualJourneyFragment;
                    //return new VisualJourneyFragment();
                }else{
                    ExploreFragment exploreFragment = new ExploreFragment();
                    exploreFragment.setArguments(bundle);
                    return exploreFragment;
                }
            case 3:
                if (userType.equals("6")||userType.equals("1")) {
                    MileStoneFragment mileStoneFragment = new MileStoneFragment();
                    mileStoneFragment.setArguments(bundle);
                return mileStoneFragment;
                }else{
                    EventsFragment eventsFragment = new EventsFragment();
                    eventsFragment.setArguments(bundle);
                    return eventsFragment;
                }
            case 4:
                JobsFragment jobsFragment = new JobsFragment();
                jobsFragment.setArguments(bundle);
                return jobsFragment;
               // return new ProjectsFragment();

            default:
                return new PostedStoriesFragment();
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Posted Stories";
        } else if (position == 1) {
            title = "Profile";
        } else if (position == 2) {
            if (userType.equals("6")||userType.equals("1")) {
                title = "Visual Journey";
            }else {
                title = "Explore";
            }
        } else if (position == 3) {
            if (userType.equals("6")||userType.equals("1")) {
            title = "Milestones";
            }else {
                title = "Events";
            }
        }else if (position == 4){
            title = "Jobs";
        }
        return title;
    }

}