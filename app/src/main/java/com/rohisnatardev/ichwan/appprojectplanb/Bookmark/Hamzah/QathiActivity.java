package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Hamzah;

import androidx.appcompat.app.AppCompatActivity;

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

public class QathiActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
ImageButton btnqathi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qathi);

        btnqathi = findViewById(R.id.play_toggle_qathi);
        btnqathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpqathi();
            }
        });
        mediaPlayer = MediaPlayer.create(this,R.raw.hamzahqothi);

        TextView txarab = findViewById(R.id.txqathiarab);
        String qothi = getString(R.string.hamqathi);
        SpannableString spqahti = new SpannableString(qothi);
        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);
        spqahti.setSpan(fcs,4,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txarab.setText(spqahti);
    }

    private void setmpqathi(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnqathi.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btnqathi.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
