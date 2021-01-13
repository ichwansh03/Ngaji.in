package com.rohisnatardev.ichwan.appprojectplanb.cnbfragment;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran.BlogQuranAdapter;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran.BlogQuranItem;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran.QuranModel;
import com.rohisnatardev.ichwan.appprojectplanb.Dzikir.doaharian.DoaHarianActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpagi.DzikirPagiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpetang.DzikirPetangActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Murottal.MurattalActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Quran.CariSurahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Quran.SajdahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Quran.WaqafActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;

public class QuranFragment extends Fragment implements View.OnClickListener {

    private BlogQuranAdapter quranAdapter;
    RecyclerView recyclerView;
    ShimmerFrameLayout shimmer;
    Handler handler;
    public QuranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quran, container, false);

        recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        quranAdapter = new BlogQuranAdapter();
        quranAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(quranAdapter);

        handler = new Handler();
        shimmer = view.findViewById(R.id.shimmer_quran);
        shimmer.startShimmer();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmer.stopShimmer();
                shimmer.hideShimmer();
            }
        },5000);

        QuranModel quranModel = new ViewModelProvider(this).get(QuranModel.class);
        quranModel.getLiveQuran().observe(getViewLifecycleOwner(), getBlogQuran);
        quranModel.setBlogQuran("extra_quran");


        view.findViewById(R.id.cari_surah).setOnClickListener(this);
        view.findViewById(R.id.ayatsajdah).setOnClickListener(this);
        view.findViewById(R.id.waqaf).setOnClickListener(this);
        view.findViewById(R.id.murotal).setOnClickListener(this);

        view.findViewById(R.id.btn_dzikirpagi).setOnClickListener(this);
        view.findViewById(R.id.btn_dzikirpetang).setOnClickListener(this);
        view.findViewById(R.id.btn_doa).setOnClickListener(this);


        return view;
    }

    private Observer<ArrayList<BlogQuranItem>> getBlogQuran = new Observer<ArrayList<BlogQuranItem>>() {
        @Override
        public void onChanged(ArrayList<BlogQuranItem> arrayList) {
            if (arrayList != null){
                quranAdapter.BlogQuranAdapter(arrayList);
            }

        }
    };



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cari_surah:
                Intent carisurah = new Intent(getActivity(), CariSurahActivity.class);
                startActivity(carisurah);
                break;
            case R.id.ayatsajdah:
                Intent sajdah = new Intent(getActivity(), SajdahActivity.class);
                startActivity(sajdah);
                break;
            case R.id.waqaf:
                Intent waqaf = new Intent(getActivity(), WaqafActivity.class);
                startActivity(waqaf);
                break;
            case R.id.murotal:
                Intent murotal = new Intent(getActivity(), MurattalActivity.class);
                startActivity(murotal);
                break;
            case R.id.btn_dzikirpagi:
                Intent dzikirpagi = new Intent(getActivity(), DzikirPagiActivity.class);
                startActivity(dzikirpagi);
                break;
            case R.id.btn_dzikirpetang:
                Intent dzikirpetang = new Intent(getActivity(), DzikirPetangActivity.class);
                startActivity(dzikirpetang);
                break;
            case R.id.btn_doa:
                Intent doa = new Intent(getActivity(), DoaHarianActivity.class);
                startActivity(doa);
                break;
        }
    }

}