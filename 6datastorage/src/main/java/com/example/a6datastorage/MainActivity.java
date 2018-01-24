package com.example.a6datastorage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

//    private EditText edit_M1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        setTitle(R.string.MainActivity_TitleLabel);

        Button button_M1 = (Button) findViewById(R.id.Button_M1);
        button_M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.a6datastorage.FILEPERSISTENCE_ACTION");
                startActivity(intent);
            }
        });

        Button button_M2 = (Button) findViewById(R.id.Button_M2);
        button_M2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.a6datastorage.SHAREDPREFERENCES_ACTION");
                startActivity(intent);
            }
        });

        Button button_M3 = (Button) findViewById(R.id.Button_M3);
        button_M3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.sqlitestorage.DATASQLITE_ACTION");
                startActivity(intent);
            }
        });

        Button button_M4 = (Button) findViewById(R.id.Button_M4);
        button_M4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.sqlitestorage.LITEPAL_ACTION");
                startActivity(intent);
            }
        });

//        edit_M1 = (EditText) findViewById(R.id.EditText_M1);


    }
}
