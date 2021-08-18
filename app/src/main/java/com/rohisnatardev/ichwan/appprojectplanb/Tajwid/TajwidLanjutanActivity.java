package com.rohisnatardev.ichwan.appprojectplanb.Tajwid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.AlifLam.QomariyahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.AlifLam.SyamsiyahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Hamzah.QathiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Hamzah.WashalActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumIdgham.MutajanisainActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumIdgham.MutamasilainActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumIdgham.MutaqaribainActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumLamdanRa.HukumLamActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumLamdanRa.HukumLamTarqiqActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumLamdanRa.HukumRaActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumLamdanRa.HukumRaTarqiqActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.ImalahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.IsymamActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.NaqlActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.SaktahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.TashilActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class TajwidLanjutanActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajwid_lanjutan);

        //lam dan ra
        findViewById(R.id.hukumlam).setOnClickListener(this);
        findViewById(R.id.hukumlamtarqiq).setOnClickListener(this);
        findViewById(R.id.hukumra).setOnClickListener(this);
        findViewById(R.id.hukumratarqiq).setOnClickListener(this);

        //idgham
        findViewById(R.id.mutamasilan).setOnClickListener(this);
        findViewById(R.id.mutajanisan).setOnClickListener(this);
        findViewById(R.id.mutaqariban).setOnClickListener(this);

        //bacaan khusus
        findViewById(R.id.imalah).setOnClickListener(this);
        findViewById(R.id.naql).setOnClickListener(this);
        findViewById(R.id.saktah).setOnClickListener(this);
        findViewById(R.id.isymam).setOnClickListener(this);
        findViewById(R.id.tashil).setOnClickListener(this);

        //hamzah
        findViewById(R.id.hamzahwasal).setOnClickListener(this);
        findViewById(R.id.hamzahqathi).setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hukumlam:
                startActivity(new Intent(this, HukumLamActivity.class));
                break;
            case R.id.hukumlamtarqiq:
                startActivity(new Intent(this, HukumLamTarqiqActivity.class));
                break;
            case R.id.hukumra:
                startActivity(new Intent(this, HukumRaActivity.class));
                break;
            case R.id.hukumratarqiq:
                startActivity(new Intent(this, HukumRaTarqiqActivity.class));
                break;
            case R.id.mutamasilan:
                startActivity(new Intent(this, MutamasilainActivity.class));
                break;
            case R.id.mutajanisan:
                startActivity(new Intent(this, MutajanisainActivity.class));
                break;
            case R.id.mutaqariban:
                startActivity(new Intent(this, MutaqaribainActivity.class));
                break;
            case R.id.imalah:
                startActivity(new Intent(this, ImalahActivity.class));
                break;
            case R.id.naql:
                startActivity(new Intent(this, NaqlActivity.class));
                break;
            case R.id.saktah:
                startActivity(new Intent(this, SaktahActivity.class));
                break;
            case R.id.isymam:
                startActivity(new Intent(this, IsymamActivity.class));
                break;
            case R.id.tashil:
                startActivity(new Intent(this, TashilActivity.class));
                break;
            case R.id.hamzahwasal:
                startActivity(new Intent(this, WashalActivity.class));
                break;
            case R.id.hamzahqathi:
                startActivity(new Intent(this, QathiActivity.class));
        }
    }

}
