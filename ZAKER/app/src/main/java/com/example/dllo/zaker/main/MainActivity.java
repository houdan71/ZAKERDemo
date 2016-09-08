package com.example.dllo.zaker.main;

import android.content.Intent;
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
import com.example.dllo.zaker.hotspot.tag.HotspotTagActivity;
import com.example.dllo.zaker.playfun.PlayFunFragment;
import com.example.dllo.zaker.playfun.location.PlayFunLocationTagActivity;
import com.example.dllo.zaker.subscription.SubscriptionFragment;
import com.example.dllo.zaker.tools.Titanic;
import com.example.dllo.zaker.tools.TitanicTextView;

public class MainActivity extends FragmentActivity implements OnClickListener {

    private RadioButton subscriptionRB, hotspotRB, playFunRB, communityRB;
    private ImageView tagSubscriptionIV, tagHotspotIV, tagPlayFunIV;
    private TextView tagTV;
    private TitanicTextView titleTV;
    private Titanic mTitanic;
    private ImageView ivTagPlayFun;
    private ImageView ivTagHotsPot;


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
        titleTV = (TitanicTextView) findViewById(R.id.include_textView_title);
        tagTV = (TextView) findViewById(R.id.include_textView_tag);

        ivTagPlayFun = (ImageView) findViewById(R.id.include_img_tag_playFun);
        ivTagHotsPot = (ImageView) findViewById(R.id.include_img_tag_hotspot);
    }

    private void initData() {
        mTitanic = new Titanic();
        mTitanic.start(titleTV);
        subscriptionRB.setOnClickListener(this);
        hotspotRB.setOnClickListener(this);
        playFunRB.setOnClickListener(this);
        communityRB.setOnClickListener(this);

        replaceFragment(R.id.frame_replace, new SubscriptionFragment());
        tagSubscriptionIV.setVisibility(View.VISIBLE);
        tagPlayFunIV.setVisibility(View.GONE);
        tagHotspotIV.setVisibility(View.GONE);

        subscriptionRB.setTextColor(0xfff53235);
        hotspotRB.setTextColor(0xff6d6d6d);
        playFunRB.setTextColor(0xff6d6d6d);
        communityRB.setTextColor(0xff6d6d6d);

        ivTagPlayFun.setOnClickListener(this);
        ivTagHotsPot.setOnClickListener(this);
    }

    public void replaceFragment(int id, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radioBtn_subscription:
                replaceFragment(R.id.frame_replace, new SubscriptionFragment());
                tagSubscriptionIV.setVisibility(View.VISIBLE);
                tagPlayFunIV.setVisibility(View.GONE);
                tagHotspotIV.setVisibility(View.GONE);
                titleTV.setText("订阅");
                tagTV.setText("");

                subscriptionRB.setTextColor(0xfff53235);
                hotspotRB.setTextColor(0xff6d6d6d);
                playFunRB.setTextColor(0xff6d6d6d);
                communityRB.setTextColor(0xff6d6d6d);
                break;
            case R.id.radioBtn_hotspot:
                replaceFragment(R.id.frame_replace, new HotspotFragment());

                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.GONE);
                tagHotspotIV.setVisibility(View.VISIBLE);
                titleTV.setText("热点");
                tagTV.setText("");

                hotspotRB.setTextColor(0xfff53235);
                subscriptionRB.setTextColor(0xff6d6d6d);
                playFunRB.setTextColor(0xff6d6d6d);
                communityRB.setTextColor(0xff6d6d6d);
                break;
            case R.id.radioBtn_playFun:
                replaceFragment(R.id.frame_replace, new PlayFunFragment());
                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.VISIBLE);
                tagHotspotIV.setVisibility(View.GONE);

                titleTV.setText("玩乐");
                tagTV.setText("大连");

                playFunRB.setTextColor(0xfff53235);
                subscriptionRB.setTextColor(0xff6d6d6d);
                hotspotRB.setTextColor(0xff6d6d6d);
                communityRB.setTextColor(0xff6d6d6d);
                break;
            case R.id.radioBtn_community:
                replaceFragment(R.id.frame_replace, new CommunityFragment());
                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.GONE);
                tagHotspotIV.setVisibility(View.GONE);
                titleTV.setText("社区");
                tagTV.setText("");

                communityRB.setTextColor(0xfff53235);
                subscriptionRB.setTextColor(0xff6d6d6d);
                playFunRB.setTextColor(0xff6d6d6d);
                hotspotRB.setTextColor(0xff6d6d6d);
                break;
            case R.id.include_img_tag_playFun:
                Intent intent = new Intent(this, PlayFunLocationTagActivity.class);
                startActivity(intent);
                break;
            case R.id.include_img_tag_hotspot:
                Intent intentHotspot = new Intent(this,HotspotTagActivity.class);
                startActivity(intentHotspot);
        }
    }

}
