package com.rohisnatardev.ichwan.appprojectplanb.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
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
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTahsin.BlogTahsinAdapter;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTahsin.BlogTahsinItem;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTahsin.TahsinModel;
import com.rohisnatardev.ichwan.appprojectplanb.R;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlHalqActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlJaufActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlKhaisActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlLisanActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AsSyafActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatLawan.SifatJamak;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatNonLawan.SifatTunggal;

import java.util.ArrayList;

public class TahsinFragment extends Fragment implements View.OnClickListener {

    private BlogTahsinAdapter tahsinAdapter;
    RecyclerView recyclerView;
    ShimmerFrameLayout shimmer;
    Handler handler;

    public TahsinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tahsin, container, false);

        recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tahsinAdapter = new BlogTahsinAdapter();
        tahsinAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(tahsinAdapter);

        handler = new Handler();
        shimmer = view.findViewById(R.id.shimmer_tahsin);
        shimmer.startShimmer();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmer.stopShimmer();
                shimmer.hideShimmer();
            }
        },5000);
        TahsinModel tahsinModel = new ViewModelProvider(this).get(TahsinModel.class);
        tahsinModel.getLiveTahsin().observe(getViewLifecycleOwner(), getBlogTahsin);
        tahsinModel.setBlogTahsin("extra_tahsin");

        CardView cvAlhalq = view.findViewById(R.id.alhalq);
        cvAlhalq.setOnClickListener(this);
        CardView cvAllisan = view.findViewById(R.id.allisan);
        cvAllisan.setOnClickListener(this);
        CardView cvAssy = view.findViewById(R.id.assyafatain);
        cvAssy.setOnClickListener(this);
        CardView cvAljauf = view.findViewById(R.id.aljauf);
        cvAljauf.setOnClickListener(this);
        CardView cvAlkhais = view.findViewById(R.id.alkhaisyum);
        cvAlkhais.setOnClickListener(this);

        CardView cvJamak = view.findViewById(R.id.sifatjamak);
        cvJamak.setOnClickListener(this);
        CardView cvTunggal = view.findViewById(R.id.sifattunggal);
        cvTunggal.setOnClickListener(this);

        return view;
    }

    private Observer<ArrayList<BlogTahsinItem>> getBlogTahsin = new Observer<ArrayList<BlogTahsinItem>>() {
        @Override
        public void onChanged(ArrayList<BlogTahsinItem> blogTahsinItems) {
            if (blogTahsinItems != null) {
                tahsinAdapter.BlogTahsinAdapter(blogTahsinItems);
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alhalq:
                Intent alhalq = new Intent(getActivity(), AlHalqActivity.class);
                startActivity(alhalq);
                break;
            case R.id.allisan:
                Intent allisan = new Intent(getActivity(), AlLisanActivity.class);
                startActivity(allisan);
                break;
            case R.id.assyafatain:
                Intent assyifa = new Intent(getActivity(), AsSyafActivity.class);
                startActivity(assyifa);
                break;
            case R.id.aljauf:
                Intent aljauf = new Intent(getActivity(), AlJaufActivity.class);
                startActivity(aljauf);
                break;
            case R.id.alkhaisyum:
                Intent alkhais = new Intent(getActivity(), AlKhaisActivity.class);
                startActivity(alkhais);
                break;
            case R.id.sifatjamak:
                Intent jamak = new Intent(getActivity(), SifatJamak.class);
                startActivity(jamak);
                break;
            case R.id.sifattunggal:
                Intent tunggal = new Intent(getActivity(), SifatTunggal.class);
                startActivity(tunggal);
        }
    }
}