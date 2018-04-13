package com.example.chenkeyu.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is "+getTaskId());
        setContentView(R.layout.second_layout);

        //获取FirstActivity传递的信息
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Toast.makeText(SecondActivity.this,data,Toast.LENGTH_SHORT).show();
        Log.d("SecondActivity",data);

        //点击按钮2，销毁当前Activity，并将消息回传给FirstActivity
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();  //销毁当前Activity
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }
}
