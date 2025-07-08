package com.example.crescentdbapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextId, editTextName;
    MyDbHelper myDbHelper;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDbHelper = new MyDbHelper(this, "employee.db", null, 1);

        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        textView = findViewById(R.id.textViewResult);
    }

    public void insertData(View view) {
        int id = Integer.parseInt(editTextId.getText().toString());
        String name = editTextName.getText().toString();
        myDbHelper.insertToTable(id, name);
    }

    public void viewData(View view) {
        String result = myDbHelper.viewData();
        textView.setText(result);
    }
}
