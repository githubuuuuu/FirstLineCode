package com.example.a6datastorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferencesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sharedpreferences_layout);

        final EditText editText_1 = (EditText) findViewById(R.id.EditText_SP1);
        final EditText editText_2 = (EditText) findViewById(R.id.EditText_SP2);
        final EditText editText_3 = (EditText) findViewById(R.id.EditText_SP3);

        Button button_1 = (Button) findViewById(R.id.Button_SP1);
        button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = editText_1.getText().toString();
                int age = 18;
                Boolean married;
                // st1 需要检查输入值是否为数字，当输入的值无效时，给出提示。
                String st1 = editText_2.getText().toString();
                String st2 = editText_3.getText().toString();
                if (st1 != null && st1.length() > 0) {
                    age = Integer.parseInt(st1);
                }
                if (st2.equals("YES")){
                    married = true;
                } else married = false;
                save(name, age, married);
            }
        });

        Button button_2 = (Button) findViewById(R.id.Button_SP2);
        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences pre = getSharedPreferences("data", MODE_PRIVATE);
                editText_1.setText(pre.getString("name", "UserID"));
                editText_2.setText(pre.getInt("age", 18));
                Boolean bl = pre.getBoolean("married", false);
                String st1;
                if (bl) {
                    st1 = "YES";
                } else st1 = "NO";
                editText_3.setText(st1);
            }
        });
    }

    public void save(String name, int age, Boolean married) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.putInt("age", age);
        editor.putBoolean("married", married);
        editor.apply();
    }

}
