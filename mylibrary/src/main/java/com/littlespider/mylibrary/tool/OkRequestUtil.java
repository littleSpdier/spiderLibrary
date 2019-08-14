package com.littlespider.mylibrary.tool;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.littlespider.mylibrary.myInterface.ICallbackListener;

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
    private ICallbackListener callbackListener;
    private Handler handler = new Handler(Looper.getMainLooper());

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public OkRequestUtil() {

    }

//    public synchronized OkRequestUtil getInstance(Context context){
//        this.context = context;
//        if (okRequestUtil == null){
//            okRequestUtil = new OkRequestUtil();
//        }
//
//        return okRequestUtil;
//    }

    public String toJsonString(Object object){
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        LogUtil.write(jsonString);
        return jsonString;
    }

    public void sendPost(String url, Map<String, String> params, ICallbackListener iCallbackListener, String... tag){
        this.callbackListener = iCallbackListener;
//        if (tag.length != 0){
//            final String theTag = tag[0];
//        }
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            bodyBuilder.add(param.getKey(), param.getValue());
            Log.i("every-params", String.format("key: %s\t=" +
                    "==\tvalue: %s", param.getKey(), param.getValue()));
        }
        FormBody formBody = bodyBuilder.build();
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                final String result = response.body().string();
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        LogUtil.write("Thread:" + Thread.currentThread().getName());
                        callbackListener.onSuccess(result);
                    }
                });
            }

            @Override
            public void onFailure(Call call, IOException e) {
                callbackListener.onFailed();
            }
        });
    }
}
