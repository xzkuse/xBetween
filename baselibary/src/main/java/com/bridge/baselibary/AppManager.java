package com.bridge.baselibary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * @author xzk
 * @data 2018/10/27
 * @email o-xiezhengkun@beyondsoft.com
 * @remark  Activity管理器
 */
public class AppManager {

    private Stack<Activity> activityStack=new Stack<>();

    private AppManager() {
    }

    private static AppManager instance;

    public static AppManager lazy(){
        if( instance == null){
            instance=new AppManager();
        }
        return instance;
    }

    /**
     * activity入栈
     * @param activity
     */
    public void addActivity(Activity activity){
        activityStack.add(activity);
    }

    /**
     * activity 出栈
     *
     * @param activity
     */
    public void finishActivity(Activity activity){
        activity.finish();
        activityStack.remove(activity);
    }

    /**
     * 获取当前栈顶
     * @return
     */
    public Activity currentActivity(){
        return activityStack.lastElement();
    }

    /**
     * 清理栈
     */
    public void finishAllActivity(){
        for (Activity activity : activityStack) {
            activity.finish();
        }
        activityStack.clear();
    }

    @SuppressLint("MissingPermission")
    public void exitApp(Context context){
        finishAllActivity();
        ActivityManager systemService = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        systemService.killBackgroundProcesses(context.getPackageName());
        System.exit(0);
    }

}
