package com.taotao.greenddemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.DaoMaster;
import com.example.DaoSession;

/**
 * Created by taotao on 16-6-5.
 */

public class DemoApplication extends Application {

    private DaoSession daoSession;
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster daoMaster;


    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    private void setupDatabase() {
        helper = new DaoMaster.DevOpenHelper(this,"record",null);
        db = helper.getWritableDatabase();

        daoMaster = new DaoMaster(db);
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();


    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
