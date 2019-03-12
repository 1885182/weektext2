package com.bawei.zhangchongru;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.adapter.MyBaseAdapter;
import com.bawei.bean.MyRxxp;
import com.bawei.bean.Shop;
import com.bawei.bean.ShopBean;
import com.bawei.util.HttpUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 侧拉 xListView  多条目加载  请求网络数据
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private XListView xListView;
    private ImageView imageView;
    private Button textmy,gengduo;
    private String dataUrl = "http://172.17.8.100/small/commodity/v1/commodityList";
    private String picUrl = "https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg";
    private List<Shop> list = new ArrayList<Shop>();
    private MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        drawerLayout = findViewById(R.id.drawerlayout);
        xListView = findViewById(R.id.xlistview);
        imageView = findViewById(R.id.image);
        textmy = findViewById(R.id.textmy);
        gengduo = findViewById(R.id.gengduo);
        //侧拉
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        //添加监听
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {

            }

            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(MainActivity.this,"打开",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(MainActivity.this,"关闭",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
        //创建适配器
        adapter = new MyBaseAdapter(list,MainActivity.this);
        xListView.setAdapter(adapter);
        //加载数据
        new MyAsynvTask().execute(dataUrl);
        //加载图片
        //new MyAsynvTask().execute(picUrl);
        Glide.with(MainActivity.this).load(picUrl).into(imageView);
        //条目点击
        textmy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"我的",Toast.LENGTH_SHORT).show();
            }
        });
        gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"更多",Toast.LENGTH_SHORT).show();
            }
        });
    }



    //内部类--请求数据
    public class MyAsynvTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //解析
            jsonParse(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            return HttpUtil.getNetData(strings[0]);
        }
    }
    //内部类--请求图片
    public class PicAsyncTask extends AsyncTask<String,Void,Bitmap>{
        ImageView iv;

        public PicAsyncTask(ImageView iv) {
            this.iv = iv;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            return HttpUtil.getPicData(strings[0]);
        }
    }
    //解析
    private void jsonParse(String s) {
        Gson gson = new Gson();
        ShopBean fromJson = gson.fromJson(s, ShopBean.class);
        //添加到集合
        list.addAll(fromJson.getResult().getRxxp().get(0).getCommodityList());
        list.addAll(fromJson.getResult().getPzsh().get(0).getCommodityList());
        list.addAll(fromJson.getResult().getMlss().get(0).getCommodityList());
        //Log.i("aaa",""+list.toString());
        //刷新适配器
        adapter.notifyDataSetChanged();
    }
}
