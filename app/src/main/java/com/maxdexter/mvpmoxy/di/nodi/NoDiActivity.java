package com.maxdexter.mvpmoxy.di.nodi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maxdexter.mvpmoxy.R;

public class NoDiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_di);

        Red red = new Red();
        White white = new White();
    }
}