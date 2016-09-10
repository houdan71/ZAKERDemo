package com.example.dllo.zaker.subscription.sport_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.MultipleAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_multiple;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 */
public class MultipleFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private MultipleAdapter multipleAdapter;

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

        NetTool.getInstance().startRequest(NValues.URL_MULTIPLE, Bean_multiple.class, new onHttpCallBack<Bean_multiple>() {
            @Override
            public void onSuccess(Bean_multiple response) {
            multipleAdapter =new MultipleAdapter(getActivity());
                multipleAdapter.setBean_multiple(response);
                view_technolo_pager.setAdapter(multipleAdapter);



            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
