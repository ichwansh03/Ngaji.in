package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatLawan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class SifatJamak extends AppCompatActivity{
    RecyclerView recyclerView;

    List<SifatLawan> sifatLawanList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifat_huruf_lawan);

        recyclerView = findViewById(R.id.recyclerView1);

        initData();
        initRecyclerView();
    }

    private void initData() {
        sifatLawanList = new ArrayList<>();
        sifatLawanList.add(new SifatLawan("Hams lawan dari Jahr","Hamsy secara bahasa artinya samar, sedangkan menurut istilah artinya pengucapan atau bunyi huruf yang disertai dengan keluarnya nafas dan terdiri dari huruf\nف-ح-ه-ث-ش-ت-ص-س-ك-خ\n\nJahr secara bahasa artinya jelas, sedangkan menurut istilah yaitu pengucapan huruf tanpa disertai keluarnya nafas, huruf jahr berjumlah 18 selain huruf hams."));
        sifatLawanList.add(new SifatLawan("Syiddah lawan dari Tawassuth","Syiddah secara bahasa artinya kuat, sedangkan menurut istilah adalah pengucapan atau bunyi denngan adanya penekan diawal karena sangat tergantung kepada makhrajnya. Hurufnya berjumlah 8 yang terdiri dari\nأ-ج-د-ق-ك-ب-ت-ط\n\nTawasuth secara bahasa artinya sedang sedangkan menurut istilah yaitu pengucapan huruf yang tidak terlalu tertahan sehingga terdengar lemah, hurufnya berjumlah 5 yaitu\nل-ن-ع-م-ر\nAda penambahan dalam hal ini, yaitu rakhawah yang dalam bahasa artinya lemah, sedangkan menurut istilah yaitu pengucapan huruf yang disertai dengan pelafadzan bunyi secara bebas karena tidak terlau tergantung pada makhrajnya, hurufnya berjumlah 15 selain huruf syiddah dan tawassuth"));
        sifatLawanList.add(new SifatLawan("Isti\'la lawan dari Istifal","Isti\'la secara bahasa artinya terangkat, sedangkan menurut istilah yaitu pelafadzan huruf disertai dengan terangkatnya lidah keatas langit-langit serta hurufnya berjumlah 7 terdiri dari\nخ-ض-ص-غ-ظ-ط-ق\n\nIstifal secara bahasa artinya menurun, sedangkan menurut isrilah yaitu pelafadzan huruf disertai dengan turunnya lidah dari langit-langit. Hurufnya berjumlah 21 selain huruf Isti\'la"));
        sifatLawanList.add(new SifatLawan("Ithibaq lawan dari Infitah","Ithibaq secara bahasa artinya lekat atau menempel, sedangkat menurut istilah yaitu pelafadzan huruf dalam keadaan bertemunya ujung lidah dengan langit-langit, hurufnya berjumlah 4 yaitu\nض-ص-ظ-ط\n\nInfithah secara bahasa artinya terpisah, sedangkan menurut istilah yaitu pelafadzan huruf dengan menjauhnya lidah dari langit-langit. Hurufnya berjumlah 23 selain huruf ithibaq."));
        sifatLawanList.add(new SifatLawan("Idzlaq lawan dari Ishmat","Idzlaq secara bahasa artinya ujung lidah, sedangkan menurut istilah yaitu huruf yang pelafadzannya mudah keluar karena makhrajnya dari ujung lidah dan bibir. Hurufnya berjumlah 6 terdiri dari\nف-ر-م-ل-ن-ب\n\nIshmat secara bahasa artinya tertahan, sedangkan menurut istilah yaitu huruf yang pelafadzannya keluar secara tertahan. Semua huruf hijaiyah adalah huruf Ishmat kecuali huruf-huruf Idzlaq"));
    }

    private void initRecyclerView() {
        SifatLawanAdapter sifatLawanAdapter = new SifatLawanAdapter(sifatLawanList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sifatLawanAdapter);
    }
}
