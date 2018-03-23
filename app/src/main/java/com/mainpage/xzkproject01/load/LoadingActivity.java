package com.mainpage.xzkproject01.load;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
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
import android.widget.RelativeLayout;

import com.mainpage.xzkproject01.MainActivity;
import com.mainpage.xzkproject01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * create: 2017/7/25 0025
 * auther: xzk
 * class: LoadingActivity
 * function: 1.最普通的加载方式
 */
public class LoadingActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener, LoadingViewInf, LoadingAdpViewInf {

    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView contentList;

    private Handler handler = new Handler();
    private RecylerViewAdapter adp;
    private List<String> list;
    private LoadingInf loadingInf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        contentList = (RecyclerView) findViewById(R.id.recyler_content_list);

        initSwipLayout();
        initRecyler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        activityManager.getAppTaskThumbnailSize();
        List<ActivityManager.RunningTaskInfo> tasks = activityManager.getRunningTasks(100);
        Log.i("tags", "1act的任务数量:" + tasks.size());
        for (int i = 0; i < tasks.size(); i++) {
            ActivityManager.RunningTaskInfo taskInfo = tasks.get(i);
            Log.i("tags", "1act的名称:" + taskInfo.baseActivity.getPackageName() + taskInfo.baseActivity.getClassName());
        }
//            activityManager.(mPackages[i]);
    }

    private void initRecyler() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("加+" + i);
        }
        loadingInf = new LoadingPresenter(this);
        LinearLayoutManager linerManager = new LinearLayoutManager(this);
        contentList.setLayoutManager(linerManager);
        adp = new RecylerViewAdapter(this, list);
        contentList.setAdapter(adp);
        adp.setOnItemClickListener(new RecylerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
//                startActivity(intent);
//                ActivityManager am = (ActivityManager)getSystemService (Context.ACTIVITY_SERVICE);
//                am.restartPackage(getPackageName());
//                系统会将，该包下的 ，所有进程，服务，全部杀掉，就可以杀干净了，要注意加上
//                        <uses-permission android:name=\"android.permission.RESTART_PACKAGES\"></uses-permission>
                Intent intent = new Intent();
                intent.setClass(LoadingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //注意本行的FLAG设置
                startActivity(intent);
            }
        });
    }

    private void initSwipLayout() {
        swipeRefresh.setColorSchemeResources(R.color.colorRed01, R.color.colorYello01
                , R.color.colorblue01, R.color.colorRed02);
        //滑动过程是受影响的,包括下拉的进度值,线性值
        //100,0---下拉时,进度条向上飞  true,代表是否执行缩放动画  start,进度条起始位置   end表示滑动之后最终停留的位置(可以拉过,但是阻尼值会越来越大)
        swipeRefresh.setProgressViewOffset(true, 2, 200);//true,第一次进来显示进度条?不是,进来的时候并不会直接显示进度条
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

    @Override
    public void showDatas(List<String> datas) {
        Log.i("tags", "act收到数据");
        list.addAll(datas);
        adp.stopLoad();
    }

    @Override
    public Context getSelfContext() {
        return this;
    }

    @Override
    public void getDataFromNet() {
        Log.i("tags", "开始加载数据:");
        loadingInf.getDataFromData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adp != null) {
            adp.recylerAdp();
            adp = null;
        }
    }
}

//滚动监听,晚点再说
////            contentList.addOnScrollListener(new RecyclerView.OnScrollListener() {
////
////                @Override
////                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
////                    super.onScrolled(recyclerView, dx, dy);
////                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
////                    int totalItemCount = layoutManager.getItemCount();
////                    int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//////                Log.i("tags", "滚动时:" + totalItemCount + ",,," + lastVisibleItem);
////                    if (!loading && totalItemCount == (lastVisibleItem + 1)) {
//////                    linearLoadingBox.scrollBy(0, (int) getResources().getDimension(R.dimen.DIMEN_100PX_s));
////
////                        loading = true;
////                        startLoad();
////                        Log.i("tags", "开始加载:");
////                    }
////                }
////            });