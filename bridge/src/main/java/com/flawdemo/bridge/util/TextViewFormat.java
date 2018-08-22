package com.flawdemo.bridge.util;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

/**
 * @author xzk
 * @data 2018/8/22
 * @remark textView显示时，特殊需求，大小，颜色，下划线
 */
public class TextViewFormat {

    /**
     * 实例
     *
     * @param tv_test
     * @param start
     * @param end
     * @param size
     */
    public static void changeTextColorSize(TextView tv_test, int start, int end, int size) {
        ColorStateList redColors = ColorStateList.valueOf(0xffff0000);
        SpannableStringBuilder spanBuilder = new SpannableStringBuilder("这是一个测试");
        //style 为0 即是正常的，还有Typeface.BOLD(粗体) Typeface.ITALIC(斜体)等
        //size  为0 即采用原始的正常的 size大小
        spanBuilder.setSpan(new TextAppearanceSpan(null, Typeface.NORMAL, size, redColors, null), start, end,
                            Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        tv_test.setText(spanBuilder);
    }

    /**
     * 改变 目标字符串 为对应大小
     *
     * @param targetMsg
     * @param multiplyingPower 字体大小倍率，暂无具体字体大小指定
     * @param start            起始位置
     * @param end              结束位置
     * @return
     */
    public static SpannableStringBuilder changeTextPartSize(String targetMsg, int multiplyingPower, int start,
                                                            int end) {
        if (end > targetMsg.length()) {
            end = targetMsg.length();
        }
        if (start < 0) {
            start = 0;
        }
        SpannableStringBuilder ssb = new SpannableStringBuilder(targetMsg);
        ssb.setSpan(new RelativeSizeSpan(multiplyingPower), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    /**
     * 改变 目标字符串 为对应颜色
     */
    public static SpannableStringBuilder changeTextPartColor(String targetMsg, int color, int start, int end) {
        if (end > targetMsg.length()) {
            end = targetMsg.length();
        }
        if (start < 0) {
            start = 0;
        }
        SpannableStringBuilder ssb = new SpannableStringBuilder(targetMsg);
        ssb.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    /**
     * 给目标字体增加下划线（可设定长度）
     *
     * @param targetMsg
     * @param start
     * @param end
     * @return
     */
    public static SpannableString setTextPartUnLine(String targetMsg, int start, int end) {
        if (end > targetMsg.length()) {
            end = targetMsg.length();
        }
        if (start < 0) {
            start = 0;
        }
        SpannableString content = new SpannableString(targetMsg);
        content.setSpan(new UnderlineSpan(), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return content;
    }

    /**
     * 给目标字体增加下划线(个体textView)
     */
    public static void setTextUnLine(TextView txt) {
        if (txt == null) {
            return;
        }
        //下划线
        txt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //抗锯齿
        txt.getPaint().setAntiAlias(true);
        //  范例方法二
        //        TextView textView = (TextView)findViewById(R.id.tv_test);
        //        textView.setText(Html.fromHtml("<u>"+"0123456"+"</u>"));
    }

}
