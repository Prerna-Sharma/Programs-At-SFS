package com.example.student.parcelabledatafiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student.androidprograms.R;

public class ShowParcelableDataActivity extends AppCompatActivity {
    private MyParcelable myParcelable;
    private TextView nameTextView, ageTextView, courseTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_parcelable_data);

        nameTextView= (TextView) findViewById(R.id.name_textview);
        ageTextView= (TextView) findViewById(R.id.age_textview);
        courseTextView = (TextView) findViewById(R.id.course_textview);

        //get user data from myParcelable and show it in 3 Text Views
        myParcelable = getIntent().getParcelableExtra("userdata");
        nameTextView.setText(myParcelable.name);
        ageTextView.setText(myParcelable.age);
        courseTextView.setText(myParcelable.course);

        // show parcelable data in toast
        Toast.makeText(ShowParcelableDataActivity.this,myParcelable.name+ " "+ myParcelable.age+ " "+ myParcelable.course, Toast.LENGTH_LONG ).show();
    }
}
