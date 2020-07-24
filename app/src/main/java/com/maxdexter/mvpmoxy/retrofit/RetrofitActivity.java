package com.maxdexter.mvpmoxy.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.maxdexter.mvpmoxy.R;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    private LoadData mLoadData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mLoadData = new LoadData();
    }

    public void getPhoto() {
        String url;
        Observable<User> single = mLoadData.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(obj -> {
             obj.getAvatarUrl();
        }, throwable -> {
            Log.e(TAG, "onError");
        });
    }

    public void onClickButton(View view){
        Glide
                .with(this)
                .load("https://avatars0.githubusercontent.com/u/66577?v=4")
                .into();
    }

}