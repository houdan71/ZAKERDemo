package com.lanou3g.okhttpdemo;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/8/30.
 */
public class OKHttpUtil implements NetInterface {
    //对其初始化
    private OkHttpClient mClient;
    //这样定义的Handler对象无论在哪里创建的,都是属于主线程的
    private Handler mHandler =new Handler(Looper.getMainLooper());
    private Gson mGson;
  //构造方法
    public OKHttpUtil() {
        super();
        mGson =new Gson();
        //获取系统SD卡
        File path = Environment
                .getExternalStorageDirectory();
        //初始化okhttp
        mClient =new OkHttpClient.Builder()
                //设置缓存位置以及缓存大小
                .cache(new Cache(path,10*1024*1024))
                //超时时间为5秒
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public void startRequest(String url, final onHttpCallBack<String> callBack) {
        Request request =new Request.Builder()
                .url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                   callBack.onError(e);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result =response.body().string();
            //post方法直接将任务传到主线程
             mHandler.post(new Runnable() {
                 @Override
                 public void run() {
                     callBack.onSuccess(result);
                 }
             });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final onHttpCallBack<T> callBack) {

        Request request =new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str =response.body().string();
                //解析
                final T result =mGson.fromJson(str,tClass);
                //把结果发回主线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });

            }
        });



    }
}
