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
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class HomepageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ClickInterface, ClickInterface2 {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private Vector<Integer> listImage;
    private ViewPager viewPager;

<<<<<<< HEAD
<<<<<<< HEAD
=======
    //TEST GLOBALVAR
    String GLOBAL_USERNAME;
>>>>>>> c9bfe81 (Checkpoint apalah2)
    ConstraintLayout assetItem1;

    // semua recyclerview
<<<<<<< HEAD
    RecyclerView rv_peringkatAtas, rv_palingpopuler;
    Vector<AssetListItem> assetlistitem1, assetlistitem2;
=======
    //TEST GLOBVAR
    String GLOBAL_USERNAME;
>>>>>>> f60b608 (global var aman(harusnya))
=======
    RecyclerView rv_peringkatAtas, rv_palingpopuler, rv_rekomendasi;
    Vector<AssetListItem> assetlistitem1, assetlistitem2, assetlistitem3;
>>>>>>> cb02473 (Home tambahan asset yang dapat di klik.)



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

<<<<<<< HEAD
<<<<<<< HEAD
        drawerLayout = findViewById(R.id.rv_palingpopuler);
//        navigationView = findViewById(R.id.nav_view);
//        toolbar = findViewById(R.id.toolbar);
=======
        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        //MENU BAR
=======
        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        //MENU BAR

>>>>>>> c9bfe81 (Checkpoint apalah2)
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
>>>>>>> f60b608 (global var aman(harusnya))

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

<<<<<<< HEAD

=======
>>>>>>> c9bfe81 (Checkpoint apalah2)
        //CAROUSEL
        viewPager = findViewById(R.id.mainViewPager);
        listImage = new Vector<>();
        listImage.add(R.drawable.carousel1);
        listImage.add(R.drawable.carousel2);
        listImage.add(R.drawable.carousel3);

        ItemSliderAdapter adapter = new ItemSliderAdapter(listImage, this);
        viewPager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new The_slide_timer(),2000,3000);

        getSemuaItem();
        moreitemsOnClick();
        navBarTnC();
    }

    @Override
    public void onClick(int position) {

    }

    @Override
    public void onClick(int position, int position2) {
        viewItemDetails(position, position2);
    }

    public void viewItemDetails(int position, int position2) {
        int x = position;

        Vector<AssetListItem> assetlistitem = null;
        if(position2 == 1) {
            assetlistitem = assetlistitem1;
        } else if (position2 == 2) {
            assetlistitem = assetlistitem2;
        } else if (position2 == 3) {
            assetlistitem = assetlistitem3;
        }

        String mAssetTitle = (String) assetlistitem.get(x).getAssetName();
        String mAssetShortDesc = (String) assetlistitem.get(x).getAssetShortDesc();
        String mAssetLongDesc = (String) assetlistitem.get(x).getAssetLongDesc();
        String mAssetPrice = (String) assetlistitem.get(x).getAssetPrice();
        int mAssetImage = assetlistitem.get(x).getAssetImage();

        Intent intentItemDetail = new Intent(this, ItemDetailsActivity.class);
        intentItemDetail.putExtra(ItemActivity.extraName, mAssetTitle);
        intentItemDetail.putExtra(ItemActivity.extraShortDesc, mAssetShortDesc);
        intentItemDetail.putExtra(ItemActivity.extraLongDesc, mAssetLongDesc);
        intentItemDetail.putExtra(ItemActivity.extraPrice, mAssetPrice);
        intentItemDetail.putExtra(ItemActivity.extraImage, mAssetImage);
        startActivity(intentItemDetail);
    }

    public class The_slide_timer extends TimerTask {
        @Override
        public void run() {

            HomepageActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()<listImage.size()-1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else
                        viewPager.setCurrentItem(0);
                }
            });
        }
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
            Intent intent = new Intent(HomepageActivity.this, ItemActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.profile_menu) {
            Intent intent = new Intent(HomepageActivity.this, ProfileActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.logout_menu) {
            Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer((GravityCompat.START));
        return true;
    }

    public void getSemuaItem () {
        // Get semua assetItem
        rv_peringkatAtas = (RecyclerView) findViewById(R.id.rv_peringkatatas);
        rv_palingpopuler = (RecyclerView) findViewById(R.id.rv_paling_populer);
        rv_rekomendasi = (RecyclerView) findViewById(R.id.rv_rekomendasi);

        assetlistitem1 = new Vector<>();
        assetlistitem2 = new Vector<>();
        assetlistitem3 = new Vector<>();

        assetlistitem1.add(new AssetListItem(
                "Crosshair",
                "A generic FPS crosshair asset.",
                "$3.69",
                R.drawable.target,
                "Crosshairs are commonly used in modern FPS games." +
                        "Crosshairs are used to guide players aiming direction"));

        assetlistitem1.add(new AssetListItem(
                "Foxie",
                "A Fox Symbol",
                "$0.99",
                R.drawable.fox,
                "A symbol of a fox. Minimalist"));

        assetlistitem1.add(new AssetListItem(
                "Peace Sign",
                "Peace Sign Icon",
                "$3.69",
                R.drawable.hand,
                "A peace hand 2D Gesture  for use in Unity, " +
                        "Unreal, and More."));

        assetlistitem2.add(new AssetListItem(
                "Genshin Impact",
                "Asset game terbaik.",
                "$6.69",
                R.drawable.carousel1,
                "Asset digunakan untuk memodifikasi game ini."));

        assetlistitem2.add(new AssetListItem(
                "Campfire",
                "A Campfire symbol, A high quality 2D icon image",
                "$6.99",
                R.drawable.campfire,
                "A cozy looking campfire icon for personal and commercial use."));

        assetlistitem3.add(new AssetListItem(
                "Crosshair",
                "A generic FPS crosshair asset.",
                "$3.69",
                R.drawable.target,
                "Crosshairs are commonly used in modern FPS games." +
                        "Crosshairs are used to guide players aiming direction"));

        assetlistitem3.add(new AssetListItem(
                "Foxie",
                "A Fox Symbol",
                "$0.99",
                R.drawable.fox,
                "A symbol of a fox. Minimalist"));

        assetlistitem3.add(new AssetListItem(
                "Peace Sign",
                "Peace Sign Icon",
                "$3.69",
                R.drawable.hand,
                "A peace hand 2D Gesture  for use in Unity, " +
                        "Unreal, and More."));

        assetlistitem3.add(new AssetListItem(
                "Hexaweb",
                "A Hexagonal Shape Icon",
                "$2.99",
                R.drawable.hexagon,
                "For commercial and personal use."));

        assetlistitem3.add(new AssetListItem(
                "Tribox",
                "A Tribox 2D Icon Asset",
                "$4.99",
                R.drawable.shapes,
                "A 2D Icon tribox asset."));

        assetlistitem3.add(new AssetListItem(
                "Backward",
                "A Backward 2D Icon.",
                "$1.99",
                R.drawable.backward,
                "A minimal style backward Icon."));

        assetlistitem3.add(new AssetListItem(
                "Bowtie",
                "A Bowtie Image Asset",
                "FREE",
                R.drawable.two_arrow,
                "A free asset. A bowtie 2D image asset."));

        assetlistitem3.add(new AssetListItem(
                "Glico",
                "A Custom made 2D Icon Asset",
                "$9.99",
                R.drawable.letter_g,
                "An Icon."));

        assetlistitem3.add(new AssetListItem(
                "Campfire",
                "A Campfire symbol, A high quality 2D icon image",
                "$6.99",
                R.drawable.campfire,
                "A cozy looking campfire icon for personal and commercial use."));


        AssetMiniAdapter adapter1 = new AssetMiniAdapter(this, this, 1);
        adapter1.setAssetListItem(assetlistitem1);

        AssetMiniAdapter adapter2 = new AssetMiniAdapter(this, this, 2);
        adapter2.setAssetListItem(assetlistitem2);

        AssetMiniAdapter adapter3 = new AssetMiniAdapter(this, this, 3);
        adapter3.setAssetListItem(assetlistitem3);


        rv_peringkatAtas.setAdapter(adapter1);
        rv_peringkatAtas.setLayoutManager(new GridLayoutManager(this, 3));
        rv_palingpopuler.setAdapter(adapter2);
        rv_palingpopuler.setLayoutManager(new GridLayoutManager(this, 2));
        rv_rekomendasi.setAdapter(adapter3);
        rv_rekomendasi.setLayoutManager(new GridLayoutManager(this, 3));

    }

    public void moreitemsOnClick() {
        TextView moreitemsTv = findViewById(R.id.moreitemsTv);

        moreitemsTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomepageActivity.this, ItemActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });
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
                Intent intent = new Intent(HomepageActivity.this, ItemActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(HomepageActivity.this, ItemActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });
    }
}