package com.xdwin.ukm101.marketing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xdwin.ukm101.R;

public class EndorserDetailsActivity extends AppCompatActivity {

    private ImageView ivEndorserPhoto;
    private TextView tvEndorserStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endorser_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.endorser_details_activity_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivEndorserPhoto = (ImageView) findViewById(R.id.endorser_details_activity_endorser_photo);
        Glide.with(getApplicationContext()).load("http://cliparts.co/cliparts/yik/A6X/yikA6X4bT.jpg").into(ivEndorserPhoto);

        tvEndorserStatistics = (TextView) findViewById(R.id.endorser_details_activity_endorser_statistics);
        tvEndorserStatistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndorserDetailsActivity.this, EndorserStatisticsActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
