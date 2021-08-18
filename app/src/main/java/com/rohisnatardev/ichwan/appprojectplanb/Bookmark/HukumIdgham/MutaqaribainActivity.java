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

import com.rohisnatardev.ichwan.appprojectplanb.Bookmark.Khusus.ImalahActivity;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class MutaqaribainActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer;
ImageButton btnmutaqa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_idgham);

        findViewById(R.id.fabhukumidgham).setOnClickListener(this);

        TextView title = findViewById(R.id.tlhukumidgham);
        title.setText(R.string.idgham_mutaqaribaan);
        TextView desc = findViewById(R.id.deschukumidgham);
        desc.setText(R.string.idgham_mutaqaribaan_desc);

        btnmutaqa = findViewById(R.id.play_toggle_hukumidgham);
        btnmutaqa.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.idghammutaqarribain);

        TextView mutaq = findViewById(R.id.examplehukumidgham);
        String tMutaqa = getString(R.string.mutaqa1);
        SpannableString string = new SpannableString(tMutaqa);
        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);
        string.setSpan(fcs,4,9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mutaq.setText(string);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fabhukumidgham:
                startActivity(new Intent(this, ImalahActivity.class));
                break;
            case R.id.play_toggle_hukumidgham:
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
