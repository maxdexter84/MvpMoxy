package com.maxdexter.mvpmoxy.di.diActivity;

import android.util.Log;

public class Red {
    private static final String TAG = "tag";

    public Red() {
        Green green = new Green();
        Log.d(TAG,green.getGreen() + " " + green.toString());
    }
}
