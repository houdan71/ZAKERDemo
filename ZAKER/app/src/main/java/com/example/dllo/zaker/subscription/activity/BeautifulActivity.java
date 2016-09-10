package com.example.dllo.zaker.subscription.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.Bean_subscription;
import com.example.dllo.zaker.subscription.adapter.BeautifulAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_beautiful;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
 */
public class BeautifulActivity extends BaseActivity {
    private ListView listView;
    private BeautifulAdapter beautifulAdapter;
    ArrayList<HotspotSecBean> b;
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


        NetTool.getInstance().startRequest(NValues.URL_BEAUTIFUL, Bean_beautiful.class, new onHttpCallBack<Bean_beautiful>() {
            @Override
            public void onSuccess(Bean_beautiful response) {
                beautifulAdapter = new BeautifulAdapter(BeautifulActivity.this);
                beautifulAdapter.setBean_beautiful(response);
                listView.setAdapter(beautifulAdapter);
                for (int i = 0; i <response.getData().getArticles().size(); i++) {
                    b = new ArrayList<>();
                    HotspotSecBean bean = new HotspotSecBean();
                    bean.setWebUrl(response.getData().getArticles().get(i).getWeburl());
                    b.add(bean);

                }
                listView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(BeautifulActivity.this, HotspotSecActivity.class);
                        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
                        startActivity(intent);

                    }


                });

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
}
