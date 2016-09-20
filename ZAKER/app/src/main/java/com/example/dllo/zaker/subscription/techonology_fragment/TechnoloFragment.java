package com.example.dllo.zaker.subscription.techonology_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TechnoloAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_technolo;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 */
public class TechnoloFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private TechnoloAdapter technoloAdapter;

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

        NetTool.getInstance().startRequest(NValues.URL_TECHNOLO, Bean_technolo.class, new onHttpCallBack<Bean_technolo>() {
            @Override
            public void onSuccess(Bean_technolo response) {
                technoloAdapter =new TechnoloAdapter(getActivity());

                technoloAdapter.setBean_technolo(response);
                view_technolo_pager.setAdapter(technoloAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
