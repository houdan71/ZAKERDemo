package com.example.dllo.zaker.subscription.fragment_adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_add_image;
import com.example.dllo.zaker.subscription.entity.Bean_essen;
import com.example.dllo.zaker.subscription.entity.Bean_essence;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/1.
 */
public class EssenceAdapter extends BaseAdapter {
    private Context context;
   private Bean_essen bean_essen;

    public EssenceAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_essen.getData().getList().size();
    }

    @Override
    public Object getItem(int position) {
        return bean_essen.getData().getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView == null){
            convertView=LayoutInflater.from(context).inflate(R.layout.item_essen,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(bean_essen.getData().getList()
        .get(position).getBlock_info().getPic()).bitmapTransform(new CropCircleTransformation(context))
        .into(holder.image_essen);
        String color = bean_essen.getData().getList()
                .get(position).getBlock_info().getBlock_color();


        holder.image_essen.setColorFilter(android.graphics.Color.parseColor(color));


        holder.text_top.setText(bean_essen
        .getData().getList().get(position).getBlock_info().getTitle());
        holder.text_below.setText(bean_essen.getData().getList().get(position)
        .getBlock_info().getStitle());

        return convertView;
    }

    public void setBean_essen(Bean_essen bean_essen) {
        this.bean_essen = bean_essen;
        notifyDataSetChanged();
    }

    class ViewHolder{
        private ImageView image_essen;
        private TextView text_top,text_below;
        public ViewHolder(View view){
            image_essen = (ImageView) view.findViewById(R.id.image_essen);
            text_top= (TextView) view.findViewById(R.id.text_top);
            text_below= (TextView) view.findViewById(R.id.text_below);
        }

    }




}
