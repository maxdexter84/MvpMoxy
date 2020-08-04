package com.maxdexter.mvpmoxy.di.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.di.dagger.app.App;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {
    @Inject
    Green mGreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        App.getAppComponent().inject(DaggerActivity.this);

        Red red = new Red();
        White white = new White();

    }

}