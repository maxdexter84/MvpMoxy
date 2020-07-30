package com.maxdexter.mvpmoxy.di.diActivity;

import android.util.Log;

public class White {

    private static final String TAG = "tag";

    public White() {
        Green green = new Green();
        Log.d(TAG,green.getGreen() + " " + green.toString());
    }
}
