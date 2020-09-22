package com.rohisnatardev.ichwan.appprojectplanb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.QuranFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.SettingFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.TahsinFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.TajwidFragment;

import org.imaginativeworld.oopsnointernet.ConnectionCallback;
import org.imaginativeworld.oopsnointernet.NoInternetDialog;

import hotchemi.android.rate.AppRate;

public class UtamaActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;

    NoInternetDialog noInternetDialog;

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


        chipNavigationBar = findViewById(R.id.chipbar);

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

    @Override
    protected void onResume() {
        super.onResume();

        // No Internet Dialog
        NoInternetDialog.Builder builder1 = new NoInternetDialog.Builder(this);

        builder1.setConnectionCallback(new ConnectionCallback() { // Optional
            @Override
            public void hasActiveConnection(boolean hasActiveConnection) {
                // ...
            }
        });
        builder1.setCancelable(true);
        builder1.setNoInternetConnectionTitle("Tidak Ada Koneksi Internet");
        builder1.setNoInternetConnectionMessage("Periksa koneksi internet anda dan coba lagi");
        builder1.setShowInternetOnButtons(true);
        builder1.setPleaseTurnOnText("Hidupkan");
        builder1.setWifiOnButtonText("Wifi");
        builder1.setMobileDataOnButtonText("Data Seluler");

        builder1.setOnAirplaneModeTitle("Tidak Ada Koneksi Internet");
        builder1.setOnAirplaneModeMessage("Anda menghidupkan mode pesawat");
        builder1.setPleaseTurnOffText("Matikan");
        builder1.setAirplaneModeOffButtonText("Mode Pesawat");
        builder1.setShowAirplaneModeOffButtons(true);

        noInternetDialog = builder1.build();
    }
}
