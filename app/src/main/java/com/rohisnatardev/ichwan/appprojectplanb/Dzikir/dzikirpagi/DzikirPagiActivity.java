package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpagi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class DzikirPagiActivity extends AppCompatActivity {

    RecyclerView rvdpagi;
    TextView title_dpagi;
    List<DzikirPagiItem> dpagilist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzikir_pagi);

        rvdpagi = findViewById(R.id.rvdzikirpagi);

        dataDzikirPagi();
        dataRecyclerdPagi();
    }

    private void dataDzikirPagi(){
        dpagilist = new ArrayList<>();

        dpagilist.add(new DzikirPagiItem("Ta\'awudz","Dibaca 1x",
                "أَعُوذُ بِاللَّهِ السَّمِيعِ الْعَلِيمِ، مِنَ الشَّيْطَانِ الرَّجِيمِ","A'udzubillaahis samii'il 'aliimi minassyaithoonirrojiim",
                "Aku berlindung kepada Allah Yang Maha Mendengar lagi Maha Mengetahui dari godaan setan yang terkutuk"));

        dpagilist.add(new DzikirPagiItem("Al-Fatihah","Dibaca 1x",
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ\n" +
                        "اَلْحَمْدُ لِلّٰهِ رَبِّ الْعٰلَمِيْنَۙ\n" +
                        "الرَّحْمٰنِ الرَّحِيْمِۙ\n" +
                        "مٰلِكِ يَوْمِ الدِّيْنِۗ\n" +
                        "اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْنُۗ\n" +
                        "اِهْدِنَا الصِّرَاطَ الْمُسْتَقِيْمَ ۙ\n" +
                        "صِرَاطَ الَّذِيْنَ اَنْعَمْتَ عَلَيْهِمْ ەۙ غَيْرِ الْمَغْضُوْبِ عَلَيْهِمْ وَلَا الضَّاۤلِّيْنَ",
                "Bismillahirrohmaanirrohiim * Al hamdulillaahirobbil 'aalamiin * Ar rohmaanir rohiim * Maaliki yaumid diin * Iyya ka na'budu wa iyya ka nasta 'iin * ihdinash shiroothol mustaqiim * Shirootol ladzina an'amta 'alaihim ghoiril magh dhuu bi 'alaihim wa ladh dhool liin",
                "Dengan nama Allah Yang Maha Pengasih, Maha Penyayang. * Segala puji bagi Allah, Tuhan seluruh alam, * Yang Maha Pengasih, Maha Penyayang, * Pemilik hari pembalasan. * Hanya kepada Engkaulah kami menyembah dan hanya kepada Engkaulah kami mohon pertolongan. * Tunjukilah kami jalan yang lurus, * (yaitu) jalan orang-orang yang telah Engkau beri nikmat kepadanya; bukan (jalan) mereka yang dimurkai, dan bukan (pula jalan) mereka yang sesat."));
        dpagilist.add(new DzikirPagiItem("Al-Baqarah 1-5","Dibaca 1x",
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ\n" +
                        "الۤمّۤ ۚ\n" +
                        "ذٰلِكَ الْكِتٰبُ لَا رَيْبَ ۛ فِيْهِ ۛ هُدًى لِّلْمُتَّقِيْنَۙ\n" +
                        "الَّذِيْنَ يُؤْمِنُوْنَ بِالْغَيْبِ وَيُقِيْمُوْنَ الصَّلٰوةَ وَمِمَّا رَزَقْنٰهُمْ يُنْفِقُوْنَ ۙ\n" +
                        "وَالَّذِيْنَ يُؤْمِنُوْنَ بِمَآ اُنْزِلَ اِلَيْكَ وَمَآ اُنْزِلَ مِنْ قَبْلِكَ ۚ وَبِالْاٰخِرَةِ هُمْ يُوْقِنُوْنَۗ\n" +
                        "اُولٰۤىِٕكَ عَلٰى هُدًى مِّنْ رَّبِّهِمْ ۙ وَاُولٰۤىِٕكَ هُمُ الْمُفْلِحُوْنَ\n",
                "Alif Laam Miim * Dza likal kitaabu laaroi bafiihi hudal lilmuttaqiin * Al ladziina yu'minuna bil ghoibi wa yuqiimunassholaata wa mimma rozaqnaahum yung fiquun * Walladziina yu' minuuna bimaa unzila ilaika wa maa unzila ming qoblika wa bil aakhiroti hum yuu qinuun * Ulaa ika 'ala hudam mir robbihim wa ulaa ika humul muflihuun",
                "Kitab (Al-Qur'an) ini tidak ada keraguan padanya; petunjuk bagi mereka yang bertakwa, * (yaitu) mereka yang beriman kepada yang gaib, melaksanakan salat, dan menginfakkan sebagian rezeki yang Kami berikan kepada mereka, * dan mereka yang beriman kepada (Al-Qur'an) yang diturunkan kepadamu (Muhammad) dan (kitab-kitab) yang telah diturunkan sebelum engkau, dan mereka yakin akan adanya akhirat. * Merekalah yang mendapat petunjuk dari Tuhannya, dan mereka itulah orang-orang yang beruntung. * Sesungguhnya orang-orang kafir, sama saja bagi mereka, engkau (Muhammad) beri peringatan atau tidak engkau beri peringatan, mereka tidak akan beriman. * Allah telah mengunci hati dan pendengaran mereka, penglihatan mereka telah tertutup, dan mereka akan mendapat azab yang berat."));
        dpagilist.add(new DzikirPagiItem("Al-Baqarah 255-257","Dibaca 1x",
                "اَللّٰهُ لَآ اِلٰهَ اِلَّا هُوَۚ اَلْحَيُّ الْقَيُّوْمُ ەۚ لَا تَأْخُذُهٗ سِنَةٌ وَّلَا نَوْمٌۗ لَهٗ مَا فِى السَّمٰوٰتِ وَمَا فِى الْاَرْضِۗ مَنْ ذَا الَّذِيْ يَشْفَعُ عِنْدَهٗٓ اِلَّا بِاِذْنِهٖۗ يَعْلَمُ مَا بَيْنَ اَيْدِيْهِمْ وَمَا خَلْفَهُمْۚ وَلَا يُحِيْطُوْنَ بِشَيْءٍ مِّنْ عِلْمِهٖٓ اِلَّا بِمَا شَاۤءَۚ وَسِعَ كُرْسِيُّهُ السَّمٰوٰتِ وَالْاَرْضَۚ وَلَا يَـُٔوْدُهٗ حِفْظُهُمَاۚ وَهُوَ الْعَلِيُّ الْعَظِيْمُ\n" +
                        "لَآ اِكْرَاهَ فِى الدِّيْنِۗ قَدْ تَّبَيَّنَ الرُّشْدُ مِنَ الْغَيِّ ۚ فَمَنْ يَّكْفُرْ بِالطَّاغُوْتِ وَيُؤْمِنْۢ بِاللّٰهِ فَقَدِ اسْتَمْسَكَ بِالْعُرْوَةِ الْوُثْقٰى لَا انْفِصَامَ لَهَا ۗوَاللّٰهُ سَمِيْعٌ عَلِيْمٌ\n" +
                        "اَللّٰهُ وَلِيُّ الَّذِيْنَ اٰمَنُوْا يُخْرِجُهُمْ مِّنَ الظُّلُمٰتِ اِلَى النُّوْرِۗ وَالَّذِيْنَ كَفَرُوْٓا اَوْلِيَاۤؤُهُمُ الطَّاغُوْتُ يُخْرِجُوْنَهُمْ مِّنَ النُّوْرِ اِلَى الظُّلُمٰتِۗ اُولٰۤىِٕكَ اَصْحٰبُ النَّارِۚ هُمْ فِيْهَا خٰلِدُوْنَ\n",
                "Alloohu laa ilaaha illa huwal hayyul qoyyuumu laa ta'khuzuhuu sinatuw walaa naumun lahuu maa fissamaawaati wa maa fil ardhi man dzalladzii yasyfa'u 'indahu illa bi idznihi ya'lamu maa ba ina aidiihim wa maa kholfahum wa laa yuhiithuuna bisyai-in min 'ilmihi illaa bi maa syaa -a wasi'a kursiyyuhus-samawaati wal ardhi wa laa yauuduhu hi fzuhuma wahuwal 'ali yyul 'azhiim * La ikroha fid-diini qot tabayyanar-rusydu minal ghoyyi famay yakfur bith-thooghuuti wa yu' minu billahi faqo dis tamsaka bil 'urwatil wutsqoo lan fishooma laha wallohu samii'un aliim * Allohu waliyyul ladziina aamanuu yukhrijuhum minazh-zhulumaati ilan-n uuri walladziina kafaruu awliyaa-u humuth-thooghutu yukhri-juunahum minan-nuuri ilazh-zhulumaati ulaa-ika ash-haabun-naarihum fiihaa khooliduun",
                "Allah, tidak ada tuhan selain Dia. Yang Mahahidup, Yang terus menerus mengurus (makhluk-Nya), tidak mengantuk dan tidak tidur. Milik-Nya apa yang ada di langit dan apa yang ada di bumi. Tidak ada yang dapat memberi syafaat di sisi-Nya tanpa izin-Nya. Dia mengetahui apa yang di hadapan mereka dan apa yang di belakang mereka, dan mereka tidak mengetahui sesuatu apa pun tentang ilmu-Nya melainkan apa yang Dia kehendaki. Kursi-Nya meliputi langit dan bumi. Dan Dia tidak merasa berat memelihara keduanya, dan Dia Mahatinggi, Mahabesar.* Tidak ada paksaan dalam (menganut) agama (Islam), sesungguhnya telah jelas (perbedaan) antara jalan yang benar dengan jalan yang sesat. Barang siapa ingkar kepada Tagut dan beriman kepada Allah, maka sungguh, dia telah berpegang (teguh) pada tali yang sangat kuat yang tidak akan putus. Allah Maha Mendengar, Maha Mengetahui. * Allah pelindung orang yang beriman. Dia mengeluarkan mereka dari kegelapan kepada cahaya (iman). Dan orang-orang yang kafir, pelindung-pelindungnya adalah setan, yang mengeluarkan mereka dari cahaya kepada kegelapan. Mereka adalah penghuni neraka. Mereka kekal di dalamnya."));
        dpagilist.add(new DzikirPagiItem("Al-Baqarah 284-286","Dibaca 1x",
                "لِلّٰهِ مَا فِى السَّمٰوٰتِ وَمَا فِى الْاَرْضِ ۗ وَاِنْ تُبْدُوْا مَا فِيْٓ اَنْفُسِكُمْ اَوْ تُخْفُوْهُ يُحَاسِبْكُمْ بِهِ اللّٰهُ ۗ فَيَغْفِرُ لِمَنْ يَّشَاۤءُ وَيُعَذِّبُ مَنْ يَّشَاۤءُ ۗ وَاللّٰهُ عَلٰى كُلِّ شَيْءٍ قَدِيْرٌ\n" +
                        "اٰمَنَ الرَّسُوْلُ بِمَآ اُنْزِلَ اِلَيْهِ مِنْ رَّبِّهٖ وَالْمُؤْمِنُوْنَۗ كُلٌّ اٰمَنَ بِاللّٰهِ وَمَلٰۤىِٕكَتِهٖ وَكُتُبِهٖ وَرُسُلِهٖۗ لَا نُفَرِّقُ بَيْنَ اَحَدٍ مِّنْ رُّسُلِهٖ ۗ وَقَالُوْا سَمِعْنَا وَاَطَعْنَا غُفْرَانَكَ رَبَّنَا وَاِلَيْكَ الْمَصِيْرُ\n" +
                        "لَا يُكَلِّفُ اللّٰهُ نَفْسًا اِلَّا وُسْعَهَا ۗ لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَا اكْتَسَبَتْ ۗ رَبَّنَا لَا تُؤَاخِذْنَآ اِنْ نَّسِيْنَآ اَوْ اَخْطَأْنَا ۚ رَبَّنَا وَلَا تَحْمِلْ عَلَيْنَآ اِصْرًا كَمَا حَمَلْتَهٗ عَلَى الَّذِيْنَ مِنْ قَبْلِنَا ۚ رَبَّنَا وَلَا تُحَمِّلْنَا مَا لَا طَاقَةَ لَنَا بِهٖۚ وَاعْفُ عَنَّاۗ وَاغْفِرْ لَنَاۗ وَارْحَمْنَا ۗ اَنْتَ مَوْلٰىنَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكٰفِرِيْنَ\n",
                "Lillahi maa fis-samawaati wa maa fil ardhi wa in tubduu ma fii anfusikum aw tukhfuuhu yuhaasibkum bi hillaahu fayaghfiru limay-yasyaa-u wa yu'adzibu may-yasyaa-u wallohu 'alaa kulli syai-in qodiir * Aamanar rosuulu bima unzila ilaihi mir-robbihi wal mu'minuuna kullu n aamana billahi wa malaaikatihi wa kutubihi wa rusulihi laa nufarriqu baina ahadim-mir-rusulihi waqoluu sami'na wa atho'naa ghufronaka robbana wa ilaikal-mashiiru * Laa yukallifullohu nafsan illa wus'ahaa lahaa maa kasaba t wa 'alaiha maktasabat, robbana laa tuaakhidznaa in nasiina aw akhtho'naa, robbana walaa tahmil 'alainaa ishron kama hamaltahu 'alal-ladziina min qobl inaa, robbana wa laa tuhammilnaa maa laa thooqotalanaa bihi wa'fu 'annaa waghfirlanaa warhamnaa anta maulaanaa fanshurnaa 'alal-qoumil-kaafiriin",
                "Milik Allah-lah apa yang ada di langit dan apa yang ada di bumi. Jika kamu nyatakan apa yang ada di dalam hatimu atau kamu sembunyikan, niscaya Allah memperhitungkannya (tentang perbuatan itu) bagimu. Dia mengampuni siapa yang Dia kehendaki dan mengazab siapa yang Dia kehendaki. Allah Mahakuasa atas segala sesuatu. * Rasul (Muhammad) beriman kepada apa yang diturunkan kepadanya (Al-Qur'an) dari Tuhannya, demikian pula orang-orang yang beriman. Semua beriman kepada Allah, malaikat-malaikat-Nya, kitab-kitab-Nya dan rasul-rasul-Nya. (Mereka berkata), “Kami tidak membeda-bedakan seorang pun dari rasul-rasul-Nya.” Dan mereka berkata, “Kami dengar dan kami taat. Ampunilah kami Ya Tuhan kami, dan kepada-Mu tempat (kami) kembali.” * Allah tidak membebani seseorang melainkan sesuai dengan kesanggupannya. Dia mendapat (pahala) dari (kebajikan) yang dikerjakannya dan dia mendapat (siksa) dari (kejahatan) yang diperbuatnya. (Mereka berdoa), “Ya Tuhan kami, janganlah Engkau hukum kami jika kami lupa atau kami melakukan kesalahan. Ya Tuhan kami, janganlah Engkau bebani kami dengan beban yang berat sebagaimana Engkau bebankan kepada orang-orang sebelum kami. Ya Tuhan kami, janganlah Engkau pikulkan kepada kami apa yang tidak sanggup kami memikulnya. Maafkanlah kami, ampunilah kami, dan rahmatilah kami. Engkaulah pelindung kami, maka tolonglah kami menghadapi orang-orang kafir.”"));
        dpagilist.add(new DzikirPagiItem("Al-Ikhlas","Dibaca 3x",
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ\n" +
                        "قُلْ هُوَ اللّٰهُ اَحَدٌۚ\n" +
                        "اَللّٰهُ الصَّمَدُۚ\n" +
                        "لَمْ يَلِدْ وَلَمْ يُوْلَدْۙ\n" +
                        "وَلَمْ يَكُنْ لَّهٗ كُفُوًا اَحَدٌ\n",
                "Qul huwallohu ahad * Allohusshomad * Lam yalid walam yuulad * Walam yaqullahu kufuwan ahad",
                "Katakanlah (Muhammad), “Dialah Allah, Yang Maha Esa. * Allah tempat meminta segala sesuatu. * (Allah) tidak beranak dan tidak pula diperanakkan. * Dan tidak ada sesuatu yang setara dengan Dia."));
        dpagilist.add(new DzikirPagiItem("Al-Falaq","Dibaca 3x",
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ\n" +
                        "قُلْ اَعُوْذُ بِرَبِّ الْفَلَقِۙ\n" +
                        "مِنْ شَرِّ مَا خَلَقَۙ\n" +
                        "وَمِنْ شَرِّ غَاسِقٍ اِذَا وَقَبَۙ\n" +
                        "وَمِنْ شَرِّ النَّفّٰثٰتِ فِى الْعُقَدِۙ\n" +
                        "وَمِنْ شَرِّ حَاسِدٍ اِذَا حَسَدَ\n",
                "Qul a’uudzubirobbil falaq * Minsarri ma kholaq * Waminsarri ghosiqin idza waqob * Waminsarrin naffatsati fil ‘uqod * Waminsarri khaasidin idza hasad",
                "Katakanlah, “Aku berlindung kepada Tuhan yang menguasai subuh (fajar), * dari kejahatan (makhluk yang) Dia ciptakan, * dan dari kejahatan malam apabila telah gelap gulita, * dan dari kejahatan (perempuan-perempuan) penyihir yang meniup pada buhul-buhul (talinya), * dan dari kejahatan orang yang dengki apabila dia dengki."));
        dpagilist.add(new DzikirPagiItem("An-Nas","Dibaca 3x",
                "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ\n" +
                        "قُلْ اَعُوْذُ بِرَبِّ النَّاسِۙ\n" +
                        "مَلِكِ النَّاسِۙ\n" +
                        "اِلٰهِ النَّاسِۙ\n" +
                        "مِنْ شَرِّ الْوَسْوَاسِ ەۙ الْخَنَّاسِۖ\n" +
                        "الَّذِيْ يُوَسْوِسُ فِيْ صُدُوْرِ النَّاسِۙ\n" +
                        "مِنَ الْجِنَّةِ وَالنَّاسِ\n",
                "Qul a’uudzubirobbinnaas * Malikinnaas * Ilaahinnaas * Minsarril waswaasil khonnaas * Alladzi yuwaswisu fi shuduurinnaas * Minal Jinnati wannaas",
                "Katakanlah, “Aku berlindung kepada Tuhannya manusia * Raja manusia, * sembahan manusia * dari kejahatan (bisikan) setan yang bersembunyi * yang membisikkan (kejahatan) ke dalam dada manusia * dari (golongan) jin dan manusia."));

        dpagilist.add(new DzikirPagiItem("Doa Pagi Hari","Dibaca 3x",
                "اَصْبَحْنَا وَاَصْبَحَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ لاَشَرِيْكَ لَهُ لاَإِلَهَ إِلاَّ هُوَ وَإِلَيْهِ النُّشُوْرُ",
                "Asbahna wa asbaha mulku lillahi walhamdulillahi la syarikallahu la illaha illa huwa wa-ilaihil nusuur",
                "Kami berpagi hari dan berpagi hari pula kerajaan milik Allah. Segala puji bagi Allah, tiada sekutu bagi-Nya, tiada Tuhan melainkan Dia dan kepada-Nya tempat kembali"));
        dpagilist.add(new DzikirPagiItem("Doa Pagi Hari","Dibaca 3x",
                "أَصْبَحْنَا عَلَى فِطْرَةِ الإِسْلاَمِ وَكَلِمَةِ الإِخْلاَصِ وَعَلَى دِيْنِ نَبِيِّنَا مُحَمَّدٍ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ وَعَلَى مِلَّةِ أَبِيْنَا إِبْرَهِيْمَ حَنِيْفًا وَمَا كَانَ مِنَ الْمُشْرِكِيْنَ",
                "Asbahna ’ala fitrotil islam-wa kalimatil ikhlas-wa’ala diini nabiyyina muhammaddin shollalloohu ’alaihi wasallam-wa’ala millatin abiina ibroohiima khanifan wamaa kana minal musyrikiin",
                "Kami berpagi hari di atas fitrah Islam, di atas kalimat ikhlash, di atas agama nabi Muhammad SAW, dan di atas milah (agama) bapak kami; Ibrahim yang hanif. Dan ia bukan termasuk golongan orang-orang yang musyrik"));

        dpagilist.add(new DzikirPagiItem("Doa Pagi Hari","Dibaca 3x",
                "اَللَّهُمَّ اِنِّى أَصْبَحْتُ مِنْكَ فِيْ نِعْمَةٍ وَعَافِيَةٍ وَسِتْرٍ فَاَتِمَّ عَلَيَّ نِعْمَتَكَ وَعَافِيَتَكَ وَسِتْرَكَ فِي الدُّنْيَا وَالآخِرَةِ",
                "Allohumma inni asbahtu minka fi ni’matin wa’afiyatin wa sittrin-fa atimma ’alayya ni’mataka wa’afiyataka wa sit-roka fiddun-ya wal aakhirot",
                "Ya Allah, sesungguhnya kami berpagi hari dari-Mu dalam kenikmatan, kesehatan dan perlindungan. Maka sempurnakanlah bagi kami kenikmatan, kesehatan dan perlindungan-Mu di dunia dan akhirat"));

        dpagilist.add(new DzikirPagiItem("Doa Pagi Hari","Dibaca 3x",
                "اَللَّهُمَّ مَاأَصْبَحَ بِيْ مِنْ نِعْمَةٍ أَوْ بِأَحَدٍ مِنْ خَلْقِكَ فَمِنْكَ وَحْدَكَ لاَشَرِيْكَ لَكَ فَلَكَ الْحَمْدُ وَلَكَ الشُّكْرُ",
                "Allohumma maa asbaha biimini’matin au bi ahadin min kholqika fa minka wahdaka la syariika laka falakalhamdu walakassyukru",
                "Ya Allah, segala kenikmatan yang berpagi hari (terjadi) bersamaku atau bersama salah satu dari makhluk-Mu, adalah dari-Mu semata; tiada sekutu bagi-Mu. Maka bagi-Mu segala puji dan bagi-Mu rasa syukur"));

        dpagilist.add(new DzikirPagiItem("*HR. Imam Ahmad dan Ibnu Majah","Dibaca 3x",
                "يَا رَبِّ لَكَ الْحَمْدُ كَمَا يَنْبَغِيْ لِجَلاَلِ وَجْهِكَ وَعَظِيْمِ سُلْطَانِكَ",
                "Yaa Robbii lakal khamdu kamaa yan baghii lijalali wajhika wa’adhiimi sulthonik",
                "Ya Rabbi, bagi-Mu segala puji sebagaimana seyogyanya bagi kemuliaan wajah-Mu dan keagungan kekuasaan-Mu"));

        dpagilist.add(new DzikirPagiItem("*HR. Abu Dawud","Dibaca 3x",
                "رَضِيْتُ بِاللَّهِ رَبًّا وَبِالْاِسْلاَمِ دِيْنًا وَبِمُحَمَّدً نَبِيًّا وَرَسُوْلاً",
                "Rodhiitu billahi robban wa bil islamidiinan wa bi muhammadin nabiiyyan wa rosuulan",
                "Aku rela Allah sebagai Tuhan, Islam sebagai agama dan Muhammad sebagai Nabi dan Rasul"));

        dpagilist.add(new DzikirPagiItem("*HR. Muslim","Dibaca 3x",
                "سُبْحَانَ اللَّهِ وَبِحَمْدِهِ عَدَدَ خَلْقِهِ وَرِضَا نَفْسِهِ وَزِنَةَ عَرْشِهِ وَمِدَادَ كَلِمَتِهِ",
                "Subhanalloohi wa bihamdihi, ‘adada kholqihi wa ridhoo nafsihi, wa jinata’arsyihi wa midadaa kalimatihi",
                "Maha Suci Allah dan dengan memuji-Nya, sejumlah makhluk-Nya, serela diri-Nya, seberat ‘Arsy-Nya dan sebanyak tinta (bagi) kalimah-Nya"));

        dpagilist.add(new DzikirPagiItem("*HR. Abu Dawud dan Tirmidzi","Dibaca 3x",
                "بِسْمِ اللَّهِ الَّذِ لاَيَضُرُّ مَعَ اسْمِهِ شَيْئٌ فِي الأَرْضِ وَلاَ فِي السَّمَآءِ وَهُوَ السَّمِيْعُ الْعَلِيْمُ",
                "Bismillaahilladzii layadhurru ma’ashmihi syai,un fil ardhi wala fissamaa,i wa huwassami’ul ’aliim",
                "Dengan nama Allah, ysng bersama nama-Nya tidak akan membahayakan sesuatu pun yang ada di bumi dan di langit. Dan Dia Maha Mendengar lagi Maha Mengetahui"));

        dpagilist.add(new DzikirPagiItem("*HR. Imam Ahmad dan Thabrani","Dibaca 3x",
                "اَللَّهُمَّ إِنَّا نَعُوْذُبِكَ مِنْ أَنْ نُشْرِكَ بِكَ شَيْئًا نَعْلَمُهُ وَنَسْتَغْفِرُكَ لِمَا لاَنَعْلَمُهُ",
                "Alloohumma inna na’udzubika min annusrika bika syai,an na’lamuhu wa nashtaghfiruka limaa la na’lamuhu",
                "Ya Allah, sesungguhnya kami berlindung kepada-Mu dari menyekutukan-mu dengan sesuatu yang kami ketahui, dan kami mohon ampun kepada-Mu untuk sesuatu yang tidak kami ketahui"));

        dpagilist.add(new DzikirPagiItem("*HR. Ibnu Hibban","Dibaca 3x",
                "أَعُوْذَ بِكَلِمَاتِ اللَّهِ التَّآمَّاتِ مِنْ شَرِّ مَا خَلَقَ",
                "A’udzubikal-limaatil-laahit tammati min sarri ma kholaqo",
                "Aku berlindung dengan kalimat Allah Yang Maha Sempurna, dari kejahatan (makhluk) yang Ia ciptakan"));

        dpagilist.add(new DzikirPagiItem("*HR. Abu Dawud","Dibaac 3x",
                "اللَّهُمَّ إِنِّي أَعُوْذُ بِكَ مِنَ الهَمِّ وَالْحَزَنِ وَأَعُوْذُ بِكَ مِنَ الْعَجْزِ وَالْكَسَلِ وَأَعُوْذُ بِكَ مِنَ الْجُبْنِ وَالْبُخْلِ وَأَعُوْذُ بِكَ مِنْ غَلَبَةِ الْدَّيْنِ وَقَهْرِالْرِّجَالِ",
                "Alloohumma innii a’udzubika minall hammi wal khajani, wa a’udzubika minnal’aj,ji wal kasali, wa a’udzubika minnal jubni wal buhkli, wa a’udzubika min gholabatid daini wa qohrirrijali",
                "Ya Allah, aku berlindung kepada-Mu dari kegelisahan dan kesedihan, dari kelemahan dan kemalasan, dari sifat pengecut dan bakhil, serta dari beban hutang dan kesewenang-wenangan orang lain"));

        dpagilist.add(new DzikirPagiItem("*HR. Ahmad","Dibaca 3x",
                "اَللَّهُمَّ عَافِنِيْ فِيْ بَدَنِيْ اَللَّهُمَّ عَافِنِيْ فِيْ سَمْعِيْ اَللَّهُمَّ عَافِنِيْ فِيْ بَصَرِيْ",
                "Alloohumma ’afinii fi badanii, alloohumma ’afinii fi sam’i, Alloohumma ’afinii fi basharii",
                "Ya Allah, sehatkanlah badanku; ya Allah, sehatkanlah pendengaranku; ya Allah, sehatkanlah penglihatanku"));

        dpagilist.add(new DzikirPagiItem("*HR. Abu Dawud","Dibaca 3x",
                "اَللَّهُمَّ إِنِّ أَعُوْذَ بِكَ مِنَ الْكُفْرِ وَالْفَقْرِ اَللَّهُمَّ إِنِّ أَعُوْذَ بِكَ مِنْ عَذَابِ َالْقَبْرِ لاَ إِلَهَ إِلاَّ أَنْتَ",
                "Alloohumma innii a’udzubika minal kufri wal fakri, Alloohumma innii a’udzubika min’adzabil qobri, la ilaaha illa anta",
                "Ya Allah, aku berlindung kepada-Mu dari kekufuran dan kefakiran; ya Allah, aku berlindung kepada-Mu dari adzab kubur. Tiada Tuhan kecuali Engkau"));

        dpagilist.add(new DzikirPagiItem("*HR. Bukhari","Dibaca 3x",
                "اللَّهُمَّ أَنْتَ رَبِّيْ لاَ إِلَهَ إِلاَّ أَنْتَ خَلَقْتَنِيْ وَأَنَا عَبْدُكَ وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَاسْتَطَعْتُ أَعُوْذُبِكَ مِنْ شَرِّ مَا صَنَعْتُ أَبُوْءُ بِذَنْبِيْ فَاغْفِرْلِيْ فَإِنَّهُ لاَيَغْفِرُ الذُّنُوْبَ إِلاَّ أَنْتَ",
                "Alloohumma anta robbii la ilaaha illa anta, kholaqtanii wa ana’abduka, wa ana ’alaa ’ahdika, wa wa’dika mastatho’tu, a’udzubika min sarri maa shona’tu, abuu,u bidan bii faghfirlii fa innahu layaghfiru dzunuba illa anta",
                "Ya Allah, Engkaulah Tuhanku, tiada Tuhan kecuali Engkau. Engkau ciptakan aku dan aku adalah hamba-Mu. Aku berada di atas janji-Mu, semampuku. Aku berlindung kepada-Mu dari kejelekan perbuatanku. Aku mengakui banyaknya nikmat-Mu (yang Engkau anugerahkan) kepadaku dan aku mengakui dosa-dosaku, maka ampunilah aku. Karena sesungguhnya tiada yang dapat mengampuni segala dosa-dosa kecuali Engkau"));

        dpagilist.add(new DzikirPagiItem("*HR. Abu Dawud, Tirmidzi dan Hakim","Dibaca 3x",
                "أَسْتَغْفِرُ اللَّهَ الَّذِيْ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّوْمُ وَأَتُوْبُ إِلَيْهِ",
                "Astaghfirullohal ladzii la ilaaha illa huwal khayyul qoyuum wa atubu ilaihi",
                "Aku mohon ampunan kepada Allah, yang tiada Tuhan kecuali Dia, Yang Maha Hidup Kekal dan sesantiasa mengurus (makhluk-Nya) dan kepada-Nya aku bertaubat"));

        dpagilist.add(new DzikirPagiItem("*HR. Thabrani (Shalawat Nabi)","Dibaca 10x",
                "اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ كَمَا صَلَّيْتَ عَلَى سَيِّدِنَا إِبْرَاهِيْمَ وَعَلَى آلِ سَيِّدِنَا إِبْرَاهِيْمَ وَبَارِكْ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِ سَيِّدِنَا مُحَمَّدٍ كَمَا بَارَكْتَ عَلَى سَيِّدِنَا إِبْرَاهِيْمَ وَعَلَى آلِ سَيِّدِنَا إِبْرَاهِيْمَ فِي الْعَالَمِيْنَ إِنَّكَ حَمِيْدٌ مَجِيْدٌ",
                "Alloohumma shalli ’ala Muhammadin, wa’ala ali sayyidinaa Muhammadin, kama shollaita ’ala sayyidinaa ibrohiim wa’ala alii sayyidina ibrohiim, wa barik ’ala sayyidinaa Muhammadin wa’ala alii sayyidinaa Muhammadin, kama barokta ’ala ibrohiim wa’ala alii ibrohiim , fil’alamiina innaka khamiddum majiid",
                "Ya Allah, berikanlah shalawat kepada Muhammad dan keluarga Muhammad, sebagaimana telah Engkau berikan kepada Ibrahim dan keluarga Ibrahim. Berikanlah barakah kepada Muhammad dan keluarga Muhammad sebagaimana telah Engkau berikan kepada Ibrahim dan keluarga Ibrahim, di alam ini. Sesungguhnya Engkau Yang Maha Terpuji lagi Maha Mulia"));

        dpagilist.add(new DzikirPagiItem("*HR. Tirmidzi","Dibaca 100x",
                "سُبْحَانَ اللَّهِ وَالْحَمْدُ لِلَّهِ وَلاَ إِلَهَ إِلاَّ اللَّهُ وَاللَّهُ أَكْبَرُ",
                "Shubhanalloohi wal hamdu lillaahi wala illaaha illalloohu walloohu akbar",
                "Maha Suci Allah, segala puji bagi Allah, tiada Tuhan melainkan Allah dan Allah Maha Besar"));

        dpagilist.add(new DzikirPagiItem("*HR. Imam Ahmad dan Thabrani","Dibaca 10x",
                "لاَ إِلَهَ إِلاَّ اللَّهُ وَحْدَهُ لاَشَرِيْكَ لَهُ, لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيْرٌ",
                "La ilaaha illalloohu wahdahula syarikalahu, lahulmuku walahul khamdu wahuwa ’ala kulli syai,in qodiir",
                "Tiada Tuhan melainkan Allah semata, tiada sekutu bagi-Nya, bagi-Nya kerajaan dan bagi-Nya segala puji, dan Dia berkuasa atas segala sesuatu"));

        dpagilist.add(new DzikirPagiItem("*HR. Nasa'i dan Hakim","Dibaca 3x",
                "سُبْحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ أَشْهَدُ أَنْ لاَ إِلَهَ إِلاَّ أَنْتَ أَسْتَغْفِرُكَ وَأَتُوْبُ إِلَيْكَ",
                "Subhanakalloohumma wabihamdika asyhadu alla ilaaha illa anta astaghfiruka wa atuubu ilaika",
                "Maha Suci Engkau, ya Allah, dan dengan memuji-Mu, aku bersaksi bahwa tiada Tuhan melainkan Engkau, aku mohon ampun dan bertaubat kepada-Mu"));

        dpagilist.add(new DzikirPagiItem("*Perkataan Imam Nawawi dalam kitab Al-Adzkar","Dibaca 1x",
                "اللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ عَبْدِكَ وَنَبِيِّكَ وَرَسُوْلِكَ النَّبِيِّ الأُمِّيِّ وَعَلَىْ آلِهِ وَصَحْبِهِ وَسَلِّمْ تَسْلِيْمًا عَدَدَ مَا أَحَاطَ بِهِ عِلْمُكَ وَخَطَّ بِهِ قَلَمُكَ وَأَحْصَاهُ كِتَابُكَ وَارْضَ اللَّهُمَّ عَنْ سَادَتَنَا أَبِيْ بَكْرٍ وَعُمَرَ وَعُثْمَانَ وَعَلِيِّ وَعَنِ الصَّحَابَةِ أَجْمَعِيْنَ وَعَنِ التَّابِعِيْنَ وَتَابِعِيْهِمْ بِإِحْسَانٍ إِلَى يَوْمِ الدِّيْنِ. سُبْحَانَ رَبِّكَ رَبِّ الْعِزَّةِ عَمَّا يَصِفُوْنَ وَسَلاَمٌ عَلَى الْمُرْسَلِيْنَ وَالْحَمْدُ لِلَّهِ رَبِّ الْعَالَمِيْنَ",
                "Alloohumma sholli ’alaa sayyidinaa Muhammadin ’abdika wanabiyyika wa rosuulika nabiyyil ummiyyii wa’ala alihii wa shohbihi wasallim tasliiman ’adada maa ahatho bihi ’ilmuka, wa khotto’bihi qolamuka, wa ah-shohu kitabuka, wardho llohumma ’an sadatinaa abii bakrin, wa ’umaro, wa ’usman, wa’alii, wa’anishokhabati ajma’iin, wa’anit tabi’ina wa tabi’iihim bi ihsanin illa yaumiddiin. Subhaanaka robbika robbil’izati ’amma yasifuun, wa salamun’alal mursalin wal hamdu lillaahi robbil’alamiin",
                "Ya Allah, berikanlah shalawat kepada nabi Muhammad sebagai; hamba-Mu; nabi yang ummi. Juga kepada keluarga dan para shahabatnya serta berilah keselamatan sebanyak yang terjangkau oleh ilmu-Mu; yang tergores oleh pena-Mu, yang terangkum oleh kitab-Mu. Ridhailah ya Allah, para pemimpin kami: Abu Bakar, Umar, Utsman dan Ali, serta semua shahabat, semua tabi’in dan orang-orang yang mengikuti jejak mereka sampai hari pembalasan. Maha Suci Tuhan-mu; Tuhan kemuliaan, dari apa-apa yang mereka sifatkan. Dan keselamatan semoga tercurah kepada para utusan dan segala puji bagi Allah, Tuhan sekalian alam"));

        dpagilist.add(new DzikirPagiItem("Ali Imran 26-27","Dibaca 1x",
                "قُلِ اللَّهُمَّ مَالِكَ الْمُلْكِ تُؤْتِي الْمُلْكَ مَنْ تَشَاءُ وَتَنْزِعُ الْمُلْكَ مِمَّنْ تَشَاءُ وَتُعِزُّ مَنْ تَشَاءُ وَتُذِلُّ مَنْ تَشَاءُ بِيَدِكَ الْخَيْرُ إِنَّكَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ" +
                        "تُولِجُ اللَّيْلَ فِي النَّهَارِ وَتُولِجُ النَّهَارَ فِي اللَّيْلِ وَتُخْرِجُ الْحَيَّ مِنَ الْمَيِّتِ وَتُخْرِجُ الْمَيِّتَ مِنَ الْحَيِّ وَتَرْزُقُ مَنْ تَشَاءُ بِغَيْرِ حِسَابٍ",
                "Qulillahumma malikal mulki tu’tilmulka man tasyaa’u watanzi’ul mulka mimmantasyaa’u watu ’ijzu mantasyaa’u wa tudzillu mantasyaa’u biyadikal khoiru-innaka ’ala kulli syai,in qodiir.Tuulijullaila finnahaari wa tuulijunahaara fillaili watukhrijulkhayya minal mayyiti wa tukhrijul mayyita minalkhayyi watarjzuku mantasaa’u bighoiri hisaab",
                "Katakanlah: “Wahai Tuhan Yang mempunyai kerajaan, Engkau berikan kerajaan kepada orang yang Engkau kehendaki dan Engkau cabut kerajaan dari orang yang Engkau kehendaki. Engkau muliakan orang yang Engkau kehendaki dan Engkau hinakan orang yang Engkau kehendaki. Di tangan Engkaulah segala kebajikan. Sesungguhnya Engkau Maha Kuasa atas segala sesuatu. Engkau masukkan malam ke dalam siang dan Engkau masukkan siang ke dalam malam. Engkau keluarkan yang hidup dari yang mati, dan Engkau keluarkan yang mati dari yang hidup. Dan Engkau beri rezki siapa yang Engkau kehendaki tanpa hisab (batas)."));

        dpagilist.add(new DzikirPagiItem("Doa Pagi Hari","Dibaca 1x",
                "اَللَّهُمَّ إِنَّ هَذَا إِقْبَالُ نَهَارِكَ وَإِدْبَارُ لَيْلِكَ، وَأَصْوَاتُ دُعَاتِكَ فَاغْفِرْلِي",
                "Alloohumma inna haadzaa iqbalu naharika wa idzbaaru lailika wa ashwatu dua’atika faghfirlii",
                "Ya Allah, sesungguhnya inilah saat datangnya siang-Mu dan perginya malam-Mu serta suara permohonan kepada-Mu, maka ampunilah aku"));

        dpagilist.add(new DzikirPagiItem("Doa Al-Matsurah","Dibaca 1x",
                "اللَّهُمَّ إِنَكَ تَعْلَمُ اَنَّ هَذِهِ اْلقُلُوْبَ قَدِ اجْتَمَعَتْ عَلَى مَحَبَّتِكَ وَالْتَقَتْ عَلَى طَاعَتِكَ وَتَوَحَّدَتْ عَلَى دَعْوَتِكَ وَتَعَاهَدَتْ عَلَى نُصْرَةِ شَرِيْعَتِكَ فَوَثِّقِ اللَّهُمَّ رَابِطَتَهَا وَاَدِّمْ وُدَّهَا وَاهُدِهَا سُبُوْلَهَا وَامْلَأْهَا بِنُوْرِكَ الَّذِيْ لاَ يَخْبُوْ وَاشْرَحْ صُدُرَهَا بِفَيْضِ الْإِيْمَانِ بِكَ وَجَمِيْلِ التَّوَكُّلِ عَلَيْكَ وَاَحْيِهَا بِمَعْرِفَتِكَ وَاَمِتْهَا عَلَى شَهَادَةِ فِيْ سَبِيْلِكَ إِنَّكَ نِعْمَ الْمَوْلَى وَنِعْم النَّصِيْرُ, اَللَّهُمَّاَمِيْن. وَصَلِّ اللَّهُمَ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى آلِهِ وَصَحْبِهِ وَسَلِّمَ",
                "Alloohumma innaka ta’lamu anna haadihil quluuba qodijtama’at ‘alaa makhabbatika wal taqot ‘alaa tho’atika wa tawakhadat ‘alaa da’watika wa ta’ahadat ‘alaa nusroti sari’atika fawatsiqilloohumma roobithotahaa wa ‘adhim wuddahaa wahdihaa subulahaa wamla’haa binuurikalladzii layakhbuu wasrakh shuduurahaa bifaidil iimaanibika wa jamiilittawakulli ‘alaika wa akhyihaa bima’rifatika wa amit-haa ‘alasshahaadati fi sabiilika innaka ni’mal maula wa ni’mannashiir. Alloohumma aamiin wa sholillahumma ‘alaa sayyidinaa muhammadin wa ‘alaa aalihi wa shohbihi wasalam",
                "Ya Allah, sesungguhnya Engkau Maha Tahu bahwa hati-hati ini telah berhimpun dalam kecintaan kepada-Mu, telah berjumpa dalam menaati-Mu, telah bersatu dalam da’wah kepada-Mu, telah terjalin dalam membela syari’at-Mu. Maka teguhkanlah, ya Allah, ikatannya; kekalkanlah kasih sayangnya; tunjukilah jalan-jalannya; penuhilah hati ini dengan cahaya-Mu yang tiada pernah sirna; lapangkanlah dadanya dengan limpahan iman kepada-Mu dan indahnya kepasrahan kepada-Mu; dan matikanlah ia di atas kesyahidan di jalan-Mu. Sesungguhnya Engkau adalah sebaik-baik pelindung dan sebaik-baik penolong. Ya Allah, kabulkanlah. Dan, curahkanlah kesejahteraan dan kedamaian kepada baginda kami Muhammad SAW., serta kepada keluarga dan para shahabat beliau"));
    }

    private void dataRecyclerdPagi(){
        DzikirPagiAdapter pagiAdapter = new DzikirPagiAdapter(dpagilist);
        rvdpagi.setLayoutManager(new LinearLayoutManager(this));
        rvdpagi.setAdapter(pagiAdapter);
    }
}
