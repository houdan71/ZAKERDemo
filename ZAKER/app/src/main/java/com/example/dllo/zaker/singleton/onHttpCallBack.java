package com.example.dllo.zaker.singleton;

/**
 * Created by dllo on 16/8/30.
 * 网络解析成功和失败的回调
 */
public interface onHttpCallBack <T>{
    void onSuccess(T response);
    void onError(Throwable e);
}
