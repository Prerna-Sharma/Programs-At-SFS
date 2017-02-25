package com.example.student.myapplication;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.student.androidprograms.R;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative_layout);
        //setContentView(R.layout.activity_scrollview);
        //setContentView(R.layout.activity_tablelayout);
/*
        //Adding Buttons
        Button mybutton = new Button(this);
        mybutton.setText("click");
        mybutton.setBackgroundColor(Color.BLUE);
        //mybutton.setId(R.id.mybuttonid);

        //Add Relative Layout
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setBackgroundColor(Color.RED);
        relativelayout.addView(mybutton);
        setContentView(relativelayout);*/

    }
}
