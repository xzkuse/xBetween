package com.flawdemo.bridge.util;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xzk
 * @data 2018/8/22
 * @remark  格式化字符串
 */
public class StringFormat {

    /**
     * 将带有 %s 的字符串 插入目标字符
     *
     * @param strWithS
     * @param targetStr
     * @return
     */
    public static String strFormat(String strWithS, String... targetStr) {
        return String.format(strWithS, targetStr);
    }

    /**
     * 给价格后面默认增加  .00
     */
    public static String transfer(double param) {
        double tmp = Math.floor(param);
        System.out.println(tmp);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(tmp);
    }

    /**
     * 金额格式化
     *
     * @param s   金额
     * @param len 小数位数
     * @return 格式后的金额
     */
    public static String insertComma(String s, int len) {
        if (s == null || s.length() < 1) {
            return "";
        }
        NumberFormat formater = null;
        double num = Double.parseDouble(s);
        if (len == 0) {
            formater = new DecimalFormat("###,###");
        } else {
            StringBuffer buff = new StringBuffer();
            buff.append("###,###.");
            for (int i = 0; i < len; i++) {
                buff.append("#");
            }
            formater = new DecimalFormat(buff.toString());
        }
        return formater.format(num);
    }

    /**
     * 金额去掉“,”
     *
     * @param s 金额
     * @return 去掉“,”后的金额
     */
    public static String delComma(String s) {
        String formatString = "";
        if (s != null && s.length() >= 1) {
            formatString = s.replaceAll(",", "");
        }
        return formatString;
    }


    /**
     * 验证金额格式  非0开头，小数点后两位，
     * @param money  金额
     * @return
     */
    public static boolean isMoney(String money){
        if(TextUtils.isEmpty(money)){
            return false;
        }
        Pattern pattern= Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        Matcher match=pattern.matcher(money);
        if(!match.matches()){
            return true;
        }else{
            return false;
        }
        //下面这种写法无效
        //return !money.matches("^(([1-9]{1}\\\\d*)|([0]{1}))(\\\\.(\\\\d){0,2})?$");
    }
}
