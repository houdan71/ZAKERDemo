package com.example.dllo.zaker.subscription.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.zaker.R;
import com.example.dllo.zaker.base.BaseActivity;
import com.example.dllo.zaker.singleton.NetTool;
import com.example.dllo.zaker.singleton.onHttpCallBack;
import com.example.dllo.zaker.subscription.entity.Bean_click;
import com.example.dllo.zaker.tools.NValues;


/**
 * Created by dllo on 16/9/8.
 */
public class ClickActivity extends BaseActivity implements TextWatcher {
    private TextView text_click;
    private ImageView imageview;
    private EditText edit_text;
    private WebView web;
    private Button btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,
    btn_seven,btn_eight,btn_nine,btn_ten,button_btn;

    @Override
    protected int getLayout() {

        return R.layout.activity_click;
    }

    @Override
    protected void initView() {
        text_click = (TextView) findViewById(R.id.text_click);
        btn_one= (Button) findViewById(R.id.btn_one);
        btn_two= (Button) findViewById(R.id.btn__two);
        btn_three= (Button) findViewById(R.id.btn__three);
        btn_four= (Button) findViewById(R.id.btn__four);
        btn_five= (Button) findViewById(R.id.btn__five);
        btn_six= (Button) findViewById(R.id.btn__six);
        btn_seven= (Button) findViewById(R.id.btn__seven);
        btn_eight= (Button) findViewById(R.id.btn__eight);
        btn_nine= (Button) findViewById(R.id.btn__nine);
        btn_ten= (Button) findViewById(R.id.btn__ten);
        web= (WebView) findViewById(R.id.web);
        edit_text= (EditText) findViewById(R.id.edit_text);
        imageview= (ImageView) findViewById(R.id.image_back);
        button_btn= (Button) findViewById(R.id.button_btn);
        button_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_one.setVisibility(View.GONE);
                btn_two.setVisibility(View.GONE);
                btn_three.setVisibility(View.GONE);
                btn_four.setVisibility(View.GONE);
                btn_five.setVisibility(View.GONE);
                btn_six.setVisibility(View.GONE);
                btn_seven.setVisibility(View.GONE);
                btn_eight.setVisibility(View.GONE);
                btn_nine.setVisibility(View.GONE);
                btn_ten.setVisibility(View.GONE);
                String url =  "http://search.myzaker.com/api/?_lbs_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_lng=121.551011&_net=wifi&_dev=515&keyword="+ edit_text.getText().toString() + "&_udid=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920.08:00:27:4c:0a:58&_province=%E8%BE%BD%E5%AE%81%E7%9C%81&_city=%E5%A4%A7%E8%BF%9E&_lat=38.889723&app_ids=660,7,13,981,1067,4,8,9,12,11195,10530,10386,12175,10362,310000&_appid=AndroidPhone&_lbs_city=%E5%A4%A7%E8%BF%9E&_version=6.7&_os_name=GoogleNexus5-4.4.4-API19-1080x1920&_mac=08:00:27:4c:0a:58&_os=4.4.4_GoogleNexus5-4.4.4-API19-1080x1920&_mcode=2FFC24DC&_nudid=f8d5a71e2585d3a4&_bsize=1080_1920&_v=6.7&_webcode=9c622f86af5dabc748cb";
                 web.loadUrl(url);
                web.setVisibility(View.VISIBLE);

            }
        });
        imageview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edit_text.addTextChangedListener(this);


    }

    @Override
    protected void initData() {


        NetTool.getInstance().startRequest(NValues.URL_CLICK, Bean_click.class, new onHttpCallBack<Bean_click>() {
            @Override
            public void onSuccess(Bean_click response) {
                btn_one.setText(response.getData().getWordlist().get(0).getWords().get(0).getText());
                btn_two.setText(response.getData().getWordlist().get(0).getWords().get(1).getText());
                btn_three.setText(response.getData().getWordlist().get(0).getWords().get(2).getText());
                btn_four.setText(response.getData().getWordlist().get(0).getWords().get(3).getText());
                btn_five.setText(response.getData().getWordlist().get(0).getWords().get(4).getText());
                btn_six.setText(response.getData().getWordlist().get(0).getWords().get(5).getText());
                btn_seven.setText(response.getData().getWordlist().get(0).getWords().get(6).getText());
                btn_eight.setText(response.getData().getWordlist().get(0).getWords().get(7).getText());
                btn_nine.setText(response.getData().getWordlist().get(0).getWords().get(8).getText());
                btn_ten.setText(response.getData().getWordlist().get(0).getWords().get(9).getText());


            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
