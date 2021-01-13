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
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlHalqActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlJaufActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlKhaisActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AlLisanActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.AsSyafActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatLawan.SifatJamak;
import com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatNonLawan.SifatTunggal;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.BacaanActivity;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid.BlogTajwidAdapter;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid.BlogTajwidItem;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid.TajwidModel;
import com.rohisnatardev.ichwan.appprojectplanb.R;
import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.TajwidActivity;

import java.util.ArrayList;

public class TajwidFragment extends Fragment implements View.OnClickListener {

    private BlogTajwidAdapter tajwidAdapter;
    RecyclerView recyclerView;

    ShimmerFrameLayout shimmer;
    Handler handler;

    public TajwidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tajwid, container, false);

        recyclerView = view.findViewById(R.id.rv_post);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        tajwidAdapter = new BlogTajwidAdapter();
        tajwidAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(tajwidAdapter);

        handler = new Handler();
        shimmer = view.findViewById(R.id.shimmer_tajwid);
        shimmer.startShimmer();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmer.stopShimmer();
                shimmer.hideShimmer();
            }
        },5000);

        TajwidModel tajwidModel = new ViewModelProvider(this).get(TajwidModel.class);
        tajwidModel.getLiveTajwid().observe(getViewLifecycleOwner(), getBlogTajwid);
        tajwidModel.setBlogTajwid("extra_tajwid");

        CardView tajwidDasar = view.findViewById(R.id.btn_tajwid_dasar);
        tajwidDasar.setOnClickListener(this);
        CardView tajwidLanjut = view.findViewById(R.id.btn_tajwid_lanjutan);
        tajwidLanjut.setOnClickListener(this);
        view.findViewById(R.id.alhalq).setOnClickListener(this);
        view.findViewById(R.id.allisan).setOnClickListener(this);
        view.findViewById(R.id.assyafatain).setOnClickListener(this);
        view.findViewById(R.id.aljauf).setOnClickListener(this);
        view.findViewById(R.id.alkhaisyum).setOnClickListener(this);

        view.findViewById(R.id.sifatjamak).setOnClickListener(this);
        view.findViewById(R.id.sifattunggal).setOnClickListener(this);

        return view;
    }

    private Observer<ArrayList<BlogTajwidItem>> getBlogTajwid = new Observer<ArrayList<BlogTajwidItem>>() {
        @Override
        public void onChanged(ArrayList<BlogTajwidItem> items) {
            if (items != null) {
                tajwidAdapter.BlogTajwidAdapter(items);
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_tajwid_dasar:
                Intent dasar = new Intent(getActivity(), TajwidActivity.class);
                startActivity(dasar);
                break;
            case R.id.btn_tajwid_lanjutan:
                Intent lanjut = new Intent(getActivity(), BacaanActivity.class);
                startActivity(lanjut);
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