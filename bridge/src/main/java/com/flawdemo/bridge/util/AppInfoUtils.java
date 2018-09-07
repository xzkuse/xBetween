package com.flawdemo.bridge.util;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import com.flawdemo.bridge.R;
import com.flawdemo.bridge.bean.AppInfo;
import com.flawdemo.bridge.util.fileServer.FileUtils;
import com.flawdemo.bridge.util.fileServer.SDCardUtils;

import java.io.File;

/**
 * @author xzk
 * @data 2018/8/29
 * @remark 获取app基本信息并封装发送
 */
public class AppInfoUtils {

    /**
     * 获取基本数据并组装app信息
     *
     * @return
     */
    public static AppInfo assembleAppInfo(Context context) throws Exception {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppVersion(AppUtils.getVersionName(context) + "-build");
        appInfo.setAppName(context.getResources().getString(R.string.app_name));
        appInfo.setDeviceCompanyInfo(android.os.Build.BRAND);
        appInfo.setDeviceSystemVersion(android.os.Build.VERSION.RELEASE);
        appInfo.setDeviceType(android.os.Build.MODEL);

        //todo  logPath
        String logFilePath = "";
        long folderSize = FileUtils.getFolderSize(new File(logFilePath));
        String fileSize = Formatter.formatFileSize(context, folderSize);
        appInfo.setAppLogSize(fileSize);

        appInfo.setDeviceId(DeviceInfoUtil.getUniqueID(context));
        appInfo.setDeviceNetworkInfo(DeviceInfoUtil.getLocalIpAddress(context));
        // 本方式不一定可行待测试（目前，流程上可行）
//        String cppDataSize = PrefUtils.getString(context, MyConstants.SP_APP_SIZE, "0M");
//        appInfo.setAppDataSize(cppDataSize);

        //        appInfo.setDeviceCpuInfo(getCpuName());

        appInfo.setDeviceCpuInfo(DeviceInfoUtil.getCpuInfo());

        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo outInfo = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(outInfo);
        long totalMem = outInfo.totalMem;
        appInfo.setDeviceMemoryInfo(Formatter.formatFileSize(context, totalMem));

        AppInfo.DeviceDiskInfo deviceDiskInfo = new AppInfo.DeviceDiskInfo();
        long memorySize = SDCardUtils.getTotalExternalMemorySize();
        long lUsed = SDCardUtils.getUsedSpace();
        deviceDiskInfo.setTotal(Formatter.formatFileSize(context, memorySize));
        deviceDiskInfo.setUsed(Formatter.formatFileSize(context, lUsed));
        appInfo.setDeviceDiskInfo(deviceDiskInfo);
        return appInfo;
    }



//    private String getAvailMemory() {// 获取android当前可用内存大小
//        ActivityManager am = (ActivityManager) MyApplication.getInstance().getSystemService(Context.ACTIVITY_SERVICE);
//        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
//        am.getMemoryInfo(mi);
//        //mi.availMem; 当前系统的可用内存
//        return Formatter.formatFileSize(MyApplication.getInstance(), mi.availMem);// 将获取的内存大小规格化
//    }
//
//    private static String getTotalMemory() {
//        String str1 = "/proc/meminfo";// 系统内存信息文件
//        String str2;
//        String[] arrayOfString;
//        long initial_memory = 0;
//        try {
//            FileReader localFileReader = new FileReader(str1);
//            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
//            str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小
//
//            arrayOfString = str2.split("//s+");
//            LogUtils.d("系统总内存大小:" + str2);
//            for (String num : arrayOfString) {
//                Log.i(str2, num + "/t");
//            }
//            if (arrayOfString.length > 1) {
//                initial_memory = Integer.valueOf(arrayOfString[1]).intValue() * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
//            }
//            localBufferedReader.close();
//
//        } catch (IOException e) {
//        }
//        return Formatter.formatFileSize(MyApplication.getInstance(), initial_memory);// Byte转换为KB或者MB，内存大小规格化
//    }




}
