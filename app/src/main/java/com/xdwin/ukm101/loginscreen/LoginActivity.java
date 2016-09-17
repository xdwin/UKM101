package com.xdwin.ukm101.loginscreen;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xdwin.ukm101.R;

public class LoginActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = (TabLayout) findViewById(R.id.login_activity_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.login_activity_view_pager);

        setupTab();
    }

    private void setupTab() {
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginTabAdapter loginAdapter = new LoginTabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(loginAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Login");
        tabLayout.getTabAt(1).setText("Register");
    }
}
