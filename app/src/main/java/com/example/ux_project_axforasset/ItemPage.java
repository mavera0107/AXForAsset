package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.Vector;

public class ItemPage extends AppCompatActivity implements ClickInterface{

    RecyclerView rv_assetlist;
    Vector<AssetListItem> assetlistitem;

    public void initialize() {
        rv_assetlist = findViewById(R.id.rvAssetListView);

        assetlistitem = new Vector<>();
        assetlistitem.add(new AssetListItem("Wizard duck", "A dangerous Duck", "50.000", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("John Wick 5", "John wick is back", "42.000", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("Crosshair", "2D Image Asset", "FREE", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("Crosshair", "2D Image Asset", "FREE", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("Crosshair", "2D Image Asset", "FREE", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("Crosshair", "2D Image Asset", "FREE", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("Crosshair", "2D Image Asset", "FREE", R.drawable.gaming));
        assetlistitem.add(new AssetListItem("Crosshair", "2D Image Asset", "FREE", R.drawable.gaming));

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
    }

    @Override
    public void onClick(int position) {
        // nanti ini buat buka konten gamenya.
        Toast.makeText(this, assetlistitem.get(position).getAssetName(), Toast.LENGTH_SHORT).show();
    }
}