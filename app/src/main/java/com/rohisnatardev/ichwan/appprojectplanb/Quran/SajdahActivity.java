package com.rohisnatardev.ichwan.appprojectplanb.Quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class SajdahActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<SajdahItem> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sajdah);

        recyclerView = findViewById(R.id.rvSajdah);

        inData();
        inRecycler();
    }
    private void inData(){
        itemList = new ArrayList<>();
        itemList.add(new SajdahItem("Al-Araf ayat 206","إِنَّ الَّذِينَ عِندَ رَبِّكَ لَا يَسْتَكْبِرُونَ عَنْ عِبَادَتِهِ وَيُسَبِّحُونَهُ وَلَهُ يَسْجُدُونَ","Sesungguhnya orang-orang yang ada di sisi Tuhanmu tidak merasa enggan untuk menyembah Allah dan mereka menyucikan-Nya dan hanya kepada-Nya mereka bersujud"));
        itemList.add(new SajdahItem("Ar-Rad ayat 15","وَلِلَّهِ يَسْجُدُ مَن فِي السَّمَاوَاتِ وَالْأَرْضِ طَوْعًا وَكَرْهًا وَظِلَالُهُم بِالْغُدُوِّ وَالْآصَالِ","Dan semua sujud kepada Allah baik yang di langit maupun yang di bumi, baik dengan kemauan sendiri maupun terpaksa (dan sujud pula) bayang-bayang mereka, pada waktu pagi dan petang hari."));
        itemList.add(new SajdahItem("An-Nahl ayat 50","وَلِلَّهِ يَسْجُدُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مِن دَابَّةٍ وَالْمَلَائِكَةُ وَهُمْ لَا يَسْتَكْبِرُونَ","Mereka takut kepada Tuhan yang (berkuasa) di atas mereka dan melaksanakan apa yang diperintahkan (kepada mereka)."));
        itemList.add(new SajdahItem("Al-Isra ayat 109","وَيَخِرُّونَ لِلْأَذْقَانِ يَبْكُونَ وَيَزِيدُهُمْ خُشُوعًا ","Dan mereka menyungkurkan wajah sambil menangis dan mereka bertambah khusyuk."));
        itemList.add(new SajdahItem("Maryam ayat 58","أُولَٰئِكَ الَّذِينَ أَنْعَمَ اللَّهُ عَلَيْهِم مِّنَ النَّبِيِّينَ مِن ذُرِّيَّةِ آدَمَ وَمِمَّنْ حَمَلْنَا مَعَ نُوحٍ وَمِن ذُرِّيَّةِ إِبْرَاهِيمَ وَإِسْرَائِيلَ وَمِمَّنْ هَدَيْنَا وَاجْتَبَيْنَا ۚ إِذَا تُتْلَىٰ عَلَيْهِمْ آيَاتُ الرَّحْمَٰنِ خَرُّوا سُجَّدًا وَبُكِيًّا ","Mereka itulah orang yang telah diberi nikmat oleh Allah, yaitu dari (golongan) para nabi dari keturunan Adam, dan dari orang yang Kami bawa (dalam kapal) bersama Nuh, dan dari keturunan Ibrahim dan Israil (Yakub) dan dari orang yang telah Kami beri petunjuk dan telah Kami pilih. Apabila dibacakan ayat-ayat Allah Yang Maha Pengasih kepada mereka, maka mereka tunduk sujud dan menangis."));
        itemList.add(new SajdahItem("Al-Hajj ayat 18","أَلَمْ تَرَ أَنَّ اللَّهَ يَسْجُدُ لَهُ مَن فِي السَّمَاوَاتِ وَمَن فِي الْأَرْضِ وَالشَّمْسُ وَالْقَمَرُ وَالنُّجُومُ وَالْجِبَالُ وَالشَّجَرُ وَالدَّوَابُّ وَكَثِيرٌ مِّنَ النَّاسِ ۖ وَكَثِيرٌ حَقَّ عَلَيْهِ الْعَذَابُ ۗ وَمَن يُهِنِ اللَّهُ فَمَا لَهُ مِن مُّكْرِمٍ ۚ إِنَّ اللَّهَ يَفْعَلُ مَا يَشَاءُ","Tidakkah engkau tahu bahwa siapa yang ada di langit dan siapa yang ada di bumi bersujud kepada Allah, juga matahari, bulan, bintang, gunung-gunung, pohon-pohon, hewan-hewan yang melata dan banyak di antara manusia? Tetapi banyak (manusia) yang pantas mendapatkan azab. Barangsiapa dihinakan Allah, tidak seorang pun yang akan memuliakannya. Sungguh, Allah berbuat apa saja yang Dia kehendaki."));
        itemList.add(new SajdahItem("Al-Hajj ayat 77","يَا أَيُّهَا الَّذِينَ آمَنُوا ارْكَعُوا وَاسْجُدُوا وَاعْبُدُوا رَبَّكُمْ وَافْعَلُوا الْخَيْرَ لَعَلَّكُمْ تُفْلِحُونَ","Wahai orang-orang yang beriman! Rukuklah, sujudlah, dan sembahlah Tuhanmu; dan berbuatlah kebaikan, agar kamu beruntung."));
        itemList.add(new SajdahItem("An-Naml ayat 26","اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ رَبُّ الْعَرْشِ الْعَظِيمِ","Allah, tidak ada tuhan melainkan Dia, Tuhan yang mempunyai ‘Arsy yang agung."));
        itemList.add(new SajdahItem("As-Sajdah ayat 15","إِنَّمَا يُؤْمِنُ بِآيَاتِنَا الَّذِينَ إِذَا ذُكِّرُوا بِهَا خَرُّوا سُجَّدًا وَسَبَّحُوا بِحَمْدِ رَبِّهِمْ وَهُمْ لَا يَسْتَكْبِرُونَ","Orang-orang yang beriman dengan ayat-ayat Kami, hanyalah orang-orang yang apabila diperingatkan dengannya (ayat-ayat Kami), mereka menyungkur sujud dan bertasbih serta memuji Tuhannya, dan mereka tidak menyombongkan diri."));
        itemList.add(new SajdahItem("Fussilat ayat 38","فَإِنِ اسْتَكْبَرُوا فَالَّذِينَ عِندَ رَبِّكَ يُسَبِّحُونَ لَهُ بِاللَّيْلِ وَالنَّهَارِ وَهُمْ لَا يَسْأَمُونَ","Jika mereka menyombongkan diri, maka mereka (malaikat) yang di sisi Tuhanmu bertasbih kepada-Nya pada malam dan siang hari, sedang mereka tidak pernah jemu."));
        itemList.add(new SajdahItem("An-Najm ayat 26","فَاسْجُدُوا لِلَّهِ وَاعْبُدُوا","Maka bersujudlah kepada Allah dan sembahlah (Dia)."));
        itemList.add(new SajdahItem("Al-Insyiqaq ayat 21","وَإِذَا قُرِئَ عَلَيْهِمُ الْقُرْآنُ لَا يَسْجُدُونَ ","Dan apabila Al-Qur'an dibacakan kepada mereka, mereka tidak (mau) bersujud."));
        itemList.add(new SajdahItem("Al-Alaq ayat 19","كَلَّا لَا تُطِعْهُ وَاسْجُدْ وَاقْتَرِب","Sekali-kali tidak! Janganlah kamu patuh kepadanya; dan sujudlah serta dekatkanlah (dirimu kepada Allah)."));
        itemList.add(new SajdahItem("Sad ayat 24","قَالَ لَقَدْ ظَلَمَكَ بِسُؤَالِ نَعْجَتِكَ إِلَىٰ نِعَاجِهِ ۖ وَإِنَّ كَثِيرًا مِّنَ الْخُلَطَاءِ لَيَبْغِي بَعْضُهُمْ عَلَىٰ بَعْضٍ إِلَّا الَّذِينَ آمَنُوا وَعَمِلُوا الصَّالِحَاتِ وَقَلِيلٌ مَّا هُمْ ۗ وَظَنَّ دَاوُودُ أَنَّمَا فَتَنَّاهُ فَاسْتَغْفَرَ رَبَّهُ وَخَرَّ رَاكِعًا وَأَنَابَ","Dia (Dawud) berkata, “Sungguh, dia telah berbuat zhalim kepadamu dengan meminta kambingmu itu untuk (ditambahkan) kepada kambingnya. Memang banyak di antara orang-orang yang bersekutu itu berbuat zhalim kepada yang lain, kecuali orang-orang yang beriman dan mengerjakan kebajikan; dan hanya sedikitlah mereka yang begitu.” Dan Dawud menduga bahwa Kami mengujinya; maka dia memohon ampunan kepada Tuhannya lalu menyungkur sujud dan bertobat."));
    }

    private void inRecycler(){
        SajdahAdapter sajdahAdapter = new SajdahAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sajdahAdapter);
    }
}
