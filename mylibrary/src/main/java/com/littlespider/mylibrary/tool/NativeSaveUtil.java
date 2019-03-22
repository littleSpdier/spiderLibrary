package com.littlespider.mylibrary.tool;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by littlespider on 2019/03/22.
 */
public class NativeSaveUtil {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public NativeSaveUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("nativeData", Context.MODE_PRIVATE);
    }

    public NativeSaveUtil(Context context, String tableName) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(tableName, Context.MODE_PRIVATE);
    }

    private void createEditer() {
        if (editor != null) {
            editor = sharedPreferences.edit();
        }
    }

    public void save(String keyOfSaveBody, Object valueOfSaveBody) {
        createEditer();
        if (valueOfSaveBody instanceof String) {
            editor.putString(keyOfSaveBody, String.valueOf(valueOfSaveBody));
        } else if (valueOfSaveBody instanceof Integer) {
            editor.putInt(keyOfSaveBody, (Integer) valueOfSaveBody);
        } else if (valueOfSaveBody instanceof Float) {
            editor.putFloat(keyOfSaveBody, (Float) valueOfSaveBody);
        } else if (valueOfSaveBody instanceof Long) {
            editor.putFloat(keyOfSaveBody, (Long) valueOfSaveBody);
        } else if (valueOfSaveBody instanceof Boolean) {
            editor.putBoolean(keyOfSaveBody, (Boolean) valueOfSaveBody);
        } else {
            Log.i("prince", "can't save this data of the type\n\t---from spiderlibrary");
        }
        editor.commit();
    }

    /**
     * 获取String类型的首选项值
     * @param keyOfGetBody 要获取首选项的key值
     * @return
     */
    public String getString(String keyOfGetBody) {
        String savedValue = getString(keyOfGetBody, "");
        return savedValue;
    }

    /**
     * 同上
     * @param keyOfGetBody
     * @param defaultValue 如果之前没有存储, 则需返回的默认值
     * @return
     */
    public String getString(String keyOfGetBody, String defaultValue) {
        String savedString = sharedPreferences.getString(keyOfGetBody, defaultValue);
        return savedString;
    }

    /**
     * 获取int类型的首选项值
     * @param keyOfGetBody 要获取首选项的key值
     * @return
     */
    public Integer getInt(String keyOfGetBody){
        int savedValue = getInt(keyOfGetBody, 0);
        return savedValue;
    }

    /**
     * 同上
     * @param keyOfGetBody
     * @param defaultValue 如果之前没有存储, 则需返回的默认值
     * @return
     */
    public Integer getInt(String keyOfGetBody, int defaultValue){
        int savedValue = sharedPreferences.getInt(keyOfGetBody, defaultValue);
        return savedValue;
    }

    /**
     * 获取float类型的首选项值
     * @param keyOfGetBody 要获取首选项的key值
     * @return
     */
    public Float getFloat(String keyOfGetBody){
        float savedValue = getFloat(keyOfGetBody, 0f);
        return savedValue;
    }

    /**
     * 同上
     * @param keyOfGetBody
     * @param defaultValue 如果之前没有存储, 则需返回的默认值
     * @return
     */
    public Float getFloat(String keyOfGetBody, float defaultValue){
        float savedValue = getFloat(keyOfGetBody, defaultValue);
        return savedValue;
    }

    /**
     * 获取long类型的首选项值
     * @param keyOfGetBody 要获取首选项的key值
     * @return
     */
    public Long getLong(String keyOfGetBody){
        long savedValue = getLong(keyOfGetBody, 0);
        return savedValue;
    }

    /**
     * 同上
     * @param keyOfGetBody
     * @param defaultValue 如果之前没有存储, 则需返回的默认值
     * @return
     */
    public Long getLong(String keyOfGetBody, long defaultValue){
        long savedValue = sharedPreferences.getLong(keyOfGetBody, defaultValue);
        return savedValue;
    }

    /**
     * 获取boolean类型的首选项值
     * @param keyOfGetBody 要获取首选项的key值
     * @return
     */
    public Boolean getBoolean(String keyOfGetBody, boolean defaultValue){
        boolean savedValue = sharedPreferences.getBoolean(keyOfGetBody, defaultValue);
        return savedValue;
    }
}
