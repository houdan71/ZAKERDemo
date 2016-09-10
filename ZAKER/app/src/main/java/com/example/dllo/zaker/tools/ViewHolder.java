package com.example.dllo.zaker.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by yuxiaomin on 16/9/5.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;


    private View mView;

    private SparseArray<View> mViewSparseArray;

    public ViewHolder(View itemView) {
        super(itemView);
    }

    public ViewHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;
        mView = itemView;
        mViewSparseArray = new SparseArray<>();
    }

    public static ViewHolder createViewHolder(Context context, ViewGroup parent, int layoutId) {
        //加载行布局
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        ViewHolder holder = new ViewHolder(itemView, context);
        return holder;
    }

    /**
     * 通过id 获取我们想要的View
     *
     * @param layoutId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int layoutId) {
        View view = mViewSparseArray.get(layoutId);
        if (view == null) {
            view = mView.findViewById(layoutId);
            mViewSparseArray.put(layoutId, view);
        }
        return (T) view;
    }

    public ViewHolder setText(int id,String s,int position){

        TextView textView = getView(id);
        textView.setText(s);
        return this;
    }

    public ViewHolder setImg(int id,String url){

        ImageView imageView = getView(id);
        Glide.with(mContext).load(url).into(imageView);
        return this;
    }

}
