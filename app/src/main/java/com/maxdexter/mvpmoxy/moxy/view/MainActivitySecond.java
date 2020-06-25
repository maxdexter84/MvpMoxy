package com.maxdexter.mvpmoxy.moxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.maxdexter.mvpmoxy.R;
import com.maxdexter.mvpmoxy.moxy.presenter.MainActivityPresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;


public class MainActivitySecond extends MvpAppCompatActivity implements ContractView {

    EditText mEditText;
    Button mButton;
    TextView mTextView;
    @InjectPresenter
    MainActivityPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String newText =  mEditText.getText().toString();
                mPresenter.clickButton(newText);
                mEditText.getText().clear();
            }
        });
    }

    private void initView() {
        mEditText = findViewById(R.id.edit_text);
        mButton = findViewById(R.id.set_text_button);
        mTextView = findViewById(R.id.textView);
    }






    @Override
    public void setText(String text) {
        mTextView.setText(text);
    }
}