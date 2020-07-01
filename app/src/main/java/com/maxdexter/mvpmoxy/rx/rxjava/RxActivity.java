package com.maxdexter.mvpmoxy.rx.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;
import java.util.concurrent.TimeUnit;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
public class RxActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    Button subscribeRx;
    Button unsubscribeRx;
    Observable<Long> observable;
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
          mDispose = observable.subscribe(s -> Log.d(TAG,s + " spam"),
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
        observable = Observable.interval(500, TimeUnit.MILLISECONDS);

    }
}