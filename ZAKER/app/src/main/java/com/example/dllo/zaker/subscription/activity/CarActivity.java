package com.example.dllo.zaker.subscription.activity;

import android.support.v4.view.ViewPager;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.adapter.CarAdapter;
import com.example.dllo.zaker.subscription.entity.Bean_car;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/8/31.
 */
public class CarActivity extends BaseActivity {
    private ViewPager view_car_pager;
    private CarAdapter carAdapter;

//    private GridView gridView;
    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    protected void initView() {
        view_car_pager= (ViewPager) findViewById(R.id.view_car_pager);
//        gridView= (GridView) findViewById(R.id.grid_today);

    }

    @Override
    protected void initData() {

        NetTool.getInstance().startRequest(NValues.URL_CAR, Bean_car.class, new onHttpCallBack<Bean_car>() {
            @Override
            public void onSuccess(Bean_car response) {
                carAdapter =new CarAdapter(CarActivity.this);

//                gridView.setAdapter(gridViewCarAdapter);
                carAdapter.setBean_car(response);
                view_car_pager.setAdapter(carAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
