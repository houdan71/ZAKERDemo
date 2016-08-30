package com.example.dllo.zaker.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.community.CommunityFragment;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.playfun.PlayFunFragment;
import com.example.dllo.zaker.subscription.SubscriptionFragment;

public class MainActivity extends FragmentActivity implements OnClickListener {

    private RadioButton subscriptionRB,hotspotRB,playFunRB,communityRB;
    private ImageView tagSubscriptionIV,tagHotspotIV,tagPlayFunIV;
    private TextView titleTV,tagTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        subscriptionRB = (RadioButton) findViewById(R.id.radioBtn_subscription);
        hotspotRB = (RadioButton) findViewById(R.id.radioBtn_hotspot);
        playFunRB = (RadioButton) findViewById(R.id.radioBtn_playFun);
        communityRB = (RadioButton) findViewById(R.id.radioBtn_community);
        tagSubscriptionIV = (ImageView) findViewById(R.id.include_img_tag_subscription);
        tagHotspotIV = (ImageView) findViewById(R.id.include_img_tag_hotspot);
        tagPlayFunIV = (ImageView) findViewById(R.id.include_img_tag_playFun);
        titleTV = (TextView) findViewById(R.id.include_textView_title);
        tagTV = (TextView) findViewById(R.id.include_textView_tag);
    }

    private void initData() {
        subscriptionRB.setOnClickListener(this);
        hotspotRB.setOnClickListener(this);
        playFunRB.setOnClickListener(this);
        communityRB.setOnClickListener(this);

        replaceFragment(R.id.frame_replace,new SubscriptionFragment());
        tagSubscriptionIV.setVisibility(View.VISIBLE);
        tagPlayFunIV.setVisibility(View.GONE);
        tagHotspotIV.setVisibility(View.GONE);
    }

    public void replaceFragment(int id, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id,fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioBtn_subscription:
                replaceFragment(R.id.frame_replace,new SubscriptionFragment());
                tagSubscriptionIV.setVisibility(View.VISIBLE);
                tagPlayFunIV.setVisibility(View.GONE);
                tagHotspotIV.setVisibility(View.GONE);
                titleTV.setText("订阅");
                tagTV.setText("");
                break;
            case R.id.radioBtn_hotspot:
                replaceFragment(R.id.frame_replace,new HotspotFragment());
                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.VISIBLE);
                tagHotspotIV.setVisibility(View.GONE);
                titleTV.setText("热点");
                tagTV.setText("");
                break;
            case R.id.radioBtn_playFun:
                replaceFragment(R.id.frame_replace,new PlayFunFragment());
                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.GONE);
                tagHotspotIV.setVisibility(View.VISIBLE);
                titleTV.setText("玩乐");
                tagTV.setText("大连");
                break;
            case R.id.radioBtn_community:
                replaceFragment(R.id.frame_replace,new CommunityFragment());
                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.GONE);
                tagHotspotIV.setVisibility(View.GONE);
                titleTV.setText("社区");
                tagTV.setText("");
                break;
        }
    }

}
