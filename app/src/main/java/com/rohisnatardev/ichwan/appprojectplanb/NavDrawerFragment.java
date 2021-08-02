package com.rohisnatardev.ichwan.appprojectplanb;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rohisnatardev.ichwan.appprojectplanb.Setting.KonsultasiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.PolicyActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.TentangAppActivity;

public class NavDrawerFragment extends DialogFragment implements View.OnClickListener {

    public NavDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_drawer, container, false);

        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.aboutapp).setOnClickListener(this);
        view.findViewById(R.id.policy).setOnClickListener(this);
        view.findViewById(R.id.consul).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aboutapp:
                startActivity(new Intent(getActivity(),TentangAppActivity.class));
                break;
            case R.id.policy:
                startActivity(new Intent(getActivity(), PolicyActivity.class));
                break;
            case R.id.consul:
                startActivity(new Intent(getActivity(), KonsultasiActivity.class));
        }
    }
}