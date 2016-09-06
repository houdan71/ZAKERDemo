package com.example.dllo.zaker.subscription.add_fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_add_image;
import com.example.dllo.zaker.subscription.entity.Bean_essen;
import com.example.dllo.zaker.subscription.entity.Bean_essence;
import com.example.dllo.zaker.subscription.fragment_adapter.EssenceAdapter;

/**
 * Created by dllo on 16/9/1.
 */
public class EssenceFragment extends BaseFragment {
    private ImageView image_add, image_left, image_right;
    private TextView text_add;
    private ListView list_add;
    private EssenceAdapter essenceAdapter;


    @Override
    protected int initLayout() {
        return R.layout.fragment_essence;
    }

    @Override
    protected void initView(View view) {
        image_add = (ImageView) view.findViewById(R.id.image_add);
        image_left = (ImageView) view.findViewById(R.id.image_left);
        image_right = (ImageView) view.findViewById(R.id.image_right);
        text_add = (TextView) view.findViewById(R.id.text_add);
        list_add = (ListView) view.findViewById(R.id.list_add);
    }

    @Override
    protected void initData() {
        //本周新上线
        String url = "http://iphone.myzaker.com/zaker/find_promotion.php?_appid=AndroidPhone&m=1472842800";
        NetTool.getInstance().startRequest(url, Bean_add_image.class, new onHttpCallBack<Bean_add_image>() {
            @Override
            public void onSuccess(Bean_add_image response) {

                Glide.with(getContext()).load(response.getData()
                        .getList().get(0).get(0).getPromotion_img()).into(image_add);
                Glide.with(getContext()).load(response.getData().getList()
                        .get(1).get(0).getPromotion_img()).into(image_left);
                Glide.with(getContext()).load(response.getData().getList()
                        .get(1).get(1).getPromotion_img()).into(image_right);


            }

            @Override
            public void onError(Throwable e) {

            }
        });
        String url1="http://iphone.myzaker.com/zaker/find.php?_appid=AndroidPhone&_version=6.7&m=1472842800";
        NetTool.getInstance().startRequest(url1, Bean_essen.class, new onHttpCallBack<Bean_essen>() {
            @Override
            public void onSuccess(Bean_essen response) {
             essenceAdapter =new EssenceAdapter(getActivity());
                essenceAdapter.setBean_essen(response);
                list_add.setAdapter(essenceAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
