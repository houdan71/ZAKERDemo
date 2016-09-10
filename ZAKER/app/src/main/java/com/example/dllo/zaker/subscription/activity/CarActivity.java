package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.CarAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_car;

/**
 * Created by dllo on 16/8/31.
 */
public class CarActivity extends BaseActivity {
    private ViewPager view_car_pager;
    private CarAdapter carAdapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_car_pager= (ViewPager) findViewById(R.id.view_car_pager);

    }

    @Override
    protected void initData() {
        String url ="";
        NetTool.getInstance().startRequest(url, Bean_car.class, new onHttpCallBack<Bean_car>() {
            @Override
            public void onSuccess(Bean_car response) {
                carAdapter =new CarAdapter(CarActivity.this);
                carAdapter.setBean_car(response);
                view_car_pager.setAdapter(carAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
