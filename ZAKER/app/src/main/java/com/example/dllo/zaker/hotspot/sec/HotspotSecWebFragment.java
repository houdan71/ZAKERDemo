package com.example.dllo.zaker.hotspot.sec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by yuxiaomin~ on 16/8/31.
 */
public class HotspotSecWebFragment extends BaseFragment {
    private ViewPager mViewPager;

    private HotspotSecViewPagerAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_hotspot_sec_web;
    }

    @Override
    protected void initView(View view) {
        mViewPager = (ViewPager) getView().findViewById(R.id.view_pager_hotspot_sec_web);

    }

    @Override
    protected void initData() {
        mAdapter = new HotspotSecViewPagerAdapter();

        Bundle bundle = getArguments();
        final ArrayList<HotspotSecBean> beanArrayList = bundle.getParcelableArrayList(HotspotSecActivity.KEY_webUrll);
        final int positionItem = bundle.getInt(HotspotSecActivity.KEY_postionItemm);
        Log.d("HotspotSecWebFragment", "positionItem:" + positionItem);
        for (int i = 0; i < beanArrayList.size(); i++) {
            Log.d("HotspotSecWebFragment", beanArrayList.get(i).getWebUrl());
        }

//        int progress= bundle.getInt(HotspotSecActivity.KEY_seekPro);
//
//        mAdapter.setPro(progress);
        mAdapter.setArrayList(beanArrayList, positionItem);
        mViewPager.setAdapter(mAdapter);

        mViewPager.setCurrentItem(positionItem);


        //加载底部评论
//
//        String url = NValues.URL_COMMENTS + beanArrayList.get(positionItem).getPk();
//        NetTool.getInstance().startRequest(url, HotspotSecCommentBean.class, new onHttpCallBack<HotspotSecCommentBean>() {
//            @Override
//            public void onSuccess(HotspotSecCommentBean response) {
//                Log.d("HotspotSecWebFragment", response.getData().getComments().get(0).getList().get(0).getAuther_name());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });

        register();


    }

    private BroadcastReceiver proReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action){
                case HotspotSecActivity.ACTION_PRO:
                    int pro = intent.getIntExtra(HotspotSecActivity.KEY_seekPro,0);
                    Log.d("HotspotSecWebFragment", "pro:" + pro);
                    mAdapter.setPro(pro);
                   // mAdapter.notifyDataSetChanged();
                    mViewPager.setAdapter(mAdapter);
                    break;
            }
        }
    };

    private void register(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(HotspotSecActivity.ACTION_PRO);
        getContext().registerReceiver(proReceiver,intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(proReceiver);
    }
}
