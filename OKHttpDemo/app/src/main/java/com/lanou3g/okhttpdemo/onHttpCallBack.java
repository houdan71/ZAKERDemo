package com.lanou3g.okhttpdemo;

/**
 * Created by dllo on 16/8/30.
 */
public interface onHttpCallBack<T> {
    void  onSuccess(T response);
    void  onError(Throwable e);
}
