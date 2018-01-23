package com.example.sqlitestorage;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a6datastorage.BaseActivity;
import com.example.a6datastorage.R;

public class DataSQLiteActivity extends BaseActivity {

    private  MySQLiteOpenHelper dbHelper;
    // Database table field: id, author, price, pages, name
    public static final String CREATE_BOOK_CATEGORY = "create table BookCategory ("
            + "id integer primary key autoincrement, "
            + "category_name text, "
            + "category_code integer)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datasqlite_layout);

        dbHelper = new MySQLiteOpenHelper(this, "BookStore.db", null, 1);

        Button createDatabase = (Button) findViewById(R.id.Button_DS1);
        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();

            }
        });

        Button updateDatabase = (Button) findViewById(R.id.Button_DS2);
        updateDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL(CREATE_BOOK_CATEGORY);

            }
        });

        Button createData = (Button) findViewById(R.id.Button_DS3);
        createData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        Button updateData = (Button) findViewById(R.id.Button_DS4);
        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        Button deleteData = (Button) findViewById(R.id.Button_DS5);
        deleteData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        Button retrieveData = (Button) findViewById(R.id.Button_DS6);
        retrieveData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

    }
}
