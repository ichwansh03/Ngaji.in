package com.rohisnatardev.ichwan.appprojectplanb.Quran;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class SajdahAdapter extends RecyclerView.Adapter<SajdahAdapter.ViewHolder> {

    private static final String TAG = "SajdahAdapter";
    List<SajdahItem> sajdahlist;

    public SajdahAdapter(List<SajdahItem> sajdahlist) {
        this.sajdahlist = sajdahlist;
    }

    @NonNull
    @Override
    public SajdahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sajdah_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SajdahAdapter.ViewHolder holder, int position) {
        SajdahItem sajdahItem = sajdahlist.get(position);
        holder.titleSurah.setText(sajdahItem.getSurah());
        holder.txAyat.setText(sajdahItem.getAyat());
        holder.txArti.setText(sajdahItem.getArti());
        boolean isExpandable = sajdahlist.get(position).isExpanded();
        holder.expandLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return sajdahlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";
        ConstraintLayout expandLayout;
        TextView titleSurah, txAyat, txArti;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleSurah = itemView.findViewById(R.id.titleSurah);
            txAyat = itemView.findViewById(R.id.textAyat);
            txArti = itemView.findViewById(R.id.textArti);
            expandLayout = itemView.findViewById(R.id.expandCv);

            titleSurah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SajdahItem item = sajdahlist.get(getAdapterPosition());
                    item.setExpanded(!item.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
