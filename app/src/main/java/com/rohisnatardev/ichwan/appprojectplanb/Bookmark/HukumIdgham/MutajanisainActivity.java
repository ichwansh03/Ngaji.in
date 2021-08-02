package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumIdgham;

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

public class MutajanisainActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer;
ImageButton btnmutaja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_idgham);

        TextView btnCallBackMj = findViewById(R.id.textNextBtn);
        btnCallBackMj.setOnClickListener(this);
        btnmutaja = findViewById(R.id.play_toggle_hukumidgham);
        btnmutaja.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.idghammutajanisain);

        TextView txmutaj = findViewById(R.id.examplehukumidgham);
        String tMutaja = getString(R.string.mutaja1);
        SpannableString spmutaja = new SpannableString(tMutaja);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        spmutaja.setSpan(foregroundColorSpan,10,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txmutaj.setText(spmutaja);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                startActivity(new Intent(this, MutaqaribainActivity.class));
                break;
            case R.id.play_toggle_hukumidgham:
                setmpmutaja();
                break;
        }
    }

    private void setmpmutaja(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnmutaja.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btnmutaja.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
