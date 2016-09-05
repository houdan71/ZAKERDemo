package com.example.dllo.zaker.subscription.fragment_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_foodie;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/2.
 */
public class FoodieAdapter extends BaseAdapter {
    private Context context;
    private Bean_foodie bean_foodie;

    public FoodieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_foodie.getData().getPosts().size();
    }

    @Override
    public Object getItem(int position) {
        return bean_foodie.getData().getPosts().get(position);
    }

    @Override
    public long getItemId(int position) {


        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodie,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(bean_foodie.getData().getPosts().get(position)
                .getAuther().getIcon()).bitmapTransform(new CropCircleTransformation(context)).into(holder.image_foodie);
        holder.text_foodie_name.setText(bean_foodie.getData().getPosts().get(position).getAuther().getName());
        holder.text_foodie_title.setText(bean_foodie.getData().getPosts().get(position).getContent());
        holder.text_foodie_time.setText(bean_foodie.getData().getPosts().get(position).getDate());
        Glide.with(context).load(bean_foodie.getData().getPosts().get(position)
                .getThumbnail_medias().get(position).
                        getUrl()).into(holder.image_foodie_view);




        return convertView;
    }

    public void setBean_foodie(Bean_foodie bean_foodie) {
        this.bean_foodie = bean_foodie;
        notifyDataSetChanged();
    }

    class ViewHolder{
        private ImageView image_foodie,image_foodie_view;
        private TextView text_foodie_name,text_foodie_time,text_foodie_title;
        public ViewHolder(View view){
            image_foodie = (ImageView) view.findViewById(R.id.image_foodie);
            image_foodie_view= (ImageView) view.findViewById(R.id.image_foodie_view);
            text_foodie_name= (TextView) view.findViewById(R.id.text_foodie_name);
            text_foodie_time= (TextView) view.findViewById(R.id.text_foodie_time);
            text_foodie_title= (TextView) view.findViewById(R.id.text_foodie_title);


        }
    }
}
