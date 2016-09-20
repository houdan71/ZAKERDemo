package com.example.dllo.zaker.subscription.sport_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TopAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_top;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 */
public class TopFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private TopAdapter topAdapter;

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

        NetTool.getInstance().startRequest(NValues.URL_TOP, Bean_top.class, new onHttpCallBack<Bean_top>() {
            @Override
            public void onSuccess(Bean_top response) {
            topAdapter =new TopAdapter(getActivity());

                topAdapter.setBean_top(response);
                view_technolo_pager.setAdapter(topAdapter);


            }

            @Override
            public void onError(Throwable e) {

            }
        });




    }
}
