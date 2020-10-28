package com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad;

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


public class MadBadalActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btnbadal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_badal);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madbadal = new Intent(MadBadalActivity.this,MadThabiiActivity.class);
                startActivity(madbadal);
            }
        });

        btnbadal = findViewById(R.id.play_toggle_madbadal);
        player = MediaPlayer.create(this,R.raw.madbadal);
        btnbadal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpbadal();
            }
        });

        TextView badal1 = findViewById(R.id.image_madbadal1);
        String string = getString(R.string.madbadal1);
        TextView badal2 = findViewById(R.id.image_madbadal);
        String string2 = getString(R.string.madbadal2);

        SpannableString sBadal = new SpannableString(string);
        SpannableString sBadal2 = new SpannableString(string2);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        sBadal.setSpan(foregroundColorSpan,4,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sBadal2.setSpan(foregroundColorSpan,2,3,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        badal1.setText(sBadal);
        badal2.setText(sBadal2);
    }

    private void setmpbadal(){
        if (player.isPlaying()){
            player.pause();
            btnbadal.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnbadal.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
