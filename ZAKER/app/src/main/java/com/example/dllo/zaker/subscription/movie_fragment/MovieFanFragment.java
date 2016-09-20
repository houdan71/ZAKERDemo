package com.example.dllo.zaker.subscription.movie_fragment;

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
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_moviefan;
import com.example.dllo.zaker.subscription.fragment_adapter.MovieFanAdapter;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/1.
 */
public class MovieFanFragment extends BaseFragment {
    private ListView list_moviefan;
    private MovieFanAdapter movieFanAdapter;
    ArrayList<HotspotSecBean> b;
    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
        list_moviefan= (ListView) view.findViewById(R.id.list_choice);


    }

    @Override
    protected void initData() {

        NetTool.getInstance().startRequest(NValues.URL_MOVIEFAN, Bean_moviefan.class, new onHttpCallBack<Bean_moviefan>() {
            @Override
            public void onSuccess(Bean_moviefan response) {
            movieFanAdapter =new MovieFanAdapter(getContext());
                b = new ArrayList<>();
                for (int i = 0; i <response.getData().getPosts().size(); i++) {

                    HotspotSecBean bean = new HotspotSecBean();
                    bean.setWebUrl(response.getData().getPosts().get(i).getWeburl());
                    b.add(bean);

                }
                list_moviefan.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getActivity(), HotspotSecActivity.class);
                        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
                        intent.putExtra(HotspotFragment.KEY_postionItem,position);
                        startActivity(intent);

                    }


                });
                movieFanAdapter.setBean_moviefan(response);
                list_moviefan.setAdapter(movieFanAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
