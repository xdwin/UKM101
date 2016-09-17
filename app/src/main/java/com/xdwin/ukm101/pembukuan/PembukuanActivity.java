package com.xdwin.ukm101.pembukuan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.xdwin.ukm101.R;

import java.util.ArrayList;

public class PembukuanActivity extends AppCompatActivity {

    private ListView listView;
    private PembukuanLVAdapter adapter;
    private ArrayList<PembukuanModel> models;
    private ImageView ivLaporanPembukuan;
    private CardView cvStatistikPembukuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembukuan);

        listView = (ListView) findViewById(R.id.pembukuan_activity_listview);
        models = new ArrayList<>();
        cvStatistikPembukuan = (CardView) findViewById(R.id.pembukuan_activity_cardview);

        String url = "https://cdn0.iconfinder.com/data/icons/business-and-management-2/512/invoice_report_clipboard_business_form_plan_finance_check_list_checking_paper_bill_billing_bank_financial_tax_document_account_pad_office_tool_equipment_information_balance_data_record_flat_design_icon-512.png";
        ivLaporanPembukuan = (ImageView) findViewById(R.id.pembukuan_activity_statistics_icon);
        Glide.with(getApplicationContext()).load(url).into(ivLaporanPembukuan);

        setupListView();

        cvStatistikPembukuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PembukuanActivity.this, PembukuanReportActivity.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(PembukuanActivity.this, PembukuanFormActivity.class));
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
