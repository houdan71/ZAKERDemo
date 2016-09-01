package com.example.dllo.zaker.playfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/9/1.
 */
public class SecondLevelViewPagerAdapter extends BaseAdapter {

    private Context mContext;
    private SecondLevelViewPagerBean mBean;

    public SecondLevelViewPagerAdapter(Context context) {
        mContext = context;
    }


    public void setBean(SecondLevelViewPagerBean bean) {
        mBean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mBean.getData().getArticles().size() > 0 ? mBean.getData().getArticles().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mBean.getData().getArticles().get(position) != null ? mBean.getData().getArticles().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewPagerViewHolder viewPagerViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_playfun_listview_viewpager_item_listview_item,parent,false);
            viewPagerViewHolder = new ViewPagerViewHolder(convertView);
            convertView.setTag(viewPagerViewHolder);
        }else {
            viewPagerViewHolder = (ViewPagerViewHolder) convertView.getTag();
        }

        viewPagerViewHolder.titleTV.setText(mBean.getData().getArticles().get(position).getTitle());
        viewPagerViewHolder.dataTV.setText(mBean.getData().getArticles().get(position).getDate());
        viewPagerViewHolder.authorTV.setText(mBean.getData().getArticles().get(position).getAuther_name());
        if (mBean.getData().getArticles().get(position).getMedia().size() == 0){
            viewPagerViewHolder.picIV.setImageResource(R.mipmap.delicious);
        }else {
            Picasso.with(mContext).load(mBean.getData().getArticles().get(position).getMedia().get(0).getUrl())
                    .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewPagerViewHolder.picIV);
        }

        return convertView;
    }

    public class ViewPagerViewHolder{

        private TextView titleTV,authorTV,dataTV;
        private ImageView picIV;
        public ViewPagerViewHolder(View view) {

            titleTV = (TextView) view.findViewById(R.id.playFun_listView_viewPager_item_listView_item_textView_title);
            authorTV = (TextView) view.findViewById(R.id.playFun_listView_viewPager_item_listView_item_textView_author);
            dataTV = (TextView) view.findViewById(R.id.playFun_listView_viewPager_item_listView_item_textView_data);
            picIV = (ImageView) view.findViewById(R.id.playFun_listView_viewPager_item_listView_item_img_pic);
        }
    }
}
