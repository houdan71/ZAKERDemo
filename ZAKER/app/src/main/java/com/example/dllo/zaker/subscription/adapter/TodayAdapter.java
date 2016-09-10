package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.subscription.GridAdapter;
import com.example.dllo.zaker.subscription.activity.TodayActivity;
import com.example.dllo.zaker.subscription.entity.Bean_today;
import com.example.dllo.zaker.subscription.entity.Bean_today.DataBean.ArticlesBean;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/1.
 */
public class TodayAdapter extends PagerAdapter implements OnClickListener {
    private Context context;
    private Bean_today bean_today;
    private int pos;

    private ImageView image_today;
    private TextView text_today,text_today_title,text_today_name,text_today_titlee,text_today_namee,
            text_today_title_bottom,text_today_name_bottom,text_today_titlee_bottom,text_today_namee_bottom,
            text_view, text_tody_name;

    private FrameLayout frameLayout;
    private LinearLayout linear_top_left,linear_top_right,linear_below_left,linear_below_right, linear_below;
    ArrayList<HotspotSecBean> b;

    public TodayAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_today.getData().getArticles().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_today_activity, null);
        pos = position;
        image_today = (ImageView) view.findViewById(R.id.image_today);
        text_today = (TextView) view.findViewById(R.id.text_today);
        text_today_title= (TextView) view.findViewById(R.id.text_today_title);
        text_today_name= (TextView) view.findViewById(R.id.text_today_name);
        text_today_titlee= (TextView) view.findViewById(R.id.text_today_titlee);
        text_today_namee= (TextView) view.findViewById(R.id.text_today_namee);
        text_today_title_bottom= (TextView) view.findViewById(R.id.text_today_title_bottom);
        text_today_name_bottom= (TextView) view.findViewById(R.id.text_today_name_bottom);
        text_today_titlee_bottom= (TextView) view.findViewById(R.id.text_today_titlee_bottom);
        text_today_namee_bottom= (TextView) view.findViewById(R.id.text_today_namee_bottom);
        text_view = (TextView) view.findViewById(R.id.text_view);
        text_tody_name = (TextView) view.findViewById(R.id.text_tody_name);

        b = new ArrayList<>();

        for (int i = 0; i < bean_today.getData().getArticles().size(); i++) {

            HotspotSecBean bean = new HotspotSecBean();
            bean.setWebUrl(bean_today.getData().getArticles().get(i).getWeburl());
            b.add(bean);

        }

        frameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
        linear_top_left= (LinearLayout) view.findViewById(R.id.linear_top_left);
        linear_top_right= (LinearLayout) view.findViewById(R.id.linear_top_right);
        linear_below_left= (LinearLayout) view.findViewById(R.id.linear_below_left);
        linear_below_right= (LinearLayout) view.findViewById(R.id.linear_below_right);
        linear_below = (LinearLayout) view.findViewById(R.id.linear_below);
        frameLayout.setOnClickListener(this);
        linear_top_left.setOnClickListener(this);
        linear_top_right.setOnClickListener(this);
        linear_below_left.setOnClickListener(this);
        linear_below_right.setOnClickListener(this);
        linear_below.setOnClickListener(this);

        Glide.with(context).load(bean_today.getData().getArticles().get(position).getThumbnail_pic()).into(image_today);

        text_today.setText(bean_today.getData().getArticles().get(position).getTitle());
        text_today_title.setText(bean_today.getData().getArticles().get(position+1).getTitle());
        text_today_name.setText(bean_today.getData().getArticles().get(position+1).getAuther_name());
        text_today_titlee.setText(bean_today.getData().getArticles().get(position+2).getTitle());
        text_today_namee.setText(bean_today.getData().getArticles().get(position+2).getAuther_name());
        text_today_title_bottom.setText(bean_today.getData().getArticles().get(position+3).getTitle());
        text_today_name_bottom.setText(bean_today.getData().getArticles().get(position+3).getAuther_name());
        text_today_titlee_bottom.setText(bean_today.getData().getArticles().get(position+4).getTitle());
        text_today_namee_bottom.setText(bean_today.getData().getArticles().get(position+4).getAuther_name());
        text_view.setText(bean_today.getData().getArticles().get(position+5).getTitle());
        text_tody_name.setText(bean_today.getData().getArticles().get(position+5).getAuther_name());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, HotspotSecActivity.class);
        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
        switch (v.getId()) {

            case R.id.frame_layout:

                intent.putExtra(HotspotFragment.KEY_postionItem, 1);
                context.startActivity(intent);
                break;
            case R.id.linear_top_left:
                intent.putExtra("pos",pos+1);
                context.startActivity(intent);
                break;
            case R.id.linear_top_right:
                intent.putExtra("pos",pos+2);
                context.startActivity(intent);
                break;
            case R.id.linear_below_left:
                intent.putExtra("pos",pos+3);
                context.startActivity(intent);
                break;
            case R.id.linear_below_right:
                intent.putExtra("pos",pos+4);
                context.startActivity(intent);
                break;

            case R.id.linear_below:

                intent.putExtra(HotspotFragment.KEY_postionItem, 1);
                context.startActivity(intent);
                break;

        }
    }


    public void setBean_today(Bean_today bean_today) {
        this.bean_today = bean_today;
        notifyDataSetChanged();
    }
}


//
//            convertView = LayoutInflater.from(context).inflate(R.layout.item_today_activity, parent, false);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//            Glide.with(context).load(bean_today.getData().getArticles().get(position + 0).getThumbnail_pic()).into(holder.image_today);
//
//            holder.text_today.setText(bean_today.getData().getArticles().get(position + 0).getTitle());
//            holder.text_today_titlee.setText(bean_today.getData().getArticles().get(position + 2).getTitle());
//
//
//            holder.text_today_name.setText(bean_today.getData().getArticles().get(position + 1).getAuther_name());
//            holder.text_today_title.setText(bean_today.getData().getArticles().get(position + 1).getTitle());
//            holder.text_today_namee.setText(bean_today.getData().getArticles().get(position + 2).getAuther_name());
//            holder.text_today_title_bottom.setText(bean_today.getData().getArticles().get(position + 3).getTitle());
//            holder.text_today_name_bottom.setText(bean_today.getData().getArticles().get(position + 3).getAuther_name());
//            holder.text_today_titlee_buttom.setText(bean_today.getData().getArticles().get(position + 4).getTitle());
//            holder.text_today_namee_buttom.setText(bean_today.getData().getArticles().get(position + 4).getAuther_name());
//            holder.text_view.setText(bean_today.getData().getArticles().get(position + 5).getTitle());
//            holder.text_tody_name.setText(bean_today.getData().getArticles().get(position + 5).getAuther_name());
//        }
//
//        frameLayout = (FrameLayout) convertView.findViewById(R.id.frame_layout);
//        linear_top_left = (LinearLayout) convertView.findViewById(R.id.linear_top_left);
//        linear_top_right = (LinearLayout) convertView.findViewById(R.id.linear_top_right);
//        linear_below_left = (LinearLayout) convertView.findViewById(R.id.linear_below_left);
//        linear_below_right = (LinearLayout) convertView.findViewById(R.id.linear_below_right);
//        linear_below = (LinearLayout) convertView.findViewById(R.id.linear_below);
//        frameLayout.setOnClickListener(this);
//        linear_top_left.setOnClickListener(this);
//        linear_top_right.setOnClickListener(this);
//        linear_below_left.setOnClickListener(this);
//        linear_below_right.setOnClickListener(this);
//        linear_below.setOnClickListener(this);
//        b = new ArrayList<>();
//        for (int i = 0; i < bean_today.getData().getArticles().size(); i++) {
//
//            HotspotSecBean bean = new HotspotSecBean();
//            bean.setWebUrl(bean_today.getData().getArticles().get(i).getWeburl());
//            b.add(bean);
//
//        }
//
//
//        return convertView;
//    }
//
//    class ViewHolder {
//        private ImageView image_today;
//        private TextView text_today, text_today_title, text_today_name, text_today_titlee, text_today_namee,
//                text_view, text_tody_name, text_today_title_bottom, text_today_name_bottom, text_today_titlee_buttom, text_today_namee_buttom;
//
//        public ViewHolder(View view) {
//            image_today = (ImageView) view.findViewById(R.id.image_today);
//            text_today = (TextView) view.findViewById(R.id.text_today);
//            text_today_title = (TextView) view.findViewById(R.id.text_today_title);
//            text_today_name = (TextView) view.findViewById(R.id.text_today_name);
//            text_today_titlee = (TextView) view.findViewById(R.id.text_today_titlee);
//            text_today_namee = (TextView) view.findViewById(R.id.text_today_namee);
//            text_today_title_bottom = (TextView) view.findViewById(R.id.text_today_title_buttom);
//            text_today_name_bottom = (TextView) view.findViewById(R.id.text_today_name_button);
//            text_today_titlee_buttom = (TextView) view.findViewById(R.id.text_today_titlee_buttom);
//            text_today_namee_buttom = (TextView) view.findViewById(R.id.text_today_namee_buttom);
//            text_view = (TextView) view.findViewById(R.id.text_view);
//            text_tody_name = (TextView) view.findViewById(R.id.text_tody_name);
//
//        }
//
//    }
//
//
//
//    public void setBean_today(Bean_today bean_today) {
//        this.bean_today = bean_today;
//        Log.d("TodayAdapter", "besn_today" + bean_today.getData().getArticles().get(0).getTitle());
//        notifyDataSetChanged();
//    }
//}

////    private int a = 0;
////
////    int lastPosition;
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        Log.d("xxxx", "position:" + position);
//
//        // 集合102个
//        // 第0页   0 + 0x5 + 0
//        //         0 + 0x5 + 1
//        //        0+ 0x5 + 2
//        //        0 + 0x5 + 3
//        //        0 + 0x5 + 4
//        //       0 + 0x5 + 5
//        // 第1页
//        //        1 + 1 x5 + 6
//        //        1+ 1x5 + 7
//
////        int index = position + (position * 5) + a;
//
////        index++;
//        View view =
//
//
//

//
//        //Toast.makeText(context, "a:" + a, Toast.LENGTH_SHORT).show();
//

//
//        //     Glide.with(context).load(bean_today.getData().getArticles().get(position + (position * 5) + a).getThumbnail_pic()).into(image_today);
//        // text_today.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getTitle());

//
//
////        a++;
//        // text_today_title.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getTitle());

//        //   text_today_name.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getAuther_name());

//        //   a++;
////        text_today_titlee.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getTitle());
////        text_today_namee.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getAuther_name());
////     //   a++;
////        text_today_title_bottom.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getTitle());
////        text_today_name_bottom.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getAuther_name());
////        a++;
////        text_today_titlee_buttom.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getTitle());
////        text_today_namee_buttom.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getAuther_name());
////        a++;
////        text_view.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getTitle());
////        text_tody_name.setText(bean_today.getData().getArticles().get(position + (position * 5) + a).getAuther_name());
////        a++;
//
//        container.addView(view);
//        return view;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//
//    }
//
//


