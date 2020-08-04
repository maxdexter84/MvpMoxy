package com.maxdexter.mvpmoxy.di.dagger;

import android.util.Log;

import com.maxdexter.mvpmoxy.di.dagger.app.App;

import javax.inject.Inject;

public class Red {
    private static final String TAG = "tag";
    @Inject
    Green mGreen;

    public Red() {
        App.getAppComponent().inject(this);
        Log.d(TAG,"Red class " + mGreen.getGreen() + " " + mGreen.toString());
    }
}
