package com.maxdexter.mvpmoxy.rx.observer;

import android.util.Log;

public class Client implements Observer {
    private static final String TAG = "tag";
    String mail;
    int num;
    public Client(int num){
        this.num = num;
    }
    @Override
    public void mailUpdate(String mail) {
        this.mail = mail;
        Log.d(TAG,mail + " " + "Client " + num);
    }
}
