package com.example.student.broadcastreceiverprograms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.student.androidprograms.R;

public class BroadcastingActivity extends AppCompatActivity {
    private Button broadcastingButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcasting);

        //find view by ID
        broadcastingButton = (Button) findViewById(R.id.broadcasting_button);
        broadcastingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction("custombroadcast");
                sendBroadcast(intent);
            }
        });
    }
}
