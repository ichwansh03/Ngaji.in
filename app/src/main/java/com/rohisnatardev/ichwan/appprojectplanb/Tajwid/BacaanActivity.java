package com.rohisnatardev.ichwan.appprojectplanb.Tajwid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

public class BacaanActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacaan);

        CardView hukumLam = findViewById(R.id.hukumlam);
        hukumLam.setOnClickListener(this);
        CardView hukumLamTarqiq = findViewById(R.id.hukumlamtarqiq);
        hukumLamTarqiq.setOnClickListener(this);
        CardView hukumRa = findViewById(R.id.hukumra);
        hukumRa.setOnClickListener(this);
        CardView hukumRaTarqiq = findViewById(R.id.hukumratarqiq);
        hukumRaTarqiq.setOnClickListener(this);
        CardView mutamasilain = findViewById(R.id.mutamasilan);
        mutamasilain.setOnClickListener(this);
        CardView mutajanisain = findViewById(R.id.mutajanisan);
        mutajanisain.setOnClickListener(this);
        CardView mutaqaribain = findViewById(R.id.mutaqariban);
        mutaqaribain.setOnClickListener(this);
        CardView imalah = findViewById(R.id.imalah);
        imalah.setOnClickListener(this);
        CardView naql = findViewById(R.id.naql);
        naql.setOnClickListener(this);
        CardView saktah = findViewById(R.id.saktah);
        saktah.setOnClickListener(this);
        CardView isymam = findViewById(R.id.isymam);
        isymam.setOnClickListener(this);
        CardView tashil = findViewById(R.id.tashil);
        tashil.setOnClickListener(this);
        CardView syamsi = findViewById(R.id.syamsiah);
        syamsi.setOnClickListener(this);
        CardView qomar = findViewById(R.id.qomariah);
        qomar.setOnClickListener(this);
        CardView hwasal = findViewById(R.id.hamzahwasal);
        hwasal.setOnClickListener(this);
        CardView hqathi = findViewById(R.id.hamzahqathi);
        hqathi.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hukumlam:
                Intent intentLam = new Intent(this, HukumLamActivity.class);
                startActivity(intentLam);
                break;
            case R.id.hukumlamtarqiq:
                Intent intentLam2 = new Intent(this, HukumLamTarqiqActivity.class);
                startActivity(intentLam2);
                break;
            case R.id.hukumra:
                Intent intentRa = new Intent(this, HukumRaActivity.class);
                startActivity(intentRa);
                break;
            case R.id.hukumratarqiq:
                Intent intentRa2 = new Intent(this, HukumRaTarqiqActivity.class);
                startActivity(intentRa2);
                break;
            case R.id.mutamasilan:
                Intent idghamMutama = new Intent(this, MutamasilainActivity.class);
                startActivity(idghamMutama);
                break;
            case R.id.mutajanisan:
                Intent idghamMutaja = new Intent(this, MutajanisainActivity.class);
                startActivity(idghamMutaja);
                break;
            case R.id.mutaqariban:
                Intent idghamMutaqa = new Intent(this, MutaqaribainActivity.class);
                startActivity(idghamMutaqa);
                break;
            case R.id.imalah:
                Intent kImalah = new Intent(this, ImalahActivity.class);
                startActivity(kImalah);
                break;
            case R.id.naql:
                Intent kNaql = new Intent(this, NaqlActivity.class);
                startActivity(kNaql);
                break;
            case R.id.saktah:
                Intent kSaktah = new Intent(this, SaktahActivity.class);
                startActivity(kSaktah);
                break;
            case R.id.isymam:
                Intent kIsymam = new Intent(this, IsymamActivity.class);
                startActivity(kIsymam);
                break;
            case R.id.tashil:
                Intent kTahsil = new Intent(this, TashilActivity.class);
                startActivity(kTahsil);
                break;
            case R.id.syamsiah:
                Intent aSyamsi = new Intent(this, SyamsiyahActivity.class);
                startActivity(aSyamsi);
                break;
            case R.id.qomariah:
                Intent aQomar = new Intent(this, QomariyahActivity.class);
                startActivity(aQomar);
                break;
            case R.id.hamzahwasal:
                Intent hWashal = new Intent(this, WashalActivity.class);
                startActivity(hWashal);
                break;
            case R.id.hamzahqathi:
                Intent hQathi = new Intent(this, QathiActivity.class);
                startActivity(hQathi);
                break;
        }
    }

}
