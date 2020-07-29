package com.maxdexter.mvpmoxy.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.maxdexter.mvpmoxy.R;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    AppCompatImageView mImageView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        mImageView = findViewById(R.id.image_user);
        mButton = findViewById(R.id.photo_load);
        clickButton();
    }

    private void clickButton() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhoto();

            }
        });
    }

    public void getPhoto() {
        Observable<User> single = LoadData.getInstance().requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(obj -> {
            Glide
                    .with(getApplicationContext())
                    .load(obj.getAvatarUrl())
                    .into(mImageView);
        }, throwable -> {
            Log.e(TAG, "onError" + throwable);
        });
    }



}