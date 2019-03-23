package com.littlespider.mylibrary.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.littlespider.mylibrary.R;


/**
 * 一个可以多处复用的自定义返回控件
 * Created by littleSpider on 2018/4/18.
 */

public class BackView extends RelativeLayout implements View.OnClickListener, IBackListener{

    RelativeLayout rl_back;
    ImageView iv_back;
    Context mContext;
    IBackListener backListener;

    public BackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_back, this);
        iv_back = view.findViewById(R.id.iv_back);
        rl_back = view.findViewById(R.id.rl_back);
        rl_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(backListener == null){
            backListener = this;
        }
        backListener.backClick();
    }

    /**
     * 设置白色的返回图片
     */
    public void setWhiteBack(){
        iv_back.setImageResource(R.drawable.back_white);
    }

    /**
     * 重新定义该控件的点击事件
     * @param backListener
     */
    public void setBackListener(IBackListener backListener){
        this.backListener = backListener;
        rl_back.setOnClickListener(this);
    }

    @Override
    public void backClick() {
        //获取此控件所在的activity
        Activity activity = (Activity)this.getContext();
        activity.finish();
    }

}
