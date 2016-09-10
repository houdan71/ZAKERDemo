package com.example.dllo.zaker.hotspot.tag.mylike;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/8.
 */
public class MyLikeFragment extends BaseFragment implements MyLikeAdapter.OnRecyclerItemClickListener {
    private RecyclerView mRecyclerView;
    private MyLikeBean mLikeBeen;
    private MyLikeAdapter mAdapter;

    private String str;

    @Override
    protected int initLayout() {
        return R.layout.fragment_hotspot_tag_my_like;

    }

    @Override
    protected void initView(View view) {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view_hotspot_tag_my_like);

    }

    @Override
    protected void initData() {

        mAdapter = new MyLikeAdapter(getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(MyApp.getContext(), 2));

        register();
        NetTool.getInstance().startRequest(NValues.URL_HOTSPOT_TAG, MyLikeBean.class, new onHttpCallBack<MyLikeBean>() {
            @Override
            public void onSuccess(MyLikeBean response) {
                mLikeBeen = response;
                mAdapter.setLikeBean(response, "lala");
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });


        mAdapter.setOnRecyclerItemListener(this);
    }


    private ArrayList<MyLikeBean> mLikeBeanArrayListl;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case "com.example.dllo.zaker.ACTION_STR":
                    str = intent.getStringExtra("str");
                    Log.d("MyLikeFragment", str);
                    mLikeBeanArrayListl = new ArrayList<>();
                    MyLikeBean bean = new MyLikeBean();
                    bean.setStr(str);
                    mLikeBeanArrayListl.add(bean);
                    mAdapter.setBeanArrayList(mLikeBeanArrayListl);
                    mAdapter.setLikeBean(mLikeBeen,"lala");
                    mAdapter.add(0, str);
                    mRecyclerView.setAdapter(mAdapter);
                    break;

            }
        }
    };

    private void register() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.dllo.zaker.ACTION_STR");
        getContext().registerReceiver(mReceiver, intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContext().unregisterReceiver(mReceiver);
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position) {
        mAdapter.delete(position);
    }
}
