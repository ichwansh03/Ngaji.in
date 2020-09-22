package com.rohisnatardev.ichwan.appprojectplanb.Monitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorActivity extends AppCompatActivity implements DatePickerListener, View.OnClickListener {

    CardView btninput, btnhapus, btninfo;
    EditText edtData;
    GraphView graphView;

    DatabaseHandler dbh;
    SQLiteDatabase sqLiteDatabase;

    LineGraphSeries<DataPoint> dataseries = new LineGraphSeries<>(new DataPoint[0]);

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");


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

        edtData = findViewById(R.id.edtData);
        btninput = findViewById(R.id.cv_inputdata);
        btninput.setOnClickListener(this);
        btnhapus = findViewById(R.id.cv_resetdata);
        btnhapus.setOnClickListener(this);

        graphView = findViewById(R.id.line_chart);

        dbh = new DatabaseHandler(this);
        sqLiteDatabase = dbh.getWritableDatabase();

        graphView.addSeries(dataseries);
        graphView.getGridLabelRenderer().setNumHorizontalLabels(7);
        insertdatagraph();


    }

    public void insertdatagraph(){
        long xValue = new Date().getTime();
        int yValue = Integer.parseInt(String.valueOf(edtData.getText()));

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cv_inputdata:
                insertdatagraph();
                break;
            case R.id.cv_resetdata:
                removeData();
                break;
        }
    }
}