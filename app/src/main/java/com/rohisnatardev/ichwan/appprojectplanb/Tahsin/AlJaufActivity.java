package com.rohisnatardev.ichwan.appprojectplanb.Tahsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rohisnatardev.ichwan.appprojectplanb.R;

public class AlJaufActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_jauf);

        TextView btnCallBack = findViewById(R.id.textNextBtn);
        btnCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentKhais = new Intent(AlJaufActivity.this,AlKhaisActivity.class);
                startActivity(intentKhais);
            }
        });

    }

}
