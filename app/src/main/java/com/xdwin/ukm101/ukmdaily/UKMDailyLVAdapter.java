package com.xdwin.ukm101.ukmdaily;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xdwin.ukm101.R;

import java.util.ArrayList;

/**
 * Created by Edwin on 9/11/2016.
 */
public class UKMDailyLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<UKMDailyModel> models;

    public UKMDailyLVAdapter(Context context, ArrayList<UKMDailyModel> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return models.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_fragment_ukmdaily, null);
            viewHolder.title = (TextView) view.findViewById(R.id.ukmdaily_item_fragment_title);
            viewHolder.excerpt = (TextView) view.findViewById(R.id.ukmdaily_item_fragment_excerpt);
            viewHolder.image = (ImageView) view.findViewById(R.id.ukmdaily_item_fragment_image);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        UKMDailyModel model = (UKMDailyModel) getItem(position);
        viewHolder.title.setText(model.getTitle());
        viewHolder.excerpt.setText(model.getExcerpt());
        Glide.with(context).load(model.getImageURL()).into(viewHolder.image);

        return view;
    }

    static class ViewHolder{
        TextView title, excerpt;
        ImageView image;

    }
}
