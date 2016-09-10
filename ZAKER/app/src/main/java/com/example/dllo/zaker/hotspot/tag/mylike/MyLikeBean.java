package com.example.dllo.zaker.hotspot.tag.mylike;

import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class MyLikeBean {
    /**
     * stat : 1
     * msg : OK
     * data : {"user_tags":["互联网","女神"],"suggest_tags":[],"hot_tags":["美食","明星","旅游","互联网","电商","日本","街拍","心理","互联网金融","设计","iPhone","4G","苹果","赚钱","Android","iOS","Twitter","减肥","电影","小米","创业","商业模式","养生","三星","微信","美剧","谷歌","女神","星座","魅族"]}
     */

    private String stat;
    private String msg;
    private DataBean data;

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> user_tags;
        private List<?> suggest_tags;
        private List<String> hot_tags;

        public List<String> getUser_tags() {
            return user_tags;
        }

        public void setUser_tags(List<String> user_tags) {
            this.user_tags = user_tags;
        }

        public List<?> getSuggest_tags() {
            return suggest_tags;
        }

        public void setSuggest_tags(List<?> suggest_tags) {
            this.suggest_tags = suggest_tags;
        }

        public List<String> getHot_tags() {
            return hot_tags;
        }

        public void setHot_tags(List<String> hot_tags) {
            this.hot_tags = hot_tags;
        }
    }
}
