package com.example.dllo.zaker.login;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

/**
 * Created by yuxiaomin~ on 16/9/5.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivDelete;
    private ImageView ivQQ, ivSina, ivWenxin;

    @Override
    protected int getLayout() {

        return R.layout.activity_login_first;
    }

    @Override
    protected void initView() {
        ivDelete = (ImageView) findViewById(R.id.iv_login_delete);
        ivQQ = (ImageView) findViewById(R.id.cb_login_qq);
        ivSina = (ImageView) findViewById(R.id.cb_login_sina);
        ivWenxin = (ImageView) findViewById(R.id.cb_login_weixin);
    }

    @Override
    protected void initData() {
        ivDelete.setOnClickListener(this);
        ivQQ.setOnClickListener(this);
        ivWenxin.setOnClickListener(this);
        ivSina.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_login_delete:
                finish();
                break;
            case R.id.cb_login_qq:
                ShareSDK.initSDK(this);
                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.showUser(null);//授权并获取用户信息
                break;
            case R.id.cb_login_sina:
                ShareSDK.initSDK(this);
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
//                weibo.setPlatformActionListener(paListener);
//                weibo.authorize();//单独授权
                weibo.showUser(null);//授权并获取用户信息
                //authorize与showUser单独调用一个即可
                //移除授权
                //weibo.removeAccount(true);
                break;
            case R.id.cb_login_weixin:
                ShareSDK.initSDK(this);
                Platform weiXin = ShareSDK.getPlatform(Wechat.NAME);
                weiXin.showUser(null);//授权并获取用户信息
                break;
        }
    }


}
