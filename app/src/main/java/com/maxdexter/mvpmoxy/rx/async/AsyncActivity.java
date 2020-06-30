package com.maxdexter.mvpmoxy.rx.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.maxdexter.mvpmoxy.R;

import java.util.concurrent.TimeUnit;

public class AsyncActivity extends AppCompatActivity {
    private static final String TAG = "tag" ;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        mButton = findViewById(R.id.async_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsync myAsync = new MyAsync();
                myAsync.execute();
                Log.d(TAG,"onClick завершен ");
            }
        });
    }


    public class MyAsync extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG,Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}