package com.maxdexter.mvpmoxy.presenter;


import com.maxdexter.mvpmoxy.model.TextModel;
import com.maxdexter.mvpmoxy.view.ContractView;

public class MainActivityPresenter {
    TextModel mTextModel;
    ContractView mContractView;

   public MainActivityPresenter(ContractView contractView){
       this.mContractView = contractView;
       mTextModel = new TextModel();
   }
   public void clickButton(){
       String oldText = mTextModel.getText();
       String newText = mContractView.getText();
       String finalText = oldText + newText;
       mTextModel.setText(finalText);
       mContractView.setText(finalText);
   }

}
