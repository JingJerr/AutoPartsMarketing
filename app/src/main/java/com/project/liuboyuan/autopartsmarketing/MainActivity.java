package com.project.liuboyuan.autopartsmarketing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {
    public static Context context;
    private LinearLayout ll;
    private TextView title;
    private MyListner listner;
    private Button mBtnOrder,mBtnProduct,mBtnVip;
    private order_Fragment mOrder;
    private product_Fragment mProduct;
    private vip_Fragment mVip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViewId();
        setListner();
        //设置默认的页面(fragment页面)
        setDefaultPage();
        switch (Utils.flag){
            case 1://显示默认页面
                //3.设置默认的页面（fragment页面）
                setDefaultPage();
                break;
            case 2://订单页面
                setOrder_fragment();
                title.setText("订单相关");
                break;
            case 3://通讯录页面
                setVip_fragment();
                break;
        }
        ll.invalidate();
    }

    private void setVip_fragment() {
        //1. 获取一个FragmentManager对象
        android.app.FragmentManager fm = getFragmentManager();
        //2. 获取FragmentTransaction对象
        android.app.FragmentTransaction transaction = fm.beginTransaction();

        if(mVip == null){
            mVip = new vip_Fragment();
        }
        //3. 设置页面
        transaction.replace(R.id.container, mVip);
        //4. 执行更改
        transaction.commit();
        ll.invalidate();
    }

    private void setOrder_fragment() {
        //1. 获取一个FragmentManager对象
        android.app.FragmentManager fm = getFragmentManager();
        //2. 获取FragmentTransaction对象
        android.app.FragmentTransaction transaction = fm.beginTransaction();

        if(mOrder == null){
            mOrder = new order_Fragment();
        }
        //3. 设置页面
        transaction.replace(R.id.container, mOrder);
        //4. 执行更改
        transaction.commit();
        ll.invalidate();
    }

    View.OnClickListener comm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private void setDefaultPage() {
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction transaction = fm.beginTransaction();
        mProduct = new product_Fragment();
        transaction.replace(R.id.container,mProduct);
        title.setText("首页");
        transaction.commit();
        ll.invalidate();
    }

    private void getViewId() {
        ll= (LinearLayout) findViewById(R.id.activity_main);
        mBtnOrder =(Button) findViewById(R.id.btn_order);
        mBtnProduct =(Button) findViewById(R.id.btn_product);
        mBtnVip = (Button) findViewById(R.id.btn_vip);
        context = getApplicationContext();
        title = (TextView)findViewById(R.id.tv_title);
    }

    private void setListner() {
        MyListner listener = new MyListner();
        mBtnOrder.setOnClickListener(listener);
        mBtnProduct.setOnClickListener(listener);
        mBtnVip.setOnClickListener(listener);
    }

    class MyListner implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            android.app.FragmentManager fm = getFragmentManager();
            android.app.FragmentTransaction transaction = fm.beginTransaction();
            switch (v.getId()){
                case R.id.btn_order:
                    if (mOrder == null){
                        mOrder = new order_Fragment();
                    }

                    transaction.replace(R.id.container,mOrder);
                    title.setText("订单相关");
                    break;
                case R.id.btn_product:
                    if (mProduct == null){
                        mProduct = new product_Fragment();
                    }
                    transaction.replace(R.id.container,mProduct);
                    title.setText("首页");
                    break;
                case R.id.btn_vip:
                    if (mVip == null){
                        mVip = new vip_Fragment();
                    }
                    transaction.replace(R.id.container,mVip);
                    title.setText("会员中心");
                    break;
            }
            //4、执行更改
            transaction.commit();
            //页面刷新
            ll.invalidate();
        }
    }
}
