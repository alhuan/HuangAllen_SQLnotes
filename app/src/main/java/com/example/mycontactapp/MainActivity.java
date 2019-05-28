package com.example.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    EditText editNumber;
    EditText editAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MyContactApp", "MainActivity: setting up the layout");
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editText_Name);
        editNumber = findViewById(R.id.editText_Number);
        editAddress = findViewById(R.id.editText_Address);

        myDb = new DatabaseHelper( this);
        Log.d("MyContactApp", "Main activity: Instantiated Database Helper");
    }

    public void addData(View view) {

        boolean isInserted = myDb.insertData(editName.getText().toString(), editNumber.getText().toString(),
            editAddress.getText().toString());

        if (isInserted) {
            Toast.makeText(MainActivity.this, "Success - contact inserted", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "FAILED - contact not inserted", Toast.LENGTH_LONG).show();
        }
    }
}
