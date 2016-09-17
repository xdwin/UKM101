package com.xdwin.ukm101.ukmdaily;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        return view;
    }

    private void setupEvents() {
        int event = 10;
        for (int i = 0; i < event; i++ ){
            UKMDailyModel model = new UKMDailyModel();
            model.setTitle("Event: Gathering UKM Se-Depok");
            model.setExcerpt("Event gathering UKM Se-Depok akan diadakan pada Bulan Januari tahun 2015. Event ini akan diadakan di kota depok selama 3 hari...");
            events.add(model);
        }
        adapter = new UKMDailyLVAdapter(getContext(), events);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

}