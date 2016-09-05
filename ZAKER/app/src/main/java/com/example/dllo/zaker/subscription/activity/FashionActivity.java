package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.FashionAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_fashion;

/**
 * Created by dllo on 16/8/31.
 */
public class FashionActivity extends BaseActivity {
    private ViewPager view_fashion_pager;
    private FashionAdapter fashionAdapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_fashion_pager = (ViewPager) findViewById(R.id.view_car_pager);

    }

    @Override
    protected void initData() {
        String url =" http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=12";
        NetTool.getInstance().startRequest(url, Bean_fashion.class, new onHttpCallBack<Bean_fashion>() {
            @Override
            public void onSuccess(Bean_fashion response) {
                fashionAdapter =new FashionAdapter(FashionActivity.this);
                fashionAdapter.setBean_fashion(response);
                view_fashion_pager.setAdapter(fashionAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
