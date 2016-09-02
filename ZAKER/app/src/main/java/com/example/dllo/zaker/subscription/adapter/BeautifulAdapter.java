package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_beautiful;

/**
 * Created by dllo on 16/9/1.
 */
public class BeautifulAdapter extends BaseAdapter {
    private Context context;
    private Bean_beautiful bean_beautiful;

    public BeautifulAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_beautiful.getData().getArticles().size();
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
        ViewHolder holder =null;
        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_beautiful,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(bean_beautiful.getData().getArticles().get(position).getThumbnail_pic()).into(holder.image_beautiful);
        holder.text_title.setText(bean_beautiful.getData().getArticles().get(position).getTitle());
        holder.text_name.setText(bean_beautiful.getData().getArticles().get(position).getAuther_name());
        return convertView;
    }

    public void setBean_beautiful(Bean_beautiful bean_beautiful) {
        this.bean_beautiful = bean_beautiful;
        notifyDataSetChanged();
    }

    class ViewHolder{
        private TextView text_title,text_name;
        private ImageView image_beautiful;
        public ViewHolder(View view){
            text_title = (TextView) view.findViewById(R.id.text_beautiful_title);
            text_name = (TextView) view.findViewById(R.id.text_beautiful_name);
            image_beautiful= (ImageView) view.findViewById(R.id.image_beautiful);
        }
    }
}
