package com.example.student.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.student.androidprograms.R;

public class FragmentsHoldingActivity extends AppCompatActivity implements Communicator {
    private SecondFragmentActivity secondFragmentActivity;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FirstFragmentActivity firstFragmentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holding_fragments);

        // adding activity_second_fragment in activity_holding_fragment.xml, and
        // R.id.second_activity is a layout defined in your
        secondFragmentActivity = new SecondFragmentActivity();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.second_fragment,secondFragmentActivity);
        fragmentTransaction.commit();

        // replacing one fragment by another
        fragment = new ThirdFragmentActivity();
        fragmentTransaction.replace(R.id.second_fragment,fragment);
        fragmentTransaction.commit();
    }

    //overridden method of communicator interface
    @Override
    public void response() {
        //
        firstFragmentActivity = (FirstFragmentActivity) getSupportFragmentManager().findFragmentById(R.id.first_fragment);
//        firstFragmentActivity.getData(data);

    }
}
