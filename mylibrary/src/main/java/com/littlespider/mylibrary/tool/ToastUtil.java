package com.littlespider.mylibrary.tool;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by littlespider on 2018/12/03.
 */
public class ToastUtil {

    private Toast toast;
    private Context mContext;

    public ToastUtil(Context context){
        mContext = context;
    }

    public void show(String message){
        if (toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showLong(String message){
        if (toast != null){
            toast.cancel();
        }
        toast = Toast.makeText(mContext, message, Toast.LENGTH_LONG);
        toast.show();
    }
}