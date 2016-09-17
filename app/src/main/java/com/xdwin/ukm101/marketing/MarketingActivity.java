package com.xdwin.ukm101.marketing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.xdwin.ukm101.R;

import java.util.ArrayList;

public class MarketingActivity extends AppCompatActivity {

    private ListView listView;
    private MarketingFrontLVAdapter adapter;
    private ArrayList<MarketingEndorserModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);

        listView = (ListView) findViewById(R.id.marketing_activity_listview);
        models = new ArrayList<>();

        setupListView();
    }

    private void setupListView() {
        MarketingEndorserModel model = new MarketingEndorserModel();
        model.setId(1);
        model.setName("Shandy Aulia");
        model.setChannel("Instagram, LINE Official");
        model.setDescription("");
        model.setImageUrl("https://pbs.twimg.com/profile_images/683303836371386373/JgsnljBI.jpg");
        model.setRangePrice("Rp 400.000 - Rp 800.000");
        models.add(model);

        MarketingEndorserModel model2 = new MarketingEndorserModel();
        model2.setId(3);
        model2.setName("Komunitas Harley Davidson Indonesia");
        model2.setChannel("Instagram, Facebook Page");
        model2.setDescription("");
        model2.setImageUrl("http://cliparts.co/cliparts/yik/A6X/yikA6X4bT.jpg");
        model2.setRangePrice("Rp 200.000 - Rp 500.000");
        models.add(model2);

        MarketingEndorserModel model3 = new MarketingEndorserModel();
        model3.setId(3);
        model3.setName("Coffe Toffe Inonesia");
        model3.setChannel("Instagram, Facebook Page");
        model3.setDescription("");
        model3.setImageUrl("http://cdn.bisnisukm.com/2012/06/coffee-toffee.jpg");
        model3.setRangePrice("Rp 400.000 - Rp 800.000");
        models.add(model3);

        adapter = new MarketingFrontLVAdapter(getApplicationContext(), models);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}
