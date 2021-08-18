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

public class MadJaizActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btnjaiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_jaiz_wajib);

        findViewById(R.id.fabmadjaizwajib).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MadJaizActivity.this, MadWajibActivity.class));
            }
        });

        btnjaiz = findViewById(R.id.play_toggle_jaizwajib);
        btnjaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpjaiz();
            }
        });
        player = MediaPlayer.create(this,R.raw.madmunfasil);

        TextView madjaiz1 = findViewById(R.id.example_jaizwajib);
        String munfasil1 = getString(R.string.madjaiz1);
        TextView madjaiz2 = findViewById(R.id.example2_jaizwajib);
        String munfasil2 = getString(R.string.madjaiz2);
        TextView madjaiz3 = findViewById(R.id.example3_jaizwajib);
        String munfasil3 = getString(R.string.madjaiz3);

        SpannableString span1 = new SpannableString(munfasil1);
        SpannableString span2 = new SpannableString(munfasil2);
        SpannableString span3 = new SpannableString(munfasil3);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);

        span1.setSpan(foregroundColorSpan,1,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(foregroundColorSpan,8,10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(foregroundColorSpan,4,7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        madjaiz1.setText(span1);
        madjaiz2.setText(span2);
        madjaiz3.setText(span3);
    }

    private void setmpjaiz(){
        if (player.isPlaying()){
            player.pause();
            btnjaiz.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnjaiz.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
