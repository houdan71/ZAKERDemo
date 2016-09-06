package com.example.dllo.zaker.subscription.relax_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.TvAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_tv;

/**
 * Created by dllo on 16/9/3.
 */
public class TvFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private TvAdapter tvAdapter;
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
        String url =" http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=11698&catalog_appid=9 ";
        NetTool.getInstance().startRequest(url, Bean_tv.class, new onHttpCallBack<Bean_tv>() {
            @Override
            public void onSuccess(Bean_tv response) {
                tvAdapter =new TvAdapter(getActivity());
                tvAdapter.setBean_tv(response);
                view_technolo_pager.setAdapter(tvAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
