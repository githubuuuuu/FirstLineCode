package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BasicActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Logcat
//        Log.d("MainActivity", getClass().getSimpleName());
        Log.d(TAG, "onCreate()");

        setContentView(R.layout.main_layout);
        setTitle(R.string.MainActivity_name);
//        "Activity" 启动时加入“活动”管理器
        ActivityCollector.addActivity(this);
//        Button
        Button btn1 = (Button) findViewById(R.id.Button_11);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.actionStart(MainActivity.this, "stringData1", "stringData2");
            }
        });
        Button btn2 = (Button) findViewById(R.id.Button_12);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.actionStart1(MainActivity.this, "stringData3", "stringData4");
            }
        });
        Button btn3 = (Button) findViewById(R.id.Button_13);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NormalActivity.actionStart1(MainActivity.this, "str1", "str2");
            }
        });
        Button btn4 = (Button) findViewById(R.id.Button_14);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity.actionStart1(MainActivity.this, "str1", "str2");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
