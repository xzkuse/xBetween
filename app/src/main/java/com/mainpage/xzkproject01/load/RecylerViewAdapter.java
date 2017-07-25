package com.mainpage.xzkproject01.load;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mainpage.xzkproject01.R;

import java.util.List;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> list;
    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView

    public RecylerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
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
            View v = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null);
            ViewHolderS s = new ViewHolderS(v);
            return s;
        } else if (viewType == TYPE_FOOTER) {
            View v = LayoutInflater.from(context).inflate(R.layout.footer_loading, null);
            FootViewHolder s = new FootViewHolder(v);
            return s;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolderS){
            String s = list.get(position);
            ((ViewHolderS)holder).txt.setText(s + "");
        }else if(holder instanceof FootViewHolder){

        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    class ViewHolderS extends RecyclerView.ViewHolder {
        TextView txt;
        public ViewHolderS(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    class FootViewHolder extends RecyclerView.ViewHolder{

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }
}
