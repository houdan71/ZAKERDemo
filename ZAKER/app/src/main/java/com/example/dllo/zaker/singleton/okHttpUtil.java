package com.example.dllo.zaker.singleton;

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
public class okHttpUtil implements NetInterface{
    private OkHttpClient mClient;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Gson mGson;

    public okHttpUtil() {
        File path = Environment.getExternalStorageDirectory();
        mClient = new OkHttpClient.Builder()
                .cache(new Cache(path,10 * 1024 * 1024))
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();


        mGson = new Gson();
    }

    @Override
    public void startRequest(String url, final onHttpCallBack<String> callBack) {

        Request request = new Request.Builder().url(url).build();
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
            public void onResponse(final Call call, Response response) throws IOException {

                final String result = response.body().string();
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

        Request request = new Request.Builder().url(url).build();
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

                String str = response.body().string();
                final T result = mGson.fromJson(str,tClass);
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
