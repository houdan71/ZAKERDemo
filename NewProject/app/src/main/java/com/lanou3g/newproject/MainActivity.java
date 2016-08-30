package com.lanou3g.newproject;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private FrameLayout frameLayout;
    private RadioButton radio_read,radio_hot,radio_play,radio_community ;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        radio_read= (RadioButton) findViewById(R.id.radio_read);
        radio_hot= (RadioButton) findViewById(R.id.redio_hot);
        radio_play= (RadioButton) findViewById(R.id.radio_play);
        radio_community= (RadioButton) findViewById(R.id.radio_community);
        initData();
    }

    private void initData() {
        FragmentManager fm  =getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, new ReadFragment());
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radio_read:

               ft.replace(R.id.frame_layout,new ReadFragment());
                Toast.makeText(this, "订阅", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redio_hot:
                ft.replace(R.id.frame_layout,new HotFragment());
                Toast.makeText(this, "热点", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_play:
                ft.replace(R.id.frame_layout,new PlayFragment());
                Toast.makeText(this, "玩乐", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_community:
                ft.replace(R.id.frame_layout,new CommunityFragment());
                Toast.makeText(this, "社区", Toast.LENGTH_SHORT).show();
                break;
        }
        ft.commit();
    }
}
