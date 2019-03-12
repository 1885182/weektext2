package com.bawei.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @Author: zhang
 * @Date: 2019/2/27 19:49
 * @Description:Fragment的抽积类
 */
public abstract class BaseFragment extends Fragment {
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        return view;
    }
    //初始化布局
    public abstract int initLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //加载控件
        initView();
    }
    //初始化控件
    protected abstract void initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //加载数据
        initData();
        //监听
        initListener();
    }
    //初始化数据
    public abstract void initData();



    public <T extends View> T fvbi(int resId){
        return (T) getView().findViewById(resId);
    }
    public abstract void initListener();
}
