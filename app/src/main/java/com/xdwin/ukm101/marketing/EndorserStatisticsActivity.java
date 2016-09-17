package com.xdwin.ukm101.marketing;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xdwin.ukm101.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.util.ArrayList;

public class EndorserStatisticsActivity extends AppCompatActivity {

    protected ValueLineChart positiveBarChart, negativeBarChart;
    protected PieChart jumlahPostPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endorser_statistics);


        Toolbar toolbar = (Toolbar) findViewById(R.id.endorser_statistics_activity_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        positiveBarChart = (ValueLineChart) findViewById(R.id.endorser_statistics_activity_positive_imp_barchart);
        negativeBarChart = (ValueLineChart) findViewById(R.id.endorser_statistics_activity_negative_imp_barchart);
        jumlahPostPieChart = (PieChart) findViewById(R.id.endorser_statistics_activity_jumlah_post_piechart);

        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF56B7F1);

        series.addPoint(new ValueLinePoint("Mei", 20.0f));
        series.addPoint(new ValueLinePoint("Jun", 10.0f));
        series.addPoint(new ValueLinePoint("Jul", 30.0f));
        series.addPoint(new ValueLinePoint("Aug", 25.0f));
        series.addPoint(new ValueLinePoint("Sep", 22.0f));
        series.addPoint(new ValueLinePoint("Oct", 35.0f));
        series.addPoint(new ValueLinePoint("Nov", 10.0f));

        positiveBarChart.addSeries(series);
        positiveBarChart.startAnimation();

        ValueLineSeries series2 = new ValueLineSeries();
        series2.setColor(0xFF56B7F1);

        series2.addPoint(new ValueLinePoint("Mei", 15.0f));
        series2.addPoint(new ValueLinePoint("Jun", 12.0f));
        series2.addPoint(new ValueLinePoint("Jul", 3.0f));
        series2.addPoint(new ValueLinePoint("Aug", 12.0f));
        series2.addPoint(new ValueLinePoint("Sep", 5.0f));
        series2.addPoint(new ValueLinePoint("Okt", 6.0f));
        series2.addPoint(new ValueLinePoint("Nov", 10.0f));

        negativeBarChart.addSeries(series2);
        negativeBarChart.startAnimation();


        jumlahPostPieChart.addPieSlice(new PieModel("Mei", 15, Color.parseColor("#FE6DA8")));
        jumlahPostPieChart.addPieSlice(new PieModel("Jun", 25, Color.parseColor("#56B7F1")));
        jumlahPostPieChart.addPieSlice(new PieModel("Jul", 35, Color.parseColor("#CDA67F")));
        jumlahPostPieChart.addPieSlice(new PieModel("Sep", 9, Color.parseColor("#FED70E")));
        jumlahPostPieChart.addPieSlice(new PieModel("Okt", 9, Color.parseColor("#FED70E")));
        jumlahPostPieChart.addPieSlice(new PieModel("Nov", 9, Color.parseColor("#FED70E")));

        jumlahPostPieChart.startAnimation();
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
