package com.littlespider.spiderlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.littlespider.mylibrary.myInterface.ICallbackListener;
import com.littlespider.mylibrary.tool.LogUtil;
import com.littlespider.mylibrary.tool.OkRequestUtil;
import com.littlespider.mylibrary.tool.ToastUtil;

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                LogUtil.write("MainActivity:" + Thread.currentThread().getName());
                new OkRequestUtil().sendPost(url,params, new MyListener(), "name");
            }
        });

        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
    }

    public void myClick(View view){
        new OkRequestUtil().sendPost(url, params, new MyListener(), "login");
    }

    class MyListener implements ICallbackListener{

        @Override
        public void onSuccess(String responseString) {
            LogUtil.write("MainActivity:" + responseString);
                    new ToastUtil(MainActivity.this).show("MainActivity:" + responseString);
        }

        @Override
        public void onFailed() {

        }
    }
}
