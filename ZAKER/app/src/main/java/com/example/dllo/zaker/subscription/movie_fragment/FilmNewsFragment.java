package com.example.dllo.zaker.subscription.movie_fragment;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_movie;
import com.example.dllo.zaker.subscription.fragment_adapter.FilmAdapter;

/**
 * Created by dllo on 16/9/1.
 */
public class FilmNewsFragment extends BaseFragment {
    private ListView listView;
    private FilmAdapter filmAdapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
      listView = (ListView) view.findViewById(R.id.list_choice);
    }

    @Override
    protected void initData() {
          String url ="http://iphone.myzaker.com/zaker/news.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&act=list&app_id=10530 ";
        NetTool.getInstance().startRequest(url, Bean_movie.class, new onHttpCallBack<Bean_movie>() {
            @Override
            public void onSuccess(Bean_movie response) {
             filmAdapter =new FilmAdapter(getContext());
                filmAdapter.setBean_movie(response);
                listView.setAdapter(filmAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
