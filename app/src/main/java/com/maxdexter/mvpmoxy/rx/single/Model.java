package com.maxdexter.mvpmoxy.rx.single;
import io.reactivex.*;
public class Model {
    private String mail = "spam";
    Single<String> single;
    public Model(){
        single = Single.just(mail);
    }
}
