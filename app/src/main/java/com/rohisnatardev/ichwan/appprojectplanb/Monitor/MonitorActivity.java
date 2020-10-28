package com.rohisnatardev.ichwan.appprojectplanb.Monitor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorActivity extends AppCompatActivity implements DatePickerListener {

    CardView btninput, btnhapus, btninfo;
    EditText editData;
    GraphView graphView;

    DatabaseHandler dbh;
    SQLiteDatabase sqLiteDatabase;

    LineGraphSeries<DataPoint> dataseries = new LineGraphSeries<>(new DataPoint[0]);

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        HorizontalPicker picker = findViewById(R.id.datePicker);
        picker.setListener(this)
                .setDays(120)
                .setOffset(7)
                .setDateSelectedColor(getResources().getColor(R.color.colorPrimary))
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.DKGRAY)
                .setTodayButtonTextColor(getResources().getColor(R.color.colorPrimary))
                .setTodayDateTextColor(getResources().getColor(R.color.colorPrimary))
                .showTodayButton(false)
                .init();

        picker.setBackgroundColor(Color.WHITE);
        picker.setDate(new DateTime());

        editData = findViewById(R.id.edtData);
        btninput = findViewById(R.id.cv_inputdata);

        btnhapus = findViewById(R.id.cv_resetdata);
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MonitorActivity.this);
                builder.setTitle("Hapus Data");
                builder.setMessage("Apakah anda yakin ingin menghapus semua data pada grafik?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        removeData();
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btninfo = findViewById(R.id.cv_helpdata);
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AskMonitorFragment fragment = new AskMonitorFragment();
                fragment.show(getSupportFragmentManager(),"FragmentAsk");
            }
        });
        graphView = findViewById(R.id.line_chart);

        dbh = new DatabaseHandler(this);
        sqLiteDatabase = dbh.getWritableDatabase();

        insertdatagraph();

        graphView.addSeries(dataseries);
        graphView.getGridLabelRenderer().setNumHorizontalLabels(7);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void insertdatagraph(){
        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MonitorActivity.this,"Data berhasil ditambahkan",Toast.LENGTH_SHORT).show();
                long xValue = new Date().getTime();
                int yValue = Integer.parseInt(String.valueOf(editData.getText()));

                dbh.insertData(xValue, yValue);

                dataseries.resetData(grabData());

                graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
                    @Override
                    public String formatLabel(double value, boolean isValueX){
                        if (isValueX){
                            return sdf.format(new Date((long) value));
                        } else {
                            return super.formatLabel(value, isValueX);
                        }
                    }
                });
            }
        });
    }

    private DataPoint[] grabData(){
        String[] column = {"xValue", "yValue"};

        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.query("TableMonitor",column,null,null,null,null,null);

        DataPoint[] dataPoints = new DataPoint[cursor.getCount()];

        for (int i = 0; i < cursor.getCount(); i++){
            cursor.moveToNext();
            dataPoints[i] = new DataPoint(cursor.getLong(0),cursor.getInt(1));
        }

        return dataPoints;
    }

    public void removeData(){
        dbh.deleteData();
        graphView.removeAllSeries();
    }


    @Override
    public void onDateSelected(DateTime dateSelected) {

    }

}