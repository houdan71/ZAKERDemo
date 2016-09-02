package com.example.dllo.zaker.subscription.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.adapter.FoodAdapter;
import com.example.dllo.zaker.subscription.fragment.ChoiceFragment;
import com.example.dllo.zaker.subscription.fragment.FoodFragment;
import com.example.dllo.zaker.subscription.fragment.FoodieFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class FoodActivity extends BaseActivity {
    private TabLayout tab_layout;
    private ViewPager viewPager;
    private List<Fragment> fragments;

    @Override
    protected int getLayout() {
        return R.layout.activity_food;
    }

    @Override
    protected void initView() {

        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_food_pager);

    }


    @Override
    protected void initData() {
        initFragment();
        FoodAdapter adapter = new FoodAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab_layout.setTabTextColors(Color.BLUE,Color.RED);
        tab_layout.setupWithViewPager(viewPager);

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ChoiceFragment());
        fragments.add(new FoodFragment());
        fragments.add(new FoodieFragment());
    }
}
