package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItemDetailsPage extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_page);
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