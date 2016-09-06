package com.example.dllo.zaker.subscription.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.relax_fragment.DisportFragment;
import com.example.dllo.zaker.subscription.relax_fragment.FilmFragment;
import com.example.dllo.zaker.subscription.relax_fragment.StarFragment;
import com.example.dllo.zaker.subscription.relax_fragment.TvFragment;
import com.example.dllo.zaker.subscription.sport_fragment.BasketballFragment;
import com.example.dllo.zaker.subscription.sport_fragment.FootballFragment;
import com.example.dllo.zaker.subscription.sport_fragment.MultipleFragment;
import com.example.dllo.zaker.subscription.sport_fragment.TopFragment;

/**
 * Created by dllo on 16/8/31.
 */
public class RelaxActivity extends BaseActivity implements OnClickListener{
    private RadioButton radio_diaport , radio_film, radio_tv,radio_star;
    @Override
    protected int getLayout() {
        return R.layout.activity_relax;
    }

    @Override
    protected void initView() {
        radio_diaport = (RadioButton) findViewById(R.id.radio_disport);
        radio_film = (RadioButton) findViewById(R.id.radio_film);
        radio_tv = (RadioButton) findViewById(R.id.radio_tv);
        radio_star = (RadioButton) findViewById(R.id.radio_star);
    }

    @Override
    protected void initData() {
        radio_diaport.setOnClickListener(this);
        radio_film.setOnClickListener(this);
        radio_tv.setOnClickListener(this);
        radio_star.setOnClickListener(this);

        replaceFragment(R.id.frame_relax, new DisportFragment());

    }
    public void replaceFragment(int id, Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.radio_disport:
                replaceFragment(R.id.frame_relax, new DisportFragment());
                break;
            case R.id.radio_film:
                replaceFragment(R.id.frame_relax, new FilmFragment());
                break;
            case R.id.radio_tv:
                replaceFragment(R.id.frame_relax, new TvFragment());
                break;
            case R.id.radio_star:
                replaceFragment(R.id.frame_relax, new StarFragment());
                break;

        }
    }
}
