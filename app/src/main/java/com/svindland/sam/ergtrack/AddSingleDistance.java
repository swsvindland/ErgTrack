package com.svindland.sam.ergtrack;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSingleDistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_single_distance);
    }

    public void saveSingleDistance(View view) {
        try{
            EditText time = (EditText)findViewById(R.id.sdtime);
            EditText distance = (EditText)findViewById(R.id.sddistance);
            EditText split = (EditText)findViewById(R.id.sdsplit);
            EditText watts = (EditText)findViewById(R.id.sdwatts);
            EditText cals = (EditText)findViewById(R.id.sdcals);
            EditText strokeRate = (EditText)findViewById(R.id.sdstrokeRate);
            EditText heartRate = (EditText)findViewById(R.id.sdheartRate);

            String convertTime = time.getText().toString();
            int convertDistance = Integer.parseInt(distance.getText().toString());
            String convertSplit = split.getText().toString();
            int convertWatts = Integer.parseInt(watts.getText().toString());
            int convertCals = Integer.parseInt(cals.getText().toString());
            int convertStrokeRate = Integer.parseInt(strokeRate.getText().toString());
            int convertHeartRate = Integer.parseInt(heartRate.getText().toString());

            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date();
            String todayDate = dateFormat.format(date);

            SQLiteDatabase db = openOrCreateDatabase("FeedReader.db", MODE_PRIVATE, null);

            ContentValues values = new ContentValues();

            values.put("date", todayDate);
            values.put("interval", 1);
            values.put("time", convertTime);
            values.put("distance", convertDistance);
            values.put("split", convertSplit);
            values.put("watts", convertWatts);
            values.put("cals", convertCals);
            values.put("stroke_rate", convertStrokeRate);
            values.put("heart_rate", convertHeartRate);

            db.insert("ErgPiece", null, values);
            db.setVersion(2);
            db.close();


            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        catch (NumberFormatException e) {

        }

    }
}
