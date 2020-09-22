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

public class MadShilahActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player1, player2, player3;
ImageButton btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_shilah);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madshilahs = new Intent(MadShilahActivity.this,MadSlhKubraActivity.class);
                startActivity(madshilahs);
            }
        });
        btn1 = findViewById(R.id.play_toggle_madshilah);
        btn1.setOnClickListener(this);
        player1 = MediaPlayer.create(this,R.raw.madshilahsughra);

        btn2 = findViewById(R.id.play_toggle_mdsilahmati);
        btn2.setOnClickListener(this);
        player2 = MediaPlayer.create(this,R.raw.madshilahsughrahasukun);

        btn3 = findViewById(R.id.play_toggle_pcmadsilah);
        btn3.setOnClickListener(this);
        player3 = MediaPlayer.create(this,R.raw.madshilahsughrapengecualian1);

        TextView madshilah1 = findViewById(R.id.image_madshilah);
        String shilah1 = getString(R.string.madshila1);
        TextView madshilah2 = findViewById(R.id.image1);
        String shilah2 = getString(R.string.madshila2);

        SpannableString spshilah1 = new SpannableString(shilah1);
        SpannableString spshilah2 = new SpannableString(shilah2);

        ForegroundColorSpan fspan = new ForegroundColorSpan(Color.RED);

        spshilah1.setSpan(fspan,9,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spshilah2.setSpan(fspan,5,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        madshilah1.setText(spshilah1);
        madshilah2.setText(spshilah2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_toggle_madshilah:
                setmp1();
                break;
            case R.id.play_toggle_mdsilahmati:
                setmp2();
                break;
            case R.id.play_toggle_pcmadsilah:
                setmp3();
                break;
        }
    }

    private void setmp1() {
        if (player1.isPlaying()){
            player1.pause();
            btn1.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player1.start();
            btn1.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmp2() {
        if (player2.isPlaying()){
            player2.pause();
            btn2.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player2.start();
            btn2.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmp3() {
        if (player3.isPlaying()){
            player3.pause();
            btn3.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player3.start();
            btn3.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player1 != null || player2 != null || player3 != null){
            player1.stop();
            player2.stop();
            player3.stop();
        }
        super.onDestroy();
    }
}
