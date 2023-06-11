package com.example.ux_project_axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    TextView textview,textview2;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //TEST GLOBVAR
    String GLOBAL_USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        //MENUBAR
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.profile_menu).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.profile_menu);


        //SET USERNAME & EMAIL
        textview = findViewById(R.id.hi_user);

<<<<<<< HEAD
<<<<<<< HEAD
        textview.setText("Hi " + GLOBAL_USERNAME);
=======
        Intent intent = getIntent();
        String profsapa ="hi  !  " + Login.getGlobalUser();
>>>>>>> 6c54b33 (kelar)
=======
        textview.setText("Hi, " + GLOBAL_USERNAME);
>>>>>>> 64d2e69 (meki)


        textview2 = findViewById(R.id.glob_email);

<<<<<<< HEAD
<<<<<<< HEAD
        textview2.setText(GLOBAL_USERNAME + "@email.com");
=======
        Intent intent2 = getIntent();
        String globmail =Login.getGlobalUser() + "@gmail.com" ;

        textview2.setText(globmail);
>>>>>>> 6c54b33 (kelar)
=======
        textview2.setText(GLOBAL_USERNAME + "@gmail.com");
>>>>>>> 64d2e69 (meki)


    }

    //MENU BAR
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.items_menu){
            Intent intent = new Intent(Profile.this, ItemPage.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.home_menu) {
            Intent intent = new Intent(Profile.this, Homepage.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.logout_menu) {
            Intent intent = new Intent(Profile.this, Login.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }
}