package com.maxdexter.mvpmoxy.di.dagger;

import android.util.Log;

import com.maxdexter.mvpmoxy.di.dagger.app.App;

import javax.inject.Inject;

public class White {

    private static final String TAG = "tag";
    @Inject
    Green mGreen;

    public White() {
        App.getAppComponent().inject(this);
        Log.d(TAG,"White class " + mGreen.getGreen() + " " + mGreen.toString());
    }
}
