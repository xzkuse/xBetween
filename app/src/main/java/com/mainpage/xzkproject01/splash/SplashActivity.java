package com.mainpage.xzkproject01.splash;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.flawdemo.bridge.log.LogUtils;
import com.flawdemo.bridge.util.ToastUtils;
import com.mainpage.xzkproject01.AppBase.BaseActivity;
import com.mainpage.xzkproject01.R;

/**
 * @author xzk
 * @data 2018/11/16
 * @email
 * @remark 项目初始化页面
 */
public class SplashActivity extends BaseActivity {

    private SimpleDraweeView simpleDraweeView;
//    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542370941227&di=4806c6f4b3cffb5613be6c7861f2o.jpg";
    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542370941227&di=4806c6f4b3cffb5613be6c7861fb5dde&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01fde75678955a32f8759f0423274e.jpg%402o.jpg";

    private Button butEnterIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        //创建SimpleDraweeView对象
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.dra_view);
        butEnterIn = findViewById(R.id.but_enter_in);
        initLoadingImage();

    }

    private void initLoadingImage() {
        //创建将要下载的图片的URI
        Uri imageUri = Uri.parse(url);
        //开始下载
        simpleDraweeView.setImageURI(imageUri);
        ControllerListener controllerListener = new BaseControllerListener(){
            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                LogUtils.d("图片加载成功");
                Animation animation = new AlphaAnimation(0f,1.0f);
                animation.setDuration(5000);
                animation.setFillAfter(true);
                butEnterIn.startAnimation(animation);
            }
            @Override
            public void onFailure(String id, Throwable throwable) {
                LogUtils.d("图片加载失败");
            }

        };
        //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                                            //重试之后要加载的图片URI地址
                                            .setUri(imageUri)
                                            //设置点击重试是否开启
                                            .setTapToRetryEnabled(false)
                                            //设置旧的Controller
                                            .setOldController(simpleDraweeView.getController())
                                            .setControllerListener(controllerListener)
                                            //构建
                                            .build();
        //设置DraweeController
        simpleDraweeView.setController(controller);
    }


}
