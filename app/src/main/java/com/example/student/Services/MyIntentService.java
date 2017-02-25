package com.example.student.Services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
    public static final String TAG = "INTENT SERVICE";

    public MyIntentService() {
        super("My Intent Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent executed");

        //Creating a new Thread
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    long endTime = System.currentTimeMillis() + 5 * 1000;

                    //
                    while (System.currentTimeMillis() < endTime) {
                        synchronized (this) {
                            try {
                                wait(endTime - System.currentTimeMillis());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }//end of while()
                }//end of for loop
                stopSelf();
                Log.d(TAG,"Destroyed");
            }
        };//end of Runnable
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
