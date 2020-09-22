package com.rohisnatardev.ichwan.appprojectplanb.HukumMad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.rohisnatardev.ichwan.appprojectplanb.R;

public class MadLazimActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer player,player2,player3,player4;
ImageButton btn, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lazim);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent madlazim = new Intent(MadLazimActivity.this,MadMunfasilActivity.class);
                startActivity(madlazim);
            }
        });

        btn = findViewById(R.id.play_toggle_madlazim);
        btn.setOnClickListener(this);
        player = MediaPlayer.create(this,R.raw.madlazim);

        btn2 = findViewById(R.id.play_toggle_madlazim2);
        btn2.setOnClickListener(this);
        player2 = MediaPlayer.create(this,R.raw.madlazim2);

        btn3 = findViewById(R.id.play_toggle_madlazim3);
        btn3.setOnClickListener(this);
        player3 = MediaPlayer.create(this,R.raw.madlazim3);

        btn4 = findViewById(R.id.play_toggle_madlazim4);
        btn4.setOnClickListener(this);
        player4 = MediaPlayer.create(this,R.raw.madlazim4);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_toggle_madlazim:
                setmplazim();
                break;
            case R.id.play_toggle_madlazim2:
                setmplazim2();
                break;
            case R.id.play_toggle_madlazim3:
                setmplazim3();
                break;
            case R.id.play_toggle_madlazim4:
                setmplazim4();
                break;
        }
    }

    private void setmplazim(){
        if (player.isPlaying()){
            player.pause();
            btn.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btn.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    private void setmplazim2(){
        if (player2.isPlaying()){
            player2.pause();
            btn2.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player2.start();
            btn2.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmplazim3(){
        if (player3.isPlaying()){
            player3.pause();
            btn3.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player3.start();
            btn3.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }
    private void setmplazim4(){
        if (player4.isPlaying()){
            player4.pause();
            btn4.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player4.start();
            btn4.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player != null || player2 != null || player3 != null || player4 != null){
            player.stop();
            player2.stop();
            player3.stop();
            player4.stop();
        }
        super.onDestroy();
    }
}
