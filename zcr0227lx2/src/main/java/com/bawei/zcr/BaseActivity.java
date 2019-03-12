package com.bawei.zcr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @Author: zhang
 * @Date: 2019/2/27 19:06
 * @Description:抽积类
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(initLayout());
        //加载控件
        initView();
        //加载数据
        initData();

    }
    //初始化布局
    public abstract int initLayout();
    //初始化控件
    public abstract void initView();

    //初始化数据
    public abstract void initData();
    //findViewById
    public <T extends View> T fvbi(int resId){
        return (T) findViewById(resId);
    }
}
