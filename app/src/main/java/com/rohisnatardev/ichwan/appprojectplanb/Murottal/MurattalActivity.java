package com.rohisnatardev.ichwan.appprojectplanb.Murottal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class MurattalActivity extends AppCompatActivity {

    FirebaseFirestore db;
    RecyclerView recyclerView;
    ArrayList<DownModel> modelArrayList = new ArrayList<>();
    DownAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_murattal);

        setRecyclerview();
        db = FirebaseFirestore.getInstance();

        dataFirebase();
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
}
