package com.rohisnatardev.ichwan.appprojectplanb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.KonsultasiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.PolicyActivity;
import com.rohisnatardev.ichwan.appprojectplanb.Setting.TentangAppActivity;

import org.jetbrains.annotations.NotNull;

public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_drawer,container,false);

        v.findViewById(R.id.aboutapp).setOnClickListener(this);
        v.findViewById(R.id.policy).setOnClickListener(this);
        v.findViewById(R.id.consul).setOnClickListener(this);
        v.findViewById(R.id.shareapp).setOnClickListener(this);

        return v;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.aboutapp:
                startActivity(new Intent(getActivity(), TentangAppActivity.class));
                break;
            case R.id.policy:
                startActivity(new Intent(getActivity(), PolicyActivity.class));
                break;
            case R.id.consul:
                startActivity(new Intent(getActivity(), KonsultasiActivity.class));
                break;
            case R.id.shareapp:
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                String sharebody = "Share Body";
                String shareSub = "Download Aplikasi Ngaji.in di Google Play Store:\n" +
                        "https://play.google.com/store/apps/details?id=com.rohisnatardev.ichwan.appprojectplanb";
                intentShare.putExtra(Intent.EXTRA_SUBJECT,sharebody);
                intentShare.putExtra(Intent.EXTRA_TEXT,shareSub);
                startActivity(Intent.createChooser(intentShare,"Bagikan"));
                break;
        }

    }
}
