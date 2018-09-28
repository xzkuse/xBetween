package com.flawdemo.bridge.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author xzk
 * @data 2018/9/28
 * @remark 版本特性适配  8.0弹窗权限   未知来源app安装权限
 */
public class AndroidVersionUtils {

    /**
     * window适配类型权限
     * @param window
     */
    public static void windowPermission(Window window){
        int type;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            type= WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }else {
            type=WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        window.setType(type);
    }

    public static void  canInstall(Activity activity){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            boolean canInstall = activity.getPackageManager().canRequestPackageInstalls();
            if(canInstall){
                //安装逻辑
//                MyAppUpdateUtils.initUpdateApp(isShow, mContext);
            }else {
//                showStringIdToast(R.string.msg_unpermissions);

                Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
                activity.startActivityForResult(intent, 200);
            }
        }else{
//            MyAppUpdateUtils.initUpdateApp(isShow, mContext);
        }
    }

}
