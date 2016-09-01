package com.example.dllo.zaker.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by dllo on 16/8/22.
 */
public class ScrollViewAndListView extends ListView {
    public ScrollViewAndListView(Context context) {
        super(context);
    }

    public ScrollViewAndListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewAndListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
