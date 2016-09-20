package com.example.dllo.zaker.subscription.activity;

import com.example.dllo.zaker.base.BaseActivity;


import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;

import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TodayAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_today;
import com.example.dllo.zaker.tools.NValues;

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



        NetTool.getInstance().startRequest(NValues.URL_TODAY, Bean_today.class, new onHttpCallBack<Bean_today>() {
            @Override
            public void onSuccess(final Bean_today response) {

                todayAdapter = new TodayAdapter(TodayActivity.this);

                todayAdapter.setBean_today(response);

                view_today_pager.setAdapter(todayAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }


}
