package com.example.dllo.zaker.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.community.CommunityFragment;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.tag.HotspotTagNewActivity;
import com.example.dllo.zaker.login.LoginActivity;
import com.example.dllo.zaker.playfun.PlayFunFragment;
import com.example.dllo.zaker.playfun.location.PlayFunLocationChooseActivity;
import com.example.dllo.zaker.playfun.location.PlayFunLocationTagActivity;
import com.example.dllo.zaker.subscription.SubscriptionFragment;
<<<<<<< HEAD
import com.example.dllo.zaker.subscription.activity.AddActivity;
=======
import com.example.dllo.zaker.tools.MarqueeTextView;
>>>>>>> 5946ad41d1abd63ef623780ef62a3d8caaf8ec8b
import com.example.dllo.zaker.tools.Titanic;
import com.example.dllo.zaker.tools.TitanicTextView;

public class MainActivity extends FragmentActivity implements OnClickListener {
    private RadioButton subscriptionRB, hotspotRB, playFunRB, communityRB;
    private ImageView tagSubscriptionIV, tagHotspotIV, tagPlayFunIV;
    private MarqueeTextView tagTV;
    private TitanicTextView titleTV;
    private Titanic mTitanic;
    private ImageView ivTagPlayFun;
    private ImageView ivTagHotsPot;

    private LocationClient locationClient = null;
    private String locationStr;
    private ImageView ivPersonal;

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
        tagTV = (MarqueeTextView) findViewById(R.id.include_textView_tag);

        ivTagPlayFun = (ImageView) findViewById(R.id.include_img_tag_playFun);
        ivTagHotsPot = (ImageView) findViewById(R.id.include_img_tag_hotspot);

        ivPersonal = (ImageView) findViewById(R.id.include_img_personal);
    }

    private void initData() {
        mTitanic = new Titanic();
        mTitanic.start(titleTV);
        subscriptionRB.setOnClickListener(this);
        hotspotRB.setOnClickListener(this);
        playFunRB.setOnClickListener(this);
        communityRB.setOnClickListener(this);
        ivPersonal.setOnClickListener(this);

        tagSubscriptionIV.setOnClickListener(this);

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

        locationClient = new LocationClient(this);
        //设置定位条件
        initLocation();
        //注册位置监听器
        locationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation location) {
                // TODO Auto-generated method stub
                if (location == null) {
                    return;
                }
                StringBuffer sb = new StringBuffer(256);
                if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                    sb.append(location.getAddrStr());
                }
                locationStr = sb.toString();
                CityBean cityBean = new CityBean();
                cityBean.setCity(locationStr);

            }
        });

        locationClient.start();
                        /*

	                     *当所设的整数值大于等于1000（ms）时，定位SDK内部使用定时定位模式。

	                     *调用requestLocation( )后，每隔设定的时间，定位SDK就会进行一次定位。

	                     *如果定位SDK根据定位依据发现位置没有发生变化，就不会发起网络请求，

	                     *返回上一次定位的结果；如果发现位置改变，就进行网络请求进行定位，得到新的定位结果。

	                     *定时定位时，调用一次requestLocation，会定时监听到定位结果。

	                     */
        locationClient.requestLocation();
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
                tagTV.setVisibility(View.GONE);

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
                tagTV.setVisibility(View.GONE);

                hotspotRB.setTextColor(0xfff53235);
                subscriptionRB.setTextColor(0xff6d6d6d);
                playFunRB.setTextColor(0xff6d6d6d);
                communityRB.setTextColor(0xff6d6d6d);
                break;
            case R.id.radioBtn_playFun:
                replaceFragment(R.id.frame_replace, new PlayFunFragment());

                SharedPreferences getSp = getSharedPreferences("location", MODE_PRIVATE);
                if (getSp.getBoolean("dialog", true)) {
                    dialog();
                }
                tagSubscriptionIV.setVisibility(View.GONE);
                tagPlayFunIV.setVisibility(View.VISIBLE);
                tagHotspotIV.setVisibility(View.GONE);

                titleTV.setText("玩乐");
                tagTV.setVisibility(View.VISIBLE);
                tagTV.setTextColor(Color.WHITE);
                tagTV.setText(locationStr);

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
                tagTV.setVisibility(View.GONE);

                communityRB.setTextColor(0xfff53235);
                subscriptionRB.setTextColor(0xff6d6d6d);
                playFunRB.setTextColor(0xff6d6d6d);
                hotspotRB.setTextColor(0xff6d6d6d);
                break;
            case R.id.include_img_tag_playFun:
                Intent intent = new Intent(this, PlayFunLocationTagActivity.class);
                intent.putExtra("loc", locationStr);
                startActivity(intent);
                break;
            case R.id.include_img_tag_hotspot:
                Intent intentHotspot = new Intent(this, HotspotTagNewActivity.class);
                startActivity(intentHotspot);
<<<<<<< HEAD
            case R.id.include_img_tag_subscription:
                Intent intentsub =new Intent(this, AddActivity.class);
                startActivity(intentsub);
=======
                break;
            case R.id.include_img_personal:
                Intent intentP = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentP);
>>>>>>> 5946ad41d1abd63ef623780ef62a3d8caaf8ec8b
                break;
        }
    }

    private void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main_location_dialog, null);
        builder.setView(view);
        TextView textView = (TextView) view.findViewById(R.id.tv_main_location_city);
        textView.setText(locationStr);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("切换", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, PlayFunLocationChooseActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();

        SharedPreferences sp = getSharedPreferences("location", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("dialog", false);
        editor.apply();
    }


    @Override

    protected void onDestroy() {
        super.onDestroy();
        if (locationClient != null && locationClient.isStarted()) {
            locationClient.stop();
            locationClient = null;
        }
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("gcj02");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
//        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        locationClient.setLocOption(option);
    }


}
