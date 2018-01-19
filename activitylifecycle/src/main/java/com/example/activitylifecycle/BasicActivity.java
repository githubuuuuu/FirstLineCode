package com.example.activitylifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by H on 2017/12/28.
 *
 */

public class BasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        logcat : print current Instance's class name
        Log.d("BasicActivity", getClass().getSimpleName());

    }
}
