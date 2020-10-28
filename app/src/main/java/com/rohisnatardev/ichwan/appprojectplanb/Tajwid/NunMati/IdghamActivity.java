package com.rohisnatardev.ichwan.appprojectplanb.Tajwid.NunMati;

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

public class IdghamActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player_idghambg, player_idghamblg, player_pcidgham;
ImageButton btnbg, btnblg, btnpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idgham);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idgham = new Intent(IdghamActivity.this,IdzharActivity.class);
                startActivity(idgham);
            }
        });

        btnbg = findViewById(R.id.play_toggle_idghambg);
        btnbg.setOnClickListener(this);
        player_idghambg = MediaPlayer.create(this,R.raw.idghambigunnah);

        btnblg = findViewById(R.id.play_toggle_idghamblg);
        btnblg.setOnClickListener(this);
        player_idghamblg = MediaPlayer.create(this,R.raw.idghambilagunnah);

        btnpc = findViewById(R.id.play_toggle_pcidgham);
        btnpc.setOnClickListener(this);
        player_pcidgham = MediaPlayer.create(this,R.raw.pengecualianidgham);

        TextView txidghambg1 = findViewById(R.id.image_idghambg1);
        String idghambg1 = getString(R.string.idghambg1);
        TextView txidghambg2 = findViewById(R.id.image_idghambg2);
        String idghambg2 = getString(R.string.idghambg2);
        TextView txidghamblg1 = findViewById(R.id.image_idghamblg1);
        String idghamblg1 = getString(R.string.idghamblg1);
        TextView txidghamblg2 = findViewById(R.id.image_idghamblg2);
        String idghamblg2 = getString(R.string.idghamblg2);
        TextView txpcighma1 = findViewById(R.id.pcidgham_image1);
        String pcidgham1 = getString(R.string.pcidgham1);
        TextView txpcidgham2 = findViewById(R.id.pcidgham_image2);
        String pcidgham2 = getString(R.string.pcidgham2);

        SpannableString spidghambg1 = new SpannableString(idghambg1);
        SpannableString spidghambg2 = new SpannableString(idghambg2);
        SpannableString spidghamblg1 = new SpannableString(idghamblg1);
        SpannableString spidghamblg2 = new SpannableString(idghamblg2);
        SpannableString spcidgham1 = new SpannableString(pcidgham1);
        SpannableString spcidghma2 = new SpannableString(pcidgham2);
        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);
        spidghambg1.setSpan(fcs,4,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spidghambg2.setSpan(fcs,7,13,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spidghamblg1.setSpan(fcs,4,11,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spidghamblg2.setSpan(fcs,21,28,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spcidgham1.setSpan(fcs,9,15,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spcidghma2.setSpan(fcs,1,8,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txidghambg1.setText(spidghambg1);
        txidghambg2.setText(spidghambg2);
        txidghamblg1.setText(spidghamblg1);
        txidghamblg2.setText(spidghamblg2);
        txpcighma1.setText(spcidgham1);
        txpcidgham2.setText(spcidghma2);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_toggle_idghambg:
                setmpbg();
                break;
            case R.id.play_toggle_idghamblg:
                setmpblg();
                break;
            case R.id.play_toggle_pcidgham:
                setmppc();
                break;
        }
    }

    private void setmpbg(){
        if (player_idghambg.isPlaying()){
            player_idghambg.pause();
            btnbg.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player_idghambg.start();
            btnbg.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    private void setmpblg(){
        if (player_idghamblg.isPlaying()){
            player_idghamblg.pause();
            btnblg.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player_idghamblg.start();
            btnblg.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    private void setmppc(){
        if (player_pcidgham.isPlaying()){
            player_pcidgham.pause();
            btnpc.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player_pcidgham.start();
            btnpc.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player_idghambg != null || player_idghamblg != null || player_pcidgham != null){
            player_idghambg.stop();
            player_idghamblg.stop();
            player_pcidgham.stop();
        }
        super.onDestroy();
    }
}
