package com.example.dllo.zaker.subscription.techonology_fragment;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.NumberAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_number;

/**
 * Created by dllo on 16/9/3.
 */
public class NumberFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private NumberAdapter numberAdapter;
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
        String url ="http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=11542&catalog_appid=13 ";
        NetTool.getInstance().startRequest(url, Bean_number.class, new onHttpCallBack<Bean_number>() {
            @Override
            public void onSuccess(Bean_number response) {


                numberAdapter =new NumberAdapter(getActivity());
                numberAdapter.setBean_number(response);
                view_technolo_pager.setAdapter(numberAdapter);


            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
