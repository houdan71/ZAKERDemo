package com.example.dllo.zaker.community.slidingitem.select;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/3.
 */
public class CommunitySelectionFragmentAdapter extends Adapter<ViewHolder> {

    private Context mContext;
    private CommunitySelectionBean  mBean;
    private List<MyDataBean> list;
    private static final int VIEW_TYPE_0 = 0;
    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private static final int VIEW_TYPE_3 = 3;

    public void setList(List<MyDataBean> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    private OnRecyclerItemClickListener mListener;

    public void setListener(OnRecyclerItemClickListener listener) {
        mListener = listener;
    }

    public CommunitySelectionFragmentAdapter(Context context) {
        mContext = context;
    }

    public void setBean(CommunitySelectionBean bean) {
        mBean = bean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_0:
                return new ZeroPictureViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fragment_community_selection_listview_type_zero,parent,false));
            case VIEW_TYPE_1:
                return new OnePictureViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fragment_community_selection_listview_type_one, parent, false));
            case VIEW_TYPE_2:
                return new TwoPictureViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fragment_community_selection_listview_type_two, parent, false));
            case VIEW_TYPE_3:
                return new ThreePictureViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fragment_community_selection_listview_type_three, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case VIEW_TYPE_0:
                final ZeroPictureViewHolder zeroPictureViewHolder = (ZeroPictureViewHolder) holder;
                zeroPictureViewHolder.nameZeroTV.setText(list.get(position).getName());
                zeroPictureViewHolder.dateZeroTV.setText(list.get(position).getDate());
                zeroPictureViewHolder.titleZeroTV.setText(list.get(position).getTitle());
                zeroPictureViewHolder.hotNumZeroTV.setText(list.get(position).getHotNum());
                zeroPictureViewHolder.commentCountZeroTV.setText(list.get(position).getCount());
                zeroPictureViewHolder.likeNumZeroTV.setText(list.get(position).getLikeNum());
                zeroPictureViewHolder.contentZeroTV.setText(list.get(position).getContent());
                Glide.with(mContext).load(list.get(position).getIcon())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .bitmapTransform(new CropCircleTransformation(mContext))
                        .into(zeroPictureViewHolder.headZeroIV);
                //设置RecyclerView的item监听
                if (mListener != null) {
                    zeroPictureViewHolder.itemView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int clickPosition = zeroPictureViewHolder.getAdapterPosition();
                            mListener.onItemClick(v, zeroPictureViewHolder, clickPosition);
                        }
                    });
                }
                break;
            case VIEW_TYPE_1:
                final OnePictureViewHolder onePictureViewHolder = (OnePictureViewHolder) holder;
                onePictureViewHolder.nameOneTV.setText(list.get(position).getName());
                onePictureViewHolder.dateOneTV.setText(list.get(position).getDate());
                onePictureViewHolder.titleOneTV.setText(list.get(position).getTitle());
                onePictureViewHolder.hotNumOneTV.setText(list.get(position).getHotNum());
                onePictureViewHolder.commentCountOneTV.setText(list.get(position).getCount());
                onePictureViewHolder.likeNumOneTV.setText(list.get(position).getLikeNum());
                onePictureViewHolder.contentOneTV.setText(list.get(position).getContent());
                Glide.with(mContext).load(list.get(position).getIcon())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .into(onePictureViewHolder.bigPictureOneIV);
                Glide.with(mContext).load(list.get(position).getIcon())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .bitmapTransform(new CropCircleTransformation(mContext))
                        .into(onePictureViewHolder.headOneIV);
//
//                if (list.get(position).getAuther().getUser_flag() == null){
//                    Glide.with(mContext).load(list.get(position).getAuther().getUser_flag().get(0).getPic())
//                            .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//                            .bitmapTransform(new CropCircleTransformation(mContext))
//                            .into(onePictureViewHolder.userFlagOneIV);
//                }

                //设置RecyclerView的item监听
                if (mListener != null) {
                    onePictureViewHolder.itemView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int clickPosition = onePictureViewHolder.getAdapterPosition();
                            mListener.onItemClick(v, onePictureViewHolder, clickPosition);
                        }
                    });
                }

                break;
            case VIEW_TYPE_2:
                final TwoPictureViewHolder twoPictureViewHolder = (TwoPictureViewHolder) holder;
                twoPictureViewHolder.nameTwoTV.setText(list.get(position).getName());
                twoPictureViewHolder.dateTwoTV.setText(list.get(position).getDate());
                twoPictureViewHolder.titleTwoTV.setText(list.get(position).getTitle());
                twoPictureViewHolder.hotNumTwoTV.setText(list.get(position).getHotNum());
                twoPictureViewHolder.commentCountTwoTV.setText(list.get(position).getCount());
                twoPictureViewHolder.likeNumTwoTV.setText(list.get(position).getLikeNum());
                twoPictureViewHolder.contentTwoTV.setText(list.get(position).getContent());
                Glide.with(mContext).load(list.get(position).getThumbnail_medias().get(0).getUrl())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .into(twoPictureViewHolder.bigPictureTwoFirstIV);
                Glide.with(mContext).load(list.get(position).getThumbnail_medias().get(1).getUrl())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .into(twoPictureViewHolder.bigPictureTwoSecondIV);
                Glide.with(mContext).load(list.get(position).getIcon())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .bitmapTransform(new CropCircleTransformation(mContext))
                        .into(twoPictureViewHolder.headTwoIV);
//                Glide.with(mContext).load(list.get(position).getSpecial_info().getDiscussion_title())
//                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//                        .bitmapTransform(new CropCircleTransformation(mContext))
//                        .into(twoPictureViewHolder.userFlagTwoIV);

                //设置RecyclerView的item监听
                if (mListener != null) {
                    twoPictureViewHolder.itemView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int clickPosition = twoPictureViewHolder.getAdapterPosition();
                            mListener.onItemClick(v, twoPictureViewHolder, clickPosition);
                        }
                    });
                }
                break;
            case VIEW_TYPE_3:
                final ThreePictureViewHolder threePictureViewHolder = (ThreePictureViewHolder) holder;
                threePictureViewHolder.nameThreeTV.setText(list.get(position).getName());
                threePictureViewHolder.dateThreeTV.setText(list.get(position).getDate());
                threePictureViewHolder.titleThreeTV.setText(list.get(position).getTitle());
                threePictureViewHolder.hotNumThreeTV.setText(list.get(position).getHotNum());
                threePictureViewHolder.commentCountThreeTV.setText(list.get(position).getCount());
                threePictureViewHolder.likeNumThreeTV.setText(list.get(position).getLikeNum());
                threePictureViewHolder.contentThreeTV.setText(list.get(position).getContent());
                Glide.with(mContext).load(list.get(position).getThumbnail_medias().get(0).getUrl())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .into(threePictureViewHolder.bigPictureThreeFirstIV);
                Glide.with(mContext).load(list.get(position).getThumbnail_medias().get(1).getUrl())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .into(threePictureViewHolder.bigPictureThreeSecondIV);
                Glide.with(mContext).load(list.get(position).getThumbnail_medias().get(2).getUrl())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .into(threePictureViewHolder.bigPictureThreeThirdIV);
                Glide.with(mContext).load(list.get(position).getIcon())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                        .bitmapTransform(new CropCircleTransformation(mContext))
                        .into(threePictureViewHolder.headThreeIV);
//                Glide.with(mContext).load(list.get(position).getSpecial_info().getDiscussion_title())
//                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
//                        .bitmapTransform(new CropCircleTransformation(mContext))
//                        .into(threePictureViewHolder.userFlagThreeIV);

               //设置RecyclerView的item监听
                if (mListener != null) {
                    threePictureViewHolder.itemView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int clickPosition = threePictureViewHolder.getAdapterPosition();
                            mListener.onItemClick(v, threePictureViewHolder, clickPosition);
                        }
                    });
                }
                break;

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getThumbnail_medias().size() == 0){
            return VIEW_TYPE_0;
        }else if (list.get(position).getThumbnail_medias().size() == 1) {
            return VIEW_TYPE_1;
        } else if (list.get(position).getThumbnail_medias().size() == 2) {
            return VIEW_TYPE_2;
        } else if (list.get(position).getThumbnail_medias().size() == 3) {
            return VIEW_TYPE_3;
        } else return VIEW_TYPE_1;
    }

    public class ZeroPictureViewHolder extends ViewHolder{
        private ImageView headZeroIV, userFlagZeroIV;
        private TextView nameZeroTV, dateZeroTV, titleZeroTV, hotNumZeroTV, commentCountZeroTV, likeNumZeroTV, contentZeroTV;

        public ZeroPictureViewHolder(View itemView) {
            super(itemView);
            headZeroIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_img_head);
            userFlagZeroIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_img_user_flag);
            nameZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_name);
            dateZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_date);
            titleZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_title);
            hotNumZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_hot_num);
            commentCountZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_comment_count);
            likeNumZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_like_num);
            contentZeroTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_zero_textView_content);
        }
    }

    public class OnePictureViewHolder extends ViewHolder {
        private ImageView headOneIV, userFlagOneIV, bigPictureOneIV;
        private TextView nameOneTV, dateOneTV, titleOneTV, hotNumOneTV, commentCountOneTV, likeNumOneTV, contentOneTV;

        public OnePictureViewHolder(View itemView) {
            super(itemView);
            headOneIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_img_head);
            userFlagOneIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_img_user_flag);
            bigPictureOneIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_img_big_picture);
            nameOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_name);
            dateOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_date);
            titleOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_title);
            hotNumOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_hot_num);
            commentCountOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_comment_count);
            likeNumOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_like_num);
            contentOneTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_content);
        }
    }

    public class TwoPictureViewHolder extends ViewHolder {
        private ImageView headTwoIV, userFlagTwoIV, bigPictureTwoFirstIV, bigPictureTwoSecondIV;
        private TextView nameTwoTV, dateTwoTV, titleTwoTV, hotNumTwoTV, commentCountTwoTV, likeNumTwoTV, contentTwoTV;

        public TwoPictureViewHolder(View itemView) {
            super(itemView);
            headTwoIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_img_head);
            userFlagTwoIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_img_user_flag);
            bigPictureTwoFirstIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_img_big_picture_first);
            bigPictureTwoSecondIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_img_big_picture_second);
            nameTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_textView_name);
            dateTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_textView_date);
            titleTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_type_two_title);
            hotNumTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_textView_hot_num);
            commentCountTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_textView_comment_count);
            likeNumTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_two_textView_like_num);
            contentTwoTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_type_two_content);
        }
    }

    public class ThreePictureViewHolder extends ViewHolder {
        private ImageView headThreeIV, userFlagThreeIV, bigPictureThreeFirstIV, bigPictureThreeSecondIV, bigPictureThreeThirdIV;
        private TextView nameThreeTV, dateThreeTV, titleThreeTV, hotNumThreeTV, commentCountThreeTV, likeNumThreeTV, contentThreeTV;

        public ThreePictureViewHolder(View itemView) {
            super(itemView);
            headThreeIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_img_head);
            userFlagThreeIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_img_user_flag);
            bigPictureThreeFirstIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_img_big_picture_first);
            bigPictureThreeSecondIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_img_big_picture_second);
            bigPictureThreeThirdIV = (ImageView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_img_big_picture_third);
            nameThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_textView_name);
            dateThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_textView_date);
            titleThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_type_three_title);
            hotNumThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_textView_hot_num);
            commentCountThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_textView_comment_count);
            likeNumThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_type_three_textView_like_num);
            contentThreeTV = (TextView) itemView.findViewById(R.id.item_fragment_community_selection_listView_textView_type_three_content);
        }
    }

    public interface OnRecyclerItemClickListener {
        void onItemClick(View view, ViewHolder holder, int position);
    }
}
