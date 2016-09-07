package com.example.dllo.zaker.subscription.money_fragment;

import android.view.View;
import android.webkit.WebView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;

/**
 * Created by dllo on 16/9/3.
 */
public class MarketFragment extends BaseFragment {
    private WebView web_view;
    @Override
    protected int initLayout() {
        return R.layout.fragment_market;
    }

    @Override
    protected void initView(View view) {
        web_view = (WebView) view.findViewById(R.id.web_view);

    }

    @Override
    protected void initData() {
        web_view.loadUrl("http://passport.eastmoney.com/mobileapp/zaker_login.aspx ");

    }
}
