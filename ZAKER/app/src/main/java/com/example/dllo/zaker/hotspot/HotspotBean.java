package com.example.dllo.zaker.hotspot;

import java.util.List;

/**
 * Created by dllo on 16/8/30.
 */
public class HotspotBean {

    private String stat;
    private String msg;


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
         * title : 今日看点
         * block_title : 今日看点
         * stitle :
         * skey :
         * pic : http://upload.myzaker.com/data/image/logo/1057.png?1418985329
         * root_type : normal
         * top_position_index : -1
         */

        private BlockInfoBean block_info;


        private InfoBean info;
        private String refresh_interval;

        private List<ShareBean> share;
        private String tip_msg;

        public String getTip_msg() {
            return tip_msg;
        }

        public void setTip_msg(String tip_msg) {
            this.tip_msg = tip_msg;
        }

        private List<ArticlesBean> articles;

        public BlockInfoBean getBlock_info() {
            return block_info;
        }

        public void setBlock_info(BlockInfoBean block_info) {
            this.block_info = block_info;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getRefresh_interval() {
            return refresh_interval;
        }

        public void setRefresh_interval(String refresh_interval) {
            this.refresh_interval = refresh_interval;
        }

        public List<ShareBean> getShare() {
            return share;
        }

        public void setShare(List<ShareBean> share) {
            this.share = share;
        }

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public static class BlockInfoBean {
            private String title;
            private String block_title;
            private String stitle;
            private String skey;
            private String pic;
            private String root_type;
            private String top_position_index;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBlock_title() {
                return block_title;
            }

            public void setBlock_title(String block_title) {
                this.block_title = block_title;
            }

            public String getStitle() {
                return stitle;
            }

            public void setStitle(String stitle) {
                this.stitle = stitle;
            }

            public String getSkey() {
                return skey;
            }

            public void setSkey(String skey) {
                this.skey = skey;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getRoot_type() {
                return root_type;
            }

            public void setRoot_type(String root_type) {
                this.root_type = root_type;
            }

            public String getTop_position_index() {
                return top_position_index;
            }

            public void setTop_position_index(String top_position_index) {
                this.top_position_index = top_position_index;
            }
        }

        public static class InfoBean {
            private String next_url;
            private String pre_url;
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
            private String ad_url;
            private String refresh_ad_url;
            private String tuijian_list_url;
            private String force_refresh;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }

            public String getPre_url() {
                return pre_url;
            }

            public void setPre_url(String pre_url) {
                this.pre_url = pre_url;
            }

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

            public String getAd_url() {
                return ad_url;
            }

            public void setAd_url(String ad_url) {
                this.ad_url = ad_url;
            }

            public String getRefresh_ad_url() {
                return refresh_ad_url;
            }

            public void setRefresh_ad_url(String refresh_ad_url) {
                this.refresh_ad_url = refresh_ad_url;
            }

            public String getTuijian_list_url() {
                return tuijian_list_url;
            }

            public void setTuijian_list_url(String tuijian_list_url) {
                this.tuijian_list_url = tuijian_list_url;
            }

            public String getForce_refresh() {
                return force_refresh;
            }

            public void setForce_refresh(String force_refresh) {
                this.force_refresh = force_refresh;
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

        public static class ArticlesBean {
            private String pk;
            private String app_ids;
            private String title;
            private String date;
            private String list_dtime;
            private String auther_name;
            private String weburl;
            private String is_full;
            private String content;
            private String full_url;
            private String is_ad;

            public String getIs_ad() {
                return is_ad;
            }

            public void setIs_ad(String is_ad) {
                this.is_ad = is_ad;
            }

            /**
             * show_jingcai : Y
             * item_type : 1_b
             */

            private SpecialInfoBean special_info;
            private String url;
            /**
             * type : image
             * id : 57c63e6da07aecf77e03bb9f
             * url : http://zkres.myzaker.com/201608/57c63e6da07aecf77e03bb9f_640.jpg
             * m_url : http://zkres.myzaker.com/201608/57c63e6da07aecf77e03bb9f_320.jpg
             * min_url : http://zkres.myzaker.com/201608/57c63e6da07aecf77e03bb9f_120.jpg
             * raw_url : http://img.3gcdn.cn/sports/2016/8/31/915377685_500_333_480.jpg
             * w : 480
             * h : 319
             */

            private List<ThumbnailMediasBean> thumbnail_medias;

            public String getPk() {
                return pk;
            }

            public void setPk(String pk) {
                this.pk = pk;
            }

            public String getApp_ids() {
                return app_ids;
            }

            public void setApp_ids(String app_ids) {
                this.app_ids = app_ids;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getList_dtime() {
                return list_dtime;
            }

            public void setList_dtime(String list_dtime) {
                this.list_dtime = list_dtime;
            }

            public String getAuther_name() {
                return auther_name;
            }

            public void setAuther_name(String auther_name) {
                this.auther_name = auther_name;
            }

            public String getWeburl() {
                return weburl;
            }

            public void setWeburl(String weburl) {
                this.weburl = weburl;
            }

            public String getIs_full() {
                return is_full;
            }

            public void setIs_full(String is_full) {
                this.is_full = is_full;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getFull_url() {
                return full_url;
            }

            public void setFull_url(String full_url) {
                this.full_url = full_url;
            }

            public SpecialInfoBean getSpecial_info() {
                return special_info;
            }

            public void setSpecial_info(SpecialInfoBean special_info) {
                this.special_info = special_info;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<ThumbnailMediasBean> getThumbnail_medias() {
                return thumbnail_medias;
            }

            public void setThumbnail_medias(List<ThumbnailMediasBean> thumbnail_medias) {
                this.thumbnail_medias = thumbnail_medias;
            }

            public static class SpecialInfoBean {
                private String show_jingcai;
                private String item_type;
                private String icon_url;

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public String getShow_jingcai() {
                    return show_jingcai;
                }

                public void setShow_jingcai(String show_jingcai) {
                    this.show_jingcai = show_jingcai;
                }

                public String getItem_type() {
                    return item_type;
                }

                public void setItem_type(String item_type) {
                    this.item_type = item_type;
                }
            }

            public static class ThumbnailMediasBean {
                private String type;
                private String id;
                private String url;
                private String m_url;
                private String min_url;
                private String raw_url;
                private String w;
                private String h;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getM_url() {
                    return m_url;
                }

                public void setM_url(String m_url) {
                    this.m_url = m_url;
                }

                public String getMin_url() {
                    return min_url;
                }

                public void setMin_url(String min_url) {
                    this.min_url = min_url;
                }

                public String getRaw_url() {
                    return raw_url;
                }

                public void setRaw_url(String raw_url) {
                    this.raw_url = raw_url;
                }

                public String getW() {
                    return w;
                }

                public void setW(String w) {
                    this.w = w;
                }

                public String getH() {
                    return h;
                }

                public void setH(String h) {
                    this.h = h;
                }
            }
        }
    }



            public static class SpecialInfoBean {
                private String show_jingcai;
                private String icon_url;
                private String item_type;
                private String web_url;
                private String open_type;
                private String stat_click_url;
                private String tag_position;
                private String stat_read_url;

                public String getShow_jingcai() {
                    return show_jingcai;
                }

                public void setShow_jingcai(String show_jingcai) {
                    this.show_jingcai = show_jingcai;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public String getItem_type() {
                    return item_type;
                }

                public void setItem_type(String item_type) {
                    this.item_type = item_type;
                }

                public String getWeb_url() {
                    return web_url;
                }

                public void setWeb_url(String web_url) {
                    this.web_url = web_url;
                }

                public String getOpen_type() {
                    return open_type;
                }

                public void setOpen_type(String open_type) {
                    this.open_type = open_type;
                }

                public String getStat_click_url() {
                    return stat_click_url;
                }

                public void setStat_click_url(String stat_click_url) {
                    this.stat_click_url = stat_click_url;
                }

                public String getTag_position() {
                    return tag_position;
                }

                public void setTag_position(String tag_position) {
                    this.tag_position = tag_position;
                }

                public String getStat_read_url() {
                    return stat_read_url;
                }

                public void setStat_read_url(String stat_read_url) {
                    this.stat_read_url = stat_read_url;
                }
            }




}
