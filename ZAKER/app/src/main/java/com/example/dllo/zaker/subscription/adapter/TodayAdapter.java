package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_today;

/**
 * Created by dllo on 16/9/1.
 */
public class TodayAdapter extends BaseAdapter {
    private Context context;
    private Bean_today bean_today;

    public TodayAdapter(Context context) {
        this.context =context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_today,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text_title.setText(bean_today.getData().getArticles().get(position).getTitle());
        holder.text_name.setText(bean_today.getData().getArticles().get(position).getAuther_name());
        holder.text_time.setText(bean_today.getData().getArticles().get(position).getDate());


        return convertView;
    }

    public void setbean_today(Bean_today bean_today) {
        this.bean_today = bean_today;
        Log.d("TodayAdapter", "bean_today.getData().getArticles().size():" + bean_today.getData().getArticles().get(0).getDate());

        notifyDataSetChanged();
    }

    class ViewHolder{
        private TextView text_title,text_name,text_time;
        public ViewHolder(View  view){
            text_title= (TextView) view.findViewById(R.id.text_title);
            text_name= (TextView) view.findViewById(R.id.text_name);
            text_time= (TextView) view.findViewById(R.id.text_time);

        }
    }
}
