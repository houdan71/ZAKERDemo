package com.example.dllo.zaker.subscription.food_fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_foodie;
import com.example.dllo.zaker.subscription.fragment_adapter.FoodieAdapter;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/1.
 */
public class FoodieFragment extends BaseFragment {
    private ListView list_foodie;
    private FoodieAdapter foodieAdapter;
    ArrayList<HotspotSecBean> b;
    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
        list_foodie= (ListView) view.findViewById(R.id.list_choice);

    }

    @Override
    protected void initData() {

        NetTool.getInstance().startRequest(NValues.URL_FOODIE, Bean_foodie.class, new onHttpCallBack<Bean_foodie>() {
            @Override
            public void onSuccess(Bean_foodie response) {
               foodieAdapter =new FoodieAdapter(getContext());
                b = new ArrayList<>();
                for (int i = 0; i <response.getData().getPosts().size(); i++) {

                    HotspotSecBean bean = new HotspotSecBean();
                    bean.setWebUrl(response.getData().getPosts().get(i).getWeburl());
                    b.add(bean);

                }
                list_foodie.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getActivity(), HotspotSecActivity.class);
                        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
                        intent.putExtra(HotspotFragment.KEY_postionItem,position);
                        startActivity(intent);

                    }


                });
                foodieAdapter.setBean_foodie(response);
                list_foodie.setAdapter(foodieAdapter);



            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
