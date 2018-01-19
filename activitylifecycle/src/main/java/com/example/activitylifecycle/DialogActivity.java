package com.example.activitylifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DialogActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        ActivityCollector.addActivity(this);
    }
    //    Intent with Class.class
    public static void actionStart(Context context, String str1, String str2){
        Intent intent = new Intent(context, DialogActivity.class);
        intent.putExtra("param1", str1);
        intent.putExtra("param2", str2);
        context.startActivity(intent);
    }
    //    Intent with ACTION register in AndroidManifest.xml
    public static void actionStart1(Context context, String str1, String str2) {
        Intent intent = new Intent("com.example.activitylifecycle.DIALOG_ACTION");
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
