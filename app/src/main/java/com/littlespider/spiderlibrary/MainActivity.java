package com.littlespider.spiderlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.littlespider.mylibrary.tool.OkRequestUtil;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String bodyJson;
    Map<String, String> params = new HashMap<>();
    String url = "https://m.51ganjie.cn/appUser/login.do";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        params.put("deviceId", "0");
        params.put("userName", "15172144011");
        params.put("pwd", "123456");
        params.put("loginType", "1");

        ParamsBean paramsBean = new ParamsBean();
        paramsBean.setUserName("15172144011");
        paramsBean.setPwd("123456");
        paramsBean.setDeviceId("0");
        paramsBean.setLoginType("1");
        OkRequestUtil.getInstance().sendPost(url,params);
    }

}
