package com.example.dllo.zaker.subscription.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.adapter.AddAdapter;
import com.example.dllo.zaker.subscription.add_fragment.ChannelFragment;
import com.example.dllo.zaker.subscription.add_fragment.EssenceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class AddActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    @Override
    protected int getLayout() {
        return R.layout.activity_add;
    }

    @Override
    protected void initView() {
        tabLayout= (TabLayout) findViewById(R.id.tab_add_layout);
        viewPager= (ViewPager) findViewById(R.id.view_add_pager);

    }

    @Override
    protected void initData() {
        initfragment();
        AddAdapter addAdapter =new AddAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(addAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(Color.BLUE,Color.RED);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initfragment() {
        fragmentList =new ArrayList<>();
        fragmentList.add(new EssenceFragment());
        fragmentList.add(new ChannelFragment());
    }
}
