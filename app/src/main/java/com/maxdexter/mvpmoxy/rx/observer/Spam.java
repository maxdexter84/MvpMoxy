package com.maxdexter.mvpmoxy.rx.observer;
import com.maxdexter.mvpmoxy.rx.observer.Observer;
import java.util.ArrayList;
import java.util.List;


public class Spam implements Observable{
    List<Observer> list;

    public Spam(){
        list = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void spam() {
        for (Observer o:list) {
            o.mailUpdate("Thread " + Thread.currentThread().getName());
        }
    }
}
