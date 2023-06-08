package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Vector;

public class ItemPage extends AppCompatActivity implements ClickInterface{

    public static final String extraName = "com.example.ux_project_axforasset.ItemPage.extraName";
    public static final String extraShortDesc = "com.example.ux_project_axforasset.ItemPage.extraShortDesc";
    public static final String extraLongDesc = "com.example.ux_project_axforasset.ItemPage.extraLongDesc";
    public static final String extraPrice = "com.example.ux_project_axforasset.ItemPage.extraPrice";
    public static final String extraImage = "com.example.ux_project_axforasset.ItemPage.extraImage";
    RecyclerView rv_assetlist;
    Vector<AssetListItem> assetlistitem;

    public void initialize() {
        rv_assetlist = findViewById(R.id.rvAssetListView);

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
//        Toast.makeText(this, assetlistitem.get(position).getAssetName(), Toast.LENGTH_SHORT).show();
        viewItemDetails(position);
    }

    public void viewItemDetails(int position) {
        int x = position;

        String mAssetTitle = (String) assetlistitem.get(x).getAssetName();
        String mAssetShortDesc = (String) assetlistitem.get(x).getAssetShortDesc();
        String mAssetLongDesc = (String) assetlistitem.get(x).getAssetLongDesc();
        String mAssetPrice = (String) assetlistitem.get(x).getAssetPrice();
        int mAssetImage = assetlistitem.get(x).getAssetImage();
//        int mAssetImage = Integer.parseInt(assetlistitem.get(x).)

        Intent intentItemDetail = new Intent(this, ItemDetailsPage.class);
        intentItemDetail.putExtra(extraName, mAssetTitle);
        intentItemDetail.putExtra(extraShortDesc, mAssetShortDesc);
        intentItemDetail.putExtra(extraLongDesc, mAssetLongDesc);
        intentItemDetail.putExtra(extraPrice, mAssetPrice);
        intentItemDetail.putExtra(extraImage, mAssetImage);
        startActivity(intentItemDetail);
    }


}