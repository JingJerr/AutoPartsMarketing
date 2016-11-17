package com.project.liuboyuan.autopartsmarketing;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.ViewFlipper;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13173 on 2016/10/26.
 */

public class product_Fragment extends Fragment{
    private ArrayAdapter<String> adapter;
    private List<product_info> lp = new ArrayList<>();
    private ListView lv_product;
    private product_adapter pr_adapter;
    ViewFlipper viewFlipper;
    float startX = 0;
    private ScrollView scroll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_main, container, false);
        getData();
        pr_adapter = new product_adapter(lp);
//        ll = (LinearLayout)view.findViewById(R.id.ll);
        lv_product = (ListView)view.findViewById(R.id.Lv_product);
        scroll = (ScrollView)view.findViewById(R.id.scroll);
        scroll.smoothScrollTo(0,0);
        lv_product.setAdapter(pr_adapter);
        lv_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),product_details.class);
                getActivity().startActivity(intent);
            }
        });
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewflipper);
        /**
         * 设置view切换的时间间隔
         */
        viewFlipper.setFlipInterval(2000);

        /**
         * view开始切换
         */
        viewFlipper.startFlipping();

        /**
         * 设置左右滑动事件以及点击事件
         */

        viewFlipper.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        break;

                    case MotionEvent.ACTION_MOVE:

                        break;
                    case MotionEvent.ACTION_UP:
                        /**
                         * 向右滑动
                         */

                        if ((event.getX() - startX) > 100) {
                            viewFlipper.showNext();
                        }

                        /**
                         * 向左滑动
                         */
                        if ((startX - event.getX()) > 100) {
                            viewFlipper.showPrevious();
                        }

                        break;

                    default:
                        break;
                }

                return true;
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        pr_adapter = new product_adapter(lp);
        lv_product.setAdapter(pr_adapter);
        lv_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), product_details.class);
                Bundle bundle = new Bundle();
                bundle.putLong("id",lp.get(i).getId());
                bundle.putString("Name",lp.get(i).getmProductName());
                bundle.putString("Price",lp.get(i).getGetmProductPrice());
                bundle.putDouble("url",lp.get(i).getUrl());
//                bundle.putString("content",lp.get(i).getPoint());

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void getData() {

        //1、创建网络访问的类的对象
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://localhost/product";

        //2、发送请求

        client.get(getActivity(), url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                for (int i = 0; i < response.length(); i++){
                    try {

                        int id = response.getJSONObject(i).getInt("id");
                        int image = R.drawable.car0;
                        String Name = response.getJSONObject(i).getString("Name");
                        String Price = response.getJSONObject(i).getString("Price");
                        product_info product_info = new product_info(id,Name,Price,image);
                        lp.add(product_info);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    lp.add((new product_info(1,"法拉利","200W-300W",R.drawable.car)));
    lp.add((new product_info(2,"兰博基尼","200W-700W",R.drawable.car0)));
    lp.add((new product_info(3,"法拉利","200W-300W",R.drawable.car)));
    lp.add((new product_info(4,"丰田","20W-70W",R.drawable.car2)));
    lp.add((new product_info(5,"大众","20W-40W",R.drawable.borui)));
    lp.add((new product_info(6,"宝马7系","80W200W",R.drawable.baoma)));
    lp.add((new product_info(7,"保时捷","200W-300W",R.drawable.baoshijie)));
    lp.add((new product_info(8,"天籁","20W-50W",R.drawable.tianlai)));
    lp.add((new product_info(9,"博瑞","50W-70W",R.drawable.borui)));
}
}

