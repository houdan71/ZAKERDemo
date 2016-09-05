package com.example.dllo.zaker.subscription.food_fragment;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.FoodAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_food;
import com.example.dllo.zaker.subscription.fragment_adapter.FoodMovieAdapter;

/**
 * Created by dllo on 16/9/1.
 */
public class FoodFragment extends BaseFragment {
    private ListView  listView;
    private FoodMovieAdapter  foodMovieAdapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
       listView = (ListView) getView().findViewById(R.id.list_choice);
    }

    @Override
    protected void initData() {
      foodMovieAdapter =new FoodMovieAdapter(getContext());
        String url ="http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=12289&top_tab_id=10386 ";
        NetTool.getInstance().startRequest(url, Bean_food.class, new onHttpCallBack<Bean_food>() {
            @Override
            public void onSuccess(Bean_food response) {
                foodMovieAdapter.setBean_food(response);
                listView.setAdapter(foodMovieAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }
}
