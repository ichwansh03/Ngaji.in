package com.rohisnatardev.ichwan.appprojectplanb.Dzikir.dzikirpetang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class DzikirPetangAdapter extends RecyclerView.Adapter<DzikirPetangAdapter.PetangHolder> {

    private static final String TAG = "DzikirPetangAdapter";
    List<DzikirPetangItem> petangItemList;

    public DzikirPetangAdapter(List<DzikirPetangItem> petangItemList) {
        this.petangItemList = petangItemList;
    }

    @NonNull
    @Override
    public DzikirPetangAdapter.PetangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_dzikir_item,parent,false);

        return new PetangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DzikirPetangAdapter.PetangHolder holder, int position) {
        DzikirPetangItem item = petangItemList.get(position);
        holder.title.setText(item.getNamadpetang());
        holder.jumlah.setText(item.getJmldpetang());
        holder.arabic.setText(item.getArabdpetang());
        holder.latino.setText(item.getLatindpetang());
        holder.mean.setText(item.getArtidpetang());
        boolean expanded = petangItemList.get(position).isExpandPetang();
        holder.expandable.setVisibility(expanded ? View.VISIBLE : View.GONE);
        holder.checkBox.setChecked(item.isCheckedpt());
    }

    @Override
    public int getItemCount() {
        return petangItemList.size();
    }

    public class PetangHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "PetangHolder";
        TextView title, jumlah, arabic, latino, mean;
        ConstraintLayout expandable;
        CheckBox checkBox;

        public PetangHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tlnamaDzikir);
            jumlah = itemView.findViewById(R.id.jmlBaca);
            arabic = itemView.findViewById(R.id.dzikirArab);
            latino = itemView.findViewById(R.id.dzikirlatin);
            mean = itemView.findViewById(R.id.dzikirArti);
            expandable = itemView.findViewById(R.id.expanddzikir);
            checkBox = itemView.findViewById(R.id.checkDzikir);

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DzikirPetangItem item = petangItemList.get(getAdapterPosition());
                    item.setExpandPetang(!item.isExpandPetang());
                    notifyItemChanged(getAdapterPosition());
                    item.setCheckedpt(true);
                }
            });
        }
    }
}
