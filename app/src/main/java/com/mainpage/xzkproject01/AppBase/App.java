package com.mainpage.xzkproject01.AppBase;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.flawdemo.bridge.log.LogUtils;
import com.flawdemo.bridge.util.ToastUtils;

/**
 * @author xzk
 * @data 2018/8/22
 * @remark  app的基础项
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化log打印
        LogUtils.getLogConfig().configAllowLog(true).configShowBorders(false);

        //初始化toast
        ToastUtils.setmContext(this);

        //初始化图片加载库
        Fresco.initialize(this);
    }
}
