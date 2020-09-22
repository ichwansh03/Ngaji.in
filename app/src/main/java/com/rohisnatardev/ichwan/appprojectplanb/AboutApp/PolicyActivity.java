package com.rohisnatardev.ichwan.appprojectplanb.AboutApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rohisnatardev.ichwan.appprojectplanb.R;


public class PolicyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        WebView web = findViewById(R.id.webPolicy);

        web.loadUrl("https://privacybbq.blogspot.com/2020/06/privacy-policy-bina-bacaan-quran.html");
        web.setWebViewClient(new WebViewClient());
    }
}
