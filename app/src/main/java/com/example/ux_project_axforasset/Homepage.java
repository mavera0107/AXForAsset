package com.example.ux_project_axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.TimerTask;
import java.util.Vector;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private Vector<Integer> listImage;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.home_menu).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.home_menu);



        viewPager = findViewById(R.id.mainViewPager);
        listImage = new Vector<>();
        listImage.add(R.drawable.carousel1);
        listImage.add(R.drawable.carousel2);
        listImage.add(R.drawable.carousel3);

        ItemSliderAdapter adapter = new ItemSliderAdapter(listImage, this);
        viewPager.setAdapter(adapter);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);
    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            Homepage.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()< listImage.size()-1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else
                        viewPager.setCurrentItem(0);
                }
            });
        }
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

        if(item.getItemId() == R.id.items_menu){
            Intent intent = new Intent(Homepage.this, ItemPage.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.profile_menu) {
            Intent intent = new Intent(Homepage.this, Profile.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.logout_menu) {
            Intent intent = new Intent(Homepage.this, Login.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }
}