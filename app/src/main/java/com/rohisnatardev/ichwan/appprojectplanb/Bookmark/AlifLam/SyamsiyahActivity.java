package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.AlifLam;

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

public class SyamsiyahActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mpSyam;
ImageButton btnsyamsiyah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliflam);

        findViewById(R.id.fabaliflam).setOnClickListener(this);
        btnsyamsiyah = findViewById(R.id.play_toggle);
        btnsyamsiyah.setOnClickListener(this);
        mpSyam = MediaPlayer.create(this,R.raw.assyamsiyah);

        TextView contohSyam = findViewById(R.id.aliflam_arab);
        String mSyamsiyah = getString(R.string.madarid2);
        SpannableString syam_string = new SpannableString(mSyamsiyah);
        ForegroundColorSpan fsyam = new ForegroundColorSpan(Color.RED);
        syam_string.setSpan(fsyam,1,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        contohSyam.setText(syam_string);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabaliflam:
                startActivity(new Intent(this, QomariyahActivity.class));
                break;
            case R.id.play_toggle:
                setmpsyamsi();
                break;
        }
    }

    private void setmpsyamsi(){
        if (mpSyam.isPlaying()){
            mpSyam.pause();
            btnsyamsiyah.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mpSyam.start();
            btnsyamsiyah.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mpSyam != null){
            mpSyam.stop();
        }
        super.onDestroy();
    }
}
