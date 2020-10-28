package com.rohisnatardev.ichwan.appprojectplanb.Murottal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;

public class MurattalActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView recyclerView;
    ArrayList<DownModel> modelArrayList = new ArrayList<>();
    DownAdapter adapter;
    private AdView mAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murattal);

        setRecyclerview();
        db = FirebaseFirestore.getInstance();

        dataFirebase();

        cekStatus();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

    }

    private void dataFirebase(){
        if (modelArrayList.size()>0)
            modelArrayList.clear();

        //db = FirebaseFirestore.getInstance();
        db.collection("files")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot documentSnapshot:task.getResult()){
                            DownModel downModel = new DownModel(documentSnapshot.getString("name"),
                                    documentSnapshot.getString("link"));
                            modelArrayList.add(downModel);
                        }

                        adapter = new DownAdapter(MurattalActivity.this,modelArrayList);
                        recyclerView.setAdapter(adapter);
                    }

                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MurattalActivity.this, "Gagal mengambil data",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerview(){
        recyclerView = findViewById(R.id.rv_murotal);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void cekStatus(){
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info == null){
            Toast.makeText(MurattalActivity.this,"Tidak ada koneksi internet",Toast.LENGTH_SHORT).show();
        }
    }
}
