package com.bawei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: zhang
 * @Date: 2019/2/27 15:41
 * @Description:
 */
public class HttpUtil {
    //网络判断
    public static boolean isNetConneted(Context context){
        if (context != null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }
    //请求数据
    public static String getNetData(String dataUrl){
        try {
            URL url = new URL(dataUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String str = "";
                while ((str = reader.readLine()) != null){
                    builder.append(str);
                }
                return builder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //创建异步请求的接口
    public interface MyCallBack{
        //定义请求数据的方法
        void getData(String str);
    }
    //定义异步任务的工具类
    public static void MyAsyncTask(String url, final MyCallBack myCallBack){
        //匿名内部类的方式创建AsyncTask
        new AsyncTask<String, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                myCallBack.getData(s);
            }

            @Override
            protected String doInBackground(String... strings) {
                return HttpUtil.getNetData(strings[0]);
            }
        }.execute(url);
    }
}
