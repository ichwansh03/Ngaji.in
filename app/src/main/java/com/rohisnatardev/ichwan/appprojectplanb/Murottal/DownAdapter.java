package com.rohisnatardev.ichwan.appprojectplanb.Murottal;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DownAdapter extends RecyclerView.Adapter<DownHolder> {

    MurattalActivity activity;
    ArrayList<DownModel> downModels;

    public DownAdapter(MurattalActivity activity, ArrayList<DownModel> downModels) {
        this.activity = activity;
        this.downModels = downModels;
    }

    @NonNull
    @Override
    public DownHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity.getBaseContext()).inflate(R.layout.murotal_item,null,false);

        return new DownHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DownHolder holder, final int position) {
        holder.name.setText(downModels.get(position).getName());
        holder.link.setText(downModels.get(position).getLink());
        holder.btndownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadMurotal(holder.name.getContext(), downModels.get(position).getName(),".mp3",DIRECTORY_DOWNLOADS,downModels.get(position).getLink());
            }
        });
    }

    public void downloadMurotal(Context context, String filename, String fileExtensions, String desDir, String url){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);

        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, desDir, filename+fileExtensions);

        downloadManager.enqueue(request);
    }

    @Override
    public int getItemCount() {
        return downModels.size();
    }
}
