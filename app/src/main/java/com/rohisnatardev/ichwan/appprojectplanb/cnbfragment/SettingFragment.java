package com.rohisnatardev.ichwan.appprojectplanb.cnbfragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.rohisnatardev.ichwan.appprojectplanb.Setting.KonsultasiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.PolicyActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.TentangAppActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;
public class SettingFragment extends Fragment implements View.OnClickListener {

    private AdView mAdView;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        view.findViewById(R.id.tx_aboutapp).setOnClickListener(this);
        view.findViewById(R.id.tx_share).setOnClickListener(this);
        view.findViewById(R.id.tx_policy).setOnClickListener(this);
        view.findViewById(R.id.tx_rates).setOnClickListener(this);
        view.findViewById(R.id.tx_pembaruan).setOnClickListener(this);
        view.findViewById(R.id.tx_consult).setOnClickListener(this);

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tx_aboutapp:
                Intent about = new Intent(getActivity(), TentangAppActivity.class);
                startActivity(about);
                break;
            case R.id.tx_share:
                shareApp();
                break;
            case R.id.tx_policy:
                Intent policy = new Intent(getActivity(), PolicyActivity.class);
                startActivity(policy);
                break;
            case R.id.tx_consult:
                Intent konsul = new Intent(getActivity(), KonsultasiActivity.class);
                startActivity(konsul);
                break;
            case R.id.tx_rates:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rohisnatardev.ichwan.appprojectplanb")));
                break;
            case R.id.tx_pembaruan:
                pembaruanApp();
                break;
        }
    }

    private void shareApp(){
        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain");
        String sharebody = "Share Body";
        String shareSub = "Download Aplikasi Bina Bacaan Qur\'an di Google Play Store:\n" +
                "https://play.google.com/store/apps/details?id=com.rohisnatardev.ichwan.appprojectplanb";
        intentShare.putExtra(Intent.EXTRA_SUBJECT,sharebody);
        intentShare.putExtra(Intent.EXTRA_TEXT,shareSub);
        startActivity(Intent.createChooser(intentShare,"Bagikan"));
    }


    private void pembaruanApp(){
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.rohisnatardev.ichwan.appprojectplanb")));
        } catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.rohisnatardev.ichwan.appprojectplanb")));
        }
    }
}