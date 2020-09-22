package com.rohisnatardev.ichwan.appprojectplanb.NunMati;

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

public class IkhfaActivity extends AppCompatActivity {
    MediaPlayer player;
    ImageButton btnikhfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikhfa);
        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ikhfa = new Intent(IkhfaActivity.this,IqlabActivity.class);
                startActivity(ikhfa);
            }
        });
        btnikhfa = findViewById(R.id.play_toggle_ikhfa);
        btnikhfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmpikhfa();
            }
        });
        player = MediaPlayer.create(this, R.raw.ikhfa);

        TextView txIkhfa1 = findViewById(R.id.contoh_ikhfa);
        String sIkhfa1 = getString(R.string.ikhfa1);
        TextView txIkhfa2 = findViewById(R.id.contoh_ikhfa2);
        String sIkhfa2 = getString(R.string.ikhfa2);

        SpannableString string1 = new SpannableString(sIkhfa1);
        SpannableString string2 = new SpannableString(sIkhfa2);

        ForegroundColorSpan fcs = new ForegroundColorSpan(Color.RED);
        string1.setSpan(fcs,12,15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string2.setSpan(fcs,2,9,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txIkhfa1.setText(string1);
        txIkhfa2.setText(string2);
    }

    private void setmpikhfa(){
        if (player.isPlaying()){
            player.pause();
            btnikhfa.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            player.start();
            btnikhfa.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (player != null){
            player.stop();
        }
        super.onDestroy();
    }
}
