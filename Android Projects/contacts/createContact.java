package com.example.contacts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class createContact extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etNumber, etWebsite, etLocation;
    ImageView goodmood, badmood, neutralmood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etLocation = findViewById(R.id.etLocation);
        etWebsite = findViewById(R.id.etWebsite);

        goodmood = findViewById(R.id.goodmood);
        badmood = findViewById(R.id.badmood);
        neutralmood = findViewById(R.id.neutralmood);

        goodmood.setOnClickListener(this);
        badmood.setOnClickListener(this);
        neutralmood.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(etName.getText().toString().isEmpty()||etNumber.getText().toString().isEmpty()
                ||etLocation.getText().toString().isEmpty()||etWebsite.getText().toString().isEmpty()){
            Toast.makeText(createContact.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }

        else{

            Intent intent = new Intent();
            intent.putExtra("name",etName.getText().toString().trim());
            intent.putExtra("number",etNumber.getText().toString().trim());
            intent.putExtra("location",etLocation.getText().toString().trim());
            intent.putExtra("website",etWebsite.getText().toString().trim());

            if(v.getId() == R.id.goodmood){
                intent.putExtra("mood","happy");
            }
            else if(v.getId() == R.id.neutralmood){
                intent.putExtra("mood","neutral");
            }
            else if(v.getId() == R.id.badmood){
                intent.putExtra("mood","bad");
            }
            setResult(RESULT_OK,intent);
            createContact.this.finish();
        }


    }
}
