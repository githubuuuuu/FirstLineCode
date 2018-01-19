package com.example.activityintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        // Button
        Button btn31 = (Button) findViewById(R.id.Button_31);
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activityintent.WEBVIEW_ACTION");
                intent.putExtra("url_data","http://10y.top");
                startActivity(intent);
            }
        });
        // Destroy activity
        Button btn32 = (Button) findViewById(R.id.Button_32);
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Report: I destroyed myself!");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
//    重写点击返回键销毁当前Activity的方法。向启动当前Activity的上一Activity返回一个传递数据的Intnet
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Report: I destroyed myself!");
        setResult(RESULT_OK, intent);
        finish();
    }
}
