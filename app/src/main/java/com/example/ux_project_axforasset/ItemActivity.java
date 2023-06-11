package com.example.ux_project_axforasset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ItemActivity extends AppCompatActivity implements ClickInterface, NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    String GLOBAL_USERNAME;
    public static final String extraName = "com.example.ux_project_axforasset.ItemPage.extraName";
    public static final String extraShortDesc = "com.example.ux_project_axforasset.ItemPage.extraShortDesc";
    public static final String extraLongDesc = "com.example.ux_project_axforasset.ItemPage.extraLongDesc";
    public static final String extraPrice = "com.example.ux_project_axforasset.ItemPage.extraPrice";
    public static final String extraImage = "com.example.ux_project_axforasset.ItemPage.extraImage";

    RecyclerView rv_assetlist;
    Vector<AssetListItem> assetlistitem;

    public void initialize() {
        rv_assetlist = findViewById(R.id.rvAssetListView);
        rv_assetlist.setLayoutManager(new GridLayoutManager(this, 2));
        List<String> data = new ArrayList<>();

        assetlistitem = new Vector<>();

        assetlistitem.add(new AssetListItem(
                "Wizard duck",
                "A Toon Styled 3D Asset",
                "$12.99",
                R.drawable.wizardduck,
                "Duck who mastered the art of magic. " +
                        "This asset comes with 2 different " +
                        "texture variants and sample animations"));

        assetlistitem.add(new AssetListItem(
                "Angry Man",
                "A Cartoon Styled 3D Model",
                "$9.99",
                R.drawable.angryman,
                "An Angry man 3D Asset. Beware of this man. " +
                        "An asset with single texture variant. " +
                        "Fully Rigged."));

        assetlistitem.add(new AssetListItem(
                "Lotus Evora S",
                "A Realistic Styled 3D Asset",
                "$15.99",
                R.drawable.evoras,
                "A 3D asset. Sportscar model. Comes with " +
                        "sample animations and fully rigged."));

        assetlistitem.add(new AssetListItem(
                "Grumpy Goat",
                "A realistic styled 3D Goat Model",
                "$4.99",
                R.drawable.grumpygoat,
                "A 3D Goat model, comes with 3 animations. " +
                        "For use in Unity. Very easy to use."));

        assetlistitem.add(new AssetListItem(
                "Wooden Mug",
                "A Cartoony Asset",
                "$6.99",
                R.drawable.woodenmug ,
                "Cartoon Styled 3D mug asset. " +
                        "A medieval/fantasy themed mugs. For use in Blender."));

        assetlistitem.add(new AssetListItem(
                "Crosshair",
                "A generic FPS crosshair asset",
                "$3.69",
                R.drawable.target ,
                "Crosshairs are commonly used in modern FPS games, crosshairs are used to guide players aiming direction."));

        assetlistitem.add(new AssetListItem(
                "Foxie",
                "A fox symbol",
                "$0.99",
                R.drawable.fox ,
                "A symbol of a Fox. Minimalist."));

        assetlistitem.add(new AssetListItem(
                "Peace Sign",
                "Peace Sign Icon",
                "$3.69",
                R.drawable.hand ,
                "A peace hand gesture 2D asset for use in Unity Unreal and more."));

        assetlistitem.add(new AssetListItem(
                "Hexaweb",
                "A hexagonal shape icon",
                "$2.99",
                R.drawable.hexagon ,
                "For personal and commercial purposes."));

        assetlistitem.add(new AssetListItem(
                "Tribox",
                "A tribox 2D icon asset.",
                "$4.99",
                R.drawable.shapes,
                ""));

        assetlistitem.add(new AssetListItem(
                "Backward",
                "A backward 2D icon",
                "$1.99",
                R.drawable.backward,
                "A minimal style backward icon"));

        assetlistitem.add(new AssetListItem(
                "Bowtie",
                "Bowtie image asset",
                "FREE",
                R.drawable.two_arrow,
                "A free asset. A bowtie 2D asset."));

        assetlistitem.add(new AssetListItem(
                "Glico",
                "A custom made icon asset",
                "$9.99",
                R.drawable.letter_g,
                ""));

        assetlistitem.add(new AssetListItem(
                "Campfire",
                "A campfire symbol have a high quality icon image",
                "$6.99",
                R.drawable.campfire,
                "A cozy looking campfire icon for personal and commercial use."));

        AssetListItemAdapter adapter = new AssetListItemAdapter(this, this);
        adapter.setAssetListItem(assetlistitem);


        rv_assetlist.setAdapter(adapter);
        rv_assetlist.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);
        initialize();
        GLOBAL_USERNAME = getIntent().getStringExtra("Username");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.items_menu).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.items_menu);
    }

    @Override
    public void onClick(int position) {
        // buat ganti konten asset details
        viewItemDetails(position);
    }

    public void viewItemDetails(int position) {
        int x = position;

        String mAssetTitle = (String) assetlistitem.get(x).getAssetName();
        String mAssetShortDesc = (String) assetlistitem.get(x).getAssetShortDesc();
        String mAssetLongDesc = (String) assetlistitem.get(x).getAssetLongDesc();
        String mAssetPrice = (String) assetlistitem.get(x).getAssetPrice();
        int mAssetImage = assetlistitem.get(x).getAssetImage();

        Intent intentItemDetail = new Intent(this, ItemDetailsActivity.class);
        intentItemDetail.putExtra(extraName, mAssetTitle);
        intentItemDetail.putExtra(extraShortDesc, mAssetShortDesc);
        intentItemDetail.putExtra(extraLongDesc, mAssetLongDesc);
        intentItemDetail.putExtra(extraPrice, mAssetPrice);
        intentItemDetail.putExtra(extraImage, mAssetImage);
        intentItemDetail.putExtra("Username", GLOBAL_USERNAME);
        startActivity(intentItemDetail);
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
            Intent intent = new Intent(ItemActivity.this, HomepageActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.profile_menu) {
            Intent intent = new Intent(ItemActivity.this, ProfileActivity.class);
            intent.putExtra("Username", GLOBAL_USERNAME);
            startActivity(intent);
        } else if (item.getItemId() == R.id.logout_menu) {
            Intent intent = new Intent(ItemActivity.this, LoginActivity.class);
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
                Intent intent = new Intent(ItemActivity.this, TermsActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(ItemActivity.this, ConditionActivity.class);
                intent.putExtra("Username", GLOBAL_USERNAME);
                startActivity(intent);
            }
        });
    }

}