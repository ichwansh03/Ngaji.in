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

import com.rohisnatardev.ichwan.appprojectplanb.HukumMad.MadBadalActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class IdghamMislainActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player_idgham;
ImageButton btnidm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idgham_mislain);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(this);
        btnidm = findViewById(R.id.play_toggle_idm);
        btnidm.setOnClickListener(this);
        player_idgham = MediaPlayer.create(this,R.raw.idghammislain);

        TextView mislain = findViewById(R.id.image_idm);
        String stringIdm = getString(R.string.mislain1);

        SpannableString spannableString = new SpannableString(stringIdm);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);

        spannableString.setSpan(foregroundColorSpan,18,23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mislain.setText(spannableString);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent idghammimi = new Intent(IdghamMislainActivity.this,MadBadalActivity.class);
                startActivity(idghammimi);
                break;
            case R.id.play_toggle_idm:
                plaympidm();
                break;
        }
    }

    private void plaympidm(){
        if (player_idgham.isPlaying()){
            player_idgham.pause();
            btnidm.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player_idgham.start();
            btnidm.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player_idgham != null){
            player_idgham.stop();
        }
        super.onDestroy();
    }
}
