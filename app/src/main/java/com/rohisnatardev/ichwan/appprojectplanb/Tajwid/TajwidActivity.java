package com.rohisnatardev.ichwan.appprojectplanb.Tajwid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        CardView btn_idgham = findViewById(R.id.idghom);
        btn_idgham.setOnClickListener(this);
        CardView btn_idzhar = findViewById(R.id.idzhar);
        btn_idzhar.setOnClickListener(this);
        CardView btn_ikhfa = findViewById(R.id.ikhfa);
        btn_ikhfa.setOnClickListener(this);
        CardView btn_iqlab = findViewById(R.id.iqlab);
        btn_iqlab.setOnClickListener(this);
        CardView btn_idzharsyf = findViewById(R.id.idzharsyf);
        btn_idzharsyf.setOnClickListener(this);
        CardView btn_ikhfasyf = findViewById(R.id.ikhfasy);
        btn_ikhfasyf.setOnClickListener(this);
        CardView btn_idghammsln = findViewById(R.id.idghammsln);
        btn_idghammsln.setOnClickListener(this);
        CardView btn_madthabi = findViewById(R.id.madtabii);
        btn_madthabi.setOnClickListener(this);
        CardView btn_mdbadal = findViewById(R.id.madbadal);
        btn_mdbadal.setOnClickListener(this);
        CardView btn_mdiwadh = findViewById(R.id.madiwadh);
        btn_mdiwadh.setOnClickListener(this);
        CardView btn_mdsilahsughra = findViewById(R.id.madshilah);
        btn_mdsilahsughra.setOnClickListener(this);
        CardView btn_mdshilahkubra = findViewById(R.id.mdsilkubbra);
        btn_mdshilahkubra.setOnClickListener(this);
        CardView btn_mdliyn = findViewById(R.id.madliyn);
        btn_mdliyn.setOnClickListener(this);
        CardView btn_mdaridlskn = findViewById(R.id.md_arid_lskn);
        btn_mdaridlskn.setOnClickListener(this);
        CardView btn_mdlazim = findViewById(R.id.mdlazim);
        btn_mdlazim.setOnClickListener(this);
        CardView btn_mdjaiz = findViewById(R.id.md_jaiz);
        btn_mdjaiz.setOnClickListener(this);
        CardView btn_mdwajib = findViewById(R.id.md_wajib);
        btn_mdwajib.setOnClickListener(this);
        CardView btnqalqalahSgr = findViewById(R.id.qalqalahsughra);
        btnqalqalahSgr.setOnClickListener(this);
        CardView btnqalqalahKbr = findViewById(R.id.qalqalahkubra);
        btnqalqalahKbr.setOnClickListener(this);

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
