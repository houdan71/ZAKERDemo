package com.example.dllo.zaker.subscription.money_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.ImportsAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_imports;

/**
 * Created by dllo on 16/9/3.
 */
public class ImportsFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private ImportsAdapter importsAdapter;

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
        String url = "http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&act=list&app_id=4 ";
        NetTool.getInstance().startRequest(url, Bean_imports.class, new onHttpCallBack<Bean_imports>() {
            @Override
            public void onSuccess(Bean_imports response) {
                importsAdapter = new ImportsAdapter(getActivity());
                importsAdapter.setBean_imports(response);

                view_technolo_pager.setAdapter(importsAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
