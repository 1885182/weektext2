package com.bawei.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bawei.helper.MyHelper;

/**
 * @Author: zhang
 * @Date: 2019/3/1 9:07
 * @Description:Dao层
 */
public class SqlDao {
    private MyHelper helper;
    private String table = "news";
    public SqlDao(Context mContext) {
        helper = new MyHelper(mContext);
    }
    //添加数据库
    public void insertData(String url,String json){
        SQLiteDatabase database = helper.getWritableDatabase();
        //删除原有数据,重新添加新数据
        database.delete(table,"url=?",new String[]{url});
        ContentValues values = new ContentValues();
        values.put("url",url);
        values.put("json",json);
        database.insert(table,null,values);
    }
    //查询数据库
    public String selectData(String url){
        String json = "";
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor query = database.query(table, null, "url=?", new String[]{url}, null, null, null);
        while (query.moveToNext()){
            json = query.getString(query.getColumnIndex("json"));
        }
        return json;
    }
}
