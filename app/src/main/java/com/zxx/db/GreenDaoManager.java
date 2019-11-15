package com.zxx.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yfy.greendao.User;
import com.yfy.greendao.UserDao;
import com.zxx.base.App;

import java.util.List;

/**
 * Created by yfy1 on 2016/12/30.
 */

public class GreenDaoManager {


    private Cursor cursor, content_cursor;

    public static GreenDaoManager manager;


    public synchronized static GreenDaoManager getInstance() {
        if (manager == null) {
            manager=new GreenDaoManager();
        }
        return manager;
    }

    public GreenDaoManager() {
        String textColumn = UserDao.Properties.Name.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = getDb().query(
                getUserDao().getTablename(),
                getUserDao().getAllColumns(),
                null, null, null, null,
                orderBy);
    }



    private UserDao getUserDao() {
        // 通过 BaseApplication 类提供的 getDaoSession() 获取具体 Dao
        return ((App) App.getApp().getApplicationContext()).getDaoSession().getUserDao();
    }
    private SQLiteDatabase getDb() {
        // 通过 BaseApplication 类提供的 getDb() 获取具体 db
        return ((App) App.getApp().getApplicationContext()).getDb();
    }






    /**
     * 获取用户信息
     */

    public List<User> query_User(String... params){
        return getUserDao().queryRaw("where name= ?", params);
    }
    /**清除 用户*/
    public void clearUser() {
        getUserDao().deleteAll();
    }


    public void save(User note){
        getUserDao().insert(note);
    }
}
