package com.example.dllo.zaker.hotspot.sec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.hotspot.HotspotFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/31.
 */
public class HotspotSecActivity extends BaseActivity implements View.OnClickListener {
    public static final String KEY_webUrll = "webUrll";
    public static final String KEY_postionItemm = "KEY_postionItemm";
    public static final String KEY_seekPro = "KEY_seekPro";

    private ImageView more;
    private AlertDialog mDialog;
    private SeekBar seekBar;
    private HotspotSecWebFragment webFragment;
    private int pro;

    private Intent mIntentBrocastPro;
    public static final String ACTION_PRO = "com.example.dllo.zaker.hotspot.sec.ACTION_PRO";
    private ImageView mImageViewBack;

    @Override
    protected int getLayout() {
        overridePendingTransition(R.anim.activity_in_anim,R.anim.activity_out_anim);
        return R.layout.activity_hotspot_sec_main;
    }

    @Override
    protected void initView() {
        more = (ImageView) findViewById(R.id.second_include_img_set);
        mImageViewBack = (ImageView) findViewById(R.id.second_include_img_back);

    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        ArrayList<HotspotSecBean> bean = intent.getParcelableArrayListExtra(HotspotFragment.KEY_webUrl);
        int positionItem = intent.getIntExtra(HotspotFragment.KEY_postionItem, 0);
        for (int i = 0; i < bean.size(); i++) {
            Log.d("HotspotSecActivity", bean.get(i).getWebUrl());
        }

        //替换fragment
        FragmentManager manager = getSupportFragmentManager();
        webFragment = new HotspotSecWebFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_webUrll, bean);
        bundle.putInt(KEY_postionItemm, positionItem);

        Log.d("AllFragment", String.valueOf(bean));
        webFragment.setArguments(bundle);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frame_hotspot_replace, webFragment).commit();

        //更多的按钮
        more.setOnClickListener(this);
        mDialog = createDialog();

        mImageViewBack.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.second_include_img_set:
                mDialog.show();

                WindowManager.LayoutParams params = mDialog.getWindow().getAttributes();
                params.height = 900;
                params.height = 450;
                mDialog.getWindow().setAttributes(params);
                break;
            case R.id.second_include_img_back:
                finish();
                break;
        }
    }


    //创建夜间模式以及字体大小的dialog
    private AlertDialog createDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
      View view = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.activity_hotspot_sec_dialog, null);
        builder.setView(view);
//        builder.setCancelable(false);

        seekBar = (SeekBar) view.findViewById(R.id.seekbar_text_size);
        //显示的字体大小
        final TextView tSize = (TextView) view.findViewById(R.id.tv_text_size_num);

        seekBar.setMax(200);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              mIntentBrocastPro = new Intent(ACTION_PRO);
               mIntentBrocastPro.putExtra(KEY_seekPro,progress);
                Log.d("HotspotSecActivity", "progress:" + mIntentBrocastPro.getIntExtra(KEY_seekPro,0));
//                mIntentBrocastPro.setAction(ACTION_PRO);
                sendBroadcast(mIntentBrocastPro);

                tSize.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        AlertDialog dialog = builder.create();
        return dialog;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_in_anim,R.anim.activity_out_anim);
    }
}
