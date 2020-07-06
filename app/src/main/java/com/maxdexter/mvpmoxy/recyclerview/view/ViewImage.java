package com.maxdexter.mvpmoxy.recyclerview.view;

import android.graphics.Bitmap;

import moxy.MvpView;

public interface ViewImage extends MvpView {
    void setImage(Bitmap bitmap);
}
