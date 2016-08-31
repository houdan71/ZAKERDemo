package com.example.dllo.zaker.subscription;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.subscription.GridAdapter.GridHolder;


/**
 * Created by dllo on 16/8/31.
 */
 public class GridAdapter extends Adapter<GridHolder> {
    private Context context;

    private OnRecyclerItemClickListener listener;

    public GridAdapter(Context context) {
        this.context = context;
    }

  public  void delect(int position){

  }
    @Override
    public GridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(context).inflate(R.layout.item_grid,parent,false);
        return  new GridHolder(view) ;

    }

    @Override
    public void onBindViewHolder(final GridHolder holder, int position) {
        holder.textView.setText(titles[position]);
        holder.imageView.setImageResource(image[position]);
        if (listener  != null){
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickPosition  =holder.getAdapterPosition();
                    listener.onItemClick(v,holder,clickPosition);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
    private String titles[]={"今日看点","头条新闻",
                "汽车频道","科技频道",
            "奢饰品频道","旅游频道",
            "财经新闻","体育频道",
            "娱乐八卦","时尚频道",
            "投资理财","电影资讯",
            "美食频道","美女",
            "奥运频道","添加更多"
    };
    private int  image[] ={
            R.mipmap.jinrikandian, R.mipmap.toutiaoxinwen,
            R.mipmap.guide_loading_tag_62, R.mipmap.guide_loading_tag_47,
            R.mipmap.sheshipin, R.mipmap.guide_loading_tag_67,
            R.mipmap.guide_loading_tag_46, R.mipmap.guide_loading_tag_49,
            R.mipmap.bagua, R.mipmap.guide_loading_tag_61,
            R.mipmap.touzilicai, R.mipmap.movie,
            R.mipmap.guide_loading_tag_102, R.mipmap.meinv,
            R.mipmap.aoyun, R.mipmap.icon_add_pressed,
    };
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        this.listener =listener;


    }
    public class GridHolder extends ViewHolder {
         private TextView textView;
         private ImageView imageView;
         public GridHolder(View itemview){
             super(itemview);
             imageView = (ImageView) itemview.findViewById(R.id.image_grid);
             textView = (TextView) itemview.findViewById(R.id.text_grid);
         }
     }
    public interface OnRecyclerItemClickListener{
        void onItemClick(View view,ViewHolder holder,int position);
    }

    }




