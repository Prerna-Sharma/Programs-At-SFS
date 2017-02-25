package com.example.student.listviewfiles;

import android.support.v7.app.AppCompatActivity;

public class ListItemsActivity  extends AppCompatActivity{
    private int employeeImage;
    private String employeeName, employeeAge, employeeProfile;

//Parametrized Constructor
    public ListItemsActivity(int image, String name, String age, String profile) {
        employeeImage = image;
        employeeName = name;
        employeeAge = age;
        employeeProfile = profile;
    }

//Getter methods
    public String getEmployeeAge() {
        return employeeAge;
    }

    public String getEmployeeProfile() {
        return employeeProfile;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeImage() {
        return employeeImage;
    }
}
