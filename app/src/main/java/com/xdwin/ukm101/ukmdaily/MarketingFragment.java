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
public class MarketingFragment extends Fragment {


    private ListView listView;
    private UKMDailyLVAdapter adapter;
    private ArrayList<UKMDailyModel> tutorials;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marketing, container, false);
        setHasOptionsMenu(true);

        listView = (ListView) view.findViewById(R.id.marketing_fragment_listview);
        tutorials = new ArrayList<>();

        setupMarketings();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), UKMDetailsActivity.class));
            }
        });

        return view;
    }

    private void setupMarketings() {
        int marketing = 10;
        for (int i = 0; i < marketing; i++ ){
            UKMDailyModel model = new UKMDailyModel();
            model.setTitle("Marketing: Memanfaatkan Google Analytics untuk menunjang traffic pada website");
            model.setExcerpt("Hampir setiap orang di kota kini mempunyai setidaknya satu buah smartphone. Hal ini tidak dapat dipungkiri karena pesatnya perkembangan jaman membuat setiap orang...");
            model.setImageURL("http://www.freeiconspng.com/uploads/megaphone-message-news-promotion-speaker-icon--17.png");
            tutorials.add(model);
        }
        adapter = new UKMDailyLVAdapter(getContext(), tutorials);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }

}
