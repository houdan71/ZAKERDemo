package com.example.dllo.zaker.subscription.relax_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.StarAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_star;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 */
public class StarFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private StarAdapter starAdapter;

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

        NetTool.getInstance().startRequest(NValues.URL_STAR, Bean_star.class, new onHttpCallBack<Bean_star>() {
            @Override
            public void onSuccess(Bean_star response) {
                starAdapter =new StarAdapter(getActivity());

                starAdapter.setBean_star(response);
                view_technolo_pager.setAdapter(starAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
