package com.mainpage.xzkproject01.load;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/7/26 0026.
 */

public class LoadingPresenter implements LoadingInf {
    private LoadingViewInf viewInf;

    public LoadingPresenter(LoadingViewInf viewInf) {
        this.viewInf = viewInf;
    }

    private int i = 0;

    @Override
    public void getDataFromData() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<String> list = new ArrayList<String>();
                if (i < 3) {
                    for (int i = 0; i < 40; i++) {
                        list.add("presenter+" + i);
                    }
                }
                Message msg = Message.obtain();
                msg.obj = list;
                handler.sendMessage(msg);
                Log.i("tags", "pre发出数据" + i);
                i++;
            }
        }, 5 * 1000);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewInf.showDatas((List<String>) msg.obj);
        }
    };
}
