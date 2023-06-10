package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView textview,textview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textview = findViewById(R.id.hi_user);

        Intent intent = getIntent();
        String profsapa ="hi" + intent.getStringExtra(Login.Global_user);

        textview.setText(profsapa);

        textview2 = findViewById(R.id.glob_email);

        Intent intent2 = getIntent();
        String globmail =intent.getStringExtra(Login.Global_user) + "@gmail.com" ;

        textview2.setText(globmail);


    }
}