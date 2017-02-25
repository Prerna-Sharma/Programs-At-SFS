package com.example.student.navigationdrawerfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.student.androidprograms.R;

import java.util.ArrayList;

public class NavigationDrawerActivity extends AppCompatActivity {
    private ListView drawerList;
    private ArrayList<NavigationDrawerItems> navItemsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_navigation_drawer);
    }
}
