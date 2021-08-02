package com.rohisnatardev.ichwan.appprojectplanb.cnbfragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rohisnatardev.ichwan.appprojectplanb.IqraPDF.Iqra1;
import com.rohisnatardev.ichwan.appprojectplanb.IqraPDF.Iqra2;
import com.rohisnatardev.ichwan.appprojectplanb.IqraPDF.Iqra3;
import com.rohisnatardev.ichwan.appprojectplanb.IqraPDF.Iqra4;
import com.rohisnatardev.ichwan.appprojectplanb.IqraPDF.Iqra5;
import com.rohisnatardev.ichwan.appprojectplanb.IqraPDF.Iqra6;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class IqraFragment extends Fragment implements View.OnClickListener {

    public IqraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iqra, container, false);

        view.findViewById(R.id.card_iqra1).setOnClickListener(this);
        view.findViewById(R.id.card_iqra2).setOnClickListener(this);
        view.findViewById(R.id.card_iqra3).setOnClickListener(this);
        view.findViewById(R.id.card_iqra4).setOnClickListener(this);
        view.findViewById(R.id.card_iqra5).setOnClickListener(this);
        view.findViewById(R.id.card_iqra6).setOnClickListener(this);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_iqra1:
                startActivity(new Intent(getActivity(),Iqra1.class));
                break;
            case R.id.card_iqra2:
                startActivity(new Intent(getActivity(), Iqra2.class));
                break;
            case R.id.card_iqra3:
                startActivity(new Intent(getActivity(), Iqra3.class));
                break;
            case R.id.card_iqra4:
                startActivity(new Intent(getActivity(), Iqra4.class));
                break;
            case R.id.card_iqra5:
                startActivity(new Intent(getActivity(), Iqra5.class));
                break;
            case R.id.card_iqra6:
                startActivity(new Intent(getActivity(), Iqra6.class));
                break;
        }
    }
}