package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.NewsAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_news;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/8/31.
 */
public class NewsActivity extends BaseActivity {
    private ViewPager view_news_pager;
    private NewsAdapter newsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_news_pager= (ViewPager) findViewById(R.id.view_car_pager);

    }

    @Override
    protected void initData() {

        NetTool.getInstance().startRequest(NValues.URL_NEWS, Bean_news.class, new onHttpCallBack<Bean_news>() {
            @Override
            public void onSuccess(Bean_news response) {
                newsAdapter =new NewsAdapter(NewsActivity.this);
                newsAdapter.setBean_news(response);
                view_news_pager.setAdapter(newsAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
