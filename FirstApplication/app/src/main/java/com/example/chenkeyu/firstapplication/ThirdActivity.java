package com.example.chenkeyu.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity","Task id is "+getTaskId());
        setContentView(R.layout.third_layout);
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ThirdActivity","onDestroy");
    }
}
