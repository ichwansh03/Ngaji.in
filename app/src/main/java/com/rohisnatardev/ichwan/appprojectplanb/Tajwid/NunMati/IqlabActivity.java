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

import com.rohisnatardev.ichwan.appprojectplanb.Tajwid.MimMati.IdzharSyafawiActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class IqlabActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player;
ImageButton btnplayiqlab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqlab);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(this);
        btnplayiqlab = findViewById(R.id.play_toggle_iqlab);
        btnplayiqlab.setOnClickListener(this);
        player = MediaPlayer.create(this,R.raw.iqlab);

        TextView textView = findViewById(R.id.image_iqlab);
        String text = getString(R.string.exiqlab);
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);

        ss.setSpan(fcs,7,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent iqlab = new Intent(IqlabActivity.this,IdzharSyafawiActivity.class);
                startActivity(iqlab);
                break;
            case R.id.play_toggle_iqlab:
                setmpiqlab();
                break;
        }
    }

    private void setmpiqlab(){
        if (player.isPlaying()){
            player.pause();
            btnplayiqlab.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnplayiqlab.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    public void onDestroy() {
        if (player != null){
            player.stop();
            player = null;
        }
        super.onDestroy();
    }
}
