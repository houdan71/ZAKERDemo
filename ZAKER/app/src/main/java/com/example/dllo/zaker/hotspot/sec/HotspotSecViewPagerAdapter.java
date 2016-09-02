package com.example.dllo.zaker.hotspot.sec;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
 */
public class HotspotSecViewPagerAdapter extends PagerAdapter {

    private ArrayList<HotspotSecBean> mArrayList;
    private WebView mWebView;
    private int positionItem;


    public void setArrayList(ArrayList<HotspotSecBean> arrayList, int positionItem) {
        mArrayList = arrayList;
        this.positionItem = positionItem;
        notifyDataSetChanged();
        for (int i = 0; i < mArrayList.size(); i++) {
            Log.d("HotspotSecViewPagerAdap", mArrayList.get(i).getWebUrl());
        }
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_sec_web_content, null);
        mWebView = (WebView) view.findViewById(R.id.web_view_hotspot_sec_web);

        WebSettings settings = mWebView.getSettings();

        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        //当点击链接时,希望覆盖而不是打开新窗口
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
        mWebView.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                        mWebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });

        for (int i = 0; i < mArrayList.size(); i++) {
            Log.d("HotspotSecViewPagerAdap", mArrayList.get(i).getWebUrl());
        }

        //添加加载的webUrl
        mWebView.loadUrl(mArrayList.get(positionItem).getWebUrl());
        Log.d("HotspotSecViewPagerAdap", "positionItem:" + positionItem);

        mWebView.loadUrl(mArrayList.get(position).getWebUrl());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
