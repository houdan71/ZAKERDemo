package com.example.dllo.zaker.playfun.location;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;

/**
 * Created by yuxiaomin~ on 16/9/5.
 */
public class PlayFunLocationTagActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mLlBack;

    private TextView locationCity, locationTv;

    private ImageView mViewBack;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_playfun_location_background:
                locationCity.setTextColor(0xfff53235);
                locationTv.setTextColor(0xfff53235);

                Intent intent = new Intent(this, PlayFunLocationChooseActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_playfun_location_back:
                finish();
                break;
        }
    }
}
