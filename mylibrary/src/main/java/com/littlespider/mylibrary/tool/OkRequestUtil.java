package com.littlespider.mylibrary.tool;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by littlespider on 2019/03/23.
 */
public class OkRequestUtil {

    private OkHttpClient client = new OkHttpClient();
    private static OkRequestUtil okRequestUtil = null;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkRequestUtil() {
    }

    public static synchronized OkRequestUtil getInstance(){
        if (okRequestUtil == null){
            okRequestUtil = new OkRequestUtil();
        }

        return okRequestUtil;
    }

    public String toJsonString(Object object){
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        LogUtil.write(jsonString);
        return jsonString;
    }

    public void sendPost(String url, Map<String, String> params){
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            bodyBuilder.add(param.getKey(), param.getValue());
            Log.i("every-params", String.format("key: %s\t===\tvalue: %s", param.getKey(), param.getValue()));
        }
        FormBody formBody = bodyBuilder.build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                new LogUtil().write(result);
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }
        });
    }
}
