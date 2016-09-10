package com.example.dllo.zaker.playfun.location;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.playfun.location.city_glide.CircleTextView;
import com.example.dllo.zaker.playfun.location.city_glide.MySlideView;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.tools.NValues;

import java.util.ArrayList;

/**
 * Created by yuxiaomin~ on 16/9/5.
 */
public class PlayFunLocationChooseActivity extends BaseActivity implements View.OnClickListener, MySlideView.onTouchListener, PlayFunLocationChooseAdapter.onItemClickListener {
    private ImageView ivBack;
    /**
     * 每个城市首字母的集合
     */
    public static String[] letters = {"#", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    private MySlideView mySlideView;
    /**
     * 吐司显示的View
     */
    private CircleTextView circleTxt;

    private RecyclerView recyclerView;

    private TextView tvHeaderView;
    private PlayFunLocationChooseAdapter adapter;
    /**
     * recyclerView布局管理器
     */
    private LinearLayoutManager layoutManager;
    /**
     * 城市名集合
     */
    public static ArrayList<String> stringCitys = new ArrayList<>();
    private PlayFunLocationChooseBean mChooseBean;



    @Override
    protected int getLayout() {
        return R.layout.activity_playfun_location_choose_city;
    }

    @Override
    protected void initView() {
        ivBack = (ImageView) findViewById(R.id.iv_playfun_location_city_choose_back);

        mySlideView = (MySlideView) findViewById(R.id.my_slide_view);
        circleTxt = (CircleTextView) findViewById(R.id.my_circle_view);
        tvHeaderView = (TextView) findViewById(R.id.tv_city_choose_header_view);
        recyclerView = (RecyclerView) findViewById(R.id.rv_sticky_example);
    }

    @Override
    protected void initData() {
        ivBack.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlayFunLocationChooseAdapter(getApplicationContext());

        NetTool.getInstance().startRequest(NValues.URL_PLAYFUN_CITY, PlayFunLocationChooseBean.class, new onHttpCallBack<PlayFunLocationChooseBean>() {
            @Override
            public void onSuccess(PlayFunLocationChooseBean response) {
                mChooseBean = response;

                for (int j = 0; j < response.getData().getCities().size(); j++) {
                    stringCitys.add(response.getData().getCities().get(j).getCity_name());
//                    pinyinList.add(response.getData().getCities().get(j).getLetter());
                    Log.d("afr", "onSuccess: " + stringCitys.size());
                }

                adapter.setChooseBean(response);
//                recyclerView.addItemDecoration(new RecyclerViewItemDecoration());
                recyclerView.setAdapter(adapter);

                mySlideView.setListener(PlayFunLocationChooseActivity.this);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("aaa", "onError: " + e.getMessage());
            }
        });


        adapter.setListener(this);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View stickyInfoView = recyclerView.findChildViewUnder(tvHeaderView.getMeasuredWidth() / 2, 5);
                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvHeaderView.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }
                View transInfoView = recyclerView.findChildViewUnder(tvHeaderView.getMeasuredWidth() / 2, tvHeaderView.getMeasuredHeight() + 1);
                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvHeaderView.getMeasuredHeight();
                    if (transViewStatus == PlayFunLocationChooseAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tvHeaderView.setTranslationY(dealtY);
                        } else {
                            tvHeaderView.setTranslationY(0);
                        }
                    } else if (transViewStatus == PlayFunLocationChooseAdapter.NONE_STICKY_VIEW) {
                        tvHeaderView.setTranslationY(0);
                    }
                }
            }
        });
    }
    private String b;

    @Override
    public void itemClick(int position) {

      b = mChooseBean.getData().getCities().get(position).getCity_name();
    }


    @Override
    public void showTextView(String textView, boolean dismiss) {
        if (dismiss) {
            circleTxt.setVisibility(View.GONE);
        } else {
            circleTxt.setVisibility(View.VISIBLE);
            circleTxt.setText(textView);
        }

        int selectPosition = 0;
        for (int i = 0; i < mChooseBean.getData().getCities().size(); i++) {
            if (mChooseBean.getData().getCities().get(i).getLetter().equals(textView)) {
                selectPosition = i;
                break;
            }
        }
        recyclerView.scrollToPosition(selectPosition);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_playfun_location_city_choose_back:
                Intent intent = new Intent();
                int resultCode = 200;
                intent.putExtra("back", b);
                this.setResult(resultCode,intent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent();
        int resultCode = 200;
        intent.putExtra("back", b);
        this.setResult(resultCode,intent);
        finish();
    }
}
