package com.example.dllo.zaker.subscription.food_fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.hotspot.HotspotFragment;
import com.example.dllo.zaker.hotspot.sec.HotspotSecActivity;
import com.example.dllo.zaker.hotspot.sec.HotspotSecBean;
import com.example.dllo.zaker.main.MetaballView;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_choice;
import com.example.dllo.zaker.subscription.fragment_adapter.ChoiceAdapter;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/1.
 */
public class ChoiceFragment extends BaseFragment {
    private ListView listView;
    private ChoiceAdapter choiceAdapter;
    private MetaballView mMetaballView;
    ArrayList<HotspotSecBean> b;
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

        NetTool.getInstance().startRequest(NValues.URL_CHOICE, Bean_choice.class, new onHttpCallBack<Bean_choice>() {
            @Override
            public void onSuccess(Bean_choice response) {
                 mMetaballView.setVisibility(View.GONE);
                b = new ArrayList<>();
                for (int i = 0; i <response.getData().getArticles().size(); i++) {

                    HotspotSecBean bean = new HotspotSecBean();
                    bean.setWebUrl(response.getData().getArticles().get(i).getWeburl());
                    b.add(bean);

                }
                listView.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                Intent intent = new Intent(getActivity(), HotspotSecActivity.class);
                                intent.putParcelableArrayListExtra(HotspotFragment.KEY_webUrl, b);
                                intent.putExtra(HotspotFragment.KEY_postionItem,position);
                                startActivity(intent);

                        }


                });
                choiceAdapter.setBean_choice(response);
                listView.setAdapter(choiceAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
