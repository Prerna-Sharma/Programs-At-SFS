package com.example.student.listviewfiles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.student.androidprograms.R;

import java.util.ArrayList;

public class CustomizedListViewActivity extends AppCompatActivity {
    private ListItemsActivity listItemsActivity;
    private ArrayList<ListItemsActivity> employeesArrayList = new ArrayList<>();
    private MyListViewAdapter myListViewAdapter;
    private ListView listView;
    private int[] image = {R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image};
    private String[] name = {"A", "B", "C", "D"};
    private String[] age = {"25", "28", "27", "26"};
    private String[] profile = {"Android Developer", "Java Developer", "Android Developer", "PHP Developer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_list_view);

        //findViewById()
        listView = (ListView) findViewById(R.id.employees_list_view);

        //adding details of employees in array list
        for (int i = 0; i < name.length; i++) {
            listItemsActivity = new ListItemsActivity(image[i], name[i], age[i], profile[i]);
            employeesArrayList.add(listItemsActivity);
        }

        myListViewAdapter = new MyListViewAdapter(this, employeesArrayList);
        listView.setAdapter(myListViewAdapter);
    }
}
