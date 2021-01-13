package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.doaharian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;


public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.DoaHolder> {

    private static final String TAG = "DoaAdapter";
    List<DoaItem> listItem;

    public DoaAdapter(List<DoaItem> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public DoaAdapter.DoaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View views = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_doa_item,parent,false);

        return new DoaHolder(views);
    }

    @Override
    public void onBindViewHolder(@NonNull DoaAdapter.DoaHolder holder, int position) {
        DoaItem item = listItem.get(position);
        holder.namadoa.setText(item.getNamadoa());
        holder.lafazdoa.setText(item.getDoaarab());
        holder.latindoa.setText(item.getDoalatin());
        holder.artidoa.setText(item.getDoaarti());
        boolean exp = listItem.get(position).isExpandDoa();
        holder.expandoa.setVisibility(exp ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class DoaHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "DoaHolder";
        TextView namadoa, lafazdoa, latindoa, artidoa;
        LinearLayout expandoa;

        public DoaHolder(@NonNull View itemView) {
            super(itemView);

            namadoa = itemView.findViewById(R.id.nama_doa);
            lafazdoa = itemView.findViewById(R.id.doaArab);
            latindoa = itemView.findViewById(R.id.doaLatin);
            artidoa = itemView.findViewById(R.id.doaArti);
            expandoa = itemView.findViewById(R.id.expandDoa);

            namadoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DoaItem doaItem = listItem.get(getAdapterPosition());
                    doaItem.setExpandDoa(!doaItem.isExpandDoa());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
