package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.LuxutyAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_luxuty;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/8/31.
 */
public class LuxutyActivity extends BaseActivity {
    private ViewPager view_luxuty_pager;
    private LuxutyAdapter luxutyAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_luxuty_pager = (ViewPager) findViewById(R.id.view_car_pager);

    }

    @Override
    protected void initData() {

        NetTool.getInstance().startRequest(NValues.URL_LUXUTY, Bean_luxuty.class, new onHttpCallBack<Bean_luxuty>() {
            @Override
            public void onSuccess(Bean_luxuty response) {
                luxutyAdapter =new LuxutyAdapter(LuxutyActivity.this);

                luxutyAdapter.setBean_lucuty(response);
                view_luxuty_pager.setAdapter(luxutyAdapter);


            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
