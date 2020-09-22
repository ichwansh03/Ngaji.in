package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatNonLawan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class SifatTunggal extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView title_sifatnlwn;
    List<SifatNonLawan> nonLawanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifat_huruf_non_lawan);

        recyclerView = findViewById(R.id.rv_nonlawan);
        initDatas();
        initRecyclerView();
    }

    private void initDatas() {
        nonLawanList = new ArrayList<>();
        nonLawanList.add(new SifatNonLawan("Shafir","Berdesis dan keluar dengan kuat antara ujung beberapa buah gigi atas dan lidah.\nTerdiri dari huruf س-ز-ص"));
        nonLawanList.add(new SifatNonLawan("Qalqalah","Pelafadzan huruf yang sukun disertai dengan getaran suara pada makhrajnya sehingga terdengar suara kuta/mental.\nTerdiri dari huruf ب-ج-د-ط-ق"));
        nonLawanList.add(new SifatNonLawan("Liin","Pelafadzan huruf yang lembut atau mudah tanpa harus memberatkan lidah. Contohnya seperti pada hukum MadLiyn"));
        nonLawanList.add(new SifatNonLawan("Inhiraaf","Huruf yang pelafadzan nya condong setelah keluar dari ujung lidah. Hurufnya yaitu ل"));
        nonLawanList.add(new SifatNonLawan("Takrir","Pelafadzan huruf dengan menggetarkan ujung lidah. Hurufnya yaitu ر"));
        nonLawanList.add(new SifatNonLawan("Tafasyi","Pelafadzan huruf dengan menghamburkan udara dari dalam mulut. Hurufnya yaitu ش"));
        nonLawanList.add(new SifatNonLawan("Istitholah","Pelafadzan huruf dengan cara memanjangkan suara dari tepi pangkal lidah hingga ujung lidah. Hurufnya yaitu ض"));
    }

    private void initRecyclerView() {
        SifatNonLawanAdapter sifatNonLawanAdapter = new SifatNonLawanAdapter(nonLawanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sifatNonLawanAdapter);
    }

}
