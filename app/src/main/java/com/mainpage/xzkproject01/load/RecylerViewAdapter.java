package com.mainpage.xzkproject01.load;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mainpage.xzkproject01.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AnimTextView.OnLoadListener {
    private List<String> list;
    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView
    private AnimTextView animTextViewxt;
    private LoadingAdpViewInf viewInf;

    public RecylerViewAdapter(LoadingAdpViewInf viewInf, List<String> list) {
        this.viewInf = viewInf;
        this.list = list;
    }

    private void setAnimTextViewxt(AnimTextView animTextViewxt) {
        this.animTextViewxt = animTextViewxt;
    }

    public void stopLoad() {
        Log.i("tags", "adp停止动画");
        if (animTextViewxt != null)
            animTextViewxt.stopAnimWait();
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() == position + 1)
            return TYPE_FOOTER;//最后一个是加载的布局
        else
            return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(viewInf.getSelfContext()).inflate(android.R.layout.simple_list_item_1, null);
            ViewHolderS s = new ViewHolderS(v);
            return s;
        } else if (viewType == TYPE_FOOTER) {
            View v = LayoutInflater.from(viewInf.getSelfContext()).inflate(R.layout.footer_loading, null);
            FootViewHolder s = new FootViewHolder(v);
            return s;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderS) {
            String s = list.get(position);
            ((ViewHolderS) holder).txt.setText(s + "");
        } else if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            if (!footViewHolder.animTextViewxt.isRunning()) {
                footViewHolder.animTextViewxt.startLoadAnim();
                Log.i("tags", "发起加载请求");
                footViewHolder.animTextViewxt.setOnLoadListener(this);
                setAnimTextViewxt(footViewHolder.animTextViewxt);//化为代理类,代理对象来处理事情
                viewInf.getDataFromNet();
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }


    @Override
    public void onLoad() {//最后的刷新是强制控制在动画结束之后,.....这才是坑啊
        Log.i("tags", "刷新适配器");
//        notifyDataSetChanged();
// 加载完成,刷新适配器//表示当前一直会刷新到最后一个
        //表示每次notify,都是一个加载onBinderHolder的问题,就表示会重复加载动画,,,,
        //动画的ui变化,会触动recyle的notyfy,如果不更新ui呢?
    }

    public void recylerAdp() {
        if (animTextViewxt != null) {
            animTextViewxt.recycleAnimView();
            animTextViewxt = null;
        }
    }

    class ViewHolderS extends RecyclerView.ViewHolder {
        TextView txt;

        public ViewHolderS(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }


    class FootViewHolder extends RecyclerView.ViewHolder {

        AnimTextView animTextViewxt;

        public FootViewHolder(View itemView) {
            super(itemView);
            animTextViewxt = (AnimTextView) itemView.findViewById(R.id.anim_txt);
        }
    }
}
