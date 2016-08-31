package com.example.dllo.zaker.playfun;

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
            public void onSuccess(PlayFunBean response) {
                mPlayFunFragmentAdapter.setPlayFunBean(response);
                mListView.setAdapter(mPlayFunFragmentAdapter);

                mRotateAdapter.setPlayFunBean(response);
                playFunVP.setAdapter(mRotateAdapter);

                LinearLayoutManager manager = new LinearLayoutManager(mContext);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                playFunRV.setLayoutManager(manager);
                mViewPagerAdapter.setPlayFunBean(response);
                playFunRV.setAdapter(mViewPagerAdapter);


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
