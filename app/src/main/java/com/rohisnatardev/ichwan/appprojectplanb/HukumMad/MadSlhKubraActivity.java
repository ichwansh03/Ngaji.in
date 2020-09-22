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
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class MadSlhKubraActivity extends AppCompatActivity {
MediaPlayer player;
ImageButton btnkubra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_slh_kubra);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madkubra = new Intent(MadSlhKubraActivity.this,MadLiynActivity.class);
                startActivity(madkubra);
            }
        });
        btnkubra = findViewById(R.id.play_toggle_madslhkubra);
        btnkubra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpkubra();
            }
        });
        player = MediaPlayer.create(this,R.raw.madshilahkubra);

        TextView mdKubra1 = findViewById(R.id.image_madsilahkbr);
        String txMdshilahkbr1 = getString(R.string.madshilahkb1);
        TextView mdKubra2 = findViewById(R.id.image_madsilahkbr2);
        String txMdshilahkbr2 = getString(R.string.madshilahkb2);

        SpannableString string1 = new SpannableString(txMdshilahkbr1);
        SpannableString string2 = new SpannableString(txMdshilahkbr2);

        ForegroundColorSpan fcspan = new ForegroundColorSpan(Color.RED);

        string1.setSpan(fcspan,32,37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string2.setSpan(fcspan,13,17,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mdKubra1.setText(string1);
        mdKubra2.setText(string2);
    }

    private void setmpkubra(){
        if (player.isPlaying()){
            player.pause();
            btnkubra.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnkubra.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
