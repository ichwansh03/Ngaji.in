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

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Hamzah.WashalActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class QomariyahActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mpQomar;
ImageButton btnqomar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliflam);

        findViewById(R.id.fabaliflam).setOnClickListener(this);

        JustifyTextView article = findViewById(R.id.tx_article_aliflam);
        article.setText(R.string.desc_qomariyah);

        btnqomar = findViewById(R.id.play_toggle);
        btnqomar.setOnClickListener(this);
        mpQomar = MediaPlayer.create(this,R.raw.alqomariyah);

        TextView qomar_arab = findViewById(R.id.aliflam_arab);
        String mQomar = getString(R.string.madarid1);
        SpannableString spQomar = new SpannableString(mQomar);
        ForegroundColorSpan fcQomar = new ForegroundColorSpan(Color.RED);
        spQomar.setSpan(fcQomar,1,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        qomar_arab.setText(spQomar);

        TextView title = findViewById(R.id.textTitle);
        title.setText(R.string.al_qomariyah);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabaliflam:
                startActivity(new Intent(this, WashalActivity.class));
                break;
            case R.id.play_toggle:
                setmpqomar();
                break;
        }
    }

    private void setmpqomar(){
        if (mpQomar.isPlaying()){
            mpQomar.pause();
            btnqomar.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mpQomar.start();
            btnqomar.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mpQomar != null){
            mpQomar.stop();
        }
        super.onDestroy();
    }
}
