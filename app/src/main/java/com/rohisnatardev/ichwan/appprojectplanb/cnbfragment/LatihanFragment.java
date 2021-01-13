package com.rohisnatardev.ichwan.appprojectplanb.cnbfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohisnatardev.ichwan.appprojectplanb.R;
public class LatihanFragment extends Fragment {

    public LatihanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_latihan, container, false);

        return view;
    }
}