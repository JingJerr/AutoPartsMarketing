package com.project.liuboyuan.autopartsmarketing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13173 on 2016/11/4.
 */

public class adress_activity extends Activity {
    private ArrayAdapter<String> adapter;
    private List<adress_info> ls = new ArrayList<>();
    private ListView lv;
    private adress_adapter myadapter;
    private ImageButton back;
    private Button add_adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adress);
        getViewId();
        setOnClickListener();
        getData();
        myadapter = new adress_adapter(this,ls);

        lv.setAdapter(myadapter);
    }

    private void setOnClickListener() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adress_activity.this,addadress_activity.class);
                startActivity(intent);
            }
        });
    }

    private void getViewId() {
        lv = (ListView)findViewById(R.id.Lv_adress);
        back = (ImageButton) findViewById(R.id.btn_back);
        add_adress = (Button)findViewById(R.id.add_adress);
    }


    private void getData() {
        ls.add(new adress_info(0,"15341524567","刘博园","河北师范大学"));
    }
}
