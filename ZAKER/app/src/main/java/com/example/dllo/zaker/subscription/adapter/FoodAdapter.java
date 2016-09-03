package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by dllo on 16/9/1.
 */
public class FoodAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragments;

    public FoodAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments =fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return  fragments == null?0:fragments.size();
    }
    public String titles[] ={"精选","美食视频","吃货"};

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
