package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView textview,textview2;

    //TEST GLOBVAR
    String GLOBAL_USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        textview = findViewById(R.id.hi_user);

        textview.setText("Hi " + GLOBAL_USERNAME);


        textview2 = findViewById(R.id.glob_email);

        textview2.setText(GLOBAL_USERNAME + "@email.com");


    }
}