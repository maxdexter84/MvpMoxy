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
import com.maxdexter.mvpmoxy.room.database.RoomPresenter;
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
    RoomPresenter mPresenter = new RoomPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        mRecyclerAdapter = new RecyclerAdapter();
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mRecyclerView.setAdapter(mRecyclerAdapter);


        initButton();
    }

    private void initButton() {
        mAddButton = findViewById(R.id.add_user);
        mDeleteButton = findViewById(R.id.delete_user);
        setAddButton();
        setDeleteButton();
    }

    private void setDeleteButton() {
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setAddButton() {
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
            mPresenter.addUser(new User("User " + count,"User " + count,count));
            }
        });
    }


}

