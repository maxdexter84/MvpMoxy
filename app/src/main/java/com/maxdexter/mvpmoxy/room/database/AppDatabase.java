package com.maxdexter.mvpmoxy.room.database;

import android.app.Application;

import androidx.room.Room;


public class AppDatabase extends Application {

    private DataBase mDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataBase = Room.databaseBuilder(this, DataBase.class, "users_database").build();
    }

    public DataBase getDataBase() {
        return mDataBase;
    }
}
