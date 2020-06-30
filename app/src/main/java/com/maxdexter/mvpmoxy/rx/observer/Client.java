package com.maxdexter.mvpmoxy.rx.observer;

public class Client implements Observer {
    String name;
    int num;
    @Override
    public void nameId(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
