package com.example.student.splashloginandregistrationactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.androidprograms.R;
import com.example.student.parcelabledatafiles.MyParcelable;
import com.example.student.parcelabledatafiles.ShowParcelableDataActivity;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge, editTextCourse;
    private Button submitButton, cancelButton;
    private MyParcelable myParcelable;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        //find views by ID
        editTextName = (EditText) findViewById(R.id.registration_edittext_name);
        editTextAge = (EditText) findViewById(R.id.registration_edittext_age);
        editTextCourse = (EditText) findViewById(R.id.registration_edittext_course);
        submitButton = (Button) findViewById(R.id.registration_button_submit);
        cancelButton = (Button) findViewById(R.id.registration_button_cancel);

        //on click of submit button, data from the 3 edit texts will get stored in the object of MyParcelable class
        // and then will be send through intent to another activity
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myParcelable = new MyParcelable(editTextName.getText().toString(), editTextAge.getText().toString(), editTextCourse.getText().toString());
                intent = new Intent(RegistrationActivity.this, ShowParcelableDataActivity.class);
                intent.putExtra("userdata", myParcelable);
                startActivity(intent);
            }
        });

        //on click of cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
