package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.AlifLam.SyamsiyahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class TashilActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer playerTashil;
ImageButton btntashil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkhusus);

        TextView textView = findViewById(R.id.textNextBtn);
        textView.setText(R.string.as_syamsiyah);
        textView.setOnClickListener(this);

        TextView title = findViewById(R.id.txtitle);
        title.setText(R.string.tahsil);

        btntashil = findViewById(R.id.play_toggle_bkhusus);
        btntashil.setOnClickListener(this);
        playerTashil = MediaPlayer.create(this,R.raw.tahsil);

        TextView tvTashil = findViewById(R.id.bkhusus_arab);
        String txTashil = getString(R.string.tashil1);
        SpannableString sTashil = new SpannableString(txTashil);
        ForegroundColorSpan fcTashil = new ForegroundColorSpan(Color.RED);
        sTashil.setSpan(fcTashil,91,97, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTashil.setText(sTashil);

        TextView article1 = findViewById(R.id.tx_article);
        article1.setText(R.string.tashil_desc);
        TextView article2 = findViewById(R.id.text_article2);
        article2.setText(R.string.tashil_desc2);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                startActivity(new Intent(this, SyamsiyahActivity.class));
                break;
            case R.id.play_toggle_bkhusus:
                setmptashil();
                break;
        }
    }

    private void setmptashil(){
        if (playerTashil.isPlaying()){
            playerTashil.pause();
            btntashil.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            playerTashil.start();
            btntashil.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (playerTashil != null){
            playerTashil.stop();
        }
        super.onDestroy();
    }
}
