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

public class NaqlActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer playerNaql;
ImageButton btnnaql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkhusus);

        TextView btnCallBackNq = findViewById(R.id.textNextBtn);
        btnCallBackNq.setText(R.string.saktah);
        btnCallBackNq.setOnClickListener(this);

        TextView title = findViewById(R.id.txtitle);
        title.setText(R.string.naql);

        btnnaql = findViewById(R.id.play_toggle_bkhusus);
        btnnaql.setOnClickListener(this);
        playerNaql = MediaPlayer.create(this,R.raw.naql);

        TextView tvnaql = findViewById(R.id.bkhusus_arab);
        String sNaql = getString(R.string.naql1);
        SpannableString spanaql = new SpannableString(sNaql);
        ForegroundColorSpan fclspan = new ForegroundColorSpan(Color.RED);
        spanaql.setSpan(fclspan,7,8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvnaql.setText(spanaql);

        TextView article = findViewById(R.id.tx_article);
        article.setText(R.string.naql_desc);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                startActivity(new Intent(this, SaktahActivity.class));
                break;
            case R.id.play_toggle_bkhusus:
                setmpnaql();
                break;
        }
    }

    private void setmpnaql(){
        if (playerNaql.isPlaying()){
            playerNaql.pause();
            btnnaql.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            playerNaql.start();
            btnnaql.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (playerNaql != null){
            playerNaql.stop();
        }
        super.onDestroy();
    }
}
