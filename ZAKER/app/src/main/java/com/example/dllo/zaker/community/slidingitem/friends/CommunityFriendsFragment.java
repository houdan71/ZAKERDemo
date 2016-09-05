package com.example.dllo.zaker.community.slidingitem.friends;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.app.MyApp;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.login.LoginActivity;
import com.example.dllo.zaker.playfun.SecondLevelWebViewActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.tools.NValues;

/**
 * Created by dllo on 16/8/30.
 */
public class CommunityFriendsFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private CommunityFriendsAdapter mAdapter;
    public static final String URL_FRIEND = "WebUrl";

    private CommunityFriendsBean mBean;


    @Override
    protected int initLayout() {
        return R.layout.fragment_community_friends;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_community);

    }

    @Override
    protected void initData() {
        mAdapter = new CommunityFriendsAdapter(getContext());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));

        NetTool.getInstance().startRequest(NValues.URL_COMMUNITY_FRIENDS, CommunityFriendsBean.class, new onHttpCallBack<CommunityFriendsBean>() {
            @Override
            public void onSuccess(CommunityFriendsBean response) {
                mBean = response;
                mAdapter.setFriendsBean(response);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });

        mAdapter.setOnRecyclerItemListener(new CommunityFriendsAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int position) {
                String weburl = null;
                CommunityFriendsBean.DataBean.ListBean mL = mBean.getData().getList().get(position);
                if (position == 0) {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                } else if (position > 0) {
                    if (mL.getMedias().size() == 0 && mL.getQuote() != null) {
                        weburl = mL.getQuote().getOpen_info().getArticle().getWeburl();
                    } else {
                        weburl = mL.getOpen_info().getPost().getWeburl();
                    }
                    Intent intent = new Intent(getContext(), SecondLevelWebViewActivity.class);
                    intent.putExtra(URL_FRIEND, weburl);
                    startActivity(intent);
                }
            }
        });
    }
}
