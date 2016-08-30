package com.example.dllo.zaker.singleton;

/**
 * Created by dllo on 16/8/30.
 * 创建单利类用于网络解析
 */
public class NetTool implements  NetInterface{
    private static NetTool ourInstance = new NetTool();

    private NetInterface mNetInterface;
    private NetTool() {
        mNetInterface = new okHttpUtil();
    }



    public static NetTool getInstance() {
        if (ourInstance == null) {
            synchronized (NetTool.class) {
                if (ourInstance == null) {
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }


    @Override
    public void startRequest(String url, onHttpCallBack<String> callBack) {
        mNetInterface.startRequest(url,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, onHttpCallBack<T> callBack) {

        mNetInterface.startRequest(url, tClass, callBack);
    }
}
