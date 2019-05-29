package com.example.recyclerviewwithfragments;

import android.app.Application;
import android.content.ContentProvider;
import android.os.Build;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("Pradeep","8903716126"));
        people.add(new Person("Mukesh","9800361612"));
        people.add(new Person("Subhas","8003716126"));
    }
}
