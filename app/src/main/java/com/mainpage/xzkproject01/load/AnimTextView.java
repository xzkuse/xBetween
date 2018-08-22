package com.mainpage.xzkproject01.load;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mainpage.xzkproject01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * create: 2017/7/26 0026
 * auther: xzk
 * class: AnimTextView
 * function: 1.单字跳动的动画
 */
public class AnimTextView extends LinearLayout {

    //    private ;
    private boolean isStart = true;//支持启动第一个动画
    private boolean isAnimRunning = false;//整个view是否在动画中

    //启动复用
    private ArrayList<TextView> loadTextList;
    private TextView loadCompelteText;
    private int delayTime = 100;
    private String strLoadComplete;
    private String loadText;
    private int intLoadTime;
    private AnimatorSet aniorSet;
    private AnimatorSet animoComplete;
    private ObjectAnimator newTxt;

    private OnLoadListener onLoadListener;

    public AnimTextView(Context context) {
        this(context, null, 0);
    }

    public AnimTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);//直接设置为水平布局

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimTextView);
        if (a != null) {
            strLoadComplete = a.getString(R.styleable.AnimTextView_completeText);
            loadText = a.getString(R.styleable.AnimTextView_loadText);
            intLoadTime = a.getInteger(R.styleable.AnimTextView_loadTextTime, 140);
            a.recycle();
        }
        loadTextList = new ArrayList<>();
        if (TextUtils.isEmpty(strLoadComplete))
            strLoadComplete = "加载完成";
        loadCompelteText = createTextView(strLoadComplete);
        if (TextUtils.isEmpty(loadText))
            loadText = "加载中...";
    }

    public AnimTextView.OnLoadListener getOnLoadListener() {
        return onLoadListener;
    }

    public void setOnLoadListener(AnimTextView.OnLoadListener onLoadListener) {
        this.onLoadListener = onLoadListener;
    }

    public void setCompleteText(String content) {
        if (TextUtils.isEmpty(content))
            return;
        loadCompelteText.setText(content);
    }

    //开始动画
    public void startLoadAnim() {
        if (loadTextList.size() == 0) {
            for (int i = 0; i < loadText.length(); i++) {
                String substr = loadText.substring(i, i + 1);
                TextView txt = createTextView(substr);
                loadTextList.add(txt);
                addView(loadTextList.get(i));
            }
        }
        Log.i("tags", "animView启动动画");
        hideCompleteView(loadCompelteText, true);
        for (int i = 0; i < loadTextList.size(); i++) {
            hideCompleteView(loadTextList.get(i), false);
            loadTextList.get(i).setScaleY(1.0f);
        }
        startTxtAnimation(); //开始每个txtView的对象的动画,要支持直接取消
    }

    //解决占位问题
    private void hideCompleteView(View tragetView, boolean hided) {
        if (hided) {
            tragetView.setVisibility(GONE);
        } else {
            tragetView.setVisibility(VISIBLE);
        }
    }

    //拦截重复加载动画的问题
    public boolean isRunning() {
        return isAnimRunning;
    }

    //阶段切分
    private void startTxtAnimation() {
        //是不是不能随便重新new?
        if (aniorSet == null) {
            aniorSet = new AnimatorSet();
            List<Animator> list = aniorSet.getChildAnimations();
            if (list == null) list = new ArrayList<>();
            else list.clear();
            for (int i = 0; i < getChildCount(); i++) {
                ObjectAnimator animator = setTxtAnim(getChildAt(i));
                list.add(animator);
            }
            aniorSet.playSequentially(list);
            aniorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    if (isStart) {//死循环动画
                        aniorSet.start();
                    } else {
                        Log.i("tags", "aniorSet动画完整结束onAnimationEnd");
                        loadCompleteAnimhide();//中间不能停止动画aniorSet.end(),只能直接开启下次动画?果然不死循环了
                    }
                }
            });
        }
        aniorSet.start();
        isAnimRunning = true;
    }

    private void loadCompleteAnimhide() {
        if (animoComplete == null) {
            animoComplete = new AnimatorSet();
            ArrayList<Animator> childAnimations = new ArrayList<>();
            for (int i = 0; i < getChildCount(); i++) {
                childAnimations.add(setTxtHideAnim(getChildAt(i)));
            }
            animoComplete.playTogether(childAnimations);
            //不支持二次循环,本次直接启动终结动画
            animoComplete.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
//                    super.onAnimationEnd(animation);//这句不会把所有的end全部加载了把,注释了之后,仍然会刷新数据
                    hideCompleteView(loadCompelteText, false);
                    for (int i = 0; i < loadTextList.size(); i++) {
                        hideCompleteView(loadTextList.get(i), true);
                    }
                    Log.i("tags", "animoComplete动画完整结束onAnimationEnd");
                    loadCompleteAnimShow();
                }
            });
        }
        animoComplete.start();
    }

    private void loadCompleteAnimShow() {
        if (loadCompelteText.getParent() == null)
            addView(loadCompelteText);//不能移除全部view
        if (newTxt == null) {
            newTxt = setTxtShowAnim(loadCompelteText);
            newTxt.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    isAnimRunning = false;//当前是否在动画运行时间
                    isStart = true;//启动下次无限循环
                    Log.i("tags", "newTxt动画完整结束onAnimationEnd");
                    if (onLoadListener != null)
                        onLoadListener.onLoad();
                }
            });
        }
        newTxt.start();
    }

    private TextView createTextView(String text) {
        TextView txt = new TextView(getContext());
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        txt.setText(text);
        txt.setLayoutParams(params);
        return txt;
    }

    private ObjectAnimator setTxtHideAnim(View childView) {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(childView, "scaleY", 1f, 0f);
        scaleY.setDuration(200);
        return scaleY;
    }

    private ObjectAnimator setTxtShowAnim(View childView) {
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(childView, "scaleY", 0f, 1f);
        scaleY.setDuration(300);
        return scaleY;
    }

    private ObjectAnimator setTxtAnim(View childView) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(childView, "translationY", 0, -30f, 0);
        animator.setDuration(intLoadTime);
        return animator;
    }

    public void stopAnimWait() {
        isStart = false;
        Log.i("tags", "等待之后再停止!");
    }

    /**
     * createTime: 2017/7/26 0026   method: recycleThisView
     * paramters: []
     * return: void
     * function:  1. 回收内部资源
     */
    public void recycleAnimView() {
        onLoadListener = null;//这里是切断与外部的联系
        if (aniorSet != null) {
            aniorSet.cancel();
            aniorSet = null;
        }
        if (animoComplete != null) {
            animoComplete.cancel();
            animoComplete = null;
        }
        if (newTxt != null) {
            newTxt.cancel();
            newTxt = null;
        }
        if (loadTextList != null) {
            loadTextList.clear();
            loadTextList = null;
        }
        if (loadCompelteText != null) {
            loadCompelteText = null;
        }
        removeAllViews();//清空所有的子view
    }


    public interface OnLoadListener {
        void onLoad();
    }
}
