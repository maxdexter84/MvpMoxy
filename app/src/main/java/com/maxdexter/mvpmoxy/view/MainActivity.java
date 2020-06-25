package com.maxdexter.mvpmoxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.maxdexter.mvpmoxy.R;


public class MainActivity extends AppCompatActivity implements ContractView{

    EditText mEditText;
    Button mButton;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditText = findViewById(R.id.edit_text);
        mButton = findViewById(R.id.set_text_button);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    public String getText() {
       String newText =  mEditText.getText().toString();
       return newText;
    }



    @Override
    public void setText(String text) {
        mTextView.setText(text);
    }
}