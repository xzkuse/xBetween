package com.mainpage.xzkproject01;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mainpage.xzkproject01.load.LoadingActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * create: 2017/7/25 0025
 * auther: xzk
 * class: MainActivity
 * function: 1.和知识互动
 */
public class MainActivity extends Activity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what > 0)
                ((TextView) msg.obj).setText(msg.what + "");
            else if (msg.what == 0)
                ((TextView) msg.obj).setText("GO!");
            else {
                ((TextView) msg.obj).setEnabled(true);
                Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
            }
        }
    };

    public void clickView(final View v) {
        v.setEnabled(false);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int i = 3;

            @Override
            public void run() {
                Message msg = Message.obtain();
                msg.obj = v;
                msg.what = i;
                handler.sendMessage(msg);
                i--;
            }
        }, 0, 1000);
    }
}
