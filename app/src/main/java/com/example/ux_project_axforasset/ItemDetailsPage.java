package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsPage extends AppCompatActivity {

    Button button;
    TextView atv_assetname, atv_price, atv_shortdesc, atv_longdesc;
    ImageView aiv_assetimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_page);

        // Textview dan Imageview assignment
        atv_assetname = (TextView) findViewById(R.id.tv_assetName);
        atv_price = (TextView) findViewById(R.id.tv_assetPrice);
        atv_shortdesc = (TextView) findViewById(R.id.tv_shortdesc);
        atv_longdesc = (TextView) findViewById(R.id.tv_longdesc);
        aiv_assetimage = (ImageView) findViewById(R.id.iv_assetImage);

        Intent intent = getIntent();

        // ambil data dari intent.
        String mAssetName = intent.getStringExtra(ItemPage.extraName);
        String mAssetShortDesc = intent.getStringExtra(ItemPage.extraShortDesc);
        String mAssetLongDesc = intent.getStringExtra(ItemPage.extraLongDesc);
        String mAssetPrice = intent.getStringExtra(ItemPage.extraPrice);
        int mImageData = intent.getIntExtra(ItemPage.extraImage,  0);

        // Ubah text dan gambar dari intent.
        atv_assetname.setText(mAssetName);
        atv_shortdesc.setText(mAssetShortDesc);
        atv_longdesc.setText(mAssetLongDesc);
        atv_price.setText(mAssetPrice);
        aiv_assetimage.setImageResource(mImageData);



        button = (Button) findViewById(R.id.TOMBOLUJI);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonTes();
            }
        });


    }

    public void backButtonTes() {
        Intent prevPage = new Intent(this, ItemPage.class);
        startActivity(prevPage);
    }


}