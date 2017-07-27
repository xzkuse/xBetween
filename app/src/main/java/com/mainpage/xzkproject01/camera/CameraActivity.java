package com.mainpage.xzkproject01.camera;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.mainpage.xzkproject01.R;

import java.util.Timer;

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


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.activity_camera);
        builder.show();
    }

    private void iniStoggle() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
