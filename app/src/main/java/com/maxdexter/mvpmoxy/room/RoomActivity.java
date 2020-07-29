package com.maxdexter.mvpmoxy.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.room.database.AppDatabase;
import com.maxdexter.mvpmoxy.room.database.DataBase;
import com.maxdexter.mvpmoxy.room.database.UserDao;
import com.maxdexter.mvpmoxy.room.database.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RoomActivity extends AppCompatActivity {
    Button mAddButton;
    Button mDeleteButton;
    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
    int count = 0;
    private static final String TAG = "RoomPresenter";
    private UserDao mUserDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mRecyclerAdapter = new RecyclerAdapter();
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mUserDao = AppDatabase.getDataBase().getUserDao();
        mUserDao.getAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onSuccess(List<User> users) {
                        mRecyclerAdapter.addList(users);

                        Log.d(TAG, "getData: " + users.size() + " " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        mRecyclerView.setAdapter(mRecyclerAdapter);
        initButton();

    }



    private void initButton() {
        mAddButton = findViewById(R.id.add_user);
        mDeleteButton = findViewById(R.id.delete_user);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            count++;
           User user = new User("name " + count, "surname " + count,count);
                Disposable disposable = mUserDao.addUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(id -> {
                            mUserDao.getAllUser();
                            mRecyclerAdapter.notifyDataSetChanged();
                            Log.d(TAG, "putData: " + id);
                        }, throwable -> {
                            Log.d(TAG, "putData: " + throwable);
                        });
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("name " + count, "surname " + count,count);
                count--;
                Disposable disposable = mUserDao.deleteUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(id -> {
                            mUserDao.getAllUser();
                            mRecyclerAdapter.notifyDataSetChanged();
                            Log.d(TAG, "getData: " + id + " " + Thread.currentThread().getName());
                        }, throwable -> {
                            Log.d(TAG, "getData: " + throwable);
                        });
            }


        });
    }
}