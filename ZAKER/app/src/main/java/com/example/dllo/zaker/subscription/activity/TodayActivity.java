package com.example.dllo.zaker.subscription.activity;

import com.example.dllo.zaker.base.BaseActivity;


import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;

import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TodayAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_today;
import com.example.dllo.zaker.tools.NValues;

import org.joda.time.TimeOfDay;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

/**
 * Created by dllo on 16/8/31.
 */
public class TodayActivity extends BaseActivity {
    private ViewPager view_today_pager;
    private TodayAdapter todayAdapter;



    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_today_pager = (ViewPager) findViewById(R.id.view_car_pager);





    }

    @Override
    protected void initData() {

        todayAdapter = new TodayAdapter(this);

        NetTool.getInstance().startRequest(NValues.URL_TODAY, Bean_today.class, new onHttpCallBack<Bean_today>() {
            @Override
            public void onSuccess(final Bean_today response) {
                todayAdapter.setBean_today(response);
                view_today_pager.setAdapter(todayAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }


}
