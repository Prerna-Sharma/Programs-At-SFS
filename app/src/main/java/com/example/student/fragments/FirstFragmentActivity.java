package com.example.student.fragments;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.androidprograms.R;

public class FirstFragmentActivity extends Fragment {
    private TextView textview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_first_fragment, container, false);
        textview = (TextView) view.findViewById(R.id.first_fragment_textview);
        return view;
    }

    //get number of button clicks and set that text on textview
    public void getData(String Data) {
        textview.setText(Data);
    }
}
