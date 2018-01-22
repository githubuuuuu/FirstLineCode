package com.example.a6datastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class FilePersistenceActivity extends AppCompatActivity {

    private EditText editText_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filepersistence_layout);
        editText_1 = (EditText) findViewById(R.id.EditText_FP1);

    }
}
