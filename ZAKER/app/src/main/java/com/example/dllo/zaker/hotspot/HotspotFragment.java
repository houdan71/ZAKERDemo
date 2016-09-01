package com.example.dllo.zaker.hotspot;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.hotspot.ListViewRefresh.CustomUltraRefreshHeader;
import com.example.dllo.zaker.hotspot.ListViewRefresh.UltraRefreshListView;
import com.example.dllo.zaker.hotspot.ListViewRefresh.UltraRefreshListener;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;


/**
 * Created by dllo on 16/8/29.
 */
public class HotspotFragment extends BaseFragment implements UltraRefreshListener, AdapterView.OnItemClickListener {

    private PtrClassicFrameLayout mPtrFrame;
    private UltraRefreshListView mLv;
    private HotspotAdapter mHotspotAdapter;
    private HotspotBean mHotspotBean;
//    private ArrayList<HotspotBean> mBeanArrayList;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<HotspotSecBean> mHotspotSecBeanArrayList;

    public static final String KEY_webUrl = "webUrl";
    public static final String KEY_postionItem = "postionItem";

    @Override
    protected int initLayout() {
        return R.layout.fragment_hotspot;
    }

    @Override
    protected void initView(View view) {
        mPtrFrame = (PtrClassicFrameLayout) getView().findViewById(R.id.ultra_ptr_hotspot);
        mLv = (UltraRefreshListView) getView().findViewById(R.id.ultra_hotspot);
    }

    @Override
    protected void initData() {
        mHotspotAdapter = new HotspotAdapter();
//        mBeanArrayList = new ArrayList<>();
        mHotspotSecBeanArrayList = new ArrayList<>();

        //创建我们的自定义头部视图
        CustomUltraRefreshHeader header = new CustomUltraRefreshHeader(getActivity());
        //设置头部视图
        mPtrFrame.setHeaderView(header);
        //设置视图修改的回调，因为我们的CustomUltraRefreshHeader实现了PtrUIHandler
        mPtrFrame.addPtrUIHandler(header);
        //设置数据刷新的会回调，因为UltraRefreshListView实现了PtrHandler
        mPtrFrame.setPtrHandler(mLv);
        NetTool.getInstance().startRequest(NValues.URL_HOTSPOT, HotspotBean.class, new onHttpCallBack<HotspotBean>() {
            @Override
            public void onSuccess(final HotspotBean response) {
                if (response.getData().getArticles().size() == 0) {
                    Toast.makeText(mContext, response.getData().getTip_msg(), Toast.LENGTH_SHORT).show();
                    return;
                } else {

//                    mBeanArrayList.add(response);
//                    Log.d("HotspotFragment", "mBeanArrayList.size():" + mBeanArrayList.size());
                    mHotspotAdapter.setBean(response);
                    mLv.setAdapter(mHotspotAdapter);
                    //设置数据刷新回调接口
                    mLv.setUltraRefreshListener(HotspotFragment.this);

                    //向webView页面传递数据
                    postToWebView(response);
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        mLv.setOnItemClickListener(this);

    }


    @Override
    public void onRefresh() {
//                datas.clear();
        NetTool.getInstance().startRequest(NValues.URL_HOTSPOT, HotspotBean.class, new onHttpCallBack<HotspotBean>() {
            @Override
            public void onSuccess(final HotspotBean response) {
                if (response.getData().getArticles().size() == 0) {
                    Toast.makeText(mContext, response.getData().getTip_msg(), Toast.LENGTH_SHORT).show();
                    return;
                } else {
//                    Log.d("HotspotFragment", "mBeanArrayList.size():" + mBeanArrayList.size());
                    mHotspotAdapter.addData(response);
                    mLv.setAdapter(mHotspotAdapter);
                    //设置数据刷新回调接口
                    mLv.setUltraRefreshListener(HotspotFragment.this);
                    //刷新完成
                    mLv.refreshComplete();
                    mHotspotAdapter.notifyDataSetChanged();
                }

                //向webView页面传递数据
                postToWebView(response);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void addMore() {
//        NetTool.getInstance().startRequest(NValues.URL_HOTSPOT, HotspotBean.class, new onHttpCallBack<HotspotBean>() {
//            @Override
//            public void onSuccess(final HotspotBean response) {
//                if (response.getData().getArticles().size() == 0) {
//                    Toast.makeText(mContext, response.getData().getTip_msg(), Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
////                    mBeanArrayList.add(response);
//                    mHotspotAdapter.addData(response);
//                    //设置数据刷新回调接口
//                    mLv.setUltraRefreshListener(HotspotFragment.this);
//                     //刷新完成
//                    mLv.refreshComplete();
//                    mHotspotAdapter.notifyDataSetChanged();
//                }
//
//                //向webView页面传递数据
//                postToWebView(response);
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("HotspotFragment", "strings:" + mHotspotSecBeanArrayList);
        Intent intent = new Intent(MyApp.getContext(), HotspotSecActivity.class);
        intent.putParcelableArrayListExtra(KEY_webUrl, mHotspotSecBeanArrayList);
        intent.putExtra(KEY_postionItem, position);
        for (int i = 0; i < mHotspotSecBeanArrayList.size(); i++) {
            Log.d("HotspotFragment", mHotspotSecBeanArrayList.get(i).getWebUrl());
        }
        startActivity(intent);
    }


    //向webView页面传递数据
    private void postToWebView(HotspotBean response) {
        for (int i = 0; i < response.getData().getArticles().size(); i++) {
            HotspotSecBean bean = new HotspotSecBean();
            bean.setWebUrl(response.getData().getArticles().get(i).getWeburl());
            bean.setPk(response.getData().getArticles().get(i).getPk());
            mHotspotSecBeanArrayList.add(bean);

            Log.d("HotspotFragmentMoreS", mHotspotSecBeanArrayList.get(i).getWebUrl());
            Log.d("HotspotFragmentMore", response.getData().getArticles().get(i).getWeburl());
        }
    }
}