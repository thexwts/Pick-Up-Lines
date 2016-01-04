package com.example.yel.myqoutes.Activity.Host;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.yel.myqoutes.R;

public class Splash extends AppCompatActivity {

    ProgressBar pgr;
    int progress = 0;
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pgr = (ProgressBar) findViewById(R.id.progressBar);
        pgr.getIndeterminateDrawable().setColorFilter(Color.parseColor("#E64A19"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    progress += 20;
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            pgr.setProgress(progress);
                            if (progress == pgr.getMax()) {
                                Intent intent = new Intent(getApplication(), Main_Host.class);
                                startActivity(intent);
                            }
                        }
                    });
                    try {

                        Thread.sleep(300);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }).start();

    }
}
