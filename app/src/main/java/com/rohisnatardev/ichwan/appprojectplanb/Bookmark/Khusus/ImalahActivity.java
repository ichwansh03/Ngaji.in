package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class ImalahActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaImalah;
ImageButton btnimalah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkhusus);

        findViewById(R.id.fabbacaankhusus).setOnClickListener(this);
        btnimalah = findViewById(R.id.play_toggle_bkhusus);
        btnimalah.setOnClickListener(this);
        mediaImalah = MediaPlayer.create(this,R.raw.imalah);

        TextView tvImalah = findViewById(R.id.bkhusus_arab);
        String txImalah = getString(R.string.imalah1);
        SpannableString sImalah = new SpannableString(txImalah);
        ForegroundColorSpan fcImalah = new ForegroundColorSpan(Color.RED);
        sImalah.setSpan(fcImalah,43,50, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvImalah.setText(sImalah);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabbacaankhusus:
                startActivity(new Intent(this, NaqlActivity.class));
                break;
            case R.id.play_toggle:
                setmpimalah();
                break;
        }
    }

    private void setmpimalah(){
        if (mediaImalah.isPlaying()){
            mediaImalah.pause();
            btnimalah.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        }else {
            mediaImalah.start();
            btnimalah.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaImalah != null){
            mediaImalah.stop();
        }
        super.onDestroy();
    }
}
