package com.xdwin.ukm101.pembukuan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xdwin.ukm101.R;

public class PembukuanFormActivity extends AppCompatActivity {

    private EditText etNilaiTransaksi;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembukuan_form);

        Toolbar toolbar = (Toolbar) findViewById(R.id.pembukuan_form_activity_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNilaiTransaksi = (EditText) findViewById(R.id.form_pembukuan_activity_value_edittext);
        btnSubmit = (Button) findViewById(R.id.pembukuan_form_activity_submit_button);

        etNilaiTransaksi.requestFocus();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your Transaction Has Been Saved", Toast.LENGTH_SHORT).show();
                finish();
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
