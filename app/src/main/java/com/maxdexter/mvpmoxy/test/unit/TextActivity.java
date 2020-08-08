package com.maxdexter.mvpmoxy.test.unit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maxdexter.mvpmoxy.R;
import com.squareup.leakcanary.LeakCanary;

public class TextActivity extends AppCompatActivity {
    Button mButton;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        mButton = findViewById(R.id.text_button);
        mTextView = findViewById(R.id.tv_text_activity);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("TextView");
            }
        });
    }


}