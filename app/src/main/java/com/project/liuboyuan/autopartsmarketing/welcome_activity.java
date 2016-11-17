package com.project.liuboyuan.autopartsmarketing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by 13173 on 2016/10/30.
 */

public class welcome_activity extends Activity {
    private Handler mMainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClass(getApplication(), login_activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            // overridePendingTransition must be called AFTER finish() or startActivity, or it won't work.
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        }
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setBackgroundDrawableResource(R.drawable.welcome);
        mMainHandler.sendEmptyMessageDelayed(0, 2000);
    }

    // much easier to handle key events
    @Override
    public void onBackPressed() {
    }
}
