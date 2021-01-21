package com.rohisnatardev.ichwan.appprojectplanb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.QuranFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.JadwalFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.LatihanFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.TajwidFragment;

import hotchemi.android.rate.AppRate;

public class UtamaActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;

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
                        fragments = new LatihanFragment();
                        break;
                    case R.id.pengaturan:
                        fragments = new JadwalFragment();
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
            NoInternetFragment internetFragment = new NoInternetFragment();
            internetFragment.show(getSupportFragmentManager(),"NoInternetFragment");
        }
    }
}
