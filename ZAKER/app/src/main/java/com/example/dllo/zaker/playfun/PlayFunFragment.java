package com.example.dllo.zaker.playfun;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.main.MetaballView;
import com.example.dllo.zaker.playfun.pulldown.JingDongListView;
import com.example.dllo.zaker.playfun.pulldown.JingDongListView.OnJingDongRefreshListener;
import com.example.dllo.zaker.playfun.rotate.RotateAdapter;
import com.example.dllo.zaker.playfun.viewpager.ViewPagerAdapter;
import com.example.dllo.zaker.playfun.viewpager.ViewPagerAdapter.OnRecyclerItemClickListener;
import com.example.dllo.zaker.playfun.viewpager.ViewPagerAdapter.ViewHolder;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;

/**
 * Created by dllo on 16/8/29.
 */
public class PlayFunFragment extends BaseFragment implements OnJingDongRefreshListener, OnScrollListener {
    private JingDongListView mListView;
    private PlayFunFragmentAdapter mPlayFunFragmentAdapter;
    private String playUrl = "http://wl.myzaker.com/?_appid=AndroidPhone&_v=6.7&_version=6.7&c=columns&city=%E5%A4%A7%E8%BF%9E";
    private ViewPager playFunVP;
    private RecyclerView playFunRV;
    private RotateAdapter mRotateAdapter;
    private ViewPagerAdapter mViewPagerAdapter;

    /**
     * 设置加载的小红球的
     */
    private MetaballView metaballView;

    /**
     * 轮播图的实现
     */
    private Handler mHandler;
    private boolean isFlag = true;
    private boolean flag = true;
    private boolean isFirst = true;

    private final static int REFRESH_COMPLETE = 0;
    private Handler refreshHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mListView.setOnRefreshComplete();
                    mRotateAdapter.notifyDataSetChanged();
                    mViewPagerAdapter.notifyDataSetChanged();
                    mPlayFunFragmentAdapter.notifyDataSetChanged();
                    mListView.setSelection(0);
                    break;

                default:
                    break;
            }
        };
    };

    @Override
    protected int initLayout() {
        return R.layout.fragment_playfun;
    }

    @Override
    protected void initView(View view) {
        mListView = (JingDongListView) view.findViewById(R.id.fragment_playFun_listView);
        metaballView = (MetaballView) view.findViewById(R.id.metaballView);
    }

    @Override
    protected void initData() {
        View rotateHead = getActivity().getLayoutInflater().inflate(R.layout.item_fragment_playfun_listview_rotate,null);
        View viewPagerHead = getActivity().getLayoutInflater().inflate(R.layout.item_fragment_playfun_listview_viewpager,null);
        playFunRV = (RecyclerView) viewPagerHead.findViewById(R.id.playFun_recyclerView_viewPager);
        playFunVP = (ViewPager) rotateHead.findViewById(R.id.playFun_viewPager_rotate);

        //加载头布局
        mListView.addHeaderView(rotateHead);
        mListView.addHeaderView(viewPagerHead);

        mRotateAdapter = new RotateAdapter(mContext);
        mViewPagerAdapter = new ViewPagerAdapter(mContext);
        mPlayFunFragmentAdapter = new PlayFunFragmentAdapter(mContext);

        NetTool.getInstance().startRequest(playUrl, PlayFunBean.class, new onHttpCallBack<PlayFunBean>() {
            @Override
            public void onSuccess(final PlayFunBean response) {
                metaballView.setPaintMode(1);
                metaballView.setVisibility(View.GONE);

                mPlayFunFragmentAdapter.setPlayFunBean(response);
                mListView.setAdapter(mPlayFunFragmentAdapter);

                mRotateAdapter.setPlayFunBean(response);
                playFunVP.setAdapter(mRotateAdapter);

                final LinearLayoutManager manager = new LinearLayoutManager(mContext);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                playFunRV.setLayoutManager(manager);
                mViewPagerAdapter.setPlayFunBean(response);
                playFunRV.setAdapter(mViewPagerAdapter);

                //给ViewPager设置监听事件 跳转到不同的界面
                mViewPagerAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                    @Override
                    public void onItemClick(View view, ViewHolder holder, int position) {
                        if (response.getData().getDisplay().get(position).getType().equals("web") ){
                            Intent intent = new Intent(mContext, SecondLevelWebViewActivity.class);
                            intent.putExtra("WebUrl",response.getData().getDisplay().get(position).getWeb().getUrl());
                            startActivity(intent);
                        }else if (response.getData().getDisplay().get(position).getType().equals("block")){
                            Intent intent  = new Intent(mContext,SecondLevelViewPagerActivity.class);
                            intent.putExtra("listUrl",response.getData().getDisplay().get(position).getBlock_info().getApi_url());
                            startActivity(intent);
                        }
                    }
                });

            }
            @Override
            public void onError(Throwable e) {
            }
        });
        shuffling();

        //设置ListView的下拉监听
        mListView.setOnJingDongRefreshListener(this);
        //ListView上拉加载
        mListView.setOnScrollListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirst) {
            isFirst = false;
            return;
        }else {
            metaballView.setVisibility(View.GONE);
        }
    }


    //实现轮播效果
    private void shuffling() {
        mHandler = new Handler(new Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                playFunVP.setCurrentItem(playFunVP.getCurrentItem() + 1);
                return false;
            }
        });


        if (isFlag) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (flag) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        mHandler.sendEmptyMessage(0);
                    }
                }
            }).start();
            isFlag = false;
        }
    }


    //ListView的下拉事件
    @Override
    public void onRefresh() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);

                    NetTool.getInstance().startRequest(playUrl, PlayFunBean.class, new onHttpCallBack<PlayFunBean>() {
                        @Override
                        public void onSuccess(final PlayFunBean response) {
                            metaballView.setPaintMode(1);
                            metaballView.setVisibility(View.GONE);

                            mPlayFunFragmentAdapter.setPlayFunBean(response);
                            mListView.setAdapter(mPlayFunFragmentAdapter);

                            mRotateAdapter.setPlayFunBean(response);
                            playFunVP.setAdapter(mRotateAdapter);

                            final LinearLayoutManager manager = new LinearLayoutManager(mContext);
                            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                            playFunRV.setLayoutManager(manager);
                            mViewPagerAdapter.setPlayFunBean(response);
                            playFunRV.setAdapter(mViewPagerAdapter);

                            //给ViewPager设置监听事件 跳转到不同的界面
                            mViewPagerAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                                @Override
                                public void onItemClick(View view, ViewHolder holder, int position) {
                                    if (response.getData().getDisplay().get(position).getType().equals("web") ){
                                        Intent intent = new Intent(mContext, SecondLevelWebViewActivity.class);
                                        intent.putExtra("WebUrl",response.getData().getDisplay().get(position).getWeb().getUrl());
                                        startActivity(intent);
                                    }else if (response.getData().getDisplay().get(position).getType().equals("block")){
                                        Intent intent  = new Intent(mContext,SecondLevelViewPagerActivity.class);
                                        intent.putExtra("listUrl",response.getData().getDisplay().get(position).getBlock_info().getApi_url());
                                        startActivity(intent);
                                    }
                                }
                            });

                        }
                        @Override
                        public void onError(Throwable e) {
                        }
                    });
                    refreshHandler.sendEmptyMessage(REFRESH_COMPLETE);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}

