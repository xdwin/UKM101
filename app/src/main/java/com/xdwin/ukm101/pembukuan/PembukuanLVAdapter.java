package com.xdwin.ukm101.pembukuan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xdwin.ukm101.R;

import java.util.ArrayList;

/**
 * Created by Edwin on 9/16/2016.
 */
public class PembukuanLVAdapter extends BaseAdapter {

    Context context;
    ArrayList<PembukuanModel> models;

    public PembukuanLVAdapter(Context context, ArrayList<PembukuanModel> models) {
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
            view = inflater.inflate(R.layout.item_fragment_pembukuan, null);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.pembukuan_item_fragment_title);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        PembukuanModel model = (PembukuanModel) getItem(position);
        viewHolder.tvTitle.setText(model.getTitle());

        return view;
    }

    static class ViewHolder{
        TextView tvTitle;
    }
}
