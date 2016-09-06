package com.example.dllo.zaker.community.slidingitem.select;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.community.slidingitem.select.CommunitySelectionFragmentAdapter.OnRecyclerItemClickListener;
import com.example.dllo.zaker.playfun.SecondLevelWebViewActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;

/**
 * Created by dllo on 16/8/30.
 */
public class CommunitySelectionFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private CommunitySelectionFragmentAdapter mAdapter;
    private String selectionUrl = "http://dis.myzaker.com/api/get_post_selected.php?_appid=AndroidPhone&_bsize=1080_1920&_city=%E5%A4%A7%E8%BF%9E&_dev=515&_lat=38.88973&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551023&_mac=08%3A00%3A27%3A79%3Aac%3Ae9&_mcode=0610D063&_net=wifi&_nudid=50789d6ae16e0bde&_os=5.1_GoogleNexus5-5.1.0-API22-1080x1920&_os_name=GoogleNexus5-5.1.0-API22-1080x1920&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_udid=5.1_GoogleNexus5-5.1.0-API22-1080x1920.08%3A00%3A27%3A79%3Aac%3Ae9&_v=6.7&_version=6.7";

    @Override
    protected int initLayout() {
        return R.layout.fragment_community_selection;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_community_selection_RecyclerView);
    }

    @Override
    protected void initData() {
        mAdapter = new CommunitySelectionFragmentAdapter(mContext);
        NetTool.getInstance().startRequest(selectionUrl, CommunitySelectionBean.class, new onHttpCallBack<CommunitySelectionBean>() {
            @Override
            public void onSuccess(final CommunitySelectionBean response) {

                LinearLayoutManager manager = new LinearLayoutManager(mContext);
                mRecyclerView.setLayoutManager(manager);
                mAdapter.setBean(response);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.setListener(new OnRecyclerItemClickListener() {
                    @Override
                    public void onItemClick(View view, ViewHolder holder, int position) {
                        Intent intent = new Intent(mContext, SecondLevelWebViewActivity.class);
                        intent.putExtra("WebUrl",response.getData().getPosts().get(position).getWeburl());
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onError(Throwable e) {

            }
        });


    }
}
