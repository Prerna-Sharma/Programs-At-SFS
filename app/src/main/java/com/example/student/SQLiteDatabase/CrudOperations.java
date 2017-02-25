package com.example.student.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student.androidprograms.R;

public class CrudOperations extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName, edtPassword;
    private Button btnAdd, btnView, btnDelete, btnUpdate;
    private SQLiteDatabase sqLiteDatabase;
    private MyDatabase myDatabase;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_operations);

        //findViewByID
        edtName = (EditText) findViewById(R.id.crud_activity_edtxt_name);
        edtPassword = (EditText) findViewById(R.id.crud_activity_edtxt_password);
        btnAdd = (Button) findViewById(R.id.crud_activity_btn_add);
        btnView = (Button) findViewById(R.id.crud_activity_btn_view);
        btnDelete = (Button) findViewById(R.id.crud_activity_btn_delete);
        btnUpdate = (Button) findViewById(R.id.crud_activity_btn_update);

        myDatabase = new MyDatabase(this);


        //Registering
        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //Add operation
            case R.id.crud_activity_btn_add:
                //Get database in writable form
                sqLiteDatabase = myDatabase.getWritableDatabase();

                // Use ContentValues to store data in columns
                // ContentValues is a name value pair, used to insert or update values in database tables.
                ContentValues contentValues = new ContentValues();
                contentValues.put(MyDatabase.NAME,edtName.getText().toString().trim());
                contentValues.put(MyDatabase.PASSWORD,edtPassword.getText().toString());

                // Inserting values in table.
                // Object of contentValues will be passed to SQLiteDataBase objects insert() function.
                // It returns row ID of newly inserted row, or -1
                long id = sqLiteDatabase.insert(MyDatabase.TABLE_NAME,null,contentValues);
                if(id>0)
                    Toast.makeText(CrudOperations.this,"Data saved",Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(CrudOperations.this, "Data is not saved", Toast.LENGTH_SHORT).show();
                    edtName.setText("");
                    edtPassword.setText("");
                }
                break;

            //View operation
            case R.id.crud_activity_btn_view:
                sqLiteDatabase = myDatabase.getReadableDatabase();
                String[] column = {MyDatabase.UID,MyDatabase.NAME,MyDatabase.PASSWORD};

                Cursor cursor = sqLiteDatabase.query(MyDatabase.TABLE_NAME,column,null,null,null,null,null);

                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    int uid = cursor.getInt(cursor.getColumnIndex(MyDatabase.UID));
                    String name = cursor.getString(cursor.getColumnIndex(MyDatabase.NAME));
                    String password = cursor.getString(cursor.getColumnIndex(MyDatabase.PASSWORD));

                    buffer.append("UserID = " + uid + " Name= " + name + " Password = " + password + "\n");
                }//end of while

                Toast.makeText(CrudOperations.this,buffer.toString(),Toast.LENGTH_SHORT).show();
                break;

            //Delete operation
            case R.id.crud_activity_btn_delete:
                sqLiteDatabase = myDatabase.getWritableDatabase();

                String whereClause = MyDatabase.NAME + "=?";
                String[] whereArgs = {"Raj"};
                int deletedRows = sqLiteDatabase.delete(MyDatabase.TABLE_NAME, whereClause, whereArgs);

                Toast.makeText(CrudOperations.this,"No. of deleted rows: " + deletedRows,Toast.LENGTH_SHORT).show();
                break;

            //Update operation
            case R.id.crud_activity_btn_update:
                sqLiteDatabase = myDatabase.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(MyDatabase.NAME,"Ram");

                String whereClause1 = MyDatabase.NAME + "=?";
                String[] whereArgs1 = {"Ravi"};

                int updatedRows = sqLiteDatabase.update(MyDatabase.TABLE_NAME, values,whereClause1,whereArgs1);

                Toast.makeText(CrudOperations.this,"No. of rows updated: " + updatedRows,Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
