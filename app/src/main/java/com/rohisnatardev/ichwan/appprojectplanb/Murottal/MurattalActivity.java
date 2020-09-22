package com.rohisnatardev.ichwan.appprojectplanb.Murottal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Typeface;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class MurattalActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton cvmishari, cvdossari;
    StorageReference storageReference, ref, storageReference1, ref1;
    FirebaseStorage firebaseStorage,firebaseStorage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murattal);

        cvmishari = findViewById(R.id.downloadMishari);
        cvdossari = findViewById(R.id.downloadDossari);
        cvdossari.setOnClickListener(this);
        cvmishari.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.downloadDossari:
                downD();
                break;

            case R.id.downloadMishari:
                downM();
                break;
        }
    }

    public void downD(){
        storageReference = firebaseStorage.getInstance().getReference();
        ref = storageReference.child("AlDossary.mp3");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFile(MurattalActivity.this,"AlDossary",".mp3",DIRECTORY_DOWNLOADS,url);
                Toast.makeText(MurattalActivity.this,"Sedang mendownload, lihat notifikasi",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MurattalActivity.this,"Download gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downM(){

        storageReference1 = firebaseStorage1.getInstance().getReference();
        ref1 = storageReference1.child("Mishari Rashid-Al Fatiha.mp3");

        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url2 = uri.toString();
                downloadFile(MurattalActivity.this,"Mishari Rashid-Al Fatiha",".mp3",DIRECTORY_DOWNLOADS,url2);
                Toast.makeText(MurattalActivity.this,"Sedang mendownload, lihat notifikasi",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MurattalActivity.this,"Download gagal",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadFile(Context context, String fileName, String fileExt, String destDir, String url){
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destDir,fileName+fileExt);

        downloadManager.enqueue(request);
    }


}
