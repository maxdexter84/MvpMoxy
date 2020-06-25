package com.maxdexter.mvpmoxy.moxy.presenter;


import com.maxdexter.mvpmoxy.moxy.model.TextModel;
import com.maxdexter.mvpmoxy.moxy.view.ContractView;
import com.maxdexter.mvpmoxy.moxy.view.MainActivitySecond;

import moxy.InjectViewState;
import moxy.MvpPresenter;
@InjectViewState
public class MainActivityPresenter extends MvpPresenter<ContractView> {
    TextModel mTextModel;


   public MainActivityPresenter(){
       mTextModel = new TextModel();
   }
   public void clickButton(String text){
       String oldText = mTextModel.getText();
       String newText = text;
       String finalText = oldText + newText;
       mTextModel.setText(finalText);
       getViewState().setText(finalText);
   }
public void setText(String text){
       mTextModel.setText(text);
}
}
