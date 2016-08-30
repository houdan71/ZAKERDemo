package com.lanou3g.okhttpdemo;

/**
 * Created by dllo on 16/8/30.
 *
 * 2个基本
 *gson可能解析不了
 * String类型
 */
public interface NetInterface {
    void startRequest(String url
            ,onHttpCallBack<String> callBack);
    //带泛型的方法
    <T> void startRequest(String url,
                          Class<T> tClass
    ,onHttpCallBack<T> callBack);

}
