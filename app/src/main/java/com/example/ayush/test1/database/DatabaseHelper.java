package com.example.ayush.test1.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ayush.test1.AppMain;
import com.example.ayush.test1.Product;
/**
 * Author: Turtuvshin Byambaa.
 * Project: Safety Inst
 * URL: https://www.github.com/tortuvshin
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int    DATABASE_VERSION = 34;
    private static final String DATABASE_NAME    = "safety.db";

    public DatabaseHelper() {
        super(AppMain.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(ProductTable.create());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Product.TABLE_PRODUCTS);
        onCreate(db);
    }
}