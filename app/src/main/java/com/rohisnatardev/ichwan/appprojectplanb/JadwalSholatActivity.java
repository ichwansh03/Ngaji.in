package com.rohisnatardev.ichwan.appprojectplanb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.batoulapps.adhan.CalculationMethod;
import com.batoulapps.adhan.CalculationParameters;
import com.batoulapps.adhan.Coordinates;
import com.batoulapps.adhan.PrayerTimes;
import com.batoulapps.adhan.data.DateComponents;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JadwalSholatActivity extends AppCompatActivity {

    TextView subuh, duhur, asar, magrib, isa;
    TextView tShubuh, tDzuhur, tAshar, tMaghrib, tIsya;
    String shubuhs,dzuhurs,ashars,maghribs,isyas;
    ProgressBar progressBar;
    FusedLocationProviderClient providerClient;
    private double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sholat);

        subuh = findViewById(R.id.shubuh);
        duhur = findViewById(R.id.dzuhur);
        asar = findViewById(R.id.ashar);
        magrib = findViewById(R.id.maghrib);
        isa = findViewById(R.id.isya);

        //waktu sholat
        tShubuh = findViewById(R.id.time_shubuh);
        shubuhs = tShubuh.getText().toString();
        tDzuhur = findViewById(R.id.time_dzuhur);
        dzuhurs = tDzuhur.getText().toString();
        tAshar = findViewById(R.id.time_ashar);
        ashars = tAshar.getText().toString();
        tMaghrib = findViewById(R.id.time_maghrib);
        maghribs = tMaghrib.getText().toString();
        tIsya = findViewById(R.id.time_isya);
        isyas = tIsya.getText().toString();

        providerClient = LocationServices.getFusedLocationProviderClient(this);

        progressBar = findViewById(R.id.barbar);

        checkState();

    }

    private void checkState(){
        final LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null){
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    Toast.makeText(this, "Enable your GPS!", Toast.LENGTH_SHORT).show();
                } else {
                    getLocation();
                }
            }
        } else {
            Toast.makeText(this, "No Internet Connection!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getLocation(){
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        providerClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null){
                    Geocoder geocoder = new Geocoder(JadwalSholatActivity.this,Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        latitude = (double) addresses.get(0).getLatitude();
                        longitude = (double) addresses.get(0).getLongitude();
                        jadwalSholat();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void jadwalSholat(){
        progressBar.setVisibility(View.GONE);
        DateComponents dateComponents = DateComponents.from(new Date());
        Coordinates coordinates = new Coordinates(latitude,longitude);
        CalculationParameters parameters = CalculationMethod.MUSLIM_WORLD_LEAGUE.getParameters();

        SimpleDateFormat formats = new SimpleDateFormat("HH:mm");
        formats.setTimeZone(TimeZone.getDefault());

        PrayerTimes prayerTimes = new PrayerTimes(coordinates,dateComponents,parameters);

        shubuhs = formats.format(prayerTimes.fajr);
        dzuhurs = formats.format(prayerTimes.dhuhr);
        ashars = formats.format(prayerTimes.asr);
        maghribs = formats.format(prayerTimes.maghrib);
        isyas = formats.format(prayerTimes.isha);

        subuh.setText(Html.fromHtml("Shubuh"));
        duhur.setText(Html.fromHtml("Dzuhur"));
        asar.setText(Html.fromHtml("Ashar"));
        magrib.setText(Html.fromHtml("Maghrib"));
        isa.setText(Html.fromHtml("Isya"));
        progressBar.setVisibility(View.GONE);
    }
}