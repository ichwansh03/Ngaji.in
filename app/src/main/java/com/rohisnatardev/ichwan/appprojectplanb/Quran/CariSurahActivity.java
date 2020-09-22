package com.rohisnatardev.ichwan.appprojectplanb.Quran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CariSurahActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_surah);

        db = new AssetDatabaseOpenHelper("quran.db", CariSurahActivity.this).openDatabase();
        final Spinner surat = findViewById(R.id.surah);
        final Spinner ayat = findViewById(R.id.ayat);
        final TextView arab = findViewById(R.id.arabic);
        final TextView idsurah = findViewById(R.id.surahnayat);
        final TextView terjemah = findViewById(R.id.terjemahan);
        final LinearLayout target = findViewById(R.id.target);


        surat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int item1, long item2) {

                int pos = adapterView.getSelectedItemPosition();
                Cursor cursor = db.rawQuery("SELECT ayat FROM quran WHERE surat=" + (pos + 1),null);
                List<String> list = new ArrayList<String>();
                cursor.moveToFirst();

                for (int i = 0; i < cursor.getCount(); i++){
                    cursor.moveToPosition(i);
                    list.add(cursor.getString(cursor.getColumnIndex("ayat")));
                }

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(CariSurahActivity.this, android.R.layout.simple_spinner_item,list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ayat.setAdapter(dataAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ayat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int a1, long a2) {
                int pos = adapterView.getSelectedItemPosition();
                Cursor cur = db.rawQuery("SELECT text, terjemah FROM quran WHERE surat=" + (surat.getSelectedItemPosition() + 1) + " AND ayat=" + (pos + 1), null);
                cur.moveToFirst();

                String text = cur.getString(cur.getColumnIndex("text"));

                if (pos == 0 & surat.getSelectedItemPosition() != 0) text = text.substring(38);
                arab.setText(text);
                terjemah.setText("\"" + cur.getString(cur.getColumnIndex("terjemah")) + "\"");
                idsurah.setText("Surah "+surat.getSelectedItem()+" Ayat "+ayat.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        findViewById(R.id.savebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Save().execute(target, ayat, surat);
            }
        });

        int myVersion = Build.VERSION.SDK_INT;
        if (myVersion > Build.VERSION_CODES.LOLLIPOP_MR1){
            if (!checkIfPermission()){
                requestSpesific();
            }
        }
    }

    private boolean checkIfPermission(){
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestSpesific(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 101){

        }else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public static Bitmap getBitmapFromView(View view){
        Bitmap returnedBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(),view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    private class Save extends AsyncTask<Object, Void, Boolean> {
        File f;

        @SuppressLint("WrongThread")
        @Override
        protected Boolean doInBackground(Object[] p1) {
            LinearLayout target = (LinearLayout) p1[0];
            Spinner ayat = (Spinner) p1[1];
            Spinner surat = (Spinner) p1[2];

            f = new File(Environment.getExternalStorageDirectory()
            + "/quran-" + surat.getSelectedItemPosition() + "_" + ayat.getSelectedItemPosition() + ".png");

            if (f.exists()) f.delete();

            try {
                FileOutputStream outputStream = new FileOutputStream(f);
                getBitmapFromView(target).compress(Bitmap.CompressFormat.PNG, 10, outputStream);
                target.setDrawingCacheEnabled(false);
                return true;
            } catch (FileNotFoundException e){
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            if (aBoolean){
                Toast.makeText(CariSurahActivity.this, "Save in " + f.getPath(), Toast.LENGTH_LONG).show();
            } else Toast.makeText(CariSurahActivity.this, " Save failed", Toast.LENGTH_LONG).show();
            super.onPostExecute(aBoolean);
        }
    }
}
