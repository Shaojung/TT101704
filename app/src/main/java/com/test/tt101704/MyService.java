package com.test.tt101704;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import java.util.Date;

public class MyService extends Service {
    private Handler handler = new Handler();
    int i = 10;
    public Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.i("mylog", new Date().toString());
            handler.postDelayed(this, 1000);
            i--;
            Log.i("mylog", "i=" + i);

        }
    };

    public MyService() {
        Log.d("SERVICE", "constructor");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // hrow new UnsupportedOperationException("Not yet implemented");
        Log.d("SERVICE", "onBind");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("mylog", "onStartCommand()");
        handler.post(showTime);
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i("mylog", "onDestroy()");
        handler.removeCallbacks(showTime);
        super.onDestroy();
    }
}
