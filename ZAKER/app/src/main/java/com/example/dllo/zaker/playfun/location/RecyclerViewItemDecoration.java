package com.example.dllo.zaker.playfun.location;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/**
 * Created by yuxiaomin on 16/7/12.
 */
public class RecyclerViewItemDecoration extends ItemDecoration {


    //手动复写的方法
    //参数2.行布局
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        super.getItemOffsets(outRect, view, parent, state);
        //设置行布局上下左右的距离
        //行布局左侧有20像素的分割线
//        outRect.left = 20;
        //一般设置左右下,上通过判断view==0 来添加上的,否则第二行以后的所有间隙都会双倍
//        outRect.right = 20;
        outRect.bottom = 1;
    }

    //自定义画分割线
    @Override
    public void onDraw(Canvas c, RecyclerView parent, State state) {
        super.onDraw(c, parent, state);
        c.drawColor(Color.GREEN);
    }
}
