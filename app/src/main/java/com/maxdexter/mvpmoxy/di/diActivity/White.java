package com.maxdexter.mvpmoxy.di.diActivity;

import android.util.Log;

public class White {

    private static final String TAG = "tag";
    Green mGreen;

    public White(Green green) {
        this.mGreen = green;
        Log.d(TAG,mGreen.getGreen() + " " + mGreen.toString());
    }
}
