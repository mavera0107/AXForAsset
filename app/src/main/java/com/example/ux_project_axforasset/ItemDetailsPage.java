package com.example.ux_project_axforasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailsPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button button;
    AppCompatButton buybutton;
    EditText emailinput;
    TextView atv_assetname, atv_price, atv_shortdesc, atv_longdesc;
    ImageView aiv_assetimage;
    Spinner paymentSpinner;
    int spinnerValue = 0;

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


        // Button initialize
        button = (Button) findViewById(R.id.TOMBOLUJI);

        // input initialize
        buybutton = (AppCompatButton) findViewById(R.id.btn_buybutton);
        emailinput = (EditText) findViewById(R.id.input_emailAddress);
        // Spinner Initialize
        paymentSpinner = (Spinner) findViewById(R.id.input_paymentspinner);
        ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter.createFromResource(this, R.array.payment_method_array_spinner, android.R.layout.simple_spinner_item);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        paymentSpinner.setAdapter(spinAdapter);
        paymentSpinner.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButtonTes();
            }
        });

        buybutton.setOnClickListener( e -> {
            String email = emailinput.getText().toString();
            // Spinnervalue udh disurus di function bawah2

            if(email.isEmpty()) {
                alertDialogue("Invalid Email", "Please enter your email.", 0);
            } else if (spinnerValue == 0) {
                alertDialogue("No Payment Method Selected", "Please select a payment method.", 0);
            } else {
                alertDialogue("Success", "You Did it!", 1);
            }

        });


    }

    public void backButtonTes() {
        Intent prevPage = new Intent(this, ItemPage.class);
        startActivity(prevPage);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerValue = (int) position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void alertDialogue(String err_name, String err_msg, int type) {
        DialogBoxFragment alertDialog = new DialogBoxFragment(err_name, err_msg, type);
        alertDialog.show(getSupportFragmentManager(), " ");
    }
}