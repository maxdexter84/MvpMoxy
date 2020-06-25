package com.maxdexter.mvpmoxy.moxy.presenter;


import com.maxdexter.mvpmoxy.moxy.model.TextModel;
import com.maxdexter.mvpmoxy.moxy.view.ContractView;

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
