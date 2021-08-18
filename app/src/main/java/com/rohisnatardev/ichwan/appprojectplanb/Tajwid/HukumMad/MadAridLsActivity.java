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

public class MadAridLsActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btnmparidh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_arid_ls);

        findViewById(R.id.fabmadaridh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MadAridLsActivity.this, MadLazimActivity.class));
            }
        });

        btnmparidh = findViewById(R.id.play_toggle_madarid);
        player = MediaPlayer.create(this,R.raw.madaridlisukun2harakat);
        btnmparidh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmparidh();
            }
        });

        TextView madaridls = findViewById(R.id.image_madarid1);
        String string = getString(R.string.madarid1);
        TextView madaridls2 = findViewById(R.id.image_madarid);
        String string2 = getString(R.string.madarid2);

        SpannableString span = new SpannableString(string);
        SpannableString span2 = new SpannableString(string2);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        span.setSpan(foregroundColorSpan,34,38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(foregroundColorSpan,19,23,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        madaridls.setText(span);
        madaridls2.setText(span2);
    }

    private void setmparidh(){
        if (player.isPlaying()){
            player.pause();
            btnmparidh.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnmparidh.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
