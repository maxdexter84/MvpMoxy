package com.maxdexter.mvpmoxy.rx.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.CleartextNetworkViolation;
import android.view.View;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;

public class ObserverActivity extends AppCompatActivity {
    private Button subscribe;
    private Button spamButton;
    private Button unsubscribe;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        subscribe = findViewById(R.id.subscribe);
        spamButton = findViewById(R.id.spam);
        unsubscribe = findViewById(R.id.unsubscribe);
        final Spam spam = new Spam();

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x +=1;
                Client client = new Client(x);
                spam.registerObserver(client);
            }
        });

        unsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Observer observer = spam.list.get(0);
                spam.unregisterObserver(observer);
            }
        });

        spamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spam.spam();
            }
        });
    }
}