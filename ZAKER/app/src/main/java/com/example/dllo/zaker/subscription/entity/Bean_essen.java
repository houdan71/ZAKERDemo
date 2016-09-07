package com.example.dllo.zaker.subscription.entity;

import java.util.List;

/**
 * Created by dllo on 16/9/5.
 */
public class Bean_essen {

    /**
     * share : [{"title":"转发至新浪微博","block_pk":"100000","share_url":"http://wbapi.myzaker.com/weibo/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"100003","title":"转发至腾讯微博","share_url":"http://wbapi.myzaker.com/qqweibo/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"10312","title":"转发至人人网","share_url":"http://wbapi.myzaker.com/renren/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y","no_photo":"Y"},{"block_pk":"100004","title":"转发至搜狐微博","share_url":"http://wbapi.myzaker.com/sohu/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"400005","title":"转发至QQ空间","share_url":"http://wbapi.myzaker.com/qqzone/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"400006","title":"转发至Pocket","share_url":"http://wbapi.myzaker.com/pocket/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y","no_photo":"Y"}]
     * info : {"comment_list_url":"http://c.myzaker.com/weibo/api_comment_article_url.php?act=get_comments","comment_url":"http://c.myzaker.com/weibo/api_comment_article.php?act=get_comments","comment_reply_url":"http://c.myzaker.com/weibo/api_post_article.php?act=reply","comment_count_url":"http://c.myzaker.com/weibo/api_comment_count.php?act=get_count","like_count_url":"http://iphone.myzaker.com/zaker/like.php","like_save_url":"http://iphone.myzaker.com/zaker/like.php?act=add","like_remove_url":"http://iphone.myzaker.com/zaker/like.php?act=remove","readstat":"http://stat.myzaker.com/stat.php","localremove_url":"http://api.myzaker.com/zaker/fav_act.php?act=delete2","localsave_url":"http://api.myzaker.com/zaker/fav_act.php?act=add"}
     * block_info : {"title":"精选"}
     * message_info : {"refresh_key":"1473058203","show_key":"1406275936"}
     * list : [{"type":"block","block_info":{"pk":"12445","title":"九派新闻","stitle":"以思想立言，中文数据新闻定义者","pic":"http://zkres.myzaker.com/data/image/logo/12445.png?t=1466995319","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12445.png?t=1466995319","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12445","data_type":"","block_color":"#b11e22"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=57870c4d9490cbf647000040&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12343","title":"高峰军事观察","stitle":"军事问题专家，湖北卫视特约评论员","pic":"http://zkres.myzaker.com/data/image/logo/12343.png?t=1459998902","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12343.png?t=1459998902","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12343","data_type":"","block_color":"#55b748"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=5767b2c59490cbe621000001&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12142","title":"锋芒小栈","stitle":"分享·科技·生活","pic":"http://zkres.myzaker.com/data/image/logo/12142.png?t=1444795144","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12142.png?t=1444795144","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12142","data_type":"","block_color":"#0093dd"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=5698d1189490cb7157000018&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12484","title":"凹凸用车","stitle":"养车、用车、玩车尽在凹凸用车","pic":"http://zkres.myzaker.com/data/image/logo/12484.png?t=1466995174","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12484.png?t=1466995174","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12484","data_type":"","block_color":"#ff2d6a"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=577f73099490cb6d0d000095&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12193","title":"妙计旅行","stitle":"让自由更简单","pic":"http://zkres.myzaker.com/data/image/logo/12193.png?t=1449050740","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12193.png?t=1449050740","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12193","data_type":"","block_color":"#e34c3a"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=57cd150c9490cb391400000d&position=subscription_recommendation"}]
     */

    private DataBean data;
    /**
     * data : {"share":[{"title":"转发至新浪微博","block_pk":"100000","share_url":"http://wbapi.myzaker.com/weibo/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"100003","title":"转发至腾讯微博","share_url":"http://wbapi.myzaker.com/qqweibo/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"10312","title":"转发至人人网","share_url":"http://wbapi.myzaker.com/renren/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y","no_photo":"Y"},{"block_pk":"100004","title":"转发至搜狐微博","share_url":"http://wbapi.myzaker.com/sohu/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"400005","title":"转发至QQ空间","share_url":"http://wbapi.myzaker.com/qqzone/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y"},{"block_pk":"400006","title":"转发至Pocket","share_url":"http://wbapi.myzaker.com/pocket/api_post.php?act=post_article","action_type":"sendForward","require_pk":"Y","require_title":"Y","require_web_url":"Y","no_photo":"Y"}],"info":{"comment_list_url":"http://c.myzaker.com/weibo/api_comment_article_url.php?act=get_comments","comment_url":"http://c.myzaker.com/weibo/api_comment_article.php?act=get_comments","comment_reply_url":"http://c.myzaker.com/weibo/api_post_article.php?act=reply","comment_count_url":"http://c.myzaker.com/weibo/api_comment_count.php?act=get_count","like_count_url":"http://iphone.myzaker.com/zaker/like.php","like_save_url":"http://iphone.myzaker.com/zaker/like.php?act=add","like_remove_url":"http://iphone.myzaker.com/zaker/like.php?act=remove","readstat":"http://stat.myzaker.com/stat.php","localremove_url":"http://api.myzaker.com/zaker/fav_act.php?act=delete2","localsave_url":"http://api.myzaker.com/zaker/fav_act.php?act=add"},"block_info":{"title":"精选"},"message_info":{"refresh_key":"1473058203","show_key":"1406275936"},"list":[{"type":"block","block_info":{"pk":"12445","title":"九派新闻","stitle":"以思想立言，中文数据新闻定义者","pic":"http://zkres.myzaker.com/data/image/logo/12445.png?t=1466995319","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12445.png?t=1466995319","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12445","data_type":"","block_color":"#b11e22"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=57870c4d9490cbf647000040&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12343","title":"高峰军事观察","stitle":"军事问题专家，湖北卫视特约评论员","pic":"http://zkres.myzaker.com/data/image/logo/12343.png?t=1459998902","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12343.png?t=1459998902","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12343","data_type":"","block_color":"#55b748"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=5767b2c59490cbe621000001&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12142","title":"锋芒小栈","stitle":"分享·科技·生活","pic":"http://zkres.myzaker.com/data/image/logo/12142.png?t=1444795144","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12142.png?t=1444795144","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12142","data_type":"","block_color":"#0093dd"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=5698d1189490cb7157000018&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12484","title":"凹凸用车","stitle":"养车、用车、玩车尽在凹凸用车","pic":"http://zkres.myzaker.com/data/image/logo/12484.png?t=1466995174","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12484.png?t=1466995174","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12484","data_type":"","block_color":"#ff2d6a"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=577f73099490cb6d0d000095&position=subscription_recommendation"},{"type":"block","block_info":{"pk":"12193","title":"妙计旅行","stitle":"让自由更简单","pic":"http://zkres.myzaker.com/data/image/logo/12193.png?t=1449050740","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12193.png?t=1449050740","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12193","data_type":"","block_color":"#e34c3a"},"ads_stat_url":"http://adm.myzaker.com/ads_stat.php?ads_id=57cd150c9490cb391400000d&position=subscription_recommendation"}]}
     * stat : 1
     * msg : OK
     */

    private String stat;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * comment_list_url : http://c.myzaker.com/weibo/api_comment_article_url.php?act=get_comments
         * comment_url : http://c.myzaker.com/weibo/api_comment_article.php?act=get_comments
         * comment_reply_url : http://c.myzaker.com/weibo/api_post_article.php?act=reply
         * comment_count_url : http://c.myzaker.com/weibo/api_comment_count.php?act=get_count
         * like_count_url : http://iphone.myzaker.com/zaker/like.php
         * like_save_url : http://iphone.myzaker.com/zaker/like.php?act=add
         * like_remove_url : http://iphone.myzaker.com/zaker/like.php?act=remove
         * readstat : http://stat.myzaker.com/stat.php
         * localremove_url : http://api.myzaker.com/zaker/fav_act.php?act=delete2
         * localsave_url : http://api.myzaker.com/zaker/fav_act.php?act=add
         */

        private InfoBean info;
        /**
         * title : 精选
         */

        private BlockInfoBean block_info;
        /**
         * refresh_key : 1473058203
         * show_key : 1406275936
         */

        private MessageInfoBean message_info;
        /**
         * title : 转发至新浪微博
         * block_pk : 100000
         * share_url : http://wbapi.myzaker.com/weibo/api_post.php?act=post_article
         * action_type : sendForward
         * require_pk : Y
         * require_title : Y
         * require_web_url : Y
         */

        private List<ShareBean> share;
        /**
         * type : block
         * block_info : {"pk":"12445","title":"九派新闻","stitle":"以思想立言，中文数据新闻定义者","pic":"http://zkres.myzaker.com/data/image/logo/12445.png?t=1466995319","large_pic":"http://zkres.myzaker.com/data/image/logo/ipad3/12445.png?t=1466995319","api_url":"http://iphone.myzaker.com/zaker/news.php?app_id=12445","data_type":"","block_color":"#b11e22"}
         * ads_stat_url : http://adm.myzaker.com/ads_stat.php?ads_id=57870c4d9490cbf647000040&position=subscription_recommendation
         */

        private List<ListBean> list;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public BlockInfoBean getBlock_info() {
            return block_info;
        }

        public void setBlock_info(BlockInfoBean block_info) {
            this.block_info = block_info;
        }

        public MessageInfoBean getMessage_info() {
            return message_info;
        }

        public void setMessage_info(MessageInfoBean message_info) {
            this.message_info = message_info;
        }

        public List<ShareBean> getShare() {
            return share;
        }

        public void setShare(List<ShareBean> share) {
            this.share = share;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            private String comment_list_url;
            private String comment_url;
            private String comment_reply_url;
            private String comment_count_url;
            private String like_count_url;
            private String like_save_url;
            private String like_remove_url;
            private String readstat;
            private String localremove_url;
            private String localsave_url;

            public String getComment_list_url() {
                return comment_list_url;
            }

            public void setComment_list_url(String comment_list_url) {
                this.comment_list_url = comment_list_url;
            }

            public String getComment_url() {
                return comment_url;
            }

            public void setComment_url(String comment_url) {
                this.comment_url = comment_url;
            }

            public String getComment_reply_url() {
                return comment_reply_url;
            }

            public void setComment_reply_url(String comment_reply_url) {
                this.comment_reply_url = comment_reply_url;
            }

            public String getComment_count_url() {
                return comment_count_url;
            }

            public void setComment_count_url(String comment_count_url) {
                this.comment_count_url = comment_count_url;
            }

            public String getLike_count_url() {
                return like_count_url;
            }

            public void setLike_count_url(String like_count_url) {
                this.like_count_url = like_count_url;
            }

            public String getLike_save_url() {
                return like_save_url;
            }

            public void setLike_save_url(String like_save_url) {
                this.like_save_url = like_save_url;
            }

            public String getLike_remove_url() {
                return like_remove_url;
            }

            public void setLike_remove_url(String like_remove_url) {
                this.like_remove_url = like_remove_url;
            }

            public String getReadstat() {
                return readstat;
            }

            public void setReadstat(String readstat) {
                this.readstat = readstat;
            }

            public String getLocalremove_url() {
                return localremove_url;
            }

            public void setLocalremove_url(String localremove_url) {
                this.localremove_url = localremove_url;
            }

            public String getLocalsave_url() {
                return localsave_url;
            }

            public void setLocalsave_url(String localsave_url) {
                this.localsave_url = localsave_url;
            }
        }

        public static class BlockInfoBean {
            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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

        public static class ShareBean {
            private String title;
            private String block_pk;
            private String share_url;
            private String action_type;
            private String require_pk;
            private String require_title;
            private String require_web_url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBlock_pk() {
                return block_pk;
            }

            public void setBlock_pk(String block_pk) {
                this.block_pk = block_pk;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public String getAction_type() {
                return action_type;
            }

            public void setAction_type(String action_type) {
                this.action_type = action_type;
            }

            public String getRequire_pk() {
                return require_pk;
            }

            public void setRequire_pk(String require_pk) {
                this.require_pk = require_pk;
            }

            public String getRequire_title() {
                return require_title;
            }

            public void setRequire_title(String require_title) {
                this.require_title = require_title;
            }

            public String getRequire_web_url() {
                return require_web_url;
            }

            public void setRequire_web_url(String require_web_url) {
                this.require_web_url = require_web_url;
            }
        }

        public static class ListBean {
            private String type;
            /**
             * pk : 12445
             * title : 九派新闻
             * stitle : 以思想立言，中文数据新闻定义者
             * pic : http://zkres.myzaker.com/data/image/logo/12445.png?t=1466995319
             * large_pic : http://zkres.myzaker.com/data/image/logo/ipad3/12445.png?t=1466995319
             * api_url : http://iphone.myzaker.com/zaker/news.php?app_id=12445
             * data_type :
             * block_color : #b11e22
             */

            private BlockInfoBean block_info;
            private String ads_stat_url;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public BlockInfoBean getBlock_info() {
                return block_info;
            }

            public void setBlock_info(BlockInfoBean block_info) {
                this.block_info = block_info;
            }

            public String getAds_stat_url() {
                return ads_stat_url;
            }

            public void setAds_stat_url(String ads_stat_url) {
                this.ads_stat_url = ads_stat_url;
            }

            public static class BlockInfoBean {
                private String pk;
                private String title;
                private String stitle;
                private String pic;
                private String large_pic;
                private String api_url;
                private String data_type;
                private String block_color;

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

                public String getStitle() {
                    return stitle;
                }

                public void setStitle(String stitle) {
                    this.stitle = stitle;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getLarge_pic() {
                    return large_pic;
                }

                public void setLarge_pic(String large_pic) {
                    this.large_pic = large_pic;
                }

                public String getApi_url() {
                    return api_url;
                }

                public void setApi_url(String api_url) {
                    this.api_url = api_url;
                }

                public String getData_type() {
                    return data_type;
                }

                public void setData_type(String data_type) {
                    this.data_type = data_type;
                }

                public String getBlock_color() {
                    return block_color;
                }

                public void setBlock_color(String block_color) {
                    this.block_color = block_color;
                }
            }
        }
    }
}
