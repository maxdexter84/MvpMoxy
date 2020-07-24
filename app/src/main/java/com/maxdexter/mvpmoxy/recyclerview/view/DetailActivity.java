package com.maxdexter.mvpmoxy.recyclerview.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.maxdexter.mvpmoxy.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    public Intent newInstance(){
        Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
        startActivity(intent);
        return intent;
    }
}