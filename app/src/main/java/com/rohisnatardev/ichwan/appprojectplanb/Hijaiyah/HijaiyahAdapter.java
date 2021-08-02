package com.rohisnatardev.ichwan.appprojectplanb.Hijaiyah;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.List;

public class HijaiyahAdapter extends RecyclerView.Adapter<HijaiyahAdapter.ViewHolder> {
    private static final String TAG = "IqraAdapter";
    private List<HijaiyahItem> mData;
    private MediaPlayer mediaPlayer;
    private Context context;

    public HijaiyahAdapter(List<HijaiyahItem> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public HijaiyahAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_iqra_hijaiyah_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HijaiyahAdapter.ViewHolder holder, int position) {
        HijaiyahItem hijaiyahItem = mData.get(position);
        holder.txHuruf.setText(hijaiyahItem.getHuruf());
        holder.txHurufEx.setText(hijaiyahItem.getExHuruf());
        holder.txSifat.setText(hijaiyahItem.getSifat());
        boolean isEkspans = mData.get(position).isExpanded();
        holder.expandable.setVisibility(isEkspans ? View.VISIBLE : View.GONE);
        mediaPlayer = MediaPlayer.create(context, hijaiyahItem.getAudio());
        holder.btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying() && mediaPlayer != null){
                    mediaPlayer.pause();
                    holder.btnplay.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                } else {
                    if (mediaPlayer != null){
                    mediaPlayer.start();
                    holder.btnplay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                    }

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "ViewHolder";
        ConstraintLayout expandable;
        TextView txHuruf, txHurufEx, txSifat;
        ImageButton btnplay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txHuruf = (TextView) itemView.findViewById(R.id.hurufhijaiyah);
            txHurufEx = (TextView) itemView.findViewById(R.id.txHuruf);
            txSifat = (TextView) itemView.findViewById(R.id.txsifat);
            btnplay = (ImageButton) itemView.findViewById(R.id.btnPlay);
            expandable = itemView.findViewById(R.id.expandHijaiyah);

            txHuruf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HijaiyahItem items = mData.get(getAdapterPosition());
                    items.setExpanded(!items.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}
