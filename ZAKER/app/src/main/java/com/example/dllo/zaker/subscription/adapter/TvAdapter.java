package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.subscription.entity.Bean_tv;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/5.
 */
public class TvAdapter extends PagerAdapter implements OnClickListener{
    private Context context;
    private Bean_tv bean_tv;
    private int pos;

    private ImageView image_today;
    private TextView text_today, text_today_title, text_today_name, text_today_titlee, text_today_namee,
            text_view, text_tody_name,text_today_title_bottom,text_today_name_bottom,text_today_titlee_bottom,text_today_namee_bottom;

    private FrameLayout frameLayout;

    private LinearLayout linear_top_left, linear_top_right, linear_below_left, linear_below_right, linear_below;
    ArrayList<HotspotSecBean> b;

    public TvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        return bean_tv.getData().getArticles().size();
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
        text_today_title = (TextView) view.findViewById(R.id.text_today_title);
        text_today_name = (TextView) view.findViewById(R.id.text_today_name);
        text_today_titlee = (TextView) view.findViewById(R.id.text_today_titlee);
        text_today_namee = (TextView) view.findViewById(R.id.text_today_namee);
        text_today_title_bottom = (TextView) view.findViewById(R.id.text_today_title_bottom);
        text_today_name_bottom = (TextView) view.findViewById(R.id.text_today_name_bottom);
        text_today_titlee_bottom = (TextView) view.findViewById(R.id.text_today_titlee_bottom);
        text_today_namee_bottom = (TextView) view.findViewById(R.id.text_today_namee_bottom);
        text_view = (TextView) view.findViewById(R.id.text_view);
        text_tody_name = (TextView) view.findViewById(R.id.text_tody_name);
        b = new ArrayList<>();
        for (int i = 0; i <bean_tv.getData().getArticles().size(); i++) {

            HotspotSecBean bean = new HotspotSecBean();
            bean.setWebUrl(bean_tv.getData().getArticles().get(i).getWeburl());
            b.add(bean);

        }

        frameLayout= (FrameLayout) view.findViewById(R.id.frame_layout);
        linear_top_left = (LinearLayout) view.findViewById(R.id.linear_top_left);
        linear_top_right = (LinearLayout) view.findViewById(R.id.linear_top_right);
        linear_below_left = (LinearLayout) view.findViewById(R.id.linear_below_left);
        linear_below_right = (LinearLayout) view.findViewById(R.id.linear_below_right);
        linear_below = (LinearLayout) view.findViewById(R.id.linear_below);
        frameLayout.setOnClickListener(this);
        linear_top_left.setOnClickListener(this);
        linear_top_right.setOnClickListener(this);
        linear_below_left.setOnClickListener(this);
        linear_below_right.setOnClickListener(this);
        linear_below.setOnClickListener(this);


        Glide.with(context).load(bean_tv.getData().getArticles().get(position).getThumbnail_pic()).into(image_today);

        text_today.setText(bean_tv.getData().getArticles().get(position).getTitle());

        text_today_title.setText(bean_tv .getData().getArticles().get(position+1).getTitle());
        text_today_name.setText(bean_tv.getData().getArticles().get(position+1).getAuther_name());
        text_today_titlee.setText(bean_tv.getData().getArticles().get(position+2).getTitle());
        text_today_namee.setText(bean_tv.getData().getArticles().get(position+2).getAuther_name());
        text_today_title_bottom.setText(bean_tv.getData().getArticles().get(position+3).getTitle());
        text_today_name_bottom.setText(bean_tv.getData().getArticles().get(position+3).getAuther_name());
        text_today_titlee_bottom.setText(bean_tv.getData().getArticles().get(position+4).getTitle());
        text_today_namee_bottom.setText(bean_tv.getData().getArticles().get(position+4).getAuther_name());
        text_view.setText(bean_tv.getData().getArticles().get(position+5).getTitle());
        text_tody_name.setText(bean_tv.getData().getArticles().get(position+5).getAuther_name());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    public void setBean_tv(Bean_tv bean_tv) {
        this.bean_tv = bean_tv;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, HotspotSecActivity.class);
        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
        switch (v.getId()) {
            case R.id.frame_layout:
                intent.putExtra("pos", pos);
                context.startActivity(intent);

                break;
            case R.id.linear_top_left:
                intent.putExtra("pos", pos + 1);
                context.startActivity(intent);
                break;
            case R.id.linear_top_right:
                intent.putExtra("pos", pos + 2);
                context.startActivity(intent);
                break;
            case R.id.linear_below_left:
                intent.putExtra("pos", pos + 3);
                context.startActivity(intent);
                break;
            case R.id.linear_below_right:
                intent.putExtra("pos", pos + 4);
                context.startActivity(intent);
                break;
            case R.id.linear_below:

                intent.putExtra("pos", pos + 5);

                context.startActivity(intent);
                break;

        }
    }
}
