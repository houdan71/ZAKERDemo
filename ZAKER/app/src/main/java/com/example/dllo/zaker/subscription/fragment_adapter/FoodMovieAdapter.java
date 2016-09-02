package com.example.dllo.zaker.subscription.fragment_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_food;

/**
 * Created by dllo on 16/9/1.
 */
public class FoodMovieAdapter extends BaseAdapter{
    private Context context;
    private Bean_food bean_food;

    public FoodMovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_food.getData().getArticles().size();
    }

    @Override
    public Object getItem(int position) {
        return bean_food.getData().getArticles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_beautiful, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
    }
        Glide.with(context).load(bean_food.getData().getArticles().get(position).getThumbnail_pic()).into(holder.image_view);
        holder.text_title.setText(bean_food.getData().getArticles().get(position).getTitle());
        holder.text_name.setText(bean_food.getData().getArticles().get(position).getAuther_name());


        return convertView;
    }


    public void setBean_food(Bean_food bean_food) {
        this.bean_food = bean_food;
        notifyDataSetChanged();
    }

    class ViewHolder{
        private TextView text_title,text_name;
        private ImageView image_view;
        public ViewHolder(View view){
            text_title= (TextView) view.findViewById(R.id.text_beautiful_title);
            text_name= (TextView) view.findViewById(R.id.text_beautiful_name);
            image_view= (ImageView) view.findViewById(R.id.image_beautiful);

        }
    }
}
