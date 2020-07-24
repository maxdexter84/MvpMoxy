package com.maxdexter.mvpmoxy.rx.single;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maxdexter.mvpmoxy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
public class SingleActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    @BindView(R.id.push)
    Button mButton;
    Model model;
    Disposable mDisposable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        ButterKnife.bind(this);
        model = new Model();
    }



    @OnClick(R.id.push)
    public void onClick(){
        Disposable d = model.single.subscribeWith(new DisposableSingleObserver<String>() {
            @Override
            public void onSuccess(String s) {
                Log.d(TAG,s);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
        d.dispose();
    }
}
