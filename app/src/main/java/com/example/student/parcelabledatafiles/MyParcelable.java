package com.example.student.parcelabledatafiles;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyParcelable  implements Parcelable {
    String name, age, course;

    public MyParcelable(String name, String age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
        Log.d("hh",name);
    }

    protected MyParcelable(Parcel in) {
        name = in.readString();
        age = in.readString();
        course = in.readString();
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(age);
        parcel.writeString(course);
    }
}