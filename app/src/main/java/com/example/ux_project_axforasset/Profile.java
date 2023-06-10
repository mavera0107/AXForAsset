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

<<<<<<< HEAD
        textview.setText("Hi " + GLOBAL_USERNAME);
=======
        Intent intent = getIntent();
        String profsapa ="hi  !  " + Login.getGlobalUser();
>>>>>>> 6c54b33 (kelar)


        textview2 = findViewById(R.id.glob_email);

<<<<<<< HEAD
        textview2.setText(GLOBAL_USERNAME + "@email.com");
=======
        Intent intent2 = getIntent();
        String globmail =Login.getGlobalUser() + "@gmail.com" ;

        textview2.setText(globmail);
>>>>>>> 6c54b33 (kelar)


    }
}