package com.example.dllo.zaker.subscription.money_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.SharesAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_shares;

/**
 * Created by dllo on 16/9/3.
 * 股票
 */
public class SharesFragment extends BaseFragment {
    private ViewPager view_technolo_pager ;
    private SharesAdapter sharesAdapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_technolo;
    }

    @Override
    protected void initView(View view) {
        view_technolo_pager= (ViewPager) view.findViewById(R.id.view_technolo_pager);

    }

    @Override
    protected void initData() {
        String url ="http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=11691&catalog_appid=4";
        NetTool.getInstance().startRequest(url, Bean_shares.class, new onHttpCallBack<Bean_shares>() {
            @Override
            public void onSuccess(Bean_shares response) {
                sharesAdapter =new SharesAdapter(getActivity());
                sharesAdapter.setBean_shares(response);
                view_technolo_pager.setAdapter(sharesAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
