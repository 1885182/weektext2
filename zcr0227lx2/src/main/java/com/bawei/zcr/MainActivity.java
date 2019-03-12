package com.bawei.zcr;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.bawei.adapter.MyFragmentAdapter;
import com.bawei.fragment.MyFragment;
import com.bawei.fragment.ShouyeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首先这是第一个页面
 * DrawerLayout侧拉
 * ViewPager+TabLayout切换页面
 * 写抽积类BaseActivity
 */
public class MainActivity extends BaseActivity {

    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titles = {"首页","我的"};
    private List<Fragment> list = new ArrayList<>();
    //初始化布局
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }
    //初始化控件
    @Override
    public void initView() {
        drawerLayout = fvbi(R.id.drawerlayout);
        tabLayout = fvbi(R.id.tablayout);
        viewPager = fvbi(R.id.viewpager);
        //侧拉
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
    //初始化数据
    @Override
    public void initData() {

        //
        list.add(new ShouyeFragment());
        list.add(new MyFragment());
        //创建适配器
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),list,titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {

    }
}
