package com.mainpage.xzkproject01;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mainpage.xzkproject01.load.LoadingActivity;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * create: 2017/7/25 0025
 * auther: xzk
 * class: MainActivity
 * function: 1.和知识互动
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Timer timer;
    private ActivityManager activityManager;
    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        text1.setOnClickListener(this);
        activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        activityManager.getAppTaskThumbnailSize();
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(100);
        Log.i("tags", "act的任务数量:" + tasks.size());
        for (int i = 0; i < tasks.size(); i++) {
            ActivityManager.RunningTaskInfo taskInfo = tasks.get(i);
            Log.i("tags", "act的名称:" + taskInfo.baseActivity.getPackageName() + taskInfo.baseActivity.getClassName());
        }
//        try {
//            Activity a = Class.forName(taskInfo.baseActivity.getPackageName() + taskInfo.baseActivity.getClassName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
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
                ((TextView) msg.obj).setText("start!");
                ((TextView) msg.obj).setEnabled(true);
                Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
//                activityManager.killBackgroundProcesses("com.mainpage.xzkproject01");
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
            }
        }
    };

    @Override
    public void onClick(final View v) {
        v.setEnabled(false);
        timer = new Timer();
        Log.i("tags", "启动命令");
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
