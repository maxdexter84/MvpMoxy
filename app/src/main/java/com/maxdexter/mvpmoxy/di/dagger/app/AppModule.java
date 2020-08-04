package com.maxdexter.mvpmoxy.di.dagger.app;

import android.app.Application;

import com.maxdexter.mvpmoxy.di.dagger.Green;
import com.maxdexter.mvpmoxy.di.dagger.Red;
import com.maxdexter.mvpmoxy.di.dagger.White;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }


    @Singleton
    @Provides
    Green provideGreen() {
        return new Green();
    }

}
