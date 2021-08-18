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

public class AlLisanActivity extends AppCompatActivity {

    RecyclerView rView;
    List<HijaiyahItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_lisan);

        rView = findViewById(R.id.rv_hijaiyah_lisan);

        dataLisan();
        setRecview();

        findViewById(R.id.fablisan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlLisanActivity.this, AsSyafActivity.class));
            }
        });

    }

    private void dataLisan(){
        list = new ArrayList<>();
        list.add(new HijaiyahItem("ق (Qaf)","قَا قِيْ قُوْ بَقْ قُوْ قَنْ قَنِ قَقْنَ مِنَ لْمُقْنِ مَقِيْ قًا قَنِقَ","Makhraj = Pangkal lidah\nSifat = Jahr, Syiddah, Isti'la, Infitah, Ishmat, Qalqalah",R.raw.qof));
        list.add(new HijaiyahItem("ك (Kaf)","كَا كِيْ كُوْ بَكْ كُوْ كَنْ كَنِ كَكْنَ مِنَ لْمُكْنِ مَكِيْ كًا كَنِكَ","Makhraj = Pangkal lidah\nSifat = Hams, Syiddah, Istifal, Infitah, Ishmat",R.raw.kaf));
        list.add(new HijaiyahItem("ج (Jim)","جَا جِيْ جُوْ بَجْ جُوْ جَنْ جَنِ جَجْنَ مِنَ لْمُجْنِ مَجِيْ جًا جَنِجَ","Makhraj = Tengah atau punggung lidah menyentuh langit-langit\nSifat = Jahr, Syiddah, Istifal, Infitah, Ishmat, Qalqalah",R.raw.ja));
        list.add(new HijaiyahItem("ي (Ya)","يَا يِيْ يُوْ بَيْ يُوْ يَنْ يَنِ يَيْنَ مِنَ لْمُيْنِ مَيِيْ يًا يَنِيَ","Makhraj = Tengah atau punggung lisan\nSifat = Jahr, Rakhawah, Istifal,Infitah, Ishmat",R.raw.ya));
        list.add(new HijaiyahItem("ش (Syin)","شَا شِيْ شُوْ بَشْ شُوْ شَنْ شَنِ شَشْنَ مِنَ لْمُشْنِ مَشِيْ شًا شَنِشَ","Makhraj = Tengah atau punggung lisan\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat, Tafassyi",R.raw.sya));
        list.add(new HijaiyahItem("ض (Dlad)","ضَا ضِيْ ضُوْ بَضْ ضُوْ ضَنْ ضَنِ ضَضْنَ مِنَ لْمُضْنِ مَضِيْ ضًا ضَنِضَ","Makhraj = Kedua samping lidah atau salah satunya menyentuh gigi-gigi atas\nSifat = Jahr, Isti\'la, Ithbaq, Istithalah",R.raw.dho));
        list.add(new HijaiyahItem("ل (Lam)","لَا لِيْ لُوْ بَلْ لُوْ لَنْ لَنِ لَلْنَ مِنَ لْمُلْنِ مَلِيْ لًا لَنِلَ","Makhraj = Ujung lidah atas bertemu langit-langit\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq, Inhiraf",R.raw.la));
        list.add(new HijaiyahItem("ن (Nun)","نَا نِيْ نُوْ بَنْ نُوْ نَنْ نَنِ نَنْنَ مِنَ لْمُنْنِ مَنِيْ نًا نَنِنَ","Makhraj = Ujung lidah atas bertemu langit-langit\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq",R.raw.na));
        list.add(new HijaiyahItem("ر (Ra)","رَا رِيْ رُوْ بَرْ رُوْ رَنْ رَنِ رَرْنَ مِنَ لْمُرْنِ مَرِيْ رًا رَنِرَ","Makhraj = Ujung lidah atas bertemu langit-langit\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq, Takrir",R.raw.ra));
        list.add(new HijaiyahItem("ت (Ta)","تَا تِيْ تُوْ بَتْ تُوْ تَنْ تَنِ تَتْنَ مِنَ لْمُتْنِ مَتِيْ تًا تَنِتَ","Makhraj = Ujung lidah bertemu gusi bagian atas\nSifat = Hams, Syiddah, Infitah, Ishmat",R.raw.ta));
        list.add(new HijaiyahItem("د (Dal)","دَا دِيْ دُوْ بَدْ دُوْ دَنْ دَنِ دَدْنَ مِنَ لْمُدْنِ مَدِيْ دًا دَنِدَ","Makhraj = Ujung lidah bertemu gusi bagian atas\nSifat = Jahr, Syiddah, Istifal, Ishmat, Qalqalah",R.raw.da));
        list.add(new HijaiyahItem("ط (Tha)","طَا طِيْ طُوْ بَطْ طُوْ طَنْ طَنِ طَطْنَ مِنَ لْمُطْنِ مَطِيْ طًا طَنِطَ","Makhraj = Ujung lidah bertemu gusi bagian atas\nSifat = Jahr, Syiddah, Isti\'la, Ithbaq, Ishmat, Qalqalah",R.raw.tho));
        list.add(new HijaiyahItem("ز (Zai)","زَا زِيْ زُوْ بَزْ زُوْ زَنْ زَنِ زَزْنَ مِنَ لْمُزْنِ مَزِيْ زًا زَنِزَ","Makhraj = Ujung lidah bawah menyentuh gigi seri bawah\nSifat = Jahr, Rakhawah, Istifal, Infitah, Ishmat, Shafir",R.raw.za));
        list.add(new HijaiyahItem("س (Sin)","سَا سِيْ سُوْ بَسْ سُوْ سَنْ سَنِ سَسْنَ مِنَ لْمُسْنِ مَسِيْ سًا سَنِسَ","Makhraj = Ujung lidah bawah menyentuh gigi seri bawah\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat",R.raw.sa));
        list.add(new HijaiyahItem("ص (Shad)","صَا صِيْ صُوْ بَصْ صُوْ صَنْ صَنِ صَصْنَ مِنَ لْمُصْنِ مَصِيْ صًا صَنِصَ","Makhraj = Ujung lidah bawah menyentuh gigi seri bawah\nSifat = Hams, Rakhawah, Isti\'la, Ithbaq, Ishmat, Shafir",R.raw.sho));
        list.add(new HijaiyahItem("ث (Tsa)","ثَا ثِيْ ثُوْ بَثْ ثُوْ ثَنْ ثَنِ ثَثْنَ مِنَ لْمُثْنِ مَثِيْ ثًا ثَنِثَ","Makhraj = Ujung lidah bawah menyentuh gigi seri atas\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat",R.raw.tsa));
        list.add(new HijaiyahItem("ذ (Dzal)","ذَا ذِيْ ذُوْ بَذْ ذُوْ ذَنْ ذَنِ ذَذْنَ مِنَ لْمُذْنِ مَذِيْ ذًا ذَنِذَ","Makhraj = Ujung lidah bawah menyentuh gigi seri atas\nSifat = Jahr, Rakhawah, Istifal, Infitah, Ishmat",R.raw.dza));
        list.add(new HijaiyahItem("ظ (Dha)","ظَا ظِيْ ظُوْ بَظْ ظُوْ ظَنْ ظَنِ ظَظْنَ مِنَ لْمُظْنِ مَظِيْ ظًا ظَنِظَ","Makhraj = Ujung lidah bawah menyentuh gigi seri atas\nSifat = Jahr, Rakhawah, Isti\'la, Ithbaq, Ishmat",R.raw.dhodz));

    }

    private void setRecview(){
        rView.setLayoutManager(new LinearLayoutManager(this));
        HijaiyahAdapter hijaiyahAdapter = new HijaiyahAdapter(list,this);
        rView.setAdapter(hijaiyahAdapter);
    }
}
