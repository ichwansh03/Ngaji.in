package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatNonLawan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class SifatNonLawanAdapter extends RecyclerView.Adapter<SifatNonLawanAdapter.ViewHolder> {
    private static final String TAG = "SifatNonLawanAdapter";
    List<SifatNonLawan> nonLawanList;

    public SifatNonLawanAdapter(List<SifatNonLawan>nonLawanList){
        this.nonLawanList = nonLawanList;
    }
    @NonNull
    @Override
    public SifatNonLawanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sifat_nonlawan_itemview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SifatNonLawan sifatNonLawan = nonLawanList.get(position);
        holder.titleNonLawan.setText(sifatNonLawan.getTitleTv());
        holder.descNonLawan.setText(sifatNonLawan.getDescTv());
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
            titleNonLawan = itemView.findViewById(R.id.title_nonlawan);
            descNonLawan = itemView.findViewById(R.id.desc_nonlawan);
            expand = itemView.findViewById(R.id.expandable_nonlawan);

            titleNonLawan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SifatNonLawan sifatNonLawan = nonLawanList.get(getAdapterPosition());
                    sifatNonLawan.setExpandable(!sifatNonLawan.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
