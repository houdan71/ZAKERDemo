package com.example.dllo.zaker.community.slidingitem.select;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.TypedValue;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.community.slidingitem.select.CommunitySelectionFragmentAdapter.OnRecyclerItemClickListener;
import com.example.dllo.zaker.playfun.SecondLevelWebViewActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/30.
 */
public class CommunitySelectionFragment extends BaseFragment implements OnRefreshListener {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private CommunitySelectionFragmentAdapter mAdapter;
    private String selectionUrl = "http://dis.myzaker.com/api/get_post_selected.php?_appid=AndroidPhone&_bsize=1080_1920&_city=%E5%A4%A7%E8%BF%9E&_dev=515&_lat=38.88973&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551023&_mac=08%3A00%3A27%3A79%3Aac%3Ae9&_mcode=0610D063&_net=wifi&_nudid=50789d6ae16e0bde&_os=5.1_GoogleNexus5-5.1.0-API22-1080x1920&_os_name=GoogleNexus5-5.1.0-API22-1080x1920&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_udid=5.1_GoogleNexus5-5.1.0-API22-1080x1920.08%3A00%3A27%3A79%3Aac%3Ae9&_v=6.7&_version=6.7";
    private String selectionNextUrl ;
    private int lastVisibleItem;
    private List<MyDataBean> list;

    @Override
    protected int initLayout() {
        return R.layout.fragment_community_selection;
    }

    @Override
    protected void initView(View view) {
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_community_selection_refresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_community_selection_RecyclerView);
    }

    @Override
    protected void initData() {
        list = new ArrayList<>();
        final LinearLayoutManager manager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new CommunitySelectionFragmentAdapter(mContext);
        NetTool.getInstance().startRequest(selectionUrl, CommunitySelectionBean.class, new onHttpCallBack<CommunitySelectionBean>() {
            @Override
            public void onSuccess(final CommunitySelectionBean response) {
                selectionNextUrl = response.getData().getInfo().getNext_url();
                refreshDate(response);
                mAdapter.setList(list);
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

        mRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,
                Color.YELLOW,Color.GREEN);
        //这句话是为了，第一次进入页面的时候显示加载进度条
        mRefreshLayout.setProgressViewOffset(false,0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,24,getResources().getDisplayMetrics()));
        mRefreshLayout.setOnRefreshListener(this);

        mRecyclerView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                lastVisibleItem =  manager.findLastVisibleItemPosition();
                if (newState ==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 ==mAdapter.getItemCount()){
                    NetTool.getInstance().startRequest(selectionNextUrl, CommunitySelectionBean.class, new onHttpCallBack<CommunitySelectionBean>() {
                        @Override
                        public void onSuccess(final CommunitySelectionBean response) {
                            selectionNextUrl = response.getData().getInfo().getNext_url();
                            refreshDate(response);
                            mAdapter.setList(list);

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

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = manager.findLastVisibleItemPosition();
            }
        });

    }

    //下拉刷新
    @Override
    public void onRefresh() {
        NetTool.getInstance().startRequest(selectionUrl, CommunitySelectionBean.class, new onHttpCallBack<CommunitySelectionBean>() {
            @Override
            public void onSuccess(final CommunitySelectionBean response) {
                mRefreshLayout.setRefreshing(false);
                refreshDate(response);
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


    public void refreshDate(CommunitySelectionBean response){
        for (int i = 0; i < response.getData().getPosts().size(); i++) {
            MyDataBean data = new MyDataBean();
            data.setContent(response.getData().getPosts().get(i).getContent())
                    .setCount(response.getData().getPosts().get(i).getComment_count())
                    .setDate(response.getData().getPosts().get(i).getList_date())
                    .setHotNum(response.getData().getPosts().get(i).getHot_num())
                    .setIcon(response.getData().getPosts().get(i).getAuther().getIcon())
                    .setLikeNum(response.getData().getPosts().get(i).getLike_num())
                    .setName(response.getData().getPosts().get(i).getAuther().getName())
                    .setTitle(response.getData().getPosts().get(i).getTitle())
            ;
            data.setThumbnail_medias(response.getData().getPosts().get(i).getThumbnail_medias());
            list.add(data);

        }
    }


}
