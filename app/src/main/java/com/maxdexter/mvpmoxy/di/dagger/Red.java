package com.maxdexter.mvpmoxy.di.dagger;

import android.util.Log;

public class Red {
    private static final String TAG = "tag";
    Green mGreen;

    public Red(Green green) {
        this.mGreen = green;
        Log.d(TAG,mGreen.getGreen() + " " + mGreen.toString());
    }
}
