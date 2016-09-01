package com.example.dllo.zaker.subscription;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by dllo on 16/8/31.
 */
public class ScrollViewAndRecyclerView extends RecyclerView {
    public ScrollViewAndRecyclerView(Context context) {
        super(context);
    }

    public ScrollViewAndRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewAndRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);

    }
}