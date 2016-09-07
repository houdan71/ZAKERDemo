package com.example.dllo.zaker.subscription.entity;

import java.util.List;

/**
 * Created by dllo on 16/9/5.
 */
public class Bean_shares {




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
        private String refresh_interval;


        private InfoBean info;
        private String catalog;
        private IpadconfigBean ipadconfig;

        private BlockInfoBean block_info;


        private ColumnInfoBean column_info;


        private List<ShareBean> share;


        private List<ArticlesBean> articles;

        public String getRefresh_interval() {
            return refresh_interval;
        }

        public void setRefresh_interval(String refresh_interval) {
            this.refresh_interval = refresh_interval;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public IpadconfigBean getIpadconfig() {
            return ipadconfig;
        }

        public void setIpadconfig(IpadconfigBean ipadconfig) {
            this.ipadconfig = ipadconfig;
        }

        public BlockInfoBean getBlock_info() {
            return block_info;
        }

        public void setBlock_info(BlockInfoBean block_info) {
            this.block_info = block_info;
        }

        public ColumnInfoBean getColumn_info() {
            return column_info;
        }

        public void setColumn_info(ColumnInfoBean column_info) {
            this.column_info = column_info;
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

        public static class InfoBean {
            private String comment_list_url;
            private String comment_url;
            private String comment_reply_url;
            private String comment_count_url;
            private String comment_hot_url;
            private String like_count_url;
            private String like_save_url;
            private String like_remove_url;
            private String readstat;
            private String next_url;
            private String localremove_url;
            private String localsave_url;
            private String ad_url;
            private String tuijian_list_url;

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

            public String getComment_hot_url() {
                return comment_hot_url;
            }

            public void setComment_hot_url(String comment_hot_url) {
                this.comment_hot_url = comment_hot_url;
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

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
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

            public String getTuijian_list_url() {
                return tuijian_list_url;
            }

            public void setTuijian_list_url(String tuijian_list_url) {
                this.tuijian_list_url = tuijian_list_url;
            }
        }

        public static class IpadconfigBean {
            /**
             * pk : 1
             * page : 1
             * tpl_group : 6
             * tpl_type : news
             * tpl_styletype : photo
             * tpl_style : 3
             * articles : 57ccf3a39490cb580e000003,57ccfaa99490cb572f000002,57cd04189490cb155f00002d,57ccf3a39490cb580e000004,57ccf01d9490cb127b000007,57ccf01d9490cb127b000005
             * diy : {"bgimage_url":"http://zkres3.myzaker.com/data/image/template/iphone/4.png?t=1458286563","bgimage_frame":"0,0,320,60","title_h":"60","hide_title":"YES","open_type":""}
             */

            private List<PagesBean> pages;
            private List<String> article_block_colors;
            private List<String> only_text_page_bgcolors;

            public List<PagesBean> getPages() {
                return pages;
            }

            public void setPages(List<PagesBean> pages) {
                this.pages = pages;
            }

            public List<String> getArticle_block_colors() {
                return article_block_colors;
            }

            public void setArticle_block_colors(List<String> article_block_colors) {
                this.article_block_colors = article_block_colors;
            }

            public List<String> getOnly_text_page_bgcolors() {
                return only_text_page_bgcolors;
            }

            public void setOnly_text_page_bgcolors(List<String> only_text_page_bgcolors) {
                this.only_text_page_bgcolors = only_text_page_bgcolors;
            }

            public static class PagesBean {
                private String pk;
                private String page;
                private String tpl_group;
                private String tpl_type;
                private String tpl_styletype;
                private String tpl_style;
                private String articles;
                /**
                 * bgimage_url : http://zkres3.myzaker.com/data/image/template/iphone/4.png?t=1458286563
                 * bgimage_frame : 0,0,320,60
                 * title_h : 60
                 * hide_title : YES
                 * open_type :
                 */

                private DiyBean diy;

                public String getPk() {
                    return pk;
                }

                public void setPk(String pk) {
                    this.pk = pk;
                }

                public String getPage() {
                    return page;
                }

                public void setPage(String page) {
                    this.page = page;
                }

                public String getTpl_group() {
                    return tpl_group;
                }

                public void setTpl_group(String tpl_group) {
                    this.tpl_group = tpl_group;
                }

                public String getTpl_type() {
                    return tpl_type;
                }

                public void setTpl_type(String tpl_type) {
                    this.tpl_type = tpl_type;
                }

                public String getTpl_styletype() {
                    return tpl_styletype;
                }

                public void setTpl_styletype(String tpl_styletype) {
                    this.tpl_styletype = tpl_styletype;
                }

                public String getTpl_style() {
                    return tpl_style;
                }

                public void setTpl_style(String tpl_style) {
                    this.tpl_style = tpl_style;
                }

                public String getArticles() {
                    return articles;
                }

                public void setArticles(String articles) {
                    this.articles = articles;
                }

                public DiyBean getDiy() {
                    return diy;
                }

                public void setDiy(DiyBean diy) {
                    this.diy = diy;
                }

                public static class DiyBean {
                    private String bgimage_url;
                    private String bgimage_frame;
                    private String title_h;
                    private String hide_title;
                    private String open_type;

                    public String getBgimage_url() {
                        return bgimage_url;
                    }

                    public void setBgimage_url(String bgimage_url) {
                        this.bgimage_url = bgimage_url;
                    }

                    public String getBgimage_frame() {
                        return bgimage_frame;
                    }

                    public void setBgimage_frame(String bgimage_frame) {
                        this.bgimage_frame = bgimage_frame;
                    }

                    public String getTitle_h() {
                        return title_h;
                    }

                    public void setTitle_h(String title_h) {
                        this.title_h = title_h;
                    }

                    public String getHide_title() {
                        return hide_title;
                    }

                    public void setHide_title(String hide_title) {
                        this.hide_title = hide_title;
                    }

                    public String getOpen_type() {
                        return open_type;
                    }

                    public void setOpen_type(String open_type) {
                        this.open_type = open_type;
                    }
                }
            }
        }

        public static class BlockInfoBean {
            private String title;
            private String stitle;
            private String skey;
            private String pic;
            private String large_pic;
            private String hidden_time;
            private String need_userinfo;
            private String block_title;
            private String block_color;
            private String desktop_color_number;
            private String use_original_icon;

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

            public String getLarge_pic() {
                return large_pic;
            }

            public void setLarge_pic(String large_pic) {
                this.large_pic = large_pic;
            }

            public String getHidden_time() {
                return hidden_time;
            }

            public void setHidden_time(String hidden_time) {
                this.hidden_time = hidden_time;
            }

            public String getNeed_userinfo() {
                return need_userinfo;
            }

            public void setNeed_userinfo(String need_userinfo) {
                this.need_userinfo = need_userinfo;
            }

            public String getBlock_title() {
                return block_title;
            }

            public void setBlock_title(String block_title) {
                this.block_title = block_title;
            }

            public String getBlock_color() {
                return block_color;
            }

            public void setBlock_color(String block_color) {
                this.block_color = block_color;
            }

            public String getDesktop_color_number() {
                return desktop_color_number;
            }

            public void setDesktop_color_number(String desktop_color_number) {
                this.desktop_color_number = desktop_color_number;
            }

            public String getUse_original_icon() {
                return use_original_icon;
            }

            public void setUse_original_icon(String use_original_icon) {
                this.use_original_icon = use_original_icon;
            }
        }

        public static class ColumnInfoBean {
            private String pk;
            private String selected_index;
            /**
             * pk : zk_app_column_4
             * title : 要闻
             * type : in_block
             * block_info : {"can_addtodesk":"Y","need_userinfo":"NO","pk":"4","title":"财经新闻","api_url":"http://iphone.myzaker.com/zaker/blog.php?app_id=4&catalog_appid=4","data_type":"news"}
             */

            private List<ListBean> list;

            public String getPk() {
                return pk;
            }

            public void setPk(String pk) {
                this.pk = pk;
            }

            public String getSelected_index() {
                return selected_index;
            }

            public void setSelected_index(String selected_index) {
                this.selected_index = selected_index;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String pk;
                private String title;
                private String type;
                /**
                 * can_addtodesk : Y
                 * need_userinfo : NO
                 * pk : 4
                 * title : 财经新闻
                 * api_url : http://iphone.myzaker.com/zaker/blog.php?app_id=4&catalog_appid=4
                 * data_type : news
                 */

                private BlockInfoBean block_info;

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

                public static class BlockInfoBean {
                    private String can_addtodesk;
                    private String need_userinfo;
                    private String pk;
                    private String title;
                    private String api_url;
                    private String data_type;

                    public String getCan_addtodesk() {
                        return can_addtodesk;
                    }

                    public void setCan_addtodesk(String can_addtodesk) {
                        this.can_addtodesk = can_addtodesk;
                    }

                    public String getNeed_userinfo() {
                        return need_userinfo;
                    }

                    public void setNeed_userinfo(String need_userinfo) {
                        this.need_userinfo = need_userinfo;
                    }

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
                }
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
            private String title;
            private String title_line_break;
            private String date;
            private String auther_name;
            private String weburl;
            private String media_count;
            private String is_full;
            private String content,thumbnail_mpic;

            public String getThumbnail_mpic() {
                return thumbnail_mpic;
            }

            public void setThumbnail_mpic(String thumbnail_mpic) {
                this.thumbnail_mpic = thumbnail_mpic;
            }

            /**
             * show_jingcai : Y
             */

            private SpecialInfoBean special_info;
            private String full_url;
            private String list_dtime;

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

            public String getTitle_line_break() {
                return title_line_break;
            }

            public void setTitle_line_break(String title_line_break) {
                this.title_line_break = title_line_break;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
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

            public String getMedia_count() {
                return media_count;
            }

            public void setMedia_count(String media_count) {
                this.media_count = media_count;
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

            public SpecialInfoBean getSpecial_info() {
                return special_info;
            }

            public void setSpecial_info(SpecialInfoBean special_info) {
                this.special_info = special_info;
            }

            public String getFull_url() {
                return full_url;
            }

            public void setFull_url(String full_url) {
                this.full_url = full_url;
            }

            public String getList_dtime() {
                return list_dtime;
            }

            public void setList_dtime(String list_dtime) {
                this.list_dtime = list_dtime;
            }

            public static class SpecialInfoBean {
                private String show_jingcai;

                public String getShow_jingcai() {
                    return show_jingcai;
                }

                public void setShow_jingcai(String show_jingcai) {
                    this.show_jingcai = show_jingcai;
                }
            }
        }
    }
}
