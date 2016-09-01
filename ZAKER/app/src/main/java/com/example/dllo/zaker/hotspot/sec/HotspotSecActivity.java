package com.example.dllo.zaker.hotspot.sec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.hotspot.HotspotFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
 */
public class HotspotSecActivity extends BaseActivity{
    public static final String KEY_webUrll = "webUrll";
    public static final String KEY_postionItemm = "KEY_postionItemm";


    @Override
    protected int getLayout() {
        return R.layout.activity_hotspot_sec_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        ArrayList<HotspotSecBean> bean = intent.getParcelableArrayListExtra(HotspotFragment.KEY_webUrl);
        int positionItem = intent.getIntExtra(HotspotFragment.KEY_postionItem,0);
        for (int i = 0; i < bean.size(); i++) {
            Log.d("HotspotSecActivity", bean.get(i).getWebUrl());
        }

        //替换fragment
        FragmentManager manager = getSupportFragmentManager();
        HotspotSecWebFragment webFragment = new HotspotSecWebFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_webUrll, bean);
        bundle.putInt(KEY_postionItemm,0);
        Log.d("AllFragment", String.valueOf(bean));
        webFragment.setArguments(bundle);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_hotspot_replace,webFragment).commit();
    }


}
