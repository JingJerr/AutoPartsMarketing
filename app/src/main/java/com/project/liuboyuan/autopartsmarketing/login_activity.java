package com.project.liuboyuan.autopartsmarketing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by 13173 on 2016/11/4.
 */

public class login_activity extends Activity {
    private EditText EtUname;
    private EditText EtUpwd;
    private Button login;
    private Button rejest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getViewId();
        setOnClickListener();
    }

    private void setOnClickListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //2.要能够获取输入框的值
                String strName = EtUname.getText().toString();
                String strPwd = EtUpwd.getText().toString();

                if (strName.equals("liuboyuan")&&strPwd.equals("123456"))
                {
                    Toast.makeText(login_activity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login_activity.this,MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(login_activity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }

        });
        rejest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void getViewId() {
        EtUname = (EditText)findViewById(R.id.EtUname );
        EtUpwd = (EditText)findViewById(R.id.EtUpwd );
        login = (Button)findViewById(R.id.login);
        rejest = (Button)findViewById(R.id.rejest);
    }
}
