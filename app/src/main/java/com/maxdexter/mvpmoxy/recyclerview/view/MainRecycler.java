package com.maxdexter.mvpmoxy.recyclerview.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.recyclerview.presenter.MainRecyclerPresenter;

public class MainRecycler extends AppCompatActivity {
    MainRecyclerPresenter mMainRecyclerPresenter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mMainRecyclerPresenter = new MainRecyclerPresenter();
      Drawable drawable = getDrawable(R.drawable.ic_launcher_background);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(drawable);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerAdapter);
    }
}