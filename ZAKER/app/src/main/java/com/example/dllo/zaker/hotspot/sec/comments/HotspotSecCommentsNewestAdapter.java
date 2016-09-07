package com.example.dllo.zaker.hotspot.sec.comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by yuxiaomin~ on 16/9/1.
 */
public class HotspotSecCommentsNewestAdapter extends BaseAdapter {

    private HotspotSecCommentBean mCommentBean;

    public void setCommentBean(HotspotSecCommentBean commentBean) {
        mCommentBean = commentBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mCommentBean.getData().getComments().get(1).getList().size();
    }

    @Override
    public Object getItem(int position) {
        return mCommentBean.getData().getComments().get(1).getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);

        ViewHolder holder = null;
        ReplyViewHolder replyViewHolder = null;

        if (convertView == null) {
            switch (type) {
                case 0:
                    convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_sec_web_content_comments_itemone, parent, false);
                    holder = new ViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case 1:
                    convertView = LayoutInflater.from(MyApp.getContext()).inflate(R.layout.fragment_hotspot_sec_web_content_comments_itemtwo, parent, false);
                    replyViewHolder = new ReplyViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
            }
        } else {
            switch (type) {
                case 0:
                    holder = (ViewHolder) convertView.getTag();
                case 1:
                    replyViewHolder = (ReplyViewHolder) convertView.getTag();
            }
        }

        switch (type) {
            case 0:
                holder.name.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getAuther_name());
                holder.time.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getDate() + mCommentBean.getData().getComments().get(1).getList().get(position).getTime());
                holder.content.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getContent());
                holder.good.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getLike_num());

                if (mCommentBean.getData().getComments().get(1).getList().get(position).getAuther_icon() != "") {
                    Glide.with(MyApp.getContext()).load(mCommentBean.getData().getComments().get(1).getList().get(position).getAuther_icon()).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(holder.head);
                } else {
                    Glide.with(MyApp.getContext()).load("http://img4.imgtn.bdimg.com/it/u=1432431551,985748249&fm=21&gp=0.jpg").bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(holder.head);
                }
                break;

            case 1:
                replyViewHolder.name.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getAuther_name());
                replyViewHolder.time.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getDate() + mCommentBean.getData().getComments().get(1).getList().get(position).getTime());
                replyViewHolder.content.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getContent());
                replyViewHolder.good.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getLike_num());

                replyViewHolder.replyName.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getList().get(0).getAuther_name());
                replyViewHolder.replyContent.setText(mCommentBean.getData().getComments().get(1).getList().get(position).getList().get(0).getContent());

                if (mCommentBean.getData().getComments().get(1).getList().get(position).getAuther_icon() != "") {
                    Glide.with(MyApp.getContext()).load(mCommentBean.getData().getComments().get(1).getList().get(position).getAuther_icon()).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(replyViewHolder.head);
                } else {
                    Glide.with(MyApp.getContext()).load("http://img4.imgtn.bdimg.com/it/u=1432431551,985748249&fm=21&gp=0.jpg").bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(replyViewHolder.head);
                }
                break;
        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        if (mCommentBean.getData().getComments().get(1).getList().get(position).getList() != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public class ViewHolder {
        private ImageView head;
        private TextView name, time, content;
        private Button good;

        public ViewHolder(View view) {
            head = (ImageView) view.findViewById(R.id.iv_hotspot_sec_web_comments_oneitem_head);
            name = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_oneitem_name);
            time = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_oneitem_time);
            content = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_oneitem_content);
            good = (Button) view.findViewById(R.id.btnhotspot_sec_web_comments_oneitem_content_zan);
        }
    }


    public class ReplyViewHolder {
        private ImageView head;
        private TextView name, time, content, replyName, replyContent;
        private Button good;

        public ReplyViewHolder(View view) {
            head = (ImageView) view.findViewById(R.id.iv_hotspot_sec_web_comments_twoitem_head);
            name = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_twoitem_name);
            time = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_twoitem_time);
            content = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_twoitem_content);
            good = (Button) view.findViewById(R.id.btnhotspot_sec_web_comments_twoitem_content_zan);

            replyName = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_twoitem_reply_name);
            replyContent = (TextView) view.findViewById(R.id.tv_hotspot_sec_web_comments_twoitem_reply_content);

        }
    }
}
