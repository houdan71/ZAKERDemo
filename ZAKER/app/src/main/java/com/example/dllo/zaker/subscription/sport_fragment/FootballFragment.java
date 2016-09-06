package com.example.dllo.zaker.subscription.sport_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.FootballAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_football;

/**
 * Created by dllo on 16/9/3.
 */
public class FootballFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private FootballAdapter footballAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fragment_technolo;
    }

    @Override
    protected void initView(View view) {
        view_technolo_pager = (ViewPager) view.findViewById(R.id.view_technolo_pager);
    }

    @Override
    protected void initData() {
        String url = "http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=12083&catalog_appid=8";
        NetTool.getInstance().startRequest(url, Bean_football.class, new onHttpCallBack<Bean_football>() {
            @Override
            public void onSuccess(Bean_football response) {
                footballAdapter = new FootballAdapter(getActivity());
                footballAdapter.setBean_football(response);
                view_technolo_pager.setAdapter(footballAdapter);


            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
}
