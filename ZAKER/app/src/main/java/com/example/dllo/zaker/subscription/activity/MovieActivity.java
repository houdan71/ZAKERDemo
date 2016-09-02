package com.example.dllo.zaker.subscription.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.adapter.MovieAdapter;
import com.example.dllo.zaker.subscription.fragment.FilmNewsFragment;
import com.example.dllo.zaker.subscription.fragment.MovieFanFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class MovieActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> f;
    @Override
    protected int getLayout() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initView() {
        tabLayout= (TabLayout) findViewById(R.id.tab_movie_layout);
        viewPager= (ViewPager) findViewById(R.id.view_movie_pager);

    }

    @Override
    protected void initData() {
        initFragment();
      MovieAdapter movieAdapter =new MovieAdapter(getSupportFragmentManager(),f);
        viewPager.setAdapter(movieAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(Color.BLUE,Color.RED);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initFragment() {
       f=new ArrayList<>();
        f.add(new FilmNewsFragment());
        f.add(new MovieFanFragment());
    }
}
