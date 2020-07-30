package com.maxdexter.mvpmoxy.di.dagger.app;

import android.app.Application;

public class App extends Application {
     static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static   AppComponent getAppComponent() {

        return sAppComponent;
    }

}
