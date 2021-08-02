package com.rohisnatardev.ichwan.appprojectplanb.IqraPDF;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import java.util.ArrayList;
import java.util.List;

public class Iqra1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqra);

        PDFView pdfView = findViewById(R.id.iqraPDF);
        pdfView.fromAsset("iqra1.pdf").swipeHorizontal(false).load();

    }

}