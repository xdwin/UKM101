package com.xdwin.ukm101.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xdwin.ukm101.R;
import com.xdwin.ukm101.homescreen.HomeActivity;
import com.xdwin.ukm101.loginscreen.LoginActivity;
import com.xdwin.ukm101.util.UserSessionManager;

public class SplashScreen extends AppCompatActivity {

    private final int DELAY_SPLASH  = 3000;
    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        session = new UserSessionManager(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (session.isLoggedIn()){
                    intent = new Intent(SplashScreen.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else {
                    intent = new Intent(SplashScreen.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        }, DELAY_SPLASH);

    }
}
