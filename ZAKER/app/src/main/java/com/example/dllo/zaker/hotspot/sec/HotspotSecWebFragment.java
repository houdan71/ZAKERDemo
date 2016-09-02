package com.example.dllo.zaker.hotspot.sec;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
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
        ArrayList<HotspotSecBean> beanArrayList = bundle.getParcelableArrayList(HotspotSecActivity.KEY_webUrll);
        int positionItem = bundle.getInt(HotspotSecActivity.KEY_postionItemm);
        Log.d("HotspotSecWebFragment", "positionItem:" + positionItem);
        for (int i = 0; i < beanArrayList.size(); i++) {
            Log.d("HotspotSecWebFragment", beanArrayList.get(i).getWebUrl());
        }

        mAdapter.setArrayList(beanArrayList, positionItem);
        mViewPager.setAdapter(mAdapter);


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

    }
}
