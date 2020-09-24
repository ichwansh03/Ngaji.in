package com.rohisnatardev.ichwan.appprojectplanb.Murottal;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

public class DownHolder extends RecyclerView.ViewHolder {

    TextView name, link;
    ImageButton btndownload;
    public DownHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name_murotal);
        link = itemView.findViewById(R.id.link_murotal);
        btndownload = itemView.findViewById(R.id.btn_download_murotal);
    }
}
