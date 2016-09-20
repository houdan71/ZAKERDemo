package com.example.dllo.zaker.subscription.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.subscription.activity.NewsActivity;
import com.example.dllo.zaker.subscription.entity.Bean_news;

import java.util.ArrayList;


/**
 * Created by dllo on 16/9/3.
 */
public class NewsAdapter extends PagerAdapter implements OnClickListener {
    private int pos;
    private Context context;
    private Bean_news bean_news;
    private ImageView image_today;
    private TextView text_today, text_today_title, text_today_name, text_today_titlee, text_today_namee,
            text_today_title_bottom, text_today_name_bottom, text_today_titlee_bottom, text_today_namee_bottom,
            text_view, text_tody_name;

    private FrameLayout frameLayout;
//    private GridView gridView;

    private LinearLayout linear_top_left, linear_top_right, linear_below_left, linear_below_right, linear_below;
    //    private GridViewNewAdapter gridViewNewAdapter;
    ArrayList<HotspotSecBean> b;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        return bean_news.getData().getArticles().size();
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
//        gridView = (GridView) view.findViewById(R.id.grid_today);
//        gridViewNewAdapter = new GridViewNewAdapter(context);
//        gridViewNewAdapter.setBean_news(bean_news);
//        gridView.setAdapter(gridViewNewAdapter);
        text_view = (TextView) view.findViewById(R.id.text_view);
        text_tody_name = (TextView) view.findViewById(R.id.text_tody_name);
        b = new ArrayList<>();
        for (int i = 0; i < bean_news.getData().getArticles().size(); i++) {
            HotspotSecBean bean = new HotspotSecBean();
            bean.setWebUrl(bean_news.getData().getArticles().get(i).getWeburl());
            b.add(bean);
        }
        frameLayout = (FrameLayout) view.findViewById(R.id.frame_layout);
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
//        gridView.setOnItemClickListener(this);
        linear_below.setOnClickListener(this);
        Glide.with(context).load(bean_news.getData().getArticles().get(position + 0).getThumbnail_pic()).into(image_today);
        text_today.setText(bean_news.getData().getArticles().get(position + 0).getTitle());
        text_today_title.setText(bean_news.getData().getArticles().get(position + 1).getTitle());
        text_today_name.setText(bean_news.getData().getArticles().get(position + 1).getAuther_name());
        text_today_titlee.setText(bean_news.getData().getArticles().get(position + 2).getTitle());
        text_today_namee.setText(bean_news.getData().getArticles().get(position + 2).getAuther_name());
        text_today_title_bottom.setText(bean_news.getData().getArticles().get(position + 3).getTitle());
        text_today_name_bottom.setText(bean_news.getData().getArticles().get(position + 3).getAuther_name());
        text_today_titlee_bottom.setText(bean_news.getData().getArticles().get(position + 4).getTitle());
        text_today_namee_bottom.setText(bean_news.getData().getArticles().get(position + 4).getAuther_name());
        text_view.setText(bean_news.getData().getArticles().get(position + 5).getTitle());
        text_tody_name.setText(bean_news.getData().getArticles().get(position + 5).getAuther_name());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    public void setBean_news(Bean_news bean_news) {
        this.bean_news = bean_news;
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


//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(context, HotspotSecActivity.class);
//        intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
//       switch (position){
//              case 0:
//            intent.putExtra("pos",pos+1);
//            context.startActivity(intent);
//                  break;
//           case 1:
//               intent.putExtra("pos",pos+2);
//               context.startActivity(intent);
//             break;
//           case 2:
//               intent.putExtra("pos",pos+3);
//               context.startActivity(intent);
//             break;
//           case 3:
//               intent.putExtra("pos",pos+4);
//               context.startActivity(intent);
//          break;
//
//       }

}




