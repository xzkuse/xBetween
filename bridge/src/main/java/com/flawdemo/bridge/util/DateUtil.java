package com.flawdemo.bridge.util;

import com.flawdemo.bridge.log.LogUtils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author xzk
 * @data 2018/8/22
 * @remark 时间格式化类
 */
public final class DateUtil {

    public static SimpleDateFormat fmtYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat fmtYMD = new SimpleDateFormat("yyyy-MM-dd");

    public static String DATE_HHMMSS_12 = "hh:mm:ss";
    public static String DATE_HHMMSS_24 = "HH:mm:ss";
    public static String DATE_YYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT_DATE = "yyyy-MM-dd";
    public static final String DEFAULT_FORMAT_TIME = "HH:mm:ss";
    public static final String DEFAULT_FORMAT_TIME_HH_MM = "HH:mm";

    public static final ThreadLocal<SimpleDateFormat> defaultDateTimeFormat = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String getDateTimeFromMillis(long timeInMillis) {
        return getDateTimeFormat(new Date(timeInMillis));
    }

    public static String getDateTimeFormat(Date date) {
        return dateSimpleFormat(date, (SimpleDateFormat) defaultDateTimeFormat.get());
    }

    public static String dateSimpleFormat(Date date, SimpleDateFormat format) {
        if (format == null) {
            format = (SimpleDateFormat) defaultDateTimeFormat.get();
        }
        return date == null ? "" : format.format(date);
    }

    /**
     * 时间戳转固定格式时间字符
     *
     * @param timeStamp
     * @param format
     * @return
     */
    public static String getStrTime(long timeStamp, String format) {
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        long l = Long.valueOf(timeStamp);
        timeString = sdf.format(new Date(l));
        return timeString;
    }

    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Time beginTime, Time endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过服务器给的标准时间 转换成 设备本地时区的时间
     *
     * @param dateTime 比如 2018-07-02 10:00:00
     * @return
     */
    public static String getDateTimeOfTimestamp(String dateTime) {
        try {
            fmtYMDHMS.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = fmtYMDHMS.parse(dateTime);
            fmtYMDHMS.setTimeZone(TimeZone.getDefault());
            return fmtYMDHMS.format(date);
        } catch (ParseException e) {
            LogUtils.e(e);
        }
        return dateTime;
    }

    /**
     * 通过服务器给的标准时间 转换成 设备本地时区的时间
     *
     * @param dateTime 比如 2018-07-02 10:00:00
     * @return
     */
    public static String getDateOfTimestamp(String dateTime) {
        try {
            fmtYMD.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = fmtYMD.parse(dateTime);
            fmtYMD.setTimeZone(TimeZone.getDefault());
            return fmtYMD.format(date);
        } catch (ParseException e) {
            LogUtils.e(e);
        }
        return dateTime;
    }

    /**
     *
     *
     * @param past
     * @return
     */
    /**
     * 获取过去第几天的日期
     * @param past   今天过去的目标天
     * @param strFormat  显示日期的格式化  yyyy-MM-dd
     * @return
     */
    public static String getPastDate(int past,String strFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        return format.format(today);
    }
}
