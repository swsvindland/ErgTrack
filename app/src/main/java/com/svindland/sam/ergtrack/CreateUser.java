package com.svindland.sam.ergtrack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.app.PendingIntent.getActivity;

public class CreateUser extends AppCompatActivity {
    public User user;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        db = openOrCreateDatabase("FeedReader.db", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE 'ErgPiece' (date, interval, time, distance, split, watts, cals, stroke_rate, heart_rate);");
    }


    public void nextButton(View view) {
        EditText eFirstName = (EditText)findViewById(R.id.firstName);
        EditText eLastName = (EditText)findViewById(R.id.lastName);
        EditText eAge = (EditText)findViewById(R.id.age);
        EditText eHeightFeet = (EditText)findViewById(R.id.heightFeet);
        EditText eHeightInch = (EditText)findViewById(R.id.heightInch);
        EditText eWeight = (EditText)findViewById(R.id.weight);

        try{
            String firstName = eFirstName.getText().toString();
            String lastName = eLastName.getText().toString();
            int age = Integer.parseInt(eAge.getText().toString());
            int heightFeet = Integer.parseInt(eHeightFeet.getText().toString());
            int heightInch = Integer.parseInt(eHeightInch.getText().toString());
            int weight = Integer.parseInt(eWeight.getText().toString());

            user = new User(firstName, lastName, age, heightFeet, heightInch, weight);

            SharedPreferences.Editor userData = getSharedPreferences("UserData", Context.MODE_PRIVATE).edit();

            userData.putBoolean("Exists", true).apply();
            userData.putString("First Name", firstName).apply();
            userData.putString("Last Name", lastName).apply();
            userData.putInt("Age", age).apply();
            userData.putInt("Height Feet", heightFeet).apply();
            userData.putInt("Height Inch", heightInch).apply();
            userData.putInt("Weight", weight).apply();


            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        catch (NumberFormatException e) {

        }

    }

}
