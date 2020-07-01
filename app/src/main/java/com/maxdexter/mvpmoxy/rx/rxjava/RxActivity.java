package com.maxdexter.mvpmoxy.rx.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    Button subscribeRx;
    Button unsubscribeRx;
    Observable<String> observable;
    Disposable mDispose;
    Observer<String> observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        subscribeRx = findViewById(R.id.subscribeRx);
        unsubscribeRx = findViewById(R.id.unsubscribeRx);

        initObservable();
        subscribeRx.setOnClickListener(v -> {
          mDispose = observable.subscribe(s -> Log.d(TAG,s),
                  t-> Log.d(TAG,t.getMessage()),
                  ()-> Log.d(TAG,"Поток данных закончился")
                  );

        });

        unsubscribeRx.setOnClickListener(v -> {
            mDispose.dispose();
            if(mDispose.isDisposed()){
                Log.d(TAG, "Вы отписались от спама");
            }
        });



    }



    private void initObservable() {
        List<String> spamList = Arrays.asList("Spam 1", "Spam 2","Spam 3");
        observable = Observable.fromIterable(spamList);
    }
}