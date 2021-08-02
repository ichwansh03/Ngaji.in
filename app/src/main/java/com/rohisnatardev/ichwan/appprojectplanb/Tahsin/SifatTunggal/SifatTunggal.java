package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatTunggal;

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
    List<SifatTunggalItem> nonLawanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifat_huruf);

        recyclerView = findViewById(R.id.rvSifatHuruf);
        title_sifatnlwn = findViewById(R.id.title_sifat);
        title_sifatnlwn.setText(R.string.sifat_yang_tidak_memiliki_lawan_kata);
        initDatas();
        initRecyclerView();
    }

    private void initDatas() {
        nonLawanList = new ArrayList<>();
        nonLawanList.add(new SifatTunggalItem("Shafir","Berdesis dan keluar dengan kuat antara ujung beberapa buah gigi atas dan lidah.\nTerdiri dari huruf س-ز-ص"));
        nonLawanList.add(new SifatTunggalItem("Qalqalah","Pelafadzan huruf yang sukun disertai dengan getaran suara pada makhrajnya sehingga terdengar suara kuta/mental.\nTerdiri dari huruf ب-ج-د-ط-ق\n" +
                "Qalqalah sendiri terbagi menjadi 2 bagian, yaitu Qalqalah Sughra dan Kubra.\nQalqalah Sughra yaitu apabila salah satu dari huruf qalqalah tersebut berharakat sukun (huruf mati) dan bukan karena waqaf serta letaknya pada pertengahan ayat." +
                "\nQalqalah Kubra yaitu apabila salah satu dari huruf qalqalah tersebut berharakat sukun karena waqaf. Dalam keadaan ini, huruf qalqalah dipantulkan apabila bacaan diwaqafkan tetapi tidak dipantulkan apabila bacaan diteruskan"));
        nonLawanList.add(new SifatTunggalItem("Liin","Pelafadzan huruf yang lembut atau mudah tanpa harus memberatkan lidah. Contohnya seperti pada hukum MadLiyn"));
        nonLawanList.add(new SifatTunggalItem("Inhiraaf","Huruf yang pelafadzan nya condong setelah keluar dari ujung lidah. Hurufnya yaitu ل"));
        nonLawanList.add(new SifatTunggalItem("Takrir","Pelafadzan huruf dengan menggetarkan ujung lidah. Hurufnya yaitu ر"));
        nonLawanList.add(new SifatTunggalItem("Tafasyi","Pelafadzan huruf dengan menghamburkan udara dari dalam mulut. Hurufnya yaitu ش"));
        nonLawanList.add(new SifatTunggalItem("Istitholah","Pelafadzan huruf dengan cara memanjangkan suara dari tepi pangkal lidah hingga ujung lidah. Hurufnya yaitu ض"));
    }

    private void initRecyclerView() {
        SifatTunggalAdapter sifatTunggalAdapter = new SifatTunggalAdapter(nonLawanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sifatTunggalAdapter);
    }

}
