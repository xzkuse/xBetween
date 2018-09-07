package com.flawdemo.bridge.util.fileServer;

import java.io.File;

/**
 * @author xzk
 * @data 2018/9/7
 * @remark  文件操作管理  地址，类型，
 */
public class FileUtils {

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

}
