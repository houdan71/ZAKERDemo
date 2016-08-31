package com.example.dllo.zaker.playfun.viewpager;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.playfun.PlayFunBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/30.
 * 玩乐页4个横向滑动图片的适配器
 */
public class ViewPagerAdapter extends Adapter<ViewPagerAdapter.ViewHolder> {

    private Context mContext;
    private PlayFunBean mPlayFunBean;

    public ViewPagerAdapter(Context context) {
        mContext = context;
    }

    public void setPlayFunBean(PlayFunBean playFunBean) {
        mPlayFunBean = playFunBean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fragment_playfun_listview_viewpager_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(mContext).load(mPlayFunBean.getData().getDisplay().get(position).getPic().getUrl())
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mPlayFunBean.getData().getDisplay().size() == 0 ? 0 : mPlayFunBean.getData().getDisplay().size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.playFun_img_viewPager);

            //设置屏幕宽一半
            WindowManager manager = (WindowManager) mContext.getSystemService(mContext.WINDOW_SERVICE);
            DisplayMetrics dm=new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(dm);
            int width=dm.widthPixels;
            mImageView.getLayoutParams().width = width / 2;

        }
    }
}
