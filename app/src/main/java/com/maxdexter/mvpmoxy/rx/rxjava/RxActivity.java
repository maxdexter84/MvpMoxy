package com.maxdexter.mvpmoxy.rx.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;

public class RxActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    Button subscribeRx;
    Button unsubscribeRx;
    Observable<String> observable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        subscribeRx = findViewById(R.id.subscribeRx);
        unsubscribeRx = findViewById(R.id.unsubscribeRx);
        observable = Observable.create(emitter -> {
            try{
                List<String> spamList = new ArrayList<>();
                spamList.add("Spam 1");
                spamList.add("Spam 2");
                spamList.add("Spam 3");
                for (String str:spamList) {
                    emitter.onNext(str);
                }
                emitter.onComplete();
            }catch (Exception e){
                emitter.onError(e);
            }

        });
        subscribeRx.setOnClickListener(v -> {
            Observer<String> observer = new Observer<String>() {
                @Override
                public void onSubscribe(Disposable d) {
                    
                }
                @Override
                public void onNext(String s) {
                    Log.d(TAG,s);
                }

                @Override
                public void onError(Throwable e) {
                    Log.d(TAG,e.getMessage());
                }

                @Override
                public void onComplete() {

                }
            };
            observable.subscribe(observer);

        });


    }
}