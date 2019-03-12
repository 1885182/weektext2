package com.bawei.fragment;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.adapter.MyAdapter;
import com.bawei.bean.FuliBean;
import com.bawei.bean.ResultsBean;
import com.bawei.dao.SqlDao;
import com.bawei.util.HttpUtil;
import com.bawei.zcr.R;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/2/27 19:48
 * @Description:首页
 *          HttpUrlConnection进行数据请求、图片请求；
 *          Banner轮播
 *          Asynctask进行异步处理；
 *          Json解析
 *          PullToRefresh进行优化展示且完成上拉下拉效果
 */
public class ShouyeFragment extends BaseFragment {
    private List<ResultsBean> beanList = new ArrayList<>();
    private PullToRefreshListView pullList;
    private List<String> list = new ArrayList<>();
    private Banner banner;
    private int page = 0;
    private String url = "http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private MyAdapter adapter;
    private SqlDao dao;

    //初始化布局
    @Override
    public int initLayout() {
        return R.layout.shouye_fragment;
    }
    //初始化控件
    @Override
    protected void initView() {
        banner = fvbi(R.id.banner);
        pullList = fvbi(R.id.pullList);
        //支持上拉下拉
        pullList.setMode(PullToRefreshBase.Mode.BOTH);
        //支持刷新中支持滚动
        pullList.setScrollingWhileRefreshingEnabled(true);

    }
    //初始化数据
    @Override
    public void initData() {
        //创建数据库工具类
        dao = new SqlDao(getActivity());
        //轮播
        setBanner();
        //创建适配器
        adapter = new MyAdapter(getActivity(),beanList);
        pullList.setAdapter(adapter);
        //判断网络
        if (HttpUtil.isNetConnected(getActivity())){
            //有网
            //加载数据
            getMyData(page);
        }else {
            //没网
            Toast.makeText(getActivity(), "请检查网络连接", Toast.LENGTH_SHORT).show();
            //查询数据库
            String s = dao.selectData(url + page);
            jsonParse(s);
        }
    }

    private void getMyData(int p) {
        final String dataUrl = url + p;
        HttpUtil.MyTask(dataUrl, new HttpUtil.MyCallBack() {
            @Override
            public Void getData(String str) {
                //保存到数据库
                dao.insertData(dataUrl,str);
                //解析
                jsonParse(str);
                return null;
            }
        });
    }
    //解析
    private void jsonParse(String str) {
        Gson gson = new Gson();
        FuliBean fromJson = gson.fromJson(str, FuliBean.class);
        beanList.addAll(fromJson.getData());
        //刷新适配器
        adapter.notifyDataSetChanged();
        //关闭刷新
        pullList.onRefreshComplete();
    }

    //轮播
    private void setBanner() {
        banner.isAutoPlay(true);
        banner.setDelayTime(1000);
        list.add("http://ww1.sinaimg.cn/large/0065oQSqly1frja502w5xj30k80od410.jpg");
        list.add("http://ww1.sinaimg.cn/large/0065oQSqly1fri9zqwzkoj30ql0w3jy0.jpg");
        list.add("http://ww1.sinaimg.cn/large/0065oQSqly1frg40vozfnj30ku0qwq7s.jpg");
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }
    //监听
    @Override
    public void initListener() {
        pullList.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //下拉刷新
                beanList.clear();
                getMyData(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //上拉加载数据
                page++;
                getMyData(page);
            }
        });
    }
}
