package com.maxdexter.mvpmoxy.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.maxdexter.mvpmoxy.room.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
