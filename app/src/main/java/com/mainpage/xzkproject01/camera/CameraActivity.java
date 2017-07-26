package com.mainpage.xzkproject01.camera;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mainpage.xzkproject01.R;

/**
 * create: 2017/7/26 0026
 * auther: xzk
 * class: CameraActivity
 * function: 1.启动自定义相机界面
 */
public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }
}
