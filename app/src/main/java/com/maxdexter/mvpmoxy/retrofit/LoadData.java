package com.maxdexter.mvpmoxy.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class LoadData {
    private static Retrofit sRetrofit;

    public static Retrofit getRetrofit(){
        if(sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static Api getApi() {

    }
}
