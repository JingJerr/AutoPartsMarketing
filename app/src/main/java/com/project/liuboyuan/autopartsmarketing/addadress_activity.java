package com.project.liuboyuan.autopartsmarketing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by 13173 on 2016/11/5.
 */

public class addadress_activity extends Activity {
    private ImageButton btn_back;
    private Button back;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addaddress);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addadress_activity.this,adress_activity.class);
                startActivity(i);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(addadress_activity.this,adress_activity.class);
                startActivity(i);
            }
        });
    }

    private void getviewId() {
        btn_back = (ImageButton)findViewById(R.id.btn_back);
        back = (Button)findViewById(R.id.back);
        add = (Button)findViewById(R.id.add);
    }
}
