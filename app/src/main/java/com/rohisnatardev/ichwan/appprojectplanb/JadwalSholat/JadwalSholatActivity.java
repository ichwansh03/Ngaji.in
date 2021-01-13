package com.rohisnatardev.ichwan.appprojectplanb.JadwalSholat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.batoulapps.adhan.CalculationMethod;
import com.batoulapps.adhan.CalculationParameters;
import com.batoulapps.adhan.Coordinates;
import com.batoulapps.adhan.PrayerTimes;
import com.batoulapps.adhan.data.DateComponents;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JadwalSholatActivity extends AppCompatActivity implements SensorEventListener, LocationListener {

    TextView tShubuh, tDzuhur, tAshar, tMaghrib, tIsya, lokasi;
    CardView setlokasi;
    LocationManager locationManager;

    private double latitude, longitude;

    ImageView compass;
    TextView compasDegree;
    int txtDegree;
    private SensorManager mSensorManager;
    private Sensor mRotationV, mAccelerometer, mMagnetometer;
    boolean haveSensor = false, haveSensor2 = false;
    float[] rMat = new float[9];
    float[] orientation = new float[3];
    private float[] mLastAccelerometer = new float[3];
    private float[] mLastMagnetometer = new float[3];
    private boolean mLastAccelerometerSet = false;
    private boolean mLastMagnetometerSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_sholat);

        //waktu sholat
        tShubuh = findViewById(R.id.time_shubuh);
        tDzuhur = findViewById(R.id.time_dzuhur);
        tAshar = findViewById(R.id.time_ashar);
        tMaghrib = findViewById(R.id.time_maghrib);
        tIsya = findViewById(R.id.time_isya);

        setlokasi = findViewById(R.id.btn_setlokasi);
        lokasi = findViewById(R.id.atur_lokasi);

        if (ContextCompat.checkSelfPermission(JadwalSholatActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(JadwalSholatActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(JadwalSholatActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            ActivityCompat.requestPermissions(JadwalSholatActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
        }

        checkStatus();

        setlokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JadwalSholatActivity.this, "Mencari Lokasi...", Toast.LENGTH_SHORT).show();
                getLocations();
            }
        });

        compass = findViewById(R.id.compas_qibla);
        compasDegree = findViewById(R.id.compas_degre);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        startSensor();

    }

    private void checkStatus(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info == null){
            NoGpsDialogFragment gpsDialogFragment = new NoGpsDialogFragment();
            gpsDialogFragment.show(getSupportFragmentManager(),"NoGpsFragment");
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocations(){
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5, JadwalSholatActivity.this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        try {
            Geocoder geocoder = new Geocoder(JadwalSholatActivity.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String alamat = addresses.get(0).getAddressLine(0);
            latitude = addresses.get(0).getLatitude();
            longitude = addresses.get(0).getLongitude();
            lokasi.setText(alamat);
            jadwalSholat();
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("alamat",alamat).apply();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void jadwalSholat(){
        DateComponents dateComponents = DateComponents.from(new Date());
        Coordinates coordinates = new Coordinates(latitude, longitude);
        CalculationParameters parameters = CalculationMethod.UMM_AL_QURA.getParameters();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formats = new SimpleDateFormat("HH:mm");
        formats.setTimeZone(TimeZone.getDefault());

        PrayerTimes prayerTimes = new PrayerTimes(coordinates,dateComponents,parameters);

        String shubuhs = formats.format(prayerTimes.fajr);
        tShubuh.setText(shubuhs);
        String dzuhurs = formats.format(prayerTimes.dhuhr);
        tDzuhur.setText(dzuhurs);
        String ashars = formats.format(prayerTimes.asr);
        tAshar.setText(ashars);
        String maghribs = formats.format(prayerTimes.maghrib);
        tMaghrib.setText(maghribs);
        String isyas = formats.format(prayerTimes.isha);
        tIsya.setText(isyas);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            SensorManager.getRotationMatrixFromVector(rMat, event.values);
            txtDegree = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            System.arraycopy(event.values, 0, mLastAccelerometer, 0, event.values.length);
            mLastAccelerometerSet = true;
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            System.arraycopy(event.values, 0, mLastMagnetometer, 0, event.values.length);
            mLastMagnetometerSet = true;
        }
        if (mLastAccelerometerSet && mLastMagnetometerSet) {
            SensorManager.getRotationMatrix(rMat, null, mLastAccelerometer, mLastMagnetometer);
            SensorManager.getOrientation(rMat, orientation);
            txtDegree = (int) (Math.toDegrees(SensorManager.getOrientation(rMat, orientation)[0]) + 360) % 360;
        }

        txtDegree = Math.round(txtDegree);
        compass.setRotation(-txtDegree);

        String where = "NW";

        if (txtDegree >= 350 || txtDegree <= 10)
            where = "N";
        if (txtDegree < 350 && txtDegree > 280)
            where = "NW";
        if (txtDegree <= 280 && txtDegree > 260)
            where = "W";
        if (txtDegree <= 260 && txtDegree > 190)
            where = "SW";
        if (txtDegree <= 190 && txtDegree > 170)
            where = "S";
        if (txtDegree <= 170 && txtDegree > 100)
            where = "SE";
        if (txtDegree <= 100 && txtDegree > 80)
            where = "E";
        if (txtDegree <= 80 && txtDegree > 10)
            where = "NE";

        compasDegree.setText(txtDegree + "° " + where);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private void startSensor(){
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) == null) {
            if ((mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) || (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) == null)) {
                //noSensorsAlert();
            }
            else {
                mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mMagnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                haveSensor = mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
                haveSensor2 = mSensorManager.registerListener(this, mMagnetometer, SensorManager.SENSOR_DELAY_UI);
            }
        }
        else{
            mRotationV = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            haveSensor = mSensorManager.registerListener(this, mRotationV, SensorManager.SENSOR_DELAY_UI);
        }
    }

    private void stopSensor(){
        if (haveSensor) {
            mSensorManager.unregisterListener(this, mRotationV);
        }
        else {
            mSensorManager.unregisterListener(this, mAccelerometer);
            mSensorManager.unregisterListener(this, mMagnetometer);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopSensor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startSensor();
    }



    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}