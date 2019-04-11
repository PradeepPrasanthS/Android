package com.example.temperaturecricket;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    EditText etxt;
    Button button;
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        etxt = findViewById(R.id.etxt);
        button = findViewById(R.id.button);
        txt2 = findViewById(R.id.txt2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cricketChirps = etxt.getId();

                int answer = (cricketChirps/3) +4;

                String text = "The appropriate tempertaure outside is " +
                                answer + "degrees Celcius.";

}
