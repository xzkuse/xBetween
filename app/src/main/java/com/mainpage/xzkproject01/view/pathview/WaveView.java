package com.mainpage.xzkproject01.view.pathview;

import android.content.Context;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 水波纹view
 */
public class WaveView extends View{
    public WaveView(Context context) {
        super(context, null, 0);
    }
    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }
    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){
        Path path=new Path();
        path.isEmpty();
    }
}
