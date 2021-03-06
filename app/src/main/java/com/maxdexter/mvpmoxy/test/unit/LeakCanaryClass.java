package com.maxdexter.mvpmoxy.test.unit;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class LeakCanaryClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
