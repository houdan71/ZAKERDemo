package com.example.dllo.zaker.playfun.rotate;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.playfun.PlayFunBean;
import com.example.dllo.zaker.playfun.SecondLevelWebViewActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/30.
 * 玩乐页轮播图的适配器
 */
public class RotateAdapter extends PagerAdapter{
    private Context mContext;
    private PlayFunBean mPlayFunBean;
    private int rotatePosition;



    public RotateAdapter(Context context) {
        mContext = context;
    }

    public void setPlayFunBean(PlayFunBean playFunBean) {
        mPlayFunBean = playFunBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mPlayFunBean.getData().getPromote().size() == 0 ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        rotatePosition = position % mPlayFunBean.getData().getPromote().size() - 1;
        Log.d("RotateAdapter", "rotatePosition:" + rotatePosition);

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_playfun_listview_rotate_item,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.playFun_img_rotate);

        Picasso.with(mContext).load(mPlayFunBean.getData().getPromote().get(position % mPlayFunBean.getData().getPromote().size()).getPromotion_img())
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(imageView);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SecondLevelWebViewActivity.class);
                    if (rotatePosition <0){
                        rotatePosition += mPlayFunBean.getData().getPromote().size() ;
                        Log.d("哈哈哈", "rotatePosition:" + rotatePosition);
                    }
                intent.putExtra("WebUrl",mPlayFunBean.getData().getPromote().get(rotatePosition).getArticle().getWeburl());

                mContext.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}
