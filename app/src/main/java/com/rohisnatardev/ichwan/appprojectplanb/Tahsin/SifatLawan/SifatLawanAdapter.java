package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatLawan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class SifatLawanAdapter extends RecyclerView.Adapter<SifatLawanAdapter.ViewHolder> {
    private static final String TAG = "SifatLawanAdapter";
    List<SifatLawan> sifatLawanList;

    public SifatLawanAdapter(List<SifatLawan>sifatLawanList){
        this.sifatLawanList = sifatLawanList;
    }
    @NonNull
    @Override
    public SifatLawanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sifat_lawan_itemview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SifatLawan sifatLawan = sifatLawanList.get(position);
        holder.txTitle.setText(sifatLawan.getTitle());
        holder.txDesc.setText(sifatLawan.getDesc());
        boolean isExpanded = sifatLawanList.get(position).isExpanded();
        holder.expandLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return sifatLawanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";
        ConstraintLayout expandLayout;
        TextView txTitle,txDesc;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txTitle = itemView.findViewById(R.id.titleTv);
            txDesc = itemView.findViewById(R.id.textDesc);
            expandLayout = itemView.findViewById(R.id.expandableCv);

            txTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SifatLawan sifatLawan = sifatLawanList.get(getAdapterPosition());
                    sifatLawan.setExpanded(!sifatLawan.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
