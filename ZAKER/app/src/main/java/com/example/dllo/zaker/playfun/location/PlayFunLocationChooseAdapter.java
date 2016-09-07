package com.example.dllo.zaker.playfun.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.zaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxiaomin~ on 16/7/29.
 */
public class PlayFunLocationChooseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;
    private Context context;
    private List<PlayFunLocationChooseBean> cityLists = new ArrayList<>();
    private onItemClickListener listener;
    private PlayFunLocationChooseBean mChooseBean;

    public PlayFunLocationChooseAdapter(Context context) {
        this.context = context;
    }



    public void setChooseBean(PlayFunLocationChooseBean chooseBean) {
        mChooseBean = chooseBean;
        notifyDataSetChanged();
        Log.d("PlayFunLocationChooseAd", mChooseBean.getData().getCities().get(7).getCity_name());
    }

    public interface onItemClickListener {
        void itemClick(int position);
    }

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_playfun_location_choose_city_rv_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof CityViewHolder) {
            CityViewHolder viewHolder = (CityViewHolder) holder;
//            PlayFunLocationChooseBean cityBean = cityLists.get(position);
            viewHolder.tvCityName.setText(mChooseBean.getData().getCities().get(position).getCity_name());

            viewHolder.rlContentWrapper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(position);
                }
            });


            if (position == 0) {
                viewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
                viewHolder.tvStickyHeader.setText(mChooseBean.getData().getCities().get(position).getLetter());
                viewHolder.itemView.setTag(FIRST_STICKY_VIEW);
            } else {
                if (!TextUtils.equals(mChooseBean.getData().getCities().get(position).getLetter(), mChooseBean.getData().getCities().get(position - 1).getLetter())) {
                    viewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
                    viewHolder.tvStickyHeader.setText(mChooseBean.getData().getCities().get(position).getLetter());
                    viewHolder.itemView.setTag(HAS_STICKY_VIEW);
                } else {
                    viewHolder.tvStickyHeader.setVisibility(View.GONE);
                    viewHolder.itemView.setTag(NONE_STICKY_VIEW);
                }
            }

            viewHolder.itemView.setContentDescription(mChooseBean.getData().getCities().get(position).getLetter());
        }


    }

    @Override
    public int getItemCount() {
        return mChooseBean.getData().getCities().size() == 0 ? 0 : mChooseBean.getData().getCities().size();
    }


    public class CityViewHolder extends RecyclerView.ViewHolder {

        TextView tvStickyHeader, tvCityName;
        RelativeLayout rlContentWrapper;


        public CityViewHolder(View itemView) {
            super(itemView);

            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_city_choose_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvCityName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


}
