package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumLamdanRa;

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

public class HukumLamTarqiqActivity extends AppCompatActivity {
MediaPlayer mediaPlayer2;
ImageButton btnplayltarqiq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_lam_tarqiq);

        TextView btnCallBackLt = findViewById(R.id.textNextBtn);
        btnCallBackLt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRtafkhim = new Intent(HukumLamTarqiqActivity.this,HukumRaActivity.class);
                startActivity(intentRtafkhim);
            }
        });
        btnplayltarqiq = findViewById(R.id.play_toggle_hukumlam1);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.alqomariyah);
        btnplayltarqiq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpltarqiq();
            }
        });

        TextView lamtarqiq2 = findViewById(R.id.hukumlam_image4);
        String tarqiq2 = getString(R.string.lamtarqiq2);

        SpannableString spanString2 = new SpannableString(tarqiq2);

        ForegroundColorSpan fcolor = new ForegroundColorSpan(Color.RED);
        spanString2.setSpan(fcolor,9,18,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        lamtarqiq2.setText(spanString2);

    }

    private void setmpltarqiq(){
        if (mediaPlayer2.isPlaying()){
            mediaPlayer2.pause();
            btnplayltarqiq.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer2.start();
            btnplayltarqiq.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer2 != null){
            mediaPlayer2.stop();
        }
        super.onDestroy();
    }
}
