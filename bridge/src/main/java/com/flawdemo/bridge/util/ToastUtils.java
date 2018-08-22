package com.flawdemo.bridge.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.flawdemo.bridge.R;
import com.flawdemo.bridge.log.LogUtils;

/**
 * 设置自定义样式土司
 */
public final class ToastUtils {

    static Context mContext;
    private static Toast toast;

//    /**
//     * @remark 根据错误信息 key 动态 显示 字符
//     */
//    public static void showErrorMsgToast(String msg) {
//        try {
//            Integer showStrId;
//            if (TextUtils.isEmpty(msg)) {
//                showStrId = R.string.key_system_error;
//            } else {
//                showStrId = mContext.getResources().getIdentifier(msg, "string", AppHelper.getPackgeName(mContext));
//            }
//            if (showStrId == 0) {
//                showStrId = R.string.key_system_error;
//            }
//            makeToastView(mContext.getString(showStrId));
//            toast.show();
//        } catch (Exception e) {
//            LogUtils.e(e);
//        }
//    }

    //            if (toast == null) {
    //                toast = Toast.makeText(mContext, msgId, Toast.LENGTH_SHORT);
    //            } else {
    //                toast.setText(mContext.getString(msgId));
    //            }
    /**
     * @author John.Gu
     * @email guqinghong@beyondsoft.com
     * @remark 根据字符 id  显示 字符
     */
    public static void showStringIdToast(int msgId) {
        try {
            makeToastView(msgId);
            toast.show();
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    /**
     * @author John.Gu
     * @email guqinghong@beyondsoft.com
     * @remark 显示 字符
     */
    public static void showStringToast(String msg) {
        try {
            makeToastView(msg);
            toast.show();
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    /**
     * 输入字符串内容
     *
     * @param msgContent
     */
    private static void makeToastView(String msgContent) {
        if (toast == null) {
            View toastView = LayoutInflater.from(mContext).inflate(R.layout.util_toast_default, null);
            TextView viewById = (TextView) toastView.findViewById(R.id.txt_toast_msg);
            viewById.setText(msgContent);
            toast = new Toast(mContext);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastView);
            setGravity(Gravity.CENTER, 0, 0);
        } else {
            setText(msgContent);
        }
    }

    /**
     * 输入 资源id
     *
     * @param msgID
     */
    private static void makeToastView(@StringRes int msgID) {
        makeToastView(mContext.getString(msgID));
    }

    /**
     * 设置toast字体
     *
     * @param s
     */
    private static void setText(CharSequence s) {
        if (toast.getView() == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView tv = (TextView) toast.getView().findViewById(R.id.txt_toast_msg);
        if (tv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
    }

    /**
     * 设置 toast 位置
     *
     * @param gravity
     * @param xOffset
     * @param yOffset
     */
    public static void setGravity(int gravity, int xOffset, int yOffset) {
        if (toast != null) {
            toast.setGravity(gravity, xOffset, yOffset);
        }
    }
}
