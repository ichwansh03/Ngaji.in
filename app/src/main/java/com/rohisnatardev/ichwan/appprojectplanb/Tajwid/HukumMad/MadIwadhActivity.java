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

public class MadIwadhActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btniwadh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_iwadh);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madiwadh = new Intent(MadIwadhActivity.this,MadShilahActivity.class);
                startActivity(madiwadh);
            }
        });
        btniwadh = findViewById(R.id.play_toggle_madiwad);
        btniwadh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpiwadh();
            }
        });
        player = MediaPlayer.create(this,R.raw.madiwadh);

        TextView txiwadh1 = findViewById(R.id.image_madiwad1);
        String iwadh = getString(R.string.madiwadh1);
        TextView txiwadh2 = findViewById(R.id.image_madiwad);
        String iwadh2 = getString(R.string.madiwadh2);

        SpannableString spanIwadh1 = new SpannableString(iwadh);
        SpannableString spanIwadh2 = new SpannableString(iwadh2);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);

        spanIwadh1.setSpan(foregroundColorSpan,29,32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanIwadh2.setSpan(foregroundColorSpan,34,37,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txiwadh1.setText(spanIwadh1);
        txiwadh2.setText(spanIwadh2);
    }

    private void setmpiwadh(){
        if (player.isPlaying()){
            player.pause();
            btniwadh.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btniwadh.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
