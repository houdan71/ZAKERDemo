package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.InvestAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_invest;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/8/31.
 */
public class InvestActivity extends BaseActivity {
    private ViewPager view_invest_pager;
    private InvestAdapter investAdapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_invest_pager = (ViewPager) findViewById(R.id.view_car_pager);

    }

    @Override
    protected void initData() {

        NetTool.getInstance().startRequest(NValues.URL_INVEST, Bean_invest.class, new onHttpCallBack<Bean_invest>() {
            @Override
            public void onSuccess(Bean_invest response) {
                investAdapter =new InvestAdapter(InvestActivity.this);
                investAdapter.setBean_invest(response);
                view_invest_pager.setAdapter(investAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
