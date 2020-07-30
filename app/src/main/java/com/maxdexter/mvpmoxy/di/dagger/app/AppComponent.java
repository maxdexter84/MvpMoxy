package com.maxdexter.mvpmoxy.di.dagger.app;

import com.maxdexter.mvpmoxy.di.dagger.DaggerActivity;
import com.maxdexter.mvpmoxy.di.dagger.Red;
import com.maxdexter.mvpmoxy.di.dagger.White;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
   void inject(DaggerActivity daggerActivity);
   void inject(Red red);
   void inject(White white);
}
