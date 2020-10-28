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

public class MadThabiiActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btntabi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_thabii);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madthabi = new Intent(MadThabiiActivity.this,MadIwadhActivity.class);
                startActivity(madthabi);
            }
        });
        btntabi = findViewById(R.id.play_toggle_madtabi);
        btntabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmptabi();
            }
        });
        player = MediaPlayer.create(this,R.raw.madtabii);

        TextView mtabi1 = findViewById(R.id.image_madtabi);
        String txmtabi1 = getString(R.string.madtabi1);
        TextView mtabi2 = findViewById(R.id.image_madtabi2);
        String txmtabi2 = getString(R.string.madtabi2);

        SpannableString span1 = new SpannableString(txmtabi1);
        SpannableString span2 = new SpannableString(txmtabi2);

        ForegroundColorSpan fgspan = new ForegroundColorSpan(Color.RED);

        span1.setSpan(fgspan,0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(fgspan,0,3,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mtabi1.setText(span1);
        mtabi2.setText(span2);
    }

    private void setmptabi(){
        if (player.isPlaying()){
            player.pause();
            btntabi.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btntabi.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
