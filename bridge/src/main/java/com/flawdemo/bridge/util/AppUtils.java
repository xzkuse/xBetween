package com.flawdemo.bridge.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
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
    public static void installApk(Context context,File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //安卓7 .0 以上安装apk方法
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(context, context.getPackageName()+ ".FileProvider",
                                                        apkFile);//这里是包名app，实际要根据项目去编写
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            // 安卓7.0以下安装apk方法
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
            context.startActivity(intent);
        }
    }

}
