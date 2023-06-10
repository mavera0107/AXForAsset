package com.example.ux_project_axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.TimerTask;
import java.util.Vector;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ClickInterface {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private Vector<Integer> listImage;
    private ViewPager viewPager;

    ConstraintLayout assetItem1;

    // semua recyclerview
    RecyclerView rv_peringkatAtas, rv_palingpopuler;
    Vector<AssetListItem> assetlistitem1, assetlistitem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        drawerLayout = findViewById(R.id.rv_palingpopuler);
//        navigationView = findViewById(R.id.nav_view);
//        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

//        Menu menu = navigationView.getMenu();
//        menu.findItem(R.id.home_menu).setVisible(false);

//        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        navigationView.setNavigationItemSelectedListener(this);

//        navigationView.setCheckedItem(R.id.home_menu);



        viewPager = findViewById(R.id.mainViewPager);
        listImage = new Vector<>();
        listImage.add(R.drawable.carousel1);
        listImage.add(R.drawable.carousel2);
        listImage.add(R.drawable.carousel3);

        ItemSliderAdapter adapter = new ItemSliderAdapter(listImage, this);
        viewPager.setAdapter(adapter);

        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);

        getSemuaItem();
    }

    @Override
    public void onClick(int position) {

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

    public void getSemuaItem () {
        // Get semua assetItem. maaf gapake for loop
        rv_peringkatAtas = (RecyclerView) findViewById(R.id.rv_peringkatatas);
        rv_palingpopuler = (RecyclerView) findViewById(R.id.rv_paling_populer);

        assetlistitem1 = new Vector<>();
        assetlistitem2 = new Vector<>();

        assetlistitem1.add(new AssetListItem(
                "Wizard duck",
                "A Toon Styled 3D Asset",
                "$12.99",
                R.drawable.wizardduck,
                "Duck who mastered the art of magic. " +
                        "This asset comes with 2 different " +
                        "texture variants and sample animations"));

        assetlistitem1.add(new AssetListItem(
                "Angry Man",
                "A Cartoon Styled 3D Model",
                "$9.99",
                R.drawable.angryman,
                "An Angry man 3D Asset. Beware of this man. " +
                        "An asset with single texture variant. " +
                        "Fully Rigged."));

        assetlistitem1.add(new AssetListItem(
                "Lotus Evora S",
                "A Realistic Styled 3D Asset",
                "$15.99",
                R.drawable.evoras,
                "A 3D asset. Sportscar model. Comes with " +
                        "sample animations and fully rigged."));

        assetlistitem2.add(new AssetListItem(
                "Wizard duck",
                "A Toon Styled 3D Asset",
                "$12.99",
                R.drawable.wizardduck,
                "Duck who mastered the art of magic. " +
                        "This asset comes with 2 different " +
                        "texture variants and sample animations"));

        assetlistitem2.add(new AssetListItem(
                "Angry Man",
                "A Cartoon Styled 3D Model",
                "$9.99",
                R.drawable.angryman,
                "An Angry man 3D Asset. Beware of this man. " +
                        "An asset with single texture variant. " +
                        "Fully Rigged."));

        AssetMiniAdapter adapter1 = new AssetMiniAdapter(this, this);
        adapter1.setAssetListItem(assetlistitem1);

        AssetMiniAdapter adapter2 = new AssetMiniAdapter(this, this);
        adapter2.setAssetListItem(assetlistitem2);


        rv_peringkatAtas.setAdapter(adapter1);
        rv_peringkatAtas.setLayoutManager(new GridLayoutManager(this, 3));
        rv_palingpopuler.setAdapter(adapter2);
        rv_palingpopuler.setLayoutManager(new GridLayoutManager(this, 2));

    }

}