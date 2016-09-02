package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/1.
 */
public class AddAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    public AddAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList =fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null?0:fragmentList.size();
    }
    private String [] titles={"精品","频道"};

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
