package com.bawei.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: zhang
 * @Date: 2019/2/26 9:08
 * @Description:网络请求数据和图片
 */
public class HttpUtil {
    public static String getNetData(String dataUrl){
        try {
            URL url = new URL(dataUrl);
            //打开
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //获取网络状态码
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK){
                //读取
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
    //请求图片
    public static Bitmap getPicData(String picUrl){
        try {
            URL url = new URL(picUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
