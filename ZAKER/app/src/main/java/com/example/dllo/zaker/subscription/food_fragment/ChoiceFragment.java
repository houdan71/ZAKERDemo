package com.example.dllo.zaker.subscription.food_fragment;

import android.view.View;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.main.MetaballView;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_choice;
import com.example.dllo.zaker.subscription.fragment_adapter.ChoiceAdapter;

/**
 * Created by dllo on 16/9/1.
 */
public class ChoiceFragment extends BaseFragment {
    private ListView listView;
    private ChoiceAdapter choiceAdapter;
    private MetaballView mMetaballView;

    @Override
    protected int initLayout() {
        return R.layout.fragment_choice;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) getView().findViewById(R.id.list_choice);
        mMetaballView = (MetaballView) view.findViewById(R.id.fragment_choice_metaballView);
        mMetaballView.setPaintMode(1);

    }

    @Override
    protected void initData() {
        choiceAdapter =new ChoiceAdapter(getContext());
        String url ="http://iphone.myzaker.com/zaker/blog.php?_appid=AndroidPhone&_bsize=1080_1920&_version=6.7&app_id=10386&top_tab_id=10386";
        NetTool.getInstance().startRequest(url, Bean_choice.class, new onHttpCallBack<Bean_choice>() {
            @Override
            public void onSuccess(Bean_choice response) {
                 mMetaballView.setVisibility(View.GONE);

                choiceAdapter.setBean_choice(response);
                listView.setAdapter(choiceAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
