package com.example.dllo.zaker.subscription.activity;

import com.example.dllo.zaker.base.BaseActivity;


import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;

import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TodayAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_today;

import org.joda.time.TimeOfDay;

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
        String url = "http://iphone.myzaker.com/zaker/daily_hot.php?_appid=AndroidPhone&_bsize=1080_1920&_city=%E5%A4%A7%E8%BF%9E&_dev=515&_lat=38.88973&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551023&_mac=08%3A00%3A27%3A4c%3A0a%3A58&_mcode=2FFC24DC&_net=wifi&_nudid=f8d5a71e2585d3a4&_os=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920&_os_name=GoogleNexus5-4.4.4-API19-1080x1920&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_udid=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920.08%3A00%3A27%3A4c%3A0a%3A58&_v=6.7&_version=6.7&app_id_4=310000&app_ids=310000%2C660%2C7%2C13%2C981%2C1067%2C4%2C8%2C9%2C12%2C11195%2C10530%2C10386%2C12175%2C10362";
        NetTool.getInstance().startRequest(url, Bean_today.class, new onHttpCallBack<Bean_today>() {
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
