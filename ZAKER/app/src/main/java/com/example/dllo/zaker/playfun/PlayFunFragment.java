package com.example.dllo.zaker.playfun;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.playfun.rotate.RotateAdapter;
import com.example.dllo.zaker.playfun.viewpager.ViewPagerAdapter;
import com.example.dllo.zaker.playfun.viewpager.ViewPagerAdapter.OnRecyclerItemClickListener;
import com.example.dllo.zaker.playfun.viewpager.ViewPagerAdapter.ViewHolder;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;

/**
 * Created by dllo on 16/8/29.
 */
public class PlayFunFragment extends BaseFragment {
    private ListView mListView;
    private PlayFunFragmentAdapter mPlayFunFragmentAdapter;
    private String playUrl = "http://wl.myzaker.com/?_appid=AndroidPhone&_v=6.7&_version=6.7&c=columns&city=%E5%A4%A7%E8%BF%9E";
    private ViewPager playFunVP;
    private RecyclerView playFunRV;
    private RotateAdapter mRotateAdapter;
    private ViewPagerAdapter mViewPagerAdapter;

    /**
     * 轮播图的实现
     */
    private Handler mHandler;
    private boolean isFlag = true;
    private boolean flag = true;

    @Override
    protected int initLayout() {
        return R.layout.fragment_playfun;
    }

    @Override
    protected void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.fragment_playFun_listView);

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



}
