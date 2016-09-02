package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/1.
 */
public class MovieAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> f;

    public MovieAdapter(FragmentManager fm,List<Fragment> f) {
        super(fm);
        this.f =f;
    }


    @Override
    public Fragment getItem(int position) {
        return f.get(position);
    }
    public String[] titles={"影讯","影迷"};

    @Override
    public int getCount() {
        return f == null?0:f.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
