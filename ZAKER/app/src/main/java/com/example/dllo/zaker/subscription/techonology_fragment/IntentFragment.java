package com.example.dllo.zaker.subscription.techonology_fragment;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.IntentAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_intent;

/**
 * Created by dllo on 16/9/3.
 */
public class IntentFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private IntentAdapter intentAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_technolo;
    }

    @Override
    protected void initView(View view) {
        view_technolo_pager = (ViewPager) view.findViewById(R.id.view_technolo_pager);

    }

    @Override
    protected void initData() {
        String url ="http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=5&catalog_appid=13";
        NetTool.getInstance().startRequest(url, Bean_intent.class, new onHttpCallBack<Bean_intent>() {
            @Override
            public void onSuccess(Bean_intent response) {
                intentAdapter =new IntentAdapter(getActivity());
                intentAdapter.setBean_intent(response);
                view_technolo_pager.setAdapter(intentAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
