package com.xdwin.ukm101.ukmdaily;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Edwin on 9/11/2016.
 */
public class UKMDailyTabAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    public UKMDailyTabAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TutorialFragment();
            case 1:
                return new MarketingFragment();
            case 2:
                return new EventFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Tutorials";
            case 1:
                return "Marketings";
            case 2:
                return "Events";
        }
        return super.getPageTitle(position);
    }
}
