package com.example.dllo.zaker.subscription.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.SubscriptionFragment;
import com.example.dllo.zaker.subscription.entity.Bean_technology;
import com.example.dllo.zaker.subscription.techonology_fragment.GeneralFragment;
import com.example.dllo.zaker.subscription.techonology_fragment.IntentFragment;
import com.example.dllo.zaker.subscription.techonology_fragment.NumberFragment;
import com.example.dllo.zaker.subscription.techonology_fragment.TechnoloFragment;
import com.mingle.widget.View;

/**
 * Created by dllo on 16/8/31.
 */
public class TechnologyActivity extends BaseActivity implements OnClickListener{
    private RadioButton radio_general,radio_number,radio_intent,radio_technolo;

    @Override
    protected int getLayout() {
        return R.layout.activity_technology;
    }

    @Override
    protected void initView() {
        radio_general= (RadioButton) findViewById(R.id.radio_general);
        radio_number= (RadioButton) findViewById(R.id.radio_number);
        radio_intent= (RadioButton) findViewById(R.id.radio_intent);
        radio_technolo= (RadioButton) findViewById(R.id.radio_technolo);


    }

    @Override
    protected void initData() {
        radio_general.setOnClickListener(this);
        radio_number.setOnClickListener(this);
        radio_intent.setOnClickListener(this);
        radio_technolo.setOnClickListener(this);
        replaceFragment(R.id.frame_technolo,new GeneralFragment());

    }
    public void replaceFragment(int id, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id,fragment);
        transaction.commit();
    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()){
            case R.id.radio_general:
                replaceFragment(R.id.frame_technolo,new GeneralFragment() );
                break;
            case R.id.radio_number:
                replaceFragment(R.id.frame_technolo,new NumberFragment());
                break;
            case R.id.radio_intent:
                replaceFragment(R.id.frame_technolo,new IntentFragment());
                break;
            case R.id.radio_technolo:
                replaceFragment(R.id.frame_technolo,new TechnoloFragment());
                break;
        }


    }
}
