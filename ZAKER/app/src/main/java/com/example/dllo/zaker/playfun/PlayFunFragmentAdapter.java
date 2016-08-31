package com.example.dllo.zaker.playfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.playfun.listview.ListViewAdapter;
import com.example.dllo.zaker.playfun.listview.MyListView;


/**
 * Created by dllo on 16/8/30.
 * 玩乐页 对应的适配器
 */
public class PlayFunFragmentAdapter extends BaseAdapter {
    private Context mContext;
    private PlayFunBean mPlayFunBean;

    private ListViewAdapter mListViewAdapter;

    public PlayFunFragmentAdapter(Context context) {
        mContext = context;


    }


    public void setPlayFunBean(PlayFunBean playFunBean) {
        mPlayFunBean = playFunBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mPlayFunBean.getData().getColumns().size() == 0 ? 0 : mPlayFunBean.getData().getColumns().size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       PlayFunViewHolder playFunViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_playfun_listview_listview,parent,false);
            playFunViewHolder = new PlayFunViewHolder(convertView);
            convertView.setTag(playFunViewHolder);
        }else {
            playFunViewHolder = (PlayFunViewHolder) convertView.getTag();
        }

        playFunViewHolder.dateListView.setText(mPlayFunBean.getData().getColumns().get(position).getTitle());
        mListViewAdapter = new ListViewAdapter(mContext);
        mListViewAdapter.setPosition(position);
        mListViewAdapter.setPlayFunBean(mPlayFunBean);
        playFunViewHolder.showListView.setAdapter(mListViewAdapter);
        return convertView;
    }


    public class PlayFunViewHolder{
        private MyListView showListView;
        private TextView dateListView;
        public PlayFunViewHolder(View view) {
            showListView = (MyListView) view.findViewById(R.id.playFun_listView_listView);
            dateListView = (TextView) view.findViewById(R.id.playFun_listView_textView_listView);

        }
    }


}
