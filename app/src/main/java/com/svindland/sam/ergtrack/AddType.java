package com.svindland.sam.ergtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type);
    }

    public void singleDistance(View view) {
        Intent i = new Intent(this, AddSingleDistance.class);
        startActivity(i);
    }

    public void singleTime(View view) {
        //Intent i = new Intent(this, AddSingle.class);
        //startActivity(i);
    }

    public void singleCalorie(View view) {
        //Intent i = new Intent(this, AddSingle.class);
        //startActivity(i);
    }

    public void intervalDistance(View view) {
        Intent i = new Intent(this, AddIntervalDistance.class);
        startActivity(i);
    }

    public void intervalTime(View view) {
        Intent i = new Intent(this, AddIntervalTime.class);
        startActivity(i);
    }
}
