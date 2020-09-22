package com.rohisnatardev.ichwan.appprojectplanb.Quran;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AssetDatabaseOpenHelper {
    private String DB_NAME = "";

    private Context context;

    public AssetDatabaseOpenHelper(String db_name, Context context) {
        this.DB_NAME = db_name;
        this.context = context;
    }

    public SQLiteDatabase openDatabase(){
        File dbFile = context.getDatabasePath(DB_NAME);
        File parent = dbFile.getParentFile();
        if (!parent.exists()) parent.mkdirs();
        if (!dbFile.exists()){
            try {
                copyData(dbFile);
            }catch (IOException e){
                throw new RuntimeException("Error membuat sumber database",e);
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READONLY);
    }

    private void copyData(File dbFile) throws IOException {
        InputStream inputStream = context.getAssets().open(DB_NAME);
        OutputStream outputStream = new FileOutputStream(dbFile);

        byte[] buffer = new byte[1024];
        while (inputStream.read(buffer) > 0){
            outputStream.write(buffer);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
