package com.example.dllo.zaker.subscription.activity;

import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.Bean_subscription;
import com.example.dllo.zaker.subscription.adapter.BeautifulAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_beautiful;

/**
 * Created by dllo on 16/8/31.
 */
public class BeautifulActivity extends BaseActivity {
    private ListView listView;
    private BeautifulAdapter beautifulAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_beautiful;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.list_view);

    }

    @Override
    protected void initData() {

        String url = "http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=12175";
        NetTool.getInstance().startRequest(url, Bean_beautiful.class, new onHttpCallBack<Bean_beautiful>() {
            @Override
            public void onSuccess(Bean_beautiful response) {
                beautifulAdapter = new BeautifulAdapter(BeautifulActivity.this);
                beautifulAdapter.setBean_beautiful(response);
                listView.setAdapter(beautifulAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
}
