package com.example.dllo.zaker.subscription.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.main.MetaballView;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_essence;
import com.example.dllo.zaker.subscription.fragment_adapter.EssenceAdapter;

/**
 * Created by dllo on 16/9/1.
 */
public class EssenceFragment extends BaseFragment {
    private ImageView image_add,image_left,image_right;
    private TextView text_add;
    private ListView list_add;
    private EssenceAdapter essenceAdapter;
    private MetaballView mMetaballView;

    @Override
    protected int initLayout() {
        return R.layout.fragment_essence;
    }

    @Override
    protected void initView(View view) {
        image_add = (ImageView) view.findViewById(R.id.image_add);
        image_left= (ImageView) view.findViewById(R.id.image_left);
        image_right= (ImageView) view.findViewById(R.id.image_right);
        text_add = (TextView) view.findViewById(R.id.text_add);
        list_add= (ListView) view.findViewById(R.id.list_add);
        mMetaballView = (MetaballView) view.findViewById(R.id.fragment_essence_metaballView);
        mMetaballView.setPaintMode(1);

    }

    @Override
    protected void initData() {
        //本周新上线
        String url="http://iphone.myzaker.com/zaker/block_topic.php?_appid=AndroidPhone&_bsize=1080_1920&_city=%E5%A4%A7%E8%BF%9E&_dev=515&_lat=38.88973&_lbs_city=%E5%A4%A7%E8%BF%9E&_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551023&_mac=08%3A00%3A27%3A4c%3A0a%3A58&_mcode=2FFC24DC&_net=wifi&_nudid=f8d5a71e2585d3a4&_os=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920&_os_name=GoogleNexus5-4.4.4-API19-1080x1920&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_udid=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920.08%3A00%3A27%3A4c%3A0a%3A58&_v=6.7&_version=6.7&id=54dee8fa9490cbde430000ba";
        NetTool.getInstance().startRequest(url, Bean_essence.class, new onHttpCallBack<Bean_essence>() {
            @Override
            public void onSuccess(Bean_essence response) {
                mMetaballView.setVisibility(View.GONE);
                essenceAdapter =new EssenceAdapter(getContext());
                Glide.with(getActivity()).load(response.getData().getHead().getImg()).into(image_add);


            }

            @Override
            public void onError(Throwable e) {

            }
        });

     //image_left


    }
}
