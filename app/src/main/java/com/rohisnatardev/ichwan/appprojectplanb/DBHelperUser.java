package com.rohisnatardev.ichwan.appprojectplanb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperUser extends SQLiteOpenHelper {
    public static final String DB_NAME = "user.db";
    public static final int DB_VERSI = 1;

    public DBHelperUser(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSI);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String USER_TABLE = "CREATE TABLE " +
                Contract.UserEntry.TABLE_NAME + " (" +
                Contract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.UserEntry.NAME_COLUMN + " TEXT NOT NULL, " +
                Contract.UserEntry.TIMESTAMP_COLUMN + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" + ");";
        sqLiteDatabase.execSQL(USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Contract.UserEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
