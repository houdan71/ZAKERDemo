package com.example.dllo.zaker.subscription.activity;

import android.widget.ImageView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;

/**
 * Created by dllo on 16/8/31.
 */
public class OlympicActivity extends BaseActivity {
    private ImageView image_oly;
    @Override
    protected int getLayout() {
        return R.layout.activity_olympic;
    }

    @Override
    protected void initView() {
        image_oly = (ImageView) findViewById(R.id.image_oly);

    }

    @Override
    protected void initData() {

    }
}
