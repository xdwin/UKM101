package com.xdwin.ukm101.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.xdwin.ukm101.R;
import com.xdwin.ukm101.loginscreen.LoginActivity;

/**
 * Created by Edwin on 8/31/2016.
 */
public class UserSessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;

    private static final int PRIVATE_MODE = 0;

    public UserSessionManager(Context mContext){
        this.mContext = mContext;
        pref = mContext.getSharedPreferences(mContext.getString(R.string.KEY_MAIN_SHARED_PREF), PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createUserSession(String phone, String password){
        editor.putString(mContext.getString(R.string.KEY_PHONE),phone);;
        editor.putBoolean(mContext.getString(R.string.KEY_ISUSERLOGIN),true);
        editor.commit();
    }

    public void checkLogin(){
        if (!this.isLoggedIn()){
            //Back to login page
            Intent intent = new Intent(mContext, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }

    public void doLogout(){
        editor.clear();
        editor.commit();
        //Then back to login page
        Intent intent = new Intent(mContext, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(mContext.getString(R.string.KEY_ISUSERLOGIN), false);
    }

}
