package com.example.dllo.zaker.community.slidingitem.friends;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by yuxiaomin~ on 16/9/3.
 */
public class CommunityFriendsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEAD = 0;
    private static final int ONE_IMG = 1;
    private static final int TWO_IMG = 2;
    private static final int THREE_IMG = 3;
    private static final int LINK = 4;
    private static final int LINK_NONE = 5;

    private LayoutInflater mInflater;

    private CommunityFriendsBean mFriendsBean;
    private Context mContext;

    private OnRecyclerItemClickListener mListener;

    public void setOnRecyclerItemListener(OnRecyclerItemClickListener listener) {
        this.mListener = listener;
    }


    public CommunityFriendsAdapter(Context context) {
        mContext = context;
    }

    public void setFriendsBean(CommunityFriendsBean friendsBean) {
        mFriendsBean = friendsBean;
        mInflater = LayoutInflater.from(mContext);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEAD:
                return new HeadViewHolder(mInflater.inflate(R.layout.fragment_community_friends_item_head, parent, false));
            case ONE_IMG:
                return new OneImgViewHolder(mInflater.inflate(R.layout.fragment_community_friends_item_one_img, parent, false));
            case TWO_IMG:
                return new TwoImgViewHolder(mInflater.inflate(R.layout.fragment_community_friends_item_two_img, parent, false));
            case THREE_IMG:
                return new ThreeImgViewHolder(mInflater.inflate(R.layout.fragment_community_friends_item_three_img, parent, false));
            case LINK:
                return new LinkImgViewHolder(mInflater.inflate(R.layout.fragment_community_friends_item_link, parent, false));
            case LINK_NONE:
                return new LinkNoneImgViewHolder(mInflater.inflate(R.layout.fragment_community_friends_item_link_none, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        CommunityFriendsBean.DataBean.ListBean mListBean = mFriendsBean.getData().getList().get(position);
        int type = getItemViewType(position);
        switch (type) {
            case HEAD:
                HeadViewHolder headViewHolder = (HeadViewHolder) holder;


                break;
            case ONE_IMG:
                OneImgViewHolder oneImgViewHolder = (OneImgViewHolder) holder;
                oneImgViewHolder.name.setText(mListBean.getAuther().getName());
                oneImgViewHolder.declare.setText(mListBean.getAction_text());
                oneImgViewHolder.time.setText(mListBean.getDate());
                oneImgViewHolder.content.setText(mListBean.getContent());
                oneImgViewHolder.zan.setText(mListBean.getLike().getLike_num() + "赞");

                Glide.with(mContext).load(mListBean.getAuther().getIcon()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(oneImgViewHolder.ivHead);
                Glide.with(mContext).load(mListBean.getAuther().getUser_flag().get(0).getPic()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(oneImgViewHolder.ivTag);
                Glide.with(mContext).load(mListBean.getMedias().get(0).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(oneImgViewHolder.ivContentBack);
                break;
            case TWO_IMG:
                TwoImgViewHolder twoImgViewHolder = (TwoImgViewHolder) holder;
                twoImgViewHolder.name.setText(mListBean.getAuther().getName());
                twoImgViewHolder.declare.setText(mListBean.getAction_text());
                twoImgViewHolder.time.setText(mListBean.getDate());
                twoImgViewHolder.content.setText(mListBean.getContent());
                twoImgViewHolder.zan.setText(mListBean.getLike().getLike_num() + "赞");

                Glide.with(mContext).load(mListBean.getAuther().getIcon()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(twoImgViewHolder.ivHead);
                Glide.with(mContext).load(mListBean.getAuther().getUser_flag().get(0).getPic()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(twoImgViewHolder.ivTag);
                Glide.with(mContext).load(mListBean.getMedias().get(0).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(twoImgViewHolder.ivContentBackFir);
                Glide.with(mContext).load(mListBean.getMedias().get(1).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(twoImgViewHolder.ivContentBackSec);
                break;
            case THREE_IMG:
                ThreeImgViewHolder threeImgViewHolder = (ThreeImgViewHolder) holder;
                threeImgViewHolder.name.setText(mListBean.getAuther().getName());
                threeImgViewHolder.declare.setText(mListBean.getAction_text());
                threeImgViewHolder.time.setText(mListBean.getDate());
                threeImgViewHolder.content.setText(mListBean.getContent());
                threeImgViewHolder.zan.setText(mListBean.getLike().getLike_num() + "赞");

                Glide.with(mContext).load(mListBean.getAuther().getIcon()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(threeImgViewHolder.ivHead);
                Glide.with(mContext).load(mListBean.getAuther().getUser_flag().get(0).getPic()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(threeImgViewHolder.ivTag);
                Glide.with(mContext).load(mListBean.getMedias().get(0).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(threeImgViewHolder.ivContentBackFir);
                Glide.with(mContext).load(mListBean.getMedias().get(1).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(threeImgViewHolder.ivContentBackSec);
                Glide.with(mContext).load(mListBean.getMedias().get(1).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(threeImgViewHolder.ivContentBackThird);
                break;
            case LINK:
                LinkImgViewHolder linkImgViewHolder = (LinkImgViewHolder) holder;
                linkImgViewHolder.name.setText(mListBean.getAuther().getName());
                linkImgViewHolder.declare.setText(mListBean.getAction_text());
                linkImgViewHolder.time.setText(mListBean.getDate());
                linkImgViewHolder.content.setText(mListBean.getContent());
                linkImgViewHolder.contentContent.setText(mListBean.getQuote().getContent());

                linkImgViewHolder.zan.setText(mListBean.getLike().getLike_num() + "赞");

                Glide.with(mContext).load(mListBean.getAuther().getIcon()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(linkImgViewHolder.ivHead);
                Glide.with(mContext).load(mListBean.getAuther().getUser_flag().get(0).getPic()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(linkImgViewHolder.ivTag);
                Glide.with(mContext).load(mListBean.getQuote().getMedias().get(0).getUrl()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(linkImgViewHolder.ivContentHead);
                break;
            case LINK_NONE:
                LinkNoneImgViewHolder linkNoneImgViewHolder = (LinkNoneImgViewHolder) holder;
                linkNoneImgViewHolder.name.setText(mListBean.getAuther().getName());
                linkNoneImgViewHolder.declare.setText(mListBean.getAction_text());
                linkNoneImgViewHolder.time.setText(mListBean.getDate());
                linkNoneImgViewHolder.content.setText(mListBean.getContent());

                linkNoneImgViewHolder.zan.setText(mListBean.getLike().getLike_num() + "赞");

                Glide.with(mContext).load(mListBean.getAuther().getIcon()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).bitmapTransform(new CropCircleTransformation(MyApp.getContext())).into(linkNoneImgViewHolder.ivHead);
                Glide.with(mContext).load(mListBean.getAuther().getUser_flag().get(0).getPic()).placeholder(R.mipmap.defaule).error(R.mipmap.fail).into(linkNoneImgViewHolder.ivTag);
                break;
        }

        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickPos = holder.getAdapterPosition();
                    mListener.onItemClick(v, holder, clickPos);
                }
            });
        }

    }



    @Override
    public int getItemCount() {
        return mFriendsBean.getData().getList().size();
    }


    private class HeadViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout ll;

        public HeadViewHolder(View itemView) {
            super(itemView);
            ll = (LinearLayout) itemView.findViewById(R.id.ll_community_login);

        }
    }

    @Override
    public int getItemViewType(int position) {
        CommunityFriendsBean.DataBean.ListBean mL = mFriendsBean.getData().getList().get(position);
        if (position == 0) {
            return HEAD;
        }
        if (mL.getMedias().size() == 1 || mL.getMedias().size() > 3) {
            return ONE_IMG;
        } else if (mL.getMedias().size() == 2) {
            return TWO_IMG;
        } else if (mL.getMedias().size() == 3) {
            return THREE_IMG;
        } else if (mL.getMedias().size() == 0 && mL.getQuote() != null) {
            return LINK;
        } else {
            return LINK_NONE;
        }
    }

    private class OneImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHead, ivContentBack, ivTag, ivMsg, ivGood;
        private FrameLayout ivFocus;
        private TextView name, time, declare, content, zan;

        public OneImgViewHolder(View itemView) {
            super(itemView);
            ivHead = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_one_img_head);
            ivContentBack = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_one_img_content);
            ivTag = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_one_img_tag);
            ivFocus = (FrameLayout) itemView.findViewById(R.id.frame_community_friends_item_one_img_focus);
            ivMsg = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_one_img_msg);
            ivGood = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_one_img_good);

            name = (TextView) itemView.findViewById(R.id.tv_community_friends_item_one_img_name);
            time = (TextView) itemView.findViewById(R.id.tv_community_friends_item_one_img_time);
            declare = (TextView) itemView.findViewById(R.id.tv_community_friends_item_one_img_declare);
            content = (TextView) itemView.findViewById(R.id.tv_community_friends_item_one_img_content);
            zan = (TextView) itemView.findViewById(R.id.tv_community_friends_item_one_img_zan);
        }
    }

    private class TwoImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHead, ivContentBackFir, ivContentBackSec, ivTag, ivMsg, ivGood;
        private FrameLayout ivFocus;
        private TextView name, time, declare, content, zan;

        public TwoImgViewHolder(View itemView) {
            super(itemView);
            ivHead = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_two_img_head);
            ivContentBackFir = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_two_img_content_img_first);
            ivContentBackSec = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_two_img_content_img_sec);
            ivTag = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_two_img_tag);
            ivFocus = (FrameLayout) itemView.findViewById(R.id.frame_community_friends_item_two_img_fouse);
            ivMsg = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_two_img_msg);
            ivGood = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_two_img_good);

            name = (TextView) itemView.findViewById(R.id.tv_community_friends_item_two_img_name);
            time = (TextView) itemView.findViewById(R.id.tv_community_friends_item_two_img_time);
            declare = (TextView) itemView.findViewById(R.id.tv_community_friends_item_two_img_declare);
            content = (TextView) itemView.findViewById(R.id.tv_community_friends_item_two_img_content);
            zan = (TextView) itemView.findViewById(R.id.tv_community_friends_item_two_img_zan);
        }
    }

    private class ThreeImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHead, ivContentBackFir, ivContentBackSec, ivContentBackThird, ivTag, ivMsg, ivGood;
        private TextView name, time, declare, content, zan;
        private FrameLayout ivFocus;

        public ThreeImgViewHolder(View itemView) {
            super(itemView);
            ivHead = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_head);
            ivContentBackFir = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_content_img_first);
            ivContentBackSec = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_content_img_sec);
            ivContentBackThird = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_content_img_third);
            ivTag = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_tag);
            ivFocus = (FrameLayout) itemView.findViewById(R.id.frame_community_friends_item_three_img_fouse);
            ivMsg = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_msg);
            ivGood = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_three_img_good);

            name = (TextView) itemView.findViewById(R.id.tv_community_friends_item_three_img_name);
            time = (TextView) itemView.findViewById(R.id.tv_community_friends_item_three_img_time);
            declare = (TextView) itemView.findViewById(R.id.tv_community_friends_item_three_img_declare);
            content = (TextView) itemView.findViewById(R.id.tv_community_friends_item_three_img_content);
            zan = (TextView) itemView.findViewById(R.id.tv_community_friends_item_three_img_zan);
        }
    }

    private class LinkImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHead, ivContentHead, ivTag, ivMsg, ivGood;
        private TextView name, time, declare, content, zan, contentContent;
        private FrameLayout ivFocus;

        public LinkImgViewHolder(View itemView) {
            super(itemView);
            ivHead = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_img_head);
            ivContentHead = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_img_content_head);
            ivTag = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_img_tag);
            ivFocus = (FrameLayout) itemView.findViewById(R.id.frame_community_friends_item_link_img_fouse);
            ivMsg = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_img_msg);
            ivGood = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_img_good);

            name = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_img_name);
            time = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_img_time);
            declare = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_img_declare);
            contentContent = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_img_content_content);
            content = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_img_content);
            zan = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_img_zan);
        }
    }

    private class LinkNoneImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHead, ivContentHead, ivTag, ivMsg, ivGood;
        private TextView name, time, declare, content, zan, contentContent;
        private FrameLayout ivFocus;

        public LinkNoneImgViewHolder(View itemView) {
            super(itemView);
            ivHead = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_none_img_head);

            ivTag = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_none_img_tag);
            ivFocus = (FrameLayout) itemView.findViewById(R.id.frame_community_friends_item_link_none_img_fouse);
            ivMsg = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_none_img_msg);
            ivGood = (ImageView) itemView.findViewById(R.id.iv_community_friends_item_link_none_img_good);

            name = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_none_img_name);
            time = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_none_img_time);
            declare = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_none_img_declare);
            content = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_none_img_content);
            zan = (TextView) itemView.findViewById(R.id.tv_community_friends_item_link_none_img_zan);
        }
    }

    public interface OnRecyclerItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position);
    }
}
