package com.littlespider.mylibrary.myInterface;

/**
 * Created by littlespider on 2019/03/24.
 */
public interface ICallbackListener {

    void onSuccess(String responseString);

    void onFailed();
}
