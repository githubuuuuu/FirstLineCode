package com.example.activityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.FirstActivity_title_name);
        setContentView(R.layout.first_layout);
        // Android.widget.Button
        Button btn11 = (Button) findViewById(R.id.Button_11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, R.string.Button_11,  Toast.LENGTH_SHORT).show();
            }
        });
        // start second activity : Intent constructor
        Button btn12 = (Button) findViewById(R.id.Button_12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.addCategory("com.example.activityintent.SECOND_CATEGORY");  // 直接传递类时无效
                startActivity(intent);
            }
        });
        // start third activity : Intent another constructor
        Button btn13 = (Button) findViewById(R.id.Button_13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activityintent.THIRD_ACTION");
                intent.addCategory("com.example.activityintent.THIRD_CATEGORY");  // 间接传递自定义action时有效
//                startActivity(intent);
                startActivityForResult(intent, 1);  // 期望被启动Activity(B) 销毁时返回一个结果给启动他(B)的Activity(A).
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnData);
                }
                break;
            default:
        }
    }
}
