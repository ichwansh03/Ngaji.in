package com.rohisnatardev.ichwan.appprojectplanb.Tajwid.MimMati;

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

public class IkfhaSyafawiActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player_ikhfa;
ImageButton btniks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikfha_syafawi);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(this);
        player_ikhfa = MediaPlayer.create(this,R.raw.ikhfasyafawi);

        btniks = findViewById(R.id.play_toggle_iks);
        btniks.setOnClickListener(this);

        TextView ikhfasyafawi = findViewById(R.id.image_iks);
        String ikhfaArab = getString(R.string.ikhfasy1);
        SpannableString string = new SpannableString(ikhfaArab);

        ForegroundColorSpan frcolor = new ForegroundColorSpan(Color.RED);
        string.setSpan(frcolor,8,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ikhfasyafawi.setText(string);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textNextBtn:
                Intent intent = new Intent(this, IdghamMislainActivity.class);
                startActivity(intent);
                break;
            case R.id.play_toggle_iks:
                setmpiks();
                break;
        }
    }

    private void setmpiks(){
        if (player_ikhfa.isPlaying()){
            player_ikhfa.pause();
            btniks.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player_ikhfa.start();
            btniks.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player_ikhfa != null){
            player_ikhfa.stop();
        }
        super.onDestroy();
    }
}
