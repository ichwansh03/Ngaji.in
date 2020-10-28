package com.rohisnatardev.ichwan.appprojectplanb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.QuranFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.SettingFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.TahsinFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.TajwidFragment;

import java.util.Calendar;

import hotchemi.android.rate.AppRate;

public class UtamaActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;
    TextView jadwal, lokasi;
    LottieAnimationView animationView;
    FusedLocationProviderClient providerClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        AppRate.with(this)
                .setInstallDays(0)
                .setLaunchTimes(4)
                .setRemindInterval(2)
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);

        checkStatus();
        //changeTime();

        providerClient = LocationServices.getFusedLocationProviderClient(this);

        chipNavigationBar = findViewById(R.id.chipbar);
        jadwal = findViewById(R.id.lihat_jadwal);
        animationView = findViewById(R.id.lottie);

        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(UtamaActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(UtamaActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(UtamaActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
                    ActivityCompat.requestPermissions(UtamaActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},44);
                } else {
                    Intent jadwalSholat = new Intent(UtamaActivity.this, JadwalSholatActivity.class);
                    startActivity(jadwalSholat);
                }
            }
        });


        if (savedInstanceState == null) {
            chipNavigationBar.setItemSelected(R.id.quran, true);
            fragmentManager = getSupportFragmentManager();
            QuranFragment quranFragment = new QuranFragment();
            fragmentManager.beginTransaction().replace(R.id.container, quranFragment).commit();
        }

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragments = null;

                switch (id) {
                    case R.id.quran:
                        fragments = new QuranFragment();
                        break;
                    case R.id.tajwid:
                        fragments = new TajwidFragment();
                        break;
                    case R.id.tahsin:
                        fragments = new TahsinFragment();
                        break;
                    case R.id.pengaturan:
                        fragments = new SettingFragment();
                        break;
                }

                if (fragments != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.container, fragments).commit();
                }
            }
        });

    }


    private void checkStatus(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info == null){
            Toast.makeText(UtamaActivity.this,"Tidak ada koneksi internet",Toast.LENGTH_SHORT).show();
        }
    }

    /*private void changeTime(){
        Calendar calendar = Calendar.getInstance();
        int timeOut = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOut >= 4 && timeOut < 10){
            animationView.setAnimation(R.raw.pagi);
        }
        else if (timeOut >= 10 && timeOut < 2){
            animationView.setAnimation(R.raw.siang);
        }
        else if (timeOut >= 2 && timeOut < 6){
            animationView.setAnimation(R.raw.sore);
        }
        else {
            animationView.setAnimation(R.raw.malam);
        }
    }*/
}
