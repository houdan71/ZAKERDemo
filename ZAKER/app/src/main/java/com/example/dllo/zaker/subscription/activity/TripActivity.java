package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TripAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_trip;

/**
 * Created by dllo on 16/8/31.
 */
public class TripActivity extends BaseActivity {
    private ViewPager view_trip_pager;
    private TripAdapter tripAdapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_trip_pager = (ViewPager) findViewById(R.id.view_car_pager);

    }

    @Override
    protected void initData() {
        String url =" http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=981";
        NetTool.getInstance().startRequest(url, Bean_trip.class, new onHttpCallBack<Bean_trip>() {
            @Override
            public void onSuccess(Bean_trip response) {
                tripAdapter =new TripAdapter(TripActivity.this);
                tripAdapter.setBean_trip(response);
                view_trip_pager.setAdapter(tripAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
