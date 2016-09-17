package com.xdwin.ukm101.loginscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Edwin on 9/2/2016.
 */
public class LoginTabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public LoginTabAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new RegisterFragment();
        }
        return null;
        }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
