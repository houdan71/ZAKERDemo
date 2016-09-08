package com.example.dllo.zaker.community;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    private TextView menuTV;
    private RelativeLayout topicRL, selectRL, friendsRL;
    private ImageView topicIV, selectIV, friendsIV;

    @Override
    protected int initLayout() {
        return R.layout.fragment_commuity_menu;
    }

    @Override
    protected void initView(View view) {
        mMenu = (SlidingMenu) view.findViewById(R.id.id_menu);
        menuTV = (TextView) view.findViewById(R.id.textView_menu);
        topicRL = (RelativeLayout) view.findViewById(R.id.fragment_community_topic_relativeLayout);
        selectRL = (RelativeLayout) view.findViewById(R.id.fragment_community_select_relativeLayout);
        friendsRL = (RelativeLayout) view.findViewById(R.id.fragment_community_friends_relativeLayout);
        topicIV = (ImageView) view.findViewById(R.id.fragment_community_topic_img);
        selectIV = (ImageView) view.findViewById(R.id.fragment_community_select_img);
        friendsIV = (ImageView) view.findViewById(R.id.fragment_community_friends_img);
        topicRL.setOnClickListener(this);
        selectRL.setOnClickListener(this);
        friendsRL.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        replaceFragment(R.id.fragment_community_replace_fragment, new CommunityTopicFragment());
        menuTV.setOnClickListener(this);
        animatorRemove();
        Glide.with(mContext).load("http://a0.att.hudong.com/85/14/01300439213381133161146417945_s.png").into(topicIV);
        Glide.with(mContext).load("http://img4.imgtn.bdimg.com/it/u=964486054,3838113940&fm=21&gp=0.jpg ").into(selectIV);
        Glide.with(mContext).load("http://p6.qhimg.com/t01959cf3ed1622e2da.jpg").into(friendsIV);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_menu:
                mMenu.toggle();
                break;
            case R.id.fragment_community_topic_relativeLayout:
                mMenu.toggle();
                menuTV.setText("话题");
                animatorRemove();
                replaceFragment(R.id.fragment_community_replace_fragment, new CommunityTopicFragment());
                break;
            case R.id.fragment_community_select_relativeLayout:
                mMenu.toggle();
                menuTV.setText("精选");
                animatorRemove();
                replaceFragment(R.id.fragment_community_replace_fragment, new CommunitySelectionFragment());
                break;
            case R.id.fragment_community_friends_relativeLayout:
                mMenu.toggle();
                menuTV.setText("好友圈");
                animatorRemove();
                replaceFragment(R.id.fragment_community_replace_fragment, new CommunityFriendsFragment());
                break;
        }

    }


    public void animatorRemove(){
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(menuTV,"translationX",0,500),
                ObjectAnimator.ofFloat(menuTV,"translationX",500,0),
                ObjectAnimator.ofFloat(menuTV,"alpha",1,0.25f,1)
        );  set.setDuration(5000).start();
    }

    public void replaceFragment(int id, Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.commit();
    }
}
