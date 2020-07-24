package com.maxdexter.mvpmoxy.rx.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
public class RxActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    @BindView(R.id.subscribeRx)
    Button subscribeRx;
    @BindView(R.id.unsubscribeRx)
    Button unsubscribeRx;
    Observable<Long> observable;
    Disposable mDispose;
    Observer<String> observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);

        initObservable();
    }



    private void initObservable() {
        observable = Observable.interval(500, TimeUnit.MILLISECONDS);

    }

    @OnClick(R.id.subscribeRx)
    void onSubscribe(){
        mDispose = observable.subscribe(s -> Log.d(TAG,s + " spam"),
                t-> Log.d(TAG,t.getMessage()),
                ()-> Log.d(TAG,"Поток данных закончился")
        );


    }
    @OnClick(R.id.unsubscribeRx)
    void onUnSubscribe(){
        mDispose.dispose();
        if(mDispose.isDisposed()){
            Log.d(TAG, "Вы отписались от спама");
        }
    }}