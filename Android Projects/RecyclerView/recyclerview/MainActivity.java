package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClick {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

//        layoutManager = new LinearLayoutManager(this);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        layoutManager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Subhas","Raj","plane"));
                myAdapter.notifyDataSetChanged();
            }
        });

        people = new ArrayList<Person>();
        people.add(new Person("John","Rombo","bus"));
        people.add(new Person("Pradeep","Prasanth","plane"));
        people.add(new Person("Dhana","Prasanthi","plane"));
        people.add(new Person("Mukesh","Sivakumar","bus"));
        people.add(new Person("John","Rombo","bus"));
        people.add(new Person("Pradeep","Prasanth","plane"));
        people.add(new Person("Dhana","Prasanthi","plane"));
        people.add(new Person("Mukesh","Sivakumar","bus"));
        people.add(new Person("John","Rombo","bus"));
        people.add(new Person("Pradeep","Prasanth","plane"));
        people.add(new Person("Dhana","Prasanthi","plane"));
        people.add(new Person("Mukesh","Sivakumar","bus"));
        people.add(new Person("John","Rombo","bus"));
        people.add(new Person("Pradeep","Prasanth","plane"));
        people.add(new Person("Dhana","Prasanthi","plane"));
        people.add(new Person("Mukesh","Sivakumar","bus"));

        myAdapter = new PersonAdapter(MainActivity.this,people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(MainActivity.this,"Surname: "+people.get(index).getSurName(), Toast.LENGTH_SHORT).show();
    }
}
