 package com.winsion.lifecyclestest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

 public class MainActivity extends AppCompatActivity {

     private MyChronometer chronometer;
//     private long elapsedTime;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         chronometer = findViewById(R.id.chronometer);
         getLifecycle().addObserver(chronometer);
//         //返回系统启动到现在的毫秒数，包含休眠时间
//         chronometer.setBase(SystemClock.elapsedRealtime());
//         chronometer.start();
    }

//     @Override
//     protected void onPause() {
//         super.onPause();
//         elapsedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
//         chronometer.stop();
//     }
//
//     @Override
//     protected void onResume() {
//         super.onResume();
//         chronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
//         chronometer.start();
//     }
 }
