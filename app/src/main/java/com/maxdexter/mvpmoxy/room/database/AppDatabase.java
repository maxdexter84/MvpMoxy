package com.maxdexter.mvpmoxy.room.database;

import android.app.Application;

import androidx.room.Room;

import com.maxdexter.mvpmoxy.room.User;

import java.util.List;


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

    public void addUser(User user) {
        mDataBase.getUserDao().addUser(user);
    }

    public List<User> getAllUser() {
      return mDataBase.getUserDao().getAllUser();
    }

    public void deleteUser(User user) {
        mDataBase.getUserDao().deleteUser(user);
    }

    public User selectUserBySurname(String surname) {
       return (User) mDataBase.getUserDao().selectUser(surname);
    }
}
