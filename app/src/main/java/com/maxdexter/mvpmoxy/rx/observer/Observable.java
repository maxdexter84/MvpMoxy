package com.maxdexter.mvpmoxy.rx.observer;

import java.util.Observer;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void spam();
}
