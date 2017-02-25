package com.example.student.androidprograms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.data;

public class showDataFromNextActivity extends AppCompatActivity {
    private Button btnNext;
    private Intent intent;
    private String getData;
    private TextView txtviewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_from_next);

        //find view by ID
        btnNext = (Button) findViewById(R.id.activity_show_data_from_next_button);
        txtviewData = (TextView) findViewById(R.id.activity_show_data_from_next_textview);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(showDataFromNextActivity.this, ImplicitIntentActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == 1) && (resultCode == ImplicitIntentActivity.RESULT_OK)) {
            getData = data.getExtras().getString("data");
            txtviewData.setText(getData);
        }
    }
}
