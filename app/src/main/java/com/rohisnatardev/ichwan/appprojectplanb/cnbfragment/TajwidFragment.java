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
import com.rohisnatardev.ichwan.appprojectplanb.BacaanActivity;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid.BlogTajwidAdapter;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid.BlogTajwidItem;
import com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid.TajwidModel;
import com.rohisnatardev.ichwan.appprojectplanb.R;
import com.rohisnatardev.ichwan.appprojectplanb.TajwidActivity;

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
        }
    }
}