package com.maxdexter.mvpmoxy.room.database;

import android.app.Application;
import androidx.room.Room;

public class AppDatabase extends Application {
    private static DataBase mDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataBase = Room.databaseBuilder(getApplicationContext(), DataBase.class, "users_database").build();

    }

    public static DataBase getDataBase() {
        return mDataBase;
    }
}
