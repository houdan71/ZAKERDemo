package com.example.dllo.zaker.hotspot.tag.morelike;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.hotspot.tag.mylike.MyLikeAdapter;
import com.example.dllo.zaker.hotspot.tag.mylike.MyLikeBean;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/9/8.
 */
public class AddMoreLikeFragment extends BaseFragment implements MyLikeAdapter.OnRecyclerItemClickListener {
    private RecyclerView mRecyclerView;
    private MyLikeAdapter mAdapter;
    private Intent intentBrocast;
    private MyLikeBean mLikeBean;
    public static final String ACTION_STR = "com.example.dllo.zaker.ACTION_STR";

    @Override
    protected int initLayout() {
        return R.layout.fragment_hotspot_tag_add_more_like;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view_hotspot_tag_addmy_like);
    }

    @Override
    protected void initData() {

        mAdapter = new MyLikeAdapter(getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        NetTool.getInstance().startRequest(NValues.URL_HOTSPOT_TAG, MyLikeBean.class, new onHttpCallBack<MyLikeBean>() {
            @Override
            public void onSuccess(MyLikeBean response) {
                mLikeBean = response;
                mAdapter.setLikeBean(response, "addMore");
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        mAdapter.setOnRecyclerItemListener(this);

    }


    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position) {
        mAdapter.delete(position);
        intentBrocast = new Intent("com.example.dllo.zaker.ACTION_STR");
        intentBrocast.putExtra("str", mLikeBean.getData().getHot_tags().get(position));
        getActivity().sendBroadcast(intentBrocast);
    }
}
