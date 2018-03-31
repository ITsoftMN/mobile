package com.example.ayush.test1;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.example.ayush.test1.database.DatabaseHelper;
import com.example.ayush.test1.database.DatabaseManager;

public class AppMain extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        DatabaseHelper dbHelper = new DatabaseHelper();
        DatabaseManager.initializeInstance(dbHelper);
    }

    public static Context getContext(){
        return context;
    }
}