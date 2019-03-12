package com.bawei.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Author: zhang
 * @Date: 2019/3/1 9:08
 * @Description:数据库帮助类
 */
public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context) {
        super(context,"bawei.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table news (url vahrchar,json varchar(800))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
