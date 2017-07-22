package com.mainpage.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/7/20.
 */

public class SumMathUtil {

    private static int[] sumArray = new int[]{2, 10, 1, 4, 5, 7, 8, 3, 6, 9};

    //冒泡排序  从大到小排序
    public static void paoSort() {
        int temp = 0;
        for (int i = 0; i < sumArray.length - 1; i++) {
            for (int j = i + 1; j < sumArray.length; j++) {
                if (sumArray[i] < sumArray[j]) {
                    temp = sumArray[j];
                    sumArray[j] = sumArray[i];
                    sumArray[i] = temp;
                }
            }
        }
        String string = new String();
        for (int i = 0; i < sumArray.length; i++) {
            string = string + sumArray[i];
        }
        Log.i("tags", string + "数组:" + sumArray.toString());//10987654321数组:[I@41f51980
//        System.out.print(sumArray.toString());
        Log.i("tags", "目标4的位置：" + getTragetPosition(sumArray, 4));//目标4的位置：6
    }

    //二分查找方法
    public static int getTragetPosition(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int moddle = (low + high) / 2;
            if (key == arr[moddle])
                return moddle;
            if (key < arr[moddle])
                low = moddle + 1;
            if (key > arr[moddle])
                high = moddle - 1;
        }
        return -1;
    }

}
