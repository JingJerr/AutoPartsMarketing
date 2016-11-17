package com.project.liuboyuan.autopartsmarketing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13173 on 2016/11/2.
 */

public class order_adapter extends BaseAdapter{
    private Context context = MainActivity.context;
    private List<order_info> lorinfo = new ArrayList<>();
    public order_adapter(List<order_info> lo){
        lorinfo = lo;
    }
    @Override
    public int getCount() {
        return lorinfo.size();
    }

    @Override
    public Object getItem(int position) {
        return lorinfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lorinfo.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(null == view){
            view = LayoutInflater.from(context).inflate(R.layout.order_item,null);
        }
        TextView order_no = (TextView) view.findViewById(R.id.order_no);
        order_no.setText(lorinfo.get(position).getmOrderNo());
        TextView order_detail = (TextView) view.findViewById(R.id.order_detail);
        order_detail.setText(lorinfo.get(position).getmOrderDetail());
        ImageView Iv_order = (ImageView) view.findViewById(R.id.Iv_order);
        Iv_order.setImageResource(lorinfo.get(position).getUrl());
        return view;
    }
}
