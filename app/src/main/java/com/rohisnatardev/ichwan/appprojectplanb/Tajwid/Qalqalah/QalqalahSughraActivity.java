package com.rohisnatardev.ichwan.appprojectplanb.Tajwid.Qalqalah;

import androidx.appcompat.app.AppCompatActivity;

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

import com.rohisnatardev.ichwan.appprojectplanb.R;

public class QalqalahSughraActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer;
ImageButton btnsughra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qalqalah_sughra);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(this);
        btnsughra = findViewById(R.id.play_toggle_qalsgr);
        btnsughra.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.qalqalahsughra);

        TextView qsughra = findViewById(R.id.qalqalahsughra_image);
        String sughra = getString(R.string.qsugra1);
        SpannableString string = new SpannableString(sughra);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        string.setSpan(foregroundColorSpan,18,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        qsughra.setText(string);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent sughra = new Intent(QalqalahSughraActivity.this,QalqalahKubraActivity.class);
                startActivity(sughra);
                break;
            case R.id.play_toggle_qalsgr:
                setmpsughra();
                break;
        }
    }

    private void setmpsughra(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnsughra.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btnsughra.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
        super.onDestroy();
    }
}
