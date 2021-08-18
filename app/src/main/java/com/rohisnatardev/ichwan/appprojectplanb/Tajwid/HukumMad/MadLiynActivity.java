package com.rohisnatardev.ichwan.appprojectplanb.Tajwid.HukumMad;

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

import androidx.appcompat.app.AppCompatActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class MadLiynActivity extends AppCompatActivity {
    MediaPlayer player;
    ImageButton btnliyn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_liyn_iwadh);

        findViewById(R.id.fabmadliyniwadh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MadLiynActivity.this, MadAridLsActivity.class));
            }
        });

        btnliyn = findViewById(R.id.play_toggle_liyniwadh);
        player = MediaPlayer.create(this,R.raw.madliyn);
        btnliyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpliyn();
            }
        });

        TextView txmadlin1 = findViewById(R.id.example_liyniwadh);
        String sLiyn1 = getString(R.string.madlin1);
        TextView txmadlin2 = findViewById(R.id.example2_liyniwadh);
        String sLiyn2 = getString(R.string.madlin2);
        TextView txmadlin3 = findViewById(R.id.example3_liyniwadh);
        String sLiyn3 = getString(R.string.madlin3);

        SpannableString span1 = new SpannableString(sLiyn1);
        SpannableString span2 = new SpannableString(sLiyn2);
        SpannableString span3 = new SpannableString(sLiyn3);

        ForegroundColorSpan fcspan = new ForegroundColorSpan(Color.RED);

        span1.setSpan(fcspan,30,35,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(fcspan,14,20,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span3.setSpan(fcspan,35,39,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txmadlin1.setText(span1);
        txmadlin2.setText(span2);
        txmadlin3.setText(span3);
    }

    private void setmpliyn(){
        if (player.isPlaying()){
            player.pause();
            btnliyn.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnliyn.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
