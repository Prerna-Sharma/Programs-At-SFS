package com.example.student.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.student.androidprograms.R;

import java.io.BufferedReader;
import java.io.File;

public class DataRetrieveActivity extends AppCompatActivity {
    private TextView txtName, txtPassword;
    private Button btnReadInternal, btnReadCache;
    private File file;
    private BufferedReader bufferedReader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retrieve);

        //find view by ID
        txtName = (TextView) findViewById(R.id.data_retrieve_textview_name);
        txtPassword = (TextView) findViewById(R.id.data_retrieve_textview_password);
        btnReadCache = (Button) findViewById(R.id.data_retrieve_btn_read_cache);
        btnReadInternal = (Button) findViewById(R.id.data_retrieve_btn_read_internal_storage);

        //onClickListener for readInternal button
        btnReadInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                file = new File(getCacheDir(),"MyCache");


            }
        });
    }
}
