package com.example.textinputlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView etFirst;
    AutoCompleteTextView etLast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirst = findViewById(R.id.etFirst);
        etLast = findViewById(R.id.etLast);

        String [] names = {"Pradeep","Dhana","Jennifer","Mukesh","Kavitha"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.custom_design_autocomplete,names);

        etFirst.setThreshold(1);
        etFirst.setAdapter(adapter);
        etLast.setThreshold(1);
        etLast.setAdapter(adapter);
    }


}
