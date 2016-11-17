package com.project.liuboyuan.autopartsmarketing;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13173 on 2016/10/26.
 */

public class order_Fragment extends Fragment{
    int id ;
    String no ;
    String details;
    int image = R.drawable.car;
    private ArrayAdapter<String> adapter;
    private List<order_info> lo = new ArrayList<>();
    private ListView lv_order;
    private order_adapter or_adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_main,container,false);
        or_adapter = new order_adapter(lo);
        lv_order = (ListView)view.findViewById(R.id.Lv_order);
        lv_order.setAdapter(or_adapter);
        setData();
        getData();
        return view;
    }
    public void setData() {

        //1、创建网络访问的类的对象
        final AsyncHttpClient orderpClient = new AsyncHttpClient();

        String orderp_url = "http://localhost/orderp";

        //2、发送请求

        orderpClient.get(getActivity(), orderp_url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray orderpResponse) {
                super.onSuccess(statusCode, headers, orderpResponse);
                for (int i = 0; i < orderpResponse.length(); i++){
                    try {
                        int id = orderpResponse.getJSONObject(i).getInt("id");
                        String no = orderpResponse.getJSONObject(i).getString("No");
                        String details = orderpResponse.getJSONObject(i).getString("Details");
                        order_info order_info = new order_info(id,no,details,image);
                        lo.add(order_info);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
    public String getName(int id){
        final AsyncHttpClient productClient = new AsyncHttpClient();
        productClient.get(getActivity(),
                "http://localhost/product="+id,
                new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject productResponse) {
                        super.onSuccess(statusCode, headers, productResponse);
                        try {
                            no = productResponse.getString("No");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Log.e("getNo: ",no );
        return no;
    }

    private void getData() {
        lo.add((new order_info(1,"001","法拉利 200W 已付款",R.drawable.car)));
        lo.add((new order_info(2,"002","兰博基尼 400W 已付款",R.drawable.car0)));
        lo.add((new order_info(3,"003","宝马7系 120W 已付款",R.drawable.baoma)));
        lo.add((new order_info(4,"004","天籁 20W 已付款",R.drawable.tianlai)));

    }

}
