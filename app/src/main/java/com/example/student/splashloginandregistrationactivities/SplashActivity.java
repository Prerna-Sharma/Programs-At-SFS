package com.example.student.splashloginandregistrationactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.student.SQLiteDatabase.CrudOperations;
import com.example.student.Threadsandhandler.MyThreadHandlerActivity;
import com.example.student.androidprograms.ImplicitIntentActivity;
import com.example.student.androidprograms.R;
import com.example.student.androidprograms.showDataFromNextActivity;
import com.example.student.broadcastreceiverprograms.BroadcastingActivity;
import com.example.student.fragments.FragmentsHoldingActivity;
import com.example.student.fragmentsintablayout.TabbedFragmentsActivity;
import com.example.student.storage.DataStorageActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(SplashActivity.this,CrudOperations.class));
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
