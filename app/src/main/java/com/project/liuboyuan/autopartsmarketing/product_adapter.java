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

public class product_adapter extends BaseAdapter{
    private Context context = MainActivity.context;
    private List<product_info> lprinfo = new ArrayList<>();
    public product_adapter(List<product_info> lp){
        lprinfo = lp;
    }
    @Override
    public int getCount() {
        return lprinfo.size();
    }

    @Override
    public Object getItem(int position) {
        return lprinfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lprinfo.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(null == view){
            view = LayoutInflater.from(context).inflate(R.layout.product_item,null);
        }
        TextView Product_Name = (TextView) view.findViewById(R.id.Product_Name);
        Product_Name.setText(lprinfo.get(position).getmProductName());
        TextView Product_Price = (TextView) view.findViewById(R.id.Product_Price);
        Product_Price.setText(lprinfo.get(position).getGetmProductPrice());
        ImageView Iv_product = (ImageView) view.findViewById(R.id.Iv_product);
        Iv_product.setImageResource(lprinfo.get(position).getUrl());
        return view;
    }
}
