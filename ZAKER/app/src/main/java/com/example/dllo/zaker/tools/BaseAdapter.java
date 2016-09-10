package com.example.dllo.zaker.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yuxiaomin on 16/9/5.
 *
 * 先写ViewHolder 在写这个
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private int layoutId;
    private List<T> datas;

    private onMyLinstener mOnMyLinstener;

    public BaseAdapter(Context context, int layoutId, List<T> datas) {
        mContext = context;
        this.layoutId = layoutId;
        this.datas = datas;
    }


    public void setOnMyLinstener(onMyLinstener onMyLinstener) {
        mOnMyLinstener = onMyLinstener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder holder = ViewHolder.createViewHolder(mContext, parent, layoutId);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        convert(holder, datas.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getAdapterPosition();

                mOnMyLinstener.onMyClick(v,pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public abstract void convert(ViewHolder holder, T t);


}
