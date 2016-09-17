package com.xdwin.ukm101.homescreen;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.xdwin.ukm101.R;
import com.xdwin.ukm101.marketing.MarketingActivity;
import com.xdwin.ukm101.miscellaneous.StatisticsActivity;
import com.xdwin.ukm101.pembukuan.PembukuanActivity;
import com.xdwin.ukm101.ukmdaily.UKMDailyActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ListView listView;
    private HomeLVAdapter adapter;
    private ArrayList<HomeMenuModel> models;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_activity_toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.ic_action_home_light);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.home_activity_drawer_layout);
        listView = (ListView) findViewById(R.id.home_activity_list_view);
        models = new ArrayList<>();

        setupMenuListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0://Pembukuan
                        intent = new Intent(HomeActivity.this, PembukuanActivity.class);
                        startActivity(intent);
                        break;
                    case 1://Marketing
                        intent = new Intent(HomeActivity.this, MarketingActivity.class);
                        startActivity(intent);
                        break;
                    case 2://UKM Daily
                        intent = new Intent(HomeActivity.this, UKMDailyActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        NavigationView nav = (NavigationView) findViewById(R.id.home_activity_navigation_view);
        if (nav != null) {
            nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.navigation_item_insight){
                        startActivity(new Intent(HomeActivity.this, StatisticsActivity.class));
                        drawerLayout.closeDrawers();
                    }
                    return false;
                }
            });
        }

    }

    private void setupMenuListView() {
        HomeMenuModel model = new HomeMenuModel();
        model.setTitle("PEMBUKUAN 101");
        model.setImageURL("https://cdn0.iconfinder.com/data/icons/business-and-finance-6/155/vector_285_14-01-512.png");
        models.add(model);

        HomeMenuModel model2 = new HomeMenuModel();
        model2.setTitle("MARKETING 101");
        model2.setImageURL("http://hourglass-studios.com/wp-content/uploads/2014/04/VisualMarketing_Icon.png");
        models.add(model2);

        HomeMenuModel model3 = new HomeMenuModel();
        model3.setTitle("UKM Daily");
        model3.setImageURL("http://1xeliq3m9521u4jii2h0nt01.wpengine.netdna-cdn.com/assets/media/icon-marketing-300x298.png");
        models.add(model3);

        adapter = new HomeLVAdapter(getApplicationContext(), models);
        listView.setAdapter(adapter);
    }

    public static final String getUriToResource(@NonNull Context context, @AnyRes int resId) throws Resources.NotFoundException {
        /** Return a Resources instance for your application's package. */
        Resources res = context.getResources();
        /**
         * Creates a Uri which parses the given encoded URI string.
         * @param uriString an RFC 2396-compliant, encoded URI
         * @throws NullPointerException if uriString is null
         * @return Uri for this given uri string
         */
        Uri resUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + res.getResourcePackageName(resId)
                + '/' + res.getResourceTypeName(resId)
                + '/' + res.getResourceEntryName(resId));
        /** return uri */
        return resUri.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }
}
