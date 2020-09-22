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

public class AlLisanActivity extends AppCompatActivity {

    RecyclerView rView;
    List<IqraItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_lisan);

        rView = findViewById(R.id.rv_hijaiyah_lisan);

        dataLisan();
        setRecview();

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSyaf = new Intent(AlLisanActivity.this,AsSyafActivity.class);
                startActivity(intentSyaf);
            }
        });

    }

    private void dataLisan(){
        list = new ArrayList<>();
        list.add(new IqraItem("ق (Qaf)","قَ قِ قُ بَقْ قُوْ قَنْ قَنِ قَقْنَ مِنَ لْمُقْنِ مَقِقً قَنِقَ","Makhraj = Pangkal lidah\nSifat = Jahr, Syiddah, Isti'la, Infitah, Ishmat, Qalqalah",R.raw.qof));
        list.add(new IqraItem("ك (Kaf)","كَ كِ كُ بَكْ كُوْ كَنْ كَنِ كَكْنَ مِنَ لْمُكْنِ مَكِكً كَنِكَ","Makhraj = Pangkal lidah\nSifat = Hams, Syiddah, Istifal, Infitah, Ishmat",R.raw.kaf));
        list.add(new IqraItem("ج (Jim)","جَ جِ جُ بَجْ جُوْ جَنْ جَنِ جَجْنَ مِنَ لْمُجْنِ مَجِجً جَنِجَ","Makhraj = Tengah atau punggung lidah menyentuh langit-langit\nSifat = Jahr, Syiddah, Istifal, Infitah, Ishmat, Qalqalah",R.raw.ja));
        list.add(new IqraItem("ي (Ya)","يَ يِ يُ بَيْ يُوْ يَنْ يَنِ يَيْنَ مِنَ لْمُيْنِ مَيِيً يَنِيَ","Makhraj = Tengah atau punggung lisan\nSifat = Jahr, Rakhawah, Istifal,Infitah, Ishmat",R.raw.ya));
        list.add(new IqraItem("ش (Syin)","شَ شِ شُ بَشْ شُوْ شَنْ شَنِ شَشْنَ مِنَ لْمُشْنِ مَشِشً شَنِشَ","Makhraj = Tengah atau punggung lisan\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat, Tafassyi",R.raw.sya));
        list.add(new IqraItem("ض (Dlad)","ضَ ضِ ضُ بَضْ ضُوْ ضَنْ ضَنِ ضَضْنَ مِنَ لْمُضْنِ مَضِضً ضَنِضَ","Makhraj = Kedua samping lidah atau salah satunya menyentuh gigi-gigi atas\nSifat = Jahr, Isti\'la, Ithbaq, Istithalah",R.raw.dho));
        list.add(new IqraItem("ل (Lam)","لَ لِ لُ بَلْ لُوْ لَنْ لَنِ لَلْنَ مِنَ لْمُلْنِ مَلِلً لَنِلَ","Makhraj = Ujung lidah atas bertemu langit-langit\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq, Inhiraf",R.raw.la));
        list.add(new IqraItem("ن (Nun)","نَ نِ نُ بَنْ نُوْ نَنْ نَنِ نَنْنَ مِنَ لْمُنْنِ مَنِنً نَنِنَ","Makhraj = Ujung lidah atas bertemu langit-langit\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq",R.raw.na));
        list.add(new IqraItem("ر (Ra)","رَ رِ رُ بَرْ رُوْ رَنْ رَنِ رَرْنَ مِنَ لْمُرْنِ مَرِرً رَنِرَ","Makhraj = Ujung lidah atas bertemu langit-langit\nSifat = Jahr, Tawassuth, Istifal, Infitah, Idzlaq, Takrir",R.raw.ra));
        list.add(new IqraItem("ت (Ta)","تَ تِ تُ بَتْ تُوْ تَنْ تَنِ تَتْنَ مِنَ لْمُتْنِ مَتِتً تَنِتَ","Makhraj = Ujung lidah bertemu gusi bagian atas\nSifat = Hams, Syiddah, Infitah, Ishmat",R.raw.ta));
        list.add(new IqraItem("د (Dal)","دَ دِ دُ بَدْ دُوْ دَنْ دَنِ دَدْنَ مِنَ لْمُدْنِ مَدِدً دَنِدَ","Makhraj = Ujung lidah bertemu gusi bagian atas\nSifat = Jahr, Syiddah, Istifal, Ishmat, Qalqalah",R.raw.da));
        list.add(new IqraItem("ط (Tha)","طَ طِ طُ بَطْ طُوْ طَنْ طَنِ طَطْنَ مِنَ لْمُطْنِ مَطِطً طَنِطَ","Makhraj = Ujung lidah bertemu gusi bagian atas\nSifat = Jahr, Syiddah, Isti\'la, Ithbaq, Ishmat, Qalqalah",R.raw.tho));
        list.add(new IqraItem("ز (Zai)","زَ زِ زُ بَزْ زُوْ زَنْ زَنِ زَزْنَ مِنَ لْمُزْنِ مَزِزً زَنِزَ","Makhraj = Ujung lidah bawah menyentuh gigi seri bawah\nSifat = Jahr, Rakhawah, Istifal, Infitah, Ishmat, Shafir",R.raw.za));
        list.add(new IqraItem("س (Sin)","سَ سِ سُ بَسْ سُوْ سَنْ سَنِ سَسْنَ مِنَ لْمُسْنِ مَسِسً سَنِسَ","Makhraj = Ujung lidah bawah menyentuh gigi seri bawah\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat",R.raw.sa));
        list.add(new IqraItem("ص (Shad)","صَ صِ صُ بَصْ صُوْ صَنْ صَنِ صَصْنَ مِنَ لْمُصْنِ مَصِصً صَنِصَ","Makhraj = Ujung lidah bawah menyentuh gigi seri bawah\nSifat = Hams, Rakhawah, Isti\'la, Ithbaq, Ishmat, Shafir",R.raw.sho));
        list.add(new IqraItem("ث (Tsa)","ثَ ثِ ثُ بَثْ ثُوْ ثَنْ ثَنِ ثَثْنَ مِنَ لْمُثْنِ مَثِثً ثَنِثَ","Makhraj = Ujung lidah bawah menyentuh gigi seri atas\nSifat = Hams, Rakhawah, Istifal, Infitah, Ishmat",R.raw.tsa));
        list.add(new IqraItem("ذ (Dzal)","ذَ ذِ ذُ بَذْ ذُوْ ذَنْ ذَنِ ذَذْنَ مِنَ لْمُذْنِ مَذِذً ذَنِذَ","Makhraj = Ujung lidah bawah menyentuh gigi seri atas\nSifat = Jahr, Rakhawah, Istifal, Infitah, Ishmat",R.raw.dza));
        list.add(new IqraItem("ظ (Dha)","ظَ ظِ ظُ بَظْ ظُوْ ظَنْ ظَنِ ظَظْنَ مِنَ لْمُظْنِ مَظِظً ظَنِظَ","Makhraj = Ujung lidah bawah menyentuh gigi seri atas\nSifat = Jahr, Rakhawah, Isti\'la, Ithbaq, Ishmat",R.raw.dhodz));

    }

    private void setRecview(){
        rView.setLayoutManager(new LinearLayoutManager(this));
        IqraAdapter iqraAdapter = new IqraAdapter(list,this);
        rView.setAdapter(iqraAdapter);
    }
}
