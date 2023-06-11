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
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class ConditionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    String GLOBAL_USERNAME;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public void initialize() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);
        initialize();

        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        navigationView.setNavigationItemSelectedListener(this);

//        navigationView.setCheckedItem(R.id.items_menu);

        navBarTnC();
    }

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

        if(item.getItemId() == R.id.home_menu){
            Intent intent = new Intent(ConditionActivity.this, HomepageActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if(item.getItemId() == R.id.items_menu) {
            Intent intent = new Intent(ConditionActivity.this, ItemActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.profile_menu) {
            Intent intent = new Intent(ConditionActivity.this, ProfileActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.logout_menu) {
            Intent intent = new Intent(ConditionActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }

    public void navBarTnC() {
        TextView tab1 = findViewById(R.id.tab1);
        TextView tab2 = findViewById(R.id.tab2);
        String GLOBAL_USERNAME;
        Intent intent;
        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(ConditionActivity.this, TermsActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(ConditionActivity.this, ConditionActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });
    }
}