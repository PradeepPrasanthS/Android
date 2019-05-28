package com.example.framents;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements List.Itemselected {

    TextView tvDesc;
    String[] desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDesc = findViewById(R.id.tvDesc);

        desc = getResources().getStringArray(R.array.descriptions);

        if(findViewById(R.id.layout_portrait)!=null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        if(findViewById(R.id.layout_land)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(int index) {
        tvDesc.setText(desc[index]);

        if(findViewById(R.id.layout_portrait)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
