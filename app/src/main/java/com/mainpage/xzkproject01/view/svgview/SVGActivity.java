package com.mainpage.xzkproject01.view.svgview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import com.mainpage.xzkproject01.R;

public class SVGActivity extends AppCompatActivity {
    static {
        //  为5.0以下支持svg图片展示做的兼容处理  代码中动态使用svg
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);
    }
}
