package com.svindland.sam.ergtrack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private User user;

    static ArrayList<Piece> arrayList = new ArrayList<Piece>();
    static ArrayList<String> debug = new ArrayList<>();


    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUser();

        wod();

        db = openOrCreateDatabase("FeedReader.db", MODE_PRIVATE, null);

        if(db.getVersion() > 1)
            update();
    }


    public void update() {
        arrayList.clear();

        Cursor result = db.rawQuery("SELECT * from 'ErgPiece'", null);

        while(result.moveToNext()) {
            String date = result.getString(0);
            int interval = result.getInt(1);
            String time = result.getString(2);
            int distance = result.getInt(3);
            String split = result.getString(4);
            int watts = result.getInt(5);
            int cals = result.getInt(6);
            int strokeRate = result.getInt(7);
            int heartRate = result.getInt(8);

            Piece piece = new Piece(interval,time, distance, split, watts, cals, strokeRate, heartRate);
            arrayList.add(0, piece);

        }
        result.close();


        CustomAdapter adapter = new CustomAdapter(this, arrayList,
                R.layout.activity_listview);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    public void wod() {
        TextView textView = (TextView)findViewById(R.id.workout);
        WorkoutList workoutList = new WorkoutList();

        Calendar c = Calendar.getInstance();
        int index = c.get(Calendar.DAY_OF_WEEK);

        if(index == 1)
            textView.setText("Rest");
        else
            textView.setText(workoutList.getList().get(index - 2).toString());

    }

    public void add(View view) {
        Intent i = new Intent(this, AddType.class);
        startActivity(i);
    }

    public void setUser() {
        SharedPreferences userData = getSharedPreferences("UserData", Context.MODE_PRIVATE);

        String firstName = userData.getString("First Name", "John");
        String lastName = userData.getString("Last Name", "Doe");
        int age = userData.getInt("Age", 0);
        int heightFeet = userData.getInt("Height Feet", 0);
        int heightInch = userData.getInt("Height Inch", 0);
        int weight = userData.getInt("Weight", 0);

        user = new User(firstName, lastName, age, heightFeet, heightInch, weight);
    }

    public User getUser() {
        return user;
    }



}