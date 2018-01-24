package com.example.sqlitestorage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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
        // Insert data to Database table
        Button insertData = (Button) findViewById(R.id.Button_DS3);
        insertData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // Start assembly first data.
                values.put("name", "The Frist Line code");
                values.put("author", "GuoLin");
                values.put("price", 40.00);
                values.put("pages", 300);
                db.insert("Book", null, values);
                values.clear();
                // assembly second data.
                values.put("name", "JAVA 入门");
                values.put("author", "xxxx.xxx");
                values.put("price", 50.00);
                values.put("pages", 400);
                db.insert("Book", null, values);
            }
        });

        Button updateData = (Button) findViewById(R.id.Button_DS4);
        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // data
                values.put("name", "The First Line Code");
                db.update("Book", values, "price = ?", new String[]{"40.00"});
                values.clear();
                // data 2
                values.put("name", "JAVA 入门");
                db.update("Book", values, "author = ?", new String[]{"xxxx.xxx"});
            }
        });

        // Delete Data from Table "Book".
        Button deleteData = (Button) findViewById(R.id.Button_DS5);
        deleteData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // 删除超过380页的书籍数据. "pages > ?"
                db.delete("Book", "pages > ?", new String[]{"380"});
            }
        });

        Button retrieveData = (Button) findViewById(R.id.Button_DS6);
        retrieveData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // step 1 :
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // step 2 :
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                // step 3 :
                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        Log.d("DataSQLiteActivity", "Book id is     " + id);
                        Log.d("DataSQLiteActivity", "Book author is " + author);
                        Log.d("DataSQLiteActivity", "Book price is  " + price);
                        Log.d("DataSQLiteActivity", "Book pages is  " + pages);
                        Log.d("DataSQLiteActivity", "Book name is   " + name);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });

    }
}
