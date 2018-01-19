package com.example.activityintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        // Button
        Button btn21 = (Button) findViewById(R.id.Button_21);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Intent.ACTION_VIEW ；打开网页
        Button btn22 = (Button) findViewById(R.id.Button_22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://10y.top"));
                startActivity(intent);
            }
        });
        // Intent.ACTION_DIAL ; 拨打电话
        Button btn23 = (Button) findViewById(R.id.Button_23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        // Intent.ACTION_VIEW ; 显示地理位置
        Button btn24 = (Button) findViewById(R.id.Button_24);
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:38.899533,-77.036476"));
                startActivity(intent);
            }
        });
    }
}
