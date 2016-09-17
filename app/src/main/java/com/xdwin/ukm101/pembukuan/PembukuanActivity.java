package com.xdwin.ukm101.pembukuan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xdwin.ukm101.R;

import java.util.ArrayList;

public class PembukuanActivity extends AppCompatActivity {

    private ListView listView;
    private PembukuanLVAdapter adapter;
    private ArrayList<PembukuanModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembukuan);

        listView = (ListView) findViewById(R.id.pembukuan_activity_listview);
        models = new ArrayList<>();

        setupListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    //TODO: Define activity
                }
            }
        });
    }

    private void setupListView() {

        PembukuanModel model = new PembukuanModel();
        model.setId("Input1");
        model.setTitle("Pembelian Aset");
        models.add(model);

        PembukuanModel model2 = new PembukuanModel();
        model2.setId("Input2");
        model2.setTitle("Hutang");
        models.add(model2);

        PembukuanModel model3 = new PembukuanModel();
        model3.setId("Input3");
        model3.setTitle("Pemindahbukuan");
        models.add(model3);

        PembukuanModel model4 = new PembukuanModel();
        model4.setId("Input4");
        model4.setTitle("Transaksi Lain");
        models.add(model4);

        adapter = new PembukuanLVAdapter(getApplicationContext(), models);
        listView.setAdapter(adapter);

    }
}
