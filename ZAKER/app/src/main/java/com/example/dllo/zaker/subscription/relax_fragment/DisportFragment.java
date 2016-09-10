package com.example.dllo.zaker.subscription.relax_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.DisportAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_disport;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 */
public class DisportFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private DisportAdapter disportAdapter;
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

        NetTool.getInstance().startRequest(NValues.URL_DISPORT, Bean_disport.class, new onHttpCallBack<Bean_disport>() {
            @Override
            public void onSuccess(Bean_disport response) {
                disportAdapter=new DisportAdapter(getActivity());
                disportAdapter.setBean_disport(response);
                view_technolo_pager.setAdapter(disportAdapter);


            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
