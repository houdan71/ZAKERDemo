package com.example.dllo.zaker.subscription.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.money_fragment.ImportsFragment;
import com.example.dllo.zaker.subscription.money_fragment.MarketFragment;
import com.example.dllo.zaker.subscription.money_fragment.SharesFragment;
import com.example.dllo.zaker.subscription.sport_fragment.BasketballFragment;
import com.example.dllo.zaker.subscription.sport_fragment.FootballFragment;
import com.example.dllo.zaker.subscription.sport_fragment.MultipleFragment;
import com.example.dllo.zaker.subscription.sport_fragment.TopFragment;

/**
 * Created by dllo on 16/8/31.
 */
public class SportsActivity extends BaseActivity implements OnClickListener {
    private RadioButton radio_top, radio_football, radio_basketball,radio_multiple;
    @Override
    protected int getLayout() {
        return R.layout.activity_sports;
    }

    @Override
    protected void initView() {
        radio_top = (RadioButton) findViewById(R.id.radio_top);
        radio_football = (RadioButton) findViewById(R.id.radio_football);
        radio_basketball = (RadioButton) findViewById(R.id.radio_basketball);
        radio_multiple = (RadioButton) findViewById(R.id.radio_multiple);

    }

    @Override
    protected void initData() {
        radio_top.setOnClickListener(this);
        radio_football.setOnClickListener(this);
        radio_basketball.setOnClickListener(this);
        radio_multiple.setOnClickListener(this);

        replaceFragment(R.id.frame_sport, new TopFragment());

    }
    public void replaceFragment(int id, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.radio_top:
                replaceFragment(R.id.frame_sport, new TopFragment());
                break;
            case R.id.radio_football:
                replaceFragment(R.id.frame_sport, new FootballFragment());
                break;
            case R.id.radio_basketball:
                replaceFragment(R.id.frame_sport, new BasketballFragment());
                break;
            case R.id.radio_multiple:
                replaceFragment(R.id.frame_sport, new MultipleFragment());
                break;

        }
    }
}
