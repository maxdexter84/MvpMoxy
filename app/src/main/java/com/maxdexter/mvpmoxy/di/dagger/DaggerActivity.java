package com.maxdexter.mvpmoxy.di.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maxdexter.mvpmoxy.R;

public class DaggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
    }
}