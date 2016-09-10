package com.example.dllo.zaker.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by dllo on 16/9/9.
 */
public class MarqueeTextView extends TextView{

    private static final String TAG = "MarqueeTextView --> ***********";
    /** 是否停止滚动 */
    private boolean mStopMarquee;
    /** 需要跑马的文字 */
    private String mText;

    /**
     * 这是绘制文字的起点
     */
    private float mCoordinateX;
    /**
     * 这是文字的宽度
     */
    private float mTextWidth;

    public MarqueeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setText(String text) {
        //得到需要的文字
        this.mText = text;
        //得到文字的宽度
        mTextWidth = getPaint().measureText(mText);
        if (mHandler.hasMessages(0))
            mHandler.removeMessages(0);
        mHandler.sendEmptyMessageDelayed(0, 2000);
    }

    //方法在onDraw方法之前调用，也就是view还没有画出来的时候，可以在此方法中去执行一些初始化的操作
    //当此view附加到窗体上时调用该方法
    //发现onAttachedToWindow()在onResume()之后运行
    @Override
    protected void onAttachedToWindow() {
        mStopMarquee = false;
        if (mText != null)
            mHandler.sendEmptyMessageDelayed(0, 2000);
        super.onAttachedToWindow();
    }

    //onDetachedFromWindow()则在onDestory()之后才会调用,
    // 也就是我们销毁View的时候。我们写的这个View不再显示。这时我们就在这个方法做一些收尾工作
    //这里做一些onDestory()
    @Override
    protected void onDetachedFromWindow() {
        mStopMarquee = true;
        if (mHandler.hasMessages(0))
            mHandler.removeMessages(0);
        super.onDetachedFromWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mText != null)
            canvas.drawText(mText, mCoordinateX, 50, getPaint());
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    //Math.abs(): 取绝对值
                    if (Math.abs(mCoordinateX) > (mTextWidth)) {
                        mCoordinateX = 0;
                        invalidate(); //重新绘制
                        if (!mStopMarquee) {
                            sendEmptyMessageDelayed(0, 2000); //停顿一下
                        }
                    } else {
                        mCoordinateX -= 1;
                        invalidate(); //重新绘制
                        if (!mStopMarquee) {
                            sendEmptyMessageDelayed(0, 30); //跑马速度
                        }
                    }

                    break;
            }
            super.handleMessage(msg);
        }
    };

}

