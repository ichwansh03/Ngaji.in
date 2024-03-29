package com.rohisnatardev.ichwan.appprojectplanb.Tahsin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.Hijaiyah.HijaiyahAdapter;
import com.rohisnatardev.ichwan.appprojectplanb.Hijaiyah.HijaiyahItem;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class AlHalqActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<HijaiyahItem> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_halq);

        recyclerView = findViewById(R.id.rv_hijaiyah_halq);

        dataHuruf();
        showRecyclerGridView();

        findViewById(R.id.fabhalqi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlHalqActivity.this, AlLisanActivity.class));
            }
        });
    }

    private void dataHuruf() {
        mData = new ArrayList<>();
        mData.add(new HijaiyahItem("ا (Alif)","آ أِيْ أُوْ بَأْ أُوْ أَنْ أَنِ أَأْنَ مِنَ لْمُؤْنِ مَأِيْ أً أَنِأً","Makhraj = Pangkal tenggorokan\nSifat = Jahr, Syiddah, Infitah",R.raw.alif));
        mData.add(new HijaiyahItem("ه (Ha Dhamir)","هَا هِيْ هُوْ بَهْ هُوْ هَنْ هَنِ هَهْنَ مِنَ لْمُهْنِ مَهِيْ هًا هَنِهَ","Makhraj = Pangkal tenggorokan\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat",R.raw.hadhomir));
        mData.add(new HijaiyahItem("ع (Ain)","عَا عِيْ عُوْ بَعْ عُوْ عَنْ عَنِ عَعْنَ مِنَ لْمُعْنِ مَعِيْ عًا عَنِعَ","Makhraj = Tengah tenggorokan\nSifat = Tawassuth, Istifal, Infitah, Ishmat",R.raw.ain));
        mData.add(new HijaiyahItem("ح (Ha)","حَا حِيْ حُوْ بَحْ حُوْ حَنْ حَنِ حَحْنَ مِنَ لْمُحْنِ مَحِيْ حًا حَنِحَ","Makhraj = Tengah tenggorokan\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat",R.raw.ha));
        mData.add(new HijaiyahItem("خ (Kha)","خَا خِيْ خُوْ بَخْ خُوْ خَنْ خَنِ خَخْنَ مِنَ لْمُخْنِ مَخِيْ خًا خَنِخَ","Makhraj = Atas tenggorokan\nSifat = Hams, Rakhawah, Isti\'la, Infitah, Ishmat",R.raw.kho));
        mData.add(new HijaiyahItem("غ (Ghain)","غَا غِيْ غُوْ بَغْ غُوْ غَنْ غَنِ غَغْنَ مِنَ لْمُغْنِ مَغِيْ غًا غَنِغَ","Makhraj = Atas tenggorokan\nSifat = Jahr, Rakhawah, Isti\'la, Infitah, Ishmat",R.raw.ghain));
    }

    private void showRecyclerGridView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HijaiyahAdapter hijaiyahAdapter = new HijaiyahAdapter(mData,this);
        recyclerView.setAdapter(hijaiyahAdapter);
    }
}
