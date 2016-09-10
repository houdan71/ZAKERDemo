package com.example.dllo.zaker.hotspot.tag.mylike;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.zaker.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/8.
 */
public class MyLikeAdapter extends RecyclerView.Adapter<MyLikeAdapter.ViewHolder> {
    private MyLikeBean mLikeBean;
    private Context mContext;
    private String tag;

    private ArrayList<MyLikeBean> mBeanArrayList;

    private int i;

    public void setBeanArrayList(ArrayList<MyLikeBean> beanArrayList) {
        mBeanArrayList = beanArrayList;
        i = mBeanArrayList.size();
        notifyDataSetChanged();
    }

    private OnRecyclerItemClickListener mListener;

    public void setOnRecyclerItemListener(OnRecyclerItemClickListener listener) {
        this.mListener = listener;
    }

    public void setLikeBean(MyLikeBean likeBean, String tag) {
        mLikeBean = likeBean;
        this.tag = tag;
        notifyDataSetChanged();
    }

    public void add(int position, String str) {
        mLikeBean.getData().getUser_tags().add(position, str);
        notifyItemInserted(position);
    }


    public void delete(int position) {
        mLikeBean.getData().getHot_tags().remove(position);
        notifyItemRemoved(position);
    }

    public MyLikeAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_hotspot_tag_my_like_item, parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (tag.equals("addMore")) {
            holder.mTextView.setText(mLikeBean.getData().getHot_tags().get(position));
//            holder.mTextView.setText(mLikeBean.getData().get);
        } else {
            if (position > 2) {
//                if (position < mBeanArrayList.size() -2){

                holder.mTextView.setText(mBeanArrayList.get(mBeanArrayList.size() -1).getStr());
//                }else {
//
//                holder.mTextView.setText(mLikeBean.getData().getUser_tags().get(position));
//                }
            } else {
                holder.mTextView.setText(mLikeBean.getData().getUser_tags().get(position));
            }
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
        if (tag.equals("addMore")) {
            return 6;
        } else {
            Log.d("MyLikeAdapter", "i:" + i);
            return mLikeBean.getData().getUser_tags().size() + i;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_hotspot_tag_my_like);
        }
    }


    public interface OnRecyclerItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position);
    }
}
