package com.example.dllo.zaker.community.slidingitem.select;

import com.example.dllo.zaker.community.slidingitem.select.CommunitySelectionBean.DataBean.PostsBean;

import java.util.List;

/**
 * Created by dllo on 16/9/7.
 */
public class MyDataBean {
    private String name,title,hotNum,likeNum,date,content,count,icon;
    private List<CommunitySelectionBean.DataBean.PostsBean.ThumbnailMediasBean> thumbnail_medias;

    public List<PostsBean.ThumbnailMediasBean> getThumbnail_medias() {
        return thumbnail_medias;
    }

    public void setThumbnail_medias(List<PostsBean.ThumbnailMediasBean> thumbnail_medias) {
        this.thumbnail_medias = thumbnail_medias;
    }




    public String getName() {
        return name;
    }

    public MyDataBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MyDataBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getHotNum() {
        return hotNum;
    }

    public MyDataBean setHotNum(String hotNum) {
        this.hotNum = hotNum;
        return this;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public MyDataBean setLikeNum(String likeNum) {
        this.likeNum = likeNum;
        return this;
    }

    public String getDate() {
        return date;
    }

    public MyDataBean setDate(String date) {
        this.date = date;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MyDataBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCount() {
        return count;
    }

    public MyDataBean setCount(String count) {
        this.count = count;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public MyDataBean setIcon(String icon) {
        this.icon = icon;
        return this;
    }
}
