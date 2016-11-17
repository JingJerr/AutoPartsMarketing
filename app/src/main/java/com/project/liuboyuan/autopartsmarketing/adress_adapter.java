package com.project.liuboyuan.autopartsmarketing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13173 on 2016/11/5.
 */

public class adress_adapter extends BaseAdapter{
    private Context context;
    private List<adress_info> lainfo = new ArrayList<>();
    public adress_adapter(Context c,List<adress_info> la){
        lainfo = la;
        context = c;
    }
    @Override
    public int getCount() {
        return lainfo.size();
    }

    @Override
    public Object getItem(int position) {
        return lainfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lainfo.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (null == view) {
            view = LayoutInflater.from(context).inflate(R.layout.adress_item, null);
        }
        TextView Tv_adress = (TextView) view.findViewById(R.id.Tv_adress);
        Tv_adress.setText(lainfo.get(position).getAdress());
        TextView Tv_name = (TextView) view.findViewById(R.id.Tv_name);
        Tv_name.setText(lainfo.get(position).getName());
        TextView Tv_phone = (TextView) view.findViewById(R.id.Tv_phone);
        Tv_phone.setText(lainfo.get(position).getPhone());
        return view;
    }
}

