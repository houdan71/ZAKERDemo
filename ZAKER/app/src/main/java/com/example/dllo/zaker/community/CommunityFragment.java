package com.example.dllo.zaker.community;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.community.tablayout.friends.CommunityFriendsFragment;
import com.example.dllo.zaker.community.tablayout.select.CommunitySelectionFragment;
import com.example.dllo.zaker.community.tablayout.topic.CommunityTopicFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/29.
 */
public class CommunityFragment extends BaseFragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList<Fragment> mFragmentArrayList;
    private CommunityAdapter mAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_community;
    }

    @Override
    protected void initView(View view) {
        mViewPager = (ViewPager) getView().findViewById(R.id.view_pager_community);
        mTabLayout = (TabLayout) getView().findViewById(R.id.tablayout_community);

    }

    @Override
    protected void initData() {
        mFragmentArrayList = new ArrayList<>();

        mFragmentArrayList.add(new CommunityTopicFragment());
        mFragmentArrayList.add(new CommunitySelectionFragment());
        mFragmentArrayList.add(new CommunityFriendsFragment());

        mAdapter = new CommunityAdapter(getChildFragmentManager());
        mAdapter.setFragmentArrayList(mFragmentArrayList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setSelectedTabIndicatorColor(0xfff53235);
        mTabLayout.setTabTextColors(0xff878787,0xfff53235);

    }
}
