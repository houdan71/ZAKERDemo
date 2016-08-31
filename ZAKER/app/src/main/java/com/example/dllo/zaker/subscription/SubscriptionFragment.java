package com.example.dllo.zaker.subscription;

import android.view.LayoutInflater;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;

/**
 * Created by dllo on 16/8/29.
 */
public class SubscriptionFragment extends BaseFragment {
//     private ViewPager view_pager;
//     private GridView grid_view;


    @Override
    protected int initLayout() {

        return R.layout.fragment_subscription;
    }

    @Override
    protected void initView(View view) {
        View view1 = LayoutInflater.from(mContext).inflate(R.layout.head_subcsription,null);
//        view_pager= (ViewPager) view.findViewById(R.id.view_pager);
//        grid_view = (GridView) view1.findViewById(R.id.grid_view);
//        grid_view.addView(view1);

    }

    @Override
    protected void initData() {


    }
}
