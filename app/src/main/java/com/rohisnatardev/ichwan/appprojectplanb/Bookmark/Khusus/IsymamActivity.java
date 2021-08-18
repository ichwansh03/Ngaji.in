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

public class IsymamActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mpIsymam;
    ImageButton btnisymam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkhusus);

        findViewById(R.id.fabbacaankhusus).setOnClickListener(this);

        TextView title = findViewById(R.id.txtitle);
        title.setText(R.string.isymam);

        btnisymam = findViewById(R.id.play_toggle_bkhusus);
        btnisymam.setOnClickListener(this);
        mpIsymam = MediaPlayer.create(this,R.raw.isymam);

        TextView txisymam = findViewById(R.id.bkhusus_arab);
        String cthIsymam = getString(R.string.isymam_contoh);
        SpannableString spanIsymam = new SpannableString(cthIsymam);
        ForegroundColorSpan fcIsymam = new ForegroundColorSpan(Color.RED);
        spanIsymam.setSpan(fcIsymam,10,14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txisymam.setText(spanIsymam);

        JustifyTextView article = findViewById(R.id.tx_article);
        article.setText(R.string.isymam_desc);
        findViewById(R.id.text_article2).setVisibility(View.INVISIBLE);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.fabbacaankhusus:
               startActivity(new Intent(this, TashilActivity.class));
               break;
           case R.id.play_toggle_bkhusus:
               setmpisymam();
               break;
       }
    }

    private void setmpisymam(){
        if (mpIsymam.isPlaying()){
            mpIsymam.pause();
            btnisymam.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mpIsymam.start();
            btnisymam.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mpIsymam != null){
            mpIsymam.stop();
        }
        super.onDestroy();
    }
}
