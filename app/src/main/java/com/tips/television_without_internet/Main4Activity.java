package com.tips.television_without_internet;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.Timer;
import java.util.TimerTask;

public class Main4Activity extends AppCompatActivity {

    private static int WELCOME_TIMEOUT = 61000;

    private Timer timer;
    private DonutProgress donutProgress;
    private CircleProgress circleProgress;
    private ArcProgress arcProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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
        }, 1000, 600);



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
