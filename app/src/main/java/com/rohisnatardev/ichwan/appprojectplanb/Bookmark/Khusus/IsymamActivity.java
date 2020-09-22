package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus;

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

public class IsymamActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mpIsymam;
    ImageButton btnisymam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisymam);

        TextView btnCallBackIs = findViewById(R.id.textNextBtn);
        btnCallBackIs.setOnClickListener(this);
        btnisymam = findViewById(R.id.play_toggle_isymam);
        btnisymam.setOnClickListener(this);
        mpIsymam = MediaPlayer.create(this,R.raw.isymam);

        TextView txisymam = findViewById(R.id.cth_isymam);
        String cthIsymam = getString(R.string.isymam_contoh);

        SpannableString spanIsymam = new SpannableString(cthIsymam);
        ForegroundColorSpan fcIsymam = new ForegroundColorSpan(Color.RED);

        spanIsymam.setSpan(fcIsymam,10,14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txisymam.setText(spanIsymam);
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.textNextBtn:
               Intent isymam = new Intent(this, TashilActivity.class);
               startActivity(isymam);
               break;
           case R.id.play_toggle_isymam:
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
