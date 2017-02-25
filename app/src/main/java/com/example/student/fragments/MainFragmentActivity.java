package com.example.student.fragments;

import android.support.annotation.Nullable;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.student.androidprograms.R;

public class MainFragmentActivity extends Fragment {
    private int counter;
    private Communicator communicator;
    private Button buttonFirstFragment, buttonSecondFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_fragment, container, false);
        buttonFirstFragment = (Button) view.findViewById(R.id.btn_first_fragment);
        buttonSecondFragment = (Button) view.findViewById(R.id.btn_second_fragment);

        buttonFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                counter++;
                communicator = (Communicator)getActivity();
                communicator.response();
//                communicator.response("Button is clicked " + counter +" times");
            }
        });

        buttonSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                communicator = (Communicator)getActivity();
                communicator.response();
            }
        });
        return view;
    }
}
