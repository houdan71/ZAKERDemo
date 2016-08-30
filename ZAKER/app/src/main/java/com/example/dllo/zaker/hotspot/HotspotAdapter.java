package com.example.dllo.zaker.hotspot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;

/**
 * Created by dllo on 16/8/30.
 */
public class HotspotAdapter extends BaseAdapter {
    private HotspotBean mBean;

    @Override
    public int getCount() {
        return mBean.getData().getArticles().size();
    }

    @Override
    public Object getItem(int position) {
        return mBean.getData().getArticles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderImgNo holderImgNo= null;
        ViewHolderImgOne holderImgOne = null;
        ViewHolderImgThree holderImgThree = null;
        ViewHolderImgAd holderImgAd = null;
int type = getItemViewType(position);
        if (convertView == null){
            switch (type){
                case 0:
                    convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_item_image_no,parent,false);
                    holderImgNo = new ViewHolderImgNo(convertView);
                    convertView.setTag(holderImgNo);
                    break;
                case 1:
                    convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_item_image_one,parent,false);
                    holderImgOne = new ViewHolderImgOne(convertView);
                    convertView.setTag(holderImgOne);
                    break;
                case 2:
                    convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_item_image_three,parent,false);
                    holderImgThree = new ViewHolderImgThree(convertView);
                    convertView.setTag(holderImgThree);
                    break;
                case 3:
                    convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_item_ad,parent,false);
                    holderImgAd = new ViewHolderImgAd(convertView);
                    convertView.setTag(holderImgAd);
                    break;
            }
        }else {
            switch (type){
                case 0:

            }
        }


        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    private class ViewHolderImgNo{
        private TextView titleNo,authorNo,timeNo;
        public ViewHolderImgNo(View itemView) {
            titleNo = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_no_title);
            authorNo = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_no_author);
            timeNo = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_no_time);

        }
    }

    private class ViewHolderImgOne{
        private TextView titleOne,authorOne,timeOne;
        private ImageView imgOne;
        public ViewHolderImgOne(View itemView) {
            titleOne = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_one_title);
            authorOne = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_one_author);
            timeOne = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_one_time);
            imgOne = (ImageView) itemView.findViewById(R.id.iv_hotspot_item_image_one_img);

        }
    }

    private class ViewHolderImgThree{
        private TextView titleThree,authorThree,timeThree;
        private ImageView imgFitst,imgSec,imgThird;
        public ViewHolderImgThree(View itemView) {

            titleThree = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_three_title);
            authorThree = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_three_author);
            timeThree = (TextView) itemView.findViewById(R.id.tv_hotspot_item_image_three_time);
            imgFitst = (ImageView) itemView.findViewById(R.id.iv_hotspot_item_image_three_img_one);
            imgSec = (ImageView) itemView.findViewById(R.id.iv_hotspot_item_image_three_img_two);
            imgThird = (ImageView) itemView.findViewById(R.id.iv_hotspot_item_image_three_img_three);
        }
    }

    private class ViewHolderImgAd{
        private TextView titleAd;
        private ImageView tagAd,imgId;
        public ViewHolderImgAd(View itemView) {

            titleAd = (TextView) itemView.findViewById(R.id.tv_hotspot_item_ad_title);
            tagAd = (ImageView) itemView.findViewById(R.id.iv_hotspot_item_ad_tag);
            imgId = (ImageView) itemView.findViewById(R.id.iv_hotspot_item_ad_img);
        }
    }
}
