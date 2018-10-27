package com.mainpage.xzkproject01.view.webview;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.flawdemo.bridge.log.LogUtils;

/**
 * @author xzk
 * @data 2018/10/13
 * @email o-xiezhengkun@beyondsoft.com
 * @remark
 */
public class MyWebViewClient extends WebViewClient {
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        return super.shouldOverrideUrlLoading(view,url);
//    }

    private String url="http://www.runoob.com/w3cnote/android-tutorial-listview-update.html";

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(url);//返回true代表在当前webview中打开，返回false表示打开浏览器
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        LogUtils.d("onPageStarted");
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        LogUtils.d("onPageFinished");
        super.onPageFinished(view, url);
    }

    //    @Override
//    public void onPageStarted(WebView view, String url, Bitmap favicon) {
//        if(!dialog.isShowing()) {
//            dialog.show();
//        }
//        super.onPageStarted(view, url, favicon);
//    }
//
//    @Override
//    public void onPageFinished(WebView view, String url) {
//        if(dialog.isShowing()){
//            dialog.dismiss();
//        }
//        super.onPageFinished(view, url);
//    }
}
