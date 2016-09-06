package com.example.dllo.zaker.subscription.entity;

import java.util.List;

/**
 * Created by dllo on 16/9/3.
 */
public class Bean_add_image {

    /**
     * stat : 1
     * msg : OK
     * data : {"info":{"common_api_url":"http://iphone.myzaker.com/zaker/common_api.php","readstat":"http://stat.myzaker.com/stat.php"},"message_info":{"refresh_key":"1472842800","show_key":"1398149413"},"list":[[{"pk":"54dee8fa9490cbde430000ba","title":"本周新频道上线","end_time":"1473004799","type":"block_topic","pop_type":"","modified":"1472724930","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=54dee8fa9490cbde430000ba&position=recommendation_promotion","block_topic":{"api_url":"http://iphone.myzaker.com/zaker/block_topic.php?id=54dee8fa9490cbde430000ba"},"promotion_img":"http://zkres.myzaker.com/201604/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTYtMDQtMTgvMTQ2MDk2OTg4NTMyODYucG5n_10000.jpg","img_height":"240","img_width":"1206"}],[{"pk":"52f376df9490cbd43400001c","title":"太平洋家居","end_time":"1473004799","type":"block","pop_type":"","modified":"1472724994","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=52f376df9490cbd43400001c&position=recommendation_promotion","block_info":{"pk":"10601","title":"太平洋家居网","stitle":"","block_title":"太平洋家居网","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=10601","data_type":"rss","pic":"http://zkres.myzaker.com/data/image/logo/10601.png?1420613972","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/10601.png?1420613972"},"promotion_img":"http://zkres.myzaker.com/201402/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTQtMDItMDYvMTM5MTY4NzM4NDM1MjcucG5n_10000.jpg","img_height":"120","img_width":"305"},{"pk":"540071d49490cb5d6d0000ad","title":"腕表之家","end_time":"1473004799","type":"block","pop_type":"","modified":"1472725070","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=540071d49490cb5d6d0000ad&position=recommendation_promotion","block_info":{"pk":"11329","title":"腕表之家","stitle":"","block_title":"腕表之家","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=11329","data_type":"","pic":"http://zkres.myzaker.com/data/image/logo/11329.png?1392776056","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/11329.png?1392776056"},"promotion_img":"http://zkres.myzaker.com/201408/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTQtMDgtMjkvMTQwOTMxNTI1NDQzODYuanBn_10000.jpg","img_height":"120","img_width":"305"}]]}
     */

    private String stat;
    private String msg;
    /**
     * info : {"common_api_url":"http://iphone.myzaker.com/zaker/common_api.php","readstat":"http://stat.myzaker.com/stat.php"}
     * message_info : {"refresh_key":"1472842800","show_key":"1398149413"}
     * list : [[{"pk":"54dee8fa9490cbde430000ba","title":"本周新频道上线","end_time":"1473004799","type":"block_topic","pop_type":"","modified":"1472724930","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=54dee8fa9490cbde430000ba&position=recommendation_promotion","block_topic":{"api_url":"http://iphone.myzaker.com/zaker/block_topic.php?id=54dee8fa9490cbde430000ba"},"promotion_img":"http://zkres.myzaker.com/201604/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTYtMDQtMTgvMTQ2MDk2OTg4NTMyODYucG5n_10000.jpg","img_height":"240","img_width":"1206"}],[{"pk":"52f376df9490cbd43400001c","title":"太平洋家居","end_time":"1473004799","type":"block","pop_type":"","modified":"1472724994","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=52f376df9490cbd43400001c&position=recommendation_promotion","block_info":{"pk":"10601","title":"太平洋家居网","stitle":"","block_title":"太平洋家居网","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=10601","data_type":"rss","pic":"http://zkres.myzaker.com/data/image/logo/10601.png?1420613972","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/10601.png?1420613972"},"promotion_img":"http://zkres.myzaker.com/201402/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTQtMDItMDYvMTM5MTY4NzM4NDM1MjcucG5n_10000.jpg","img_height":"120","img_width":"305"},{"pk":"540071d49490cb5d6d0000ad","title":"腕表之家","end_time":"1473004799","type":"block","pop_type":"","modified":"1472725070","ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=540071d49490cb5d6d0000ad&position=recommendation_promotion","block_info":{"pk":"11329","title":"腕表之家","stitle":"","block_title":"腕表之家","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=11329","data_type":"","pic":"http://zkres.myzaker.com/data/image/logo/11329.png?1392776056","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/11329.png?1392776056"},"promotion_img":"http://zkres.myzaker.com/201408/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTQtMDgtMjkvMTQwOTMxNTI1NDQzODYuanBn_10000.jpg","img_height":"120","img_width":"305"}]]
     */

    private DataBean data;

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
        /**
         * common_api_url : http://iphone.myzaker.com/zaker/common_api.php
         * readstat : http://stat.myzaker.com/stat.php
         */

        private InfoBean info;
        /**
         * refresh_key : 1472842800
         * show_key : 1398149413
         */

        private MessageInfoBean message_info;
        /**
         * pk : 54dee8fa9490cbde430000ba
         * title : 本周新频道上线
         * end_time : 1473004799
         * type : block_topic
         * pop_type :
         * modified : 1472724930
         * ads_stat_url : http://adm.myzaker.com/ads_stat.php?ads_id=54dee8fa9490cbde430000ba&position=recommendation_promotion
         * block_topic : {"api_url":"http://iphone.myzaker.com/zaker/block_topic.php?id=54dee8fa9490cbde430000ba"}
         * promotion_img : http://zkres.myzaker.com/201604/aHR0cDovL3VwbG9hZC5teXpha2VyLmNvbS9kYXRhL2FwcF9pbmZvLzIwMTYtMDQtMTgvMTQ2MDk2OTg4NTMyODYucG5n_10000.jpg
         * img_height : 240
         * img_width : 1206
         */

        private List<List<ListBean>> list;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public MessageInfoBean getMessage_info() {
            return message_info;
        }

        public void setMessage_info(MessageInfoBean message_info) {
            this.message_info = message_info;
        }

        public List<List<ListBean>> getList() {
            return list;
        }

        public void setList(List<List<ListBean>> list) {
            this.list = list;
        }

        public static class InfoBean {
            private String common_api_url;
            private String readstat;

            public String getCommon_api_url() {
                return common_api_url;
            }

            public void setCommon_api_url(String common_api_url) {
                this.common_api_url = common_api_url;
            }

            public String getReadstat() {
                return readstat;
            }

            public void setReadstat(String readstat) {
                this.readstat = readstat;
            }
        }

        public static class MessageInfoBean {
            private String refresh_key;
            private String show_key;

            public String getRefresh_key() {
                return refresh_key;
            }

            public void setRefresh_key(String refresh_key) {
                this.refresh_key = refresh_key;
            }

            public String getShow_key() {
                return show_key;
            }

            public void setShow_key(String show_key) {
                this.show_key = show_key;
            }
        }

        public static class ListBean {
            private String pk;
            private String title;
            private String end_time;
            private String type;
            private String pop_type;
            private String modified;
            private String ads_stat_url;
            /**
             * api_url : http://iphone.myzaker.com/zaker/block_topic.php?id=54dee8fa9490cbde430000ba
             */

            private BlockTopicBean block_topic;
            private String promotion_img;
            private String img_height;
            private String img_width;

            public String getPk() {
                return pk;
            }

            public void setPk(String pk) {
                this.pk = pk;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPop_type() {
                return pop_type;
            }

            public void setPop_type(String pop_type) {
                this.pop_type = pop_type;
            }

            public String getModified() {
                return modified;
            }

            public void setModified(String modified) {
                this.modified = modified;
            }

            public String getAds_stat_url() {
                return ads_stat_url;
            }

            public void setAds_stat_url(String ads_stat_url) {
                this.ads_stat_url = ads_stat_url;
            }

            public BlockTopicBean getBlock_topic() {
                return block_topic;
            }

            public void setBlock_topic(BlockTopicBean block_topic) {
                this.block_topic = block_topic;
            }

            public String getPromotion_img() {
                return promotion_img;
            }

            public void setPromotion_img(String promotion_img) {
                this.promotion_img = promotion_img;
            }

            public String getImg_height() {
                return img_height;
            }

            public void setImg_height(String img_height) {
                this.img_height = img_height;
            }

            public String getImg_width() {
                return img_width;
            }

            public void setImg_width(String img_width) {
                this.img_width = img_width;
            }

            public static class BlockTopicBean {
                private String api_url;

                public String getApi_url() {
                    return api_url;
                }

                public void setApi_url(String api_url) {
                    this.api_url = api_url;
                }
            }
        }
    }
}
