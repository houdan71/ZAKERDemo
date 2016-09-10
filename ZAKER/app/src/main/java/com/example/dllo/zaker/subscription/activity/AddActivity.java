package com.example.dllo.zaker.subscription.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import android.text.Editable;
import android.text.TextUtils;


import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.ViewGroup;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.adapter.AddAdapter;
import com.example.dllo.zaker.subscription.add_fragment.ChannelFragment;
import com.example.dllo.zaker.subscription.add_fragment.EssenceFragment;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/31.
 */
public class AddActivity extends BaseActivity implements TextWatcher {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private ImageView image_back;
    //输入框
    private EditText edit_text;
    //搜索键
    private Button button_btn;







    @Override
    protected int getLayout() {
        return R.layout.activity_add;
    }

    @Override
    protected void initView() {

        tabLayout = (TabLayout) findViewById(R.id.tab_add_layout);
        viewPager = (ViewPager) findViewById(R.id.view_add_pager);
        image_back= (ImageView) findViewById(R.id.image_back);
        edit_text = (EditText) findViewById(R.id.edit_text);
        button_btn = (Button) findViewById(R.id.button_btn);

         edit_text.addTextChangedListener(this);

    }


    @Override
    protected void initData() {
        initfragment();
        AddAdapter addAdapter = new AddAdapter(getSupportFragmentManager(), fragmentList);


        viewPager.setAdapter(addAdapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(Color.BLUE, Color.RED);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initfragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new EssenceFragment());
        fragmentList.add(new ChannelFragment());
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
      //  Intent intent =new Intent (AddActivity.this,ClickActivity.class);
       // startActivity(intent);

    }

    @Override
    public void afterTextChanged(Editable s) {



    }



    }


