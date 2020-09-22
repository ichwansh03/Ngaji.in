package com.rohisnatardev.ichwan.appprojectplanb.Quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class WaqafActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<WaqafItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waqaf);

        recyclerView = findViewById(R.id.rvWaqaf);

        dataWaqaf();
        recyclerInit();
    }
    private void dataWaqaf(){
        itemList = new ArrayList<>();
        itemList.add(new WaqafItem("Waqaf Lazim (م)","Penghentian di akhir kalimat secara sempurna. Waqaf ini biasanya memiliki tanda seperti hukum iqlab, namun berbeda fungsi dan maksudnya"));
        itemList.add(new WaqafItem("Waqaf Lam (لا)","Pelarangan untuk berhenti pada waqaf ini. Jika berada di pertengahan ayat, maka tidak dianjurkan untuk berhenti. Jika berada di akhir ayat, boleh berhenti dan boleh tidak"));
        itemList.add(new WaqafItem("Waqaf Jaiz (ج)","Boleh berhenti dan boleh melanjutkan bacaan"));
        itemList.add(new WaqafItem("Waqaf Washol (صلى)","Lebih baik meneruskan bacaan tanpa berhenti pada waqaf ini, jika berhenti maka bacaan harus disambung"));
        itemList.add(new WaqafItem("Waqaf Qaf Awlaa (قلى)","Lebih diutamakan untuk berhenti pada waqaf ini"));
        itemList.add(new WaqafItem("Waqaf Saktah (س)","Berhenti sejenak tanpa mengambil nafas"));
        itemList.add(new WaqafItem("Waqaf Muroqobah","Waqaf ini ditandai dengan 3 titik dan selalu muncul 2 kali baik di 1 ayat maupun dua ayat (akhir dan awal) dan dibaca dengan berhenti pada salh satu tandanya. Jika sudah berhenti pada tanda pertama, tidak perlu berhenti pada tanda kedua, begitupun sebaliknya"));
    }

    private void recyclerInit(){
        WaqafAdapter waqafAdapter = new WaqafAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(waqafAdapter);
    }

}
