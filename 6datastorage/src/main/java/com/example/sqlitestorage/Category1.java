package com.example.sqlitestorage;

import org.litepal.crud.DataSupport;

/**
 * Created by W on 2018/1/24.
 * table category1 : id, categoryName, categoryCode
 */

public class Category1 extends DataSupport{
    private int id;
    private String categoryName;
    private String categoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
