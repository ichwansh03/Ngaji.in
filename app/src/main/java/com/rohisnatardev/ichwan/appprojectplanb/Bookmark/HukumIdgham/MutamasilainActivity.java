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

public class MutamasilainActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer;
ImageButton btnmutama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_idgham);

        TextView btnCallBackMs = findViewById(R.id.textNextBtn);
        btnCallBackMs.setText(R.string.idgham_mutajanisaan);
        btnCallBackMs.setOnClickListener(this);

        TextView title = findViewById(R.id.tlhukumidgham);
        title.setText(R.string.idgham_mutamatsilaan);
        TextView desc = findViewById(R.id.deschukumidgham);
        desc.setText(R.string.idgham_mutamatsilaan_desc);

        btnmutama = findViewById(R.id.play_toggle_hukumidgham);
        btnmutama.setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.idghammutamasilain);

        TextView textView = findViewById(R.id.examplehukumidgham);
        String txmuta = getString(R.string.mutama1);
        SpannableString sptring = new SpannableString(txmuta);
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        sptring.setSpan(span,10,18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(sptring);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                startActivity(new Intent(this, MutajanisainActivity.class));
                break;
            case R.id.play_toggle_hukumidgham:
                setmpmutama();
                break;
        }
    }

    private void setmpmutama(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            btnmutama.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer.start();
            btnmutama.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
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
