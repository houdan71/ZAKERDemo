package com.example.dllo.zaker.playfun.location;


import java.util.List;

/**
 * Created by yuxiaomin~ on 16/7/26.
 */
public class PlayFunLocationChooseBean {




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
         * province_code : 19
         * city_code : dalian
         * city_name : 大连
         */

        private LbsCityBean lbs_city;
        /**
         * province_code : 32
         * city_code : aba
         * city_name : 阿坝
         * letter : A
         */

        private List<CitiesBean> cities;
        /**
         * province_code : 22
         * city_code : beijing
         * city_name : 北京
         * letter : 热
         */

        private List<HotCitiesBean> hot_cities;

        public LbsCityBean getLbs_city() {
            return lbs_city;
        }

        public void setLbs_city(LbsCityBean lbs_city) {
            this.lbs_city = lbs_city;
        }

        public List<CitiesBean> getCities() {
            return cities;
        }

        public void setCities(List<CitiesBean> cities) {
            this.cities = cities;
        }

        public List<HotCitiesBean> getHot_cities() {
            return hot_cities;
        }

        public void setHot_cities(List<HotCitiesBean> hot_cities) {
            this.hot_cities = hot_cities;
        }

        public static class LbsCityBean {
            private String province_code;
            private String city_code;
            private String city_name;

            public String getProvince_code() {
                return province_code;
            }

            public void setProvince_code(String province_code) {
                this.province_code = province_code;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }
        }

        public static class CitiesBean {
            private String province_code;
            private String city_code;
            private String city_name;
            private String letter;

            public String getProvince_code() {
                return province_code;
            }

            public void setProvince_code(String province_code) {
                this.province_code = province_code;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getLetter() {
                return letter;
            }

            public void setLetter(String letter) {
                this.letter = letter;
            }
        }

        public static class HotCitiesBean {
            private String province_code;
            private String city_code;
            private String city_name;
            private String letter;

            public String getProvince_code() {
                return province_code;
            }

            public void setProvince_code(String province_code) {
                this.province_code = province_code;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getLetter() {
                return letter;
            }

            public void setLetter(String letter) {
                this.letter = letter;
            }
        }
    }
}
