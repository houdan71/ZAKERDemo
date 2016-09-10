package com.example.dllo.zaker.subscription.techonology_fragment;

import android.renderscript.Script.FieldBase;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.GeneralAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_general;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 */
public class GeneralFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private GeneralAdapter generalAdapter;
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

        NetTool.getInstance().startRequest(NValues.URL_GENERAL, Bean_general.class, new onHttpCallBack<Bean_general>() {
            @Override
            public void onSuccess(Bean_general response) {
                generalAdapter =new GeneralAdapter(getActivity());
                generalAdapter.setBean_general(response);
                view_technolo_pager.setAdapter(generalAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
