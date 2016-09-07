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
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.subscription.entity.Bean_film;
import com.example.dllo.zaker.subscription.entity.Bean_movie;

/**
 * Created by dllo on 16/9/2.
 */
public class FilmAdapter extends BaseAdapter {
    private Context context;
    private Bean_movie bean_movie;

    public FilmAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return bean_movie.getData().getArticles().size();
    }

    @Override
    public Object getItem(int position) {
        return bean_movie.getData().getArticles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie_film,parent,false);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(bean_movie
                .getData().getArticles()
                .get(position).getThumbnail_pic()).into(holder.image_film_view);
        holder.text_film_title.setText(bean_movie
                .getData().getArticles()
        .get(position).getTitle());
        holder.text_film_time.setText(bean_movie
        .getData().getArticles()
        .get(position).getDate());
        holder.text_film_name.setText(bean_movie
        .getData().getArticles().get(position)
        .getAuther_name());
        return convertView;
    }

    public void setBean_movie(Bean_movie bean_movie) {
        this.bean_movie = bean_movie;
        notifyDataSetChanged();
    }



    class ViewHolder{
        private TextView text_film_title,text_film_time,text_film_name;
        private ImageView image_film_view;
        public ViewHolder(View  view){
            text_film_title= (TextView) view.findViewById(R.id.text_film_title);
            text_film_time= (TextView) view.findViewById(R.id.text_film_time);
            text_film_name= (TextView) view.findViewById(R.id.text_film_name);
            image_film_view= (ImageView) view.findViewById(R.id.image_film_view);
        }
    }
}
