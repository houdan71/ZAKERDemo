package com.lanou3g.okhttpdemo;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lanou3g.okhttpdemo.Bean.Bean;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view);
        String url ="http://baobab.wandoujia.com/api/v2/feed?num=2&udid=cd1ee9c5b44e4f9487a505a4fe31ddcb07441cc8&vc=121&vn=2.3.5&deviceModel=MI%205&first_channel=eyepetizer_xiaomi_market&last_channel=eyepetizer_xiaomi_market&system_version_code=23";
//        //创建对象
//        OkHttpClient okHttpClient =new OkHttpClient();
//        //2.请求
//        Request request =new Request.Builder().url(url).build();
//
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//             String result =response.body().string();//转化成String类型
//                Gson gson =new Gson();
//                Bean bean =gson.fromJson(result,Bean.class);
//            final    String  str =     bean.getIssueList().get(0).getItemList()
//                        .get(0).getData().getDescription();
//                //报错 ,发回主线程
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(str);
//                    }
//                });
//
////                for (Bean.IssueListBean issueListBean:bean.getIssueList() ){
////                    Log.d("MainActivity", "issueListBean"+issueListBean);
////
////                }
//
//
//
//            }
//        });


       NetTool.getInstance().startRequest(url, Bean.class, new onHttpCallBack<Bean>() {
           @Override
           public void onSuccess(Bean response) {
               String str =response.getIssueList().get(0).getItemList()
                        .get(1).getData().getDescription();
               Log.d("MainActivity", str);
               textView.setText(str);
           }

           @Override
           public void onError(Throwable e) {

           }
       });


    }
}
