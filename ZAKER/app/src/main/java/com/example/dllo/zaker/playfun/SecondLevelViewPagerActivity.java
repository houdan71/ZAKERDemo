package com.example.dllo.zaker.playfun;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;

/**
 * Created by dllo on 16/8/31.
 */
public class SecondLevelViewPagerActivity extends BaseActivity {
    private ListView mListView;
    private SecondLevelViewPagerAdapter mAdapter;
    //viewPager点击传递过来的网址
    private Intent viewPagerIntent;

    @Override
    protected int getLayout() {
        return R.layout.item_fragment_playfun_listview_viewpager_item_listview;
    }

    @Override
    protected void initView() {

        mListView = (ListView) findViewById(R.id.playFun_listView_viewPager_listView);
    }

    @Override
    protected void initData() {
         viewPagerIntent = getIntent();
        String listUrl = viewPagerIntent.getStringExtra("listUrl");
        mAdapter = new SecondLevelViewPagerAdapter(this);
        NetTool.getInstance().startRequest(listUrl, SecondLevelViewPagerBean.class, new onHttpCallBack<SecondLevelViewPagerBean>() {
            @Override
            public void onSuccess(final SecondLevelViewPagerBean response) {
                mAdapter.setBean(response);
                mListView.setAdapter(mAdapter);
                mListView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(SecondLevelViewPagerActivity.this,SecondLevelWebViewActivity.class);
                        intent.putExtra("WebUrl",response.getData().getArticles().get(position).getWeburl());
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
