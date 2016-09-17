package com.xdwin.ukm101.ukmdaily;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xdwin.ukm101.R;

public class UKMDailyActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private UKMDailyTabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukmdaily);

        setupTab();
    }

    private void setupTab() {
        tabLayout = (TabLayout) findViewById(R.id.ukmdaily_activity_tab_layout);
        viewPager = (ViewPager) findViewById(R.id.ukmdaily_activity_view_pager);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabAdapter = new UKMDailyTabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Tutorials");
        tabLayout.getTabAt(1).setText("Marketings");
        tabLayout.getTabAt(2).setText("Events");
    }
}
