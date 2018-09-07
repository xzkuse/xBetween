package com.flawdemo.bridge.util.fileServer;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * @author xzk
 * @data 2018/9/7
 * @remark  sd卡操作类 ，外置，内置
 */
public class SDCardUtils {


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
}
