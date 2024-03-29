package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.rohisnatardev.ichwan.appprojectplanb.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class BlogQuranDetailActivity extends AppCompatActivity {

    public static final String EXTRA_QURAN = "extra_quran";
    TextView txtitle, txdesc;
    ImageView imgview;
    private ProgressBar bar;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);

        txtitle = findViewById(R.id.tlbgdet);
        txdesc = findViewById(R.id.ctdesc);
        imgview = findViewById(R.id.imgblogdet);
        bar = findViewById(R.id.pgb_det);

        bar.setVisibility(View.VISIBLE);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        BlogQuranItem item = getIntent().getParcelableExtra(EXTRA_QURAN);

                        txtitle.setText(item.getTlquran());

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                            txdesc.setText(Html.fromHtml(item.getCnquran(),Html.FROM_HTML_MODE_COMPACT));
                        } else {
                            txdesc.setText(Html.fromHtml(item.getCnquran()));
                        }

                        Document document = Jsoup.parse(item.getCnquran());
                        Elements elements = document.select("img");
                        Glide.with(BlogQuranDetailActivity.this)
                                .load(elements.get(0).attr("src")).into(imgview);

                        bar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }
}
