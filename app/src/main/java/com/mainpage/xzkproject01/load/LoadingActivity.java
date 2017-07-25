package com.mainpage.xzkproject01.load;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mainpage.xzkproject01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * create: 2017/7/25 0025
 * auther: xzk
 * class: LoadingActivity
 * function: 1.最普通的加载方式
 */
public class LoadingActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView contentList;

    private Handler handler = new Handler();
    private LinearLayout linearLoadingBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        contentList = (RecyclerView) findViewById(R.id.recyler_content_list);
        linearLoadingBox = (LinearLayout) findViewById(R.id.linear_loading_box);

        initSwipLayout();
        initRecyler();
    }

    private void initRecyler() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("加+" + i);
        }
        LinearLayoutManager linerManager = new LinearLayoutManager(this);
        contentList.setLayoutManager(linerManager);
        RecylerViewAdapter adp = new RecylerViewAdapter(this, list);
        contentList.setAdapter(adp);
//        contentList.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                int totalItemCount = layoutManager.getItemCount();
//                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
////                Log.i("tags", "滚动时:" + totalItemCount + ",,," + lastVisibleItem);
//                if (!loading && totalItemCount == (lastVisibleItem + 1)) {
//                    linearLoadingBox.scrollBy(0,(int) getResources().getDimension(R.dimen.DIMEN_100PX_s));
//                    loading = true;
//                    startLoad();
//                    Log.i("tags", "开始加载:");
//                }
//            }
//        });
    }

    private boolean loading;

    public void startLoad() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                linearLoadingBox.scrollBy(0,(int) getResources().getDimension(R.dimen.DIMEN_100PX));
                loading = false;
            }
        }, 3 * 1000);
    }

    private void initSwipLayout() {
        swipeRefresh.setColorSchemeResources(R.color.colorRed01, R.color.colorYello01
                , R.color.colorblue01, R.color.colorRed02);
        //滑动过程是受影响的,包括下拉的进度值,线性值
        //100,0---下拉时,进度条向上飞  true,代表是否执行缩放动画  start,进度条起始位置   end表示滑动之后最终停留的位置(可以拉过,但是阻尼值会越来越大)
        swipeRefresh.setProgressViewOffset(true, 2, 100);//true,第一次进来显示进度条?不是,进来的时候并不会直接显示进度条
        swipeRefresh.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefresh.setRefreshing(false);
            }
        }, 3 * 1000);
    }
}
