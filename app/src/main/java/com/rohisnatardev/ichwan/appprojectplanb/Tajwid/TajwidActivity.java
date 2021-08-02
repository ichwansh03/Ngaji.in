package com.rohisnatardev.ichwan.appprojectplanb.Tajwid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.rohisnatardev.ichwan.appprojectplanb.R;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadAridLsActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadBadalActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadIwadhActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadLazimActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadLiynActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadMunfasilActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadMuttasilActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadShilahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadSlhKubraActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad.MadThabiiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.MimMati.IdghamMislainActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.MimMati.IdzharSyafawiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.MimMati.IkfhaSyafawiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.NunMati.IdghamActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.NunMati.IdzharActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.NunMati.IkhfaActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.NunMati.IqlabActivity;

public class TajwidActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajwid);

        //nun mati
        findViewById(R.id.idghom).setOnClickListener(this);
        findViewById(R.id.idzhar).setOnClickListener(this);
        findViewById(R.id.ikhfa).setOnClickListener(this);
        findViewById(R.id.iqlab).setOnClickListener(this);

        //mim mati
        findViewById(R.id.idzharsyf).setOnClickListener(this);
        findViewById(R.id.ikhfasy).setOnClickListener(this);
        findViewById(R.id.idghammsln).setOnClickListener(this);

        //mad
        findViewById(R.id.madtabii).setOnClickListener(this);
        findViewById(R.id.madbadal).setOnClickListener(this);
        findViewById(R.id.madiwadh).setOnClickListener(this);
        findViewById(R.id.madshilah).setOnClickListener(this);
        findViewById(R.id.mdsilkubbra).setOnClickListener(this);
        findViewById(R.id.madliyn).setOnClickListener(this);
        findViewById(R.id.md_arid_lskn).setOnClickListener(this);
        findViewById(R.id.mdlazim).setOnClickListener(this);
        findViewById(R.id.md_jaiz).setOnClickListener(this);
        findViewById(R.id.md_wajib).setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idghom:
                startActivity(new Intent(this, IdghamActivity.class));
                break;
            case R.id.idzhar:
                startActivity(new Intent(this, IdzharActivity.class));
                break;
            case R.id.ikhfa:
                startActivity(new Intent(this, IkhfaActivity.class));
                break;
            case R.id.iqlab:
                startActivity(new Intent(this, IqlabActivity.class));
                break;
            case R.id.idzharsyf:
                startActivity(new Intent(this, IdzharSyafawiActivity.class));
                break;
            case R.id.ikhfasy:
                startActivity(new Intent(this, IkfhaSyafawiActivity.class));
                break;
            case R.id.idghammsln:
                startActivity(new Intent(this, IdghamMislainActivity.class));
                break;
            case R.id.madtabii:
                startActivity(new Intent(this, MadThabiiActivity.class));
                break;
            case R.id.madbadal:
                startActivity(new Intent(this, MadBadalActivity.class));
                break;
            case R.id.madiwadh:
                startActivity(new Intent(this, MadIwadhActivity.class));
                break;
            case R.id.madshilah:
                startActivity(new Intent(this, MadShilahActivity.class));
                break;
            case R.id.mdsilkubbra:
                startActivity(new Intent(this, MadSlhKubraActivity.class));
                break;
            case R.id.madliyn:
                startActivity(new Intent(this, MadLiynActivity.class));
                break;
            case R.id.md_arid_lskn:
                startActivity(new Intent(this, MadAridLsActivity.class));
                break;
            case R.id.mdlazim:
                startActivity(new Intent(this, MadLazimActivity.class));
                break;
            case R.id.md_jaiz:
                startActivity(new Intent(this, MadMunfasilActivity.class));
                break;
            case R.id.md_wajib:
                startActivity(new Intent(this, MadMuttasilActivity.class));
                break;

        }
    }
}
