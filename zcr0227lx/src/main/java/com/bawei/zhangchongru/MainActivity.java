package com.bawei.zhangchongru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.util.HttpUtil;

public class MainActivity extends AppCompatActivity {

    private String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //判断网络
        if (HttpUtil.isNetConneted(MainActivity.this)){
            //请求数据
            HttpUtil.MyAsyncTask(url, new HttpUtil.MyCallBack() {
                @Override
                public void getData(String str) {
                    Log.i("aaaaa",""+str);
                }
            });
        }
    }
}
