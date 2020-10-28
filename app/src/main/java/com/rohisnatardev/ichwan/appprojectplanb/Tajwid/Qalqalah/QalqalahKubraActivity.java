package com.rohisnatardev.ichwan.appprojectplanb.Tajwid.Qalqalah;

import androidx.appcompat.app.AppCompatActivity;

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

public class QalqalahKubraActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
ImageButton btnkubra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qalqalah_kubra);

        btnkubra = findViewById(R.id.play_toggle_qalkbr);
        mediaPlayer = MediaPlayer.create(this,R.raw.madtafkhimc7);

        btnkubra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpkubra();
            }
        });

        TextView qkubra = findViewById(R.id.qalqalahkubra_image);
        String kubra = getString(R.string.qkubra1);
        SpannableString spannableString = new SpannableString(kubra);
        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);
        spannableString.setSpan(fcs,14,16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        qkubra.setText(spannableString);
    }

    private void setmpkubra(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnkubra.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btnkubra.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
