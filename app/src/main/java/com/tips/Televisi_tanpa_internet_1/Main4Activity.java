package com.tips.Televisi_tanpa_internet_1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Timer;
import java.util.TimerTask;

public class Main4Activity extends AppCompatActivity {

    private AdView mAdView;



    private static int WELCOME_TIMEOUT = 11000;

    private Timer timer;
    private DonutProgress donutProgress;
    private CircleProgress circleProgress;
    private ArcProgress arcProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //ads

        MobileAds.initialize(this, "ca-app-pub-1459580878977332~9882513400");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);





        Timer timer;

        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        donutProgress.setProgress(donutProgress.getProgress() + 1);

                    }
                });
            }
        }, 1000, 100);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcome = new Intent(Main4Activity.this, Main5Activity.class);
                startActivity(welcome);

                finish();
            }
        },WELCOME_TIMEOUT);
    }
}
