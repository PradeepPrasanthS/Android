package com.example.recyclerviewwithfragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnClicked {

    TextView tvName,tvPhone;
    EditText edtName,etPhone;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        edtName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etNumber);
        btnAdd = findViewById(R.id.btnAdd);
        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().isEmpty()||etPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    ApplicationClass.people.add(new Person(edtName.getText().toString().trim(),etPhone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this,"Person added successfully", Toast.LENGTH_SHORT).show();
                    edtName.setText(null);
                    etPhone.setText(null);
                    listFrag.notifyDataChanged();
                }
            }
        });

        if(findViewById(R.id.layout_portrait)!=null){

            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listFrag))
                    .hide(fragmentManager.findFragmentById(R.id.detailFrag))
                    .hide(fragmentManager.findFragmentById(R.id.addPersonFrag))
                    .commit();
        }

        if(findViewById(R.id.layout_land)!=null){

            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.detailFrag))
                    .show(fragmentManager.findFragmentById(R.id.listFrag))
                    .show(fragmentManager.findFragmentById(R.id.addPersonFrag))
                    .commit();
            itemClicked(0);
        }

    }

    @Override
    public void itemClicked(int index) {

        tvName.setText(ApplicationClass.people.get(index).getName());
        tvPhone.setText(ApplicationClass.people.get(index).getPhone());

        if(findViewById(R.id.layout_portrait)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.addPersonFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
