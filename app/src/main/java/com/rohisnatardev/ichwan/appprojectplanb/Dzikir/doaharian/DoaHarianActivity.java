package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.doaharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class DoaHarianActivity extends AppCompatActivity {

    RecyclerView rvdoa;
    TextView title_doa;
    List<DoaItem> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_harian);

        rvdoa = findViewById(R.id.rvdoaharian);
        dataDoa();
        setDoa();
    }

    private void dataDoa(){
        item = new ArrayList<>();
        item.add(new DoaItem("Doa Masuk Masjid",
                "اَللّٰهُمَّ افْتَحْ لِيْ اَبْوَابَ رَحْمَتِكَ",
                "Alloohummaftahlii abwaaba rohmatik",
                "Ya Allah, bukalah untukku pintu-pintu rahmat-Mu"));

        item.add(new DoaItem("Doa Keluar Masjid",
                "اَللّٰهُمَّ اِنِّى اَسْأَلُكَ مِنْ فَضْلِكَ",
                "Alloohumma inni as aluka min fadhlik",
                "Ya Allah, sesungguhya aku memohon keutamaan darimu"));

        item.add(new DoaItem("Doa Sebelum Tidur",
                "بِسْمِكَ اَللَّهُمَّ اَحْيَا وَبِسْمِكَ اَمُوْتُ",
                "Bismika allohumma ahyaa wabismikaamuut",
                "Dengan nama-Mu yaa Allah, hidupku dan matiku"));

        item.add(new DoaItem("Doa Bangun Tidur",
                "اَلْحَمْدُلِلَّهِ الَّذِيْ اَحْيَانَا بَعْدَ مَا اَمَاتَنَا وَاِلَيْهِ النُّشُوْرُ",
                "Alhamdulillahilladzi ahyaanaa ba'damaa amaatanaa wailaihinnnusur",
                "Segala Puji bagi Allah yang menghidupkan kami sesudah mati/tidur kami, dan kepada-Nya kami kembali"));

        item.add(new DoaItem("Doa Masuk WC",
                "بِسْمِ اللهِ اَللَّهُمَّ اِنىِّ اَعُوْذُبِكَ مِنَ اْلخُبُثِ وَالْخَبَائِثِ",
                "Bismillahi allohumma inni a'uudzubika minal khubutsi wal khobaaits",
                "Dengan nama Allah. Ya Allah, sesungguhnya aku berlindung kepada-Mu dari kejahatan para setan"));

        item.add(new DoaItem("Doa Keluar WC",
                "اَلْحَمْدُلِلَّهِ الَّذِي اَذْهَبَ عَنىِّ الْأَذَى وَعَافَنِى",
                "Alhamdulillahilladzi adzhaba 'anniladza wa'aafani",
                "Ku memohon ampunan-Mu. Segala puji bagi Allah yang telah menghilangkan penyakitku dan telah menyembuhkan/menyelamatkanku"));

        item.add(new DoaItem("Doa Sebelum Makan",
                "اَللَّهُمَّ باَرِكْ لَنَا فِيْمَا رَزَقْتَناَ وَقِنَا عَذَابَ النَّارِ",
                "Allohumma baariklana fiimarozaktanaa waqinaa 'adzabannar",
                "Ya Allah, berkatilah rezeki yang engkau berikan kepada kami, dan peliharalah kami dari siksa api neraka"));

        item.add(new DoaItem("Doa Sesudah Makan",
                "اَلْحَمْدُلِلَّهِ الَّذِيْ اَطْعَمَنَا وَسَقَنَا وَجَعَلَنَا مِنَ الْمُسْلِمِيْنَ",
                "Alhamdulillahilladzii ath'amanaa wasaqonaa waja'alanaa minalmuslimiin",
                "Segala puji bagi Allah yang memberi kami makan dan minum serta menjadikan kami memeluk agama islam"));

        item.add(new DoaItem("Doa Keluar Rumah",
                "بِسْمِ اللهِ تَوَكَّلْتُ عَلَى اللهِ وَلاَ حَوْلَ وَلاَ قُوَّةَ اِلَّا باِللهِ",
                "Bismillahi tawakkaltu 'alallohi walaa haula walaa quwwata illa billahi",
                "Dengan nama Allah aku berserah diri kepada-Nya, dan tiada upaya kecuali dengan pertolongan Allah"));

        item.add(new DoaItem("Doa Ketika Berpakaian",
                "اَلْحَمْدُ لِلَّهِ الَّذِي كَسَانِى هَذَا وَرَزَقَنِيْهِ مِنْ غَيْرِ حَوْلٍ مِنىِّ وَلاَ قُوَّةٍ",
                "Alhamdulillahilladzi kasaanii warozaqonihi min ghoirihaulin minnii walaaquwwatin",
                "Segala puji bagi Allah yang telah memakaikan pakaian ini kepadaku dan mengaruniakanya padaku tanpa daya dan kekuatan dari-Mu"));

        item.add(new DoaItem("Doa Ketika Bercermin",
                "اَللَّهُمَّ كَمَاحَسَّنْتَ خَلْقِيْ فَحَسِّنْ خُلُقِىْ",
                "Allohumma kamaahassamta kholqii fahasin khuluqii",
                "Ya Allah, sebagaimana Engkau telah memperindah kejadianku, maka perindah pulalah akhlakku"));

        item.add(new DoaItem("Doa Ketika Hujan Turun",
                "اللَّهُمَّ صَيِّباً نافِعاً",
                "Allohumma shoyyibannafi'an",
                "Ya Allah, (jadikanlah) hujan ini bermanfaat (bagi kami)"));

        item.add(new DoaItem("Doa Diberi Kemudahan Segala Urusan",
                "اللَّهُمَّ لاَ سَهْلَ إِلاَّ مَا جَعَلْتَهُ سَهْلاً وَأَنْتَ تَجْعَلُ الحَزْنَ إِذَا شِئْتَ سَهْلاً",
                "Allohumma laasahla illama ja'altahu sahlan waanta taj'alul hasna idza syi'ta sahlan",
                "Ya Allah, tidak ada kemudahan kecuali yang Engkau buat mudah. Dan engkau menjadikan kesedihan (kesulitan), jika Engkau kehendaki pasti akan menjadi mudah"));

        item.add(new DoaItem("Doa Pembuka Pintu Rizki dan Keberkahan Ilmu",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ عِلْمًا نَافِعًا وَرِزْقًا طَيِّبًا وَعَمَلًا مُتَقَبَّلًا",
                "Allohumma inna asaluka 'ilmannaafi'an warizqon thoyyiban wa'amalan mutaqobbala",
                "Ya Allah, sungguh aku memohon kepada-Mu ilmu yang bermanfaat (bagi diriku dan orang lain), rizki yang halal dan amal yang diterima (di sisi-Mu dan mendapatkan ganjaran yang baik"));

        item.add(new DoaItem("Doa Mohon Diberi Kecerdasan Berfikir",
                "اَللهُمَّ اَلْهِمْنِىْ رُشْدِيْ وَقِنِىْ شَرِّ نَفْسِىْ" ,
                "Allohumma alhimni rusydi wafinii syarri nafsii",
                "Ya Allah, ilhamkanlah kepadaku kecerdasan dan lindungilah aku dari kejahatan nafsuku"));

        item.add(new DoaItem("Doa Ketika Mendapatkan Pujian dari Orang Lain",
                "اَللَّهُمَّ لاَ تُؤَاخِذْنِيْ بِمَا يَقُوْلُوْنَ، وَاغْفِرْلِيْ مَا لاَ يَعْلَمُوْنَ وَاجْعَلْنِيْ خَيْرًا مِمَّا يَظُنُّوْنَ",
                "Allohumma la tu'khidznii bimaayaquuluuna, waghfirlii maa laa ya'lamunaa waj'alnii khoirommimma yadzunnuuna",
                "Ya Allah, semoga Engkau tidak menghukumku karena apa yang mereka katakan. Ampunilah aku atas apa yang tidak mereka ketahui. Dan jadikanlah aku lebih baik daripada yang mereka perkirakan"));

        item.add(new DoaItem("Doa Untuk Kedua Orangtua",
                "اَللّهُمَّ اغْفِرْلِى وَلِوَالِدَيَّ وَارْحَمْهُمَا كَمَارَبَّيَانِي صَغِيْرًا",
                "Allohummaghfirlii waliwaalidayya warhamhumaa kamaarobbayani shoghiroo",
                "Ya Allah, ampunilah aku dan kedua orangtuaku, dan sayangilah keduanya sebagaimana keduanya menyayangai aku sewaktu kecil"));

        item.add(new DoaItem("Doa Sujud Sahwi",
                "سُـبْحَانَ مَنْ لاَ يَنَامُ وَلاَ يَسْهُوْ",
                "Subhaana mallayanaamu walla yashu",
                "Maha Suci Allah yang tidak tidur dan lupa"));

        item.add(new DoaItem("Doa Kafaratul Majlis",
                "سُبْحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ، أَشْهَدُ أَنْ لاَ إِلَـٰهَ إِلاَّ أَنْتَ، أَسْتَغْفِرُكَ، وَأَتُوْبُ إِلَيْكَ",
                "Subhanallohumma wabihamdika asyhadu alla ilaha illa anta, astaghfiruka wa atuubuilaik",
                "Maha Suci Engkau ya Allah, aku memujiMu. Aku bersaksi bahwa tidak ada sesembahan yang berhak disembah kecuali Engkau, aku minta ampun dan bertaubat kepada-Mu"));

    }

    private void setDoa(){
        DoaAdapter doaAdapter = new DoaAdapter(item);
        rvdoa.setLayoutManager(new LinearLayoutManager(this));
        rvdoa.setAdapter(doaAdapter);
    }
}
