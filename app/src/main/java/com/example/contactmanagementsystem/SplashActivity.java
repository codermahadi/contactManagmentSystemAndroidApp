package com.example.contactmanagementsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    LinearLayout app_name, get_start;
    Animation down_from_top, up_from_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        app_name = (LinearLayout) findViewById(R.id.app_name);
        get_start = (LinearLayout) findViewById(R.id.get_start);

        down_from_top = AnimationUtils.loadAnimation(this, R.anim.down_frpm_top);
        up_from_bottom = AnimationUtils.loadAnimation(this, R.anim.up_from_bottom);

        app_name.setAnimation(down_from_top);
        get_start.setAnimation(up_from_bottom);

        int timeout = 3000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                System.out.println("Time Out");
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, timeout);
    }
}
