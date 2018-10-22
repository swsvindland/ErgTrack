package com.svindland.sam.ergtrack;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences userData = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        boolean userExists = userData.getBoolean("Exists", false);

        if(userExists) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(this, CreateUser.class);
            startActivity(i);
        }


    }
}
