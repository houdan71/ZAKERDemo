package com.example.dllo.zaker.subscription.food_fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.main.MetaballView;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_food;
import com.example.dllo.zaker.subscription.fragment_adapter.FoodMovieAdapter;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/1.
 */
public class FoodFragment extends BaseFragment {
    private ListView  listView;
    private FoodMovieAdapter  foodMovieAdapter;
    ArrayList<HotspotSecBean> b;


    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
<<<<<<< HEAD

       listView = (ListView) getView().findViewById(R.id.list_choice);




=======
       listView = (ListView) getView().findViewById(R.id.list_choice);

        mMetaballView = (MetaballView) view.findViewById(R.id.fragment_choice_metaballView);
        mMetaballView.setPaintMode(1);

>>>>>>> 6ce7fc03856b45cd31f8039a607d17f3b0582b8e
    }

    @Override
    protected void initData() {
      foodMovieAdapter =new FoodMovieAdapter(getContext());

        NetTool.getInstance().startRequest(NValues.URL_FOOD, Bean_food.class, new onHttpCallBack<Bean_food>() {
            @Override
            public void onSuccess(Bean_food response) {
                for (int i = 0; i <response.getData().getArticles().size(); i++) {
                    b = new ArrayList<>();
                    HotspotSecBean bean = new HotspotSecBean();
                    bean.setWebUrl(response.getData().getArticles().get(i).getWeburl());
                    b.add(bean);

                }
                listView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getActivity(), HotspotSecActivity.class);
                        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
                        startActivity(intent);

                    }


                });
                foodMovieAdapter.setBean_food(response);
                listView.setAdapter(foodMovieAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });



    }
}
