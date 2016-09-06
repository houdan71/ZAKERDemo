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
        String url = "http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=10530&catalog_appid=9";
        NetTool.getInstance().startRequest(url, Bean_film.class, new onHttpCallBack<Bean_film>() {
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
