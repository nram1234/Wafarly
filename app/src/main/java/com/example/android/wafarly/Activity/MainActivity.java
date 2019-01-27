package com.example.android.wafarly.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.android.wafarly.Adapter.FirestTimeSlid;
import com.example.android.wafarly.R;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    FirestTimeSlid adpter;
    CircleIndicator indicator;
    LinearLayout linearLayout;
    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viwpager);
        adpter = new FirestTimeSlid(this);
        viewPager.setAdapter(adpter);
        indicator = (CircleIndicator) findViewById(R.id.circular);
        indicator.setViewPager(viewPager);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();
                int p = adpter.image.length;
                i++;
                viewPager.setCurrentItem(i,true);
                if (i == p - 1) {

                 startActivity(new Intent(getApplicationContext(),Login.class));
                 finish();
                }


            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 2000, 2000);

    }
}
