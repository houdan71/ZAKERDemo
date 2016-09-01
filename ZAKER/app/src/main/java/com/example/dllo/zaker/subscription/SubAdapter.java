package com.example.dllo.zaker.subscription;

import android.content.Context;
import android.support.v4.view.PagerAdapter;

import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/30.
 */
public class SubAdapter extends PagerAdapter implements OnPageChangeListener {
    private Context context;
    private ImageView[] tips;
    private ArrayList<Integer> images;
    private ImageView imageView;

    private Bean_subscription bean_subscription;


    public SubAdapter(Context context) {
        this.context = context;
        images = new ArrayList<>();
    }

    public void setTips(ImageView[] tips) {
        this.tips = tips;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,container,false);
        imageView = (ImageView) view.findViewById(R.id.image_item);
        Glide.with(context).load(bean_subscription.getData().getList().get(position % (bean_subscription.getData().getList().size())).getPromotion_img()).into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return images ==null?0:Integer.MAX_VALUE;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < tips.length; i++) {
            if (i == position % images.size()){
                tips[i].setImageResource(R.mipmap.ic_launcher);
            }else {
                tips[i].setImageResource(R.mipmap.ic_launcher);
            }

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setBean_subscription(Bean_subscription bean_subscription) {
        this.bean_subscription = bean_subscription;
        notifyDataSetChanged();
    }
}
