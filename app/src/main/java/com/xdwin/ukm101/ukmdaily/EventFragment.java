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
public class EventFragment extends Fragment {

    private ListView listView;
    private UKMDailyLVAdapter adapter;
    private ArrayList<UKMDailyModel> events;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        setHasOptionsMenu(true);

        listView = (ListView) view.findViewById(R.id.event_fragment_listview);
        events = new ArrayList<>();

        setupEvents();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), UKMDetailsActivity.class));
            }
        });

        return view;
    }

    private void setupEvents() {
        int event = 10;
        for (int i = 0; i < event; i++ ){
            UKMDailyModel model = new UKMDailyModel();
            model.setTitle("Event: Gathering UKM Se-Depok");
            model.setExcerpt("Event gathering UKM Se-Depok akan diadakan pada Bulan Januari tahun 2015. Event ini akan diadakan di kota depok selama 3 hari...");
            model.setImageURL("https://cdn4.iconfinder.com/data/icons/flat-icon-set/2133/flat_icons-graficheria.it-06.png");
            model.setContent("Event gathering UKM Se-Depok akan diadakan pada Bulan Januari tahun 2015. Event ini akan diadakan di kota depok selama 3 hari...");
            model.setId(1);
            events.add(model);
        }

        UKMDailyModel model2 = new UKMDailyModel();
        model2.setTitle("Event: Gathering Pengusaha Kampus Batch 2 Cabang Depok");
        model2.setImageURL("https://pbs.twimg.com/profile_images/628750297892962304/kopjkHnC.png");
        model2.setId(2);
        events.add(model2);

        UKMDailyModel model3 = new UKMDailyModel();
        model3.setTitle("Event: Female Entrepreneurship Cabang Jakarta Selatan");
        model3.setImageURL("https://freeiconshop.com/files/edd/person-girl-flat.png");
        model3.setId(2);
        events.add(model3);


        
        adapter = new UKMDailyLVAdapter(getContext(), events);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

}
