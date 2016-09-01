package com.example.dllo.zaker.subscription;


import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;

/**
 * Created by dllo on 16/8/31.
 */
public class MyItemDecoration  extends ItemDecoration{
    @Override
    public void onDraw(Canvas c, RecyclerView parent, State state) {
        super.onDraw(c, parent, state);

        c.drawColor( 0x10444703 );

    }

    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        //行布局左侧有20像素的分割线
        outRect.left=10;
        outRect.bottom=10;

    }
}
