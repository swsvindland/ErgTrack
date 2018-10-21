package com.samsvindland.ergtrack;

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

public class AddIntervalDistance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_interval_distance);
    }

    public void saveIntervalDistance(View view) {
        try{
            EditText interval = (EditText)findViewById(R.id.idinterval);
            EditText time = (EditText)findViewById(R.id.idtime);
            EditText distance = (EditText)findViewById(R.id.iddistance);
            EditText split = (EditText)findViewById(R.id.idsplit);
            EditText watts = (EditText)findViewById(R.id.idwatts);
            EditText cals = (EditText)findViewById(R.id.idcals);
            EditText strokeRate = (EditText)findViewById(R.id.idstrokeRate);
            EditText heartRate = (EditText)findViewById(R.id.idheartRate);

            int convertInterval = Integer.parseInt(interval.getText().toString());
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
            values.put("interval", convertInterval);
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
