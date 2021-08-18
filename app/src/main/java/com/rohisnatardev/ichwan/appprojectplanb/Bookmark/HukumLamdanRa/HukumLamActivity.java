package com.rohisnatardev.ichwan.appprojectplanb.Bookmark.HukumLamdanRa;

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

public class HukumLamActivity extends AppCompatActivity {
MediaPlayer mediaPlayer1;
ImageButton btnplaylam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hukum_lam);

        findViewById(R.id.fabhukumlam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HukumLamActivity.this, HukumLamTarqiqActivity.class));
            }
        });

        btnplaylam = findViewById(R.id.play_toggle_hukumlam);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.lamtafkhim);
        btnplaylam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setmplam();
            }
        });

        TextView lamtafkhim1 = findViewById(R.id.example_hukumlam);
        String stringLam1 = getString(R.string.lamtafkhim1);
        TextView lamtafkhim2 = findViewById(R.id.exampl2_hukumlam);
        String stringLam2 = getString(R.string.lamtafkhim2);

        SpannableString lamtaf1 = new SpannableString(stringLam1);
        SpannableString lamtaf2 = new SpannableString(stringLam2);

        ForegroundColorSpan fspan1 = new ForegroundColorSpan(Color.RED);

        lamtaf1.setSpan(fspan1,5,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        lamtaf2.setSpan(fspan1,20,26,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        lamtafkhim1.setText(lamtaf1);
        lamtafkhim2.setText(lamtaf2);

    }

    private void setmplam(){
        if (mediaPlayer1.isPlaying()){
            mediaPlayer1.pause();
            btnplaylam.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
        } else {
            mediaPlayer1.start();
            btnplaylam.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer1 != null){
            mediaPlayer1.stop();
        }
        super.onDestroy();
    }
}
