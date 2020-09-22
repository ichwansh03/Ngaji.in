package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumIdgham;

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

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.ImalahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class MutaqaribainActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer;
ImageButton btnmutaqa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutaqaribain);

        TextView btnCallBackMq = findViewById(R.id.textNextBtn);
        btnCallBackMq.setOnClickListener(this);
        btnmutaqa = findViewById(R.id.play_toggle_mutaqaribain);
        btnmutaqa.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.idghammutaqarribain);

        TextView mutaq = findViewById(R.id.image_mutaqaribain);
        String tMutaqa = getString(R.string.mutaqa1);

        SpannableString string = new SpannableString(tMutaqa);

        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);

        string.setSpan(fcs,4,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mutaq.setText(string);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent mutaqa = new Intent(MutaqaribainActivity.this, ImalahActivity.class);
                startActivity(mutaqa);
                break;
            case R.id.play_toggle_mutaqaribain:
                setmpmutaqa();
                break;
        }
    }

    private void setmpmutaqa(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnmutaqa.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btnmutaqa.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
        super.onDestroy();
    }
}
