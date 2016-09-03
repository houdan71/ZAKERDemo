package com.example.dllo.zaker.community;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseFragment;
import com.example.dllo.zaker.community.slidingitem.friends.CommunityFriendsFragment;
import com.example.dllo.zaker.community.slidingitem.select.CommunitySelectionFragment;
import com.example.dllo.zaker.community.slidingitem.topic.CommunityTopicFragment;
import com.example.dllo.zaker.tools.SlidingMenu;

/**
 * Created by dllo on 16/9/3.
 */
public class CommunityFragment extends BaseFragment implements OnClickListener {
    private SlidingMenu mMenu;
    private Button menuBtn;
    private RelativeLayout topicRL,selectRL,friendsRL;

    @Override
    protected int initLayout() {
        return R.layout.fragment_commuity_menu;
    }

    @Override
    protected void initView(View view) {
        mMenu = (SlidingMenu) view.findViewById(R.id.id_menu);
        menuBtn = (Button) view.findViewById(R.id.btn_menu);
        topicRL = (RelativeLayout) view.findViewById(R.id.fragment_community_topic_relativeLayout);
        selectRL = (RelativeLayout) view.findViewById(R.id.fragment_community_select_relativeLayout);
        friendsRL = (RelativeLayout) view.findViewById(R.id.fragment_community_friends_relativeLayout);
        topicRL.setOnClickListener(this);
        selectRL.setOnClickListener(this);
        friendsRL.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        replaceFragment(R.id.fragment_community_replace_fragment,new CommunityTopicFragment());
        menuBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_menu:
                mMenu.toggle();
                break;
            case R.id.fragment_community_topic_relativeLayout:
                mMenu.toggle();
                menuBtn.setText("话题");
               replaceFragment(R.id.fragment_community_replace_fragment,new CommunityTopicFragment());
                break;
            case R.id.fragment_community_select_relativeLayout:
                mMenu.toggle();
                menuBtn.setText("精选");
                replaceFragment(R.id.fragment_community_replace_fragment,new CommunitySelectionFragment());
                break;
            case R.id.fragment_community_friends_relativeLayout:
                mMenu.toggle();
                menuBtn.setText("好友圈");
                replaceFragment(R.id.fragment_community_replace_fragment,new CommunityFriendsFragment());
                break;
        }

    }


    public void replaceFragment(int id, Fragment fragment){
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id,fragment);
        transaction.commit();
    }
}
