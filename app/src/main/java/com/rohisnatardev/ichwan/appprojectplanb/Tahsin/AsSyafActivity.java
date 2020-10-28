package com.rohisnatardev.ichwan.appprojectplanb.Tahsin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.Hijaiyah.IqraAdapter;
import com.rohisnatardev.ichwan.appprojectplanb.Hijaiyah.IqraItem;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class AsSyafActivity extends AppCompatActivity {

    RecyclerView rvSyaf;
    List<IqraItem> iqraItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_syaf);

        rvSyaf = findViewById(R.id.rv_hijaiyah_syaf);

        dataSyaf();
        setRecyclers();

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJauf = new Intent(AsSyafActivity.this,AlJaufActivity.class);
                startActivity(intentJauf);
            }
        });
    }

    private void dataSyaf(){
        iqraItems = new ArrayList<>();
        iqraItems.add(new IqraItem("ف (Fa)","فَا فِيْ فُوْ بَفْ فُوْ فَنْ فَنِ فَفْنَ مِنَ لْمُفْنِ مَفِيْ فًا فَنِفَ","Makhraj = Ujung gigi atas menyentuh pangkal bibir bawah bagian dalam\nSifat = Hams, Istifal, Infitah, Idzlaq",R.raw.fa));
        iqraItems.add(new IqraItem("ب (Ba)","بَا بِيْ بُوْ بَبْ بُوْ بَنْ بَنِ بَبْنَ مِنَ لْمُبْنِ مَبِيْ بًا بَنِبَ","Makhraj = Kedua bibir saling menempel\nSifat = Jahr, Syiddah, Istifal, Infitah, Idzlaq, Qalqalah",R.raw.ba));
        iqraItems.add(new IqraItem("م (Mim)","مَا مِيْ مُوْ بَمْ مُوْ مَنْ مَنِ مَمْنَ مِنَ لْمُمْنِ مَمِيْ مًا مَنِمَ","Makhraj = Kedua bibir saling menempel\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq",R.raw.mim));
        iqraItems.add(new IqraItem("و (Wau)","وَا وِيْ وُوْ بَوْ وُوْ وَنْ وَنِ وَوْنَ مِنَ لْمُوْنِ مَوِيْ وًا وَنِوَ","Makhraj = Kedua bibir membentuk bundaran\nSifat = Jahr, Rakhawah, Istifal, Infitah, Ishmat",R.raw.wau));
    }

    private void setRecyclers(){
        rvSyaf.setLayoutManager(new LinearLayoutManager(this));
        IqraAdapter iqraAdapter = new IqraAdapter(iqraItems,this);
        rvSyaf.setAdapter(iqraAdapter);
    }

}
