package com.maxdexter.mvpmoxy.rx.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;

public class ObserverActivity extends AppCompatActivity {
    private Button subscribe;
    private Button spam;
    private Button unsubscribe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
    }
}