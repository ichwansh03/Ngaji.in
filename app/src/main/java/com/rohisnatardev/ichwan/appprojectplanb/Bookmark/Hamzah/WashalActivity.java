package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Hamzah;

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

public class WashalActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player1, player2;
ImageButton btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washal);

        TextView textView = findViewById(R.id.textNextBtn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WashalActivity.this,QathiActivity.class);
                startActivity(intent);
            }
        });
        btn1 = findViewById(R.id.play_toggle_washal1);
        btn1.setOnClickListener(this);
        player1 = MediaPlayer.create(this,R.raw.wasalfiildommah);
        btn2 = findViewById(R.id.play_toggle_washal2);
        btn2.setOnClickListener(this);
        player2 = MediaPlayer.create(this,R.raw.hamzahwasalnon);

        TextView txwashal1 = findViewById(R.id.txarabwashal1);
        String sWasahl1 = getString(R.string.wasal1);
        TextView txwashal2 = findViewById(R.id.txarabwashal2);

        String sWashal2 = getString(R.string.wasal15);
        TextView txwashal3 = findViewById(R.id.txarabwashal3);

        String sWashal3 = getString(R.string.wasal2);

        SpannableString spWashal1 = new SpannableString(sWasahl1);
        SpannableString spWashal2 = new SpannableString(sWashal2);
        SpannableString spWashal3 = new SpannableString(sWashal3);

        ForegroundColorSpan fcspan = new ForegroundColorSpan(Color.RED);

        spWashal1.setSpan(fcspan,0,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spWashal2.setSpan(fcspan,23,25,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spWashal3.setSpan(fcspan,20,22,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txwashal1.setText(spWashal1);
        txwashal2.setText(spWashal2);
        txwashal3.setText(spWashal3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_toggle_washal1:
                setmp1();
                break;
            case R.id.play_toggle_washal2:
                setmp2();
                break;
        }
    }

    private void setmp1(){
        if (player1.isPlaying()){
            player1.pause();
            btn1.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player1.start();
            btn1.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    private void setmp2(){
        if (player2.isPlaying()){
            player2.pause();
            btn2.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player2.start();
            btn2.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player1 != null && player2 != null){
            player1.stop();
            player2.stop();
        }
        super.onDestroy();
    }
}
