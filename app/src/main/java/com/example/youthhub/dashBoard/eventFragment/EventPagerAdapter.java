package com.example.youthhub.dashBoard.eventFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.youthhub.resModel.event.eventView.EventViewData;
import com.example.youthhub.resModel.event.eventView.EventViewResponse;
import com.example.youthhub.utils.Constants;

public class EventPagerAdapter extends FragmentStatePagerAdapter {

    Bundle bundle;
    private EventViewData eventViewData;

    EventPagerAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.bundle = bundle;
        EventViewResponse eventViewResponse = bundle.getParcelable(Constants.EventViewRes);
        eventViewData = eventViewResponse != null ? eventViewResponse.getEventViewData() : null;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return EventAboutFragment.newInstance(eventViewData);
            case 1:
                return EventPhotosFragment.newInstance(eventViewData);
            case 2:
                return EventVideosFragment.newInstance(eventViewData);
            case 3:
                return EventDiscussionFragment.newInstance(eventViewData);
            //return EventDiscussionFragment.newInstance(eventViewData);
            default:
                return EventAboutFragment.newInstance(eventViewData);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "About";
        } else if (position == 1) {
            title = "Photos";
        } else if (position == 2) {
            title = "Videos";
        } else if (position == 3) {
            title = "Discussion Board";
        }
        return title;
    }
}
