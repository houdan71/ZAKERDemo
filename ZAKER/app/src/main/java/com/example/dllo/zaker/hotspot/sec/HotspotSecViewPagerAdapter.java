package com.example.dllo.zaker.hotspot.sec;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
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
    private WebSettings settings;
    private int fontSize = 1;
    private int pro;
    private static final String SP_TEXTSIZE = "com.example.dllo.zaker.hotspot.sec.SP_TEXTSIZE";
    private static final String SP_KEY_TEXTSIZE_CURRENT = "textSizeCurrent";
    private static final String SP_KEY_TEXTSIZE_flag = "tag";

    public void setPro(int pro) {
        this.pro = pro;
        notifyDataSetChanged();
        Log.d("HotspotSecViewPagerAdap", "pro:" + pro);
        seekTo(pro);
    }

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

//        mWebView.setBackgroundColor(Color.BLUE);

        settings = mWebView.getSettings();
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

        //添加加载的webUrl
        Log.d("HotspotSecViewPagerAdap", "positionItem:" + positionItem);
        mWebView.loadUrl(mArrayList.get(position).getWebUrl());
//        settings.setTextSize(WebSettings.TextSize.LARGEST);
        Log.d("HotspotSecViewPagerAdap", "pro:" + pro);

        SharedPreferences getSp = MyApp.getContext().getSharedPreferences(SP_TEXTSIZE, Context.MODE_PRIVATE);
        if (getSp.getBoolean(SP_KEY_TEXTSIZE_flag, false)) {
            int size = getSp.getInt(SP_KEY_TEXTSIZE_CURRENT, 0);

            SharedPreferences sp = MyApp.getContext().getSharedPreferences(SP_TEXTSIZE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(SP_KEY_TEXTSIZE_flag, false);
            seekTo(size);

        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


    private void seekTo(int progress) {

        Log.d("HotspotSecViewPagerAdap", "progress:" + progress);

//        settings.setTextSize(TextSizee.SMALLEST);
//        pro = progress;
        if (settings.getTextSize() == WebSettings.TextSize.SMALLEST) {
            fontSize = 1;
        } else if (settings.getTextSize() == WebSettings.TextSize.SMALLER) {
            fontSize = 2;
        } else if (settings.getTextSize() == WebSettings.TextSize.NORMAL) {
            fontSize = 3;
        } else if (settings.getTextSize() == WebSettings.TextSize.LARGER) {
            fontSize = 4;
        } else if (settings.getTextSize() == WebSettings.TextSize.LARGEST) {
            fontSize = 5;
        }

        Log.d("HotspotSecViewPagerAdap", "fontSize:" + fontSize);
        if (progress == 0) {
            return;
        } else if (progress > 0 && progress <= 50) {
            fontSize = 1;
        } else if (progress > 50 && progress <= 75) {
            fontSize = 2;
        } else if (progress > 70 && progress <= 100) {
            fontSize = 3;
        } else if (progress > 100 && progress <= 150) {
            fontSize = 4;
        } else if (progress > 150) {
            fontSize = 5;
        }

        switch (fontSize) {
            case 1:
                settings.setTextSize(WebSettings.TextSize.SMALLEST);
                break;
            case 2:
                settings.setTextSize(WebSettings.TextSize.SMALLER);
                break;
            case 3:
                settings.setTextSize(WebSettings.TextSize.NORMAL);
                break;
            case 4:
                settings.setTextSize(WebSettings.TextSize.LARGER);
                break;
            case 5:
                settings.setTextSize(WebSettings.TextSize.LARGEST);
                break;
        }

        SharedPreferences sp = MyApp.getContext().getSharedPreferences(SP_TEXTSIZE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(SP_KEY_TEXTSIZE_CURRENT, progress);
        editor.putBoolean(SP_KEY_TEXTSIZE_flag, true);
        editor.apply();
    }


}
