package com.example.dllo.zaker.subscription.fragment_adapter;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.entity.Bean_moviefan;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/9/2.
 */
public class MovieFanAdapter extends BaseAdapter {
    private Context context;
    private Bean_moviefan bean_moviefan;

    public MovieFanAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_moviefan.getData().getPosts().size();
    }

    @Override
    public Object getItem(int position) {
        return bean_moviefan.getData().getPosts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView == null){
            convertView= LayoutInflater.from(context)
                    .inflate(R.layout.item_foodie,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(bean_moviefan.getData()
        .getPosts().get(position).getAuther().getName()).
                bitmapTransform(new CropCircleTransformation(context)).into(holder.image_moviefan);
        holder.text_moniefan_name.setText(bean_moviefan
        .getData().getPosts().get(position)
        .getAuther().getName());
        holder.text_moviefan_title.setText(bean_moviefan
        .getData().getPosts().get(position)
        .getContent());
        holder.text_moviefan_time.setText(bean_moviefan
        .getData().getPosts()
        .get(position).getList_date());
        if (bean_moviefan.getData().getPosts().get(position).getThumbnail_medias().size()>0){

            Glide.with(context).load(bean_moviefan
               .getData().getPosts().get(position).getThumbnail_medias()
               .get(0).getUrl()).into(holder.image_moviefan_view);
        }
        else {
            holder.image_moviefan_view.setVisibility(View.GONE);
        }
//   if (bean_moviefan.getData().getPosts().get(position).getThumbnail_medias()  ==  null){
//       View view =LayoutInflater.from(context).inflate(R.layout.item_foodiee,parent,false);
//       return view;
//
//   }else {
//
//       Glide.with(context).load(bean_moviefan
//               .getData().getPosts().get(position).getThumbnail_medias()
//               .get(0).getUrl()).into(holder.image_moviefan_view);
//
//   }
        return convertView;
    }

    public void setBean_moviefan(Bean_moviefan bean_moviefan) {
        this.bean_moviefan = bean_moviefan;
        notifyDataSetChanged();
    }

    class ViewHolder{
        private ImageView image_moviefan,image_moviefan_view;
        private TextView text_moniefan_name,text_moviefan_time,text_moviefan_title;
        public ViewHolder(View view){
            image_moviefan= (ImageView) view.findViewById(R.id.image_foodie);
            image_moviefan_view= (ImageView) view.findViewById(R.id.image_foodie_view);
            text_moniefan_name= (TextView) view.findViewById(R.id.text_foodie_name);
            text_moviefan_title= (TextView) view.findViewById(R.id.text_foodie_title);
            text_moviefan_time= (TextView) view.findViewById(R.id.text_foodie_time);

        }
    }
}
