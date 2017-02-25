package com.example.student.storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student.androidprograms.R;
import com.example.student.myapplication.MainActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStorageActivity extends AppCompatActivity {
    private EditText edtName, edtPassword;
    private Button btnSaveInternal, btnSaveCache, btnNext;
    private String fileName;
    private FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);

        //findViewByID
        edtName = (EditText) findViewById(R.id.data_storage_edtxt_name);
        edtPassword = (EditText) findViewById(R.id.data_storage_edtxt_password);
        btnSaveInternal = (Button) findViewById(R.id.data_storage_btn_save_internal);
        btnSaveCache = (Button) findViewById(R.id.data_storage_btn_save_cache);
        btnNext = (Button) findViewById(R.id.data_storage_btn_next);

        //On click listener for "Save on Internal Memory" button
        btnSaveInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create a new file
                fileName = "MyFile.txt";
                try {
                    //call openFileOutput() to get a FileOutputStream that writes to a file in your internal directory
                    fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

                    //write name and password to the file
                    fileOutputStream.write((edtName.getText().toString() + " ").getBytes());
                    fileOutputStream.write((edtPassword.getText().toString()).getBytes());

                    //close fileOutputStream
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //getFilesDir() returns a File representing an internal directory for your app.
        Toast.makeText(this, "Data stored in " + getFilesDir() + "/" + fileName, Toast.LENGTH_LONG).show();


        //On click listener for "Save data on Cache" button
        btnSaveCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName = "MyCache";

                //To create a new file in one of these directories, you can use the File() constructor,
                // passing the File provided by one of the above methods that specifies your internal storage directory
                File file = new File(getCacheDir(), fileName);

                try {
                    //use getCacheDir() to open a File that represents the internal directory where your application should save temporary cache files.
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write((edtName.getText().toString()).getBytes());
                    fileOutputStream.write((edtPassword.getText().toString()).getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //getCacheDir() returns a File representing an internal directory for your app's temporary cache files.
        Toast.makeText(this, "Data stored in " + getCacheDir() + "/" + fileName, Toast.LENGTH_LONG).show();
    }
}