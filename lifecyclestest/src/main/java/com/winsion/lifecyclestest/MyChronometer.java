package com.winsion.lifecyclestest;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * author: hewensheng
 * date  : 2019/9/25 17:01
 * desc  :
 */
public class MyChronometer extends Chronometer implements LifecycleObserver {

    private long elapsedTime;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter(){
        elapsedTime = SystemClock.elapsedRealtime() -getBase();
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter(){
        setBase(SystemClock.elapsedRealtime() -elapsedTime);
        start();
    }


}
