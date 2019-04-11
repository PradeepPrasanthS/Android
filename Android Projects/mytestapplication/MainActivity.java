package com.example.mytestapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Life Cycle Event","In on create");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Life Cycle Event","In on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Life Cycle Event","In on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Life Cycle Event","In on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Life Cycle Event","In on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Life Cycle Event","In on destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Life Cycle Event","In on restart");
    }
}
