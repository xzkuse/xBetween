package com.flawdemo.bridge.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.RequiresApi;
import android.text.format.Formatter;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xzk
 * @data 2018/8/29
 * @email o-xiezhengkun@beyondsoft.com
 * @remark 获取app基本信息并封装发送
 */
public class AppInfoUtils {

//    /**
//     * 获取基本数据并组装app信息
//     *
//     * @return
//     */
//    public static AppInfo assembleAppInfo() throws Exception {
//        AppInfo appInfo = new AppInfo();
//        MyApplication instance = MyApplication.getInstance();
//        appInfo.setShopId(instance.getShopData().shopId);
//        appInfo.setStoreId(instance.getShopData().storeId);
//        appInfo.setAppVersion(AppHelper.getVersionName(instance) + "-build");
//        appInfo.setAppName(instance.getResources().getString(R.string.app_name));
//        appInfo.setDeviceCompanyInfo(android.os.Build.BRAND);
//        appInfo.setDeviceSystemVersion(android.os.Build.VERSION.RELEASE);
//        appInfo.setDeviceType(android.os.Build.MODEL);
//
//        String logFilePath = ServiceFactory.getAppService().getFilePath("log");
//        long folderSize = getFolderSize(new File(logFilePath));
//        String fileSize = Formatter.formatFileSize(instance, folderSize);
//        appInfo.setAppLogSize(fileSize);
//
//        appInfo.setDeviceId(getUniqueID(instance));
//        appInfo.setDeviceNetworkInfo(DeviceInfoUtil.getLocalIpAddress());
//        // 本方式不一定可行待测试（目前，流程上可行）
//        String cppDataSize = PrefUtils.getString(instance, MyConstants.SP_APP_SIZE, "0M");
//        appInfo.setAppDataSize(cppDataSize);
//
//        appInfo.setAppPrinterInfo(getPrinterInfo());
//        //        appInfo.setDeviceCpuInfo(getCpuName());
//
//        appInfo.setDeviceCpuInfo(getCpuInfo());
//
//        ActivityManager am = (ActivityManager) instance.getSystemService(Context.ACTIVITY_SERVICE);
//        ActivityManager.MemoryInfo outInfo = new ActivityManager.MemoryInfo();
//        am.getMemoryInfo(outInfo);
//        long totalMem = outInfo.totalMem;
//        appInfo.setDeviceMemoryInfo(Formatter.formatFileSize(instance, totalMem));
//
//        AppInfo.DeviceDiskInfo deviceDiskInfo = new AppInfo.DeviceDiskInfo();
//        long memorySize = getTotalExternalMemorySize();
//        long lUsed = getUsedSpace();
//        deviceDiskInfo.setTotal(Formatter.formatFileSize(instance, memorySize));
//        deviceDiskInfo.setUsed(Formatter.formatFileSize(instance, lUsed));
//        appInfo.setDeviceDiskInfo(deviceDiskInfo);
//
//        String createTime = PrefUtils.getString(instance, MyConstants.SP_APP_CREATE_TIME, "null");
//        appInfo.setCreateTime(createTime);
//        String updateTime = PrefUtils.getString(instance, MyConstants.SP_APP_UPDATE_TIME, "null");
//        appInfo.setUpdateTime(updateTime);
//
//        return appInfo;
//    }

    /**
     * 获取目标cpu情况
     *
     * @return
     */
    public static String getCpuInfo() {
        StringBuilder sbr = new StringBuilder();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            String[] supportedAbis = Build.SUPPORTED_ABIS;
            if (supportedAbis != null && supportedAbis.length > 1) {
                sbr.append(supportedAbis[0]+ ":" + Runtime.getRuntime().availableProcessors()+"核");
            }
        }else {
            sbr.append(Build.CPU_ABI + ":" + Runtime.getRuntime().availableProcessors()+"核");
        }
        return sbr.toString();
    }

    /**
     * 判断SD卡是否可用
     *
     * @return true : 可用<br>false : 不可用
     */
    public static boolean isSDCardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 获取手机外部总空间大小
     *
     * @return 总大小，字节为单位
     */
    public static long getTotalExternalMemorySize() {
        if (isSDCardEnable()) {
            //获取SDCard根目录
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            return totalBlocks * blockSize;
        } else {
            return -1;
        }
    }

    /**
     * 获取SD卡剩余空间
     *
     * @return SD卡剩余空间
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static long getUsedSpace() {
        if (!isSDCardEnable()) {
            return 0;
        }
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        /*获取block的SIZE*/
        long blockSize = stat.getBlockSize();
        /*空闲的Block的数量*/
        long availableBlocks = stat.getAvailableBlocks();
        long totalBlocks = stat.getBlockCount();
        long size = (totalBlocks - availableBlocks) * blockSize;
        return size;
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

    /**
     * 获取CPU型号
     *
     * @return
     */
    public static String getCpuName() {
        String str1 = "/proc/cpuinfo";
        String str2 = "";
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr);
            while ((str2 = localBufferedReader.readLine()) != null) {
                if (str2.contains("Hardware")) {
                    return str2.split(":")[1];
                }
            }
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return null;
    }


    /**
     * 获得文件大小
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    //    /**
    //     * The IMEI: 仅仅只对Android手机有效
    //     * 采用此种方法，需要在AndroidManifest.xml中加入一个许可：android.permission.READ_PHONE_STATE，并且用
    //     * 户应当允许安装此应用。作为手机来讲，IMEI是唯一的，它应该类似于 359881030314356（除非你有一个没有量产的手
    //     * 机（水货）它可能有无效的IMEI，如：0000000000000）。
    //     *
    //     * @return imei
    //     */
    //    public static String getIMEI(Context mContext) {
    //        TelephonyManager TelephonyMgr = (TelephonyManager) mContext.getApplicationContext().getSystemService(
    //            Context.TELEPHONY_SERVICE);
    //        String szImei = TelephonyMgr.getDeviceId();
    //        return szImei;
    //    }

    /*
     * @return PesudoUniqueID
     */
    public static String getPesudoUniqueID() {
        //we make this look like a valid IMEI
        String m_szDevIDShort =
            "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 +
            Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
            Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 +
            Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
            Build.USER.length() % 10; //13 digits
        return m_szDevIDShort;
    }

    /*
     * return  m_szWLANMAC
     */
    public static String getWLANMACAddress(Context mContext) {
        WifiManager wm = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
        return m_szWLANMAC;
    }

    /*
     * @return
     */
    public static String getUniqueID(Context mContext) {
        String m_szLongID = getPesudoUniqueID() + getWLANMACAddress(mContext);
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
        byte p_md5Data[] = m.digest();
        String m_szUniqueID = new String();
        for (int i = 0; i < p_md5Data.length; i++) {
            int b = (0xFF & p_md5Data[i]);
            if (b <= 0xF) {
                m_szUniqueID += "0";
            }
            m_szUniqueID += Integer.toHexString(b);
        }
        m_szUniqueID = m_szUniqueID.toUpperCase();
        return m_szUniqueID;
    }

}
