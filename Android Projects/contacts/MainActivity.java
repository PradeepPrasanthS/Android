package com.example.contacts;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView contacts;
    Button newContact;
    ImageView call,website,location,profile;
    private int code = 3;
    String name = "", number = "", map = "", web = "", mood = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = findViewById(R.id.contacts);
        newContact = findViewById(R.id.newContact);
        call = findViewById(R.id.call);
        website = findViewById(R.id.website);
        location = findViewById(R.id.location);
        profile = findViewById(R.id.profile);

        call.setVisibility(View.GONE);
        website.setVisibility(View.GONE);
        location.setVisibility(View.GONE);
        profile.setVisibility(View.GONE);

        newContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,
                        com.example.contacts.createContact.class);
                startActivityForResult(intent,code);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == code){
            if(resultCode == RESULT_OK){

                call.setVisibility(View.VISIBLE);
                website.setVisibility(View.VISIBLE);
                location.setVisibility(View.VISIBLE);
                profile.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("website");
                map = data.getStringExtra("location");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy")){
                    profile.setImageResource(R.drawable.goodmood);
                }

                else if(mood.equals("neutral")){
                    profile.setImageResource(R.drawable.neutralmood);
                }

                else if(mood.equals("bad")){
                    profile.setImageResource(R.drawable.badmood);
                }

                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:" + number));
                        startActivity(intent);
                    }
                });

                website.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://" + web));
                                startActivity(intent);
                    }
                });

                location.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=" + map));
                        startActivity(intent);
                    }
                });

            }

            else{
                Toast.makeText(this, "No data Passed through!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
