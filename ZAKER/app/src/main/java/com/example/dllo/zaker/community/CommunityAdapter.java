package com.example.dllo.zaker.community;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/30.
 */
public class CommunityAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentArrayList;
    private String[] title = {"话题", "精选", "好友圈"};

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        mFragmentArrayList = fragmentArrayList;
        notifyDataSetChanged();
    }

    public CommunityAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList != null && mFragmentArrayList.size() > 0 ? mFragmentArrayList.get(position) : null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
