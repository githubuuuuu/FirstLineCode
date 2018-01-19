package com.example.activitylifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);
        ActivityCollector.addActivity(this);
//        Button
        Button btn1 = (Button) findViewById(R.id.Button_N1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.actionStart1(NormalActivity.this, "s1", "s2");
            }
        });
    }

    //    Intent with ACTION register in AndroidManifest.xml
    public static void actionStart1(Context context, String str1, String str2) {
        Intent intent = new Intent("com.example.activitylifecycle.NORMAL_ACTION");
        intent.putExtra("param1", str1);
        intent.putExtra("param2", str2);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
