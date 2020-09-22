package com.rohisnatardev.ichwan.appprojectplanb.Monitor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "DataMonitor", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "create table TableMonitor(xValue INTEGER,yValue INTEGER)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(long valX, int valY){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("xValue", valX);
        values.put("yValue", valY);

        database.insert("TableMonitor",null,values);
    }

    public void deleteData(){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("TableMonitor",null,null);
    }
}
