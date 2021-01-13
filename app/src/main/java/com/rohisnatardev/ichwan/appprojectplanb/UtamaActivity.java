package com.rohisnatardev.ichwan.appprojectplanb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.rohisnatardev.ichwan.appprojectplanb.JadwalSholat.JadwalSholatActivity;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.QuranFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.SettingFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.LatihanFragment;
import com.rohisnatardev.ichwan.appprojectplanb.cnbfragment.TajwidFragment;

import java.util.Calendar;

import hotchemi.android.rate.AppRate;

public class UtamaActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;
    FragmentManager fragmentManager;
    TextView jadwal, greetTx;
    CardView cvInfo;

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
        jadwal = findViewById(R.id.lihat_jadwal);
        cvInfo = findViewById(R.id.cv_jadwal_sholat);
        greetTx = findViewById(R.id.greetx);
        cardGreet();
        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jadwalSholat = new Intent(UtamaActivity.this, JadwalSholatActivity.class);
                startActivity(jadwalSholat);
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
                        fragments = new LatihanFragment();
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
            NoInternetFragment internetFragment = new NoInternetFragment();
            internetFragment.show(getSupportFragmentManager(),"NoInternetFragment");
        }
    }

    private void cardGreet(){
        Calendar calendar = Calendar.getInstance();
        int timeOut = calendar.get(Calendar.HOUR_OF_DAY);

        if(timeOut >= 3 && timeOut < 7){
            greetTx.setText(getString(R.string.greeting_pagi));
        }
        else if(timeOut >= 7 && timeOut < 11){
            greetTx.setText(getString(R.string.greeting_dhuha));
        }
        else if(timeOut >= 11 && timeOut < 19){
            greetTx.setText(getString(R.string.greeting_quran));
        }
        else{
            greetTx.setText(getString(R.string.greeting_malam));
        }
    }

}
