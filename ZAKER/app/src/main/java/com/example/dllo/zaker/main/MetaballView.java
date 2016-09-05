package com.example.dllo.zaker.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dodola on 15/7/27.
 */
public class MetaballView extends View {

    private Paint paint = new Paint();
    private float handle_len_rate = 2f;
    //调节半径的
    private float radius = 30;
    //一个动,其余不动
    private final int ITEM_COUNT = 6;
    //两个球之间的距离
    private final int ITEM_DIVIDER = 60;
    //球放大的大小
    private final float SCALE_RATE = 0.3f;
    //从第一个球到最后一个球的长度
    private float maxLength;
    private ArrayList<Circle> circlePaths = new ArrayList<>();
    private float mInterpolatedTime;
    private MoveAnimation wa;
    private Circle circle;

    public MetaballView(Context context) {
        super(context);
        init();
    }

    public MetaballView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MetaballView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private class Circle {
        float[] center;
        //半径
        float radius;
    }

    //设置模式
    public void setPaintMode(int mode) {
        paint.setStyle(mode == 0 ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    private void init() {
        paint.setColor(0xfff53235);
        paint.setStyle(Paint.Style.FILL);
        //抗锯齿
        paint.setAntiAlias(true);
        //画第一个动的小球
        Circle circlePath = new Circle();
        circlePath.center = new float[]{(radius + ITEM_DIVIDER), radius * 1.4f};
        circlePath.radius = radius / 4 * 3;
        circlePaths.add(circlePath);

        //画之后的几个大圆
        for (int i = 1; i < ITEM_COUNT; i++) {
            circlePath = new Circle();
            circlePath.center = new float[]{(radius * 2 + ITEM_DIVIDER) * i, radius * 1.4f};
            circlePath.radius = radius;
            circlePaths.add(circlePath);
        }
        maxLength = (radius * 2 + ITEM_DIVIDER) * ITEM_COUNT;
    }

    private float[] getVector(float radians, float length) {
        float x = (float) (Math.cos(radians) * length);
        float y = (float) (Math.sin(radians) * length);
        return new float[]{
                x, y
        };
    }

    private class MoveAnimation extends Animation {

        //设置移动的动画效果
        //每次调用,参数interpolatedTime值都会变化，该参数从0渐 变为1，当该参数为1时表明动画结束
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            mInterpolatedTime = interpolatedTime;
            invalidate();
        }
    }

    /**
     * @param canvas          画布
     * @param j
     * @param i
     * @param v               控制两个圆连接时候长度，间接控制连接线的粗细，该值为1的时候连接线为直线
     * @param handle_len_rate
     * @param maxDistance
     */
    private void metaball(Canvas canvas, int j, int i, float v, float handle_len_rate, float maxDistance) {
        final Circle circle1 = circlePaths.get(i);
        final Circle circle2 = circlePaths.get(j);

        RectF ball1 = new RectF();
        ball1.left = circle1.center[0] - circle1.radius;
        ball1.top = circle1.center[1] - circle1.radius;
        ball1.right = ball1.left + circle1.radius * 2;
        ball1.bottom = ball1.top + circle1.radius * 2;

        RectF ball2 = new RectF();
        ball2.left = circle2.center[0] - circle2.radius;
        ball2.top = circle2.center[1] - circle2.radius;
        ball2.right = ball2.left + circle2.radius * 2;
        ball2.bottom = ball2.top + circle2.radius * 2;

        float[] center1 = new float[]{
                ball1.centerX(),
                ball1.centerY()
        };
        float[] center2 = new float[]{
                ball2.centerX(),
                ball2.centerY()
        };
        float d = getDistance(center1, center2);

        float radius1 = ball1.width() / 2;
        float radius2 = ball2.width() / 2;
        float pi2 = (float) (Math.PI / 2);
        float u1, u2;


        if (d > maxDistance) {
            canvas.drawCircle(ball1.centerX(), ball1.centerY(), circle1.radius, paint);
            canvas.drawCircle(ball2.centerX(), ball2.centerY(), circle2.radius, paint);
        } else {
            float scale2 = 1 + SCALE_RATE * (1 - d / maxDistance);
            float scale1 = 1 - SCALE_RATE * (1 - d / maxDistance);
            radius2 *= scale2;
//            radius1 *= scale1;
            canvas.drawCircle(ball1.centerX(), ball1.centerY(), radius1, paint);
            canvas.drawCircle(ball2.centerX(), ball2.centerY(), radius2, paint);

        }

        Log.d("Metaball_radius", "radius1:" + radius1 + ",radius2:" + radius2);
        if (radius1 == 0 || radius2 == 0) {
            return;
        }

        if (d > maxDistance || d <= Math.abs(radius1 - radius2)) {
            return;
        } else if (d < radius1 + radius2) {
            u1 = (float) Math.acos((radius1 * radius1 + d * d - radius2 * radius2) /
                    (2 * radius1 * d));
            u2 = (float) Math.acos((radius2 * radius2 + d * d - radius1 * radius1) /
                    (2 * radius2 * d));
        } else {
            u1 = 0;
            u2 = 0;
        }
        Log.d("Metaball", "center2:" + Arrays.toString(center2) + ",center1:" + Arrays.toString(center1));
        float[] centermin = new float[]{center2[0] - center1[0], center2[1] - center1[1]};

        float angle1 = (float) Math.atan2(centermin[1], centermin[0]);
        float angle2 = (float) Math.acos((radius1 - radius2) / d);
        float angle1a = angle1 + u1 + (angle2 - u1) * v;
        float angle1b = angle1 - u1 - (angle2 - u1) * v;
        float angle2a = (float) (angle1 + Math.PI - u2 - (Math.PI - u2 - angle2) * v);
        float angle2b = (float) (angle1 - Math.PI + u2 + (Math.PI - u2 - angle2) * v);

        Log.d("Metaball", "angle1:" + angle1 + ",angle2:" + angle2 + ",angle1a:" + angle1a + ",angle1b:" + angle1b + ",angle2a:" + angle2a + ",angle2b:" + angle2b);


        float[] p1a1 = getVector(angle1a, radius1);
        float[] p1b1 = getVector(angle1b, radius1);
        float[] p2a1 = getVector(angle2a, radius2);
        float[] p2b1 = getVector(angle2b, radius2);

        float[] p1a = new float[]{p1a1[0] + center1[0], p1a1[1] + center1[1]};
        float[] p1b = new float[]{p1b1[0] + center1[0], p1b1[1] + center1[1]};
        float[] p2a = new float[]{p2a1[0] + center2[0], p2a1[1] + center2[1]};
        float[] p2b = new float[]{p2b1[0] + center2[0], p2b1[1] + center2[1]};


        Log.d("Metaball", "p1a:" + Arrays.toString(p1a) + ",p1b:" + Arrays.toString(p1b) + ",p2a:" + Arrays.toString(p2a) + ",p2b:" + Arrays.toString(p2b));

        float[] p1_p2 = new float[]{p1a[0] - p2a[0], p1a[1] - p2a[1]};

        float totalRadius = (radius1 + radius2);
        float d2 = Math.min(v * handle_len_rate, getLength(p1_p2) / totalRadius);
        d2 *= Math.min(1, d * 2 / (radius1 + radius2));
        Log.d("Metaball", "d2:" + d2);
        radius1 *= d2;
        radius2 *= d2;

        float[] sp1 = getVector(angle1a - pi2, radius1);
        float[] sp2 = getVector(angle2a + pi2, radius2);
        float[] sp3 = getVector(angle2b - pi2, radius2);
        float[] sp4 = getVector(angle1b + pi2, radius1);
        Log.d("Metaball", "sp1:" + Arrays.toString(sp1) + ",sp2:" + Arrays.toString(sp2) + ",sp3:" + Arrays.toString(sp3) + ",sp4:" + Arrays.toString(sp4));


        Path path1 = new Path();
        path1.moveTo(p1a[0], p1a[1]);
        path1.cubicTo(p1a[0] + sp1[0], p1a[1] + sp1[1], p2a[0] + sp2[0], p2a[1] + sp2[1], p2a[0], p2a[1]);
        path1.lineTo(p2b[0], p2b[1]);
        path1.cubicTo(p2b[0] + sp3[0], p2b[1] + sp3[1], p1b[0] + sp4[0], p1b[1] + sp4[1], p1b[0], p1b[1]);
        path1.lineTo(p1a[0], p1a[1]);
        path1.close();
        canvas.drawPath(path1, paint);

    }

    private float getLength(float[] b) {
        return (float) Math.sqrt(b[0] * b[0] + b[1] * b[1]);
    }

    private float getDistance(float[] b1, float[] b2) {
        float x = b1[0] - b2[0];
        float y = b1[1] - b2[1];
        float d = x * x + y * y;
        return (float) Math.sqrt(d);
    }



    //画动的圆
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circle = circlePaths.get(0);
        circle.center[0] = maxLength * mInterpolatedTime;
        for (int i = 1, l = circlePaths.size(); i < l; i++) {
            metaball(canvas, i, 0, 0.6f, handle_len_rate, radius * 4f);
        }
    }

    //复写该方法确定自定义View的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //1精确模式（MeasureSpec.EXACTLY）
        //2.最大模式（MeasureSpec.AT_MOST）
        //3.未指定模式（MeasureSpec.UNSPECIFIED）

        //设置组件的宽度
        widthMeasureSpec = MeasureSpec.makeMeasureSpec((int) (ITEM_COUNT * (radius * 2 + ITEM_DIVIDER)), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (2 * radius * 1.4f), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    //结束动画
    private void stopAnimation() {
        this.clearAnimation();
        postInvalidate();
    }

    //开始动画
    private void startAnimation() {
        wa = new MoveAnimation();
        //设置它运动的时间
        wa.setDuration(1000);
        //setInterpolator可以控制动画的变化速率
        wa.setInterpolator(new AccelerateDecelerateInterpolator());
        //setRepeatCount方法：设置重复次数
        wa.setRepeatCount(Animation.INFINITE);
        //必须设置setRepeatCount此设置才生效，动画执行完成之后按照逆方式动画返回
        wa.setRepeatMode(Animation.REVERSE);
        startAnimation(wa);
    }


    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        //隐藏和不可见时停止动画
        if (visibility == GONE || visibility == INVISIBLE) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }


//    onAttachedToWindow运行在onResume之后
//    onAttachedToWindow是在第一次onDraw前调用的。也就是我们写的View在没有绘制出来时调用的，但只会调用一次。
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    //我们销毁View的时候
    @Override
    protected void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }



}
