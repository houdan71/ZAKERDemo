package com.example.dllo.zaker.hotspot.tag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/8.
 */
public class HotspotTagNewAdapter extends FragmentPagerAdapter {
    private String[] title={"我的喜好","添加更多喜好"};
    private ArrayList<Fragment> mFragments;

    public HotspotTagNewAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        mFragments = fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments != null && mFragments.size() > 0?mFragments.get(position):null;
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
