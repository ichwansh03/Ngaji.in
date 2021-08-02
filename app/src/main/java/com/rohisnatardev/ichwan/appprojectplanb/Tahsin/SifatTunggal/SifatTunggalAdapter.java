package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatTunggal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class SifatTunggalAdapter extends RecyclerView.Adapter<SifatTunggalAdapter.ViewHolder> {
    private static final String TAG = "SifatNonLawanAdapter";
    List<SifatTunggalItem> nonLawanList;

    public SifatTunggalAdapter(List<SifatTunggalItem>nonLawanList){
        this.nonLawanList = nonLawanList;
    }
    @NonNull
    @Override
    public SifatTunggalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sifat_huruf_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SifatTunggalItem sifatTunggalItem = nonLawanList.get(position);
        holder.titleNonLawan.setText(sifatTunggalItem.getTitleTv());
        holder.descNonLawan.setText(sifatTunggalItem.getDescTv());
        boolean isExpandable = nonLawanList.get(position).isExpandable();
        holder.expand.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return nonLawanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";
        ConstraintLayout expand;
        TextView titleNonLawan, descNonLawan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleNonLawan = itemView.findViewById(R.id.titleTv);
            descNonLawan = itemView.findViewById(R.id.textDesc);
            expand = itemView.findViewById(R.id.expandableCv);

            titleNonLawan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SifatTunggalItem sifatTunggalItem = nonLawanList.get(getAdapterPosition());
                    sifatTunggalItem.setExpandable(!sifatTunggalItem.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
