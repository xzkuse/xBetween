package com.flawdemo.bridge.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * @author xzk
 * @data 2018/8/24
 * @remark 应用层常用工具类
 */
public class AppUtils {

    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
//            PackageManager.GET_ACTIVITIES
            pi = pm.getPackageInfo(context.getPackageName(), 16384);
            return pi;
        } catch (Exception var3) {
            var3.printStackTrace();
            return pi;
        }
    }

    /**
     * 安装 apk 文件
     *
     * @param apkFile
     */
    public static void installApk(Activity activity, File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //安卓7 .0 以上安装apk方法
           //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(activity, activity.getPackageName()+ ".FileProvider",
                                                        apkFile);//这里是包名app，实际要根据项目去编写
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            // 安卓7.0以下安装apk方法
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            activity.startActivity(intent);
        }
    }

    /**
     * 安装APK  (新版)
     *
     */
    public static void installApk(Application application, File updateFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //判读版本是否在7.0以上
        if (Build.VERSION.SDK_INT >= 24) {
            //provider authorities
            Uri apkUri = FileProvider.getUriForFile(application,application.getPackageName()+ ".FileProvider", updateFile);
            //Granting Temporary Permissions to a URI
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(updateFile), "application/vnd.android.package-archive");
        }
        application.startActivity(intent);
    }


    /**
     * 判断是否是8.0,8.0需要处理未知应用来源权限问题,否则直接安装
     */
    private void checkIsAndroidO(Application application, File updateFile) {
        if (Build.VERSION.SDK_INT >= 26) {
            boolean b = application.getPackageManager().canRequestPackageInstalls();
            if (b) {
                installApk(application,updateFile);
            } else {
                //请求安装未知应用来源的权限
                startInstallPermissionSettingActivity();
            }
        } else {
            installApk(application,updateFile);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startInstallPermissionSettingActivity() {
        //注意这个是8.0新API
        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES);
//        startActivityForResult(intent, 10010);
    }

}
