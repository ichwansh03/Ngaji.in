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

public class WaqafAdapter extends RecyclerView.Adapter<WaqafAdapter.HolderAdapter> {

    private static final String TAG = "WaqafAdapter";
    List<WaqafItem> waqafItemList;

    public WaqafAdapter(List<WaqafItem> waqafItemList) {
        this.waqafItemList = waqafItemList;
    }

    @NonNull
    @Override
    public WaqafAdapter.HolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_waqaf_item,parent,false);
        return new HolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaqafAdapter.HolderAdapter holder, int position) {
        WaqafItem waqafItem = waqafItemList.get(position);
        holder.titleView.setText(waqafItem.getTitle());
        holder.overView.setText(waqafItem.getOverview());
        boolean expand = waqafItemList.get(position).isExpand();
        holder.expandedLayout.setVisibility(expand ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return waqafItemList.size();
    }

    public class HolderAdapter extends RecyclerView.ViewHolder {
        private static final String TAG = "HolderAdapter";
        ConstraintLayout expandedLayout;
        TextView titleView, overView;
        public HolderAdapter(@NonNull View itemView) {
            super(itemView);

            titleView = itemView.findViewById(R.id.titleWaqaf);
            overView = itemView.findViewById(R.id.overview);
            expandedLayout = itemView.findViewById(R.id.expandWaqaf);

            titleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WaqafItem waqafItem = waqafItemList.get(getAdapterPosition());
                    waqafItem.setExpand(!waqafItem.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
