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

public class HukumRaActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer,mediaPlayer2,mediaPlayer3,mediaPlayer4,mediaPlayer5,mediaPlayer6;
ImageButton btn, btn2, btn3, btn4, btn5, btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_ra_tafkhim);

        findViewById(R.id.fabratafkhim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HukumRaActivity.this, HukumRaTarqiqActivity.class));
            }
        });

        btn = findViewById(R.id.play_toggle_hukumra);
        btn.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.madtafkhimc1);

        btn2 = findViewById(R.id.play_toggle_hukumra2);
        btn2.setOnClickListener(this);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.madtafkhimc4);

        btn3 = findViewById(R.id.play_toggle_hukumra3);
        btn3.setOnClickListener(this);
        mediaPlayer3 = MediaPlayer.create(this,R.raw.madtafkhimc2);

        btn4 = findViewById(R.id.play_toggle_hukumra4);
        btn4.setOnClickListener(this);
        mediaPlayer4 = MediaPlayer.create(this,R.raw.madtafkhimc5);

        btn5 = findViewById(R.id.play_toggle_hukumra5);
        btn5.setOnClickListener(this);
        mediaPlayer5 = MediaPlayer.create(this,R.raw.madtafkhimc7);

        btn6 = findViewById(R.id.play_toggle_hukumra6);
        btn6.setOnClickListener(this);
        mediaPlayer6 = MediaPlayer.create(this,R.raw.madtafkhimc3);

        TextView ratafkhim1 = findViewById(R.id.hukumra_image1);
        String ratafk1 = getString(R.string.ratafkhim1);
        TextView ratafkhim2 = findViewById(R.id.hukumra_image2);
        String ratafk2 = getString(R.string.ratafkhim2);
        TextView ratafkhim3 = findViewById(R.id.hukumra_image3);
        String ratafk3 = getString(R.string.ratafkhim3);
        TextView ratafkhim4 = findViewById(R.id.hukumra_image4);
        String ratafk4 = getString(R.string.ratafkhim4);
        TextView ratafkhim5 = findViewById(R.id.hukumra_image5);
        String ratafk5 = getString(R.string.ratafkhim5);
        TextView ratafkhim6 = findViewById(R.id.hukumra_image6);
        String ratafk6 = getString(R.string.ratafkhim6);

        SpannableString spanRa1 = new SpannableString(ratafk1);
        SpannableString spanRa2 = new SpannableString(ratafk2);
        SpannableString spanRa3 = new SpannableString(ratafk3);
        SpannableString spanRa4 = new SpannableString(ratafk4);
        SpannableString spanRa5 = new SpannableString(ratafk5);
        SpannableString spanRa6 = new SpannableString(ratafk6);

        ForegroundColorSpan fcolorSpan = new ForegroundColorSpan(Color.RED);

        spanRa1.setSpan(fcolorSpan,0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ratafkhim1.setText(spanRa1);
        spanRa2.setSpan(fcolorSpan,4,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ratafkhim2.setText(spanRa2);
        spanRa3.setSpan(fcolorSpan,2,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ratafkhim3.setText(spanRa3);
        spanRa4.setSpan(fcolorSpan,5,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ratafkhim4.setText(spanRa4);
        spanRa5.setSpan(fcolorSpan,9,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ratafkhim5.setText(spanRa5);
        spanRa6.setSpan(fcolorSpan,9,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ratafkhim6.setText(spanRa6);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_toggle_hukumra:
                setmp1();
                break;
            case R.id.play_toggle_hukumra2:
                setmp2();
                break;
            case R.id.play_toggle_hukumra3:
                setmp3();
                break;
            case R.id.play_toggle_hukumra4:
                setmp4();
                break;
            case R.id.play_toggle_hukumra5:
                setmp5();
                break;
            case R.id.play_toggle_hukumra6:
                setmp6();
                break;
        }
    }

    private void setmp1(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btn.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btn.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    private void setmp2(){
        if (mediaPlayer2.isPlaying()){
            mediaPlayer2.pause();
            btn2.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer2.start();
            btn2.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmp3(){
        if (mediaPlayer3.isPlaying()){
            mediaPlayer3.pause();
            btn3.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer3.start();
            btn3.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmp4(){
        if (mediaPlayer4.isPlaying()){
            mediaPlayer4.pause();
            btn4.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer4.start();
            btn4.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmp5(){
        if (mediaPlayer5.isPlaying()){
            mediaPlayer5.pause();
            btn5.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer5.start();
            btn5.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmp6(){
        if (mediaPlayer6.isPlaying()){
            mediaPlayer6.pause();
            btn6.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer6.start();
            btn6.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null || mediaPlayer2 != null || mediaPlayer3 != null || mediaPlayer4 != null
        || mediaPlayer5 != null || mediaPlayer6 != null){
            mediaPlayer.stop();
            mediaPlayer2.stop();
            mediaPlayer3.stop();
            mediaPlayer4.stop();
            mediaPlayer5.stop();
            mediaPlayer6.stop();
        }
        super.onDestroy();
    }
}
