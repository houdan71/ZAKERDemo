package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_car;


/**
 * Created by dllo on 16/9/3.
 */
public class CarAdapter extends PagerAdapter {
    private Context context;
    private Bean_car bean_car;
    private ImageView image_today;
    private TextView text_today, text_today_title, text_today_name, text_today_titlee, text_today_namee,
            text_view, text_tody_name,text_today_title_bottom,text_today_name_bottom,text_today_titlee_buttom,text_today_namee_buttom;

    public CarAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        return bean_car.getData().getArticles().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_today_activity, null);

        image_today = (ImageView) view.findViewById(R.id.image_today);
        text_today = (TextView) view.findViewById(R.id.text_today);
        text_today_title = (TextView) view.findViewById(R.id.text_today_title);
        text_today_name = (TextView) view.findViewById(R.id.text_today_name);
        text_today_titlee = (TextView) view.findViewById(R.id.text_today_titlee);
        text_today_namee = (TextView) view.findViewById(R.id.text_today_namee);
        text_today_title_bottom= (TextView) view.findViewById(R.id.text_today_title_buttom);
        text_today_name_bottom= (TextView) view.findViewById(R.id.text_today_name_button);
        text_today_titlee_buttom= (TextView) view.findViewById(R.id.text_today_titlee_buttom);
        text_today_namee_buttom= (TextView) view.findViewById(R.id.text_today_namee_buttom);
        text_view = (TextView) view.findViewById(R.id.text_view);
        text_tody_name = (TextView) view.findViewById(R.id.text_tody_name);

        Glide.with(context).load(bean_car.getData().getArticles().get(position).getThumbnail_pic()).into(image_today);

        text_today.setText(bean_car.getData().getArticles().get(position).getTitle());

        text_today_title.setText(bean_car .getData().getArticles().get(position+1).getTitle());
        text_today_name.setText(bean_car.getData().getArticles().get(position+1).getAuther_name());
        text_today_titlee.setText(bean_car.getData().getArticles().get(position+2).getTitle());
        text_today_namee.setText(bean_car.getData().getArticles().get(position+2).getAuther_name());
        text_today_title_bottom.setText(bean_car.getData().getArticles().get(position+3).getTitle());
        text_today_name_bottom.setText(bean_car.getData().getArticles().get(position+3).getAuther_name());
        text_today_titlee_buttom.setText(bean_car.getData().getArticles().get(position+4).getTitle());
        text_today_namee_buttom.setText(bean_car.getData().getArticles().get(position+3).getAuther_name());
        text_view.setText(bean_car.getData().getArticles().get(position+4).getTitle());
        text_tody_name.setText(bean_car.getData().getArticles().get(position+4).getAuther_name());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


    public void setBean_car(Bean_car bean_car) {
        this.bean_car = bean_car;
        notifyDataSetChanged();
    }
}
