package com.example.student.listviewfiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.androidprograms.R;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ListItemsActivity> listItemsArrayList;

    //Parametrized Constructor
    public MyListViewAdapter(Context context, ArrayList<ListItemsActivity> listItemsArrayList) {
        this.context = context;
        this.listItemsArrayList = listItemsArrayList;
    }

    @Override
    public int getCount() {
        return listItemsArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return listItemsArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_list_items, viewGroup, false);

        //findViewById
        ImageView imageView = (ImageView) view.findViewById(R.id.employee_image);
        TextView name = (TextView) view.findViewById(R.id.employee_name);
        TextView age = (TextView) view.findViewById(R.id.employee_age);
        TextView profile = (TextView) view.findViewById(R.id.employee_profile);

        //get data from
        ListItemsActivity listItemsActivity = listItemsArrayList.get(i);

        //set particular data  in each row
        imageView.setImageResource(listItemsActivity.getEmployeeImage());
        name.setText(listItemsActivity.getEmployeeName());
        age.setText(listItemsActivity.getEmployeeAge());
        profile.setText(listItemsActivity.getEmployeeProfile());

        return view;
    }
}
