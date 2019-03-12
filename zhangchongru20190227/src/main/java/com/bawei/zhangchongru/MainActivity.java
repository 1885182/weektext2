package com.bawei.zhangchongru;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Banner banner;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        list.add("http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg");
        list.add("http://img.kaiyanapp.com/aa6f349fb801f3ce40ba9b4c95908649.jpeg?imageMogr2/quality/60/format/jpg");
        list.add("http://img.kaiyanapp.com/56cb65d09db5649407c77c9c1b6d31b9.jpeg?imageMogr2/quality/60/format/jpg");
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.start();
    }
}
