package com.rohisnatardev.ichwan.appprojectplanb.Tajwid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.Qalqalah.QalqalahKubraActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.Qalqalah.QalqalahSughraActivity;

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
        findViewById(R.id.qalqalahsughra).setOnClickListener(this);
        findViewById(R.id.qalqalahkubra).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idghom:
                Intent idgham = new Intent(this, IdghamActivity.class);
                startActivity(idgham);
                break;
            case R.id.idzhar:
                Intent idzhar = new Intent(this, IdzharActivity.class);
                startActivity(idzhar);
                break;
            case R.id.ikhfa:
                Intent ikhfa = new Intent(this, IkhfaActivity.class);
                startActivity(ikhfa);
                break;
            case R.id.iqlab:
                Intent iqlab = new Intent(this, IqlabActivity.class);
                startActivity(iqlab);
                break;
            case R.id.idzharsyf:
                Intent idzharsyfw = new Intent(this, IdzharSyafawiActivity.class);
                startActivity(idzharsyfw);
                break;
            case R.id.ikhfasy:
                Intent ikhfasyfw = new Intent(this, IkfhaSyafawiActivity.class);
                startActivity(ikhfasyfw);
                break;
            case R.id.idghammsln:
                Intent idghammsln = new Intent(this, IdghamMislainActivity.class);
                startActivity(idghammsln);
                break;
            case R.id.madtabii:
                Intent madthabi = new Intent(this, MadThabiiActivity.class);
                startActivity(madthabi);
                break;
            case R.id.madbadal:
                Intent mdbadal = new Intent(this, MadBadalActivity.class);
                startActivity(mdbadal);
                break;
            case R.id.madiwadh:
                Intent mdiwadh = new Intent(this, MadIwadhActivity.class);
                startActivity(mdiwadh);
                break;
            case R.id.madshilah:
                Intent mdshsughra = new Intent(this, MadShilahActivity.class);
                startActivity(mdshsughra);
                break;
            case R.id.mdsilkubbra:
                Intent mdshkubra = new Intent(this, MadSlhKubraActivity.class);
                startActivity(mdshkubra);
                break;
            case R.id.madliyn:
                Intent mdliyn = new Intent(this, MadLiynActivity.class);
                startActivity(mdliyn);
                break;
            case R.id.md_arid_lskn:
                Intent mdaridh = new Intent(this, MadAridLsActivity.class);
                startActivity(mdaridh);
                break;
            case R.id.mdlazim:
                Intent madlazim = new Intent(this, MadLazimActivity.class);
                startActivity(madlazim);
                break;
            case R.id.md_jaiz:
                Intent madjaiz = new Intent(this, MadMunfasilActivity.class);
                startActivity(madjaiz);
                break;
            case R.id.md_wajib:
                Intent madwajib = new Intent(this, MadMuttasilActivity.class);
                startActivity(madwajib);
                break;
            case R.id.qalqalahsughra:
                Intent qalqalahsgr = new Intent(this, QalqalahSughraActivity.class);
                startActivity(qalqalahsgr);
                break;
            case R.id.qalqalahkubra:
                Intent qalqalahkbr = new Intent(this, QalqalahKubraActivity.class);
                startActivity(qalqalahkbr);
                break;

        }
    }
}
