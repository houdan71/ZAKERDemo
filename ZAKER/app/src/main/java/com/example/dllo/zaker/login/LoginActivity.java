package com.example.dllo.zaker.login;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;

/**
 * Created by dllo on 16/9/5.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivDelete;

    @Override
    protected int getLayout() {

        return R.layout.activity_login_first;
    }

    @Override
    protected void initView() {
        ivDelete = (ImageView) findViewById(R.id.iv_login_delete);

    }

    @Override
    protected void initData() {
        ivDelete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_login_delete:
                finish();
                break;
        }
    }


}
