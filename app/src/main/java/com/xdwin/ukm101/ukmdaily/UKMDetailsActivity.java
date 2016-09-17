package com.xdwin.ukm101.ukmdaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xdwin.ukm101.R;

public class UKMDetailsActivity extends AppCompatActivity {


    private ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ukmdetails);

        ivBanner = (ImageView) findViewById(R.id.ukmdetails_activity_banner);
        String url = "https://cdn.idntimes.com/content-images/post/20160818/jo-hell-590d0dc7ad57a026d21432d82066d30e_850x350.jpg";
        Glide.with(getApplicationContext()).load(url).into(ivBanner);
    }
}
