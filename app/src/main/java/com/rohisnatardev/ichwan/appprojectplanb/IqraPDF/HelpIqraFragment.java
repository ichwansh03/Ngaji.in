package com.rohisnatardev.ichwan.appprojectplanb.IqraPDF;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohisnatardev.ichwan.appprojectplanb.R;

public class HelpIqraFragment extends Fragment {

    public HelpIqraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help_iqra, container, false);

        return view;
    }
}