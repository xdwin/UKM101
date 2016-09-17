package com.xdwin.ukm101.marketing;

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
 * Created by Edwin on 9/14/2016.
 */
public class MarketingFrontLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<MarketingEndorserModel> models;

    public MarketingFrontLVAdapter(Context context, ArrayList<MarketingEndorserModel> models) {
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
            view = inflater.inflate(R.layout.item_fragment_marketing, null);
            viewHolder.tvName = (TextView) view.findViewById(R.id.marketing_item_fragment_name);
            viewHolder.tvChannel = (TextView) view.findViewById(R.id.marketing_item_fragment_channel);
            viewHolder.tvPriceRange = (TextView) view.findViewById(R.id.marketing_item_fragment_price_range);
            viewHolder.ivPhoto = (ImageView) view.findViewById(R.id.marketing_item_fragment_image);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        MarketingEndorserModel model = (MarketingEndorserModel)  getItem(position);
        viewHolder.tvName.setText(model.getName());
        viewHolder.tvPriceRange.setText(model.getRangePrice());
        viewHolder.tvChannel.setText(model.getChannel());
        Glide.with(context).load(model.getImageUrl()).into(viewHolder.ivPhoto);
        return view;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvChannel;
        TextView tvPriceRange;
        ImageView ivPhoto;
    }
}
