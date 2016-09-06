package com.example.dllo.zaker.playfun;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.MAppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.dllo.zaker.R;
import com.mingle.circletreveal.CircularRevealCompat;
import com.mingle.skin.SkinConfig;
import com.mingle.skin.SkinStyle;
import com.mingle.skin.hepler.SkinCompat;
import com.mingle.widget.animation.CRAnimation;
import com.mingle.widget.animation.SimpleAnimListener;

/**
 * Created by dllo on 16/8/31.
 */
public class SecondLevelWebViewActivity extends MAppCompatActivity implements OnClickListener {
    private WebView mWebView;
    private String webUrl;
    //获取到传递给二级界面的|Intent的值
    private Intent secondIntent;

    private Button setIV;
    private  View ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel);
        ll = findViewById(R.id.ll);

        mWebView = (WebView) findViewById(R.id.secondLevel_webView);
        setIV = (Button) findViewById(R.id.btn);
        setIV.setOnClickListener(this);

        WebSettings settings = mWebView.getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);

        //当点击链接时,希望覆盖而不是打开新窗口
        mWebView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                view.loadUrl(url);
                return true;
            }
        });

        //点击后退按钮,让WebView后退一页(也可以覆写Activity的onKeyDown方法)
        mWebView.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN){
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
                        mWebView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });


        //二级界面的intent
        secondIntent = getIntent();
        webUrl = secondIntent.getStringExtra("WebUrl");
        mWebView.loadUrl(webUrl);



    }

    @Override
    public void onClick(View v) {
        CRAnimation crA =
                new CircularRevealCompat(ll).circularReveal(ll.getWidth() / 2, ll.getHeight() / 2, ll.getWidth(), 0);

        if (crA != null) {
            crA.addListener(new SimpleAnimListener() {
                @Override
                public void onAnimationEnd(CRAnimation animation) {
                    super.onAnimationEnd(animation);
                    ll.setVisibility(View.GONE);
                    SkinStyle skinStyle = null;
                    if (SkinConfig.getSkinStyle(SecondLevelWebViewActivity.this) == SkinStyle.Dark) {
                        skinStyle = SkinStyle.Light;
                    } else {
                        skinStyle = SkinStyle.Dark;
                    }
                    SkinCompat.setSkinStyle(SecondLevelWebViewActivity.this, skinStyle, mSkinStyleChangeListenerImp) ;
                }
            });
            crA.start();

        }
    }

    private SkinStyleChangeListenerImp mSkinStyleChangeListenerImp=new SkinStyleChangeListenerImp();
    class SkinStyleChangeListenerImp implements SkinCompat.SkinStyleChangeListener {

        @Override
        public void beforeChange() {

        }

        @Override
        public void afterChange() {

            ll.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ll.setVisibility(View.VISIBLE);

                    ll.setVisibility(View.VISIBLE);

                    CRAnimation crA =
                            new CircularRevealCompat(ll).circularReveal(ll.getWidth() / 2, ll.getHeight() / 2, 0, ll.getWidth());

                    if (crA != null)
                        crA.start();
                }
            },600);


        }

    }
}
