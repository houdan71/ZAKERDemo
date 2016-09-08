package com.example.dllo.zaker.subscription.relax_fragment;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.FilmsAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_film;
import com.example.dllo.zaker.subscription.fragment_adapter.FilmAdapter;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/3.
 *
 * 娱乐---  电影
 */

public class FilmFragment extends BaseFragment {
    private ViewPager view_technolo_pager;
    private FilmsAdapter filmsAdapter;
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

        NetTool.getInstance().startRequest(NValues.URL_FILM, Bean_film.class, new onHttpCallBack<Bean_film>() {
            @Override
            public void onSuccess(Bean_film response) {
            filmsAdapter =new FilmsAdapter(getActivity());
                filmsAdapter.setBean_film(response);
                view_technolo_pager.setAdapter(filmsAdapter);



            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
