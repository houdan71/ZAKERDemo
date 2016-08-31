package com.example.dllo.zaker.hotspot;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;

/**
 * Created by dllo on 16/8/29.
 */
public class HotspotFragment extends BaseFragment {
    private ListView mListView;

    @Override
    protected int initLayout() {
        return R.layout.fragment_hotspot;
    }

    @Override
    protected void initView(View view) {
        mListView = (ListView) getView().findViewById(R.id.lv_hotspot);

    }

    @Override
    protected void initData() {

    }
}
