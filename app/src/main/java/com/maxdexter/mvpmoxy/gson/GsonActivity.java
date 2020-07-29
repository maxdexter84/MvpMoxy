package com.maxdexter.mvpmoxy.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.maxdexter.mvpmoxy.R;

public class GsonActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    Gson mGson;
    Time time;
    Button mButton;
    TextView tOfY;
    TextView year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        iniView();
        String json = "{\"time_of_year\": \"summer\", \"year\": 2019}";
        pushButton(json);
    }

    private void pushButton(String json) {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJson(json);
            }
        });
    }

    private void parseJson(String json) {
        mGson = new Gson();
        time = mGson.fromJson(json, Time.class);
        tOfY.setText(time.time_of_year);
        year.setText("" + time.year);
        Log.d(TAG,time.time_of_year);
        Log.d(TAG," " + time.year);
    }

    private void iniView() {
        tOfY = findViewById(R.id.time_of_year);
        year = findViewById(R.id.year);
        mButton = findViewById(R.id.button);
    }
}