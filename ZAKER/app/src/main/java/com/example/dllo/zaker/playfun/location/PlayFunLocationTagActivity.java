package com.example.dllo.zaker.playfun.location;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;
import com.example.dllo.zaker.base.BaseActivity;

/**
 * Created by yuxiaomin~ on 16/9/5.
 */
public class PlayFunLocationTagActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mLlBack;
    private TextView locationCity, locationTv;
    private ImageView mViewBack;
    private String cityText;
    private static final String SP_KEY_CITY_TEXT = "com.example.dllo.zaker.SP_KEY_CITY_TEXT";
    private static final String SP_KEY_CITY_TEXT_flag = "com.example.dllo.zaker.SP_KEY_CITY_TEXT_flag";
    private static final String SP_CITY = "com.example.dllo.zaker.SP_CITY";

    @Override
    protected int getLayout() {
        return R.layout.activity_playfun_lication_tag;
    }

    @Override
    protected void initView() {
        mLlBack = (LinearLayout) findViewById(R.id.ll_playfun_location_background);
        locationTv = (TextView) findViewById(R.id.tv_playfun_location);
        locationCity = (TextView) findViewById(R.id.tv_playfun_location_city);
        mViewBack = (ImageView) findViewById(R.id.iv_playfun_location_back);
    }

    @Override
    protected void initData() {

        mLlBack.setOnClickListener(this);
        mViewBack.setOnClickListener(this);


        Intent intent = getIntent();
        String loca = intent.getStringExtra("loc");
        Log.d("PlayFunLocationTagActiv", loca);

        //判断是否有设置的状态
//        SharedPreferences getSp = MyApp.getContext().getSharedPreferences(SP_CITY, Context.MODE_PRIVATE);
//        if (getSp.getBoolean(SP_KEY_CITY_TEXT_flag, false)) {
//
//            cityText = getSp.getString(SP_KEY_CITY_TEXT,loca);
            locationCity.setText(loca);
//        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_playfun_location_background:
                locationCity.setTextColor(0xfff53235);
                locationTv.setTextColor(0xfff53235);

                Intent intent = new Intent(this, PlayFunLocationChooseActivity.class);
                startActivityForResult(intent, 200);
                break;
            case R.id.iv_playfun_location_back:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == 200) {
            String city = data.getStringExtra("back");
            cityText = city;
            locationCity.setText(city);

            //保存设置状态
            SharedPreferences sp = MyApp.getContext().getSharedPreferences(SP_CITY, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(SP_KEY_CITY_TEXT, city);
            editor.putBoolean(SP_KEY_CITY_TEXT_flag, true);
            editor.apply();

        }
    }

}
