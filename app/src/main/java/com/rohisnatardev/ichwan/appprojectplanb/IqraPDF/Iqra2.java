package com.rohisnatardev.ichwan.appprojectplanb.IqraPDF;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class Iqra2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqra);

        PDFView pdfView = findViewById(R.id.iqraPDF);
        pdfView.fromAsset("iqra2.pdf").swipeHorizontal(false).load();

    }
}
