package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpagi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class DzikirPagiAdapter extends RecyclerView.Adapter<DzikirPagiAdapter.DzikirPagiHolder> {

    private static final String TAG = "DzikirPagiAdapter";
    List<DzikirPagiItem> itemList;

    public DzikirPagiAdapter(List<DzikirPagiItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public DzikirPagiAdapter.DzikirPagiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dzikir_pagi_item,parent,false);

        return new DzikirPagiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DzikirPagiAdapter.DzikirPagiHolder holder, int position) {
        DzikirPagiItem item = itemList.get(position);
        holder.nama.setText(item.getNamabacaan());
        holder.jumlah.setText(item.getJmlbaca());
        holder.arab.setText(item.getDzikirarab());
        holder.latin.setText(item.getDzikirlatin());
        holder.arti.setText(item.getDzikirarti());
        boolean isExp = itemList.get(position).isExpand();
        holder.expandedConstraint.setVisibility(isExp ? View.VISIBLE : View.GONE);
        holder.ckbox.setChecked(item.isChecked());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class DzikirPagiHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "DzikirPagiHolder";
        TextView nama, jumlah, arab, latin, arti;
        ConstraintLayout expandedConstraint;
        CheckBox ckbox;

        public DzikirPagiHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tlnamaDzikirpagi);
            jumlah = itemView.findViewById(R.id.jmlBaca);
            arab = itemView.findViewById(R.id.dzikirPagiArab);
            latin = itemView.findViewById(R.id.dzikirPagilatin);
            arti = itemView.findViewById(R.id.dzikirPagiArti);
            expandedConstraint = itemView.findViewById(R.id.expanddzikirPagi);
            ckbox = itemView.findViewById(R.id.checkDzikirpagi);

            nama.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DzikirPagiItem items = itemList.get(getAdapterPosition());
                    items.setExpand(!items.isExpand());
                    notifyItemChanged(getAdapterPosition());
                    items.setChecked(true);
                }
            });
        }
    }
}
