package com.project.liuboyuan.autopartsmarketing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by 13173 on 2016/11/2.
 */

public class product_details extends Activity {
    private ImageButton btn_back;
    private Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        getviewId();
        setListener();
    }

    private void setListener() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.flag = 2;
                Intent i = new Intent(product_details.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void getviewId() {
        btn_back = (ImageButton)findViewById(R.id.btn_back);
        buy = (Button)findViewById(R.id.lijigoumai);
    }

}
