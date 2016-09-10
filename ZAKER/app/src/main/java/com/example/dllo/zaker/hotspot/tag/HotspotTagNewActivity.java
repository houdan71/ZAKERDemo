package com.example.dllo.zaker.hotspot.tag;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.hotspot.tag.morelike.AddMoreLikeFragment;
import com.example.dllo.zaker.hotspot.tag.mylike.MyLikeFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/8.
 */
public class HotspotTagNewActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;
    private HotspotTagNewAdapter mAdapter;




    @Override
    protected int getLayout() {
        return R.layout.activity_hotspot_tag;
    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout_hotspot_tag);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_hotspot_tag);

    }

    @Override
    protected void initData() {

        mFragments = new ArrayList<>();
        mFragments.add(new MyLikeFragment());
        mFragments.add(new AddMoreLikeFragment());

        mAdapter = new HotspotTagNewAdapter(getSupportFragmentManager());
        mAdapter.setFragments(mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setSelectedTabIndicatorColor(0xFFF53235);
        mTabLayout.setTabTextColors(R.color.gray_background,R.color.ColorTitle);
    }
}
