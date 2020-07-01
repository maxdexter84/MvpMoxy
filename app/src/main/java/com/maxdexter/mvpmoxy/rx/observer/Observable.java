package com.maxdexter.mvpmoxy.rx.observer;

import com.maxdexter.mvpmoxy.rx.observer.Observer;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void spam();
}
