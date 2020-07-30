package com.maxdexter.mvpmoxy.room.database;

import android.util.Log;

import com.maxdexter.mvpmoxy.room.User;
import io.reactivex.*;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;



public class RoomPresenter {
    private static final String TAG = "tag";
    private static RoomPresenter instance;
    private UserDao mUserDao;
    List<User> mUsers;

    public static RoomPresenter getInstance() {
        if(instance == null){
            instance = new RoomPresenter();
        }
        return instance;
    }

    public RoomPresenter() {
        mUserDao = AppDatabase.getDataBase().getUserDao();
    }

    public List<User> getUsers() {
      mUserDao.getAllUser()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new SingleObserver<List<User>>() {
                  @Override
                  public void onSubscribe(Disposable d) {
                  }
                  @Override
                  public void onSuccess(List<User> users) {
                      mUsers = users;
                      Log.d(TAG,users.toString());
                  }

                  @Override
                  public void onError(Throwable e) {
                      Log.d(TAG,e.getMessage());
                  }
              });
      return mUsers;
    }

    public void addUser(User user) {
        mUserDao.addUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(Long aLong) {
                       mUsers = getUsers();
                        Log.d(TAG,aLong.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                    Log.d(TAG,e.getMessage());
                    }
                });
    }
    public void deleteUser(User user) {
        mUserDao.deleteUser(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        getUsers();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
