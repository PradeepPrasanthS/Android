package com.example.vectorassets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView set;
    Button  change;
    ImageView set2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set = findViewById(R.id.set);
        change =findViewById(R.id.change);
        set2 = findViewById(R.id.set2);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                set.setImageResource(R.drawable.headset);

            }
        });
        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
