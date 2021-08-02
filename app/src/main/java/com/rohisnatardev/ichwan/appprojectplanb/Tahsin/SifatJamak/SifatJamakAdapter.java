package com.rohisnatardev.ichwan.appprojectplanb.Tahsin.SifatJamak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class SifatJamakAdapter extends RecyclerView.Adapter<SifatJamakAdapter.ViewHolder> {
    private static final String TAG = "SifatLawanAdapter";
    List<SifatJamakItem> sifatJamakItemList;

    public SifatJamakAdapter(List<SifatJamakItem> sifatJamakItemList){
        this.sifatJamakItemList = sifatJamakItemList;
    }
    @NonNull
    @Override
    public SifatJamakAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sifat_huruf_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SifatJamakItem sifatJamakItem = sifatJamakItemList.get(position);
        holder.txTitle.setText(sifatJamakItem.getTitle());
        holder.txDesc.setText(sifatJamakItem.getDesc());
        boolean isExpanded = sifatJamakItemList.get(position).isExpanded();
        holder.expandLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return sifatJamakItemList.size();
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
                    SifatJamakItem sifatJamakItem = sifatJamakItemList.get(getAdapterPosition());
                    sifatJamakItem.setExpanded(!sifatJamakItem.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
