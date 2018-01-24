package com.example.sqlitestorage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.a6datastorage.BaseActivity;
import com.example.a6datastorage.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LitepalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.litepal_layout);

        Button createDatabase = (Button) findViewById(R.id.Button_LA1);
        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // litepal
                Connector.getDatabase();
            }
        });

        Button insertData = (Button) findViewById(R.id.Button_LA2);
        insertData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Book1 book1 = new Book1();
                // table "book1": int id; String author; double price; int pages; String name; String press;
                book1.setAuthor("GuoLin");
                book1.setPrice(20.00);
                book1.setPages(200);
                book1.setName("The First Line Code");
                book1.setPress("中国人民出版社");
                book1.save();
            }
        });
        Button updateData = (Button) findViewById(R.id.Button_LA3);
        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Book1 book1 = new Book1();
                book1.setAuthor("ZhangSan");
                book1.setName("JAVA 入门");
                book1.updateAll("id =?", "1");
            }
        });

        Button deleteData = (Button) findViewById(R.id.Button_LA4);
        deleteData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book1.class, "author = ?", "GuoLin");
            }
        });

        Button queryData = (Button) findViewById(R.id.Button_LA5);
        queryData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                List<Book1> book1s = DataSupport.findAll(Book1.class);
                // java 增强的for循环（泛型）写法.
                for (Book1 book1 : book1s) {
                    Log.d("LitepalActivity", "book id is      : " + book1.getId());
                    Log.d("LitepalActivity", "book name is    : " + book1.getName());
                    Log.d("LitepalActivity", "book author is  : " + book1.getAuthor());
                    Log.d("LitepalActivity", "book price is   : " + book1.getPrice());
                    Log.d("LitepalActivity", "book pages is   : " + book1.getPages());
                    Log.d("LitepalActivity", "book press is   : " + book1.getPress());

                }
            }
        });

    }
}
