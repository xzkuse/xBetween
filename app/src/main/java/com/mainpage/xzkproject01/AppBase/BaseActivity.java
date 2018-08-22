package com.mainpage.xzkproject01.AppBase;

import android.support.v7.app.AppCompatActivity;
import me.jessyan.autosize.internal.CustomAdapt;

/**
 * @author xzk
 * @data 2018/8/22
 * @remark  基类activity
 */
public abstract class BaseActivity extends AppCompatActivity implements CustomAdapt {

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return 667;
    }
}