package com.rohisnatardev.ichwan.appprojectplanb.HukumMad;

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

import com.rohisnatardev.ichwan.appprojectplanb.Qalqalah.QalqalahSughraActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class MadMuttasilActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btnwajib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_muttasil);

        TextView tv = findViewById(R.id.textNextBtn);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madwajib = new Intent(MadMuttasilActivity.this, QalqalahSughraActivity.class);
                startActivity(madwajib);
            }
        });
        btnwajib = findViewById(R.id.play_toggle_madwajib);
        btnwajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpwajib();
            }
        });
        player = MediaPlayer.create(this,R.raw.madwajibmuttasil);

        TextView mWajib1 = findViewById(R.id.image_madwajib);
        String mString1 = getString(R.string.madwajib1);
        TextView mWajib2 = findViewById(R.id.image_madwajib2);
        String mString2 = getString(R.string.madwajib2);

        SpannableString spaned1 = new SpannableString(mString1);
        SpannableString spaned2 = new SpannableString(mString2);

        ForegroundColorSpan forspan = new ForegroundColorSpan(Color.RED);

        spaned1.setSpan(forspan,8,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spaned2.setSpan(forspan,23,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mWajib1.setText(spaned1);
        mWajib2.setText(spaned2);
    }

    private void setmpwajib(){
        if (player.isPlaying()){
            player.pause();
            btnwajib.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnwajib.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player != null){
            player.stop();
        }
        super.onDestroy();
    }
}
