package com.example.dllo.zaker.playfun.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.playfun.PlayFunBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/30.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private PlayFunBean mPlayFunBean;
    private int prePosition;

    public void setPosition(int position) {
        this.prePosition = position;
        notifyDataSetChanged();
    }

    public void setPlayFunBean(PlayFunBean playFunBean) {
        mPlayFunBean = playFunBean;
        notifyDataSetChanged();
    }

    public ListViewAdapter(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return mPlayFunBean.getData().getColumns().get(prePosition).getItems().size() == 0 ? 0 : mPlayFunBean.getData().getColumns().get(prePosition).getItems().size();
    }

    @Override
    public Object getItem(int position) {
        return mPlayFunBean.getData().getColumns().get(prePosition).getItems().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_playfun_listview_listview_item,parent,false);
            listViewHolder = new ListViewHolder(convertView);
            convertView.setTag(listViewHolder);
        }else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }
        listViewHolder.titleTV.setText(mPlayFunBean.getData().getColumns().get(prePosition).getItems().get(position).getTitle());
        listViewHolder.contentTV.setText(mPlayFunBean.getData().getColumns().get(prePosition).getItems().get(position).getContent());
        Picasso.with(mContext).load(mPlayFunBean.getData().getColumns().get(prePosition).getItems().get(position).getPic().getUrl())
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(listViewHolder.backgroundIV);
        return convertView;
    }


    public class ListViewHolder{
        private TextView titleTV,contentTV;
        private ImageView backgroundIV;
        public ListViewHolder(View view) {
            titleTV = (TextView) view.findViewById(R.id.playFun_listView_listView_textView_title);
            contentTV = (TextView) view.findViewById(R.id.playFun_listView_listView_textView_content);
            backgroundIV = (ImageView) view.findViewById(R.id.playFun_listView_listView_img);
        }
    }


}
