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


/**
 * Created by dllo on 16/8/31.
 */
public class MoneyActivity extends BaseActivity implements OnClickListener {
    private RadioButton radio_imports, radio_shares, radio_market;

    @Override
    protected int getLayout() {
        return R.layout.activity_money;
    }

    @Override
    protected void initView() {
        radio_imports = (RadioButton) findViewById(R.id.radio_imports);
        radio_shares = (RadioButton) findViewById(R.id.radio_shares);
        radio_market = (RadioButton) findViewById(R.id.radio_market);

    }

    @Override
    protected void initData() {
        radio_imports.setOnClickListener(this);
        radio_shares.setOnClickListener(this);
        radio_market.setOnClickListener(this);

        replaceFragment(R.id.frame_money, new ImportsFragment());
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
            case R.id.radio_imports:
                replaceFragment(R.id.frame_money, new ImportsFragment());
                break;
            case R.id.radio_shares:
                replaceFragment(R.id.frame_money, new SharesFragment());
                break;
            case R.id.radio_market:
                replaceFragment(R.id.frame_money, new MarketFragment());
                break;

        }

    }
}
