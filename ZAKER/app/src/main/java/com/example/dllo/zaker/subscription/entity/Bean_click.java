package com.example.dllo.zaker.subscription.entity;

import java.util.List;

/**
 * Created by dllo on 16/9/9.
 */
public class Bean_click {


   /**
     * stat : 1
     * msg : ok
     * data : {"wordlist":[{"pk":"hotwords","words":[{"text":"海昏侯墓失传论语"},{"text":"军训设女子匕首连"},{"text":"闫妮女儿考入中戏"},{"text":"宋茜开撕杨洋"},{"text":"撒贝宁接诈骗电话"},{"text":"曝张一山亲男友人"},{"text":"福原爱结婚"},{"text":"邓超吐槽孙俪料理"},{"text":"女子举报男友酒驾"},{"text":"王健林目标被抢注"},{"text":"帮店刷单被骗2万"},{"text":"胡定欣透视衣造型"}]}]}
     */

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
         * pk : hotwords
         * words : [{"text":"海昏侯墓失传论语"},{"text":"军训设女子匕首连"},{"text":"闫妮女儿考入中戏"},{"text":"宋茜开撕杨洋"},{"text":"撒贝宁接诈骗电话"},{"text":"曝张一山亲男友人"},{"text":"福原爱结婚"},{"text":"邓超吐槽孙俪料理"},{"text":"女子举报男友酒驾"},{"text":"王健林目标被抢注"},{"text":"帮店刷单被骗2万"},{"text":"胡定欣透视衣造型"}]
         */

        private List<WordlistBean> wordlist;

        public List<WordlistBean> getWordlist() {
            return wordlist;
        }

        public void setWordlist(List<WordlistBean> wordlist) {
            this.wordlist = wordlist;
        }

        public static class WordlistBean {
            private String pk;
            /**
             * text : 海昏侯墓失传论语
             */

            private List<WordsBean> words;

            public String getPk() {
                return pk;
            }

            public void setPk(String pk) {
                this.pk = pk;
            }

            public List<WordsBean> getWords() {
                return words;
            }

            public void setWords(List<WordsBean> words) {
                this.words = words;
            }

            public static class WordsBean {
                private String text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }
}
