package com.xdwin.ukm101.ukmdaily;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xdwin.ukm101.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFragment extends Fragment {

    private ListView listView;
    private UKMDailyLVAdapter adapter;
    private ArrayList<UKMDailyModel> tutorials;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        setHasOptionsMenu(true);

        listView = (ListView) view.findViewById(R.id.tutorial_fragment_listview);
        tutorials = new ArrayList<>();

        setupTutorials();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), UKMDetailsActivity.class));
            }
        });

        return view;
    }

    private void setupTutorials() {
        int tutorial = 10;
        for (int i = 0; i < tutorial; i++ ){
            UKMDailyModel model = new UKMDailyModel();
            model.setTitle("Tutorial: Cara membuat iklan yang menarik pada social media");
            model.setExcerpt("Pada zaman sekarang, semua orang telah mempunyai akun pada masing-masing sosial media. Tak lagi memandang status, baik ibu-ibu, anak-anak maupun orang dewasa...");
            model.setImageURL("https://cdn1.iconfinder.com/data/icons/business-items/512/analytics_laptop_web_analysis_report_chart_data_stock_market_screen_business_management_information_statistics_flat_design_icon-512.png");
            tutorials.add(model);
        }
        adapter = new UKMDailyLVAdapter(getContext(), tutorials);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

}
