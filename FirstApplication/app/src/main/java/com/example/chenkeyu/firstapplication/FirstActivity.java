package com.example.chenkeyu.firstapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task Id is "+getTaskId());
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //隐式的启动SecondActivity
                /*Intent intent = new Intent("com.example.chenkeyu.firstapplication.ACTION_START");
                intent.addCategory("com.example.chenkeyu.firstapplication.MY_CATEGORY");*/

                //点击按钮启动其他程序
                /*Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086")); */   //将字符串通过Uri.parse()方法解析成一个Uri对象，在通过setData()方法传递出去

                //传递消息给SecondActivity
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivityForResult(intent,1); //SecondActivity被销毁后，回传消息给FirstActivity
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){       //构建菜单
        getMenuInflater().inflate(R.menu.main,menu);
        return true;                                     //返回true表示菜单栏可见
    }

    //重写onOptionsItemSelected方法，判断是菜单栏哪个被选中，并触发不同行为
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_item :
                Toast.makeText(this, "You Clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item :
                Toast.makeText(this, "You Clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    //重写onActivityResult方法，通过requestCode判断是哪个Activity返回的消息，并触发不同行为
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Toast.makeText(FirstActivity.this,returnedData,Toast.LENGTH_SHORT).show();
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }
}
