package com.maxdexter.mvpmoxy.retrofit;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("/users/JakeWharton")
    Observable<User> getUser();
}
