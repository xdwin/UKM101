package com.xdwin.ukm101.miscellaneous;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xdwin.ukm101.R;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.PieModel;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

public class StatisticsActivity extends AppCompatActivity {

    private ValueLineChart dailyChart;
    private PieChart incomeExpensesChart;
    private ImageView ivUKMPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        ivUKMPhoto = (ImageView) findViewById(R.id.statistics_activity_ukm_photo);
        dailyChart = (ValueLineChart) findViewById(R.id.statistics_activity_daily_chart);
        incomeExpensesChart = (PieChart) findViewById(R.id.statistics_activity_perbandingan);

        Glide.with(getApplicationContext()).load("http://hargamenu.xyz/wp-content/uploads/2016/05/roti-bakar-eddy.jpg").into(ivUKMPhoto);

        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF56B7F1);

        series.addPoint(new ValueLinePoint("Mei", 20.0f));
        series.addPoint(new ValueLinePoint("Jun", 10.0f));
        series.addPoint(new ValueLinePoint("Jul", 30.0f));
        series.addPoint(new ValueLinePoint("Aug", 25.0f));
        series.addPoint(new ValueLinePoint("Sep", 22.0f));
        series.addPoint(new ValueLinePoint("Oct", 35.0f));
        series.addPoint(new ValueLinePoint("Nov", 10.0f));

        dailyChart.addSeries(series);
        dailyChart.startAnimation();

        incomeExpensesChart.addPieSlice(new PieModel("Income", 55, Color.parseColor("#4CAF50")));
        incomeExpensesChart.addPieSlice(new PieModel("Expenses", 20, Color.parseColor("#CC0000")));
        incomeExpensesChart.startAnimation();
    }
}
