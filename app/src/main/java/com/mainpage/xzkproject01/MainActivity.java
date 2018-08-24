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
import android.widget.Button;
import android.widget.TextView;

import com.flawdemo.bridge.log.LogUtils;
import com.flawdemo.bridge.view.calendar.CustomDatePicker;
import com.mainpage.xzkproject01.AppBase.BaseActivity;
import com.mainpage.xzkproject01.load.LoadingActivity;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * create: 2017/7/25 0025
 * auther: xzk
 * class: MainActivity
 * function: 1.首界面
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Timer timer;
    private ActivityManager activityManager;
    private TextView text1;
    private Button butCalendarView;
    private CustomDatePicker customDatePicker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

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

    private void initView(){
        text1 = (TextView) findViewById(R.id.text1);
        butCalendarView = (Button) findViewById(R.id.but_calendar_view);
        text1.setOnClickListener(this);
        butCalendarView.setOnClickListener(this);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what > 0) {
                ((TextView) msg.obj).setText(msg.what + "");
            } else if (msg.what == 0) {
                ((TextView) msg.obj).setText("GO!");
            } else {
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
        switch (v.getId()) {
            case R.id.but_calendar_view:
                customDatePicker1.show(butCalendarView.getText().toString());
                break;
            case R.id.text1:
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
                break;
            default:
                LogUtils.d("输出一个未注册view:" + v.getId());
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        initDatePicker();
    }

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        butCalendarView.setText(now.split(" ")[0]);
//        currentTime.setText(now);

        // 回调接口，获得选中的时间
        // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                butCalendarView.setText(time.split(" ")[0]);
            }
        }, "2010-01-01 00:00", now);
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

//        customDatePicker2 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
//            @Override
//            public void handle(String time) { // 回调接口，获得选中的时间
//                currentTime.setText(time);
//            }
//        }, "2010-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
//        customDatePicker2.showSpecificTime(true); // 显示时和分
//        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }
}
