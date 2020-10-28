package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid;

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

public class BlogTajwidDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TAJWID = "extra_tajwid";

    TextView tldetTajwid, ctdetTajwid;
    private ProgressBar progressBar;
    ImageView imgview;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);

        tldetTajwid = findViewById(R.id.tlbgdet);
        ctdetTajwid = findViewById(R.id.ctdesc);
        progressBar = findViewById(R.id.pgb_det);
        imgview = findViewById(R.id.imgblogdet);

        progressBar.setVisibility(View.VISIBLE);

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
                        BlogTajwidItem tajwidItem = getIntent().getParcelableExtra(EXTRA_TAJWID);

                        tldetTajwid.setText(tajwidItem.getTlptTajwid());

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                            ctdetTajwid.setText(Html.fromHtml(tajwidItem.getDsptTajwid(),Html.FROM_HTML_MODE_COMPACT));
                        } else {
                            ctdetTajwid.setText(Html.fromHtml(tajwidItem.getDsptTajwid()));
                        }

                        Document document = Jsoup.parse(tajwidItem.getDsptTajwid());
                        Elements elements = document.select("img");
                        Glide.with(BlogTajwidDetailActivity.this)
                                .load(elements.get(0).attr("src")).into(imgview);

                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }
}
