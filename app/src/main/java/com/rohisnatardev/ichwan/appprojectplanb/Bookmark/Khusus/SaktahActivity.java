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

import me.biubiubiu.justifytext.library.JustifyTextView;

public class SaktahActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer playerSaktah;
ImageButton btnsaktah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkhusus);

        findViewById(R.id.fabbacaankhusus).setOnClickListener(this);

        TextView title = findViewById(R.id.txtitle);
        title.setText(R.string.saktah);

        btnsaktah = findViewById(R.id.play_toggle_bkhusus);
        btnsaktah.setOnClickListener(this);
        playerSaktah = MediaPlayer.create(this,R.raw.saktah);

        TextView tvSaktah = findViewById(R.id.bkhusus_arab);
        String txSaktah = getString(R.string.saktah1);
        SpannableString sSaktah = new SpannableString(txSaktah);
        ForegroundColorSpan fcSaktah = new ForegroundColorSpan(Color.RED);
        sSaktah.setSpan(fcSaktah,10,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSaktah.setText(sSaktah);

        JustifyTextView article = findViewById(R.id.tx_article);
        article.setText(R.string.saktah_desc);
        findViewById(R.id.text_article2).setVisibility(View.INVISIBLE);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabbacaankhusus:
                startActivity(new Intent(this, IsymamActivity.class));
                break;
            case R.id.play_toggle_bkhusus:
                setmpsaktah();
                break;
        }
    }

    private void setmpsaktah(){
        if (playerSaktah.isPlaying()){
            playerSaktah.pause();
            btnsaktah.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            playerSaktah.start();
            btnsaktah.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (playerSaktah != null){
            playerSaktah.stop();
        }
        super.onDestroy();
    }
}
