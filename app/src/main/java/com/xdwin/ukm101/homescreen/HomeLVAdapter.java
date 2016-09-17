package com.xdwin.ukm101.homescreen;

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
 * Created by Edwin on 9/16/2016.
 */
public class HomeLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<HomeMenuModel> models;

    public HomeLVAdapter(Context context, ArrayList<HomeMenuModel> models) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;

        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_fragment_home, null);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.home_activity_menu_title);
            viewHolder.ivIcon = (ImageView) view.findViewById(R.id.home_activity_menu_icon);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        HomeMenuModel model = (HomeMenuModel) getItem(position);
        viewHolder.tvTitle.setText(model.getTitle());
        Glide.with(context).load(model.getImageURL()).into(viewHolder.ivIcon);
        return view;
    }

    static class ViewHolder{
        TextView tvTitle;
        ImageView ivIcon;
    }
}
