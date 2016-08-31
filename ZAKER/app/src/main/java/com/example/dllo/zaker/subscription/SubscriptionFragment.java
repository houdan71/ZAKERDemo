package com.example.dllo.zaker.subscription;

import android.os.Handler;

import android.os.Message;
import android.support.v4.view.ViewPager;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

import android.view.MotionEvent;


import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/29.
 */
public class SubscriptionFragment extends BaseFragment  {
    private ViewPager view_pager;
    private LinearLayout linearLayout;
      private ScrollViewAndRecyclerView recyclerView;
    private SubAdapter subAdapter;
    private GridAdapter gridAdapter;
    private ItemTouchHelper mHelper;
    private ImageView[] tips;
    private Handler handler;
    private boolean mm = true;
    private boolean flag = true;
    private boolean userTouch = false;


    private Bean_subscription bean_subscription;


    @Override
    protected int initLayout() {

        return R.layout.fragment_subscription;
    }

    @Override
    protected void initView(View view) {


        view_pager = (ViewPager) view.findViewById(R.id.view_pager);
        linearLayout = (LinearLayout) view.findViewById(R.id.linear_lb);
        recyclerView = (ScrollViewAndRecyclerView) view.findViewById(R.id.recycle_view);





    }

    @Override
    protected void initData() {
        gridAdapter = new GridAdapter(getContext());

        String url = "http://iphone.myzaker.com/zaker/follow_promote.php?_appid=AndroidPhone&_bsize=1080_1920&_city=%E5%A4%A7%E8%BF%9E&_dev=515&_lat=38.88973&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551023&_mac=08%3A00%3A27%3A4c%3A0a%3A58&_mcode=2FFC24DC&_net=wifi&_nudid=f8d5a71e2585d3a4&_os=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920&_os_name=GoogleNexus5-4.4.4-API19-1080x1920&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_udid=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920.08%3A00%3A27%3A4c%3A0a%3A58&_v=6.7&_version=6.7&m=1472280481";
        NetTool.getInstance().startRequest(url, Bean_subscription.class, new onHttpCallBack<Bean_subscription>() {
            @Override
            public void onSuccess(Bean_subscription response) {
                bean_subscription = response;
                subAdapter = new SubAdapter(mContext);
                subAdapter.setBean_subscription(bean_subscription);
                view_pager.setAdapter(subAdapter);
                LayoutManager lm =new GridLayoutManager(mContext,3);
                recyclerView.setLayoutManager(lm);
                recyclerView.addItemDecoration(new MyItemDecoration());

                recyclerView.setAdapter(gridAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                Callback callback =createCallback();
                mHelper =new ItemTouchHelper(callback);
                mHelper.attachToRecyclerView(recyclerView);
                wheelFun(response);

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
    private Callback createCallback() {
        return new Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
                //两个参数
                //参数1:决定行布局支持哪种拖拉的手势
                //参数2:决定行布局支持哪种滑动的手势
                return Callback.makeMovementFlags(ItemTouchHelper.UP|ItemTouchHelper.DOWN|
                                ItemTouchHelper.START|ItemTouchHelper.END
                        ,ItemTouchHelper.START|ItemTouchHelper.END);
            }

        //方法的作用:移动了行布局之后会回调该该方法
            //参数1:
            //参数2:移动的行布局对应的ViewHolder
            //参数3:移动到的位置所对应的ViewHolder

            @Override
            public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {

                return false;
            }
            //滑动行布局时回调的方法
            //参数1:滑动的行布局所对应的VIewHolder
            //参数2:滑动的方向
            @Override
            public void onSwiped(ViewHolder viewHolder, int direction) {
                int position =viewHolder.getAdapterPosition();
                //gridAdapter.delect(position);
            }
            //选择性覆写,返回决定是否用长按拖动功能
            @Override
            public boolean isLongPressDragEnabled() {
                return super.isLongPressDragEnabled();
            }
            //选择性覆写,返回值决定是否启用滑动功能
            @Override
            public boolean isItemViewSwipeEnabled() {
                return super.isItemViewSwipeEnabled();
            }


        };
    }
            private void wheelFun(final Bean_subscription bean_subscription) {

                handler = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        view_pager.setCurrentItem(view_pager.getCurrentItem() + 1);
                        return false;
                    }
                });
                if (mm) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (flag) {

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (!userTouch) {
                                    handler.sendEmptyMessage(0);
                                }

                            }
                        }
                    }).start();
                    mm = false;
                    //当用户点击的时候就不会再触发发轮播图了
                    //轮播图就会暂停轮播
                    view_pager.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            switch (event.getAction()) {
                                case MotionEvent.ACTION_DOWN:
                                    //当用户触摸了轮播图的时候
                                    userTouch = true;
                                    break;
                                case MotionEvent.ACTION_UP:
                                    //当用户手指离开轮播图的时候
                                    userTouch = false;

                                    break;
                            }
                            return false;
                        }
                    });
                }
                tips = new ImageView[bean_subscription.getData().getList().size()];
                for (int i = 0; i < bean_subscription.getData().getList().size(); i++) {

                    ImageView imageView = new ImageView(mContext);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
                    tips[i] = imageView;
                    if (i == 0) {
                        imageView.setImageResource(R.mipmap.umeng_socialize_switchbutton_btn_pressed);
                    } else {
                        imageView.setImageResource(R.mipmap.umeng_socialize_switchbutton_btn_unpressed);
                    }
                    LinearLayout.LayoutParams layoutParams =
                            new LinearLayout.LayoutParams(
                                    40, 40);

                    layoutParams.leftMargin = 5;
                    layoutParams.rightMargin = 5;

                    linearLayout.addView(imageView, layoutParams);
                }
                subAdapter.setTips(tips);

            }

        }


