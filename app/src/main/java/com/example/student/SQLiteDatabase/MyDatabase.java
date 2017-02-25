package com.example.student.SQLiteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabase extends SQLiteOpenHelper{
    Context context;

    //Define the schema
    public static final String DATABASE_NAME = "employee.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "EMPLOYEE";
    public static final String UID = "_id";
    public static final String NAME = "Name";
    public static final String PASSWORD = "Password";

    //Table creation and deletion query
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + PASSWORD + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME +"";

    //Constructor
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        Toast.makeText(context,"Constructor called",Toast.LENGTH_SHORT).show();
    }

    //on table creation
    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(context,"onCreate() called",Toast.LENGTH_SHORT).show();
        db.execSQL(CREATE_TABLE);
    }

    //on table deletion
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context,"onDrop() called",Toast.LENGTH_SHORT).show();
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
