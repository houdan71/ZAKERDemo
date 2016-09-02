package com.example.dllo.zaker.subscription.fragment_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.zaker.subscription.entity.Bean_essence;

/**
 * Created by dllo on 16/9/1.
 */
public class EssenceAdapter extends BaseAdapter {
    private Context context;
    private Bean_essence bean_essence;

    public EssenceAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_essence.getData().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return bean_essence.getData().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
