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

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumIdgham.MutamasilainActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;


public class HukumRaTarqiqActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3;
ImageButton btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_ra_tarqiq);


        btn1 = findViewById(R.id.play_toggle_ratarqiq1);
        btn1.setOnClickListener(this);
        mediaPlayer1 = MediaPlayer.create(this,R.raw.madtarqiqc1);
        btn2 = findViewById(R.id.play_toggle_ratarqiq2);
        btn2.setOnClickListener(this);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.madtarqiqc2);
        btn3 = findViewById(R.id.play_toggle_ratarqiq3);
        btn3.setOnClickListener(this);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.madtarqiqc3);
        type();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent intentMutama = new Intent(HukumRaTarqiqActivity.this,MutamasilainActivity.class);
                startActivity(intentMutama);
                break;
            case R.id.play_toggle_ratarqiq1:
                playMusic1();
                break;
            case R.id.play_toggle_ratarqiq2:
                playMusic2();
                break;
            case R.id.play_toggle_ratarqiq3:
                playMusic3();
                break;
        }
    }

    private void playMusic1(){
        if (mediaPlayer1.isPlaying()){
            mediaPlayer1.pause();
            btn1.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer1.start();
            btn1.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }

    }

    private void playMusic2(){
        if (mediaPlayer2.isPlaying()){
            mediaPlayer2.pause();
            btn2.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer2.start();
            btn2.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }

    }

    private void playMusic3(){
        if (mediaPlayer3.isPlaying()){
            mediaPlayer3.pause();
            btn3.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer3.start();
            btn3.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }

    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer1 != null || mediaPlayer2 != null || mediaPlayer3 != null){
            mediaPlayer1.stop();
            mediaPlayer2.stop();
            mediaPlayer3.stop();
        }

        super.onDestroy();
    }

    private void type(){
        TextView btnCallBackRt = findViewById(R.id.textNextBtn);

        btnCallBackRt.setOnClickListener(this);

        TextView ratarqiq1 = findViewById(R.id.ratarqiq_image1);
        String stringRa1 = getString(R.string.ratarqiq1);
        TextView ratarqiq2 = findViewById(R.id.ratarqiq_image2);
        String stringRa2 = getString(R.string.ratarqiq2);
        TextView ratarqiq3 = findViewById(R.id.ratarqiq_image3);
        String stringRa3 = getString(R.string.ratarqiq3);
        TextView ratarqiq4 = findViewById(R.id.ratarqiq_image4);
        String stringRa4 = getString(R.string.ratarqiq4);

        SpannableString rastring1 = new SpannableString(stringRa1);
        SpannableString rastring2 = new SpannableString(stringRa2);
        SpannableString rastring3 = new SpannableString(stringRa3);
        SpannableString rastring4 = new SpannableString(stringRa4);

        ForegroundColorSpan colorSpanRa = new ForegroundColorSpan(Color.RED);

        rastring1.setSpan(colorSpanRa,1,3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        rastring2.setSpan(colorSpanRa,10,13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        rastring3.setSpan(colorSpanRa,7,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        rastring4.setSpan(colorSpanRa,36,38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ratarqiq1.setText(rastring1);
        ratarqiq2.setText(rastring2);
        ratarqiq3.setText(rastring3);
        ratarqiq4.setText(rastring4);
    }
}
