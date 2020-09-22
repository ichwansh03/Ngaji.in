package com.rohisnatardev.ichwan.appprojectplanb.MimMati;

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

public class IdzharSyafawiActivity extends AppCompatActivity {
MediaPlayer player_izhar;
ImageButton btnidzharsy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idzhar_syafawi);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idzharsy = new Intent(IdzharSyafawiActivity.this,IkfhaSyafawiActivity.class);
                startActivity(idzharsy);
            }
        });
        btnidzharsy = findViewById(R.id.play_toggle_izs);
        btnidzharsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpizs();
            }
        });
        player_izhar = MediaPlayer.create(this,R.raw.izharsyafawi);

        TextView idzharsy1 = findViewById(R.id.image_izs1);
        String izhar1 = getString(R.string.izharsy1);
        TextView idzharsy2 = findViewById(R.id.image_izs);
        String izhar2 = getString(R.string.izharsy2);

        SpannableString stringSpan1 = new SpannableString(izhar1);
        SpannableString stringSpan2 = new SpannableString(izhar2);

        ForegroundColorSpan fcspan = new ForegroundColorSpan(Color.RED);
        stringSpan1.setSpan(fcspan,4,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        stringSpan2.setSpan(fcspan,2,7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        idzharsy1.setText(stringSpan1);
        idzharsy2.setText(stringSpan2);
    }

    private void setmpizs(){
        if (player_izhar.isPlaying()){
            player_izhar.pause();
            btnidzharsy.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player_izhar.start();
            btnidzharsy.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player_izhar != null){
            player_izhar.stop();
        }
        super.onDestroy();
    }
}
