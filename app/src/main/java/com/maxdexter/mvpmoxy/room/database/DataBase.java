package com.maxdexter.mvpmoxy.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserDao.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
