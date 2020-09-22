package com.rohisnatardev.ichwan.appprojectplanb.NunMati;

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


public class IdzharActivity extends AppCompatActivity{
MediaPlayer player;
ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idzhar);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idzhar = new Intent(IdzharActivity.this,IkhfaActivity.class);
                startActivity(idzhar);
            }
        });

        imageButton = findViewById(R.id.play_toggle_idzhar);
        player = MediaPlayer.create(this, R.raw.idzhar);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmp();
            }
        });

        TextView izhar1 = findViewById(R.id.image_idzhar);
        String string = getString(R.string.idzhar1);
        TextView izhar2 = findViewById(R.id.image_idzhar2);
        String string2 = getString(R.string.idzhar2);

        SpannableString span1 = new SpannableString(string);
        SpannableString span2 = new SpannableString(string2);

        ForegroundColorSpan fcspan = new ForegroundColorSpan(Color.RED);
        span1.setSpan(fcspan,4,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(fcspan,6,12,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        izhar1.setText(span1);
        izhar2.setText(span2);
    }

    private void setmp(){
        if (player.isPlaying()){
            player.pause();
            imageButton.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            imageButton.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
