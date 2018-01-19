package com.example.activitylifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        ActivityCollector.addActivity(this);

//        Button
        Button btn21 = (Button) findViewById(R.id.Button_21);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAllActivity();
            }
        });
    }
//    Intent with Class.class
    public static void actionStart(Context context, String str1, String str2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", str1);
        intent.putExtra("param2", str2);
        context.startActivity(intent);
    }
//    Intent with ACTION register in AndroidManifest.xml
    public static void actionStart1(Context context, String str1, String str2){
        Intent intent = new Intent("com.example.activitylifecycle.SECOND_ACTION");
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
