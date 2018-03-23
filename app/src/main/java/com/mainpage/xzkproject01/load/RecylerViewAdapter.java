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
    private boolean allowLoad = true;//是否允许加载的标记
    private int listSize = 0;//作为标记

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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (onItemClickListener != null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("tags", "点击item");
                    onItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        if (holder instanceof ViewHolderS) {
            String s = list.get(position);
            ((ViewHolderS) holder).txt.setText(s + "");
        } else if (holder instanceof FootViewHolder) {
            final FootViewHolder footViewHolder = (FootViewHolder) holder;
            if (!footViewHolder.animTextViewxt.isRunning()) {
                if (allowLoad) {
                    Log.i("tags", "发起加载请求");
                    footViewHolder.animTextViewxt.startLoadAnim();//开启动画
                    viewInf.getDataFromNet();//发起请求
                    if (footViewHolder.animTextViewxt.getOnLoadListener() == null) {
                        footViewHolder.animTextViewxt.setOnLoadListener(this);
                        setAnimTextViewxt(footViewHolder.animTextViewxt);//化为代理类,代理对象来处理事情
                    }
                } else {
                    footViewHolder.animTextViewxt.setCompleteText("没数据,不加载!");
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    // 加载完成,刷新适配器//表示当前一直会刷新到最后一个
    //表示每次notify,都是一个加载onBinderHolder的问题,就表示会重复加载动画,,,,
    //动画的ui变化,会触动recyle的notyfy,如果不更新ui呢?
    @Override
    public void onLoad() {//最后的刷新是强制控制在动画结束之后,.....这才是坑啊
        Log.i("tags", "刷新适配器");
        if (list.size() > 0) {
            if (listSize != list.size()) {
//            allowLoad
                notifyDataSetChanged();
                listSize = list.size();
            } else {
                allowLoad = false;
            }
        }
    }

    public void recylerAdp() {
        if (animTextViewxt != null) {
            animTextViewxt.recycleAnimView();
            animTextViewxt = null;
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
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
