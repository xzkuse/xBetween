package com.mainpage.xzkproject01.view;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mainpage.xzkproject01.AppBase.BaseActivity;
import com.mainpage.xzkproject01.R;
import com.mainpage.xzkproject01.view.webview.MyWebViewClient;

public class WebviewActivity extends BaseActivity {

    private WebView wbView;
    private String url="www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        wbView = findViewById(R.id.wb_view);

        initWebViewAttrs();
    }

    private void initWebViewAttrs() {
        WebSettings webSettings = wbView.getSettings();

        //设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //设置支持缩放
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.supportMultipleWindows();
        webSettings.setAllowContentAccess(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLoadsImagesAutomatically(true);
        //这行最好不要丢掉
        wbView.setWebChromeClient(new WebChromeClient());

        wbView.loadUrl(url);

        wbView.setWebViewClient(new MyWebViewClient());

    }
}
