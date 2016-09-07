package com.example.dllo.zaker.subscription.movie_fragment;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_moviefan;
import com.example.dllo.zaker.subscription.fragment_adapter.MovieFanAdapter;

/**
 * Created by dllo on 16/9/1.
 */
public class MovieFanFragment extends BaseFragment {
    private ListView list_moviefan;
    private MovieFanAdapter movieFanAdapter;
    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
        list_moviefan= (ListView) view.findViewById(R.id.list_choice);


    }

    @Override
    protected void initData() {
       String url ="http://dis.myzaker.com/api/get_post.php?_appid=AndroidPhone&_bsize=1080_1920&_city=%E5%A4%A7%E8%BF%9E&_dev=515&_lat=38.88973&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551023&_mac=08%3A00%3A27%3A4c%3A0a%3A58&_mcode=2FFC24DC&_net=wifi&_nudid=f8d5a71e2585d3a4&_os=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920&_os_name=GoogleNexus5-4.4.4-API19-1080x1920&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_udid=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920.08%3A00%3A27%3A4c%3A0a%3A58&_v=6.7&_version=6.7&discussion_id=168&sort_type=last_comment";
        NetTool.getInstance().startRequest(url, Bean_moviefan.class, new onHttpCallBack<Bean_moviefan>() {
            @Override
            public void onSuccess(Bean_moviefan response) {
            movieFanAdapter =new MovieFanAdapter(getContext());
                movieFanAdapter.setBean_moviefan(response);
                list_moviefan.setAdapter(movieFanAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
