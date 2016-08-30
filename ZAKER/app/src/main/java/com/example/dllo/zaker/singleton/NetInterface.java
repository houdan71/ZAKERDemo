package com.example.dllo.zaker.singleton;

/**
 * Created by dllo on 16/8/30.
 */
public interface NetInterface {
    void startRequest(String url,onHttpCallBack<String> callBack);
    <T> void  startRequest(String url,Class<T> tClass,onHttpCallBack<T> callBack);
}
